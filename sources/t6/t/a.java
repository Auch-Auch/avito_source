package t6.t;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a<T> implements ReadWriteProperty<Object, T> {
    public T a;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    @NotNull
    public T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = this.a;
        if (t != null) {
            return t;
        }
        StringBuilder L = a2.b.a.a.a.L("Property ");
        L.append(kProperty.getName());
        L.append(" should be initialized before get.");
        throw new IllegalStateException(L.toString());
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, @NotNull T t) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        this.a = t;
    }
}
