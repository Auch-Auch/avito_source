package a2.a.a.x1.n;

import androidx.lifecycle.Observer;
import com.avito.android.photo_picker.camera.CameraFragment;
import com.avito.android.photo_picker.camera.CameraViewModel;
public final class b<T> implements Observer<CameraViewModel.ViewState> {
    public final /* synthetic */ CameraFragment a;

    public b(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(CameraViewModel.ViewState viewState) {
        CameraViewModel.ViewState viewState2 = viewState;
        if (viewState2 instanceof CameraViewModel.ViewState.NoImagesFromGalleryAvailable) {
            CameraFragment.access$showGalleryButtonStub(this.a);
        } else if (viewState2 instanceof CameraViewModel.ViewState.GalleryButtonSource) {
            CameraFragment.access$showGalleryButtonSrc(this.a, ((CameraViewModel.ViewState.GalleryButtonSource) viewState2).getBitmap());
        } else if (viewState2 instanceof CameraViewModel.ViewState.NeedToReopenCamera) {
            this.a.b();
        } else if (viewState2 instanceof CameraViewModel.ViewState.UpdateTextureMatrix) {
            CameraFragment.access$getCameraViewport$p(this.a).transformViewport(((CameraViewModel.ViewState.UpdateTextureMatrix) viewState2).getMatrix());
        } else if (viewState2 instanceof CameraViewModel.ViewState.HideNoPermission) {
            CameraFragment.access$hideNoPermission(this.a);
        } else if (viewState2 instanceof CameraViewModel.ViewState.ShowNoPermission) {
            CameraFragment.access$showNoPermission(this.a, ((CameraViewModel.ViewState.ShowNoPermission) viewState2).getButtonTextResId());
        } else if (viewState2 instanceof CameraViewModel.ViewState.ChangeFlashModeIcon) {
            CameraFragment.access$getChangeFlashButton$p(this.a).setImageResource(((CameraViewModel.ViewState.ChangeFlashModeIcon) viewState2).getImageResId());
        } else if (viewState2 instanceof CameraViewModel.ViewState.StartFocusOnTouch) {
            CameraViewModel.ViewState.StartFocusOnTouch startFocusOnTouch = (CameraViewModel.ViewState.StartFocusOnTouch) viewState2;
            CameraFragment.access$getCameraViewport$p(this.a).startClickAnimation(startFocusOnTouch.getX(), startFocusOnTouch.getY());
        } else if (viewState2 instanceof CameraViewModel.ViewState.PhotoCaptureStarted) {
            CameraFragment.access$disablePhotoControls(this.a);
        } else if (viewState2 instanceof CameraViewModel.ViewState.PhotoCaptureSuccess) {
            CameraFragment.access$handlePhotoCaptured(this.a, ((CameraViewModel.ViewState.PhotoCaptureSuccess) viewState2).getWithCameraRestart());
        } else if (viewState2 instanceof CameraViewModel.ViewState.PhotoCaptureError) {
            this.a.a();
        }
    }
}
