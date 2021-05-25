package com.avito.android.user_adverts_common.charity.events;

import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", SDKConstants.PARAM_USER_ID, "advertID", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;", "source", "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "getCharityButtonClickEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;)Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "user-adverts-common_release"}, k = 2, mv = {1, 4, 2})
public final class CharityButtonClickEventKt {

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

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003f: APUT  
      (r1v1 kotlin.Pair[])
      (2 ??[int, float, short, byte, char])
      (wrap: kotlin.Pair : 0x003b: INVOKE  (r9v6 kotlin.Pair) = 
      ("source")
      (wrap: java.lang.Integer : 0x0037: INVOKE  (r9v5 java.lang.Integer) = (r10v2 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
     */
    @NotNull
    public static final ParametrizedClickStreamEvent getCharityButtonClickEvent(@NotNull String str, @NotNull String str2, @NotNull CharityInteractor.Source source) {
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
        return new ParametrizedClickStreamEvent(4741, 2, r.mapOf(pairArr), null, 8, null);
    }
}
