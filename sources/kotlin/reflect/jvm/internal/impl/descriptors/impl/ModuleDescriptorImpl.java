package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.e;
import t6.n.r;
import t6.n.y;
import t6.r.a.j;
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    @NotNull
    public final StorageManager c;
    @NotNull
    public final KotlinBuiltIns d;
    @NotNull
    public final Map<ModuleCapability<?>, Object> e;
    @Nullable
    public ModuleDependencies f;
    @Nullable
    public PackageFragmentProvider g;
    public boolean h;
    @NotNull
    public final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> i;
    @NotNull
    public final Lazy j;

    public static final class a extends Lambda implements Function0<CompositePackageFragmentProvider> {
        public final /* synthetic */ ModuleDescriptorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ModuleDescriptorImpl moduleDescriptorImpl) {
            super(0);
            this.a = moduleDescriptorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public CompositePackageFragmentProvider invoke() {
            ModuleDependencies moduleDependencies = this.a.f;
            ModuleDescriptorImpl moduleDescriptorImpl = this.a;
            if (moduleDependencies != null) {
                List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
                allDependencies.contains(this.a);
                Iterator<T> it = allDependencies.iterator();
                while (it.hasNext()) {
                    ModuleDescriptorImpl.access$isInitialized(it.next());
                }
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(allDependencies, 10));
                Iterator<T> it2 = allDependencies.iterator();
                while (it2.hasNext()) {
                    PackageFragmentProvider packageFragmentProvider = it2.next().g;
                    Intrinsics.checkNotNull(packageFragmentProvider);
                    arrayList.add(packageFragmentProvider);
                }
                return new CompositePackageFragmentProvider(arrayList);
            }
            StringBuilder L = a2.b.a.a.a.L("Dependencies of module ");
            L.append(moduleDescriptorImpl.b());
            L.append(" were not set before querying module content");
            throw new AssertionError(L.toString());
        }
    }

    public static final class b extends Lambda implements Function1<FqName, PackageViewDescriptor> {
        public final /* synthetic */ ModuleDescriptorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ModuleDescriptorImpl moduleDescriptorImpl) {
            super(1);
            this.a = moduleDescriptorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PackageViewDescriptor invoke(FqName fqName) {
            FqName fqName2 = fqName;
            Intrinsics.checkNotNullParameter(fqName2, "fqName");
            ModuleDescriptorImpl moduleDescriptorImpl = this.a;
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName2, moduleDescriptorImpl.c);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name name, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns kotlinBuiltIns, @Nullable TargetPlatform targetPlatform) {
        this(name, storageManager, kotlinBuiltIns, targetPlatform, null, null, 48, null);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i2, j jVar) {
        this(name, storageManager, kotlinBuiltIns, (i2 & 8) != 0 ? null : targetPlatform, (i2 & 16) != 0 ? r.emptyMap() : map, (i2 & 32) != 0 ? null : name2);
    }

    public static final boolean access$isInitialized(ModuleDescriptorImpl moduleDescriptorImpl) {
        return moduleDescriptorImpl.g != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d2);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(Intrinsics.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    public final String b() {
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        return (T) this.e.get(moduleCapability);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.f;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        StringBuilder L = a2.b.a.a.a.L("Dependencies of module ");
        L.append(b());
        L.append(" were not set");
        throw new AssertionError(L.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.i.invoke(fqName);
    }

    @NotNull
    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return (CompositePackageFragmentProvider) this.j.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    public final void initialize(@NotNull PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        this.g = packageFragmentProvider;
    }

    public boolean isValid() {
        return this.h;
    }

    public final void setDependencies(@NotNull ModuleDependencies moduleDependencies) {
        Intrinsics.checkNotNullParameter(moduleDependencies, "dependencies");
        ModuleDependencies moduleDependencies2 = this.f;
        this.f = moduleDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        if (Intrinsics.areEqual(this, moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.f;
        Intrinsics.checkNotNull(moduleDependencies);
        if (!CollectionsKt___CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name name, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns kotlinBuiltIns, @Nullable TargetPlatform targetPlatform, @NotNull Map<ModuleCapability<?>, ? extends Object> map, @Nullable Name name2) {
        super(Annotations.Companion.getEMPTY(), name);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(map, "capabilities");
        this.c = storageManager;
        this.d = kotlinBuiltIns;
        if (name.isSpecial()) {
            Map<ModuleCapability<?>, Object> mutableMap = r.toMutableMap(map);
            this.e = mutableMap;
            mutableMap.put(KotlinTypeRefinerKt.getREFINER_CAPABILITY(), new Ref(null));
            this.h = true;
            this.i = storageManager.createMemoizedFunction(new b(this));
            this.j = c.lazy(new a(this));
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Module name must be special: ", name));
    }

    public final void setDependencies(@NotNull ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.checkNotNullParameter(moduleDescriptorImplArr, "descriptors");
        setDependencies(ArraysKt___ArraysKt.toList(moduleDescriptorImplArr));
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> list) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        setDependencies(list, y.emptySet());
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> list, @NotNull Set<ModuleDescriptorImpl> set) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        Intrinsics.checkNotNullParameter(set, "friends");
        setDependencies(new ModuleDependenciesImpl(list, set, CollectionsKt__CollectionsKt.emptyList(), y.emptySet()));
    }
}
