package com.avito.android.authorization.login_suggests.events;

import com.avito.android.analytics.clickstream.event.HasSensitiveData;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.util.Collections;
import com.avito.android.util.Strings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/authorization/login_suggests/events/SuggestClickedEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "Lcom/avito/android/analytics/clickstream/event/HasSensitiveData;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "login", "social", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestClickedEvent implements ClickStreamEvent, HasSensitiveData {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public SuggestClickedEvent() {
        this(null, null, 3, null);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002c: APUT  
      (r0v1 kotlin.Pair[])
      (0 ??[int, short, byte, char])
      (wrap: kotlin.Pair : 0x0027: INVOKE  (r3v1 kotlin.Pair) = ("login_type"), (r3v0 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public SuggestClickedEvent(@Nullable String str, @Nullable String str2) {
        String str3;
        Pair[] pairArr = new Pair[4];
        if (str == null || !Strings.isPhone(str)) {
            str3 = (str == null || !Strings.isEmail(str)) ? str2 != null ? "social" : "" : "email";
        } else {
            str3 = "phone";
        }
        pairArr[0] = TuplesKt.to("login_type", str3);
        pairArr[1] = TuplesKt.to(AuthParamsKt.KEY_SOCIAL_ID, Long.valueOf(SuggestClickedEventKt.access$convertToEventId(str2)));
        pairArr[2] = TuplesKt.to("phone", (str == null || !Strings.isPhone(str)) ? null : str);
        pairArr[3] = TuplesKt.to("email", (str == null || !Strings.isEmail(str)) ? null : str);
        this.a = new ParametrizedClickStreamEvent(2817, 2, Collections.filterValuesNotNull(r.mapOf(pairArr)), null, 8, null);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuggestClickedEvent(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
