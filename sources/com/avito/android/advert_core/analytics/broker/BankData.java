package com.avito.android.advert_core.analytics.broker;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/BankData;", "", "", "toJson", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "alias", AuthSource.SEND_ABUSE, "positionString", "", VKApiConst.POSITION, "<init>", "(ILjava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class BankData {
    public final String a;
    public final String b;

    public BankData(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "alias");
        this.b = str;
        this.a = i >= 0 ? String.valueOf(i) : BuildConfig.ADJUST_DEFAULT_TRACKER;
    }

    @NotNull
    public final String toJson() {
        StringBuilder L = a.L("{\"position\": ");
        L.append(this.a);
        L.append(", \"alias\": \"");
        return a.t(L, this.b, "\"}");
    }
}
