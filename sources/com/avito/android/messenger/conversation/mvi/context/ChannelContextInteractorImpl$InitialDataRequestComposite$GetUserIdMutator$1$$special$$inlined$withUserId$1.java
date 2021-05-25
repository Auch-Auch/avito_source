package com.avito.android.messenger.conversation.mvi.context;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"R", "Larrow/core/Option;", "", "userIdOption", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$withUserId$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$InitialDataRequestComposite$GetUserIdMutator$1$$special$$inlined$withUserId$1<T, R> implements Function<Option<? extends String>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelContextInteractor.State a;

    public ChannelContextInteractorImpl$InitialDataRequestComposite$GetUserIdMutator$1$$special$$inlined$withUserId$1(ChannelContextInteractor.State state) {
        this.a = state;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Option<? extends String> option) {
        return apply((Option<String>) option);
    }

    public final SingleSource<? extends R> apply(@NotNull Option<String> option) {
        Intrinsics.checkNotNullParameter(option, "userIdOption");
        if (option instanceof None) {
            throw new UnauthorizedException();
        } else if (option instanceof Some) {
            return Singles.toSingle(ChannelContextInteractor.State.copy$default(this.a, (String) ((Some) option).getT(), null, null, false, 14, null));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
