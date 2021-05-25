package com.sumsub.sns.presentation.screen.base;

import a2.g.r.g;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\u000f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001f\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR(\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000f8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u001f\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\r¨\u0006!"}, d2 = {"Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "Lcom/sumsub/sns/core/data/model/Error;", "error", "", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "onLoad", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Landroid/net/Uri;", "getShowWebUrl", "()Landroidx/lifecycle/LiveData;", "showWebUrl", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/data/model/Document;", g.a, "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "get_showDocumentPreviewActionLiveData", "()Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showDocumentPreviewActionLiveData", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "i", "_cancelActionLiveData", "getCancelVerification", "cancelVerification", "h", "get_showWebUrlActionLiveData", "_showWebUrlActionLiveData", "getShowDocumentPreview", "showDocumentPreview", "<init>", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseViewModel extends com.sumsub.sns.core.presentation.base.SNSBaseViewModel {
    @NotNull
    public final ActionLiveData<Event<Document>> g = new ActionLiveData<>();
    @NotNull
    public final ActionLiveData<Event<Uri>> h = new ActionLiveData<>();
    public final ActionLiveData<Event<SNSCompletionResult>> i = new ActionLiveData<>();

    @NotNull
    public final LiveData<Event<SNSCompletionResult>> getCancelVerification() {
        return this.i;
    }

    @NotNull
    public final LiveData<Event<Document>> getShowDocumentPreview() {
        return this.g;
    }

    @NotNull
    public final LiveData<Event<Uri>> getShowWebUrl() {
        return this.h;
    }

    @NotNull
    public final ActionLiveData<Event<Document>> get_showDocumentPreviewActionLiveData() {
        return this.g;
    }

    @NotNull
    public final ActionLiveData<Event<Uri>> get_showWebUrlActionLiveData() {
        return this.h;
    }

    @Override // com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        super.onHandleError(error);
        if (error instanceof Error.Network) {
            onLoad();
        } else if (error instanceof Error.Init) {
            onLoad();
        } else if (error instanceof Error.Common) {
            SNSCompletionResult.AbnormalTermination abnormalTermination = new SNSCompletionResult.AbnormalTermination(((Error.Common) error).getException());
            Timber.d("Completion the SDK with result - " + abnormalTermination, new Object[0]);
            this.i.setValue(new Event<>(abnormalTermination));
        }
    }

    public void onLoad() {
    }
}
