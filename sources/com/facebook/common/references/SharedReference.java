package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
@VisibleForTesting
public class SharedReference<T> {
    @GuardedBy("itself")
    public static final Map<Object, Integer> d = new IdentityHashMap();
    @GuardedBy("this")
    public T a;
    @GuardedBy("this")
    public int b = 1;
    public final ResourceReleaser<T> c;

    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.a = (T) Preconditions.checkNotNull(t);
        this.c = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
        if (!CloseableReference.useGc() || (!(t instanceof Bitmap) && !(t instanceof HasBitmap))) {
            Map<Object, Integer> map = d;
            synchronized (map) {
                Integer num = map.get(t);
                if (num == null) {
                    map.put(t, 1);
                } else {
                    map.put(t, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static String reportData() {
        return Objects.toStringHelper("SharedReference").add("live_objects_count", d.size()).toString();
    }

    public synchronized void addReference() {
        if (isValid(this)) {
            this.b++;
        } else {
            throw new NullReferenceException();
        }
    }

    public synchronized boolean addReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        addReference();
        return true;
    }

    public void deleteReference() {
        int i;
        T t;
        synchronized (this) {
            if (isValid(this)) {
                Preconditions.checkArgument(this.b > 0);
                i = this.b - 1;
                this.b = i;
            } else {
                throw new NullReferenceException();
            }
        }
        if (i == 0) {
            synchronized (this) {
                t = this.a;
                this.a = null;
            }
            this.c.release(t);
            Map<Object, Integer> map = d;
            synchronized (map) {
                Integer num = map.get(t);
                if (num == null) {
                    FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", t.getClass());
                } else if (num.intValue() == 1) {
                    map.remove(t);
                } else {
                    map.put(t, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }

    public synchronized boolean deleteReferenceIfValid() {
        if (!isValid()) {
            return false;
        }
        deleteReference();
        return true;
    }

    public synchronized T get() {
        return this.a;
    }

    public synchronized int getRefCountTestOnly() {
        return this.b;
    }

    public synchronized boolean isValid() {
        return this.b > 0;
    }

    public static boolean isValid(SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.isValid();
    }
}
