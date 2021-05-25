package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/DraftRepoWriter;", "", "", ChannelContext.Item.USER_ID, "channelId", "interlocutorId", "text", "Lio/reactivex/Completable;", "putDraft", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteDraft", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "deleteAllDraftsWithInterlocutor", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DraftRepoWriter {
    @NotNull
    Completable deleteAllDraftsWithInterlocutor(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable deleteDraft(@NotNull String str, @NotNull String str2);

    @NotNull
    Completable putDraft(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);
}
