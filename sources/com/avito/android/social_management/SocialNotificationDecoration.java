package com.avito.android.social_management;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social_management.adapter.notification.NotificationItemView;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/social_management/SocialNotificationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)I", "<init>", "()V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialNotificationDecoration extends RecyclerView.ItemDecoration {
    public final int a(View view, RecyclerView recyclerView) {
        if (recyclerView.getChildViewHolder(view) instanceof NotificationItemView) {
            return view.getResources().getDimensionPixelOffset(R.dimen.content_highlight_horizontal_padding);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        rect.left = a(view, recyclerView);
        rect.right = a(view, recyclerView);
        int i2 = 0;
        if (recyclerView.getChildViewHolder(view) instanceof NotificationItemView) {
            i = view.getResources().getDimensionPixelOffset(R.dimen.social_notification_banner_top);
        } else {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            i = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() == 0 ? view.getResources().getDimensionPixelSize(R.dimen.list_top_padding) : 0;
        }
        rect.top = i;
        if (recyclerView.getChildViewHolder(view) instanceof NotificationItemView) {
            i2 = view.getResources().getDimensionPixelOffset(R.dimen.social_notification_banner_bottom);
        } else {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams2).getViewAdapterPosition();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (viewAdapterPosition == (adapter != null ? adapter.getItemCount() : 0) - 1) {
                i2 = view.getResources().getDimensionPixelSize(R.dimen.list_top_padding);
            }
        }
        rect.bottom = i2;
    }
}
