package a2.a.a.k2.b.h;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a extends ViewOutlineProvider {
    @Nullable
    public View a;
    public int b;

    @Override // android.view.ViewOutlineProvider
    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        View view2 = this.a;
        if (view2 == null) {
            view2 = view;
        }
        if (view2.getTop() > 0) {
            if (this.b == 0) {
                this.b = Views.dpToPx(view, 15);
            }
            int paddingTop = view.getPaddingTop();
            int width = view.getWidth();
            int height = view.getHeight();
            int i = this.b;
            outline.setRoundRect(0, paddingTop, width, height + i, (float) i);
            return;
        }
        outline.setRect(0, -view2.getPaddingTop(), view.getWidth(), view.getHeight());
        outline.setAlpha(0.0f);
    }
}
