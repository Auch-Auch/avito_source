package com.avito.android.messenger.conversation.mvi.menu;

import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.BlockUserLink;
import com.avito.android.deep_linking.links.ChannelCallLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeleteChannelLink;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/avito/android/messenger/conversation/mvi/menu/ChannelMenuPresenterImpl$getMenuAndAbilityToBlockWithReasons$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelMenuPresenterImpl$NewInteractorStateMutator$getMenuAndAbilityToBlockWithReasons$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChannelMenuAction a;
    public final /* synthetic */ ChannelMenuPresenterImpl b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelMenuPresenterImpl$NewInteractorStateMutator$getMenuAndAbilityToBlockWithReasons$$inlined$let$lambda$1(ChannelMenuAction channelMenuAction, ChannelMenuPresenterImpl channelMenuPresenterImpl, int i, List list, List list2) {
        super(0);
        this.a = channelMenuAction;
        this.b = channelMenuPresenterImpl;
        this.c = list;
        this.d = list2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ChannelMenuPresenterImpl channelMenuPresenterImpl = this.b;
        DeepLink deepLink = this.a.getDeepLink();
        if (deepLink instanceof ChannelCallLink) {
            ChannelMenuPresenterImpl.access$getInteractor$p(channelMenuPresenterImpl).callUser();
        } else if (deepLink instanceof BlockUserLink) {
            BlockUserLink blockUserLink = (BlockUserLink) deepLink;
            ChannelMenuPresenterImpl.access$getInteractor$p(channelMenuPresenterImpl).blockUser(blockUserLink.getUserId(), blockUserLink.getChannelId(), blockUserLink.getItemId());
        } else if (deepLink instanceof DeleteChannelLink) {
            ChannelMenuPresenterImpl.access$getInteractor$p(channelMenuPresenterImpl).deleteChannel(((DeleteChannelLink) deepLink).getChannelId());
        } else if (deepLink instanceof AbuseReportLink) {
            ChannelMenuPresenterImpl.access$getInteractor$p(channelMenuPresenterImpl).reportAbuse((AbuseReportLink) deepLink);
        } else {
            ChannelMenuPresenterImpl.access$getDeeplinkProcessor$p(channelMenuPresenterImpl).process(deepLink);
        }
    }
}
