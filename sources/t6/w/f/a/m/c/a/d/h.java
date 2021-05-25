package t6.w.f.a.m.c.a.d;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class h {
    @NotNull
    public final KotlinType a;
    @Nullable
    public final JavaDefaultQualifiers b;
    @Nullable
    public final TypeParameterDescriptor c;
    public final boolean d;

    public h(@NotNull KotlinType kotlinType, @Nullable JavaDefaultQualifiers javaDefaultQualifiers, @Nullable TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.b = javaDefaultQualifiers;
        this.c = typeParameterDescriptor;
        this.d = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c) && this.d == hVar.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        JavaDefaultQualifiers javaDefaultQualifiers = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (javaDefaultQualifiers == null ? 0 : javaDefaultQualifiers.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.c;
        if (typeParameterDescriptor != null) {
            i = typeParameterDescriptor.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TypeAndDefaultQualifiers(type=");
        L.append(this.a);
        L.append(", defaultQualifiers=");
        L.append(this.b);
        L.append(", typeParameterForArgument=");
        L.append(this.c);
        L.append(", isFromStarProjection=");
        return a.A(L, this.d, ')');
    }
}
