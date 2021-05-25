package com.avito.android.util.preferences;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/util/preferences/MessengerContract;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUNREAD_MESSAGES_COUNTER", "()Ljava/lang/String;", "UNREAD_MESSAGES_COUNTER", AuthSource.SEND_ABUSE, "getUNREAD_COUNTERS_UPDATE_TIME", "UNREAD_COUNTERS_UPDATE_TIME", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerContract {
    @NotNull
    public static final MessengerContract INSTANCE = new MessengerContract();
    @NotNull
    public static final String a = a.c3("messenger_", "unread_counters_update_time");
    @NotNull
    public static final String b = a.c3("messenger_", "unread_messages_count");

    @NotNull
    public final String getUNREAD_COUNTERS_UPDATE_TIME() {
        return a;
    }

    @NotNull
    public final String getUNREAD_MESSAGES_COUNTER() {
        return b;
    }
}
