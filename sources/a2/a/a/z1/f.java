package a2.a.a.z1;

import android.net.Uri;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.photo_wizard.PhotoWizardViewModel;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Uri> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public f(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Uri uri) {
        CameraViewport preview;
        Uri uri2 = uri;
        WizardPhotoPickerView wizardPhotoPickerView = this.a.p;
        if (!(wizardPhotoPickerView == null || (preview = wizardPhotoPickerView.preview()) == null)) {
            preview.startPhotoCaptureAnimation();
        }
        PhotoWizardViewModel photoWizardViewModel = this.a.q;
        if (photoWizardViewModel != null) {
            Intrinsics.checkNotNullExpressionValue(uri2, "it");
            photoWizardViewModel.onPictureTaken(uri2);
        }
    }
}
