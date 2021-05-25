package com.avito.android.photo_view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder;
import com.avito.android.photo_view.ImageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_view/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/photo_picker/legacy/DraggablePhotoViewHolder;", "Lcom/avito/android/photo_view/ImageData;", "image", "", "bind", "(Lcom/avito/android/photo_view/ImageData;)V", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "s", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "getPresenter", "()Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "Landroid/view/View;", "viewContainer", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public abstract class ViewHolder extends RecyclerView.ViewHolder implements DraggablePhotoViewHolder {
    @NotNull
    public final ImageListView.Presenter s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewHolder(@NotNull View view, @NotNull ImageListView.Presenter presenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "viewContainer");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.s = presenter;
    }

    public abstract void bind(@NotNull ImageData imageData);

    @NotNull
    public final ImageListView.Presenter getPresenter() {
        return this.s;
    }
}
