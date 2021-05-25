package com.avito.android.messenger.conversation.mvi.file_download;

import androidx.work.WorkInfo;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadManager;", "", "", ChannelContext.Item.USER_ID, "channelId", "localMessageId", "", "enqTimestamp", "Lio/reactivex/rxjava3/core/Completable;", "enqueueDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Completable;", "cancelDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "startFromTimestamp", "Lio/reactivex/rxjava3/core/Observable;", "", "Ljava/util/UUID;", "Landroidx/work/WorkInfo;", "observeNewDownloadFails", "(Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/rxjava3/core/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileDownloadManager {
    @NotNull
    Completable cancelDownload(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Completable enqueueDownload(@NotNull String str, @NotNull String str2, @NotNull String str3, long j);

    @NotNull
    Observable<Map<UUID, WorkInfo>> observeNewDownloadFails(@NotNull String str, @NotNull String str2, long j);
}
