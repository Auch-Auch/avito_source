package com.avito.android.advert_core.analytics.delivery;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/analytics/delivery/DeliveryButtonItemClickEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", BookingInfoActivity.EXTRA_ITEM_ID, ChannelContext.Item.USER_ID, "categoryId", "source", "", "isUserAuth", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryButtonItemClickEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public DeliveryButtonItemClickEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        a.b1(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, ChannelContext.Item.USER_ID, str3, "categoryId", str4, "source");
        this.a = new ParametrizedClickStreamEvent(2483, 1, r.mapOf(TuplesKt.to("iid", str), TuplesKt.to("uid", str2), TuplesKt.to("cid", str3), TuplesKt.to("scrp", str4), TuplesKt.to("is_user_auth", Boolean.valueOf(z))), "Avito.Delivery / Создание заказа на доставку / Клик на  кнопку \"купить с доставкой\"");
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
