package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ClassLiteralValue {
    @NotNull
    public final ClassId a;
    public final int b;

    public ClassLiteralValue(@NotNull ClassId classId, int i) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.a = classId;
        this.b = i;
    }

    @NotNull
    public final ClassId component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics.areEqual(this.a, classLiteralValue.a) && this.b == classLiteralValue.b;
    }

    public final int getArrayNestedness() {
        return this.b;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.a;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int arrayNestedness = getArrayNestedness();
        for (int i = 0; i < arrayNestedness; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(getClassId());
        int arrayNestedness2 = getArrayNestedness();
        for (int i2 = 0; i2 < arrayNestedness2; i2++) {
            sb.append(">");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
