package com.avito.android.advert_core.analytics.sharing;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", AuthSource.BOOKING_ORDER, "I", "getVersion", "()I", "version", "", "", "", "c", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", AuthSource.SEND_ABUSE, "getEventId", "eventId", "<init>", "()V", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ItemSharingEvent implements ClickStreamEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a = 308;
    public final int b = 12;
    @NotNull
    public final Map<String, Object> c = new LinkedHashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, ChannelContext.Item.USER_ID, "", "socialNetworkId", "pageType", "", "authorized", "Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent;", "createForAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent;", "developmentsId", "locationId", "createForDevelopmentsCatalog", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent;", "createForAutoCatalog", "()Lcom/avito/android/advert_core/analytics/sharing/ItemSharingEvent;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ ItemSharingEvent createForAdvertDetails$default(Companion companion, String str, String str2, int i, String str3, Boolean bool, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                bool = null;
            }
            return companion.createForAdvertDetails(str, str2, i, str3, bool);
        }

        @NotNull
        public final ItemSharingEvent createForAdvertDetails(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str3, "pageType");
            return new ItemSharingEvent(str, str2, i, str3, bool, null);
        }

        @NotNull
        public final ItemSharingEvent createForAutoCatalog() {
            return new ItemSharingEvent(null);
        }

        @NotNull
        public final ItemSharingEvent createForDevelopmentsCatalog(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "developmentsId");
            return new ItemSharingEvent(str, str2, null);
        }

        public Companion(j jVar) {
        }
    }

    public ItemSharingEvent(String str, String str2, int i, String str3, Boolean bool, j jVar) {
        getParams().put("iid", str);
        getParams().put("oid", str2);
        getParams().put("snid", Integer.valueOf(i));
        getParams().put("pagetype", str3);
        if (bool != null) {
            getParams().put("is_auth", Boolean.valueOf(bool.booleanValue()));
        }
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.c;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b;
    }

    public ItemSharingEvent(String str, String str2, j jVar) {
        getParams().put("RealtyDevelopment_id", str);
        getParams().put("cid", 24);
        getParams().put("mcid", 4918);
        getParams().put("pagetype", "share button");
        if (str2 != null) {
            getParams().put("lid", str2);
        }
    }

    public ItemSharingEvent() {
        getParams().put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, ScreenIdField.AUTO_CATALOG.getId());
        getParams().put("pagetype", "share button");
    }

    public ItemSharingEvent(j jVar) {
        getParams().put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, ScreenIdField.AUTO_CATALOG.getId());
        getParams().put("pagetype", "share button");
    }
}
