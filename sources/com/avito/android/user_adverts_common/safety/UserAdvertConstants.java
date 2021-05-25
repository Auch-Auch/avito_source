package com.avito.android.user_adverts_common.safety;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/UserAdvertConstants;", "", "", "KEY_STATUS_MESSAGE", "Ljava/lang/String;", "KEY_SOA_UPDATE_MESSAGE", "KEY_ADVERT_ACTION", "", "SAFETY_INFO_BANNER_DELAY_MS", "J", "KEY_SHOULD_SHOW_APPRATER", "<init>", "()V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertConstants {
    @NotNull
    public static final UserAdvertConstants INSTANCE = new UserAdvertConstants();
    @NotNull
    public static final String KEY_ADVERT_ACTION = "advert_action";
    @NotNull
    public static final String KEY_SHOULD_SHOW_APPRATER = "should_show_app_rater";
    @NotNull
    public static final String KEY_SOA_UPDATE_MESSAGE = "soa_update_message";
    @NotNull
    public static final String KEY_STATUS_MESSAGE = "status_message";
    public static final long SAFETY_INFO_BANNER_DELAY_MS = 600;
}
