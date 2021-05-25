package com.avito.android.calls_shared;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/calls_shared/InAppCallsConfig;", "", "", "", AuthSource.SEND_ABUSE, "[Ljava/lang/String;", "getLOG_TAG_WHITE_LIST", "()[Ljava/lang/String;", "LOG_TAG_WHITE_LIST", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallsConfig {
    @NotNull
    public static final InAppCallsConfig INSTANCE = new InAppCallsConfig();
    @NotNull
    public static final String[] a = {LogTagsKt.TAG_IAC, LogTagsKt.TAG_VOX_CLIENT, LogTagsKt.TAG_CALL_MANAGER, LogTagsKt.TAG_CALL_MANAGER_SERVICE, LogTagsKt.TAG_CALL_PRESENTER, LogTagsKt.TAG_CALL_INTERACTOR, LogTagsKt.TAG_CALL_EVENT_TRACKER};

    @NotNull
    public final String[] getLOG_TAG_WHITE_LIST() {
        return a;
    }
}
