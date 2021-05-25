package a2.q.a.b.c.a;

import android.view.View;
import com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity;
public final class a implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ SNSDocumentSelectorActivity b;

    public a(String str, SNSDocumentSelectorActivity sNSDocumentSelectorActivity) {
        this.a = str;
        this.b = sNSDocumentSelectorActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.getViewModel().m190onDocumentSelectedwYDFDDU(this.a);
    }
}
