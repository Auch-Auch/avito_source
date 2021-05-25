package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    @NotNull
    public static final Companion Companion = Companion.a;

    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();
        @NotNull
        public static final Annotations b = new Annotations$Companion$EMPTY$1();

        @NotNull
        public final Annotations create(@NotNull List<? extends AnnotationDescriptor> list) {
            Intrinsics.checkNotNullParameter(list, "annotations");
            return list.isEmpty() ? b : new AnnotationsImpl(list);
        }

        @NotNull
        public final Annotations getEMPTY() {
            return b;
        }
    }

    public static final class DefaultImpls {
        @Nullable
        public static AnnotationDescriptor findAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            Object obj;
            Intrinsics.checkNotNullParameter(annotations, "this");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((AnnotationDescriptor) obj).getFqName(), fqName)) {
                    break;
                }
            }
            return (AnnotationDescriptor) obj;
        }

        public static boolean hasAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(annotations, "this");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            return annotations.findAnnotation(fqName) != null;
        }
    }

    @Nullable
    AnnotationDescriptor findAnnotation(@NotNull FqName fqName);

    boolean hasAnnotation(@NotNull FqName fqName);

    boolean isEmpty();
}
