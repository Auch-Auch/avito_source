package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class CompositeAnnotations implements Annotations {
    @NotNull
    public final List<Annotations> a;

    public static final class a extends Lambda implements Function1<Annotations, AnnotationDescriptor> {
        public final /* synthetic */ FqName a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FqName fqName) {
            super(1);
            this.a = fqName;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AnnotationDescriptor invoke(Annotations annotations) {
            Annotations annotations2 = annotations;
            Intrinsics.checkNotNullParameter(annotations2, "it");
            return annotations2.findAnnotation(this.a);
        }
    }

    public static final class b extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Sequence<? extends AnnotationDescriptor> invoke(Annotations annotations) {
            Annotations annotations2 = annotations;
            Intrinsics.checkNotNullParameter(annotations2, "it");
            return CollectionsKt___CollectionsKt.asSequence(annotations2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(@NotNull List<? extends Annotations> list) {
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (AnnotationDescriptor) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(this.a), new a(fqName)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        for (Annotations annotations : CollectionsKt___CollectionsKt.asSequence(this.a)) {
            if (annotations.hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.flatMap(CollectionsKt___CollectionsKt.asSequence(this.a), b.a).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(@NotNull Annotations... annotationsArr) {
        this(ArraysKt___ArraysKt.toList(annotationsArr));
        Intrinsics.checkNotNullParameter(annotationsArr, "delegates");
    }
}
