package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.legacy.PhotoPickerView;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenter;
import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001#J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u000bJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u000bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$Presenter;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemPresenter$Listener;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "Lcom/avito/android/photo_picker/legacy/details_list/EditorItemPresenter$Listener;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView;", "view", "", "attachView", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerView;)V", "detachView", "()V", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;)V", "detachRouter", "Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "getState", "()Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenterState;", "", "id", "setSelectedPhotoId", "(Ljava/lang/String;)V", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "viewModel", "setViewModel", "(Lcom/avito/android/photo_picker/PhotoPickerViewModel;)V", "handleContinueButtonClick", "hideFullScreenLoading", "showFullScreenLoading", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "getFirstPhoto", "()Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "firstPhoto", "Router", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerPresenter extends PhotoPickerView.Presenter, ThumbnailItemPresenter.Listener, CameraItemPresenter.Listener, EditorItemPresenter.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerPresenter$Router;", "", "", "onSubmit", "()V", "onCancel", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onCancel();

        void onSubmit();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull PhotoPickerView photoPickerView);

    void detachRouter();

    void detachView();

    @Nullable
    UriPhotoItem getFirstPhoto();

    @NotNull
    PhotoPickerPresenterState getState();

    void handleContinueButtonClick();

    void hideFullScreenLoading();

    void setSelectedPhotoId(@NotNull String str);

    void setViewModel(@NotNull PhotoPickerViewModel photoPickerViewModel);

    void showFullScreenLoading();
}
