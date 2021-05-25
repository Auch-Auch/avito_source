package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.y;
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    public static final /* synthetic */ KProperty<Object>[] h = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    @NotNull
    public final ModuleDescriptor a;
    @NotNull
    public final JavaToKotlinClassMapper b = JavaToKotlinClassMapper.INSTANCE;
    @NotNull
    public final NotNullLazyValue c;
    @NotNull
    public final KotlinType d;
    @NotNull
    public final NotNullLazyValue e;
    @NotNull
    public final CacheWithNotNullValues<FqName, ClassDescriptor> f;
    @NotNull
    public final NotNullLazyValue g;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 4, 2, 3};

        static {
            a.values();
        }
    }

    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    public static final class b extends Lambda implements Function0<SimpleType> {
        public final /* synthetic */ JvmBuiltInsCustomizer a;
        public final /* synthetic */ StorageManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
            super(0);
            this.a = jvmBuiltInsCustomizer;
            this.b = storageManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleType invoke() {
            return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.a.b().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID(), new NotFoundClasses(this.b, this.a.b().getOwnerModuleDescriptor())).getDefaultType();
        }
    }

    public static final class c extends Lambda implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ Name a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Name name) {
            super(1);
            this.a = name;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(MemberScope memberScope) {
            MemberScope memberScope2 = memberScope;
            Intrinsics.checkNotNullParameter(memberScope2, "it");
            return memberScope2.getContributedFunctions(this.a, NoLookupLocation.FROM_BUILTINS);
        }
    }

    public static final class d extends Lambda implements Function0<Annotations> {
        public final /* synthetic */ JvmBuiltInsCustomizer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
            super(0);
            this.a = jvmBuiltInsCustomizer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Annotations invoke() {
            return Annotations.Companion.create(t6.n.d.listOf(AnnotationUtilKt.createDeprecatedAnnotation$default(this.a.a.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    public JvmBuiltInsCustomizer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull Function0<JvmBuiltIns.Settings> function0) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "settingsComputation");
        this.a = moduleDescriptor;
        this.c = storageManager.createLazyValue(function0);
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new PackageFragmentDescriptorImpl(moduleDescriptor, new FqName("java.io")) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            @NotNull
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        }, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, t6.n.d.listOf(new LazyWrappedType(storageManager, new t6.w.f.a.m.a.a.b(this))), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(MemberScope.Empty.INSTANCE, y.emptySet(), null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        this.d = defaultType;
        this.e = storageManager.createLazyValue(new b(this, storageManager));
        this.f = storageManager.createCacheWithNotNullValues();
        this.g = storageManager.createLazyValue(new d(this));
    }

    public final LazyJavaClassDescriptor a(ClassDescriptor classDescriptor) {
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            return null;
        }
        ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe);
        FqName asSingleFqName = mapKotlinToJava == null ? null : mapKotlinToJava.asSingleFqName();
        if (asSingleFqName == null) {
            return null;
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(b().getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) resolveClassByFqName;
        }
        return null;
    }

    public final JvmBuiltIns.Settings b() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.c, this, h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !b().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor a3 = a(classDescriptor);
        if (a3 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.b, DescriptorUtilsKt.getFqNameSafe(a3), FallbackBuiltIns.f.getInstance(), null, 4, null);
        if (mapJavaToKotlin$default == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, a3).buildSubstitutor();
        List<ClassConstructorDescriptor> constructors = a3.getConstructors();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = constructors.iterator();
        while (true) {
            boolean z4 = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t = next;
            if (t.getVisibility().isPublicAPI()) {
                Collection<ClassConstructorDescriptor> constructors2 = mapJavaToKotlin$default.getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors2, "defaultKotlinVersion.constructors");
                if (!constructors2.isEmpty()) {
                    Iterator<T> it2 = constructors2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "it");
                        if (OverridingUtil.getBothWaysOverridability(next2, t.mo426substitute(buildSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                            z3 = true;
                            continue;
                        } else {
                            z3 = false;
                            continue;
                        }
                        if (z3) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (t.getValueParameters().size() == 1) {
                        List<ValueParameterDescriptor> valueParameters = t.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
                        ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters)).getType().getConstructor().mo425getDeclarationDescriptor();
                        if (Intrinsics.areEqual(declarationDescriptor == null ? null : DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor), DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                            z2 = true;
                            if (!z2 && !KotlinBuiltIns.isDeprecated(t) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, a3, MethodSignatureMappingKt.computeJvmDescriptor$default(t, false, false, 3, null)))) {
                                z4 = true;
                            }
                        }
                    }
                    z2 = false;
                    z4 = true;
                }
            }
            if (z4) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) it3.next();
            FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor.newCopyBuilder();
            newCopyBuilder.setOwner(classDescriptor);
            newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
            newCopyBuilder.setPreserveSourceElement();
            newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
            if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, a3, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                newCopyBuilder.setAdditionalAnnotations((Annotations) StorageKt.getValue(this.g, this, h[2]));
            }
            FunctionDescriptor build = newCopyBuilder.build();
            Objects.requireNonNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((ClassConstructorDescriptor) build);
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0264, code lost:
        if (r2 != 3) goto L_0x0282;
     */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ee A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x028d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fd A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r15) {
        /*
        // Method dump skipped, instructions count: 659
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        if (jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType simpleType = (SimpleType) StorageKt.getValue(this.e, this, h[1]);
            Intrinsics.checkNotNullExpressionValue(simpleType, "cloneableType");
            return CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinType[]{simpleType, this.d});
        } else if (jvmBuiltInsSignatures.isSerializableInJava(fqNameUnsafe)) {
            return t6.n.d.listOf(this.d);
        } else {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor a3 = a(classDescriptor);
        if (a3 == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope unsubstitutedMemberScope = a3.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it.next(), false, false, 3, null), computeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    @NotNull
    public Set<Name> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return y.emptySet();
        }
        LazyJavaClassDescriptor a3 = a(classDescriptor);
        Set<Name> set = null;
        if (!(a3 == null || (unsubstitutedMemberScope = a3.getUnsubstitutedMemberScope()) == null)) {
            set = unsubstitutedMemberScope.getFunctionNames();
        }
        return set == null ? y.emptySet() : set;
    }
}
