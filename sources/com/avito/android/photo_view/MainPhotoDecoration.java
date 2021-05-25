package com.avito.android.photo_view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.photo_uploader_label.PhotoUploaderLabel;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_view/MainPhotoDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lcom/avito/android/lib/design/photo_uploader_label/PhotoUploaderLabel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/photo_uploader_label/PhotoUploaderLabel;", "getLabel", "()Lcom/avito/android/lib/design/photo_uploader_label/PhotoUploaderLabel;", "label", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class MainPhotoDecoration extends RecyclerView.ItemDecoration {
    @NotNull
    public final PhotoUploaderLabel a;

    public MainPhotoDecoration(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new PhotoUploaderLabel(context, null, 0, 0, 14, null);
    }

    @NotNull
    public final PhotoUploaderLabel getLabel() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition;
        View view;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if ((adapter != null ? adapter.getItemViewType(0) : -1) > 0 && (findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(0)) != null && (view = findViewHolderForLayoutPosition.itemView) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "parent.findViewHolderFor…tion)?.itemView ?: return");
            this.a.setTag(0);
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
            int i2 = marginLayoutParams != null ? marginLayoutParams.rightMargin : 0;
            int i3 = marginLayoutParams != null ? marginLayoutParams.topMargin : 0;
            this.a.measure(View.MeasureSpec.makeMeasureSpec((view.getWidth() - i) - i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((view.getHeight() - i3) - (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0), Integer.MIN_VALUE));
            PhotoUploaderLabel photoUploaderLabel = this.a;
            photoUploaderLabel.layout(0, 0, photoUploaderLabel.getMeasuredWidth(), this.a.getMeasuredHeight());
            canvas.save();
            canvas.translate(view.getX() + ((float) i), view.getY() + ((float) i3));
            this.a.draw(canvas);
            canvas.restore();
        }
    }
}
