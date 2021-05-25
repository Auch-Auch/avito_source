package com.avito.android.advert_core.delivery;

import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "getDeliveryData", "()Lio/reactivex/rxjava3/core/Observable;", "", "newValue", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "advertItemToggleDelivery", "(Z)Lio/reactivex/rxjava3/core/Observable;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDeliveryBlockRepository {
    @NotNull
    Observable<LoadingState<AdvertDeliverySwitchResponse>> advertItemToggleDelivery(boolean z);

    @NotNull
    Observable<AdvertDeliveryC2C> getDeliveryData();
}
