package com.sumsub.sns.core.presentation.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR%\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR,\u0010$\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060 j\u0002`!0\u000e0\r8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R(\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u0019\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010\u0017R#\u0010+\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060 j\u0002`!0\u000e0\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010\u0017¨\u0006-"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onBackClicked", "()V", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "", "url", "onLinkClicked", "(Ljava/lang/String;)V", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "", "f", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "getShowSupport", "()Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "showSupport", "Landroidx/lifecycle/LiveData;", "getFinish", "()Landroidx/lifecycle/LiveData;", "finish", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "get_showProgressLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_showProgressLiveData", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "get_throwErrorActionLiveData", "_throwErrorActionLiveData", "d", "get_finishActionLiveData", "_finishActionLiveData", "getShowProgress", "showProgress", "getThrowError", "throwError", "<init>", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseViewModel extends ViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    @NotNull
    public final ActionLiveData<Event<Object>> d = new ActionLiveData<>();
    @NotNull
    public final ActionLiveData<Event<Exception>> e = new ActionLiveData<>();
    @NotNull
    public final ActionLiveData<Event<Object>> f = new ActionLiveData<>();

    @NotNull
    public final LiveData<Event<Object>> getFinish() {
        return this.d;
    }

    @NotNull
    public final LiveData<Boolean> getShowProgress() {
        return this.c;
    }

    @NotNull
    public final ActionLiveData<Event<Object>> getShowSupport() {
        return this.f;
    }

    @NotNull
    public final LiveData<Event<Exception>> getThrowError() {
        return this.e;
    }

    @NotNull
    public final ActionLiveData<Event<Object>> get_finishActionLiveData() {
        return this.d;
    }

    @NotNull
    public final MutableLiveData<Boolean> get_showProgressLiveData() {
        return this.c;
    }

    @NotNull
    public final ActionLiveData<Event<Exception>> get_throwErrorActionLiveData() {
        return this.e;
    }

    public void onBackClicked() {
        this.d.setValue(new Event<>(new Object()));
    }

    public void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Timber.d("Handle error: " + error, new Object[0]);
    }

    public final void onLinkClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Timber.d("An user has clicked on " + str, new Object[0]);
        if (Intrinsics.areEqual(str, SNSConstants.LinkType.SUPPORT)) {
            this.f.setValue(new Event<>(new Object()));
        }
    }
}
