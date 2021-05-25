package com.avito.android.photo_picker.legacy.details_list;

import android.net.Uri;
import com.avito.android.permissions.PermissionResultHandler;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.photo_picker.legacy.CameraPresenterState;
import com.avito.android.photo_picker.legacy.OnPhotoSourcesAvailableChangeListener;
import com.avito.android.photo_picker.legacy.PhotoSource;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u0005:\u0002\u001c\u001dJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView$Presenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Lcom/avito/android/permissions/PermissionResultHandler;", "view", "", "bindView", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;)V", "detachViewWithSurface", "()V", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;)V", "detachRouter", "Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "getState", "()Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "initialize", "uninitialize", "onScreenLeaved", "Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;", "photoSourcesChangeListener", "setPhotoSourcesChangeListener", "(Lcom/avito/android/photo_picker/legacy/OnPhotoSourcesAvailableChangeListener;)V", "startPreview", "Listener", "Router", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraItemPresenter extends CameraItemView.Presenter, ResponsiveItemPresenter<CameraItemView, BasePhotoItem>, PermissionResultHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void viewAttached(@NotNull CameraItemPresenter cameraItemPresenter, @NotNull CameraItemView cameraItemView, int i) {
            Intrinsics.checkNotNullParameter(cameraItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewAttached(cameraItemPresenter, cameraItemView, i);
        }

        public static void viewDetached(@NotNull CameraItemPresenter cameraItemPresenter, @NotNull CameraItemView cameraItemView, int i) {
            Intrinsics.checkNotNullParameter(cameraItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewDetached(cameraItemPresenter, cameraItemView, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\b\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "", "", "Landroid/net/Uri;", "uris", "Lcom/avito/android/photo_picker/legacy/PhotoSource;", "source", "", "onNewPhotos", "(Ljava/util/List;Lcom/avito/android/photo_picker/legacy/PhotoSource;)V", "Lcom/avito/android/photo_picker/SelectedPhoto;", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onNewPhotos(@NotNull List<SelectedPhoto> list);

        void onNewPhotos(@NotNull List<? extends Uri> list, @NotNull PhotoSource photoSource);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Router;", "", "", "isMultiple", "openGallery", "(Z)Z", "", "openAppSettings", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void openAppSettings();

        boolean openGallery(boolean z);
    }

    void attachRouter(@NotNull Router router);

    void bindView(@NotNull CameraItemView cameraItemView);

    void detachRouter();

    void detachViewWithSurface();

    @NotNull
    CameraPresenterState getState();

    void initialize();

    void onScreenLeaved();

    void setPhotoSourcesChangeListener(@NotNull OnPhotoSourcesAvailableChangeListener onPhotoSourcesAvailableChangeListener);

    void startPreview();

    void uninitialize();
}
