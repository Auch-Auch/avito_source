package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class JavaTypeAttributes {
    @NotNull
    public final TypeUsage a;
    @NotNull
    public final JavaTypeFlexibility b;
    public final boolean c;
    @Nullable
    public final TypeParameterDescriptor d;

    public JavaTypeAttributes(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.a = typeUsage;
        this.b = javaTypeFlexibility;
        this.c = z;
        this.d = typeParameterDescriptor;
    }

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.a;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.b;
        }
        if ((i & 4) != 0) {
            z = javaTypeAttributes.c;
        }
        if ((i & 8) != 0) {
            typeParameterDescriptor = javaTypeAttributes.d;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    @NotNull
    public final JavaTypeAttributes copy(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.a == javaTypeAttributes.a && this.b == javaTypeAttributes.b && this.c == javaTypeAttributes.c && Intrinsics.areEqual(this.d, javaTypeAttributes.d);
    }

    @NotNull
    public final JavaTypeFlexibility getFlexibility() {
        return this.b;
    }

    @NotNull
    public final TypeUsage getHowThisTypeIsUsed() {
        return this.a;
    }

    @Nullable
    public final TypeParameterDescriptor getUpperBoundOfTypeParameter() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = (hashCode + i) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.d;
        return i4 + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("JavaTypeAttributes(howThisTypeIsUsed=");
        L.append(this.a);
        L.append(", flexibility=");
        L.append(this.b);
        L.append(", isForAnnotationParameter=");
        L.append(this.c);
        L.append(", upperBoundOfTypeParameter=");
        L.append(this.d);
        L.append(')');
        return L.toString();
    }

    @NotNull
    public final JavaTypeAttributes withFlexibility(@NotNull JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, null, javaTypeFlexibility, false, null, 13, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, j jVar) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : typeParameterDescriptor);
    }
}
