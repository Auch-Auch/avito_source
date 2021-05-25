package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.e;
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    public static final /* synthetic */ KProperty<Object>[] g = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    @NotNull
    public final ModuleDescriptorImpl c;
    @NotNull
    public final FqName d;
    @NotNull
    public final NotNullLazyValue e;
    @NotNull
    public final MemberScope f;

    public static final class a extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
        public final /* synthetic */ LazyPackageViewDescriptorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
            super(0);
            this.a = lazyPackageViewDescriptorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends PackageFragmentDescriptor> invoke() {
            return PackageFragmentProviderKt.packageFragments(this.a.getModule().getPackageFragmentProvider(), this.a.getFqName());
        }
    }

    public static final class b extends Lambda implements Function0<MemberScope> {
        public final /* synthetic */ LazyPackageViewDescriptorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
            super(0);
            this.a = lazyPackageViewDescriptorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MemberScope invoke() {
            if (this.a.getFragments().isEmpty()) {
                return MemberScope.Empty.INSTANCE;
            }
            List<PackageFragmentDescriptor> fragments = this.a.getFragments();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMemberScope());
            }
            List plus = CollectionsKt___CollectionsKt.plus((Collection<? extends SubpackagesScope>) arrayList, new SubpackagesScope(this.a.getModule(), this.a.getFqName()));
            ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
            StringBuilder L = a2.b.a.a.a.L("package view scope for ");
            L.append(this.a.getFqName());
            L.append(" in ");
            L.append(this.a.getModule().getName());
            return companion.create(L.toString(), plus);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull FqName fqName, @NotNull StorageManager storageManager) {
        super(Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial());
        Intrinsics.checkNotNullParameter(moduleDescriptorImpl, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.c = moduleDescriptorImpl;
        this.d = fqName;
        this.e = storageManager.createLazyValue(new a(this));
        this.f = new LazyScopeAdapter(storageManager, new b(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d2);
    }

    public boolean equals(@Nullable Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        if (packageViewDescriptor != null && Intrinsics.areEqual(getFqName(), packageViewDescriptor.getFqName()) && Intrinsics.areEqual(getModule(), packageViewDescriptor.getModule())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public FqName getFqName() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.e, this, g[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        return this.f;
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return PackageViewDescriptor.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl module = getModule();
        FqName parent = getFqName().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
        return module.getPackage(parent);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public ModuleDescriptorImpl getModule() {
        return this.c;
    }
}
