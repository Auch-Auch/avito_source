package kotlin.reflect;

import a2.b.a.a.a;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@ExperimentalStdlibApi
public final class WildcardTypeImpl implements WildcardType, Type {
    @NotNull
    public static final WildcardTypeImpl c = new WildcardTypeImpl(null, null);
    @NotNull
    public static final Companion d = new Companion(null);
    public final Type a;
    public final Type b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "Lkotlin/reflect/WildcardTypeImpl;", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.c;
        }

        public Companion(j jVar) {
        }
    }

    public WildcardTypeImpl(@Nullable Type type, @Nullable Type type2) {
        this.a = type;
        this.b = type2;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getLowerBounds() {
        Type type = this.b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    @NotNull
    public String getTypeName() {
        if (this.b != null) {
            StringBuilder L = a.L("? super ");
            L.append(TypesJVMKt.access$typeToString(this.b));
            return L.toString();
        }
        Type type = this.a;
        if (type == null || !(!Intrinsics.areEqual(type, Object.class))) {
            return "?";
        }
        StringBuilder L2 = a.L("? extends ");
        L2.append(TypesJVMKt.access$typeToString(this.a));
        return L2.toString();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000b: APUT  (r0v1 java.lang.reflect.Type[]), (0 ??[int, short, byte, char]), (r1v1 java.lang.reflect.Type) */
    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getTypeName();
    }
}
