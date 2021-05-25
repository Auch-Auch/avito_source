package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;
public class ResourceEncoderRegistry {
    public final List<a<?>> a = new ArrayList();

    public static final class a<T> {
        public final Class<T> a;
        public final ResourceEncoder<T> b;

        public a(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.a = cls;
            this.b = resourceEncoder;
        }
    }

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.a.add(new a<>(cls, resourceEncoder));
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: com.bumptech.glide.load.ResourceEncoder<T>, com.bumptech.glide.load.ResourceEncoder<Z> */
    @Nullable
    public synchronized <Z> ResourceEncoder<Z> get(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.a.get(i);
            if (aVar.a.isAssignableFrom(cls)) {
                return (ResourceEncoder<T>) aVar.b;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.a.add(0, new a<>(cls, resourceEncoder));
    }
}
