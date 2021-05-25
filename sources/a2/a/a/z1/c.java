package a2.a.a.z1;

import com.avito.android.photo_picker.camera.CameraViewModel;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<CameraViewport.FocusArea> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public c(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CameraViewport.FocusArea focusArea) {
        CameraViewport preview;
        CameraViewport.FocusArea focusArea2 = focusArea;
        CameraInteractor cameraInteractor = this.a.f;
        if (cameraInteractor != null && cameraInteractor.getHasAutoFocus() && cameraInteractor.getHasFocusAreas()) {
            this.a.g = CameraViewModel.FocusMode.MANUAL_FOCUS;
            WizardPhotoPickerView wizardPhotoPickerView = this.a.p;
            if (!(wizardPhotoPickerView == null || (preview = wizardPhotoPickerView.preview()) == null)) {
                preview.startClickAnimation(focusArea2.getFocusRect().centerX(), focusArea2.getFocusRect().centerY());
            }
            cameraInteractor.focusAuto(focusArea2.getFocusRect(), focusArea2.getMeteringRect());
        }
    }
}
