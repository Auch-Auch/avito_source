package com.avito.android.location_picker.providers;

import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "state", "", "trackSearchQueryChanged", "(Lcom/avito/android/location_picker/entities/LocationPickerState;)V", "trackAddressSuggestionSelected", "trackMapPositionChanged", "trackDevicePositionUsed", "trackTryToSaveEmptyAddress", "trackTryToSaveNotSuggestedAddress", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerAnalyticsProvider {
    void trackAddressSuggestionSelected(@NotNull LocationPickerState locationPickerState);

    void trackDevicePositionUsed(@NotNull LocationPickerState locationPickerState);

    void trackMapPositionChanged(@NotNull LocationPickerState locationPickerState);

    void trackSearchQueryChanged(@NotNull LocationPickerState locationPickerState);

    void trackTryToSaveEmptyAddress(@NotNull LocationPickerState locationPickerState);

    void trackTryToSaveNotSuggestedAddress(@NotNull LocationPickerState locationPickerState);
}
