package com.avito.android.analytics.provider.clickstream;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.db.SavedSearchesContract;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b#\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/avito/android/analytics/provider/clickstream/ScreenIdField;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MAIN", "SERP", "ADVERT_DETAILS", "MY_ADVERT_DETAILS", "CHANNELS", "CHANNEL", "AUTHENTICATION", "SHOPS_LIST", "SHOP_DETAILS", "ADVERT_EDIT", "PROFILE", "PUBLIC_PROFILE", "PUBLISH_WIZARD", "PROFILE_ITEMS", "FAVORITE_ITEMS", "DELIVERY_ORDER", "FILTERS", "CATEGORY", "SAVED_SEARCHES", "NOTIFICATIONS", "MESSENGER", "MESSENGER_RECOMMENDATIONS", "SETTINGS", "NEW_ADVERT", "AUTO_CATALOG", "BRANDSPACE", "EXTENDED_PROFILE", "analytics_release"}, k = 1, mv = {1, 4, 2})
public enum ScreenIdField {
    MAIN("main"),
    SERP("serp"),
    ADVERT_DETAILS("item"),
    MY_ADVERT_DETAILS("profile_item"),
    CHANNELS(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS),
    CHANNEL("channel"),
    AUTHENTICATION(SocialButtonClickedEventKt.AUTH),
    SHOPS_LIST("shops_list"),
    SHOP_DETAILS("shop_info"),
    ADVERT_EDIT("edit_item"),
    PROFILE("profile"),
    PUBLIC_PROFILE("public_profile"),
    PUBLISH_WIZARD("publish_wizard"),
    PROFILE_ITEMS(BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT),
    FAVORITE_ITEMS("favorite_items"),
    DELIVERY_ORDER("delivery_order_create"),
    FILTERS("filters"),
    CATEGORY("category"),
    SAVED_SEARCHES(SavedSearchesContract.TABLE_NAME),
    NOTIFICATIONS("notifications"),
    MESSENGER("messenger"),
    MESSENGER_RECOMMENDATIONS("msg_recommendations"),
    SETTINGS("settings"),
    NEW_ADVERT("new_advert"),
    AUTO_CATALOG(AdvertDetailsAnalyticsInteractorKt.PAGE_TYPE_AUTO_CARD),
    BRANDSPACE(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE),
    EXTENDED_PROFILE("extended_profile");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    ScreenIdField(String str) {
        this.a = str;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }
}
