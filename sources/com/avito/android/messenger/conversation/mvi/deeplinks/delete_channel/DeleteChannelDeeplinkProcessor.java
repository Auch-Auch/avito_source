package com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel;

import com.avito.android.deep_linking.links.DeleteChannelLink;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/delete_channel/DeleteChannelDeeplinkProcessor;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeleteChannelLink;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class DeleteChannelDeeplinkProcessor extends AbstractDeeplinkProcessor<DeleteChannelLink> {
    public DeleteChannelDeeplinkProcessor() {
        super(DeleteChannelLink.class);
    }
}
