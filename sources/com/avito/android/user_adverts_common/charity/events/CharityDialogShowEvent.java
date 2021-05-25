package com.avito.android.user_adverts_common.charity.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_adverts_common/charity/events/CharityDialogShowEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", SDKConstants.PARAM_USER_ID, "advertID", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public final class CharityDialogShowEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CharityInteractor.Source.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0042: APUT  
      (r1v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x003e: INVOKE  (r10v6 kotlin.Pair) = 
      ("source")
      (wrap: java.lang.Integer : 0x003a: INVOKE  (r10v5 java.lang.Integer) = (r11v2 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    public CharityDialogShowEvent(@NotNull String str, @NotNull String str2, @NotNull CharityInteractor.Source source) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_USER_ID);
        Intrinsics.checkNotNullParameter(str2, "advertID");
        Intrinsics.checkNotNullParameter(source, "source");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("uid", str);
        Pair pair = TuplesKt.to("iid", str2);
        int i = 1;
        pairArr[1] = pair;
        int ordinal = source.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                i = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        pairArr[2] = TuplesKt.to("source", Integer.valueOf(i));
        this.a = new ParametrizedClickStreamEvent(4748, 0, r.mapOf(pairArr), null, 8, null);
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
