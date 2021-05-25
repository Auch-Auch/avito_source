package ru.avito.component.shortcut_navigation_bar;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0019"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/RubricatorItemsDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "topPadding", "c", "bottomPadding", AuthSource.SEND_ABUSE, "halfBetweenPadding", "Lru/avito/component/shortcut_navigation_bar/RubricatorType;", "rubricatorType", "<init>", "(Lru/avito/component/shortcut_navigation_bar/RubricatorType;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RubricatorItemsDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public RubricatorItemsDecoration(@NotNull RubricatorType rubricatorType) {
        Intrinsics.checkNotNullParameter(rubricatorType, "rubricatorType");
        this.a = rubricatorType.isLargeIcon() ? ViewSizeKt.getDp(5) : ViewSizeKt.getDp(10);
        this.b = ViewSizeKt.getDp(rubricatorType.isLargeIcon() ? 12 : 8);
        this.c = rubricatorType.isLargeIcon() ? ViewSizeKt.getDp(10) : ViewSizeKt.getDp(16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int i2 = 0;
            if (childAdapterPosition == 0) {
                i = 0;
            } else {
                i = this.a;
            }
            rect.left = i;
            if (childAdapterPosition != adapter.getItemCount() - 1) {
                i2 = this.a;
            }
            rect.right = i2;
            rect.top = this.b;
            rect.bottom = this.c;
        }
    }
}
