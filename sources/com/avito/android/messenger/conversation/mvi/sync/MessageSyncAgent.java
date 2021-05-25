package com.avito.android.messenger.conversation.mvi.sync;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "", "", "subscribeToBackendNotifications", "()V", "", ChannelContext.Item.USER_ID, "channelId", "messageId", "searchQuery", "Lio/reactivex/Completable;", "syncLatestMessages", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Lio/reactivex/Single;", "", "syncPreviousPageOfMessages", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageSyncAgent {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Completable syncLatestMessages$default(MessageSyncAgent messageSyncAgent, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return messageSyncAgent.syncLatestMessages(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncLatestMessages");
        }
    }

    void subscribeToBackendNotifications();

    @NotNull
    Completable syncLatestMessages(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4);

    @NotNull
    Single<Boolean> syncPreviousPageOfMessages(@NotNull String str, @NotNull String str2);
}
