package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class LazyJavaAnnotations implements Annotations {
    @NotNull
    public final LazyJavaResolverContext a;
    @NotNull
    public final JavaAnnotationOwner b;
    public final boolean c;
    @NotNull
    public final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> d;

    public static final class a extends Lambda implements Function1<JavaAnnotation, AnnotationDescriptor> {
        public final /* synthetic */ LazyJavaAnnotations a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LazyJavaAnnotations lazyJavaAnnotations) {
            super(1);
            this.a = lazyJavaAnnotations;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AnnotationDescriptor invoke(JavaAnnotation javaAnnotation) {
            JavaAnnotation javaAnnotation2 = javaAnnotation;
            Intrinsics.checkNotNullParameter(javaAnnotation2, "annotation");
            return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(javaAnnotation2, this.a.a, this.a.c);
        }
    }

    public LazyJavaAnnotations(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaAnnotationOwner javaAnnotationOwner, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationOwner");
        this.a = lazyJavaResolverContext;
        this.b = javaAnnotationOwner;
        this.c = z;
        this.d = lazyJavaResolverContext.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new a(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        JavaAnnotation findAnnotation = this.b.findAnnotation(fqName);
        AnnotationDescriptor invoke = findAnnotation == null ? null : this.d.invoke(findAnnotation);
        return invoke == null ? JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.b, this.a) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.b.getAnnotations().isEmpty() && !this.b.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.plus(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.b.getAnnotations()), this.d), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.b, this.a))).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, j jVar) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }
}
