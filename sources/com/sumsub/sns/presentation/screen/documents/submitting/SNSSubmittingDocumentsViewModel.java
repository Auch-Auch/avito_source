package com.sumsub.sns.presentation.screen.documents.submitting;

import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/submitting/SNSSubmittingDocumentsViewModel;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsViewModel;", "Lcom/sumsub/sns/core/data/model/Document;", "document", "", "onDocumentClicked", "(Lcom/sumsub/sns/core/data/model/Document;)V", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSubmittingDocumentsViewModel extends SNSBaseListDocumentsViewModel {
    public SNSSubmittingDocumentsViewModel() {
        Timber.i("SubmittingDocumentsViewModel is created", new Object[0]);
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel
    public void onDocumentClicked(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        if (document.isSubmitted()) {
            get_showDocumentPreviewActionLiveData().setValue(new Event<>(document));
        }
    }
}
