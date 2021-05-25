package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
public final class TypeAliasExpander {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final TypeAliasExpansionReportStrategy a;
    public final boolean b;

    public static final class Companion {
        public Companion() {
        }

        public static final void access$assertRecursionDepth(Companion companion, int i, TypeAliasDescriptor typeAliasDescriptor) {
            Objects.requireNonNull(companion);
            if (i > 100) {
                throw new AssertionError(Intrinsics.stringPlus("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }

        public final void checkBoundsInTypeAlias(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, @NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeSubstitutor typeSubstitutor) {
            Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
            Intrinsics.checkNotNullParameter(kotlinType, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(kotlinType2, "typeArgument");
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameterDescriptor");
            Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
            for (KotlinType kotlinType3 : typeParameterDescriptor.getUpperBounds()) {
                KotlinType safeSubstitute = typeSubstitutor.safeSubstitute(kotlinType3, Variance.INVARIANT);
                Intrinsics.checkNotNullExpressionValue(safeSubstitute, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType2, safeSubstitute)) {
                    typeAliasExpansionReportStrategy.boundsViolationInSubstitution(safeSubstitute, kotlinType, kotlinType2, typeParameterDescriptor);
                }
            }
        }

        public Companion(j jVar) {
        }
    }

    static {
        new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    }

    public TypeAliasExpander(@NotNull TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
        this.a = typeAliasExpansionReportStrategy;
        this.b = z;
    }

    public final void a(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((AnnotationDescriptor) it.next()).getFqName());
        }
        Iterator it2 = annotations2.iterator();
        while (it2.hasNext()) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) it2.next();
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.a.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    public final SimpleType b(SimpleType simpleType, Annotations annotations) {
        return KotlinTypeKt.isError(simpleType) ? simpleType : TypeSubstitutionKt.replace$default(simpleType, null, c(simpleType, annotations), 1, null);
    }

    public final Annotations c(KotlinType kotlinType, Annotations annotations) {
        if (KotlinTypeKt.isError(kotlinType)) {
            return kotlinType.getAnnotations();
        }
        return AnnotationsKt.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    public final SimpleType d(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection e = e(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i);
        KotlinType type = e.getType();
        Intrinsics.checkNotNullExpressionValue(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        e.getProjectionKind();
        a(asSimpleType.getAnnotations(), annotations);
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(b(asSimpleType, annotations), z);
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        if (!z2) {
            return makeNullableIfNeeded;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.getArguments(), z, MemberScope.Empty.INSTANCE));
    }

    public final TypeProjection e(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        Variance variance;
        KotlinType kotlinType;
        Variance variance2;
        Variance variance3;
        Companion.access$assertRecursionDepth(Companion, i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            UnwrappedType unwrap = typeProjection.getType().unwrap();
            if (DynamicTypesKt.isDynamic(unwrap)) {
                return typeProjection;
            }
            SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
            if (KotlinTypeKt.isError(asSimpleType) || !TypeUtilsKt.requiresTypeAliasExpansion(asSimpleType)) {
                return typeProjection;
            }
            TypeConstructor constructor = asSimpleType.getConstructor();
            ClassifierDescriptor declarationDescriptor = constructor.mo425getDeclarationDescriptor();
            constructor.getParameters().size();
            asSimpleType.getArguments().size();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                return typeProjection;
            }
            int i2 = 0;
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
                if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                    this.a.recursiveTypeAlias(typeAliasDescriptor);
                    return new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(Intrinsics.stringPlus("Recursive type alias: ", typeAliasDescriptor.getName())));
                }
                List<TypeProjection> arguments = asSimpleType.getArguments();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arguments, 10));
                for (TypeProjection typeProjection2 : arguments) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(e(typeProjection2, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                    i2 = i3;
                }
                SimpleType d = d(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i + 1, false);
                SimpleType f = f(asSimpleType, typeAliasExpansion, i);
                if (!DynamicTypesKt.isDynamic(d)) {
                    d = SpecialTypesKt.withAbbreviation(d, f);
                }
                return new TypeProjectionImpl(typeProjection.getProjectionKind(), d);
            }
            SimpleType f2 = f(asSimpleType, typeAliasExpansion, i);
            TypeSubstitutor create = TypeSubstitutor.create(f2);
            Intrinsics.checkNotNullExpressionValue(create, "create(substitutedType)");
            for (T t : f2.getArguments()) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (!t2.isStarProjection()) {
                    KotlinType type2 = t2.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "substitutedArgument.type");
                    if (!TypeUtilsKt.containsTypeAliasParameters(type2)) {
                        TypeProjection typeProjection3 = asSimpleType.getArguments().get(i2);
                        TypeParameterDescriptor typeParameterDescriptor2 = asSimpleType.getConstructor().getParameters().get(i2);
                        if (this.b) {
                            Companion companion = Companion;
                            TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.a;
                            KotlinType type3 = typeProjection3.getType();
                            Intrinsics.checkNotNullExpressionValue(type3, "unsubstitutedArgument.type");
                            KotlinType type4 = t2.getType();
                            Intrinsics.checkNotNullExpressionValue(type4, "substitutedArgument.type");
                            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor2, "typeParameter");
                            companion.checkBoundsInTypeAlias(typeAliasExpansionReportStrategy, type3, type4, typeParameterDescriptor2, create);
                        }
                    }
                }
                i2 = i4;
            }
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), f2);
        } else if (replacement.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection2;
        } else {
            UnwrappedType unwrap2 = replacement.getType().unwrap();
            Variance projectionKind = replacement.getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
            Variance projectionKind2 = typeProjection.getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
            if (!(projectionKind2 == projectionKind || projectionKind2 == (variance3 = Variance.INVARIANT))) {
                if (projectionKind == variance3) {
                    projectionKind = projectionKind2;
                } else {
                    this.a.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap2);
                }
            }
            if (typeParameterDescriptor == null) {
                variance = null;
            } else {
                variance = typeParameterDescriptor.getVariance();
            }
            if (variance == null) {
                variance = Variance.INVARIANT;
            }
            Intrinsics.checkNotNullExpressionValue(variance, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
            if (!(variance == projectionKind || variance == (variance2 = Variance.INVARIANT))) {
                if (projectionKind == variance2) {
                    projectionKind = variance2;
                } else {
                    this.a.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap2);
                }
            }
            a(type.getAnnotations(), unwrap2.getAnnotations());
            if (unwrap2 instanceof DynamicType) {
                DynamicType dynamicType = (DynamicType) unwrap2;
                kotlinType = dynamicType.replaceAnnotations(c(dynamicType, type.getAnnotations()));
            } else {
                SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(TypeSubstitutionKt.asSimpleType(unwrap2), type.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
                kotlinType = b(makeNullableIfNeeded, type.getAnnotations());
            }
            return new TypeProjectionImpl(projectionKind, kotlinType);
        }
    }

    @NotNull
    public final SimpleType expand(@NotNull TypeAliasExpansion typeAliasExpansion, @NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return d(typeAliasExpansion, annotations, false, 0, true);
    }

    public final SimpleType f(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = simpleType.getConstructor();
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (T t : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            TypeProjection e = e(t2, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!e.isStarProjection()) {
                e = new TypeProjectionImpl(e.getProjectionKind(), TypeUtils.makeNullableIfNeeded(e.getType(), t2.getType().isMarkedNullable()));
            }
            arrayList.add(e);
            i2 = i3;
        }
        return TypeSubstitutionKt.replace$default(simpleType, arrayList, null, 2, null);
    }
}
