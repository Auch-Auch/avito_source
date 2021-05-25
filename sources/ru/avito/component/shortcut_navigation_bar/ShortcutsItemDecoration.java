package ru.avito.component.shortcut_navigation_bar;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0017\u001a\u00020\r\u0012\b\b\u0003\u0010\u0018\u001a\u00020\r\u0012\b\b\u0003\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u001c"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/ShortcutsItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "halfBetweenPadding", "c", "verticalPadding", AuthSource.SEND_ABUSE, "edgePadding", "Landroid/content/res/Resources;", "resources", "edgePaddingRes", "halfBetweenPaddingRes", "verticalPaddingRes", "<init>", "(Landroid/content/res/Resources;III)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutsItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortcutsItemDecoration(Resources resources, int i, int i2, int i3, int i4, j jVar) {
        this(resources, (i4 & 2) != 0 ? R.dimen.main_edge_shortcuts_padding : i, (i4 & 4) != 0 ? R.dimen.main_shortcuts_padding : i2, (i4 & 8) != 0 ? R.dimen.main_vertical_shortcuts_padding : i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            rect.left = childAdapterPosition == 0 ? this.a : this.b;
            rect.right = childAdapterPosition == adapter.getItemCount() + -1 ? this.a : this.b;
            int i = this.c;
            rect.top = i;
            rect.bottom = i;
        }
    }

    public ShortcutsItemDecoration(@NotNull Resources resources, @DimenRes int i, @DimenRes int i2, @DimenRes int i3) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources.getDimensionPixelOffset(i);
        this.b = resources.getDimensionPixelOffset(i2);
        this.c = resources.getDimensionPixelOffset(i3);
    }
}
