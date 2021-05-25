package com.avito.android.location;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/location/LocationSource;", "", "", "getAnalyticsOrdinal", "()I", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LOCATION_FROM_COORDS", "LOCATION_FROM_LIST", "LOCATION_FROM_FILTERS", "LOCATION_FROM_DEEPLINK", "LOCATION_FROM_EXTERNAL_LINK", "LOCATION_FROM_LAAS", "LOCATION_FOR_SEARCH", "user-location_release"}, k = 1, mv = {1, 4, 2})
public enum LocationSource {
    LOCATION_FROM_COORDS("location_from_coords"),
    LOCATION_FROM_LIST("location_from_list"),
    LOCATION_FROM_FILTERS("location_from_filters"),
    LOCATION_FROM_DEEPLINK("location_from_deeplink"),
    LOCATION_FROM_EXTERNAL_LINK("location_from_external_link"),
    LOCATION_FROM_LAAS("location_from_laas"),
    LOCATION_FOR_SEARCH("location_for_search");
    
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LocationSource.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
            iArr[5] = 6;
            iArr[6] = 7;
        }
    }

    /* access modifiers changed from: public */
    LocationSource(String str) {
        this.a = str;
    }

    public final int getAnalyticsOrdinal() {
        switch (ordinal()) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 8;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
