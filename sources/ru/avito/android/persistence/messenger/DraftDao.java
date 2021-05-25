package ru.avito.android.persistence.messenger;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Dao
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H'¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/avito/android/persistence/messenger/DraftDao;", "", "", ChannelContext.Item.USER_ID, "channelId", "Lio/reactivex/Observable;", "", "Lru/avito/android/persistence/messenger/DraftEntity;", "getDraft", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getAllDrafts", "(Ljava/lang/String;)Lio/reactivex/Observable;", "channelIds", "getDraftsForChannelIds", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", AnalyticFieldsName.draft, "", "insertDraft", "(Lru/avito/android/persistence/messenger/DraftEntity;)J", "insertDrafts", "(Ljava/util/List;)Ljava/util/List;", "", "deleteDraft", "(Ljava/lang/String;Ljava/lang/String;)I", "interlocutorId", "deleteAllDraftsWithInterlocutor", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface DraftDao {
    @Query("\n            DELETE FROM draft \n            WHERE \n                local_user_id = :userId \n                AND interlocutor_id = :interlocutorId\n            ")
    int deleteAllDraftsWithInterlocutor(@NotNull String str, @NotNull String str2);

    @Query("\n        DELETE FROM draft \n        WHERE \n            local_user_id = :userId \n            AND channel_id = :channelId\n        ")
    int deleteDraft(@NotNull String str, @NotNull String str2);

    @Query("SELECT * FROM draft WHERE local_user_id = :userId")
    @NotNull
    Observable<List<DraftEntity>> getAllDrafts(@NotNull String str);

    @Query("SELECT * FROM draft WHERE local_user_id = :userId AND channel_id = :channelId")
    @NotNull
    Observable<List<DraftEntity>> getDraft(@NotNull String str, @NotNull String str2);

    @Query("\n        SELECT * FROM draft\n        WHERE local_user_id = :userId\n            AND channel_id IN (:channelIds)\n        \n    ")
    @NotNull
    Observable<List<DraftEntity>> getDraftsForChannelIds(@NotNull String str, @NotNull List<String> list);

    @Insert(onConflict = 1)
    long insertDraft(@NotNull DraftEntity draftEntity);

    @Insert(onConflict = 1)
    @NotNull
    List<Long> insertDrafts(@NotNull List<DraftEntity> list);
}
