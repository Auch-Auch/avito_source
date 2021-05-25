package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.user_profile.Phone;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/event/PhoneClickedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/remote/model/user_profile/Phone;", "phone", "otherPhonesCount", "<init>", "(Lcom/avito/android/remote/model/user_profile/Phone;I)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneClickedEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003e: APUT  
      (r1v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x0039: INVOKE  (r10v3 kotlin.Pair) = 
      ("item_number")
      (wrap: java.lang.String : 0x0033: INVOKE  (r10v2 java.lang.String) = (r2v2 int) type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public PhoneClickedEvent(@NotNull Phone phone, int i) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Pair[] pairArr = new Pair[4];
        int i2 = 0;
        pairArr[0] = TuplesKt.to("phone", phone.getPhone());
        pairArr[1] = TuplesKt.to("is_verified", Boolean.valueOf(phone.getVerified()));
        Integer itemsCount = phone.getItemsCount();
        pairArr[2] = TuplesKt.to("item_number", String.valueOf(itemsCount != null ? itemsCount.intValue() : i2));
        pairArr[3] = TuplesKt.to("other_phones_number", Integer.valueOf(i));
        this.a = new ParametrizedClickStreamEvent(2831, 1, r.mapOf(pairArr), null, 8, null);
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
