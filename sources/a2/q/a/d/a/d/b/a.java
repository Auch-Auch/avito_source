package a2.q.a.d.a.d.b;

import android.view.View;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
public final class a implements View.OnClickListener {
    public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

    public a(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment) {
        this.a = sNSPreviewPhotoDocumentFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a();
        ((SNSPreviewPhotoDocumentViewModel) this.a.getViewModel()).onWarningAccepted();
    }
}
