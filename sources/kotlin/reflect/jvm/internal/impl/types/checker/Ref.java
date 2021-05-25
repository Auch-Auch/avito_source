package kotlin.reflect.jvm.internal.impl.types.checker;

import org.jetbrains.annotations.Nullable;
public final class Ref<T> {
    @Nullable
    public T a;

    public Ref(@Nullable T t) {
        this.a = t;
    }

    @Nullable
    public final T getValue() {
        return this.a;
    }
}
