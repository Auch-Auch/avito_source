package a2.a.a.x1;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.PhotoPickerActivity;
import com.avito.android.photo_picker.PhotoPickerViewModel;
public final class c<T> implements Observer<PhotoPickerViewModel.ViewState> {
    public final /* synthetic */ PhotoPickerActivity a;

    public c(PhotoPickerActivity photoPickerActivity) {
        this.a = photoPickerActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhotoPickerViewModel.ViewState viewState) {
        PhotoPickerViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof PhotoPickerViewModel.ViewState.ShowChosenPhotoPanel) {
            PhotoPickerActivity.access$showChosenPhotoFragment(this.a);
        } else if (viewState2 instanceof PhotoPickerViewModel.ViewState.HideChosenPhotoPanel) {
            PhotoPickerActivity.access$hideChosenPhotoFragment(this.a);
        } else if (viewState2 instanceof PhotoPickerViewModel.ViewState.ShowMaxPhotoError) {
            PhotoPickerActivity.access$showMaxPhotoError(this.a, ((PhotoPickerViewModel.ViewState.ShowMaxPhotoError) viewState2).getMaxPhotos());
        } else if (viewState2 instanceof PhotoPickerViewModel.ViewState.ShowFullScreenLoading) {
            PhotoPickerActivity.access$showFullScreenLoading(this.a);
        } else if (viewState2 instanceof PhotoPickerViewModel.ViewState.HideFullScreenLoading) {
            PhotoPickerActivity.access$hideFullScreenLoading(this.a);
        }
    }
}
