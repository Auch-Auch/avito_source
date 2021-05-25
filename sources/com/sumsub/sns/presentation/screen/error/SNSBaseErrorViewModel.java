package com.sumsub.sns.presentation.screen.error;

import androidx.lifecycle.LiveData;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/presentation/screen/error/SNSBaseErrorViewModel;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "", "onCloseClicked", "()V", "Lcom/sumsub/sns/core/data/model/Error;", "getType", "()Lcom/sumsub/sns/core/data/model/Error;", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "j", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_closeActionLiveData", "Landroidx/lifecycle/LiveData;", "getClose", "()Landroidx/lifecycle/LiveData;", "close", "<init>", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseErrorViewModel extends SNSBaseViewModel {
    public final ActionLiveData<Event<Error>> j = new ActionLiveData<>();

    @NotNull
    public final LiveData<Event<Error>> getClose() {
        return this.j;
    }

    @NotNull
    public abstract Error getType();

    public final void onCloseClicked() {
        this.j.setValue(new Event<>(getType()));
    }
}
