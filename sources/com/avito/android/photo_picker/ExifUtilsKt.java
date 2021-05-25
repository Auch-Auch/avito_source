package com.avito.android.photo_picker;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0005\u001a#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\u00020\u0007*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\r\u001a\u0004\u0018\u00010\u0002*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u000e\"\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011*&\u0010\u0013\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0014"}, d2 = {"Landroidx/exifinterface/media/ExifInterface;", "", "", "Lcom/avito/android/photo_picker/ExifAttributesCollection;", "getAttributes", "(Landroidx/exifinterface/media/ExifInterface;)Ljava/util/Map;", "data", "", "setAttributesAndSave", "(Landroidx/exifinterface/media/ExifInterface;Ljava/util/Map;)V", "extraData", "setExtraData", "(Ljava/util/Map;Ljava/lang/String;)V", "getExtraData", "(Ljava/util/Map;)Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "FIELDS", "ExifAttributesCollection", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ExifUtilsKt {
    public static final Set<String> a = y.setOf((Object[]) new String[]{ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_X_RESOLUTION, ExifInterface.TAG_Y_RESOLUTION, ExifInterface.TAG_RESOLUTION_UNIT, ExifInterface.TAG_DATETIME, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_FLASHPIX_VERSION, ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_GAMMA, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_SENSING_METHOD, ExifInterface.TAG_FILE_SOURCE, ExifInterface.TAG_SCENE_TYPE, ExifInterface.TAG_CFA_PATTERN, ExifInterface.TAG_CUSTOM_RENDERED, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_SCENE_CAPTURE_TYPE, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_CONTRAST, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_IMAGE_UNIQUE_ID, "CameraOwnerName", ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DIFFERENTIAL});

    @NotNull
    public static final Map<String, String> getAttributes(@NotNull ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "$this$getAttributes");
        Set<String> set = a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : set) {
            linkedHashMap.put(t, exifInterface.getAttribute(t));
        }
        return linkedHashMap;
    }

    @Nullable
    public static final String getExtraData(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "$this$getExtraData");
        String str = map.get(ExifInterface.TAG_USER_COMMENT);
        if (str != null) {
            return StringsKt__StringsKt.trim(str).toString();
        }
        return null;
    }

    public static final void setAttributesAndSave(@NotNull ExifInterface exifInterface, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(exifInterface, "$this$setAttributesAndSave");
        Intrinsics.checkNotNullParameter(map, "data");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            exifInterface.setAttribute(entry.getKey(), entry.getValue());
        }
        try {
            exifInterface.saveAttributes();
        } catch (IOException e) {
            Logs.error(e);
        }
    }

    public static final void setExtraData(@NotNull Map<String, String> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(map, "$this$setExtraData");
        map.put(ExifInterface.TAG_USER_COMMENT, str);
    }
}
