package com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel;

import com.avito.android.deep_linking.links.DeleteChannelLink;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeleteChannelLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/DeleteChannelLink;)Z", "Ldagger/Lazy;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuInteractor;", "d", "Ldagger/Lazy;", "channelMenuInteractor", "<init>", "(Ldagger/Lazy;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeleteChannelDeeplinkProcessorImpl extends DeleteChannelDeeplinkProcessor {
    public final Lazy<ChannelMenuInteractor> d;

    @Inject
    public DeleteChannelDeeplinkProcessorImpl(@NotNull Lazy<ChannelMenuInteractor> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "channelMenuInteractor");
        this.d = lazy;
    }

    public boolean doProcess(@NotNull DeleteChannelLink deleteChannelLink) {
        Intrinsics.checkNotNullParameter(deleteChannelLink, "deeplink");
        this.d.get().deleteChannel(deleteChannelLink.getChannelId());
        return true;
    }
}
