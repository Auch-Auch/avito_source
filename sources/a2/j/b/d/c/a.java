package a2.j.b.d.c;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.behavior.SwipeDismissBehavior;
public class a implements AccessibilityViewCommand {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        boolean z = false;
        if (!this.a.canSwipeDismissView(view)) {
            return false;
        }
        boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
        int i = this.a.f;
        if ((i == 0 && z2) || (i == 1 && !z2)) {
            z = true;
        }
        int width = view.getWidth();
        if (z) {
            width = -width;
        }
        ViewCompat.offsetLeftAndRight(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior.OnDismissListener onDismissListener = this.a.b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(view);
        }
        return true;
    }
}
