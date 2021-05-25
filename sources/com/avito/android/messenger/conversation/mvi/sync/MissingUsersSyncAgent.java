package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "", "", ChannelContext.Item.USER_ID, "channelId", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "messages", "", "syncMissingUsers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MissingUsersSyncAgent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent$State;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final State INSTANCE = new State();
    }

    void syncMissingUsers(@NotNull String str, @NotNull String str2, @NotNull List<LocalMessage> list);
}
