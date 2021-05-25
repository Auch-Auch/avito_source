package com.avito.android.messenger.conversation.mvi.context;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Singles;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "R", "Larrow/core/Option;", "it", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/util/Singles$flatMapFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$RefreshMutator$syncChatAndUpdateState$$inlined$flatMapFold$1<T, R> implements Function<Option<? extends T>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelContextInteractorImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ChannelContextInteractor.State c;
    public final /* synthetic */ String d;

    public ChannelContextInteractorImpl$RefreshMutator$syncChatAndUpdateState$$inlined$flatMapFold$1(ChannelContextInteractorImpl channelContextInteractorImpl, String str, ChannelContextInteractor.State state, String str2) {
        this.a = channelContextInteractorImpl;
        this.b = str;
        this.c = state;
        this.d = str2;
    }

    public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option) {
        Intrinsics.checkNotNullParameter(option, "it");
        if (option instanceof None) {
            StringBuilder L = a.L("Channel is not in DB after channelSyncAgent.syncChat(): userId = ");
            L.append(this.b);
            L.append(", channelId = ");
            L.append(this.a.w);
            Single error = Single.error(new RuntimeException(L.toString()));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error<ChannelCont…channelId = $channelId\"))");
            return error;
        } else if (option instanceof Some) {
            return Singles.toSingle(ChannelContextInteractor.State.copy$default(this.c, this.d, new Loading.Success((Channel) ((Some) option).getT()), null, false, 12, null));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Option) ((Option) obj));
    }
}
