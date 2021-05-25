package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;
public class EncoderRegistry {
    public final List<a<?>> a = new ArrayList();

    public static final class a<T> {
        public final Class<T> a;
        public final Encoder<T> b;

        public a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.a = cls;
            this.b = encoder;
        }
    }

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.a.add(new a<>(cls, encoder));
    }

    @Nullable
    public synchronized <T> Encoder<T> getEncoder(@NonNull Class<T> cls) {
        for (a<?> aVar : this.a) {
            if (aVar.a.isAssignableFrom(cls)) {
                return aVar.b;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.a.add(0, new a<>(cls, encoder));
    }
}
