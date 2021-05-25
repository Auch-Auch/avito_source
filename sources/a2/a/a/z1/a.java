package a2.a.a.z1;

import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import io.reactivex.functions.Consumer;
import org.funktionale.option.Option;
public final class a<T> implements Consumer<Option<? extends CameraInteractor>> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public a(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Option<? extends CameraInteractor> option) {
        CameraInteractor cameraInteractor = (CameraInteractor) option.orNull();
        if (cameraInteractor != null) {
            cameraInteractor.prepareCamera(this.a.k, this.a.o);
        }
    }
}
