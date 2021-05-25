package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.DocumentType;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.x;
import t6.n.y;
import t6.v.e;
public final class NotFoundClasses {
    @NotNull
    public final StorageManager a;
    @NotNull
    public final ModuleDescriptor b;
    @NotNull
    public final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> c;
    @NotNull
    public final MemoizedFunctionToNotNull<a, ClassDescriptor> d;

    public static final class MockClassDescriptor extends ClassDescriptorBase {
        public final boolean g;
        @NotNull
        public final List<TypeParameterDescriptor> h;
        @NotNull
        public final ClassTypeConstructorImpl i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MockClassDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Name name, boolean z, int i2) {
            super(storageManager, declarationDescriptor, name, SourceElement.NO_SOURCE, false);
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(declarationDescriptor, "container");
            Intrinsics.checkNotNullParameter(name, "name");
            this.g = z;
            IntRange until = e.until(0, i2);
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations.Companion.getEMPTY(), false, Variance.INVARIANT, Name.identifier(Intrinsics.stringPlus("T", Integer.valueOf(nextInt))), nextInt, storageManager));
            }
            this.h = arrayList;
            this.i = new ClassTypeConstructorImpl(this, TypeParameterUtilsKt.computeConstructorTypeParameters(this), x.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return y.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        @NotNull
        public DescriptorVisibility getVisibility() {
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
            Intrinsics.checkNotNullExpressionValue(descriptorVisibility, DocumentType.PUBLIC_KEY);
            return descriptorVisibility;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("class ");
            L.append(getName());
            L.append(" (not found)");
            return L.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        @NotNull
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        @NotNull
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        @NotNull
        public MemberScope.Empty getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return MemberScope.Empty.INSTANCE;
        }
    }

    public static final class a {
        @NotNull
        public final ClassId a;
        @NotNull
        public final List<Integer> b;

        public a(@NotNull ClassId classId, @NotNull List<Integer> list) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(list, "typeParametersCount");
            this.a = classId;
            this.b = list;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ClassRequest(classId=");
            L.append(this.a);
            L.append(", typeParametersCount=");
            L.append(this.b);
            L.append(')');
            return L.toString();
        }
    }

    public static final class b extends Lambda implements Function1<a, ClassDescriptor> {
        public final /* synthetic */ NotFoundClasses a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NotFoundClasses notFoundClasses) {
            super(1);
            this.a = notFoundClasses;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptor invoke(a aVar) {
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor;
            a aVar2 = aVar;
            Intrinsics.checkNotNullParameter(aVar2, "$dstr$classId$typeParametersCount");
            ClassId classId = aVar2.a;
            List<Integer> list = aVar2.b;
            if (!classId.isLocal()) {
                ClassId outerClassId = classId.getOuterClassId();
                if (outerClassId == null) {
                    classOrPackageFragmentDescriptor = null;
                } else {
                    classOrPackageFragmentDescriptor = this.a.getClass(outerClassId, CollectionsKt___CollectionsKt.drop(list, 1));
                }
                if (classOrPackageFragmentDescriptor == null) {
                    MemoizedFunctionToNotNull memoizedFunctionToNotNull = this.a.c;
                    FqName packageFqName = classId.getPackageFqName();
                    Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                    classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
                }
                boolean isNestedClass = classId.isNestedClass();
                StorageManager storageManager = this.a.a;
                Name shortClassName = classId.getShortClassName();
                Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
                Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                return new MockClassDescriptor(storageManager, classOrPackageFragmentDescriptor, shortClassName, isNestedClass, num == null ? 0 : num.intValue());
            }
            throw new UnsupportedOperationException(Intrinsics.stringPlus("Unresolved local class: ", classId));
        }
    }

    public static final class c extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public final /* synthetic */ NotFoundClasses a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NotFoundClasses notFoundClasses) {
            super(1);
            this.a = notFoundClasses;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PackageFragmentDescriptor invoke(FqName fqName) {
            FqName fqName2 = fqName;
            Intrinsics.checkNotNullParameter(fqName2, "fqName");
            return new EmptyPackageFragmentDescriptor(this.a.b, fqName2);
        }
    }

    public NotFoundClasses(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        this.a = storageManager;
        this.b = moduleDescriptor;
        this.c = storageManager.createMemoizedFunction(new c(this));
        this.d = storageManager.createMemoizedFunction(new b(this));
    }

    @NotNull
    public final ClassDescriptor getClass(@NotNull ClassId classId, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(list, "typeParametersCount");
        return this.d.invoke(new a(classId, list));
    }
}
