package com.avito.android.advert_core.utils;

import android.content.res.Resources;
import com.avito.android.remote.model.LocationInfo;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/advert_core/utils/LocationUtils;", "", "<init>", "()V", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class LocationUtils {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_core/utils/LocationUtils$Companion;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/model/LocationInfo;", "loc", "", "generateFullAddress", "(Landroid/content/res/Resources;Lcom/avito/android/remote/model/LocationInfo;)Ljava/lang/String;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final String generateFullAddress(@NotNull Resources resources, @NotNull LocationInfo locationInfo) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            Intrinsics.checkNotNullParameter(locationInfo, "loc");
            StringBuilder sb = new StringBuilder();
            if (locationInfo.hasLocation()) {
                sb.append(locationInfo.getLocationName());
            }
            boolean z = true;
            if (locationInfo.hasMetro()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(resources.getString(R.string.metro_prefix));
                sb.append(locationInfo.getMetroName());
            }
            if (locationInfo.hasDistrict()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(locationInfo.getDistrictName());
                sb.append(resources.getString(R.string.district_suffix));
            }
            if (locationInfo.hasAddress()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(locationInfo.getAddress());
            }
            if (locationInfo.hasDirection()) {
                if (sb.length() <= 0) {
                    z = false;
                }
                if (z) {
                    sb.append(", ");
                }
                sb.append(locationInfo.getDirectionName());
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "address.toString()");
            return sb2;
        }

        public Companion(j jVar) {
        }
    }

    @JvmStatic
    @NotNull
    public static final String generateFullAddress(@NotNull Resources resources, @NotNull LocationInfo locationInfo) {
        return Companion.generateFullAddress(resources, locationInfo);
    }
}
