package com.avito.android.photo_picker.photo_panel;

import a2.a.a.x1.r.b;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel$ViewState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "activityViewModel", "", "init", "(Lcom/avito/android/photo_picker/PhotoPickerViewModel;)V", "onCleared", "()V", "mainButtonClicked", "photosClicked", "", "Lcom/avito/android/photo_picker/SelectedPhoto;", "photosList", "c", "(Ljava/util/List;)V", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "d", "Lcom/avito/android/photo_picker/PhotoPickerViewModel;", "photoPickerViewModel", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "subscription", "<init>", "ViewState", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPanelViewModel extends ViewModel {
    public Disposable c;
    public PhotoPickerViewModel d;
    public final MutableLiveData<ViewState> e = new MutableLiveData<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel$ViewState;", "", "<init>", "()V", "SelectedPhotosUpdate", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel$ViewState$SelectedPhotosUpdate;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel$ViewState$SelectedPhotosUpdate;", "Lcom/avito/android/photo_picker/photo_panel/PhotoPanelViewModel$ViewState;", "Landroid/net/Uri;", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getLastPhoto", "()Landroid/net/Uri;", "lastPhoto", "c", "getPreLastPhoto", "preLastPhoto", "", AuthSource.SEND_ABUSE, "I", "getCount", "()I", "count", "<init>", "(ILandroid/net/Uri;Landroid/net/Uri;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class SelectedPhotosUpdate extends ViewState {
            public final int a;
            @Nullable
            public final Uri b;
            @Nullable
            public final Uri c;

            public SelectedPhotosUpdate(int i, @Nullable Uri uri, @Nullable Uri uri2) {
                super(null);
                this.a = i;
                this.b = uri;
                this.c = uri2;
            }

            public final int getCount() {
                return this.a;
            }

            @Nullable
            public final Uri getLastPhoto() {
                return this.b;
            }

            @Nullable
            public final Uri getPreLastPhoto() {
                return this.c;
            }
        }

        public ViewState() {
        }

        public ViewState(j jVar) {
        }
    }

    public static final /* synthetic */ PhotoPickerViewModel access$getPhotoPickerViewModel$p(PhotoPanelViewModel photoPanelViewModel) {
        PhotoPickerViewModel photoPickerViewModel = photoPanelViewModel.d;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        return photoPickerViewModel;
    }

    public final void c(List<SelectedPhoto> list) {
        MutableLiveData<ViewState> mutableLiveData = this.e;
        int size = list.size();
        SelectedPhoto selectedPhoto = (SelectedPhoto) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        Uri uri = null;
        Uri uri2 = selectedPhoto != null ? selectedPhoto.getUri() : null;
        SelectedPhoto selectedPhoto2 = (SelectedPhoto) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) CollectionsKt___CollectionsKt.dropLast(list, 1));
        if (selectedPhoto2 != null) {
            uri = selectedPhoto2.getUri();
        }
        mutableLiveData.setValue(new ViewState.SelectedPhotosUpdate(size, uri2, uri));
    }

    public final void init(@NotNull PhotoPickerViewModel photoPickerViewModel) {
        Intrinsics.checkNotNullParameter(photoPickerViewModel, "activityViewModel");
        this.d = photoPickerViewModel;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        this.c = photoPickerViewModel.getSelectedPhotosChangeObservable$photo_picker_release().subscribe(new b(this));
        PhotoPickerViewModel photoPickerViewModel2 = this.d;
        if (photoPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        c(photoPickerViewModel2.getSelectedPhotos$photo_picker_release());
    }

    public final void mainButtonClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.d;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.selectPhotosFromCamera();
        PhotoPickerViewModel photoPickerViewModel2 = this.d;
        if (photoPickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel2.closeWithSuccess();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void photosClicked() {
        PhotoPickerViewModel photoPickerViewModel = this.d;
        if (photoPickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPickerViewModel");
        }
        photoPickerViewModel.goToEdit();
    }

    @NotNull
    public final LiveData<ViewState> screenState() {
        return this.e;
    }
}
