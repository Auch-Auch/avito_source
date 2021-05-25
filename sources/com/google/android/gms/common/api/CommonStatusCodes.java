package com.google.android.gms.common.api;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.avito.android.payment.SberbankOnlineKt;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public class CommonStatusCodes {
    @RecentlyNonNull
    public static final int API_NOT_CONNECTED = 17;
    @RecentlyNonNull
    public static final int CANCELED = 16;
    @RecentlyNonNull
    public static final int CONNECTION_SUSPENDED_DURING_CALL = 20;
    @RecentlyNonNull
    public static final int DEVELOPER_ERROR = 10;
    @RecentlyNonNull
    public static final int ERROR = 13;
    @RecentlyNonNull
    public static final int INTERNAL_ERROR = 8;
    @RecentlyNonNull
    public static final int INTERRUPTED = 14;
    @RecentlyNonNull
    public static final int INVALID_ACCOUNT = 5;
    @RecentlyNonNull
    public static final int NETWORK_ERROR = 7;
    @RecentlyNonNull
    public static final int RECONNECTION_TIMED_OUT = 22;
    @RecentlyNonNull
    public static final int RECONNECTION_TIMED_OUT_DURING_UPDATE = 21;
    @RecentlyNonNull
    public static final int REMOTE_EXCEPTION = 19;
    @RecentlyNonNull
    public static final int RESOLUTION_REQUIRED = 6;
    @RecentlyNonNull
    @Deprecated
    public static final int SERVICE_DISABLED = 3;
    @RecentlyNonNull
    @Deprecated
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    @RecentlyNonNull
    public static final int SIGN_IN_REQUIRED = 4;
    @RecentlyNonNull
    public static final int SUCCESS = 0;
    @RecentlyNonNull
    public static final int SUCCESS_CACHE = -1;
    @RecentlyNonNull
    public static final int TIMEOUT = 15;

    @NonNull
    public static String getStatusCodeString(@RecentlyNonNull int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return SberbankOnlineKt.RESULT_SUCCESS;
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return a.m2(32, "unknown status code: ", i);
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
