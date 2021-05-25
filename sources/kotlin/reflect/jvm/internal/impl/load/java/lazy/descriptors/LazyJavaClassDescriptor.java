package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.y;
import t6.r.a.j;
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final LazyJavaResolverContext g;
    @NotNull
    public final JavaClass h;
    @Nullable
    public final ClassDescriptor i;
    @NotNull
    public final LazyJavaResolverContext j;
    @NotNull
    public final ClassKind k;
    @NotNull
    public final Modality l;
    @NotNull
    public final Visibility m;
    public final boolean n;
    @NotNull
    public final a o;
    @NotNull
    public final LazyJavaClassMemberScope p;
    @NotNull
    public final ScopesHolderForClass<LazyJavaClassMemberScope> q;
    @NotNull
    public final InnerClassesScopeWrapper r;
    @NotNull
    public final LazyJavaStaticClassScope s;
    @NotNull
    public final Annotations t;
    @NotNull
    public final NotNullLazyValue<List<TypeParameterDescriptor>> u;

    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public final class a extends AbstractClassTypeConstructor {
        @NotNull
        public final NotNullLazyValue<List<TypeParameterDescriptor>> c;
        public final /* synthetic */ LazyJavaClassDescriptor d;

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$a$a  reason: collision with other inner class name */
        public static final class C0509a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
            public final /* synthetic */ LazyJavaClassDescriptor a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0509a(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
                super(0);
                this.a = lazyJavaClassDescriptor;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends TypeParameterDescriptor> invoke() {
                return TypeParameterUtilsKt.computeConstructorTypeParameters(this.a);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(lazyJavaClassDescriptor.j.getStorageManager());
            Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "this$0");
            this.d = lazyJavaClassDescriptor;
            this.c = lazyJavaClassDescriptor.j.getStorageManager().createLazyValue(new C0509a(lazyJavaClassDescriptor));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
            if ((!r6.isRoot() && r6.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) != false) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
            if (r8 == null) goto L_0x0087;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01d4  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0211  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0216  */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            /*
            // Method dump skipped, instructions count: 557
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.a.computeSupertypes():java.util.Collection");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo425getDeclarationDescriptor() {
            return this.d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.c.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return this.d.j.getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @NotNull
        public String toString() {
            String asString = this.d.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
            return asString;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
        public ClassifierDescriptor mo425getDeclarationDescriptor() {
            return this.d;
        }
    }

    public static final class b extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
        public final /* synthetic */ LazyJavaClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(0);
            this.a = lazyJavaClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends TypeParameterDescriptor> invoke() {
            List<JavaTypeParameter> typeParameters = this.a.getJClass().getTypeParameters();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(typeParameters, 10));
            for (T t : typeParameters) {
                TypeParameterDescriptor resolveTypeParameter = lazyJavaClassDescriptor.j.getTypeParameterResolver().resolveTypeParameter(t);
                if (resolveTypeParameter != null) {
                    arrayList.add(resolveTypeParameter);
                } else {
                    throw new AssertionError("Parameter " + ((Object) t) + " surely belongs to class " + lazyJavaClassDescriptor.getJClass() + ", so it must be resolved");
                }
            }
            return arrayList;
        }
    }

    public static final class c extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope> {
        public final /* synthetic */ LazyJavaClassDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(1);
            this.a = lazyJavaClassDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LazyJavaClassMemberScope invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "it");
            LazyJavaResolverContext lazyJavaResolverContext = this.a.j;
            LazyJavaClassDescriptor lazyJavaClassDescriptor = this.a;
            return new LazyJavaClassMemberScope(lazyJavaResolverContext, lazyJavaClassDescriptor, lazyJavaClassDescriptor.getJClass(), this.a.i != null, this.a.p);
        }
    }

    static {
        y.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i2, j jVar) {
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, (i2 & 8) != 0 ? null : classDescriptor);
    }

    @NotNull
    public final LazyJavaClassDescriptor copy$descriptors_jvm(@NotNull JavaResolverCache javaResolverCache, @Nullable ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = this.j;
        LazyJavaResolverContext replaceComponents = ContextKt.replaceComponents(lazyJavaResolverContext, lazyJavaResolverContext.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(replaceComponents, containingDeclaration, this.h, classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List) this.u.invoke();
    }

    @NotNull
    public final JavaClass getJClass() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.l != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
        Collection<JavaClassifierType> permittedTypes = this.h.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = permittedTypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = this.j.getTypeResolver().transformJavaType(it.next(), attributes$default).getConstructor().mo425getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        if (!Intrinsics.areEqual(this.m, DescriptorVisibilities.PRIVATE) || this.h.getOuterClass() != null) {
            return UtilsKt.toDescriptorVisibility(this.m);
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
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
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    @NotNull
    public String toString() {
        return Intrinsics.stringPlus("Lazy Java class ", DescriptorUtilsKt.getFqNameUnsafe(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaClass javaClass, @Nullable ClassDescriptor classDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, javaClass.getName(), lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaClass), false);
        ClassKind classKind;
        Modality modality;
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        this.g = lazyJavaResolverContext;
        this.h = javaClass;
        this.i = classDescriptor;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, javaClass, 0, 4, null);
        this.j = childForClassOrPackage$default;
        childForClassOrPackage$default.getComponents().getJavaResolverCache().recordClass(javaClass, this);
        javaClass.getLightClassOriginKind();
        if (javaClass.isAnnotationType()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (javaClass.isInterface()) {
            classKind = ClassKind.INTERFACE;
        } else if (javaClass.isEnum()) {
            classKind = ClassKind.ENUM_CLASS;
        } else {
            classKind = ClassKind.CLASS;
        }
        this.k = classKind;
        if (javaClass.isAnnotationType() || javaClass.isEnum()) {
            modality = Modality.FINAL;
        } else {
            modality = Modality.Companion.convertFromFlags(false, javaClass.isSealed() || javaClass.isAbstract() || javaClass.isInterface(), !javaClass.isFinal());
        }
        this.l = modality;
        this.m = javaClass.getVisibility();
        this.n = javaClass.getOuterClass() != null && !javaClass.isStatic();
        this.o = new a(this);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(childForClassOrPackage$default, this, javaClass, classDescriptor != null, null, 16, null);
        this.p = lazyJavaClassMemberScope;
        this.q = ScopesHolderForClass.Companion.create(this, childForClassOrPackage$default.getStorageManager(), childForClassOrPackage$default.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new c(this));
        this.r = new InnerClassesScopeWrapper(lazyJavaClassMemberScope);
        this.s = new LazyJavaStaticClassScope(childForClassOrPackage$default, javaClass, this);
        this.t = LazyJavaAnnotationsKt.resolveAnnotations(childForClassOrPackage$default, javaClass);
        this.u = childForClassOrPackage$default.getStorageManager().createLazyValue(new b(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return (List) this.p.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    @NotNull
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.q.getScope(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope) super.getUnsubstitutedMemberScope();
    }
}
