package com.avito.android.photo_view.blueprints;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.PhotoViewResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemPresenterImpl;", "Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemPresenter;", "Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Photo;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemView;Lcom/avito/android/category_parameters/ParameterElement$Photo;I)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/photo_view/ImageListPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", "Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "c", "Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/photo_view/ImageListPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/photo_view/PhotoViewResourceProvider;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStatePhotoItemPresenterImpl implements MultiStatePhotoItemPresenter {
    public final ImageListPresenter a;
    public final AttributedTextFormatter b;
    public final PhotoViewResourceProvider c;

    public MultiStatePhotoItemPresenterImpl(@NotNull ImageListPresenter imageListPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PhotoViewResourceProvider photoViewResourceProvider) {
        Intrinsics.checkNotNullParameter(imageListPresenter, "imageListPresenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(photoViewResourceProvider, "resourcesProvider");
        this.a = imageListPresenter;
        this.b = attributedTextFormatter;
        this.c = photoViewResourceProvider;
    }

    public void bindView(@NotNull MultiStatePhotoItemView multiStatePhotoItemView, @NotNull ParameterElement.Photo photo, int i) {
        String str;
        Intrinsics.checkNotNullParameter(multiStatePhotoItemView, "view");
        Intrinsics.checkNotNullParameter(photo, "item");
        CharSequence charSequence = null;
        if (photo.getHideTitle()) {
            str = null;
        } else if (photo.isVideoEnabled()) {
            str = this.c.getPhotoAndVideoTitle();
        } else {
            str = photo.getTitle();
        }
        multiStatePhotoItemView.setTitle(str);
        ItemWithState.State state = photo.getState();
        if (state instanceof ItemWithState.State.Error) {
            multiStatePhotoItemView.setErrorState(((ItemWithState.State.Error) state).getMessage());
        } else if (state instanceof ItemWithState.State.Warning) {
            multiStatePhotoItemView.setWarningState(((ItemWithState.State.Warning) state).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            CharSequence message = ((ItemWithState.State.Normal) state).getMessage();
            if (message != null) {
                charSequence = message;
            } else {
                AttributedText motivation = photo.getMotivation();
                if (motivation != null) {
                    charSequence = this.b.format(motivation);
                }
            }
            multiStatePhotoItemView.setNormalState(charSequence);
        }
        this.a.setCameraError(photo.getState() instanceof ItemWithState.State.Error);
        this.a.setMaxImageCount(photo.getCount());
        this.a.setVideoEnabled(photo.isVideoEnabled());
        multiStatePhotoItemView.attachPresenter(this.a);
    }
}
