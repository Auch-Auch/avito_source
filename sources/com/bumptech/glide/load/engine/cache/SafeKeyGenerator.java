package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SafeKeyGenerator {
    public final LruCache<Key, String> a = new LruCache<>(1000);
    public final Pools.Pool<b> b = FactoryPools.threadSafe(10, new a(this));

    public class a implements FactoryPools.Factory<b> {
        public a(SafeKeyGenerator safeKeyGenerator) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final class b implements FactoryPools.Poolable {
        public final MessageDigest a;
        public final StateVerifier b = StateVerifier.newInstance();

        public b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @NonNull
        public StateVerifier getVerifier() {
            return this.b;
        }
    }

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.a) {
            str = this.a.get(key);
        }
        if (str == null) {
            b bVar = (b) Preconditions.checkNotNull(this.b.acquire());
            try {
                key.updateDiskCacheKey(bVar.a);
                str = Util.sha256BytesToHex(bVar.a.digest());
            } finally {
                this.b.release(bVar);
            }
        }
        synchronized (this.a) {
            this.a.put(key, str);
        }
        return str;
    }
}
