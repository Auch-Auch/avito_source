package com.avito.android.messenger.channels.mvi.data;

import arrow.core.Option;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/DraftRepoReader;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Observable;", "Larrow/core/Option;", "Lru/avito/android/persistence/messenger/DraftEntity;", "getDraft", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "getAllDrafts", "(Ljava/lang/String;)Lio/reactivex/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DraftRepoReader {
    @NotNull
    Observable<List<DraftEntity>> getAllDrafts(@NotNull String str);

    @NotNull
    Observable<Option<DraftEntity>> getDraft(@NotNull String str, @NotNull String str2);
}
