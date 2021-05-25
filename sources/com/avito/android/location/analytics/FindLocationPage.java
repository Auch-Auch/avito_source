package com.avito.android.location.analytics;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/location/analytics/FindLocationPage;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "BUYER_ITEM_MAP", "SELLER_ITEM_MAP", "ADD_ADV_MAP", "SEARCH_MAP", "SMALL_RADIUS", "DELIVERY_MAP", "NEW_DEVELOPMENTS_MAP", "SHARING_MAP", "PLATFORM_MAP", "PVZ_MAP", "FIRST_LAUNCH", "OPEN_APP", "PROFILE", "DISTANCE_SORT", "user-location_release"}, k = 1, mv = {1, 4, 2})
public enum FindLocationPage {
    BUYER_ITEM_MAP("buyer_item_map"),
    SELLER_ITEM_MAP("seller_item_map"),
    ADD_ADV_MAP("add_map"),
    SEARCH_MAP("map"),
    SMALL_RADIUS("radius"),
    DELIVERY_MAP("delivery_map"),
    NEW_DEVELOPMENTS_MAP("new_developments"),
    SHARING_MAP("messenger_my_location"),
    PLATFORM_MAP("messenger_alien_location"),
    PVZ_MAP("pvz_map"),
    FIRST_LAUNCH("first_launch"),
    OPEN_APP("open_app"),
    PROFILE("profile"),
    DISTANCE_SORT("distance_sort");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    FindLocationPage(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
