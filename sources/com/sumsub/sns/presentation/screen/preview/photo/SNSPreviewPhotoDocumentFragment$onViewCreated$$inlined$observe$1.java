package com.sumsub.sns.presentation.screen.preview.photo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.transition.TransitionManager;
import com.sumsub.sns.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/sumsub/sns/core/common/ExtensionsKt$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1<T> implements Observer<T> {
    public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1) this.b).a.getViewModel()).onDataIsReadableClicked(((SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1) this.b).a.getIvPhoto().getRotation());
            } else if (i == 1) {
                ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1) this.b).a.getViewModel()).onTakeAnotherDataClicked();
            } else {
                throw null;
            }
        }
    }

    public SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observe$1(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment) {
        this.a = sNSPreviewPhotoDocumentFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            boolean booleanValue = t.booleanValue();
            TransitionManager.beginDelayedTransition(this.a.getVgWarning());
            this.a.getGContent().setVisibility(booleanValue ? 0 : 8);
            this.a.getTvIdDoc().setVisibility(8);
            if (booleanValue) {
                TextView tvTitle = this.a.getTvTitle();
                tvTitle.setVisibility(0);
                tvTitle.setText(this.a.getTitle());
                TextView tvSubtitle = this.a.getTvSubtitle();
                tvSubtitle.setVisibility(0);
                tvSubtitle.setText(this.a.getTextResource(R.string.sns_preview_photo_subtitle));
                Button btnReadableDocument = this.a.getBtnReadableDocument();
                btnReadableDocument.setText(this.a.getTextResource(R.string.sns_preview_photo_action_accept));
                btnReadableDocument.setOnClickListener(new a(0, this));
                btnReadableDocument.setVisibility(0);
                Button btnTakeAnotherPhoto = this.a.getBtnTakeAnotherPhoto();
                btnTakeAnotherPhoto.setText(this.a.getTextResource(R.string.sns_preview_photo_action_retake));
                btnTakeAnotherPhoto.setOnClickListener(new a(1, this));
            }
        }
    }
}
