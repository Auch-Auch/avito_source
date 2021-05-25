package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
public final class Option<T> {
    public static final CacheKeyUpdater<Object> e = new a();
    public final T a;
    public final CacheKeyUpdater<T> b;
    public final String c;
    public volatile byte[] d;

    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public class a implements CacheKeyUpdater<Object> {
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    public Option(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        this.c = Preconditions.checkNotEmpty(str);
        this.a = t;
        this.b = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, null, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str) {
        return new Option<>(str, null, e);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.c.equals(((Option) obj).c);
        }
        return false;
    }

    @Nullable
    public T getDefaultValue() {
        return this.a;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Option{key='");
        L.append(this.c);
        L.append('\'');
        L.append('}');
        return L.toString();
    }

    public void update(@NonNull T t, @NonNull MessageDigest messageDigest) {
        CacheKeyUpdater<T> cacheKeyUpdater = this.b;
        if (this.d == null) {
            this.d = this.c.getBytes(Key.CHARSET);
        }
        cacheKeyUpdater.update(this.d, t, messageDigest);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, e);
    }
}
