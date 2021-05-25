package com.sumsub.sns.presentation.screen.preview.photo;

import android.content.DialogInterface;
import androidx.lifecycle.Observer;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.Event;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lcom/sumsub/sns/core/presentation/base/Event;", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Lcom/sumsub/sns/core/presentation/base/Event;)V", "com/sumsub/sns/core/common/ExtensionsKt$observeEvent$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$1<T> implements Observer<Event<? extends T>> {
    public final /* synthetic */ SNSPreviewPhotoDocumentFragment a;

    /* compiled from: java-style lambda group */
    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = this.a;
            if (i2 == 0) {
                ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$1) this.b).a.getViewModel()).onDocumentSideAnswerClicked(true);
            } else if (i2 == 1) {
                ((SNSPreviewPhotoDocumentViewModel) ((SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$1) this.b).a.getViewModel()).onDocumentSideAnswerClicked(false);
            } else {
                throw null;
            }
        }
    }

    public SNSPreviewPhotoDocumentFragment$onViewCreated$$inlined$observeEvent$1(SNSPreviewPhotoDocumentFragment sNSPreviewPhotoDocumentFragment) {
        this.a = sNSPreviewPhotoDocumentFragment;
    }

    public final void onChanged(Event<? extends T> event) {
        if (event != null && event.getContentIfNotHandled() != null) {
            new MaterialAlertDialogBuilder(this.a.requireContext()).setMessage(this.a.getTextResource(R.string.sns_prompt_doubleSide_text)).setPositiveButton(this.a.getTextResource(R.string.sns_prompt_doubleSide_action_yes), (DialogInterface.OnClickListener) new a(0, this)).setNegativeButton(this.a.getTextResource(R.string.sns_prompt_doubleSide_action_no), (DialogInterface.OnClickListener) new a(1, this)).show();
        }
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((Event) ((Event) obj));
    }
}
