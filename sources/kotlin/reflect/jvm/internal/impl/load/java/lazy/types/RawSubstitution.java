package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.e;
public final class RawSubstitution extends TypeSubstitution {
    @NotNull
    public static final RawSubstitution INSTANCE = new RawSubstitution();
    @NotNull
    public static final JavaTypeAttributes a;
    @NotNull
    public static final JavaTypeAttributes b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {3, 2, 1};

        static {
            JavaTypeFlexibility.values();
        }
    }

    public static final class a extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
        public final /* synthetic */ ClassDescriptor a;
        public final /* synthetic */ RawSubstitution b;
        public final /* synthetic */ SimpleType c;
        public final /* synthetic */ JavaTypeAttributes d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
            super(1);
            this.a = classDescriptor;
            this.b = rawSubstitution;
            this.c = simpleType;
            this.d = javaTypeAttributes;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            ClassDescriptor findClassAcrossModuleDependencies;
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            ClassDescriptor classDescriptor = this.a;
            if (!(classDescriptor instanceof ClassDescriptor)) {
                classDescriptor = null;
            }
            ClassId classId = classDescriptor == null ? null : DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId == null || (findClassAcrossModuleDependencies = kotlinTypeRefiner2.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual(findClassAcrossModuleDependencies, this.a)) {
                return null;
            }
            return (SimpleType) this.b.a(this.c, findClassAcrossModuleDependencies, this.d).getFirst();
        }
    }

    static {
        TypeUsage typeUsage = TypeUsage.COMMON;
        a = JavaTypeResolverKt.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        b = JavaTypeResolverKt.toAttributes$default(typeUsage, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinType = JavaTypeResolverKt.getErasedUpperBound$default(typeParameterDescriptor, null, null, 3, null);
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    public final Pair<SimpleType, Boolean> a(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(simpleType, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(simpleType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type, "componentTypeProjection.type");
            List listOf = d.listOf(new TypeProjectionImpl(projectionKind, b(type)));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAnnotations(), simpleType.getConstructor(), listOf, simpleType.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        } else if (KotlinTypeKt.isError(simpleType)) {
            SimpleType createErrorType = ErrorUtils.createErrorType(Intrinsics.stringPlus("Raw error type: ", simpleType.getConstructor()));
            Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return TuplesKt.to(createErrorType, Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(this);
            Intrinsics.checkNotNullExpressionValue(memberScope, "declaration.getMemberScope(RawSubstitution)");
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
            Annotations annotations = simpleType.getAnnotations();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "declaration.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
            for (T t : parameters) {
                Intrinsics.checkNotNullExpressionValue(t, "parameter");
                arrayList.add(computeProjection$default(this, t, javaTypeAttributes, null, 4, null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new a(classDescriptor, this, simpleType, javaTypeAttributes)), Boolean.TRUE);
        }
    }

    public final KotlinType b(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return b(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor) declarationDescriptor, null, null, 3, null));
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor declarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo425getDeclarationDescriptor();
            if (declarationDescriptor2 instanceof ClassDescriptor) {
                Pair<SimpleType, Boolean> a3 = a(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor, a);
                SimpleType component1 = a3.component1();
                boolean booleanValue = a3.component2().booleanValue();
                Pair<SimpleType, Boolean> a4 = a(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) declarationDescriptor2, b);
                SimpleType component12 = a4.component1();
                boolean booleanValue2 = a4.component2().booleanValue();
                if (booleanValue || booleanValue2) {
                    return new RawTypeImpl(component1, component12);
                }
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                return KotlinTypeFactory.flexibleType(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + Typography.quote).toString());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected declaration kind: ", declarationDescriptor).toString());
    }

    @NotNull
    public final TypeProjection computeProjection(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull JavaTypeAttributes javaTypeAttributes, @NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "parameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        Intrinsics.checkNotNullParameter(kotlinType, "erasedUpperBound");
        int ordinal = javaTypeAttributes.getFlexibility().ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
                return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType());
            }
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                return new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
            }
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        } else if (ordinal == 2) {
            return new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @NotNull
    public TypeProjectionImpl get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return new TypeProjectionImpl(b(kotlinType));
    }
}
