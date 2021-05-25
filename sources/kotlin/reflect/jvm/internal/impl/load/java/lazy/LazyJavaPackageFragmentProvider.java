package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import t6.d;
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    public final LazyJavaResolverContext a;
    @NotNull
    public final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> b;

    public static final class a extends Lambda implements Function0<LazyJavaPackageFragment> {
        public final /* synthetic */ LazyJavaPackageFragmentProvider a;
        public final /* synthetic */ JavaPackage b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaPackage javaPackage) {
            super(0);
            this.a = lazyJavaPackageFragmentProvider;
            this.b = javaPackage;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public LazyJavaPackageFragment invoke() {
            return new LazyJavaPackageFragment(this.a.a, this.b);
        }
    }

    public LazyJavaPackageFragmentProvider(@NotNull JavaResolverComponents javaResolverComponents) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        LazyJavaResolverContext lazyJavaResolverContext = new LazyJavaResolverContext(javaResolverComponents, TypeParameterResolver.EMPTY.INSTANCE, d.lazyOf(null));
        this.a = lazyJavaResolverContext;
        this.b = lazyJavaResolverContext.getStorageManager().createCacheWithNotNullValues();
    }

    public final LazyJavaPackageFragment a(FqName fqName) {
        JavaPackage findPackage = this.a.getComponents().getFinder().findPackage(fqName);
        if (findPackage == null) {
            return null;
        }
        return this.b.computeIfAbsent(fqName, new a(this, findPackage));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        CollectionsKt.addIfNotNull(collection, a(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<LazyJavaPackageFragment> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt__CollectionsKt.listOfNotNull(a(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageFragment a3 = a(fqName);
        List<FqName> subPackageFqNames$descriptors_jvm = a3 == null ? null : a3.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : CollectionsKt__CollectionsKt.emptyList();
    }
}
