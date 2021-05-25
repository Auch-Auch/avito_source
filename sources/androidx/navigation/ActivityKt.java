package androidx.navigation;

import android.app.Activity;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/app/Activity;", "", "viewId", "Landroidx/navigation/NavController;", "findNavController", "(Landroid/app/Activity;I)Landroidx/navigation/NavController;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ActivityKt {
    @NotNull
    public static final NavController findNavController(@NotNull Activity activity, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$findNavController");
        NavController findNavController = Navigation.findNavController(activity, i);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavController(this, viewId)");
        return findNavController;
    }
}
