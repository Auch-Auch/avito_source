package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class StagingArea {
    @GuardedBy("this")
    public Map<CacheKey, EncodedImage> a = new HashMap();

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    public final synchronized void a() {
        FLog.v(StagingArea.class, "Count = %d", Integer.valueOf(this.a.size()));
    }

    public void clearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.a.values());
            this.a.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        if (!this.a.containsKey(cacheKey)) {
            return false;
        }
        EncodedImage encodedImage = this.a.get(cacheKey);
        synchronized (encodedImage) {
            if (EncodedImage.isValid(encodedImage)) {
                return true;
            }
            this.a.remove(cacheKey);
            FLog.w(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
            return false;
        }
    }

    @Nullable
    public synchronized EncodedImage get(CacheKey cacheKey) {
        EncodedImage cloneOrNull;
        Preconditions.checkNotNull(cacheKey);
        EncodedImage encodedImage = this.a.get(cacheKey);
        if (encodedImage != null) {
            synchronized (encodedImage) {
                if (!EncodedImage.isValid(encodedImage)) {
                    this.a.remove(cacheKey);
                    FLog.w(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            }
            encodedImage = cloneOrNull;
        }
        return encodedImage;
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage.closeSafely(this.a.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
        a();
    }

    public boolean remove(CacheKey cacheKey) {
        EncodedImage remove;
        Preconditions.checkNotNull(cacheKey);
        synchronized (this) {
            remove = this.a.remove(cacheKey);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.isValid();
        } finally {
            remove.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkNotNull(encodedImage);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        EncodedImage encodedImage2 = this.a.get(cacheKey);
        if (encodedImage2 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
        CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
        if (!(byteBufferRef == null || byteBufferRef2 == null)) {
            try {
                if (byteBufferRef.get() == byteBufferRef2.get()) {
                    this.a.remove(cacheKey);
                    CloseableReference.closeSafely(byteBufferRef2);
                    CloseableReference.closeSafely(byteBufferRef);
                    EncodedImage.closeSafely(encodedImage2);
                    a();
                    return true;
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely(byteBufferRef2);
                CloseableReference.closeSafely(byteBufferRef);
                EncodedImage.closeSafely(encodedImage2);
                throw th;
            }
        }
        CloseableReference.closeSafely(byteBufferRef2);
        CloseableReference.closeSafely(byteBufferRef);
        EncodedImage.closeSafely(encodedImage2);
        return false;
    }
}
