package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.d;
import t6.n.x;
import t6.n.y;
import t6.r.a.j;
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty<Object>[] d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    @NotNull
    public static final FqName e = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
    @NotNull
    public static final Name f;
    @NotNull
    public static final ClassId g;
    @NotNull
    public final ModuleDescriptor a;
    @NotNull
    public final Function1<ModuleDescriptor, DeclarationDescriptor> b;
    @NotNull
    public final NotNullLazyValue c;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.g;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<ModuleDescriptor, BuiltInsPackageFragment> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public BuiltInsPackageFragment invoke(ModuleDescriptor moduleDescriptor) {
            ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
            Intrinsics.checkNotNullParameter(moduleDescriptor2, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
            List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(JvmBuiltInClassDescriptorFactory.e).getFragments();
            ArrayList arrayList = new ArrayList();
            for (T t : fragments) {
                if (t instanceof BuiltInsPackageFragment) {
                    arrayList.add(t);
                }
            }
            return (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        }
    }

    public static final class b extends Lambda implements Function0<ClassDescriptorImpl> {
        public final /* synthetic */ JvmBuiltInClassDescriptorFactory a;
        public final /* synthetic */ StorageManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
            super(0);
            this.a = jvmBuiltInClassDescriptorFactory;
            this.b = storageManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ClassDescriptorImpl invoke() {
            ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor) this.a.b.invoke(this.a.a), JvmBuiltInClassDescriptorFactory.f, Modality.ABSTRACT, ClassKind.INTERFACE, d.listOf(this.a.a.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, this.b);
            classDescriptorImpl.initialize(new CloneableClassScope(this.b, classDescriptorImpl), y.emptySet(), null);
            return classDescriptorImpl;
        }
    }

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames.cloneable;
        Name shortName = fqNameUnsafe.shortName();
        Intrinsics.checkNotNullExpressionValue(shortName, "cloneable.shortName()");
        f = shortName;
        ClassId classId = ClassId.topLevel(fqNameUnsafe.toSafe());
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        g = classId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.a = moduleDescriptor;
        this.b = function1;
        this.c = storageManager.createLazyValue(new b(this, storageManager));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (Intrinsics.areEqual(classId, Companion.getCLONEABLE_CLASS_ID())) {
            return (ClassDescriptorImpl) StorageKt.getValue(this.c, this, d[0]);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        if (Intrinsics.areEqual(fqName, e)) {
            return x.setOf((ClassDescriptorImpl) StorageKt.getValue(this.c, this, d[0]));
        }
        return y.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull FqName fqName, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual(name, f) && Intrinsics.areEqual(fqName, e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i, j jVar) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? a.a : function1);
    }
}
