package defpackage;

import android.view.View;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import com.avito.android.photo_wizard.WizardPhotoPickerViewImpl;
/* compiled from: java-style lambda group */
/* renamed from: g  reason: default package */
public final class g implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public g(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                WizardPhotoPickerView.Listener listener = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener != null) {
                    listener.onCloseClicked();
                    return;
                }
                return;
            case 1:
                WizardPhotoPickerView.Listener listener2 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener2 != null) {
                    listener2.onTakePhotoClicked();
                    return;
                }
                return;
            case 2:
                WizardPhotoPickerView.Listener listener3 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener3 != null) {
                    listener3.onPhotoActionClicked();
                    return;
                }
                return;
            case 3:
                WizardPhotoPickerView.Listener listener4 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener4 != null) {
                    listener4.onRetakePhotoClicked();
                    return;
                }
                return;
            case 4:
                WizardPhotoPickerView.Listener listener5 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener5 != null) {
                    listener5.onFlashClicked();
                    return;
                }
                return;
            case 5:
                WizardPhotoPickerView.Listener listener6 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener6 != null) {
                    listener6.onRetryClicked();
                    return;
                }
                return;
            case 6:
                WizardPhotoPickerView.Listener listener7 = ((WizardPhotoPickerViewImpl) this.b).w;
                if (listener7 != null) {
                    listener7.allowAccessClicked();
                    return;
                }
                return;
            default:
                throw null;
        }
    }
}
