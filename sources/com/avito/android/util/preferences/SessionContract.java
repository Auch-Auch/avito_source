package com.avito.android.util.preferences;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u0012\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/preferences/SessionContract;", "", "", "SESSION", "Ljava/lang/String;", "REFRESH_TOKEN", "SIGNATURE", "getSIGNATURE$annotations", "()V", "PUSH_TOKEN", "<init>", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SessionContract {
    @NotNull
    public static final SessionContract INSTANCE = new SessionContract();
    @NotNull
    public static final String PUSH_TOKEN = "push_token";
    @NotNull
    public static final String REFRESH_TOKEN = "refresh_token";
    @NotNull
    public static final String SESSION = "session";
    @NotNull
    public static final String SIGNATURE = "signature";

    @Deprecated(message = "Removed property. Don't write into it.")
    public static /* synthetic */ void getSIGNATURE$annotations() {
    }
}
