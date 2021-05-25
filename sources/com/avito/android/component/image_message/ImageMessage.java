package com.avito.android.component.image_message;

import androidx.annotation.VisibleForTesting;
import com.avito.android.component.circular_action_progress.CircularActionProgress;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.image_loader.Picture;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u00138&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/avito/android/component/image_message/ImageMessage;", "", "Lcom/avito/android/image_loader/Picture;", "picture", "thumbnail", "Lcom/avito/android/image_loader/ImageRequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/ImageRequestListener;)V", "showProgress", "()V", "hideProgress", "showError", "hideError", "Lio/reactivex/rxjava3/core/Observable;", "getErrorClicks", "()Lio/reactivex/rxjava3/core/Observable;", "errorClicks", "Lcom/avito/android/component/circular_action_progress/CircularActionProgress;", "getProgress", "()Lcom/avito/android/component/circular_action_progress/CircularActionProgress;", "getProgress$annotations", "progress", "getImageClicks", "imageClicks", "getCancelClicks", "cancelClicks", "getImageLongClicks", "imageLongClicks", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ImageMessage {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @VisibleForTesting
        public static /* synthetic */ void getProgress$annotations() {
        }

        public static /* synthetic */ void setImage$default(ImageMessage imageMessage, Picture picture, Picture picture2, ImageRequestListener imageRequestListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    picture2 = null;
                }
                if ((i & 4) != 0) {
                    imageRequestListener = null;
                }
                imageMessage.setImage(picture, picture2, imageRequestListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImage");
        }
    }

    @NotNull
    Observable<Unit> getCancelClicks();

    @NotNull
    Observable<Unit> getErrorClicks();

    @NotNull
    Observable<Unit> getImageClicks();

    @NotNull
    Observable<Unit> getImageLongClicks();

    @NotNull
    CircularActionProgress getProgress();

    void hideError();

    void hideProgress();

    void setImage(@NotNull Picture picture, @Nullable Picture picture2, @Nullable ImageRequestListener imageRequestListener);

    void showError();

    void showProgress();
}
