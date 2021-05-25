package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    @NotNull
    public final Collection<PackageFragmentDescriptor> a;

    public static final class a extends Lambda implements Function1<PackageFragmentDescriptor, FqName> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public FqName invoke(PackageFragmentDescriptor packageFragmentDescriptor) {
            PackageFragmentDescriptor packageFragmentDescriptor2 = packageFragmentDescriptor;
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor2, "it");
            return packageFragmentDescriptor2.getFqName();
        }
    }

    public static final class b extends Lambda implements Function1<FqName, Boolean> {
        public final /* synthetic */ FqName a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FqName fqName) {
            super(1);
            this.a = fqName;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(FqName fqName) {
            FqName fqName2 = fqName;
            Intrinsics.checkNotNullParameter(fqName2, "it");
            return Boolean.valueOf(!fqName2.isRoot() && Intrinsics.areEqual(fqName2.parent(), this.a));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        this.a = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        for (PackageFragmentDescriptor packageFragmentDescriptor : this.a) {
            if (Intrinsics.areEqual(packageFragmentDescriptor.getFqName(), fqName)) {
                collection.add(packageFragmentDescriptor);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            if (Intrinsics.areEqual(t.getFqName(), fqName)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.a), a.a), new b(fqName)));
    }
}
