package kotlin.reflect.jvm.internal.impl.types.model;

import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public interface TypeSystemOptimizationContext {

    public static final class DefaultImpls {
        public static boolean identicalArguments(@NotNull TypeSystemOptimizationContext typeSystemOptimizationContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(typeSystemOptimizationContext, "this");
            Intrinsics.checkNotNullParameter(simpleTypeMarker, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, AuthSource.BOOKING_ORDER);
            return false;
        }
    }

    boolean identicalArguments(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2);
}
