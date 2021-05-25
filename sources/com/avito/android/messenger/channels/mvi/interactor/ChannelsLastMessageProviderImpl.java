package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import dagger.Lazy;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u000b\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProviderImpl;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/UserId;", ChannelContext.Item.USER_ID, "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelId;", "channelIds", "", "requestLastMessages", "(Ljava/lang/String;Ljava/util/Set;)V", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", AuthSource.OPEN_CHANNEL_LIST, "Ldagger/Lazy;", "messageRepo", "defaultState", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;Lcom/avito/android/util/SchedulersFactory;Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsLastMessageProviderImpl extends BaseMviEntityWithMutatorsRelay<ChannelsLastMessageProvider.State> implements ChannelsLastMessageProvider {
    public final Lazy<MessageRepo> m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ChannelsLastMessageProviderImpl(@NotNull ChannelsLastMessageProvider.State state, @NotNull SchedulersFactory schedulersFactory, @NotNull Lazy<MessageRepo> lazy) {
        super("ChannelsLastMessageProvider", state, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(state, "defaultState");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(lazy, "messageRepo");
        this.m = lazy;
    }

    @Override // com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider
    public void requestLastMessages(@NotNull String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(set, "channelIds");
        Relay mutatorsRelay = getMutatorsRelay();
        MessageRepo messageRepo = this.m.get();
        Intrinsics.checkNotNullExpressionValue(messageRepo, "messageRepo.get()");
        RequestMutator requestMutator = new RequestMutator(str, set, messageRepo);
        mutatorsRelay.accept(new MutatorSingle(requestMutator.getName(), new ChannelsLastMessageProviderImpl$requestLastMessages$$inlined$plusAssign$1(requestMutator)));
    }
}
