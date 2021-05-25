package com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/elements/delete_local/MessageEraser;", "", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lio/reactivex/Single;", "", "deleteLocalMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageEraser {
    @NotNull
    Single<Boolean> deleteLocalMessage(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
