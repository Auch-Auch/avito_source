package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.n.y;
import t6.r.a.j;
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    @NotNull
    public final Name a;
    @NotNull
    public final Name b;
    @NotNull
    public final Lazy c;
    @NotNull
    public final Lazy d;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<FqName> {
        public final /* synthetic */ PrimitiveType a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PrimitiveType primitiveType) {
            super(0);
            this.a = primitiveType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FqName invoke() {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.a.getArrayTypeName());
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return child;
        }
    }

    public static final class b extends Lambda implements Function0<FqName> {
        public final /* synthetic */ PrimitiveType a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PrimitiveType primitiveType) {
            super(0);
            this.a = primitiveType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FqName invoke() {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(this.a.getTypeName());
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return child;
        }
    }

    /* access modifiers changed from: public */
    static {
        PrimitiveType primitiveType;
        PrimitiveType primitiveType2;
        PrimitiveType primitiveType3;
        PrimitiveType primitiveType4;
        PrimitiveType primitiveType5;
        PrimitiveType primitiveType6;
        PrimitiveType primitiveType7;
        NUMBER_TYPES = y.setOf((Object[]) new PrimitiveType[]{primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7});
    }

    /* access modifiers changed from: public */
    PrimitiveType(String str) {
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeName)");
        this.a = identifier;
        Name identifier2 = Name.identifier(Intrinsics.stringPlus(str, "Array"));
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"${typeName}Array\")");
        this.b = identifier2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.c = c.lazy(lazyThreadSafetyMode, (Function0) new b(this));
        this.d = c.lazy(lazyThreadSafetyMode, (Function0) new a(this));
    }

    @NotNull
    public final FqName getArrayTypeFqName() {
        return (FqName) this.d.getValue();
    }

    @NotNull
    public final Name getArrayTypeName() {
        return this.b;
    }

    @NotNull
    public final FqName getTypeFqName() {
        return (FqName) this.c.getValue();
    }

    @NotNull
    public final Name getTypeName() {
        return this.a;
    }
}
