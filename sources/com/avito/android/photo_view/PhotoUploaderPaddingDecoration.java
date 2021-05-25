package com.avito.android.photo_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/photo_view/PhotoUploaderPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", AuthSource.BOOKING_ORDER, "I", "spacingVertical", AuthSource.SEND_ABUSE, "spacingHorizontal", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;II)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploaderPaddingDecoration extends RecyclerView.ItemDecoration {
    public int a;
    public int b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploaderPaddingDecoration(Context context, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? R.attr.photoUploaderList : i, (i3 & 4) != 0 ? R.style.Design_Widget_PhotoUploaderList : i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Integer num = null;
        if (!(layoutManager instanceof GridLayoutManager)) {
            layoutManager = null;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int spanCount = gridLayoutManager != null ? gridLayoutManager.getSpanCount() : 1;
        int ceil = (int) Math.ceil(((double) state.getItemCount()) / ((double) spanCount));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewAdapterPosition = ((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition();
        int i = viewAdapterPosition % spanCount;
        int i2 = viewAdapterPosition / spanCount;
        int i3 = this.a;
        int i4 = i3 / 2;
        int i5 = i3 / spanCount;
        Integer valueOf = Integer.valueOf(i4);
        valueOf.intValue();
        int i6 = 0;
        if (!(i2 > 0)) {
            valueOf = null;
        }
        rect.top = valueOf != null ? valueOf.intValue() : 0;
        Integer valueOf2 = Integer.valueOf(i4);
        valueOf2.intValue();
        if (i2 < ceil - 1) {
            num = valueOf2;
        }
        if (num != null) {
            i6 = num.intValue();
        }
        rect.bottom = i6;
        rect.left = i5 * i;
        rect.right = ((spanCount - i) - 1) * i5;
    }

    public PhotoUploaderPaddingDecoration(@NotNull Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.PhotoUploaderList, i, i2);
        this.a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderList_photoUploaderList_spacingHorizontal, this.a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderList_photoUploaderList_spacingVertical, this.b);
        obtainStyledAttributes.recycle();
    }
}
