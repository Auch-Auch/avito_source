package com.avito.android.vas_discount;

import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_discount/DiscountActivityViewModel;", "", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/DiscountResponse;", "getDataChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "dataChanges", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public interface DiscountActivityViewModel {
    @NotNull
    SingleLiveEvent<LoadingState<DiscountResponse>> getDataChanges();
}
