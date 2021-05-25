package a2.a.a.z1;

import android.view.LayoutInflater;
import android.view.View;
import com.avito.android.photo_wizard.DocumentType;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import com.avito.android.photo_wizard.WizardPhotoPickerViewImpl;
import kotlin.jvm.internal.Intrinsics;
public final class h implements View.OnClickListener {
    public final /* synthetic */ DocumentType a;
    public final /* synthetic */ WizardPhotoPickerViewImpl b;

    public h(DocumentType documentType, WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl, LayoutInflater layoutInflater) {
        this.a = documentType;
        this.b = wizardPhotoPickerViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WizardPhotoPickerView.Listener listener;
        Intrinsics.checkNotNullExpressionValue(view, "clicked");
        if (!view.isSelected() && (listener = this.b.w) != null) {
            listener.onDocumentTypeClicked(this.a);
        }
    }
}
