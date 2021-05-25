package com.avito.android.analytics.event.cart;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Collections;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.SearchContextWrapperKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B/\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/analytics/event/cart/OpenCartEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "source", "cartItemsQuantity", "Lcom/avito/android/util/SearchContextWrapper;", "searchContextWrapper", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;Ljava/lang/Integer;Lcom/avito/android/util/SearchContextWrapper;)V", "Source", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class OpenCartEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSrcp", "()Ljava/lang/String;", "srcp", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ADVERT_BOTTOM_SHEET", "ADVERT_BUTTON", "CART_FAB", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public enum Source {
        ADVERT_BOTTOM_SHEET("button_bottom_sheet"),
        ADVERT_BUTTON(PhonePageSourceKt.PHONE_SOURCE_BUTTON),
        CART_FAB("icon");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        Source(String str) {
            this.a = str;
        }

        @NotNull
        public final String getSrcp() {
            return this.a;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0021: APUT  
      (r2v0 kotlin.Pair[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x001c: INVOKE  (r6v2 kotlin.Pair) = ("srcp"), (r6v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public OpenCartEvent(@Nullable String str, @Nullable Source source, @Nullable Integer num, @Nullable SearchContextWrapper searchContextWrapper) {
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("iid", str);
        String str2 = null;
        pairArr[1] = TuplesKt.to("srcp", source != null ? source.getSrcp() : null);
        pairArr[2] = TuplesKt.to("block_items_display", num);
        pairArr[3] = TuplesKt.to("x", searchContextWrapper != null ? SearchContextWrapperKt.extractSearchXFromContext(searchContextWrapper) : str2);
        this.a = new ParametrizedClickStreamEvent(4647, 4, Collections.filterValuesNotNull(r.mapOf(pairArr)), "Avito.Marketplace / Корзина / Переход на страницу корзины");
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }
}
