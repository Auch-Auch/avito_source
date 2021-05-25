package ru.avito.messenger.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002\"\u0016\u0010\b\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0016\u0010\t\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0002\"\u0016\u0010\n\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0016\u0010\u000b\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006\"8\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\r8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u00048\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006\"\u0016\u0010\u0014\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0002\"\u0016\u0010\u0015\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0002¨\u0006\u0016"}, d2 = {"", "DEFAULT_JSONRPC_TIMEOUT_MS", "J", "DEFAULT_TIME_TO_MODIFY_MESSAGE_MS", "", "DEFAULT_IMAGE_UPLOAD_ENDPOINT", "Ljava/lang/String;", "DEFAULT_PING_TIMEOUT_MS", "DEFAULT_COMMAND_TIMEOUT_MS", "DEFAULT_READ_TIMEOUT_MS", "DEFAULT_ENDPOINT", "LOG_TAG", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", AuthSource.SEND_ABUSE, "Ljava/util/LinkedHashMap;", "getDEFAULT_PARAMS", "()Ljava/util/LinkedHashMap;", "DEFAULT_PARAMS", "DEFAULT_ORIGIN", "DEFAULT_CONNECT_TIMEOUT_MS", "DEFAULT_UPLOAD_TIMEOUT_MS", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ConstantsKt {
    public static final long DEFAULT_COMMAND_TIMEOUT_MS = 15000;
    public static final long DEFAULT_CONNECT_TIMEOUT_MS = 15000;
    @NotNull
    public static final String DEFAULT_ENDPOINT = "https://socket.avito.ru/socket";
    @NotNull
    public static final String DEFAULT_IMAGE_UPLOAD_ENDPOINT = "https://socket.avito.ru/images";
    public static final long DEFAULT_JSONRPC_TIMEOUT_MS = 15000;
    @NotNull
    public static final String DEFAULT_ORIGIN = "https://www.avito.ru";
    public static final long DEFAULT_PING_TIMEOUT_MS = 15000;
    public static final long DEFAULT_READ_TIMEOUT_MS = 15000;
    public static final long DEFAULT_TIME_TO_MODIFY_MESSAGE_MS = 3600000;
    public static final long DEFAULT_UPLOAD_TIMEOUT_MS = 15000;
    @NotNull
    public static final String LOG_TAG = "Messenger";
    @NotNull
    public static final LinkedHashMap<String, String> a = new LinkedHashMap<>();

    @NotNull
    public static final LinkedHashMap<String, String> getDEFAULT_PARAMS() {
        return a;
    }
}
