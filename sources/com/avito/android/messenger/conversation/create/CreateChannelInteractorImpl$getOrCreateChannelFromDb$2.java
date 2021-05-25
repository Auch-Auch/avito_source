package com.avito.android.messenger.conversation.create;

import com.avito.android.messenger.conversation.create.CreateChannelInteractor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "invoke", "(Ljava/lang/Throwable;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class CreateChannelInteractorImpl$getOrCreateChannelFromDb$2 extends FunctionReferenceImpl implements Function1<Throwable, CreateChannelInteractor.Result.Error> {
    public CreateChannelInteractorImpl$getOrCreateChannelFromDb$2(CreateChannelInteractorImpl createChannelInteractorImpl) {
        super(1, createChannelInteractorImpl, CreateChannelInteractorImpl.class, "mapErrorToResult", "mapErrorToResult(Ljava/lang/Throwable;)Lcom/avito/android/messenger/conversation/create/CreateChannelInteractor$Result$Error;", 0);
    }

    @NotNull
    public final CreateChannelInteractor.Result.Error invoke(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "p1");
        CreateChannelInteractorImpl createChannelInteractorImpl = (CreateChannelInteractorImpl) this.receiver;
        TerminationEvent fromThrowable = TerminationEvent.Companion.fromThrowable(th);
        if (fromThrowable instanceof TerminationEvent.NetworkError) {
            return CreateChannelInteractor.Result.Error.Network.INSTANCE;
        }
        if (fromThrowable instanceof TerminationEvent.UnauthorizedError) {
            return CreateChannelInteractor.Result.Error.Auth.INSTANCE;
        }
        if (fromThrowable instanceof TerminationEvent.ForbiddenError) {
            return CreateChannelInteractor.Result.Error.Forbidden.INSTANCE;
        }
        Integer code = fromThrowable.getCode();
        if (code != null && code.intValue() == -32060) {
            return CreateChannelInteractor.Result.Error.PhoneVerification.INSTANCE;
        }
        return new CreateChannelInteractor.Result.Error.Unknown(th);
    }
}
