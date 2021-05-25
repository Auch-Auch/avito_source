package a2.a.a.x1.n;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.PhotoPickerViewModel;
import com.avito.android.photo_picker.camera.CameraFragment;
public final class a<T> implements Observer<PhotoPickerViewModel.ViewState> {
    public final /* synthetic */ CameraFragment a;

    public a(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhotoPickerViewModel.ViewState viewState) {
        PhotoPickerViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof PhotoPickerViewModel.ViewState.ShowMaxPhotoError) {
            CameraFragment.access$getInfoTextView$p(this.a).setVisibility(4);
        } else if (viewState2 instanceof PhotoPickerViewModel.ViewState.HideChosenPhotoPanel) {
            CameraFragment.access$getInfoTextView$p(this.a).setVisibility(0);
        }
    }
}
