package com.avito.android.messenger.conversation.mvi.context;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.util.Singles;
import com.avito.android.util.UnauthorizedException;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"R", "Larrow/core/Option;", "", "userIdOption", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "com/avito/android/messenger/conversation/mvi/context/ChannelContextInteractorImpl$withUserId$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1<T, R> implements Function<Option<? extends String>, SingleSource<? extends R>> {
    public final /* synthetic */ ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator a;
    public final /* synthetic */ ChannelContextInteractor.State b;

    public ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1(ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator getChannelMutator, ChannelContextInteractor.State state) {
        this.a = getChannelMutator;
        this.b = state;
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
            String str = (String) ((Some) option).getT();
            ChannelContextInteractorImpl channelContextInteractorImpl = ChannelContextInteractorImpl.this;
            Single<Option<Channel>> firstOrError = channelContextInteractorImpl.E.getChannel(str, channelContextInteractorImpl.w).observeOn(channelContextInteractorImpl.getSchedulerForReducibles()).firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "channelRepo.getChannel(\n…          .firstOrError()");
            Single<R> flatMap = firstOrError.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(str, str, this) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1$lambda$1
                public final /* synthetic */ String a;
                public final /* synthetic */ String b;
                public final /* synthetic */ ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1 c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option2) {
                    Intrinsics.checkNotNullParameter(option2, "it");
                    if (option2 instanceof None) {
                        ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1 channelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1 = this.c;
                        final ChannelContextInteractorImpl channelContextInteractorImpl2 = ChannelContextInteractorImpl.this;
                        final String str2 = this.a;
                        final ChannelContextInteractor.State state = channelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1.b;
                        Completable observeOn = channelContextInteractorImpl2.F.syncChat(str2, channelContextInteractorImpl2.w).observeOn(channelContextInteractorImpl2.getSchedulerForReducibles());
                        Intrinsics.checkNotNullExpressionValue(observeOn, "channelSyncAgent.syncCha…n(schedulerForReducibles)");
                        Single<R> flatMap2 = observeOn.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>() { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1$lambda$1.1
                            public final SingleSource<? extends T> apply(@NotNull Unit unit) {
                                Intrinsics.checkNotNullParameter(unit, "it");
                                ChannelContextInteractorImpl channelContextInteractorImpl3 = channelContextInteractorImpl2;
                                Single<Option<Channel>> firstOrError2 = channelContextInteractorImpl3.E.getChannel(str2, channelContextInteractorImpl3.w).observeOn(channelContextInteractorImpl3.getSchedulerForReducibles()).firstOrError();
                                Intrinsics.checkNotNullExpressionValue(firstOrError2, "channelRepo.getChannel(\n…          .firstOrError()");
                                return firstOrError2;
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(flatMap2, "toSingleDefault(Unit).flatMap { singleFactory() }");
                        Single<R> flatMap3 = flatMap2.flatMap(new Function<Option<? extends T>, SingleSource<? extends R>>(str2) { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1$lambda$1.2
                            public final /* synthetic */ String b;

                            {
                                this.b = r2;
                            }

                            public final SingleSource<? extends R> apply(@NotNull Option<? extends T> option3) {
                                Intrinsics.checkNotNullParameter(option3, "it");
                                if (option3 instanceof None) {
                                    StringBuilder L = a.L("Channel is not in DB after channelSyncAgent.syncChat(): userId = ");
                                    L.append(this.b);
                                    L.append(", channelId = ");
                                    L.append(channelContextInteractorImpl2.w);
                                    Single error = Single.error(new RuntimeException(L.toString()));
                                    Intrinsics.checkNotNullExpressionValue(error, "Single.error<ChannelCont…channelId = $channelId\"))");
                                    return error;
                                } else if (option3 instanceof Some) {
                                    return Singles.toSingle(ChannelContextInteractor.State.copy$default(state, str2, new Loading.Success((Channel) ((Some) option3).getT()), null, false, 12, null));
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }

                            @Override // io.reactivex.functions.Function
                            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                                return apply((Option) ((Option) obj));
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(flatMap3, "flatMap { it.fold(ifEmpty, some) }");
                        return flatMap3;
                    } else if (option2 instanceof Some) {
                        ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1 channelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$12 = this.c;
                        final ChannelContextInteractorImpl.InitialDataRequestComposite.GetChannelMutator getChannelMutator = channelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$12.a;
                        Single<T> doAfterSuccess = Singles.toSingle(ChannelContextInteractor.State.copy$default(channelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$12.b, this.b, new Loading.Success((Channel) ((Some) option2).getT()), null, false, 12, null)).doAfterSuccess(new Consumer<ChannelContextInteractor.State>() { // from class: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractorImpl$InitialDataRequestComposite$GetChannelMutator$invoke$$inlined$withUserId$1$lambda$1.3
                            public final void accept(ChannelContextInteractor.State state2) {
                                ChannelContextInteractorImpl.this.refresh();
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(doAfterSuccess, "oldState.copy(\n         …h()\n                    }");
                        return doAfterSuccess;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                @Override // io.reactivex.functions.Function
                public /* bridge */ /* synthetic */ Object apply(Object obj) {
                    return apply((Option) ((Option) obj));
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.fold(ifEmpty, some) }");
            return flatMap;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
