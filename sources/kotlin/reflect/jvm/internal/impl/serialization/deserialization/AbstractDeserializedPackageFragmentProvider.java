package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    @NotNull
    public final StorageManager a;
    @NotNull
    public final KotlinMetadataFinder b;
    @NotNull
    public final ModuleDescriptor c;
    public DeserializationComponents components;
    @NotNull
    public final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> d;

    public static final class a extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public final /* synthetic */ AbstractDeserializedPackageFragmentProvider a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
            super(1);
            this.a = abstractDeserializedPackageFragmentProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PackageFragmentDescriptor invoke(FqName fqName) {
            FqName fqName2 = fqName;
            Intrinsics.checkNotNullParameter(fqName2, "fqName");
            DeserializedPackageFragment findPackage = this.a.findPackage(fqName2);
            if (findPackage == null) {
                return null;
            }
            findPackage.initialize(this.a.getComponents());
            return findPackage;
        }
    }

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder kotlinMetadataFinder, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        this.a = storageManager;
        this.b = kotlinMetadataFinder;
        this.c = moduleDescriptor;
        this.d = storageManager.createMemoizedFunctionWithNullableValues(new a(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        CollectionsKt.addIfNotNull(collection, this.d.invoke(fqName));
    }

    @Nullable
    public abstract DeserializedPackageFragment findPackage(@NotNull FqName fqName);

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    @NotNull
    public final KotlinMetadataFinder getFinder() {
        return this.b;
    }

    @NotNull
    public final ModuleDescriptor getModuleDescriptor() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt__CollectionsKt.listOfNotNull(this.d.invoke(fqName));
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return y.emptySet();
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }
}
