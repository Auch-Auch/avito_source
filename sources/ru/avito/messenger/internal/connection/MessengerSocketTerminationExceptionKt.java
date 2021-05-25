package ru.avito.messenger.internal.connection;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.connection.MessengerSocketTerminationException;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "toMessengerSocketTerminationException", "(Lru/avito/messenger/internal/entity/messenger/TerminationEvent;)Lru/avito/messenger/internal/connection/MessengerSocketTerminationException;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessengerSocketTerminationExceptionKt {
    @NotNull
    public static final MessengerSocketTerminationException toMessengerSocketTerminationException(@NotNull TerminationEvent terminationEvent) {
        Intrinsics.checkNotNullParameter(terminationEvent, "$this$toMessengerSocketTerminationException");
        if (terminationEvent instanceof TerminationEvent.UnauthorizedError) {
            return new MessengerSocketTerminationException.UnauthorizedError(((TerminationEvent.UnauthorizedError) terminationEvent).getError());
        }
        if (terminationEvent instanceof TerminationEvent.ForbiddenError) {
            return new MessengerSocketTerminationException.ForbiddenError(((TerminationEvent.ForbiddenError) terminationEvent).getError());
        }
        if (terminationEvent instanceof TerminationEvent.ClosedByUser) {
            return new MessengerSocketTerminationException.ClosedByUser();
        }
        if (terminationEvent instanceof TerminationEvent.NetworkError) {
            return new MessengerSocketTerminationException.NetworkError(((TerminationEvent.NetworkError) terminationEvent).getError());
        }
        if (terminationEvent instanceof TerminationEvent.Unknown) {
            TerminationEvent.Unknown unknown = (TerminationEvent.Unknown) terminationEvent;
            return new MessengerSocketTerminationException.Unknown(unknown.getReason(), unknown.getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
