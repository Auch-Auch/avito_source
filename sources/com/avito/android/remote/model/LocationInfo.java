package com.avito.android.remote.model;

import com.avito.android.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/LocationInfo;", "", "", "hasLocation", "()Z", "hasMetro", "hasAddress", "", "getAddress", "()Ljava/lang/String;", "hasDirection", "hasDistrict", "hasCoordinates", "getDistrictName", "districtName", "getMetroName", "metroName", "getLocationName", Constants.LOCATION_NAME, "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "coordinates", "getDirectionName", "directionName", "models_release"}, k = 1, mv = {1, 4, 2})
public interface LocationInfo {
    @Nullable
    String getAddress();

    @Nullable
    Coordinates getCoordinates();

    @NotNull
    String getDirectionName();

    @NotNull
    String getDistrictName();

    @NotNull
    String getLocationName();

    @NotNull
    String getMetroName();

    boolean hasAddress();

    boolean hasCoordinates();

    boolean hasDirection();

    boolean hasDistrict();

    boolean hasLocation();

    boolean hasMetro();
}
