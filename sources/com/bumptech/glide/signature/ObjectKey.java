package com.bumptech.glide.signature;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
public final class ObjectKey implements Key {
    public final Object a;

    public ObjectKey(@NonNull Object obj) {
        this.a = Preconditions.checkNotNull(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.a.equals(((ObjectKey) obj).a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return a.q(a.L("ObjectKey{object="), this.a, '}');
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.a.toString().getBytes(Key.CHARSET));
    }
}
