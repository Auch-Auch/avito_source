package com.avito.android.photo_view;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.design.ImageLoadable;
import com.avito.android.lib.design.photo_uploader_image.PhotoUploaderImage;
import com.avito.android.photo_view.ImageData;
import com.avito.android.photo_view.ImageListView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/photo_view/ImageViewHolder;", "Lcom/avito/android/photo_view/ViewHolder;", "", "isDraggable", "()Z", "Lcom/avito/android/photo_view/ImageData;", "image", "", "bind", "(Lcom/avito/android/photo_view/ImageData;)V", "Lcom/avito/android/lib/design/photo_uploader_image/PhotoUploaderImage;", "kotlin.jvm.PlatformType", "t", "Lcom/avito/android/lib/design/photo_uploader_image/PhotoUploaderImage;", "photoImageView", "Landroid/view/View;", "viewContainer", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "presenter", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_view/ImageListView$Presenter;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class ImageViewHolder extends ViewHolder {
    public final PhotoUploaderImage t;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((ImageViewHolder) this.c).getPresenter().onRemoveClicked((String) this.b);
                return Unit.INSTANCE;
            } else if (i != 1) {
                ImageData.State.Error error = null;
                if (i == 2) {
                    ImageData.State state = ((ImageData) this.d).getState();
                    if (state instanceof ImageData.State.Error) {
                        error = state;
                    }
                    ImageData.State.Error error2 = error;
                    if (error2 != null) {
                        ((PhotoUploaderImage) this.b).showErrorActionsOverlay(error2.isRestorable());
                    }
                    return Unit.INSTANCE;
                }
                throw null;
            } else {
                ((ImageViewHolder) this.c).getPresenter().onRetryClicked((String) this.b);
                return Unit.INSTANCE;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PhotoUploaderImage a;
        public final /* synthetic */ ImageViewHolder b;
        public final /* synthetic */ ImageData c;

        public b(PhotoUploaderImage photoUploaderImage, ImageViewHolder imageViewHolder, ImageData imageData) {
            this.a = photoUploaderImage;
            this.b = imageViewHolder;
            this.c = imageData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ImageData.State state = this.c.getState();
            if (state instanceof ImageData.State.Error) {
                ImageData.State state2 = this.c.getState();
                if (!(state2 instanceof ImageData.State.Error)) {
                    state2 = null;
                }
                ImageData.State.Error error = (ImageData.State.Error) state2;
                if (error != null) {
                    this.a.showErrorActionsOverlay(error.isRestorable());
                }
            } else if (state instanceof ImageData.State.Loading) {
                this.a.showRemoveOverlay();
            } else {
                this.b.getPresenter().showPhotoPicker(this.c.getId());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageViewHolder(@NotNull View view, @NotNull ImageListView.Presenter presenter) {
        super(view, presenter);
        Intrinsics.checkNotNullParameter(view, "viewContainer");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.t = (PhotoUploaderImage) view.findViewById(R.id.loading_photo_image_view);
    }

    @Override // com.avito.android.photo_view.ViewHolder
    public void bind(@NotNull ImageData imageData) {
        Intrinsics.checkNotNullParameter(imageData, "image");
        PhotoUploaderImage photoUploaderImage = this.t;
        String id = imageData.getId();
        photoUploaderImage.setOnClickListener(new b(photoUploaderImage, this, imageData));
        photoUploaderImage.setRemoveClickedListener(new a(0, id, this, imageData));
        photoUploaderImage.setRetryClickedListener(new a(1, id, this, imageData));
        photoUploaderImage.setErrorClickedListener(new a(2, photoUploaderImage, this, imageData));
        Uri localUri = imageData.getLocalUri();
        if (localUri == null) {
            photoUploaderImage.setImage(null);
        } else {
            Glide.with(photoUploaderImage).load(localUri).into((RequestBuilder<Drawable>) new CustomViewTarget<View, Drawable>(photoUploaderImage, photoUploaderImage) { // from class: com.avito.android.photo_view.ImageViewHolder$$special$$inlined$loadUri$1
                public final /* synthetic */ ImageLoadable f;

                {
                    this.f = r1;
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadFailed(@Nullable Drawable drawable) {
                }

                @Override // com.bumptech.glide.request.target.CustomViewTarget
                public void onResourceCleared(@Nullable Drawable drawable) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(drawable, "resource");
                    this.f.setImage(drawable);
                }
            });
        }
        ImageData.State state = imageData.getState();
        if (state instanceof ImageData.State.Loading) {
            photoUploaderImage.showProgressBar();
        } else if (state instanceof ImageData.State.Error) {
            photoUploaderImage.showErrorOverlay();
        } else {
            photoUploaderImage.showContent();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder
    public boolean isDraggable() {
        return true;
    }
}
