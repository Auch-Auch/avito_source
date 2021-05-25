package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.avito.android.analytics.screens.InternalConstsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class AnnotationsKt {
    @NotNull
    public static final Annotations composeAnnotations(@NotNull Annotations annotations, @NotNull Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations, InternalConstsKt.FIRST_IMAGE);
        Intrinsics.checkNotNullParameter(annotations2, "second");
        if (annotations.isEmpty()) {
            return annotations2;
        }
        return annotations2.isEmpty() ? annotations : new CompositeAnnotations(annotations, annotations2);
    }
}
