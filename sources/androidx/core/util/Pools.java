package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    public static class SimplePool<T> implements Pool<T> {
        public final Object[] a;
        public int b;

        public SimplePool(int i) {
            if (i > 0) {
                this.a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i = this.b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            int i;
            boolean z;
            int i2 = 0;
            while (true) {
                i = this.b;
                if (i2 >= i) {
                    z = false;
                    break;
                } else if (this.a[i2] == t) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                Object[] objArr = this.a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        public final Object c = new Object();

        public SynchronizedPool(int i) {
            super(i);
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.c) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            boolean release;
            synchronized (this.c) {
                release = super.release(t);
            }
            return release;
        }
    }
}
