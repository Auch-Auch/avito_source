package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.w.f.a.m.j.e;
import t6.w.f.a.m.j.h;
public final class KotlinTypeFactory {
    @NotNull
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    public static final class a extends Lambda implements Function1 {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter((KotlinTypeRefiner) obj, "$noName_0");
            return null;
        }
    }

    public static final class b {
        @Nullable
        public final SimpleType a;
        @Nullable
        public final TypeConstructor b;

        public b(@Nullable SimpleType simpleType, @Nullable TypeConstructor typeConstructor) {
            this.a = simpleType;
            this.b = typeConstructor;
        }
    }

    public static final class c extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
        public final /* synthetic */ KotlinTypeFactory a;
        public final /* synthetic */ TypeConstructor b;
        public final /* synthetic */ List<TypeProjection> c;
        public final /* synthetic */ Annotations d;
        public final /* synthetic */ boolean e;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z) {
            super(1);
            this.a = kotlinTypeFactory;
            this.b = typeConstructor;
            this.c = list;
            this.d = annotations;
            this.e = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "refiner");
            b access$refineConstructor = KotlinTypeFactory.access$refineConstructor(this.a, this.b, kotlinTypeRefiner2, this.c);
            if (access$refineConstructor == null) {
                return null;
            }
            SimpleType simpleType = access$refineConstructor.a;
            if (simpleType != null) {
                return simpleType;
            }
            Annotations annotations = this.d;
            TypeConstructor typeConstructor = access$refineConstructor.b;
            Intrinsics.checkNotNull(typeConstructor);
            return KotlinTypeFactory.simpleType(annotations, typeConstructor, this.c, this.e, kotlinTypeRefiner2);
        }
    }

    public static final class d extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
        public final /* synthetic */ KotlinTypeFactory a;
        public final /* synthetic */ TypeConstructor b;
        public final /* synthetic */ List<TypeProjection> c;
        public final /* synthetic */ Annotations d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ MemberScope f;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z, MemberScope memberScope) {
            super(1);
            this.a = kotlinTypeFactory;
            this.b = typeConstructor;
            this.c = list;
            this.d = annotations;
            this.e = z;
            this.f = memberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            b access$refineConstructor = KotlinTypeFactory.access$refineConstructor(this.a, this.b, kotlinTypeRefiner2, this.c);
            if (access$refineConstructor == null) {
                return null;
            }
            SimpleType simpleType = access$refineConstructor.a;
            if (simpleType != null) {
                return simpleType;
            }
            Annotations annotations = this.d;
            TypeConstructor typeConstructor = access$refineConstructor.b;
            Intrinsics.checkNotNull(typeConstructor);
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, this.c, this.e, this.f);
        }
    }

    static {
        a aVar = a.a;
    }

    public static final b access$refineConstructor(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List list) {
        ClassifierDescriptor classifierDescriptor;
        b bVar;
        Objects.requireNonNull(kotlinTypeFactory);
        ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            classifierDescriptor = null;
        } else {
            classifierDescriptor = kotlinTypeRefiner.refineDescriptor(declarationDescriptor);
        }
        if (classifierDescriptor == null) {
            return null;
        }
        if (classifierDescriptor instanceof TypeAliasDescriptor) {
            bVar = new b(computeExpandedType((TypeAliasDescriptor) classifierDescriptor, list), null);
        } else {
            TypeConstructor refine = classifierDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
            Intrinsics.checkNotNullExpressionValue(refine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
            bVar = new b(null, refine);
        }
        return bVar;
    }

    @JvmStatic
    @NotNull
    public static final SimpleType computeExpandedType(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(list, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, typeAliasDescriptor, list), Annotations.Companion.getEMPTY());
    }

    @JvmStatic
    @NotNull
    public static final UnwrappedType flexibleType(@NotNull SimpleType simpleType, @NotNull SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        if (Intrinsics.areEqual(simpleType, simpleType2)) {
            return simpleType;
        }
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType integerLiteralType(@NotNull Annotations annotations, @NotNull IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        MemberScope createErrorScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(annotations, integerLiteralTypeConstructor, emptyList, z, createErrorScope);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleNotNullType(@NotNull Annotations annotations, @NotNull ClassDescriptor classDescriptor, @NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(annotations, typeConstructor, list, false, null, 16, null);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final SimpleType simpleType(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @Nullable KotlinTypeRefiner kotlinTypeRefiner) {
        MemberScope memberScope;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        if (!annotations.isEmpty() || !list.isEmpty() || z || typeConstructor.mo425getDeclarationDescriptor() == null) {
            KotlinTypeFactory kotlinTypeFactory = INSTANCE;
            Objects.requireNonNull(kotlinTypeFactory);
            ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
            if (declarationDescriptor instanceof TypeParameterDescriptor) {
                memberScope = declarationDescriptor.getDefaultType().getMemberScope();
            } else if (declarationDescriptor instanceof ClassDescriptor) {
                if (kotlinTypeRefiner == null) {
                    kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(declarationDescriptor));
                }
                if (list.isEmpty()) {
                    memberScope = ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, kotlinTypeRefiner);
                } else {
                    memberScope = ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
                }
            } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
                memberScope = ErrorUtils.createErrorScope(Intrinsics.stringPlus("Scope for abbreviation: ", ((TypeAliasDescriptor) declarationDescriptor).getName()), true);
                Intrinsics.checkNotNullExpressionValue(memberScope, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
            } else if (typeConstructor instanceof IntersectionTypeConstructor) {
                memberScope = ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
            } else {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
            }
            return simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, list, z, memberScope, new c(kotlinTypeFactory, typeConstructor, list, annotations, z));
        }
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.mo425getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor2);
        SimpleType defaultType = declarationDescriptor2.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return defaultType;
    }

    public static /* synthetic */ SimpleType simpleType$default(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(annotations, typeConstructor, list, z, kotlinTypeRefiner);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        h hVar = new h(typeConstructor, list, z, memberScope, new d(INSTANCE, typeConstructor, list, annotations, z, memberScope));
        return annotations.isEmpty() ? hVar : new e(hVar, annotations);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull Annotations annotations, @NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull MemberScope memberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        h hVar = new h(typeConstructor, list, z, memberScope, function1);
        return annotations.isEmpty() ? hVar : new e(hVar, annotations);
    }
}
