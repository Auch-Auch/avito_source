package com.avito.android.messenger.conversation.mvi.menu;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeleteChannelLink;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelMenuInteractorKt {
    public static final String access$getContextItemIdString$p(Channel channel) {
        ChannelContext context = channel.getContext();
        if (!(context instanceof ChannelContext.Item)) {
            context = null;
        }
        ChannelContext.Item item = (ChannelContext.Item) context;
        if (item != null) {
            return item.getId();
        }
        return null;
    }

    public static final DeepLink access$getDeleteLink$p(Channel channel) {
        T t;
        Iterator<T> it = channel.getContext().getMenu().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getDeepLink() instanceof DeleteChannelLink) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.getDeepLink();
        }
        return null;
    }

    public static final String access$getInterlocutorUserId$p(ChannelMenuInteractor.State state) {
        List<User> users;
        T t;
        Channel channel = state.getChannel();
        if (channel == null || (users = channel.getUsers()) == null) {
            return null;
        }
        Iterator<T> it = users.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (!Intrinsics.areEqual(t.getId(), state.getCurrentUserId())) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.getId();
        }
        return null;
    }
}
