package com.avito.android.photo_view;

import android.view.View;
import com.avito.android.lib.design.photo_uploader_appending.PhotoUploaderAppending;
import com.avito.android.photo_view.ImageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_view/VideoAppendingViewHolder;", "Lcom/avito/android/photo_view/ViewHolder;", "", "isDraggable", "()Z", "Lcom/avito/android/photo_view/ImageData;", "image", "", "bind", "(Lcom/avito/android/photo_view/ImageData;)V", "Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending;", "kotlin.jvm.PlatformType", "t", "Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending;", "photoUploaderAppending", "Landroid/view/View;", "viewContainer", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class VideoAppendingViewHolder extends ViewHolder {
    public final PhotoUploaderAppending t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VideoAppendingViewHolder a;
        public final /* synthetic */ ImageData b;

        public a(VideoAppendingViewHolder videoAppendingViewHolder, ImageData imageData) {
            this.a = videoAppendingViewHolder;
            this.b = imageData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getPresenter().showVideoPicker();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoAppendingViewHolder(@NotNull View view, @NotNull ImageListView.Presenter presenter) {
        super(view, presenter);
        Intrinsics.checkNotNullParameter(view, "viewContainer");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.t = (PhotoUploaderAppending) view.findViewById(R.id.loading_photo_image_view);
    }

    @Override // com.avito.android.photo_view.ViewHolder
    public void bind(@NotNull ImageData imageData) {
        Intrinsics.checkNotNullParameter(imageData, "image");
        PhotoUploaderAppending photoUploaderAppending = this.t;
        photoUploaderAppending.setOnClickListener(new a(this, imageData));
        photoUploaderAppending.setState(PhotoUploaderAppending.Companion.getSTATE_NORMAL());
        if (imageData instanceof PlaceholderImageData) {
            PlaceholderImageData placeholderImageData = (PlaceholderImageData) imageData;
            photoUploaderAppending.setText(placeholderImageData.getPlaceholderText());
            photoUploaderAppending.setIcon(placeholderImageData.getPlaceholderIcon());
        }
    }

    @Override // com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder
    public boolean isDraggable() {
        return false;
    }
}
