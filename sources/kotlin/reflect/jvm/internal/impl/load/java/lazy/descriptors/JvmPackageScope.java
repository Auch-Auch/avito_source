package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
import t6.n.y;
public final class JvmPackageScope implements MemberScope {
    public static final /* synthetic */ KProperty<Object>[] e = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull
    public final LazyJavaResolverContext a;
    @NotNull
    public final LazyJavaPackageFragment b;
    @NotNull
    public final LazyJavaPackageScope c;
    @NotNull
    public final NotNullLazyValue d;

    public static final class a extends Lambda implements Function0<MemberScope[]> {
        public final /* synthetic */ JvmPackageScope a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JvmPackageScope jvmPackageScope) {
            super(0);
            this.a = jvmPackageScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MemberScope[] invoke() {
            Collection<KotlinJvmBinaryClass> values = this.a.b.getBinaryClasses$descriptors_jvm().values();
            JvmPackageScope jvmPackageScope = this.a;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                MemberScope createKotlinPackagePartScope = jvmPackageScope.a.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(jvmPackageScope.b, it.next());
                if (createKotlinPackagePartScope != null) {
                    arrayList.add(createKotlinPackagePartScope);
                }
            }
            Object[] array = ScopeUtilsKt.listOfNonEmptyScopes(arrayList).toArray(new MemberScope[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (MemberScope[]) array;
        }
    }

    public JvmPackageScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.a = lazyJavaResolverContext;
        this.b = lazyJavaPackageFragment;
        this.c = new LazyJavaPackageScope(lazyJavaResolverContext, javaPackage, lazyJavaPackageFragment);
        this.d = lazyJavaResolverContext.getStorageManager().createLazyValue(new a(this));
    }

    public final MemberScope[] a() {
        return (MemberScope[]) StorageKt.getValue(this.d, this, e[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<Name> getClassifierNames() {
        Set<Name> flatMapClassifierNamesOrNull = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt___ArraysKt.asIterable(a()));
        if (flatMapClassifierNamesOrNull == null) {
            return null;
        }
        flatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return flatMapClassifierNamesOrNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        ClassDescriptor contributedClassifier = this.c.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        MemberScope[] a3 = a();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = a3.length;
        while (i < length) {
            MemberScope memberScope = a3[i];
            i++;
            ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] a3 = a();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(descriptorKindFilter, function1);
        int length = a3.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = a3[i];
            i++;
            contributedDescriptors = ScopeUtilsKt.concat(contributedDescriptors, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        return contributedDescriptors == null ? y.emptySet() : contributedDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] a3 = a();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation);
        int length = a3.length;
        int i = 0;
        Collection collection = contributedFunctions;
        while (i < length) {
            MemberScope memberScope = a3[i];
            i++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, lookupLocation));
        }
        return collection == null ? y.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.c;
        MemberScope[] a3 = a();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation);
        int length = a3.length;
        int i = 0;
        Collection collection = contributedVariables;
        while (i < length) {
            MemberScope memberScope = a3[i];
            i++;
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, lookupLocation));
        }
        return collection == null ? y.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getFunctionNames() {
        MemberScope[] a3 = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : a3) {
            h.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    @NotNull
    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<Name> getVariableNames() {
        MemberScope[] a3 = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : a3) {
            h.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        UtilsKt.record(this.a.getComponents().getLookupTracker(), lookupLocation, this.b, name);
    }
}
