package com.avito.android.delivery.map.point_info;

import com.avito.android.remote.model.delivery.DeliveryMultiPointDetailInfo;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoInteractor;", "", "", "fiasId", "itemId", "", "serviceIds", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "getDeliveryPointShortInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsPointInfoInteractor {
    @NotNull
    Observable<LoadingState<DeliveryMultiPointDetailInfo>> getDeliveryPointShortInfo(@NotNull String str, @Nullable String str2, @NotNull List<String> list);
}
