package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.e;
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    @NotNull
    public final BinaryVersion g;
    @Nullable
    public final DeserializedContainerSource h;
    @NotNull
    public final NameResolverImpl i;
    @NotNull
    public final ProtoBasedClassDataFinder j;
    @Nullable
    public ProtoBuf.PackageFragment k;
    public MemberScope l;

    public static final class a extends Lambda implements Function1<ClassId, SourceElement> {
        public final /* synthetic */ DeserializedPackageFragmentImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
            super(1);
            this.a = deserializedPackageFragmentImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SourceElement invoke(ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "it");
            DeserializedContainerSource deserializedContainerSource = this.a.h;
            if (deserializedContainerSource != null) {
                return deserializedContainerSource;
            }
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return sourceElement;
        }
    }

    public static final class b extends Lambda implements Function0<Collection<? extends Name>> {
        public final /* synthetic */ DeserializedPackageFragmentImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
            super(0);
            this.a = deserializedPackageFragmentImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<? extends Name> invoke() {
            Collection<ClassId> allClassIds = this.a.getClassDataFinder().getAllClassIds();
            ArrayList arrayList = new ArrayList();
            for (T t : allClassIds) {
                T t2 = t;
                if (!t2.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(t2)) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ClassId) it.next()).getShortClassName());
            }
            return arrayList2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(@NotNull FqName fqName, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ProtoBuf.PackageFragment packageFragment, @NotNull BinaryVersion binaryVersion, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, moduleDescriptor);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        Intrinsics.checkNotNullParameter(packageFragment, "proto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        this.g = binaryVersion;
        this.h = deserializedContainerSource;
        ProtoBuf.StringTable strings = packageFragment.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = packageFragment.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.i = nameResolverImpl;
        this.j = new ProtoBasedClassDataFinder(packageFragment, nameResolverImpl, binaryVersion, new a(this));
        this.k = packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope = this.l;
        if (memberScope != null) {
            return memberScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        ProtoBuf.PackageFragment packageFragment = this.k;
        if (packageFragment != null) {
            this.k = null;
            ProtoBuf.Package r4 = packageFragment.getPackage();
            Intrinsics.checkNotNullExpressionValue(r4, "proto.`package`");
            this.l = new DeserializedPackageMemberScope(this, r4, this.i, this.g, this.h, deserializationComponents, new b(this));
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    @NotNull
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.j;
    }
}
