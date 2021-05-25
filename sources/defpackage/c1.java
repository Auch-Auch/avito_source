package defpackage;

import android.view.View;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
/* compiled from: java-style lambda group */
/* renamed from: c1  reason: default package */
public final class c1 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public c1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((SNSPreviewPhotoDocumentFragment) this.b).a();
            ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment) this.b).getViewModel()).onWarningIgnored();
        } else if (i == 1) {
            ((SNSPreviewPhotoDocumentFragment) this.b).a();
            ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment) this.b).getViewModel()).onWarningAccepted();
        } else {
            throw null;
        }
    }
}
