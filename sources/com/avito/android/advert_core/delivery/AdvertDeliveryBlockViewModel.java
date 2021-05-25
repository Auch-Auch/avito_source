package com.avito.android.advert_core.delivery;

import androidx.lifecycle.LiveData;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "", "", "newValue", "", "onSwitchChanged", "(Z)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock;", "getDataChanges", "()Landroidx/lifecycle/LiveData;", "dataChanges", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "getSwitchProgressChanges", "switchProgressChanges", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDeliveryBlockViewModel {
    @NotNull
    LiveData<AdvertDeliveryBlock> getDataChanges();

    @NotNull
    LiveData<LoadingState<AdvertDeliverySwitchResponse>> getSwitchProgressChanges();

    void onSwitchChanged(boolean z);
}
