package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenterImpl;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$OpenDealActionOrAdvert;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "curState", "", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextPresenterImpl$Event$OpenDealActionOrAdvert;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1 extends Lambda implements Function2<ChannelContextPresenterImpl.Event.OpenDealActionOrAdvert, ChannelContextView.State, Unit> {
    public final /* synthetic */ ChannelContextPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelContextPresenterImpl$openDealActionOrAdvertEventHandler$1(ChannelContextPresenterImpl channelContextPresenterImpl) {
        super(2);
        this.a = channelContextPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ChannelContextPresenterImpl.Event.OpenDealActionOrAdvert openDealActionOrAdvert, ChannelContextView.State state) {
        invoke(openDealActionOrAdvert, state);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ChannelContextPresenterImpl.Event.OpenDealActionOrAdvert openDealActionOrAdvert, @NotNull ChannelContextView.State state) {
        Intrinsics.checkNotNullParameter(openDealActionOrAdvert, "$this$actionHandler");
        Intrinsics.checkNotNullParameter(state, "curState");
        ChannelContextView.ItemBlock itemBlock = state.itemBlock;
        DeepLink deepLink = null;
        if (!(itemBlock instanceof ChannelContextView.ItemBlock.Loaded)) {
            itemBlock = null;
        }
        ChannelContextView.ItemBlock.Loaded loaded = (ChannelContextView.ItemBlock.Loaded) itemBlock;
        if (loaded != null) {
            deepLink = loaded.dealActionDeepLink;
        }
        if (deepLink == null || (deepLink instanceof NoMatchLink)) {
            this.a.openAdvert();
        } else {
            this.a.A.process(deepLink);
        }
    }
}
