package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.w.f.a.m.c.a.d.c;
public final class JavaTypeEnhancement {
    @NotNull
    public final JavaResolverSettings a;

    public static class a {
        @NotNull
        public final KotlinType a;
        public final int b;
        public final boolean c;

        public a(@NotNull KotlinType kotlinType, int i, boolean z) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.a = kotlinType;
            this.b = i;
            this.c = z;
        }

        @NotNull
        public KotlinType a() {
            return this.a;
        }
    }

    public static final class b extends a {
        @NotNull
        public final SimpleType d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(@NotNull SimpleType simpleType, int i, boolean z) {
            super(simpleType, i, z);
            Intrinsics.checkNotNullParameter(simpleType, "type");
            this.d = simpleType;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.a
        public KotlinType a() {
            return this.d;
        }
    }

    public JavaTypeEnhancement(@NotNull JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.a = javaResolverSettings;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x017c */
    public final b a(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z) {
        TypeProjection typeProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition) && simpleType.getArguments().isEmpty()) {
            return new b(simpleType, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().mo425getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(simpleType, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i));
        c access$enhanceMutability = TypeEnhancementKt.access$enhanceMutability(declarationDescriptor, invoke, typeComponentPosition);
        T t = access$enhanceMutability.a;
        Annotations annotations = access$enhanceMutability.b;
        TypeConstructor typeConstructor = t.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z2 = annotations != null;
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (T t2 : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            if (t3.isStarProjection()) {
                int i5 = i2 + 1;
                if (function12.invoke(Integer.valueOf(i2)).getNullability() != NullabilityQualifier.NOT_NULL || z) {
                    typeProjection = TypeUtils.makeStarProjection(t.getTypeConstructor().getParameters().get(i3));
                    Intrinsics.checkNotNullExpressionValue(typeProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(t3.getType().unwrap());
                    Variance projectionKind = t3.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    typeProjection = TypeUtilsKt.createProjection(makeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
                i2 = i5;
            } else {
                a b2 = b(t3.getType().unwrap(), function12, i2);
                z2 = z2 || b2.c;
                i2 += b2.b;
                KotlinType a3 = b2.a();
                Variance projectionKind2 = t3.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(a3, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            arrayList.add(typeProjection);
            function12 = function1;
            i3 = i4;
        }
        c access$getEnhancedNullability = TypeEnhancementKt.access$getEnhancedNullability(simpleType, invoke, typeComponentPosition);
        boolean booleanValue = access$getEnhancedNullability.a.booleanValue();
        Annotations annotations2 = access$getEnhancedNullability.b;
        int i6 = i2 - i;
        if (!(z2 || annotations2 != null)) {
            return new b(simpleType, i6, false);
        }
        boolean z3 = false;
        Annotations access$compositeAnnotationsOrSingle = TypeEnhancementKt.access$compositeAnnotationsOrSingle(CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Annotations[]{simpleType.getAnnotations(), annotations, annotations2}));
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(access$compositeAnnotationsOrSingle, typeConstructor, arrayList, booleanValue, null, 16, null);
        UnwrappedType unwrappedType = simpleType$default;
        if (invoke.isNotNullTypeParameter()) {
            if (this.a.getCorrectNullabilityForNotNullTypeParameter()) {
                unwrappedType = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType$default, true);
            } else {
                unwrappedType = new NotNullTypeParameter(simpleType$default);
            }
        }
        if (annotations2 != null && invoke.isNullabilityQualifierForWarning()) {
            z3 = true;
        }
        if (z3) {
            unwrappedType = TypeWithEnhancementKt.wrapEnhancement(simpleType, unwrappedType);
        }
        return new b((SimpleType) unwrappedType, i6, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.a b(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14) {
        /*
            r11 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r12)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$a r13 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$a
            r13.<init>(r12, r2, r1)
            return r13
        L_0x000e:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x0086
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r3 = r11
            r5 = r13
            r6 = r14
            r8 = r0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$b r10 = r3.a(r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$b r13 = r3.a(r4, r5, r6, r7, r8)
            int r14 = r10.b
            int r0 = r13.b
            boolean r14 = r10.c
            if (r14 != 0) goto L_0x003b
            boolean r14 = r13.c
            if (r14 == 0) goto L_0x003c
        L_0x003b:
            r1 = 1
        L_0x003c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r13.d
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.getEnhancement(r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.getEnhancement(r14)
            if (r14 != 0) goto L_0x004f
            if (r0 != 0) goto L_0x004e
            r14 = 0
            goto L_0x0060
        L_0x004e:
            r14 = r0
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            goto L_0x0060
        L_0x0052:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r14)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r0)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r14 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r14, r0)
        L_0x0060:
            if (r1 == 0) goto L_0x007e
            boolean r12 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            if (r12 == 0) goto L_0x0070
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r12 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r10.d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.d
            r12.<init>(r0, r13)
            goto L_0x007a
        L_0x0070:
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r12 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.d
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r13)
        L_0x007a:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r14)
        L_0x007e:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$a r13 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$a
            int r14 = r10.b
            r13.<init>(r12, r14, r1)
            goto L_0x0097
        L_0x0086:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x0098
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r6 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$b r13 = r1.a(r2, r3, r4, r5, r6)
        L_0x0097:
            return r13
        L_0x0098:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.b(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$a");
    }

    @Nullable
    public final KotlinType enhance(@NotNull KotlinType kotlinType, @NotNull Function1<? super Integer, JavaTypeQualifiers> function1) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        a b2 = b(kotlinType.unwrap(), function1, 0);
        KotlinType a3 = b2.a();
        if (b2.c) {
            return a3;
        }
        return null;
    }
}
