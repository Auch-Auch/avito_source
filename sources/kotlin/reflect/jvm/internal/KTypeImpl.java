package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.e;
import t6.r.a.j;
import t6.w.f.a.h;
import t6.w.f.a.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u000102¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR#\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8V@\u0016X\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\u001f\u0010)\u001a\u0004\u0018\u00010\u00138V@\u0016X\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010$R\u0018\u0010/\u001a\u0004\u0018\u00010\u00178V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "", "nullable", "makeNullableAsSpecified$kotlin_reflection", "(Z)Lkotlin/reflect/jvm/internal/KTypeImpl;", "makeNullableAsSpecified", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "Lkotlin/reflect/KClassifier;", AuthSource.SEND_ABUSE, "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "computeJavaType", "d", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "", "Lkotlin/reflect/KTypeProjection;", "c", "getArguments", "()Ljava/util/List;", "arguments", AuthSource.BOOKING_ORDER, "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier", "", "getAnnotations", "annotations", "getJavaType", "()Ljava/lang/reflect/Type;", "javaType", "isMarkedNullable", "()Z", "Lkotlin/Function0;", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KTypeImpl implements KTypeBase {
    public static final /* synthetic */ KProperty[] e = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    public final ReflectProperties.LazySoftVal<Type> a;
    @Nullable
    public final ReflectProperties.LazySoftVal b;
    @NotNull
    public final ReflectProperties.LazySoftVal c;
    @NotNull
    public final KotlinType d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Variance.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<List<? extends KTypeProjection>> {
        public final /* synthetic */ KTypeImpl a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KTypeImpl kTypeImpl, Function0 function0) {
            super(0);
            this.a = kTypeImpl;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends KTypeProjection> invoke() {
            KTypeProjection kTypeProjection;
            List<TypeProjection> arguments = this.a.getType().getArguments();
            if (arguments.isEmpty()) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Lazy lazy = c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new i(this));
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arguments, 10));
            int i = 0;
            for (T t : arguments) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (t2.isStarProjection()) {
                    kTypeProjection = KTypeProjection.Companion.getSTAR();
                } else {
                    KotlinType type = t2.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                    h hVar = null;
                    if (this.b != null) {
                        hVar = new h(i, this, lazy, null);
                    }
                    KTypeImpl kTypeImpl = new KTypeImpl(type, hVar);
                    int ordinal = t2.getProjectionKind().ordinal();
                    if (ordinal == 0) {
                        kTypeProjection = KTypeProjection.Companion.invariant(kTypeImpl);
                    } else if (ordinal == 1) {
                        kTypeProjection = KTypeProjection.Companion.contravariant(kTypeImpl);
                    } else if (ordinal == 2) {
                        kTypeProjection = KTypeProjection.Companion.covariant(kTypeImpl);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                arrayList.add(kTypeProjection);
                i = i2;
            }
            return arrayList;
        }
    }

    public static final class b extends Lambda implements Function0<KClassifier> {
        public final /* synthetic */ KTypeImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KTypeImpl kTypeImpl) {
            super(0);
            this.a = kTypeImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KClassifier invoke() {
            KTypeImpl kTypeImpl = this.a;
            return kTypeImpl.a(kTypeImpl.getType());
        }
    }

    public KTypeImpl(@NotNull KotlinType kotlinType, @Nullable Function0<? extends Type> function0) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.d = kotlinType;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = (ReflectProperties.LazySoftVal) (!(function0 instanceof ReflectProperties.LazySoftVal) ? null : function0);
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (function0 != null) {
            lazySoftVal = ReflectProperties.lazySoft(function0);
        }
        this.a = lazySoftVal;
        this.b = ReflectProperties.lazySoft(new b(this));
        this.c = ReflectProperties.lazySoft(new a(this, function0));
    }

    public final KClassifier a(KotlinType kotlinType) {
        KotlinType type;
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) declarationDescriptor);
            if (javaClass == null) {
                return null;
            }
            if (javaClass.isArray()) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) kotlinType.getArguments());
                if (typeProjection == null || (type = typeProjection.getType()) == null) {
                    return new KClassImpl(javaClass);
                }
                Intrinsics.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
                KClassifier a3 = a(type);
                if (a3 != null) {
                    return new KClassImpl(ReflectClassUtilKt.createArrayType(JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(a3))));
                }
                throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
            } else if (TypeUtils.isNullableType(kotlinType)) {
                return new KClassImpl(javaClass);
            } else {
                Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new KClassImpl(javaClass);
            }
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) declarationDescriptor);
        } else {
            if (!(declarationDescriptor instanceof TypeAliasDescriptor)) {
                return null;
            }
            throw new NotImplementedError(a2.b.a.a.a.c3("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KTypeImpl) && Intrinsics.areEqual(this.d, ((KTypeImpl) obj).d);
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.d);
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return (List) this.c.getValue(this, e[1]);
    }

    @Override // kotlin.reflect.KType
    @Nullable
    public KClassifier getClassifier() {
        return (KClassifier) this.b.getValue(this, e[0]);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    @Nullable
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.a;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    @NotNull
    public final KotlinType getType() {
        return this.d;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.d.isMarkedNullable();
    }

    @NotNull
    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean z) {
        if (!FlexibleTypesKt.isFlexible(this.d) && isMarkedNullable() == z) {
            return this;
        }
        KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.d, z);
        Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "TypeUtils.makeNullableAsSpecified(type, nullable)");
        return new KTypeImpl(makeNullableAsSpecified, this.a);
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, j jVar) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }
}
