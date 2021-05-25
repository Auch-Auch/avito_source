package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.w.f.a.m.j.i;
public class TypeSubstitutor {
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    @NotNull
    public final TypeSubstitution a;

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public enum b {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public TypeSubstitutor(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution != null) {
            this.a = typeSubstitution;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r13) {
        /*
        // Method dump skipped, instructions count: 634
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.a(int):void");
    }

    public static b b(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return b.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return b.IN_IN_OUT_POSITION;
        }
        return b.NO_CONFLICT;
    }

    public static String c(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!ExceptionUtilsKt.isProcessCanceledException(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull TypeProjection typeProjection) {
        if (variance == null) {
            a(33);
            throw null;
        } else if (typeProjection == null) {
            a(34);
            throw null;
        } else if (!typeProjection.isStarProjection()) {
            return combine(variance, typeProjection.getProjectionKind());
        } else {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 != null) {
                return variance2;
            }
            a(35);
            throw null;
        }
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution != null) {
            return new TypeSubstitutor(typeSubstitution);
        }
        a(0);
        throw null;
    }

    @NotNull
    public static TypeSubstitutor createChainedSubstitutor(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            a(2);
            throw null;
        } else if (typeSubstitution2 != null) {
            return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution, typeSubstitution2));
        } else {
            a(3);
            throw null;
        }
    }

    @NotNull
    public final TypeProjection d(@NotNull TypeProjection typeProjection, @Nullable TypeParameterDescriptor typeParameterDescriptor, int i) throws a {
        KotlinType kotlinType;
        KotlinType kotlinType2 = null;
        if (typeProjection != null) {
            TypeSubstitution typeSubstitution = this.a;
            if (i > 100) {
                StringBuilder L = a2.b.a.a.a.L("Recursion too deep. Most likely infinite loop while substituting ");
                L.append(c(typeProjection));
                L.append("; substitution: ");
                L.append(c(typeSubstitution));
                throw new IllegalStateException(L.toString());
            } else if (typeProjection.isStarProjection()) {
                return typeProjection;
            } else {
                KotlinType type = typeProjection.getType();
                if (type instanceof TypeWithEnhancement) {
                    TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
                    UnwrappedType origin = typeWithEnhancement.getOrigin();
                    KotlinType enhancement = typeWithEnhancement.getEnhancement();
                    TypeProjection d = d(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i + 1);
                    return new TypeProjectionImpl(d.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(d.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
                } else if (DynamicTypesKt.isDynamic(type) || (type.unwrap() instanceof RawType)) {
                    return typeProjection;
                } else {
                    TypeProjection typeProjection2 = this.a.get(type);
                    if (typeProjection2 == null) {
                        typeProjection2 = null;
                    } else if (type.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
                        TypeConstructor constructor = typeProjection2.getType().getConstructor();
                        if (constructor instanceof NewCapturedTypeConstructor) {
                            TypeProjection projection = ((NewCapturedTypeConstructor) constructor).getProjection();
                            Variance projectionKind = projection.getProjectionKind();
                            b b2 = b(typeProjection.getProjectionKind(), projectionKind);
                            b bVar = b.OUT_IN_IN_POSITION;
                            if (b2 == bVar) {
                                typeProjection2 = new TypeProjectionImpl(projection.getType());
                            } else if (typeParameterDescriptor != null && b(typeParameterDescriptor.getVariance(), projectionKind) == bVar) {
                                typeProjection2 = new TypeProjectionImpl(projection.getType());
                            }
                        }
                    }
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    if (typeProjection2 == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeVariable(type)) {
                        FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(type);
                        int i2 = i + 1;
                        TypeProjection d2 = d(new TypeProjectionImpl(projectionKind2, asFlexibleType.getLowerBound()), typeParameterDescriptor, i2);
                        TypeProjection d3 = d(new TypeProjectionImpl(projectionKind2, asFlexibleType.getUpperBound()), typeParameterDescriptor, i2);
                        Variance projectionKind3 = d2.getProjectionKind();
                        if (d2.getType() == asFlexibleType.getLowerBound() && d3.getType() == asFlexibleType.getUpperBound()) {
                            return typeProjection;
                        }
                        return new TypeProjectionImpl(projectionKind3, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(d2.getType()), TypeSubstitutionKt.asSimpleType(d3.getType())));
                    } else if (KotlinBuiltIns.isNothing(type) || KotlinTypeKt.isError(type)) {
                        return typeProjection;
                    } else {
                        if (typeProjection2 != null) {
                            b b3 = b(projectionKind2, typeProjection2.getProjectionKind());
                            if (!CapturedTypeConstructorKt.isCaptured(type)) {
                                int ordinal = b3.ordinal();
                                if (ordinal == 1) {
                                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                                }
                                if (ordinal == 2) {
                                    throw new a("Out-projection in in-position");
                                }
                            }
                            CustomTypeVariable customTypeVariable = TypeCapabilitiesKt.getCustomTypeVariable(type);
                            if (typeProjection2.isStarProjection()) {
                                return typeProjection2;
                            }
                            if (customTypeVariable != null) {
                                kotlinType = customTypeVariable.substitutionResult(typeProjection2.getType());
                            } else {
                                kotlinType = TypeUtils.makeNullableIfNeeded(typeProjection2.getType(), type.isMarkedNullable());
                            }
                            if (!type.getAnnotations().isEmpty()) {
                                Annotations filterAnnotations = this.a.filterAnnotations(type.getAnnotations());
                                if (filterAnnotations != null) {
                                    if (filterAnnotations.hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
                                        filterAnnotations = new FilteredAnnotations(filterAnnotations, new i());
                                    }
                                    kotlinType = TypeUtilsKt.replaceAnnotations(kotlinType, new CompositeAnnotations(kotlinType.getAnnotations(), filterAnnotations));
                                } else {
                                    a(31);
                                    throw null;
                                }
                            }
                            if (b3 == b.NO_CONFLICT) {
                                projectionKind2 = combine(projectionKind2, typeProjection2.getProjectionKind());
                            }
                            return new TypeProjectionImpl(projectionKind2, kotlinType);
                        }
                        KotlinType type2 = typeProjection.getType();
                        Variance projectionKind4 = typeProjection.getProjectionKind();
                        if (type2.getConstructor().mo425getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
                            return typeProjection;
                        }
                        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type2);
                        if (abbreviation != null) {
                            kotlinType2 = replaceWithNonApproximatingSubstitution().substitute(abbreviation, Variance.INVARIANT);
                        }
                        List<TypeParameterDescriptor> parameters = type2.getConstructor().getParameters();
                        List<TypeProjection> arguments = type2.getArguments();
                        ArrayList arrayList = new ArrayList(parameters.size());
                        boolean z = false;
                        for (int i3 = 0; i3 < parameters.size(); i3++) {
                            TypeParameterDescriptor typeParameterDescriptor2 = parameters.get(i3);
                            TypeProjection typeProjection3 = arguments.get(i3);
                            TypeProjection d4 = d(typeProjection3, typeParameterDescriptor2, i + 1);
                            int ordinal2 = b(typeParameterDescriptor2.getVariance(), d4.getProjectionKind()).ordinal();
                            if (ordinal2 == 0) {
                                Variance variance = typeParameterDescriptor2.getVariance();
                                Variance variance2 = Variance.INVARIANT;
                                if (variance != variance2 && !d4.isStarProjection()) {
                                    d4 = new TypeProjectionImpl(variance2, d4.getType());
                                }
                            } else if (ordinal2 == 1 || ordinal2 == 2) {
                                d4 = TypeUtils.makeStarProjection(typeParameterDescriptor2);
                            }
                            if (d4 != typeProjection3) {
                                z = true;
                            }
                            arrayList.add(d4);
                        }
                        if (z) {
                            arguments = arrayList;
                        }
                        KotlinType replace = TypeSubstitutionKt.replace(type2, arguments, this.a.filterAnnotations(type2.getAnnotations()));
                        if ((replace instanceof SimpleType) && (kotlinType2 instanceof SimpleType)) {
                            replace = SpecialTypesKt.withAbbreviation((SimpleType) replace, (SimpleType) kotlinType2);
                        }
                        return new TypeProjectionImpl(projectionKind4, replace);
                    }
                }
            }
        } else {
            a(17);
            throw null;
        }
    }

    @NotNull
    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.a;
        if (typeSubstitution != null) {
            return typeSubstitution;
        }
        a(7);
        throw null;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @NotNull
    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution typeSubstitution = this.a;
        return (!(typeSubstitution instanceof IndexedParametersSubstitution) || !typeSubstitution.approximateContravariantCapturedTypes()) ? this : new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.a).getParameters(), ((IndexedParametersSubstitution) this.a).getArguments(), false));
    }

    @NotNull
    public KotlinType safeSubstitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            a(8);
            throw null;
        } else if (variance == null) {
            a(9);
            throw null;
        } else if (!isEmpty()) {
            try {
                KotlinType type = d(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
                if (type != null) {
                    return type;
                }
                a(11);
                throw null;
            } catch (a e) {
                SimpleType createErrorType = ErrorUtils.createErrorType(e.getMessage());
                if (createErrorType != null) {
                    return createErrorType;
                }
                a(12);
                throw null;
            }
        } else if (kotlinType != null) {
            return kotlinType;
        } else {
            a(10);
            throw null;
        }
    }

    @Nullable
    public KotlinType substitute(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        if (kotlinType == null) {
            a(13);
            throw null;
        } else if (variance != null) {
            TypeProjection substitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
            if (substitute == null) {
                return null;
            }
            return substitute.getType();
        } else {
            a(14);
            throw null;
        }
    }

    @Nullable
    public TypeProjection substituteWithoutApproximation(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            a(16);
            throw null;
        } else if (isEmpty()) {
            return typeProjection;
        } else {
            try {
                return d(typeProjection, null, 0);
            } catch (a unused) {
                return null;
            }
        }
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return create(TypeConstructorSubstitution.create(kotlinType.getConstructor(), kotlinType.getArguments()));
        }
        a(5);
        throw null;
    }

    @NotNull
    public static Variance combine(@NotNull Variance variance, @NotNull Variance variance2) {
        if (variance == null) {
            a(36);
            throw null;
        } else if (variance2 != null) {
            Variance variance3 = Variance.INVARIANT;
            if (variance == variance3) {
                if (variance2 != null) {
                    return variance2;
                }
                a(38);
                throw null;
            } else if (variance2 == variance3) {
                if (variance != null) {
                    return variance;
                }
                a(39);
                throw null;
            } else if (variance != variance2) {
                throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
            } else if (variance2 != null) {
                return variance2;
            } else {
                a(40);
                throw null;
            }
        } else {
            a(37);
            throw null;
        }
    }

    @Nullable
    public TypeProjection substitute(@NotNull TypeProjection typeProjection) {
        if (typeProjection != null) {
            TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
            if (this.a.approximateCapturedTypes() || this.a.approximateContravariantCapturedTypes()) {
                return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substituteWithoutApproximation, this.a.approximateContravariantCapturedTypes());
            }
            return substituteWithoutApproximation;
        }
        a(15);
        throw null;
    }
}
