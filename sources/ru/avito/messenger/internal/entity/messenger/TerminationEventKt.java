package ru.avito.messenger.internal.entity.messenger;

import com.avito.android.jsonrpc.client.JsonRpcCallException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import ru.avito.websocket.RxWebSocketState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "toTerminationEvent", "(Ljava/lang/Throwable;)Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "Lru/avito/websocket/RxWebSocketState$Disconnected;", "(Lru/avito/websocket/RxWebSocketState$Disconnected;)Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class TerminationEventKt {
    public static final TerminationEvent access$determineEvent(int i, String str, Throwable th) {
        if (i != -32043) {
            if (!(i == -32041 || i == 401)) {
                if (i != 403) {
                    if (i == 1000) {
                        return new TerminationEvent.ClosedByUser();
                    }
                    if (i != 3401) {
                        if (i != 3403) {
                            return new TerminationEvent.Unknown(Integer.valueOf(i), str, th);
                        }
                    }
                }
            }
            return new TerminationEvent.UnauthorizedError(i, th);
        }
        return new TerminationEvent.ForbiddenError(th);
    }

    @NotNull
    public static final TerminationEvent toTerminationEvent(@Nullable Throwable th) {
        if (th instanceof JsonRpcCallException) {
            int code = ((JsonRpcCallException) th).getCode();
            String message = th.getMessage();
            if (code != -32043) {
                if (!(code == -32041 || code == 401)) {
                    if (code != 403) {
                        if (code == 1000) {
                            return new TerminationEvent.ClosedByUser();
                        }
                        if (code != 3401) {
                            if (code != 3403) {
                                return new TerminationEvent.Unknown(Integer.valueOf(code), message, th);
                            }
                        }
                    }
                }
                return new TerminationEvent.UnauthorizedError(code, th);
            }
            return new TerminationEvent.ForbiddenError(th);
        } else if (th instanceof IOException) {
            return new TerminationEvent.NetworkError(th);
        } else {
            return new TerminationEvent.Unknown(null, th != null ? th.getMessage() : null, th);
        }
    }

    @NotNull
    public static final TerminationEvent toTerminationEvent(@NotNull RxWebSocketState.Disconnected disconnected) {
        Intrinsics.checkNotNullParameter(disconnected, "$this$toTerminationEvent");
        if (disconnected.getError() instanceof IOException) {
            return new TerminationEvent.NetworkError(disconnected.getError());
        }
        int code = disconnected.getCode();
        String reason = disconnected.getReason();
        Throwable error = disconnected.getError();
        if (code != -32043) {
            if (!(code == -32041 || code == 401)) {
                if (code != 403) {
                    if (code == 1000) {
                        return new TerminationEvent.ClosedByUser();
                    }
                    if (code != 3401) {
                        if (code != 3403) {
                            return new TerminationEvent.Unknown(Integer.valueOf(code), reason, error);
                        }
                    }
                }
            }
            return new TerminationEvent.UnauthorizedError(code, error);
        }
        return new TerminationEvent.ForbiddenError(error);
    }
}
