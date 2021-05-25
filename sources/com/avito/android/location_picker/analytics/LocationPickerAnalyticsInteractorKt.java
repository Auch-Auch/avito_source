package com.avito.android.location_picker.analytics;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"location-picker_release"}, k = 2, mv = {1, 4, 2})
public final class LocationPickerAnalyticsInteractorKt {
    public static final Long access$toKilometers(Long l) {
        if (l != null) {
            return Long.valueOf(l.longValue() / ((long) 1000));
        }
        return null;
    }
}
