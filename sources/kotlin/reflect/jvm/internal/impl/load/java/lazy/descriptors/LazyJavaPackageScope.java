package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.r.a.j;
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    @NotNull
    public final JavaPackage m;
    @NotNull
    public final LazyJavaPackageFragment n;
    @NotNull
    public final NullableLazyValue<Set<String>> o;
    @NotNull
    public final MemoizedFunctionToNullable<a, ClassDescriptor> p;

    public static abstract class KotlinClassLookupResult {

        public static final class Found extends KotlinClassLookupResult {
            @NotNull
            public final ClassDescriptor a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Found(@NotNull ClassDescriptor classDescriptor) {
                super(null);
                Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
                this.a = classDescriptor;
            }

            @NotNull
            public final ClassDescriptor getDescriptor() {
                return this.a;
            }
        }

        public static final class NotFound extends KotlinClassLookupResult {
            @NotNull
            public static final NotFound INSTANCE = new NotFound();

            public NotFound() {
                super(null);
            }
        }

        public static final class SyntheticClass extends KotlinClassLookupResult {
            @NotNull
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            public SyntheticClass() {
                super(null);
            }
        }

        public KotlinClassLookupResult(j jVar) {
        }
    }

    public static final class a {
        @NotNull
        public final Name a;
        @Nullable
        public final JavaClass b;

        public a(@NotNull Name name, @Nullable JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.a = name;
            this.b = javaClass;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class b extends Lambda implements Function1<a, ClassDescriptor> {
        public final /* synthetic */ LazyJavaPackageScope a;
        public final /* synthetic */ LazyJavaResolverContext b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
            super(1);
            this.a = lazyJavaPackageScope;
            this.b = lazyJavaResolverContext;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptor invoke(a aVar) {
            KotlinClassFinder.Result result;
            KotlinJvmBinaryClass kotlinJvmBinaryClass;
            ClassId classId;
            LightClassOriginKind lightClassOriginKind;
            FqName fqName;
            byte[] bArr;
            a aVar2 = aVar;
            Intrinsics.checkNotNullParameter(aVar2, "request");
            ClassId classId2 = new ClassId(this.a.getOwnerDescriptor().getFqName(), aVar2.a);
            if (aVar2.b != null) {
                result = this.b.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar2.b);
            } else {
                result = this.b.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId2);
            }
            if (result == null) {
                kotlinJvmBinaryClass = null;
            } else {
                kotlinJvmBinaryClass = result.toKotlinJvmBinaryClass();
            }
            if (kotlinJvmBinaryClass == null) {
                classId = null;
            } else {
                classId = kotlinJvmBinaryClass.getClassId();
            }
            if (classId != null && (classId.isNestedClass() || classId.isLocal())) {
                return null;
            }
            KotlinClassLookupResult access$resolveKotlinBinaryClass = LazyJavaPackageScope.access$resolveKotlinBinaryClass(this.a, kotlinJvmBinaryClass);
            if (access$resolveKotlinBinaryClass instanceof KotlinClassLookupResult.Found) {
                return ((KotlinClassLookupResult.Found) access$resolveKotlinBinaryClass).getDescriptor();
            }
            if (access$resolveKotlinBinaryClass instanceof KotlinClassLookupResult.SyntheticClass) {
                return null;
            }
            if (access$resolveKotlinBinaryClass instanceof KotlinClassLookupResult.NotFound) {
                JavaClass javaClass = aVar2.b;
                if (javaClass == null) {
                    JavaClassFinder finder = this.b.getComponents().getFinder();
                    if (result != null) {
                        if (!(result instanceof KotlinClassFinder.Result.ClassFileContent)) {
                            result = null;
                        }
                        KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) result;
                        if (classFileContent != null) {
                            bArr = classFileContent.getContent();
                            javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, null, 4, null));
                        }
                    }
                    bArr = null;
                    javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, null, 4, null));
                }
                if (javaClass == null) {
                    lightClassOriginKind = null;
                } else {
                    lightClassOriginKind = javaClass.getLightClassOriginKind();
                }
                if (lightClassOriginKind != LightClassOriginKind.BINARY) {
                    if (javaClass == null) {
                        fqName = null;
                    } else {
                        fqName = javaClass.getFqName();
                    }
                    if (fqName == null || fqName.isRoot() || !Intrinsics.areEqual(fqName.parent(), this.a.getOwnerDescriptor().getFqName())) {
                        return null;
                    }
                    LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.b, this.a.getOwnerDescriptor(), javaClass, null, 8, null);
                    this.b.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                    return lazyJavaClassDescriptor;
                }
                throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass + "\nClassId: " + classId2 + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(this.b.getComponents().getKotlinClassFinder(), javaClass) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(this.b.getComponents().getKotlinClassFinder(), classId2) + '\n');
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c extends Lambda implements Function0<Set<? extends String>> {
        public final /* synthetic */ LazyJavaResolverContext a;
        public final /* synthetic */ LazyJavaPackageScope b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(LazyJavaResolverContext lazyJavaResolverContext, LazyJavaPackageScope lazyJavaPackageScope) {
            super(0);
            this.a = lazyJavaResolverContext;
            this.b = lazyJavaPackageScope;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Set<? extends String> invoke() {
            return this.a.getComponents().getFinder().knownClassNamesInPackage(this.b.getOwnerDescriptor().getFqName());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaPackage javaPackage, @NotNull LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(lazyJavaResolverContext);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "ownerDescriptor");
        this.m = javaPackage;
        this.n = lazyJavaPackageFragment;
        this.o = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new c(lazyJavaResolverContext, this));
        this.p = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new b(this, lazyJavaResolverContext));
    }

    public static final KotlinClassLookupResult access$resolveKotlinBinaryClass(LazyJavaPackageScope lazyJavaPackageScope, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(lazyJavaPackageScope);
        if (kotlinJvmBinaryClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) {
            return KotlinClassLookupResult.SyntheticClass.INSTANCE;
        }
        ClassDescriptor resolveClass = lazyJavaPackageScope.getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
        return resolveClass != null ? new KotlinClassLookupResult.Found(resolveClass) : KotlinClassLookupResult.NotFound.INSTANCE;
    }

    public final ClassDescriptor a(Name name, JavaClass javaClass) {
        if (!SpecialNames.isSafeIdentifier(name)) {
            return null;
        }
        Set set = (Set) this.o.invoke();
        if (javaClass != null || set == null || set.contains(name.asString())) {
            return this.p.invoke(new a(name, javaClass));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeClassNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return y.emptySet();
        }
        Set<String> set = (Set) this.o.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            for (String str : set) {
                hashSet.add(Name.identifier(str));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.m;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        Collection<JavaClass> classes = javaPackage.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : classes) {
            Name name = t.getLightClassOriginKind() == LightClassOriginKind.SOURCE ? null : t.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return y.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull Name name) {
        Intrinsics.checkNotNullParameter(collection, "result");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<Name> computePropertyNames(@NotNull DescriptorKindFilter descriptorKindFilter, @Nullable Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return y.emptySet();
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(@NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return a(javaClass.getName(), javaClass);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter$Companion r0 = kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion
            int r1 = r0.getCLASSIFIERS_MASK()
            int r0 = r0.getNON_SINGLETON_CLASSIFIERS_MASK()
            r0 = r0 | r1
            boolean r5 = r5.acceptsKinds(r0)
            if (r5 != 0) goto L_0x0020
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0065
        L_0x0020:
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r5 = r4.getAllDescriptors()
            java.lang.Object r5 = r5.invoke()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0033:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r5.next()
            r2 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getName()
            java.lang.String r3 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object r2 = r6.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x005d
            r2 = 1
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 == 0) goto L_0x0033
            r0.add(r1)
            goto L_0x0033
        L_0x0064:
            r5 = r0
        L_0x0065:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return a(name, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.n;
    }
}
