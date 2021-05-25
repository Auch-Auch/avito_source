package com.bumptech.glide.load;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
public final class Options implements Key {
    public final ArrayMap<Option<?>, Object> a = new CachedHashCodeArrayMap();

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.a.equals(((Options) obj).a);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull Option<T> option) {
        return this.a.containsKey(option) ? (T) this.a.get(option) : option.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.a.hashCode();
    }

    public void putAll(@NonNull Options options) {
        this.a.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.a);
    }

    @NonNull
    public <T> Options set(@NonNull Option<T> option, @NonNull T t) {
        this.a.put(option, t);
        return this;
    }

    public String toString() {
        StringBuilder L = a.L("Options{values=");
        L.append(this.a);
        L.append('}');
        return L.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.keyAt(i).update(this.a.valueAt(i), messageDigest);
        }
    }
}
