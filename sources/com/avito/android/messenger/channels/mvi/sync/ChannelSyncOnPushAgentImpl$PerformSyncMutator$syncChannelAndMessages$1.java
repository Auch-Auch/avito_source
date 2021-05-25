package com.avito.android.messenger.channels.mvi.sync;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Larrow/core/Option;", "Lcom/avito/android/remote/model/messenger/Channel;", "channelOption", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/CompletableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncChannelAndMessages$1<T, R> implements Function<Option<? extends Channel>, CompletableSource> {
    public final /* synthetic */ ChannelSyncOnPushAgentImpl.PerformSyncMutator a;
    public final /* synthetic */ String b;

    public ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncChannelAndMessages$1(ChannelSyncOnPushAgentImpl.PerformSyncMutator performSyncMutator, String str) {
        this.a = performSyncMutator;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(Option<? extends Channel> option) {
        return apply((Option<Channel>) option);
    }

    public final CompletableSource apply(@NotNull Option<Channel> option) {
        Completable completable;
        Intrinsics.checkNotNullParameter(option, "channelOption");
        ChannelSyncOnPushAgentImpl.PerformSyncMutator performSyncMutator = this.a;
        String str = this.b;
        Completable observeOn = ((MessengerClient) performSyncMutator.d.o.get()).connect(true).observeOn(performSyncMutator.d.getSchedulerForMutators());
        Intrinsics.checkNotNullExpressionValue(observeOn, "client.get().connect(for…eOn(schedulerForMutators)");
        if (option instanceof None) {
            completable = ((ChannelSyncAgent) performSyncMutator.d.q.get()).syncChat(str, performSyncMutator.c);
        } else if (option instanceof Some) {
            Channel channel = (Channel) ((Some) option).getT();
            completable = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Completable subscribeOn = completable.observeOn(performSyncMutator.d.getSchedulerForMutators()).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "channelOption.fold(\n    …eOn(schedulerForMutators)");
        Completable subscribeOn2 = observeOn.andThen(subscribeOn).subscribeOn(performSyncMutator.d.getSchedulerForMutators());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "connect()\n              …eOn(schedulerForMutators)");
        return subscribeOn2;
    }
}
