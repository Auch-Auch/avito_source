package com.avito.android.tns_gallery;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "endMargin", AuthSource.SEND_ABUSE, "startMargin", "c", "betweenMargin", "Landroid/app/Activity;", "context", "Lcom/avito/android/tns_gallery/TnsGallerySettings;", "settings", "<init>", "(Landroid/app/Activity;Lcom/avito/android/tns_gallery/TnsGallerySettings;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public TnsGalleryItemDecoration(@NotNull Activity activity, @NotNull TnsGallerySettings tnsGallerySettings) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(tnsGallerySettings, "settings");
        this.a = Views.dpToPx(activity, tnsGallerySettings.getPaddingLeftDp());
        this.b = Views.dpToPx(activity, tnsGallerySettings.getPaddingRightDp());
        this.c = Views.dpToPx(activity, tnsGallerySettings.getSpaceBetweenImagesItems());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
        if (viewAdapterPosition == 0) {
            i2 = this.a;
            i = this.c;
        } else {
            if (viewAdapterPosition == ((recyclerView == null || (adapter = recyclerView.getAdapter()) == null) ? 0 : adapter.getItemCount()) - 1) {
                i3 = this.b;
            } else {
                i3 = this.c;
            }
            i = i3;
            i2 = 0;
        }
        rect.set(i2, 0, i, 0);
    }
}
