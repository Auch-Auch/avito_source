package com.avito.android.location_picker.providers;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "", "", "count", "", "getAdvertsCountTitle", "(I)Ljava/lang/String;", "getFindMeButtonMargin", "()I", "findMeButtonMargin", "getRadiusPadding", "radiusPadding", "getRadiusWidgetOffset", "radiusWidgetOffset", "getAdvertsCountErrorMessage", "()Ljava/lang/String;", "advertsCountErrorMessage", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPickerResourceProvider {
    @NotNull
    String getAdvertsCountErrorMessage();

    @NotNull
    String getAdvertsCountTitle(int i);

    int getFindMeButtonMargin();

    int getRadiusPadding();

    int getRadiusWidgetOffset();
}
