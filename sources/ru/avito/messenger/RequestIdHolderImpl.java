package ru.avito.messenger;

import com.avito.android.remote.auth.AuthSource;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038V@VX\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/avito/messenger/RequestIdHolderImpl;", "Lru/avito/messenger/RequestIdHolder;", "Lru/avito/messenger/RequestIdGenerator;", "", "generateRequestId", "()Ljava/lang/String;", "<set-?>", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRequestId", "setRequestId", "(Ljava/lang/String;)V", "requestId", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class RequestIdHolderImpl implements RequestIdHolder, RequestIdGenerator {
    @NotNull
    public String a = "";

    @Override // ru.avito.messenger.RequestIdGenerator
    @NotNull
    public String generateRequestId() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        setRequestId(uuid);
        return uuid;
    }

    @Override // ru.avito.messenger.RequestIdHolder
    @NotNull
    public synchronized String getRequestId() {
        return this.a;
    }

    public synchronized void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }
}
