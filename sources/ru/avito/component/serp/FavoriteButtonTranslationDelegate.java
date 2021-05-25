package ru.avito.component.serp;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lru/avito/component/serp/FavoriteButtonTranslationDelegate;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "decorationView", "", "I", "stickyRightMargin", AuthSource.BOOKING_ORDER, "photoViewType", "<init>", "(Landroid/view/View;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteButtonTranslationDelegate extends RecyclerView.ItemDecoration {
    public final View a;
    public final int b;
    public final int c;

    public FavoriteButtonTranslationDelegate(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "decorationView");
        this.a = view;
        this.b = i;
        this.c = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        float f;
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        int findLastVisiblePositionWithViewType = RecyclerViewsKt.findLastVisiblePositionWithViewType(recyclerView, this.b);
        if (findLastVisiblePositionWithViewType >= 0 && RecyclerViewsKt.getViewTypeSafe(recyclerView, findLastVisiblePositionWithViewType) == this.b) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findLastVisiblePositionWithViewType);
            View view = findViewHolderForLayoutPosition != null ? findViewHolderForLayoutPosition.itemView : null;
            if (view == null) {
                View view2 = this.a;
                view2.setX(-((float) view2.getWidth()));
                return;
            }
            int right = view.getRight() - this.c;
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            float f2 = (float) ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            boolean z = ((float) right) < ((float) recyclerView.getWidth()) - f2 && RecyclerViewsKt.nextViewType(recyclerView, findLastVisiblePositionWithViewType) != this.b;
            View view3 = this.a;
            if (z) {
                f = (float) (right - view3.getWidth());
                i = this.c;
            } else {
                f = ((float) recyclerView.getWidth()) - f2;
                i = this.a.getWidth();
            }
            view3.setX(f - ((float) i));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FavoriteButtonTranslationDelegate(View view, int i, int i2, int i3, j jVar) {
        this(view, i, (i3 & 4) != 0 ? 0 : i2);
    }
}
