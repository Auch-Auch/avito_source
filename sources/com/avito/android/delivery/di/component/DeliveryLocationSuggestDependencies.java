package com.avito.android.delivery.di.component;

import com.avito.android.remote.LocationApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestDependencies;", "Lcom/avito/android/delivery/di/component/DeliveryRdsCommonDependencies;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "()Lcom/avito/android/remote/LocationApi;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryLocationSuggestDependencies extends DeliveryRdsCommonDependencies {
    @Override // com.avito.android.location_list.di.LocationListDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.location.di.LocationDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    LocationApi locationApi();
}
