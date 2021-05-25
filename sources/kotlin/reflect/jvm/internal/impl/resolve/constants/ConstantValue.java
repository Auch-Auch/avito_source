package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public abstract class ConstantValue<T> {
    public final T a;

    public ConstantValue(T t) {
        this.a = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            T value = getValue();
            Object obj2 = null;
            ConstantValue constantValue = obj instanceof ConstantValue ? (ConstantValue) obj : null;
            if (constantValue != null) {
                obj2 = constantValue.getValue();
            }
            if (!Intrinsics.areEqual(value, obj2)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public abstract KotlinType getType(@NotNull ModuleDescriptor moduleDescriptor);

    public T getValue() {
        return this.a;
    }

    public int hashCode() {
        T value = getValue();
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(getValue());
    }
}
