package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
public final class ValueParameterData {
    @NotNull
    public final KotlinType a;
    public final boolean b;

    public ValueParameterData(@NotNull KotlinType kotlinType, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.b = z;
    }

    public final boolean getHasDefaultValue() {
        return this.b;
    }

    @NotNull
    public final KotlinType getType() {
        return this.a;
    }
}
