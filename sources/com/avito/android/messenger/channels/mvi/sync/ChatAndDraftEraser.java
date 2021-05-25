package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J/\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Completable;", "deleteChatAndDraftFromEverywhere", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteChatAndDraftFromDb", "interlocutorId", "itemId", "deleteChatAndAllDraftsWithInterlocutorFromDb", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChatAndDraftEraser {
    @NotNull
    Completable deleteChatAndAllDraftsWithInterlocutorFromDb(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    @NotNull
    Completable deleteChatAndDraftFromDb(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable deleteChatAndDraftFromEverywhere(@NotNull String str, @NotNull String str2);
}
