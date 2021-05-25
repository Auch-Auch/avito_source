package com.avito.android.advert_core.analytics.closed_advert;

import com.avito.android.payment.SberbankOnlineKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0007\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"", SberbankOnlineKt.RESULT_SUCCESS, "Ljava/lang/String;", "NETWORK_ERROR", "CLOSED", "BLOCKED", "ACTIVE", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertDetailsLoadEventKt {
    @NotNull
    public static final String ACTIVE = "active";
    @NotNull
    public static final String BLOCKED = "blocked";
    @NotNull
    public static final String CLOSED = "closed";
    @NotNull
    public static final String NETWORK_ERROR = "network_error";
    @NotNull
    public static final String SUCCESS = "success";
}
