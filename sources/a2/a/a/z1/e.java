package a2.a.a.z1;

import android.net.Uri;
import com.avito.android.photo_wizard.PhotoWizardImageResizer;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<byte[], ObservableSource<? extends Uri>> {
    public final /* synthetic */ WizardPhotoPickerPresenterImpl a;

    public e(WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl) {
        this.a = wizardPhotoPickerPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Uri> apply(byte[] bArr) {
        byte[] bArr2 = bArr;
        PhotoWizardImageResizer photoWizardImageResizer = this.a.x;
        Intrinsics.checkNotNullExpressionValue(bArr2, "it");
        return photoWizardImageResizer.resize(bArr2, this.a.o, WizardPhotoPickerPresenterImpl.access$calculateFinalPhotoSize(this.a), null).map(new d(this));
    }
}
