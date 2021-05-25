package a2.a.a.z1;

import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public g(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        WizardPhotoPickerView wizardPhotoPickerView = this.a.p;
        if (wizardPhotoPickerView != null) {
            wizardPhotoPickerView.enablePreviewControls();
        }
    }
}
