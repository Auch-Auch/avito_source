package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", AuthSource.SEND_ABUSE, "I", "getEventId", "()I", "eventId", AuthSource.BOOKING_ORDER, "getVersion", "version", "", "", "", "c", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public final class CallToSellerClickStreamEvent implements ClickStreamEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a = 2650;
    public final int b = 11;
    @NotNull
    public final Map<String, Object> c = new LinkedHashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019Ja\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent$Companion;", "", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "", BookingInfoActivity.EXTRA_ITEM_ID, "categoryId", "", "isFromCompany", UrlParams.METRO_ID, "userHashId", "locationId", "shopId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent;", "createTreeEvent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent;", "developmentsId", "createForDevelopmentsCatalog", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent;", "userKey", "createForExtendedProfile", "(Ljava/lang/String;)Lcom/avito/android/analytics/event/CallToSellerClickStreamEvent;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final CallToSellerClickStreamEvent createForDevelopmentsCatalog(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "developmentsId");
            return new CallToSellerClickStreamEvent(str, str2, null);
        }

        @NotNull
        public final CallToSellerClickStreamEvent createForExtendedProfile(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "userKey");
            return new CallToSellerClickStreamEvent(str, null);
        }

        @NotNull
        public final CallToSellerClickStreamEvent createTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @Nullable String str2, boolean z, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            return new CallToSellerClickStreamEvent(treeClickStreamParent, str, str2, z, str3, str4, str5, str6, i, null);
        }

        public Companion(j jVar) {
        }
    }

    public CallToSellerClickStreamEvent(TreeClickStreamParent treeClickStreamParent, String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i, j jVar) {
        Map<String, Object> emptyMap;
        getParams().putAll((treeClickStreamParent == null || (emptyMap = treeClickStreamParent.getParams()) == null) ? r.emptyMap() : emptyMap);
        getParams().put("iid", str);
        if (str2 != null) {
            getParams().put("cid", str2);
        }
        getParams().put("oc", Boolean.valueOf(z));
        if (str3 != null) {
            getParams().put("mid", str3);
        }
        if (str4 != null) {
            getParams().put("oid", str4);
        }
        if (str5 != null) {
            getParams().put("lid", str5);
        }
        if (str6 != null) {
            getParams().put("sid", str6);
        }
        getParams().put("from_block", Integer.valueOf(i));
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

    public CallToSellerClickStreamEvent(String str, String str2, j jVar) {
        getParams().put("RealtyDevelopment_id", str);
        getParams().put("cid", 24);
        getParams().put("mcid", 4918);
        getParams().put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, "develop_realty");
        if (str2 != null) {
            getParams().put("lid", str2);
        }
    }

    public CallToSellerClickStreamEvent(String str, j jVar) {
        getParams().put("user_key", str);
        getParams().put(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, "profile_services");
    }
}
