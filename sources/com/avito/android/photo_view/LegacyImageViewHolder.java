package com.avito.android.photo_view;

import a2.a.a.y1.c;
import a2.a.a.y1.d;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.PhotoImageView;
import com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder;
import com.avito.android.photo_view.ImageData;
import com.avito.android.photo_view.ImageListView;
import com.avito.android.util.SimpleDraweeViewsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/avito/android/photo_view/LegacyImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/avito/android/photo_picker/legacy/DraggablePhotoViewHolder;", "", "isDraggable", "()Z", "Lcom/avito/android/photo_view/ImageData;", "image", "", "bind", "(Lcom/avito/android/photo_view/ImageData;)V", "Lcom/avito/android/design/widget/PhotoImageView;", "kotlin.jvm.PlatformType", "s", "Lcom/avito/android/design/widget/PhotoImageView;", "photoImageView", "u", "Z", "isCameraPreview", "setCameraPreview", "(Z)V", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "t", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "getPresenter", "()Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "Landroid/view/View;", "viewContainer", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_view/ImageListView$Presenter;Z)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyImageViewHolder extends RecyclerView.ViewHolder implements DraggablePhotoViewHolder {
    public final PhotoImageView s;
    @NotNull
    public final ImageListView.Presenter t;
    public boolean u;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyImageViewHolder(View view, ImageListView.Presenter presenter, boolean z, int i, j jVar) {
        this(view, presenter, (i & 4) != 0 ? false : z);
    }

    public final void bind(@NotNull ImageData imageData) {
        Intrinsics.checkNotNullParameter(imageData, "image");
        boolean areEqual = Intrinsics.areEqual(imageData.getId(), ImageListPresenterKt.PHOTO_CAMERA_ITEM_ID);
        this.u = areEqual;
        PhotoImageView photoImageView = this.s;
        if (areEqual) {
            photoImageView.setOnClickListener(new c(this, imageData));
            photoImageView.getImageView().setImageURI((String) null);
            photoImageView.showContent();
            return;
        }
        String id = imageData.getId();
        photoImageView.setOnClickListener(new d(this, photoImageView, imageData));
        photoImageView.setListener(new PhotoImageView.Listener(id) { // from class: com.avito.android.photo_view.LegacyImageViewHolder$bindImage$2
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            @Override // com.avito.android.design.widget.PhotoImageView.Listener
            public void onRemoveClicked() {
                LegacyImageViewHolder.this.getPresenter().onRemoveClicked(this.b);
            }

            @Override // com.avito.android.design.widget.PhotoImageView.Listener
            public void onRetryClicked() {
                LegacyImageViewHolder.this.getPresenter().onRetryClicked(this.b);
            }
        });
        Uri localUri = imageData.getLocalUri();
        if (localUri != null) {
            SimpleDraweeViewsKt.getRequestBuilder(photoImageView.getImageView()).uri(localUri).load();
        } else {
            photoImageView.getImageView().setImageURI((String) null);
        }
        ImageData.State state = imageData.getState();
        if (state instanceof ImageData.State.Loading) {
            photoImageView.showProgressBar();
        } else if (state instanceof ImageData.State.Error) {
            photoImageView.showErrorOverlay();
        } else {
            photoImageView.showContent();
        }
    }

    @NotNull
    public final ImageListView.Presenter getPresenter() {
        return this.t;
    }

    public final boolean isCameraPreview() {
        return this.u;
    }

    @Override // com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder
    public boolean isDraggable() {
        return !this.u;
    }

    public final void setCameraPreview(boolean z) {
        this.u = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyImageViewHolder(@NotNull View view, @NotNull ImageListView.Presenter presenter, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "viewContainer");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.t = presenter;
        this.u = z;
        this.s = (PhotoImageView) view.findViewById(R.id.loading_photo_image_view);
    }
}
