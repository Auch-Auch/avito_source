package a2.a.a.z1;

import com.avito.android.photo_picker.legacy.CameraInteractor;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import org.funktionale.option.Option;
public final class b<T> implements Consumer<Option<? extends CameraInteractor>> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public b(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Option<? extends CameraInteractor> option) {
        Option<? extends CameraInteractor> option2 = option;
        if (!option2.isEmpty()) {
            this.a.f = (CameraInteractor) option2.get();
            this.a.d();
        }
    }
}
