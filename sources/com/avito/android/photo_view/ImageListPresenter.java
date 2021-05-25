package com.avito.android.photo_view;

import com.avito.android.photo_view.ImageListView;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000fH&¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH&¢\u0006\u0004\b\u001b\u0010\u0012R\u001c\u0010 \u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/photo_view/ImageListPresenter;", "Lcom/avito/android/photo_view/ImageListView$Presenter;", "Lcom/avito/android/photo_view/ImageListView;", "view", "", "attachView", "(Lcom/avito/android/photo_view/ImageListView;)V", "detachView", "()V", "Lcom/avito/android/photo_view/ImageListRouter;", "router", "attachRouter", "(Lcom/avito/android/photo_view/ImageListRouter;)V", "detachRouter", "hideAllRemoveButtons", "", "success", "onPhotoPickerResult", "(Z)V", "Lio/reactivex/Observable;", "", "photoCountChanges", "()Lio/reactivex/Observable;", "addNewPhoto", "hasError", "setCameraError", "enabled", "setVideoEnabled", "getMaxImageCount", "()I", "setMaxImageCount", "(I)V", "maxImageCount", "getCurrentPhotoCount", "currentPhotoCount", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public interface ImageListPresenter extends ImageListView.Presenter {
    void addNewPhoto();

    void attachRouter(@NotNull ImageListRouter imageListRouter);

    void attachView(@NotNull ImageListView imageListView);

    void detachRouter();

    void detachView();

    int getCurrentPhotoCount();

    int getMaxImageCount();

    void hideAllRemoveButtons();

    void onPhotoPickerResult(boolean z);

    @NotNull
    Observable<Integer> photoCountChanges();

    void setCameraError(boolean z);

    void setMaxImageCount(int i);

    void setVideoEnabled(boolean z);
}
