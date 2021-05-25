package com.avito.android.messenger;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/MessengerConstants;", "", "", "CREATE_CHANNEL_RESULT_FORBIDDEN", "I", "CREATE_CHANNEL_RESULT_UNAUTHORIZED", "CREATE_CHANNEL_RESULT_PHONE_VERIFICATION_REQUIRED", "CREATE_CHANNEL_RESULT_CANCELED", "", "ONLINE_STATUS_THRESHOLD_IN_SECONDS", "J", "STOP_TYPING_DELAY_MS", "CREATE_CHANNEL_AUTHENTICATED", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerConstants {
    public static final int CREATE_CHANNEL_AUTHENTICATED = 1;
    public static final int CREATE_CHANNEL_RESULT_CANCELED = 0;
    public static final int CREATE_CHANNEL_RESULT_FORBIDDEN = 43;
    public static final int CREATE_CHANNEL_RESULT_PHONE_VERIFICATION_REQUIRED = 60;
    public static final int CREATE_CHANNEL_RESULT_UNAUTHORIZED = 41;
    @NotNull
    public static final MessengerConstants INSTANCE = new MessengerConstants();
    public static final long ONLINE_STATUS_THRESHOLD_IN_SECONDS = 150;
    public static final long STOP_TYPING_DELAY_MS = 3000;
}
