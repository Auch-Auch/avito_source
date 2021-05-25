package com.avito.android.messenger.channels.mvi.sync;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Larrow/core/Option;", "it", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/CompletableSource;", "com/avito/android/util/Singles$flatMapCompletableFold$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncMessages$$inlined$flatMapCompletableFold$1<T, R> implements Function<Option<? extends T>, CompletableSource> {
    public final /* synthetic */ ChannelSyncOnPushAgentImpl.PerformSyncMutator a;
    public final /* synthetic */ String b;

    public ChannelSyncOnPushAgentImpl$PerformSyncMutator$syncMessages$$inlined$flatMapCompletableFold$1(ChannelSyncOnPushAgentImpl.PerformSyncMutator performSyncMutator, String str) {
        this.a = performSyncMutator;
        this.b = str;
    }

    public final CompletableSource apply(@NotNull Option<? extends T> option) {
        Intrinsics.checkNotNullParameter(option, "it");
        if (option instanceof None) {
            Completable subscribeOn = MessageSyncAgent.DefaultImpls.syncLatestMessages$default((MessageSyncAgent) this.a.d.s.get(), this.b, this.a.c, null, null, 12, null).observeOn(this.a.d.getSchedulerForMutators()).subscribeOn(this.a.d.getSchedulerForMutators());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "messageSyncAgent.get().s…eOn(schedulerForMutators)");
            return subscribeOn;
        } else if (option instanceof Some) {
            LocalMessage localMessage = (LocalMessage) ((Some) option).getT();
            Completable complete = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
            return complete;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(Object obj) {
        return apply((Option) ((Option) obj));
    }
}
