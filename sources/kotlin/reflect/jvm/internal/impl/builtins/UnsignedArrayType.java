package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
/* JADX WARN: Init of enum UBYTEARRAY can be incorrect */
/* JADX WARN: Init of enum USHORTARRAY can be incorrect */
/* JADX WARN: Init of enum UINTARRAY can be incorrect */
/* JADX WARN: Init of enum ULONGARRAY can be incorrect */
public enum UnsignedArrayType {
    UBYTEARRAY(r1),
    USHORTARRAY(r2),
    UINTARRAY(r4),
    ULONGARRAY(r6);
    
    @NotNull
    public final ClassId a;
    @NotNull
    public final Name b;

    /* access modifiers changed from: public */
    static {
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UByteArray"), "fromString(\"kotlin/UByteArray\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UShortArray"), "fromString(\"kotlin/UShortArray\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UIntArray"), "fromString(\"kotlin/UIntArray\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/ULongArray"), "fromString(\"kotlin/ULongArray\")");
    }

    /* access modifiers changed from: public */
    UnsignedArrayType(ClassId classId) {
        this.a = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.b = shortClassName;
    }

    @NotNull
    public final Name getTypeName() {
        return this.b;
    }
}
