package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
/* JADX WARN: Init of enum UBYTE can be incorrect */
/* JADX WARN: Init of enum USHORT can be incorrect */
/* JADX WARN: Init of enum UINT can be incorrect */
/* JADX WARN: Init of enum ULONG can be incorrect */
public enum UnsignedType {
    UBYTE(r1),
    USHORT(r2),
    UINT(r4),
    ULONG(r6);
    
    @NotNull
    public final ClassId a;
    @NotNull
    public final Name b;
    @NotNull
    public final ClassId c;

    /* access modifiers changed from: public */
    static {
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UByte"), "fromString(\"kotlin/UByte\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UShort"), "fromString(\"kotlin/UShort\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UInt"), "fromString(\"kotlin/UInt\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/ULong"), "fromString(\"kotlin/ULong\")");
    }

    /* access modifiers changed from: public */
    UnsignedType(ClassId classId) {
        this.a = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.b = shortClassName;
        this.c = new ClassId(classId.getPackageFqName(), Name.identifier(Intrinsics.stringPlus(shortClassName.asString(), "Array")));
    }

    @NotNull
    public final ClassId getArrayClassId() {
        return this.c;
    }

    @NotNull
    public final ClassId getClassId() {
        return this.a;
    }

    @NotNull
    public final Name getTypeName() {
        return this.b;
    }
}
