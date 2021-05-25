package com.avito.android.analytics.event;

import com.avito.android.analytics_adjust.AdjustTokenWithFirebaseName;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002\"\u0016\u0010\b\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0016\u0010\t\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0002\"\u0016\u0010\n\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0002¨\u0006\u000b"}, d2 = {"", "CALL_SOURCE_XL_ITEM", "Ljava/lang/String;", "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "adjustTokenWithFirebaseName", "CALL_SOURCE_ADVERT", "CALL_SOURCE_ITEM", "CALL_SOURCE_DISCOUNTS_DIALOG", "CALL_SOURCE_SAFE_SHOW_DIALOG", "analytics_release"}, k = 2, mv = {1, 4, 2})
public final class CallToSellerEventKt {
    @NotNull
    public static final String CALL_SOURCE_ADVERT = "r";
    @NotNull
    public static final String CALL_SOURCE_DISCOUNTS_DIALOG = "d";
    @NotNull
    public static final String CALL_SOURCE_ITEM = "s";
    @NotNull
    public static final String CALL_SOURCE_SAFE_SHOW_DIALOG = "o";
    @NotNull
    public static final String CALL_SOURCE_XL_ITEM = "xs";
    public static final AdjustTokenWithFirebaseName a = AdjustTokenWithFirebaseName.CALL_TO_SELLER;
}
