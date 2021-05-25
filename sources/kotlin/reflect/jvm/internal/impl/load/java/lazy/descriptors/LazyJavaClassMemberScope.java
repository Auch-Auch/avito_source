package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.z;
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    @NotNull
    public final ClassDescriptor m;
    @NotNull
    public final JavaClass n;
    public final boolean o;
    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> p;
    @NotNull
    public final NotNullLazyValue<Set<Name>> q;
    @NotNull
    public final NotNullLazyValue<Map<Name, JavaField>> r;
    @NotNull
    public final MemoizedFunctionToNullable<Name, ClassDescriptorBase> s;

    public static final class a extends Lambda implements Function1<JavaMember, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(JavaMember javaMember) {
            JavaMember javaMember2 = javaMember;
            Intrinsics.checkNotNullParameter(javaMember2, "it");
            return Boolean.valueOf(!javaMember2.isStatic());
        }
    }

    public static final class d extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ LazyJavaClassMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
            super(1);
            this.a = lazyJavaClassMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "it");
            return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.a, name2);
        }
    }

    public static final class e extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ LazyJavaClassMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
            super(1);
            this.a = lazyJavaClassMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "it");
            return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.a, name2);
        }
    }

    public static final class f extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
        public final /* synthetic */ LazyJavaClassMemberScope a;
        public final /* synthetic */ LazyJavaResolverContext b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
            super(0);
            this.a = lazyJavaClassMemberScope;
            this.b = lazyJavaResolverContext;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends ClassConstructorDescriptor> invoke() {
            Collection<JavaConstructor> constructors = this.a.n.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.size());
            for (JavaConstructor javaConstructor : constructors) {
                arrayList.add(LazyJavaClassMemberScope.access$resolveConstructor(this.a, javaConstructor));
            }
            if (this.a.n.isRecord()) {
                ClassConstructorDescriptor access$createDefaultRecordConstructor = LazyJavaClassMemberScope.access$createDefaultRecordConstructor(this.a);
                boolean z = false;
                String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(access$createDefaultRecordConstructor, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((ClassConstructorDescriptor) it.next(), false, false, 2, null), computeJvmDescriptor$default)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    arrayList.add(access$createDefaultRecordConstructor);
                    this.b.getComponents().getJavaResolverCache().recordConstructor(this.a.n, access$createDefaultRecordConstructor);
                }
            }
            SignatureEnhancement signatureEnhancement = this.b.getComponents().getSignatureEnhancement();
            LazyJavaResolverContext lazyJavaResolverContext = this.b;
            LazyJavaClassMemberScope lazyJavaClassMemberScope = this.a;
            boolean isEmpty = arrayList.isEmpty();
            Collection collection = arrayList;
            if (isEmpty) {
                collection = CollectionsKt__CollectionsKt.listOfNotNull(LazyJavaClassMemberScope.access$createDefaultConstructor(lazyJavaClassMemberScope));
            }
            return CollectionsKt___CollectionsKt.toList(signatureEnhancement.enhanceSignatures(lazyJavaResolverContext, collection == 1 ? 1 : 0));
        }
    }

    public static final class g extends Lambda implements Function0<Map<Name, ? extends JavaField>> {
        public final /* synthetic */ LazyJavaClassMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
            super(0);
            this.a = lazyJavaClassMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<Name, ? extends JavaField> invoke() {
            Collection<JavaField> fields = this.a.n.getFields();
            ArrayList arrayList = new ArrayList();
            for (T t : fields) {
                if (t.isEnumEntry()) {
                    arrayList.add(t);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(arrayList, 10)), 16));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                linkedHashMap.put(((JavaField) next).getName(), next);
            }
            return linkedHashMap;
        }
    }

    public static final class h extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ SimpleFunctionDescriptor a;
        public final /* synthetic */ LazyJavaClassMemberScope b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
            super(1);
            this.a = simpleFunctionDescriptor;
            this.b = lazyJavaClassMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "accessorName");
            if (Intrinsics.areEqual(this.a.getName(), name2)) {
                return t6.n.d.listOf(this.a);
            }
            return CollectionsKt___CollectionsKt.plus(LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic(this.b, name2), (Iterable) LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.b, name2));
        }
    }

    public static final class i extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ LazyJavaClassMemberScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
            super(0);
            this.a = lazyJavaClassMemberScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            return CollectionsKt___CollectionsKt.toSet(this.a.n.getInnerClassNames());
        }
    }

    public static final class j extends Lambda implements Function1<Name, ClassDescriptorBase> {
        public final /* synthetic */ LazyJavaClassMemberScope a;
        public final /* synthetic */ LazyJavaResolverContext b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
            super(1);
            this.a = lazyJavaClassMemberScope;
            this.b = lazyJavaResolverContext;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptorBase invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "name");
            if (!((Set) this.a.q.invoke()).contains(name2)) {
                JavaField javaField = (JavaField) ((Map) this.a.r.invoke()).get(name2);
                if (javaField == null) {
                    return null;
                }
                return EnumEntrySyntheticClassDescriptor.create(this.b.getStorageManager(), this.a.getOwnerDescriptor(), name2, this.b.getStorageManager().createLazyValue(new t6.w.f.a.m.c.a.c.a.a(this.a)), LazyJavaAnnotationsKt.resolveAnnotations(this.b, javaField), this.b.getComponents().getSourceElementFactory().source(javaField));
            }
            JavaClassFinder finder = this.b.getComponents().getFinder();
            ClassId classId = DescriptorUtilsKt.getClassId(this.a.getOwnerDescriptor());
            Intrinsics.checkNotNull(classId);
            ClassId createNestedClassId = classId.createNestedClassId(name2);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
            JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, this.a.n, 2, null));
            if (findClass == null) {
                return null;
            }
            LazyJavaResolverContext lazyJavaResolverContext = this.b;
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, this.a.getOwnerDescriptor(), findClass, null, 8, null);
            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i2, t6.r.a.j jVar) {
        this(lazyJavaResolverContext, classDescriptor, javaClass, z, (i2 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    public static final ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        List<ValueParameterDescriptor> list;
        Pair pair;
        boolean isAnnotationType = lazyJavaClassMemberScope.n.isAnnotationType();
        if ((lazyJavaClassMemberScope.n.isInterface() || !lazyJavaClassMemberScope.n.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor ownerDescriptor = lazyJavaClassMemberScope.getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, lazyJavaClassMemberScope.getC().getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope.n));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        if (isAnnotationType) {
            Collection<JavaMethod> methods = lazyJavaClassMemberScope.n.getMethods();
            list = new ArrayList<>(methods.size());
            JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, true, null, 2, null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (T t : methods) {
                if (Intrinsics.areEqual(t.getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                    arrayList.add(t);
                } else {
                    arrayList2.add(t);
                }
            }
            Pair pair2 = new Pair(arrayList, arrayList2);
            List list2 = (List) pair2.component1();
            List<JavaMethod> list3 = (List) pair2.component2();
            list2.size();
            JavaMethod javaMethod = (JavaMethod) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            if (javaMethod != null) {
                JavaType returnType = javaMethod.getReturnType();
                if (returnType instanceof JavaArrayType) {
                    JavaArrayType javaArrayType = (JavaArrayType) returnType;
                    pair = new Pair(lazyJavaClassMemberScope.getC().getTypeResolver().transformArrayType(javaArrayType, attributes$default, true), lazyJavaClassMemberScope.getC().getTypeResolver().transformJavaType(javaArrayType.getComponentType(), attributes$default));
                } else {
                    pair = new Pair(lazyJavaClassMemberScope.getC().getTypeResolver().transformJavaType(returnType, attributes$default), null);
                }
                lazyJavaClassMemberScope.a(list, createJavaConstructor, 0, javaMethod, (KotlinType) pair.component1(), (KotlinType) pair.component2());
            }
            int i2 = javaMethod != null ? 1 : 0;
            int i3 = 0;
            for (JavaMethod javaMethod2 : list3) {
                lazyJavaClassMemberScope.a(list, createJavaConstructor, i3 + i2, javaMethod2, lazyJavaClassMemberScope.getC().getTypeResolver().transformJavaType(javaMethod2.getReturnType(), attributes$default), null);
                i3++;
            }
        } else {
            list = Collections.emptyList();
        }
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(list, lazyJavaClassMemberScope.n(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(true);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        lazyJavaClassMemberScope.getC().getComponents().getJavaResolverCache().recordConstructor(lazyJavaClassMemberScope.n, createJavaConstructor);
        return createJavaConstructor;
    }

    public static final ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        ClassDescriptor ownerDescriptor = lazyJavaClassMemberScope.getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, Annotations.Companion.getEMPTY(), true, lazyJavaClassMemberScope.getC().getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope.n));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        Collection<JavaRecordComponent> recordComponents = lazyJavaClassMemberScope.n.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        KotlinType kotlinType = null;
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 2, null);
        int i2 = 0;
        for (JavaRecordComponent javaRecordComponent : recordComponents) {
            int i3 = i2 + 1;
            KotlinType transformJavaType = lazyJavaClassMemberScope.getC().getTypeResolver().transformJavaType(javaRecordComponent.getType(), attributes$default);
            arrayList.add(new ValueParameterDescriptorImpl(createJavaConstructor, null, i2, Annotations.Companion.getEMPTY(), javaRecordComponent.getName(), transformJavaType, false, false, false, javaRecordComponent.isVararg() ? lazyJavaClassMemberScope.getC().getComponents().getModule().getBuiltIns().getArrayElementType(transformJavaType) : kotlinType, lazyJavaClassMemberScope.getC().getComponents().getSourceElementFactory().source(javaRecordComponent)));
            i2 = i3;
            attributes$default = attributes$default;
            kotlinType = kotlinType;
        }
        createJavaConstructor.setHasSynthesizedParameterNames(false);
        createJavaConstructor.initialize(arrayList, lazyJavaClassMemberScope.n(ownerDescriptor));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        return createJavaConstructor;
    }

    public static final JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaConstructor javaConstructor) {
        ClassDescriptor ownerDescriptor = lazyJavaClassMemberScope.getOwnerDescriptor();
        JavaClassConstructorDescriptor createJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(ownerDescriptor, LazyJavaAnnotationsKt.resolveAnnotations(lazyJavaClassMemberScope.getC(), javaConstructor), false, lazyJavaClassMemberScope.getC().getComponents().getSourceElementFactory().source(javaConstructor));
        Intrinsics.checkNotNullExpressionValue(createJavaConstructor, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        LazyJavaResolverContext childForMethod = ContextKt.childForMethod(lazyJavaClassMemberScope.getC(), createJavaConstructor, javaConstructor, ownerDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters resolveValueParameters = lazyJavaClassMemberScope.resolveValueParameters(childForMethod, createJavaConstructor, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = ownerDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = childForMethod.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        createJavaConstructor.initialize(resolveValueParameters.getDescriptors(), UtilsKt.toDescriptorVisibility(javaConstructor.getVisibility()), CollectionsKt___CollectionsKt.plus((Collection) declaredTypeParameters, (Iterable) arrayList));
        createJavaConstructor.setHasStableParameterNames(false);
        createJavaConstructor.setHasSynthesizedParameterNames(resolveValueParameters.getHasSynthesizedNames());
        createJavaConstructor.setReturnType(ownerDescriptor.getDefaultType());
        childForMethod.getComponents().getJavaResolverCache().recordConstructor(javaConstructor, createJavaConstructor);
        return createJavaConstructor;
    }

    public static final Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        Collection<JavaMethod> findMethodsByName = ((DeclaredMemberIndex) lazyJavaClassMemberScope.getDeclaredMemberIndex().invoke()).findMethodsByName(name);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(findMethodsByName, 10));
        Iterator<T> it = findMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope.resolveMethodToFunctionDescriptor(it.next()));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x000d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r3, kotlin.reflect.jvm.internal.impl.name.Name r4) {
        /*
            java.util.Set r3 = r3.o(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x000d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r3.next()
            r1 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r1
            boolean r2 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(r1)
            if (r2 != 0) goto L_0x002b
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r2 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r1 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r1)
            if (r1 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r1 = 0
            goto L_0x002c
        L_0x002b:
            r1 = 1
        L_0x002c:
            if (r1 != 0) goto L_0x000d
            r4.add(r0)
            goto L_0x000d
        L_0x0032:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope, kotlin.reflect.jvm.internal.impl.name.Name):java.util.Collection");
    }

    public final void a(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i2, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType kotlinType3;
        Annotations empty = Annotations.Companion.getEMPTY();
        Name name = javaMethod.getName();
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(returnType)");
        boolean hasAnnotationParameterDefaultValue = javaMethod.getHasAnnotationParameterDefaultValue();
        if (kotlinType2 == null) {
            kotlinType3 = null;
        } else {
            kotlinType3 = TypeUtils.makeNotNullable(kotlinType2);
        }
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i2, empty, name, makeNotNullable, hasAnnotationParameterDefaultValue, false, false, kotlinType3, getC().getComponents().getSourceElementFactory().source(javaMethod)));
    }

    public final void b(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z) {
            collection.addAll(resolveOverridesForNonStaticMembers);
            return;
        }
        List plus = CollectionsKt___CollectionsKt.plus((Collection) collection, (Iterable) resolveOverridesForNonStaticMembers);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(resolveOverridesForNonStaticMembers, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : resolveOverridesForNonStaticMembers) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
            } else {
                Intrinsics.checkNotNullExpressionValue(simpleFunctionDescriptor, "resolvedOverride");
                simpleFunctionDescriptor = f(simpleFunctionDescriptor, simpleFunctionDescriptor2, plus);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(kotlin.reflect.jvm.internal.impl.name.Name r17, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r18, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r19, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r20, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> r21) {
        /*
        // Method dump skipped, instructions count: 343
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.c(kotlin.reflect.jvm.internal.impl.name.Name, java.util.Collection, java.util.Collection, java.util.Collection, kotlin.jvm.functions.Function1):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeClassNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return z.plus((Set) this.q.invoke(), (Iterable) ((Map) this.r.invoke()).keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.n.isRecord() && ((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findRecordComponentByName(name) != null) {
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                JavaRecordComponent findRecordComponentByName = ((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findRecordComponentByName(name);
                Intrinsics.checkNotNull(findRecordComponentByName);
                JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), findRecordComponentByName), findRecordComponentByName.getName(), getC().getComponents().getSourceElementFactory().source(findRecordComponentByName), true);
                Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
                createJavaMethod.initialize(null, getDispatchReceiverParameter(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), getC().getTypeResolver().transformJavaType(findRecordComponentByName.getType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 2, null)), Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
                createJavaMethod.setParameterNamesStatus(false, false);
                getC().getComponents().getJavaResolverCache().recordMethod(findRecordComponentByName, createJavaMethod);
                collection.add(createJavaMethod);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeNonDeclaredFunctions(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r12) {
        /*
            r10 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.Set r6 = r10.o(r12)
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE
            boolean r0 = r0.getSameAsRenamedInJvmBuiltin(r12)
            r7 = 1
            if (r0 != 0) goto L_0x0065
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            boolean r0 = r0.getSameAsBuiltinMethodWithErasedValueParameters(r12)
            if (r0 != 0) goto L_0x0065
            boolean r0 = r6.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x003f
        L_0x0028:
            java.util.Iterator r0 = r6.iterator()
        L_0x002c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            boolean r2 = r2.isSuspend()
            if (r2 == 0) goto L_0x002c
            r0 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0065
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r2 = r6.iterator()
        L_0x004a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r4
            boolean r4 = r10.r(r4)
            if (r4 == 0) goto L_0x004a
            r0.add(r3)
            goto L_0x004a
        L_0x0061:
            r10.b(r11, r12, r0, r1)
            return
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet$Companion r0 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r8 = r0.create()
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r10.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r10.getC()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r0 = r0.getKotlinTypeChecker()
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r5 = r0.getOverridingUtil()
            r0 = r12
            r1 = r6
            java.util.Collection r9 = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r0, r1, r2, r3, r4, r5)
            java.lang.String r0 = "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$b r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$b
            r5.<init>(r10)
            r0 = r10
            r1 = r12
            r2 = r11
            r3 = r9
            r4 = r11
            r0.c(r1, r2, r3, r4, r5)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$c r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$c
            r5.<init>(r10)
            r4 = r8
            r0.c(r1, r2, r3, r4, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r6.iterator()
        L_0x00af:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c6
            java.lang.Object r2 = r1.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            boolean r3 = r10.r(r3)
            if (r3 == 0) goto L_0x00af
            r0.add(r2)
            goto L_0x00af
        L_0x00c6:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.plus(r0, r8)
            r10.b(r11, r12, r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredFunctions(java.util.Collection, kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        if (this.n.isAnnotationType() && (javaMethod = (JavaMethod) CollectionsKt___CollectionsKt.singleOrNull(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).findMethodsByName(name))) != null) {
            JavaPropertyDescriptor create = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(getC(), javaMethod), Modality.FINAL, UtilsKt.toDescriptorVisibility(javaMethod.getVisibility()), false, javaMethod.getName(), getC().getComponents().getSourceElementFactory().source(javaMethod), false);
            Intrinsics.checkNotNullExpressionValue(create, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
            PropertyGetterDescriptorImpl createDefaultGetter = DescriptorFactory.createDefaultGetter(create, Annotations.Companion.getEMPTY());
            Intrinsics.checkNotNullExpressionValue(createDefaultGetter, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
            create.initialize(createDefaultGetter, null);
            KotlinType computeMethodReturnType = computeMethodReturnType(javaMethod, ContextKt.childForMethod$default(getC(), create, javaMethod, 0, 4, null));
            create.setType(computeMethodReturnType, CollectionsKt__CollectionsKt.emptyList(), getDispatchReceiverParameter(), null);
            createDefaultGetter.initialize(computeMethodReturnType);
            collection.add(create);
        }
        Set<PropertyDescriptor> p2 = p(name);
        if (!p2.isEmpty()) {
            SmartSet.Companion companion = SmartSet.Companion;
            SmartSet create2 = companion.create();
            SmartSet create3 = companion.create();
            d(p2, collection, create2, new d(this));
            d(z.minus((Set) p2, (Iterable) create2), create3, null, new e(this));
            Collection<? extends PropertyDescriptor> resolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, z.plus((Set) p2, (Iterable) create3), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
            collection.addAll(resolveOverridesForNonStaticMembers);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computePropertyNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (this.n.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getFieldNames());
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(linkedHashSet, it.next().getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    public final void d(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor;
        for (PropertyDescriptor propertyDescriptor : set) {
            PropertySetterDescriptorImpl propertySetterDescriptorImpl = null;
            if (h(propertyDescriptor, function1)) {
                SimpleFunctionDescriptor l = l(propertyDescriptor, function1);
                Intrinsics.checkNotNull(l);
                if (propertyDescriptor.isVar()) {
                    simpleFunctionDescriptor = m(propertyDescriptor, function1);
                    Intrinsics.checkNotNull(simpleFunctionDescriptor);
                } else {
                    simpleFunctionDescriptor = null;
                }
                if (simpleFunctionDescriptor != null) {
                    simpleFunctionDescriptor.getModality();
                    l.getModality();
                }
                JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor2 = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), l, simpleFunctionDescriptor, propertyDescriptor);
                KotlinType returnType = l.getReturnType();
                Intrinsics.checkNotNull(returnType);
                javaForKotlinOverridePropertyDescriptor2.setType(returnType, CollectionsKt__CollectionsKt.emptyList(), getDispatchReceiverParameter(), null);
                PropertyGetterDescriptorImpl createGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor2, l.getAnnotations(), false, false, false, l.getSource());
                createGetter.setInitialSignatureDescriptor(l);
                createGetter.initialize(javaForKotlinOverridePropertyDescriptor2.getType());
                Intrinsics.checkNotNullExpressionValue(createGetter, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
                if (simpleFunctionDescriptor != null) {
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) valueParameters);
                    if (valueParameterDescriptor != null) {
                        javaForKotlinOverridePropertyDescriptor = javaForKotlinOverridePropertyDescriptor2;
                        propertySetterDescriptorImpl = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                        propertySetterDescriptorImpl.setInitialSignatureDescriptor(simpleFunctionDescriptor);
                        propertyGetterDescriptorImpl = createGetter;
                    } else {
                        throw new AssertionError(Intrinsics.stringPlus("No parameter found for ", simpleFunctionDescriptor));
                    }
                } else {
                    javaForKotlinOverridePropertyDescriptor = javaForKotlinOverridePropertyDescriptor2;
                    propertyGetterDescriptorImpl = createGetter;
                }
                javaForKotlinOverridePropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl);
                propertySetterDescriptorImpl = javaForKotlinOverridePropertyDescriptor;
            }
            if (propertySetterDescriptorImpl != null) {
                collection.add(propertySetterDescriptorImpl);
                if (set2 != null) {
                    set2.add(propertyDescriptor);
                    return;
                }
                return;
            }
        }
    }

    public final Collection<KotlinType> e() {
        if (!this.o) {
            return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
        }
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    public final SimpleFunctionDescriptor f(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z;
        boolean z2 = true;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (Intrinsics.areEqual(simpleFunctionDescriptor, next) || next.getInitialSignatureDescriptor() != null || !i(next, callableDescriptor)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(simpleFunctionDescriptor2);
        return simpleFunctionDescriptor2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r3, getC().getComponents().getSettings().isReleaseCoroutines()) == false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor g(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r1 = "valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            r0 = r2
            goto L_0x0051
        L_0x0014:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.mo425getDeclarationDescriptor()
            if (r3 != 0) goto L_0x0024
            r3 = r2
            goto L_0x0028
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(r3)
        L_0x0028:
            if (r3 != 0) goto L_0x002c
        L_0x002a:
            r3 = r2
            goto L_0x003b
        L_0x002c:
            boolean r4 = r3.isSafe()
            if (r4 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r3 = r2
        L_0x0034:
            if (r3 != 0) goto L_0x0037
            goto L_0x002a
        L_0x0037:
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = r3.toSafe()
        L_0x003b:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r5.getC()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r4.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r4 = r4.getSettings()
            boolean r4 = r4.isReleaseCoroutines()
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.isContinuation(r3, r4)
            if (r3 == 0) goto L_0x0012
        L_0x0051:
            if (r0 != 0) goto L_0x0054
            return r2
        L_0x0054:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r6.newCopyBuilder()
            java.util.List r6 = r6.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.dropLast(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r2.setValueParameters(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            java.util.List r0 = r0.getArguments()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl) r0
            if (r0 != 0) goto L_0x008b
            goto L_0x008e
        L_0x008b:
            r0.setSuspend(r1)
        L_0x008e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.g(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        MemoizedFunctionToNullable<Name, ClassDescriptorBase> memoizedFunctionToNullable;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) getMainScope();
        ClassDescriptorBase classDescriptorBase = null;
        if (!(lazyJavaClassMemberScope == null || (memoizedFunctionToNullable = lazyJavaClassMemberScope.s) == null)) {
            classDescriptorBase = memoizedFunctionToNullable.invoke(name);
        }
        return classDescriptorBase == null ? this.s.invoke(name) : classDescriptorBase;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        return super.getContributedFunctions(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        return super.getContributedVariables(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    public final boolean h(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor l = l(propertyDescriptor, function1);
        SimpleFunctionDescriptor m2 = m(propertyDescriptor, function1);
        if (l == null) {
            return false;
        }
        if (!propertyDescriptor.isVar()) {
            return true;
        }
        if (m2 == null || m2.getModality() != l.getModality()) {
            return false;
        }
        return true;
    }

    public final boolean i(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        if (result != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE || JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.n.isAnnotationType()) {
            return false;
        }
        return r(javaMethodDescriptor);
    }

    public final boolean j(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return i(functionDescriptor, simpleFunctionDescriptor);
    }

    public final SimpleFunctionDescriptor k(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(getterName)");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final SimpleFunctionDescriptor l(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        String str = null;
        PropertyGetterDescriptor propertyGetterDescriptor = getter == null ? null : (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter);
        if (propertyGetterDescriptor != null) {
            str = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor);
        }
        if (str != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), propertyGetterDescriptor)) {
            return k(propertyDescriptor, str, function1);
        }
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return k(propertyDescriptor, JvmAbi.getterName(asString), function1);
    }

    public final SimpleFunctionDescriptor m(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        JvmAbi jvmAbi = JvmAbi.INSTANCE;
        String asString = propertyDescriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Name identifier = Name.identifier(JvmAbi.setterName(asString));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator it = ((Iterable) function1.invoke(identifier)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final DescriptorVisibility n(ClassDescriptor classDescriptor) {
        DescriptorVisibility visibility = classDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!Intrinsics.areEqual(visibility, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY)) {
            return visibility;
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility;
    }

    public final Set<SimpleFunctionDescriptor> o(Name name) {
        Collection<KotlinType> e2 = e();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = e2.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(linkedHashSet, it.next().getMemberScope().getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    public final Set<PropertyDescriptor> p(Name name) {
        Collection<KotlinType> e2 = e();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e2.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = it.next().getMemberScope().getContributedVariables(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next());
            }
            t6.n.h.addAll(arrayList, arrayList2);
        }
        return CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    public final boolean q(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        if (!Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null)) || i(simpleFunctionDescriptor, functionDescriptor)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        if (kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.isSetterName(r4) == false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0079 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean r(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r10) {
        /*
        // Method dump skipped, instructions count: 432
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.r(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):boolean");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, getOwnerDescriptor(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaScope.MethodSignatureData resolveMethodSignature(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator.PropagatedSignature resolvePropagatedSignature = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(javaMethod, getOwnerDescriptor(), kotlinType, null, list2, list);
        Intrinsics.checkNotNullExpressionValue(resolvePropagatedSignature, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        KotlinType returnType = resolvePropagatedSignature.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "propagated.returnType");
        KotlinType receiverType = resolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters = resolvePropagatedSignature.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "propagated.valueParameters");
        List<TypeParameterDescriptor> typeParameters = resolvePropagatedSignature.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean hasStableParameterNames = resolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = resolvePropagatedSignature.getErrors();
        Intrinsics.checkNotNullExpressionValue(errors, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(returnType, receiverType, valueParameters, typeParameters, hasStableParameterNames, errors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public String toString() {
        return Intrinsics.stringPlus("Lazy Java member scope for ", this.n.getFqName());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull JavaClass javaClass, boolean z, @Nullable LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(lazyJavaResolverContext, lazyJavaClassMemberScope);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        this.m = classDescriptor;
        this.n = javaClass;
        this.o = z;
        this.p = lazyJavaResolverContext.getStorageManager().createLazyValue(new f(this, lazyJavaResolverContext));
        this.q = lazyJavaResolverContext.getStorageManager().createLazyValue(new i(this));
        this.r = lazyJavaResolverContext.getStorageManager().createLazyValue(new g(this));
        this.s = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new j(this, lazyJavaResolverContext));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LinkedHashSet<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Collection<KotlinType> supertypes = getOwnerDescriptor().getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<Name> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(linkedHashSet, it.next().getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getMethodNames());
        linkedHashSet.addAll(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getRecordComponentNames());
        linkedHashSet.addAll(computeClassNames(descriptorKindFilter, function1));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.n, a.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public ClassDescriptor getOwnerDescriptor() {
        return this.m;
    }
}
