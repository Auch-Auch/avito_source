package com.avito.android.advert.consultation_form.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/consultation_form/event/FindOfficeOfferSubmitEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "c", "I", "getVersion", "()I", "version", AuthSource.BOOKING_ORDER, "getEventId", "eventId", "", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "", "isPhoneValid", "iid", "<init>", "(IIZLjava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class FindOfficeOfferSubmitEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final int b;
    public final int c;

    public FindOfficeOfferSubmitEvent(int i, int i2, boolean z, @Nullable String str) {
        this.b = i;
        this.c = i2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cre_feature_test_phone_validation", Boolean.valueOf(z));
        if (str != null) {
            linkedHashMap.put("iid", str);
        }
        Unit unit = Unit.INSTANCE;
        this.a = linkedHashMap;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FindOfficeOfferSubmitEvent(int i, int i2, boolean z, String str, int i3, j jVar) {
        this((i3 & 1) != 0 ? 4640 : i, (i3 & 2) != 0 ? 3 : i2, z, str);
    }
}
