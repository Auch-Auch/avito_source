package com.avito.android.service_subscription;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.service_subscription_legacy.ServiceSubscriptionResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "loadServiceSubscription", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "orderCallback", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ServiceSubscriptionInteractor {
    @NotNull
    Observable<LoadingState<ServiceSubscriptionResponse>> loadServiceSubscription();

    @NotNull
    Observable<LoadingState<SuccessResult>> orderCallback();
}
