package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "", "<init>", "()V", "All", "Id", "Tags", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Id;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Tags;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$All;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelsKey {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$All;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class All extends ChannelsKey {
        @NotNull
        public static final All INSTANCE = new All();

        public All() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Id;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "", "component1", "()Ljava/lang/String;", "channelId", "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Id;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Id extends ChannelsKey {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Id(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.a = str;
        }

        public static /* synthetic */ Id copy$default(Id id, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = id.a;
            }
            return id.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Id copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new Id(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Id) && Intrinsics.areEqual(this.a, ((Id) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getChannelId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Id(channelId="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J0\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Tags;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey;", "Ljava/util/SortedSet;", "", "component1", "()Ljava/util/SortedSet;", "component2", "includeTags", "excludeTags", "copy", "(Ljava/util/SortedSet;Ljava/util/SortedSet;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelsKey$Tags;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/SortedSet;", "getIncludeTags", AuthSource.BOOKING_ORDER, "getExcludeTags", "<init>", "(Ljava/util/SortedSet;Ljava/util/SortedSet;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Tags extends ChannelsKey {
        @NotNull
        public final SortedSet<String> a;
        @NotNull
        public final SortedSet<String> b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Tags(@NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2) {
            super(null);
            Intrinsics.checkNotNullParameter(sortedSet, "includeTags");
            Intrinsics.checkNotNullParameter(sortedSet2, "excludeTags");
            this.a = sortedSet;
            this.b = sortedSet2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.sync.ChannelsKey$Tags */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Tags copy$default(Tags tags, SortedSet sortedSet, SortedSet sortedSet2, int i, Object obj) {
            if ((i & 1) != 0) {
                sortedSet = tags.a;
            }
            if ((i & 2) != 0) {
                sortedSet2 = tags.b;
            }
            return tags.copy(sortedSet, sortedSet2);
        }

        @NotNull
        public final SortedSet<String> component1() {
            return this.a;
        }

        @NotNull
        public final SortedSet<String> component2() {
            return this.b;
        }

        @NotNull
        public final Tags copy(@NotNull SortedSet<String> sortedSet, @NotNull SortedSet<String> sortedSet2) {
            Intrinsics.checkNotNullParameter(sortedSet, "includeTags");
            Intrinsics.checkNotNullParameter(sortedSet2, "excludeTags");
            return new Tags(sortedSet, sortedSet2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tags)) {
                return false;
            }
            Tags tags = (Tags) obj;
            return Intrinsics.areEqual(this.a, tags.a) && Intrinsics.areEqual(this.b, tags.b);
        }

        @NotNull
        public final SortedSet<String> getExcludeTags() {
            return this.b;
        }

        @NotNull
        public final SortedSet<String> getIncludeTags() {
            return this.a;
        }

        public int hashCode() {
            SortedSet<String> sortedSet = this.a;
            int i = 0;
            int hashCode = (sortedSet != null ? sortedSet.hashCode() : 0) * 31;
            SortedSet<String> sortedSet2 = this.b;
            if (sortedSet2 != null) {
                i = sortedSet2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Tags(includeTags=");
            L.append(this.a);
            L.append(", excludeTags=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public ChannelsKey() {
    }

    public ChannelsKey(j jVar) {
    }
}
