package com.sumsub.sns.core.common;

import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/common/SNSAppListener;", "", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "result", "", "onCancel", "(Lcom/sumsub/sns/core/data/model/SNSCompletionResult;)V", "onMoveToNextDocument", "()V", "", "isCancelled", "onMoveToVerificationScreen", "(Z)V", "Lcom/sumsub/sns/core/data/model/Document;", "document", "onDocumentUploaded", "(Lcom/sumsub/sns/core/data/model/Document;)V", "onDocumentClicked", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onErrorAction", "(Lcom/sumsub/sns/core/data/model/Error;)V", "show", "onProgress", "onClose", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface SNSAppListener {
    void onCancel(@NotNull SNSCompletionResult sNSCompletionResult);

    void onClose();

    void onDocumentClicked(@NotNull Document document);

    void onDocumentUploaded(@NotNull Document document);

    void onErrorAction(@NotNull Error error);

    void onMoveToNextDocument();

    void onMoveToVerificationScreen(boolean z);

    void onProgress(boolean z);
}
