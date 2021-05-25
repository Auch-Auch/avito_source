package com.avito.android.location.di;

import com.avito.android.TopLocationInteractor;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.remote.LocationApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/location/di/LocationDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/remote/LocationApi;", "locationApi", "()Lcom/avito/android/remote/LocationApi;", "Lcom/avito/android/TopLocationInteractor;", "topLocationInteractor", "()Lcom/avito/android/TopLocationInteractor;", "Lcom/avito/android/location/SavedLocationStorage;", "savedLocationStorage", "()Lcom/avito/android/location/SavedLocationStorage;", "Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "backNavigationLocationInteractor", "()Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface LocationDependencies extends ComponentDependencies {
    @NotNull
    BackNavigationLocationInteractor backNavigationLocationInteractor();

    @Override // com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    LocationApi locationApi();

    @NotNull
    SavedLocationStorage savedLocationStorage();

    @NotNull
    TopLocationInteractor topLocationInteractor();
}
