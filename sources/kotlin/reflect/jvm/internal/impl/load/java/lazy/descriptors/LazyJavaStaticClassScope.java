package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
import t6.n.h;
import t6.n.y;
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    @NotNull
    public final JavaClass m;
    @NotNull
    public final LazyJavaClassDescriptor n;

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
            return Boolean.valueOf(javaMember2.isStatic());
        }
    }

    public static final class b extends Lambda implements Function1<MemberScope, Collection<? extends PropertyDescriptor>> {
        public final /* synthetic */ Name a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Name name) {
            super(1);
            this.a = name;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends PropertyDescriptor> invoke(MemberScope memberScope) {
            MemberScope memberScope2 = memberScope;
            Intrinsics.checkNotNullParameter(memberScope2, "it");
            return memberScope2.getContributedVariables(this.a, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
        }
    }

    public static final class c extends Lambda implements Function1<MemberScope, Collection<? extends Name>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Collection<? extends Name> invoke(MemberScope memberScope) {
            MemberScope memberScope2 = memberScope;
            Intrinsics.checkNotNullParameter(memberScope2, "it");
            return memberScope2.getVariableNames();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaClass javaClass, @NotNull LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(lazyJavaResolverContext);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "ownerDescriptor");
        this.m = javaClass;
        this.n = lazyJavaClassDescriptor;
    }

    public final PropertyDescriptor a(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (T t : overriddenDescriptors) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(a(t));
        }
        return (PropertyDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) CollectionsKt___CollectionsKt.distinct(arrayList));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeClassNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return y.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        Set<Name> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = y.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.m.isEnum()) {
            mutableSet.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
        }
        return mutableSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name) {
        Set set;
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (parentJavaStaticClassScope == null) {
            set = y.emptySet();
        } else {
            set = CollectionsKt___CollectionsKt.toSet(parentJavaStaticClassScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, set, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(resolveOverridesForStaticMembers);
        if (!this.m.isEnum()) {
            return;
        }
        if (Intrinsics.areEqual(name, StandardNames.ENUM_VALUE_OF)) {
            SimpleFunctionDescriptor createEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
            Intrinsics.checkNotNullExpressionValue(createEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
            collection.add(createEnumValueOfMethod);
        } else if (Intrinsics.areEqual(name, StandardNames.ENUM_VALUES)) {
            SimpleFunctionDescriptor createEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
            Intrinsics.checkNotNullExpressionValue(createEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
            collection.add(createEnumValuesMethod);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(@NotNull Name name, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        LazyJavaClassDescriptor ownerDescriptor = getOwnerDescriptor();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DFS.dfs(d.listOf(ownerDescriptor), t6.w.f.a.m.c.a.c.a.e.a, new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ownerDescriptor, linkedHashSet, new b(name)));
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, linkedHashSet, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(resolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            PropertyDescriptor a3 = a((PropertyDescriptor) obj);
            Object obj2 = linkedHashMap.get(a3);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(a3, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Collection resolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) entry.getValue(), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            h.addAll(arrayList, resolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computePropertyNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(((DeclaredMemberIndex) getDeclaredMemberIndex().invoke()).getFieldNames());
        LazyJavaClassDescriptor ownerDescriptor = getOwnerDescriptor();
        DFS.dfs(d.listOf(ownerDescriptor), t6.w.f.a.m.c.a.c.a.e.a, new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ownerDescriptor, mutableSet, c.a));
        return mutableSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.m, a.a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.n;
    }
}
