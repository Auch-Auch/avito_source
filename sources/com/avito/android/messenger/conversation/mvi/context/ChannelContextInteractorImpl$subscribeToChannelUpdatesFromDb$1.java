package com.avito.android.messenger.conversation.mvi.context;

import arrow.core.Option;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 \u0005* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "currentUserId", "Lio/reactivex/ObservableSource;", "Larrow/core/Option;", "Lcom/avito/android/remote/model/messenger/Channel;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/String;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToChannelUpdatesFromDb$1<T, R> implements Function<String, ObservableSource<? extends Option<? extends Channel>>> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$subscribeToChannelUpdatesFromDb$1(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final ObservableSource<? extends Option<Channel>> apply(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currentUserId");
        return this.a.E.getChannel(str, this.a.w);
    }
}
