package com.avito.android.rating.details.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/rating/details/adapter/UserProfileCommentDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "I", "topPadding", AuthSource.BOOKING_ORDER, "bottomPadding", "c", "firstItemPadding", "d", "lastItemPadding", "<init>", "(IIII)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileCommentDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfileCommentDecoration(int i, int i2, int i3, int i4, int i5, j jVar) {
        this(i, i2, (i5 & 4) != 0 ? i : i3, (i5 & 8) != 0 ? i2 : i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (recyclerView.getChildViewHolder(view) instanceof UserProfileCommentItemView) {
            boolean z = false;
            rect.top = recyclerView.getChildAdapterPosition(view) == 0 ? this.c : this.a;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                Intrinsics.checkNotNullExpressionValue(layoutManager, "parent.layoutManager ?: return false");
                if (recyclerView.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                    z = true;
                }
            }
            rect.bottom = z ? this.d : this.b;
        }
    }

    public UserProfileCommentDecoration(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }
}
