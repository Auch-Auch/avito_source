package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import arrow.core.Option;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001b\u001cJ1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "Lcom/avito/android/messenger/channels/mvi/sync/ChatAndDraftEraser;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsBackendNotificationsHandler;", "Lcom/avito/android/messenger/channels/mvi/sync/LocalChannelEditor;", "", ChannelContext.Item.USER_ID, "itemId", "source", "Lio/reactivex/Single;", "createChat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "createAvitoChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "channelId", "Lio/reactivex/Completable;", "syncChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;", "Ljava/util/SortedSet;", "tags", "excludeTags", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "syncLatestChats", "(Ljava/lang/String;Ljava/util/SortedSet;Ljava/util/SortedSet;)Lio/reactivex/Single;", "", "currentOffset", "syncNextPage", "(Ljava/lang/String;ILjava/util/SortedSet;Ljava/util/SortedSet;)Lio/reactivex/Single;", "Companion", "SyncChatsResult", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelSyncAgent extends ChatAndDraftEraser, ChannelsBackendNotificationsHandler, LocalChannelEditor {
    @NotNull
    public static final Companion Companion = Companion.a;
    public static final int INITIAL_REQUEST_SIZE = 30;
    public static final int PAGE_SIZE = 10;
    @NotNull
    public static final String TAG = "ChannelSyncAgent";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$Companion;", "", "", "INITIAL_REQUEST_SIZE", "I", "", "TAG", "Ljava/lang/String;", "PAGE_SIZE", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final int INITIAL_REQUEST_SIZE = 30;
        public static final int PAGE_SIZE = 10;
        @NotNull
        public static final String TAG = "ChannelSyncAgent";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single createAvitoChat$default(ChannelSyncAgent channelSyncAgent, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return channelSyncAgent.createAvitoChat(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAvitoChat");
        }

        public static /* synthetic */ Single createChat$default(ChannelSyncAgent channelSyncAgent, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return channelSyncAgent.createChat(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createChat");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\f\u001a\u00020\u00002\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\n\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "", "Larrow/core/Option;", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "component1", "()Larrow/core/Option;", "", "component2", "()Z", "oldestSyncedChatTimestamp", "hasMorePages", "copy", "(Larrow/core/Option;Z)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Larrow/core/Option;", "getOldestSyncedChatTimestamp", AuthSource.BOOKING_ORDER, "Z", "getHasMorePages", "<init>", "(Larrow/core/Option;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class SyncChatsResult {
        @NotNull
        public final Option<Long> a;
        public final boolean b;

        public SyncChatsResult(@NotNull Option<Long> option, boolean z) {
            Intrinsics.checkNotNullParameter(option, "oldestSyncedChatTimestamp");
            this.a = option;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent$SyncChatsResult */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SyncChatsResult copy$default(SyncChatsResult syncChatsResult, Option option, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                option = syncChatsResult.a;
            }
            if ((i & 2) != 0) {
                z = syncChatsResult.b;
            }
            return syncChatsResult.copy(option, z);
        }

        @NotNull
        public final Option<Long> component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final SyncChatsResult copy(@NotNull Option<Long> option, boolean z) {
            Intrinsics.checkNotNullParameter(option, "oldestSyncedChatTimestamp");
            return new SyncChatsResult(option, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SyncChatsResult)) {
                return false;
            }
            SyncChatsResult syncChatsResult = (SyncChatsResult) obj;
            return Intrinsics.areEqual(this.a, syncChatsResult.a) && this.b == syncChatsResult.b;
        }

        public final boolean getHasMorePages() {
            return this.b;
        }

        @NotNull
        public final Option<Long> getOldestSyncedChatTimestamp() {
            return this.a;
        }

        public int hashCode() {
            Option<Long> option = this.a;
            int hashCode = (option != null ? option.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SyncChatsResult(oldestSyncedChatTimestamp=");
            L.append(this.a);
            L.append(", hasMorePages=");
            return a.B(L, this.b, ")");
        }
    }

    @NotNull
    Single<String> createAvitoChat(@NotNull String str, @Nullable String str2);

    @NotNull
    Single<String> createChat(@NotNull String str, @NotNull String str2, @Nullable String str3);

    @NotNull
    Completable syncChat(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<SyncChatsResult> syncLatestChats(@NotNull String str, @NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2);

    @NotNull
    Single<SyncChatsResult> syncNextPage(@NotNull String str, int i, @NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2);
}
