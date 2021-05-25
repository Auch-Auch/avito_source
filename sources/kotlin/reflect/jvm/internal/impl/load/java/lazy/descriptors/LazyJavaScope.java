package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.r;
import t6.r.a.j;
public abstract class LazyJavaScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty<Object>[] l = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    @NotNull
    public final LazyJavaResolverContext a;
    @Nullable
    public final LazyJavaScope b;
    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> d;
    @NotNull
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> e;
    @NotNull
    public final MemoizedFunctionToNullable<Name, PropertyDescriptor> f;
    @NotNull
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> g;
    @NotNull
    public final NotNullLazyValue h;
    @NotNull
    public final NotNullLazyValue i;
    @NotNull
    public final NotNullLazyValue j;
    @NotNull
    public final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> k;

    public static final class MethodSignatureData {
        @NotNull
        public final KotlinType a;
        @Nullable
        public final KotlinType b;
        @NotNull
        public final List<ValueParameterDescriptor> c;
        @NotNull
        public final List<TypeParameterDescriptor> d;
        public final boolean e;
        @NotNull
        public final List<String> f;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> */
        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(@NotNull KotlinType kotlinType, @Nullable KotlinType kotlinType2, @NotNull List<? extends ValueParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, boolean z, @NotNull List<String> list3) {
            Intrinsics.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics.checkNotNullParameter(list, "valueParameters");
            Intrinsics.checkNotNullParameter(list2, "typeParameters");
            Intrinsics.checkNotNullParameter(list3, "errors");
            this.a = kotlinType;
            this.b = kotlinType2;
            this.c = list;
            this.d = list2;
            this.e = z;
            this.f = list3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodSignatureData)) {
                return false;
            }
            MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
            return Intrinsics.areEqual(this.a, methodSignatureData.a) && Intrinsics.areEqual(this.b, methodSignatureData.b) && Intrinsics.areEqual(this.c, methodSignatureData.c) && Intrinsics.areEqual(this.d, methodSignatureData.d) && this.e == methodSignatureData.e && Intrinsics.areEqual(this.f, methodSignatureData.f);
        }

        @NotNull
        public final List<String> getErrors() {
            return this.f;
        }

        public final boolean getHasStableParameterNames() {
            return this.e;
        }

        @Nullable
        public final KotlinType getReceiverType() {
            return this.b;
        }

        @NotNull
        public final KotlinType getReturnType() {
            return this.a;
        }

        @NotNull
        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.d;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.c;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            KotlinType kotlinType = this.b;
            int hashCode2 = kotlinType == null ? 0 : kotlinType.hashCode();
            int hashCode3 = (this.d.hashCode() + ((this.c.hashCode() + ((hashCode + hashCode2) * 31)) * 31)) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return this.f.hashCode() + ((hashCode3 + i) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("MethodSignatureData(returnType=");
            L.append(this.a);
            L.append(", receiverType=");
            L.append(this.b);
            L.append(", valueParameters=");
            L.append(this.c);
            L.append(", typeParameters=");
            L.append(this.d);
            L.append(", hasStableParameterNames=");
            L.append(this.e);
            L.append(", errors=");
            L.append(this.f);
            L.append(')');
            return L.toString();
        }
    }

    public static final class ResolvedValueParameters {
        @NotNull
        public final List<ValueParameterDescriptor> a;
        public final boolean b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> */
        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(@NotNull List<? extends ValueParameterDescriptor> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "descriptors");
            this.a = list;
            this.b = z;
        }

        @NotNull
        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.a;
        }

        public final boolean getHasSynthesizedNames() {
            return this.b;
        }
    }

    public static final class a extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaScope lazyJavaScope) {
            super(0);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<? extends DeclarationDescriptor> invoke() {
            return this.a.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
        }
    }

    public static final class b extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyJavaScope lazyJavaScope) {
            super(0);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            return this.a.computeClassNames(DescriptorKindFilter.CLASSIFIERS, null);
        }
    }

    public static final class c extends Lambda implements Function1<Name, PropertyDescriptor> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(LazyJavaScope lazyJavaScope) {
            super(1);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PropertyDescriptor invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "name");
            if (this.a.getMainScope() != null) {
                return (PropertyDescriptor) this.a.getMainScope().f.invoke(name2);
            }
            JavaField findFieldByName = ((DeclaredMemberIndex) this.a.getDeclaredMemberIndex().invoke()).findFieldByName(name2);
            if (findFieldByName == null || findFieldByName.isEnumEntry()) {
                return null;
            }
            return LazyJavaScope.access$resolveProperty(this.a, findFieldByName);
        }
    }

    public static final class d extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(LazyJavaScope lazyJavaScope) {
            super(1);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "name");
            if (this.a.getMainScope() != null) {
                return (Collection) this.a.getMainScope().e.invoke(name2);
            }
            ArrayList arrayList = new ArrayList();
            for (JavaMethod javaMethod : ((DeclaredMemberIndex) this.a.getDeclaredMemberIndex().invoke()).findMethodsByName(name2)) {
                JavaMethodDescriptor resolveMethodToFunctionDescriptor = this.a.resolveMethodToFunctionDescriptor(javaMethod);
                if (this.a.isVisibleAsFunction(resolveMethodToFunctionDescriptor)) {
                    this.a.getC().getComponents().getJavaResolverCache().recordMethod(javaMethod, resolveMethodToFunctionDescriptor);
                    arrayList.add(resolveMethodToFunctionDescriptor);
                }
            }
            this.a.computeImplicitlyDeclaredFunctions(arrayList, name2);
            return arrayList;
        }
    }

    public static final class e extends Lambda implements Function0<DeclaredMemberIndex> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LazyJavaScope lazyJavaScope) {
            super(0);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public DeclaredMemberIndex invoke() {
            return this.a.computeMemberIndex();
        }
    }

    public static final class f extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LazyJavaScope lazyJavaScope) {
            super(0);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            return this.a.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, null);
        }
    }

    public static final class g extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(LazyJavaScope lazyJavaScope) {
            super(1);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) this.a.e.invoke(name2));
            LazyJavaScope.access$retainMostSpecificMethods(this.a, linkedHashSet);
            this.a.computeNonDeclaredFunctions(linkedHashSet, name2);
            return CollectionsKt___CollectionsKt.toList(this.a.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.a.getC(), linkedHashSet));
        }
    }

    public static final class h extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(LazyJavaScope lazyJavaScope) {
            super(1);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public List<? extends PropertyDescriptor> invoke(Name name) {
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "name");
            ArrayList arrayList = new ArrayList();
            CollectionsKt.addIfNotNull(arrayList, this.a.f.invoke(name2));
            this.a.computeNonDeclaredProperties(name2, arrayList);
            if (DescriptorUtils.isAnnotationClass(this.a.getOwnerDescriptor())) {
                return CollectionsKt___CollectionsKt.toList(arrayList);
            }
            return CollectionsKt___CollectionsKt.toList(this.a.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.a.getC(), arrayList));
        }
    }

    public static final class i extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ LazyJavaScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(LazyJavaScope lazyJavaScope) {
            super(0);
            this.a = lazyJavaScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends Name> invoke() {
            return this.a.computePropertyNames(DescriptorKindFilter.VARIABLES, null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaScope lazyJavaScope, int i2, j jVar) {
        this(lazyJavaResolverContext, (i2 & 2) != 0 ? null : lazyJavaScope);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
        if (r12.getHasConstantNotNullInitializer() != false) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor access$resolveProperty(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope r11, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField r12) {
        /*
            java.util.Objects.requireNonNull(r11)
            boolean r0 = r12.isFinal()
            r1 = 1
            r6 = r0 ^ 1
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r11.a
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r12)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r11.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r0 = r12.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.toDescriptorVisibility(r0)
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r12.getName()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r11.a
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r0 = r0.getSourceElementFactory()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r8 = r0.source(r12)
            boolean r0 = r12.isFinal()
            r10 = 0
            if (r0 == 0) goto L_0x003f
            boolean r0 = r12.isStatic()
            if (r0 == 0) goto L_0x003f
            r9 = 1
            goto L_0x0040
        L_0x003f:
            r9 = 0
        L_0x0040:
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r0 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor.create(r2, r3, r4, r5, r6, r7, r8, r9)
        */
        //  java.lang.String r2 = "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )"
        /*
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 0
            r0.initialize(r2, r2, r2, r2)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3 = r11.a
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r3 = r3.getTypeResolver()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r4 = r12.getType()
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r5 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r6 = 3
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r5, r10, r2, r6, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.transformJavaType(r4, r5)
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(r3)
            if (r4 != 0) goto L_0x006e
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r3)
            if (r4 == 0) goto L_0x0086
        L_0x006e:
            boolean r4 = r12.isFinal()
            if (r4 == 0) goto L_0x007c
            boolean r4 = r12.isStatic()
            if (r4 == 0) goto L_0x007c
            r4 = 1
            goto L_0x007d
        L_0x007c:
            r4 = 0
        L_0x007d:
            if (r4 == 0) goto L_0x0086
            boolean r4 = r12.getHasConstantNotNullInitializer()
            if (r4 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r1 = 0
        L_0x0087:
            if (r1 == 0) goto L_0x0092
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(r3)
            java.lang.String r1 = "makeNotNullable(propertyType)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
        L_0x0092:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r4 = r11.getDispatchReceiverParameter()
            r0.setType(r3, r1, r4, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.getType()
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.shouldRecordInitializerForProperty(r0, r1)
            if (r1 == 0) goto L_0x00b9
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r11.a
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r1.getStorageManager()
            t6.w.f.a.m.c.a.c.a.b r2 = new t6.w.f.a.m.c.a.c.a.b
            r2.<init>(r11, r12, r0)
            kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue r1 = r1.createNullableLazyValue(r2)
            r0.setCompileTimeInitializer(r1)
        L_0x00b9:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r11 = r11.a
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r11 = r11.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r11 = r11.getJavaResolverCache()
            r11.recordField(r12, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.access$resolveProperty(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField):kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor");
    }

    public static final void access$retainMostSpecificMethods(LazyJavaScope lazyJavaScope, Set set) {
        Objects.requireNonNull(lazyJavaScope);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(computeJvmDescriptor$default);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(computeJvmDescriptor$default, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection selectMostSpecificInEachOverridableGroup = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list, t6.w.f.a.m.c.a.c.a.c.a);
                set.removeAll(list);
                set.addAll(selectMostSpecificInEachOverridableGroup);
            }
        }
    }

    @NotNull
    public abstract Set<Name> computeClassNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    @NotNull
    public final List<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : computeClassNames(descriptorKindFilter, function1)) {
                if (function1.invoke(name).booleanValue()) {
                    CollectionsKt.addIfNotNull(linkedHashSet, getContributedClassifier(name, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name2 : computeFunctionNames(descriptorKindFilter, function1)) {
                if (function1.invoke(name2).booleanValue()) {
                    linkedHashSet.addAll(getContributedFunctions(name2, noLookupLocation));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) && !descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE)) {
            for (Name name3 : computePropertyNames(descriptorKindFilter, function1)) {
                if (function1.invoke(name3).booleanValue()) {
                    linkedHashSet.addAll(getContributedVariables(name3, noLookupLocation));
                }
            }
        }
        return CollectionsKt___CollectionsKt.toList(linkedHashSet);
    }

    @NotNull
    public abstract Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    public void computeImplicitlyDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @NotNull
    public abstract DeclaredMemberIndex computeMemberIndex();

    @NotNull
    public final KotlinType computeMethodReturnType(@NotNull JavaMethod javaMethod, @NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        return lazyJavaResolverContext.getTypeResolver().transformJavaType(javaMethod.getReturnType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaMethod.getContainingClass().isAnnotationType(), null, 2, null));
    }

    public abstract void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name);

    public abstract void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection);

    @NotNull
    public abstract Set<Name> computePropertyNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1);

    @NotNull
    public final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.c;
    }

    @NotNull
    public final LazyJavaResolverContext getC() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getClassifierNames() {
        return (Set) StorageKt.getValue(this.j, this, l[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.c.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.g.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        if (!getVariableNames().contains(name)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.k.invoke(name);
    }

    @NotNull
    public final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.d;
    }

    @Nullable
    public abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        return (Set) StorageKt.getValue(this.h, this, l[0]);
    }

    @Nullable
    public final LazyJavaScope getMainScope() {
        return this.b;
    }

    @NotNull
    public abstract DeclarationDescriptor getOwnerDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        return (Set) StorageKt.getValue(this.i, this, l[1]);
    }

    public boolean isVisibleAsFunction(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    @NotNull
    public abstract MethodSignatureData resolveMethodSignature(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2);

    @NotNull
    public final JavaMethodDescriptor resolveMethodToFunctionDescriptor(@NotNull JavaMethod javaMethod) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> map;
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        JavaMethodDescriptor createJavaMethod = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.a, javaMethod), javaMethod.getName(), this.a.getComponents().getSourceElementFactory().source(javaMethod), ((DeclaredMemberIndex) this.d.invoke()).findRecordComponentByName(javaMethod.getName()) != null && javaMethod.getValueParameters().isEmpty());
        Intrinsics.checkNotNullExpressionValue(createJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        LazyJavaResolverContext childForMethod$default = ContextKt.childForMethod$default(this.a, createJavaMethod, javaMethod, 0, 4, null);
        List<JavaTypeParameter> typeParameters = javaMethod.getTypeParameters();
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(t6.n.e.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = childForMethod$default.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
            Intrinsics.checkNotNull(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        ResolvedValueParameters resolveValueParameters = resolveValueParameters(childForMethod$default, createJavaMethod, javaMethod.getValueParameters());
        MethodSignatureData resolveMethodSignature = resolveMethodSignature(javaMethod, arrayList, computeMethodReturnType(javaMethod, childForMethod$default), resolveValueParameters.getDescriptors());
        KotlinType receiverType = resolveMethodSignature.getReceiverType();
        if (receiverType == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(createJavaMethod, receiverType, Annotations.Companion.getEMPTY());
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> typeParameters2 = resolveMethodSignature.getTypeParameters();
        List<ValueParameterDescriptor> valueParameters = resolveMethodSignature.getValueParameters();
        KotlinType returnType = resolveMethodSignature.getReturnType();
        Modality convertFromFlags = Modality.Companion.convertFromFlags(false, javaMethod.isAbstract(), !javaMethod.isFinal());
        DescriptorVisibility descriptorVisibility = UtilsKt.toDescriptorVisibility(javaMethod.getVisibility());
        if (resolveMethodSignature.getReceiverType() != null) {
            map = q.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt___CollectionsKt.first((List<? extends Object>) resolveValueParameters.getDescriptors())));
        } else {
            map = r.emptyMap();
        }
        createJavaMethod.initialize(receiverParameterDescriptor, dispatchReceiverParameter, typeParameters2, valueParameters, returnType, convertFromFlags, descriptorVisibility, map);
        createJavaMethod.setParameterNamesStatus(resolveMethodSignature.getHasStableParameterNames(), resolveValueParameters.getHasSynthesizedNames());
        if (!resolveMethodSignature.getErrors().isEmpty()) {
            childForMethod$default.getComponents().getSignaturePropagator().reportSignatureErrors(createJavaMethod, resolveMethodSignature.getErrors());
        }
        return createJavaMethod;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0122  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.ResolvedValueParameters resolveValueParameters(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r23, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r24, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> r25) {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.resolveValueParameters(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$ResolvedValueParameters");
    }

    @NotNull
    public String toString() {
        return Intrinsics.stringPlus("Lazy scope for ", getOwnerDescriptor());
    }

    public LazyJavaScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @Nullable LazyJavaScope lazyJavaScope) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        this.a = lazyJavaResolverContext;
        this.b = lazyJavaScope;
        this.c = lazyJavaResolverContext.getStorageManager().createRecursionTolerantLazyValue(new a(this), CollectionsKt__CollectionsKt.emptyList());
        this.d = lazyJavaResolverContext.getStorageManager().createLazyValue(new e(this));
        this.e = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new d(this));
        this.f = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new c(this));
        this.g = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new g(this));
        this.h = lazyJavaResolverContext.getStorageManager().createLazyValue(new f(this));
        this.i = lazyJavaResolverContext.getStorageManager().createLazyValue(new i(this));
        this.j = lazyJavaResolverContext.getStorageManager().createLazyValue(new b(this));
        this.k = lazyJavaResolverContext.getStorageManager().createMemoizedFunction(new h(this));
    }
}
