package t6.w.f.a.m.j.k;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
public final class a {
    @NotNull
    public final TypeParameterDescriptor a;
    @NotNull
    public final KotlinType b;
    @NotNull
    public final KotlinType c;

    public a(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(kotlinType, "inProjection");
        Intrinsics.checkNotNullParameter(kotlinType2, "outProjection");
        this.a = typeParameterDescriptor;
        this.b = kotlinType;
        this.c = kotlinType2;
    }
}
