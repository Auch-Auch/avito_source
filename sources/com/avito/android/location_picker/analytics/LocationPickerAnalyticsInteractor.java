package com.avito.android.location_picker.analytics;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "state", "", "trackScreenOpened", "(Lcom/avito/android/location_picker/entities/LocationPickerState;)V", "Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "trackScreenClosed", "(Lcom/avito/android/location_picker/entities/LocationPickerState;Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerAnalyticsInteractor {
    void trackScreenClosed(@NotNull LocationPickerState locationPickerState, @NotNull ScreenCloseFromBlock screenCloseFromBlock);

    void trackScreenOpened(@NotNull LocationPickerState locationPickerState);
}
