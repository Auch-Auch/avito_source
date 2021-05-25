package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    public static final /* synthetic */ KProperty<Object>[] m = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    @NotNull
    public final JavaPackage f;
    @NotNull
    public final LazyJavaResolverContext g;
    @NotNull
    public final NotNullLazyValue h;
    @NotNull
    public final JvmPackageScope i;
    @NotNull
    public final NotNullLazyValue<List<FqName>> j;
    @NotNull
    public final Annotations k;
    @NotNull
    public final NotNullLazyValue l;

    public static final class a extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
        public final /* synthetic */ LazyJavaPackageFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaPackageFragment lazyJavaPackageFragment) {
            super(0);
            this.a = lazyJavaPackageFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Map<String, ? extends KotlinJvmBinaryClass> invoke() {
            PackagePartProvider packagePartProvider = this.a.g.getComponents().getPackagePartProvider();
            String asString = this.a.getFqName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
            List<String> findPackageParts = packagePartProvider.findPackageParts(asString);
            LazyJavaPackageFragment lazyJavaPackageFragment = this.a;
            ArrayList arrayList = new ArrayList();
            for (T t : findPackageParts) {
                ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(t).getFqNameForTopLevelClassMaybeWithDollars());
                Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaPackageFragment.g.getComponents().getKotlinClassFinder(), classId);
                Pair pair = findKotlinClass == null ? null : TuplesKt.to(t, findKotlinClass);
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return r.toMap(arrayList);
        }
    }

    public static final class b extends Lambda implements Function0<List<? extends FqName>> {
        public final /* synthetic */ LazyJavaPackageFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyJavaPackageFragment lazyJavaPackageFragment) {
            super(0);
            this.a = lazyJavaPackageFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends FqName> invoke() {
            Collection<JavaPackage> subPackages = this.a.f.getSubPackages();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(subPackages, 10));
            Iterator<T> it = subPackages.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFqName());
            }
            return arrayList;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage) {
        super(lazyJavaResolverContext.getModule(), javaPackage.getFqName());
        Annotations annotations;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        this.f = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, null, 0, 6, null);
        this.g = childForClassOrPackage$default;
        this.h = childForClassOrPackage$default.getStorageManager().createLazyValue(new a(this));
        this.i = new JvmPackageScope(childForClassOrPackage$default, javaPackage, this);
        this.j = childForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new b(this), CollectionsKt__CollectionsKt.emptyList());
        if (childForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            annotations = Annotations.Companion.getEMPTY();
        } else {
            annotations = LazyJavaAnnotationsKt.resolveAnnotations(childForClassOrPackage$default, javaPackage);
        }
        this.k = annotations;
        this.l = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0<HashMap<JvmClassName, JvmClassName>>(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$partToFacade$2
            public final /* synthetic */ LazyJavaPackageFragment a;

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    KotlinClassHeader.Kind.values();
                    int[] iArr = new int[6];
                    KotlinClassHeader.Kind kind = KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
                    iArr[5] = 1;
                    KotlinClassHeader.Kind kind2 = KotlinClassHeader.Kind.FILE_FACADE;
                    iArr[2] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public HashMap<JvmClassName, JvmClassName> invoke() {
                String multifileClassName;
                HashMap<JvmClassName, JvmClassName> hashMap = new HashMap<>();
                for (Map.Entry<String, KotlinJvmBinaryClass> entry : this.a.getBinaryClasses$descriptors_jvm().entrySet()) {
                    JvmClassName byInternalName = JvmClassName.byInternalName(entry.getKey());
                    Intrinsics.checkNotNullExpressionValue(byInternalName, "byInternalName(partInternalName)");
                    KotlinClassHeader classHeader = entry.getValue().getClassHeader();
                    int ordinal = classHeader.getKind().ordinal();
                    if (ordinal == 2) {
                        hashMap.put(byInternalName, byInternalName);
                    } else if (ordinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                        JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                        Intrinsics.checkNotNullExpressionValue(byInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                        hashMap.put(byInternalName, byInternalName2);
                    }
                }
                return hashMap;
            }
        });
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        return this.i.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.k;
    }

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.h, this, m[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    @NotNull
    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return (List) this.j.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    @NotNull
    public String toString() {
        return Intrinsics.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public JvmPackageScope getMemberScope() {
        return this.i;
    }
}
