package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class TypeUtils {
    public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");
    @NotNull
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    public static class SpecialType extends DelegatingSimpleType {
        public final String b;

        public SpecialType(String str) {
            this.b = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void a(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L_0x0009
                if (r9 == r0) goto L_0x0009
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto L_0x000b
            L_0x0009:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            L_0x000b:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L_0x0013
                if (r9 == r0) goto L_0x0013
                r5 = 3
                goto L_0x0014
            L_0x0013:
                r5 = 2
            L_0x0014:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L_0x0030
                if (r9 == r4) goto L_0x002b
                if (r9 == r3) goto L_0x0026
                if (r9 == r0) goto L_0x0030
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L_0x0032
            L_0x0026:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L_0x0032
            L_0x002b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L_0x0032
            L_0x0030:
                r5[r7] = r6
            L_0x0032:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L_0x003e
                if (r9 == r0) goto L_0x003b
                r5[r1] = r6
                goto L_0x0043
            L_0x003b:
                r5[r1] = r7
                goto L_0x0043
            L_0x003e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L_0x0043:
                if (r9 == r1) goto L_0x0057
                if (r9 == r4) goto L_0x0053
                if (r9 == r3) goto L_0x0050
                if (r9 == r0) goto L_0x0057
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L_0x0057
            L_0x0050:
                r5[r4] = r7
                goto L_0x0057
            L_0x0053:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L_0x0057:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L_0x0065
                if (r9 == r0) goto L_0x0065
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L_0x006a
            L_0x0065:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L_0x006a:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        @NotNull
        public SimpleType getDelegate() {
            throw new IllegalStateException(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        @NotNull
        /* renamed from: refine */
        public SpecialType mo988refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(3);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        @NotNull
        public DelegatingSimpleType replaceDelegate(@NotNull SimpleType simpleType) {
            if (simpleType == null) {
                a(2);
                throw null;
            }
            throw new IllegalStateException(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        @NotNull
        public String toString() {
            String str = this.b;
            if (str != null) {
                return str;
            }
            a(1);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        @NotNull
        public SimpleType makeNullableAsSpecified(boolean z) {
            throw new IllegalStateException(this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        @NotNull
        public SimpleType replaceAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                a(0);
                throw null;
            }
            throw new IllegalStateException(this.b);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r24) {
        /*
        // Method dump skipped, instructions count: 784
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.a(int):void");
    }

    public static boolean acceptsNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            a(28);
            throw null;
        } else if (kotlinType.isMarkedNullable()) {
            return true;
        } else {
            if (!FlexibleTypesKt.isFlexible(kotlinType) || !acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
                return false;
            }
            return true;
        }
    }

    public static boolean b(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1, SmartSet<KotlinType> smartSet) {
        FlexibleType flexibleType = null;
        if (function1 == null) {
            a(44);
            throw null;
        } else if (kotlinType == null) {
            return false;
        } else {
            UnwrappedType unwrap = kotlinType.unwrap();
            if (noExpectedType(kotlinType)) {
                return function1.invoke(unwrap).booleanValue();
            }
            if (smartSet != null && smartSet.contains(kotlinType)) {
                return false;
            }
            if (function1.invoke(unwrap).booleanValue()) {
                return true;
            }
            if (smartSet == null) {
                smartSet = SmartSet.create();
            }
            smartSet.add(kotlinType);
            if (unwrap instanceof FlexibleType) {
                flexibleType = (FlexibleType) unwrap;
            }
            if (flexibleType != null && (b(flexibleType.getLowerBound(), function1, smartSet) || b(flexibleType.getUpperBound(), function1, smartSet))) {
                return true;
            }
            if ((unwrap instanceof DefinitelyNotNullType) && b(((DefinitelyNotNullType) unwrap).getOriginal(), function1, smartSet)) {
                return true;
            }
            TypeConstructor constructor = kotlinType.getConstructor();
            if (constructor instanceof IntersectionTypeConstructor) {
                for (KotlinType kotlinType2 : ((IntersectionTypeConstructor) constructor).getSupertypes()) {
                    if (b(kotlinType2, function1, smartSet)) {
                        return true;
                    }
                }
                return false;
            }
            for (TypeProjection typeProjection : kotlinType.getArguments()) {
                if (!typeProjection.isStarProjection()) {
                    if (b(typeProjection.getType(), function1, smartSet)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean contains(@Nullable KotlinType kotlinType, @NotNull Function1<UnwrappedType, Boolean> function1) {
        if (function1 != null) {
            return b(kotlinType, function1, null);
        }
        a(43);
        throw null;
    }

    @Nullable
    public static KotlinType createSubstitutedSupertype(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            a(20);
            throw null;
        } else if (kotlinType2 == null) {
            a(21);
            throw null;
        } else if (typeSubstitutor != null) {
            KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
            if (substitute != null) {
                return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
            }
            return null;
        } else {
            a(22);
            throw null;
        }
    }

    @Nullable
    public static ClassDescriptor getClassDescriptor(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                return (ClassDescriptor) declarationDescriptor;
            }
            return null;
        }
        a(30);
        throw null;
    }

    @NotNull
    public static List<TypeProjection> getDefaultTypeProjections(@NotNull List<TypeParameterDescriptor> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                arrayList.add(new TypeProjectionImpl(typeParameterDescriptor.getDefaultType()));
            }
            List<TypeProjection> list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            if (list2 != null) {
                return list2;
            }
            a(17);
            throw null;
        }
        a(16);
        throw null;
    }

    @NotNull
    public static List<KotlinType> getImmediateSupertypes(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
            Collection<KotlinType> supertypes = kotlinType.getConstructor().getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            for (KotlinType kotlinType2 : supertypes) {
                KotlinType createSubstitutedSupertype = createSubstitutedSupertype(kotlinType, kotlinType2, create);
                if (createSubstitutedSupertype != null) {
                    arrayList.add(createSubstitutedSupertype);
                }
            }
            return arrayList;
        }
        a(18);
        throw null;
    }

    @Nullable
    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            a(62);
            throw null;
        } else if (kotlinType.getConstructor().mo425getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().mo425getDeclarationDescriptor();
        } else {
            return null;
        }
    }

    public static boolean hasNullableSuperType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            a(29);
            throw null;
        } else if (kotlinType.getConstructor().mo425getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        } else {
            for (KotlinType kotlinType2 : getImmediateSupertypes(kotlinType)) {
                if (isNullableType(kotlinType2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isDontCarePlaceholder(@Nullable KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    public static boolean isNullableType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            a(27);
            throw null;
        } else if (kotlinType.isMarkedNullable()) {
            return true;
        } else {
            if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
                return true;
            }
            if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
                return false;
            }
            if (isTypeParameter(kotlinType)) {
                return hasNullableSuperType(kotlinType);
            }
            TypeConstructor constructor = kotlinType.getConstructor();
            if (constructor instanceof IntersectionTypeConstructor) {
                for (KotlinType kotlinType2 : constructor.getSupertypes()) {
                    if (isNullableType(kotlinType2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean isTypeParameter(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return getTypeParameterDescriptorOrNull(kotlinType) != null || (kotlinType.getConstructor() instanceof NewTypeVariableConstructor);
        }
        a(59);
        throw null;
    }

    @NotNull
    public static KotlinType makeNotNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return makeNullableAsSpecified(kotlinType, false);
        }
        a(2);
        throw null;
    }

    @NotNull
    public static KotlinType makeNullable(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return makeNullableAsSpecified(kotlinType, true);
        }
        a(1);
        throw null;
    }

    @NotNull
    public static KotlinType makeNullableAsSpecified(@NotNull KotlinType kotlinType, boolean z) {
        if (kotlinType != null) {
            UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
            if (makeNullableAsSpecified != null) {
                return makeNullableAsSpecified;
            }
            a(4);
            throw null;
        }
        a(3);
        throw null;
    }

    @NotNull
    public static SimpleType makeNullableIfNeeded(@NotNull SimpleType simpleType, boolean z) {
        if (simpleType == null) {
            a(5);
            throw null;
        } else if (z) {
            SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
            if (makeNullableAsSpecified != null) {
                return makeNullableAsSpecified;
            }
            a(6);
            throw null;
        } else if (simpleType != null) {
            return simpleType;
        } else {
            a(7);
            throw null;
        }
    }

    @NotNull
    public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        a(45);
        throw null;
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (!ErrorUtils.isError(classifierDescriptor)) {
            return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
        }
        SimpleType createErrorType = ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
        if (createErrorType != null) {
            return createErrorType;
        }
        a(11);
        throw null;
    }

    public static boolean noExpectedType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
        }
        a(0);
        throw null;
    }

    @NotNull
    public static KotlinType makeNullableIfNeeded(@NotNull KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            a(8);
            throw null;
        } else if (z) {
            return makeNullable(kotlinType);
        } else {
            if (kotlinType != null) {
                return kotlinType;
            }
            a(9);
            throw null;
        }
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            a(12);
            throw null;
        } else if (memberScope == null) {
            a(13);
            throw null;
        } else if (function1 != null) {
            SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
            if (simpleTypeWithNonTrivialMemberScope != null) {
                return simpleTypeWithNonTrivialMemberScope;
            }
            a(15);
            throw null;
        } else {
            a(14);
            throw null;
        }
    }
}
