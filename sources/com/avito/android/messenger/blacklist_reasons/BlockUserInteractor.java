package com.avito.android.messenger.blacklist_reasons;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "", ChannelContext.Item.USER_ID, "channelId", "itemId", "", "reasonId", "", "blockUser", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "", "isSpam", "messageId", "confirmChatAsSpam", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "retry", "()V", "reset", "Lio/reactivex/Observable;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "getResultStream", "()Lio/reactivex/Observable;", "resultStream", "Action", "Result", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlockUserInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "", "getChannelId", "()Ljava/lang/String;", "channelId", "getUserId", ChannelContext.Item.USER_ID, "getItemId", "itemId", "<init>", "()V", "BlockUser", "ConfirmChatAsSpam", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$BlockUser;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Action {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$BlockUser;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Long;", ChannelContext.Item.USER_ID, "channelId", "itemId", "reasonId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$BlockUser;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getItemId", "d", "Ljava/lang/Long;", "getReasonId", AuthSource.BOOKING_ORDER, "getChannelId", AuthSource.SEND_ABUSE, "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class BlockUser extends Action {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @Nullable
            public final String c;
            @Nullable
            public final Long d;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ BlockUser(String str, String str2, String str3, Long l, int i, j jVar) {
                this(str, str2, str3, (i & 8) != 0 ? null : l);
            }

            public static /* synthetic */ BlockUser copy$default(BlockUser blockUser, String str, String str2, String str3, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = blockUser.getUserId();
                }
                if ((i & 2) != 0) {
                    str2 = blockUser.getChannelId();
                }
                if ((i & 4) != 0) {
                    str3 = blockUser.getItemId();
                }
                if ((i & 8) != 0) {
                    l = blockUser.d;
                }
                return blockUser.copy(str, str2, str3, l);
            }

            @NotNull
            public final String component1() {
                return getUserId();
            }

            @NotNull
            public final String component2() {
                return getChannelId();
            }

            @Nullable
            public final String component3() {
                return getItemId();
            }

            @Nullable
            public final Long component4() {
                return this.d;
            }

            @NotNull
            public final BlockUser copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l) {
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                Intrinsics.checkNotNullParameter(str2, "channelId");
                return new BlockUser(str, str2, str3, l);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof BlockUser)) {
                    return false;
                }
                BlockUser blockUser = (BlockUser) obj;
                return Intrinsics.areEqual(getUserId(), blockUser.getUserId()) && Intrinsics.areEqual(getChannelId(), blockUser.getChannelId()) && Intrinsics.areEqual(getItemId(), blockUser.getItemId()) && Intrinsics.areEqual(this.d, blockUser.d);
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @NotNull
            public String getChannelId() {
                return this.b;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @Nullable
            public String getItemId() {
                return this.c;
            }

            @Nullable
            public final Long getReasonId() {
                return this.d;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @NotNull
            public String getUserId() {
                return this.a;
            }

            public int hashCode() {
                String userId = getUserId();
                int i = 0;
                int hashCode = (userId != null ? userId.hashCode() : 0) * 31;
                String channelId = getChannelId();
                int hashCode2 = (hashCode + (channelId != null ? channelId.hashCode() : 0)) * 31;
                String itemId = getItemId();
                int hashCode3 = (hashCode2 + (itemId != null ? itemId.hashCode() : 0)) * 31;
                Long l = this.d;
                if (l != null) {
                    i = l.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("BlockUser(userId=");
                L.append(getUserId());
                L.append(", channelId=");
                L.append(getChannelId());
                L.append(", itemId=");
                L.append(getItemId());
                L.append(", reasonId=");
                L.append(this.d);
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BlockUser(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l) {
                super(null);
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                Intrinsics.checkNotNullParameter(str2, "channelId");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = l;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u000f\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Z", ChannelContext.Item.USER_ID, "channelId", "itemId", "messageId", "isSpam", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action$ConfirmChatAsSpam;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", "c", "getItemId", "e", "Z", "d", "getMessageId", AuthSource.BOOKING_ORDER, "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ConfirmChatAsSpam extends Action {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @Nullable
            public final String c;
            @NotNull
            public final String d;
            public final boolean e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ConfirmChatAsSpam(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, boolean z) {
                super(null);
                a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str4, "messageId");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = z;
            }

            public static /* synthetic */ ConfirmChatAsSpam copy$default(ConfirmChatAsSpam confirmChatAsSpam, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirmChatAsSpam.getUserId();
                }
                if ((i & 2) != 0) {
                    str2 = confirmChatAsSpam.getChannelId();
                }
                if ((i & 4) != 0) {
                    str3 = confirmChatAsSpam.getItemId();
                }
                if ((i & 8) != 0) {
                    str4 = confirmChatAsSpam.d;
                }
                if ((i & 16) != 0) {
                    z = confirmChatAsSpam.e;
                }
                return confirmChatAsSpam.copy(str, str2, str3, str4, z);
            }

            @NotNull
            public final String component1() {
                return getUserId();
            }

            @NotNull
            public final String component2() {
                return getChannelId();
            }

            @Nullable
            public final String component3() {
                return getItemId();
            }

            @NotNull
            public final String component4() {
                return this.d;
            }

            public final boolean component5() {
                return this.e;
            }

            @NotNull
            public final ConfirmChatAsSpam copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, boolean z) {
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                Intrinsics.checkNotNullParameter(str2, "channelId");
                Intrinsics.checkNotNullParameter(str4, "messageId");
                return new ConfirmChatAsSpam(str, str2, str3, str4, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConfirmChatAsSpam)) {
                    return false;
                }
                ConfirmChatAsSpam confirmChatAsSpam = (ConfirmChatAsSpam) obj;
                return Intrinsics.areEqual(getUserId(), confirmChatAsSpam.getUserId()) && Intrinsics.areEqual(getChannelId(), confirmChatAsSpam.getChannelId()) && Intrinsics.areEqual(getItemId(), confirmChatAsSpam.getItemId()) && Intrinsics.areEqual(this.d, confirmChatAsSpam.d) && this.e == confirmChatAsSpam.e;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @NotNull
            public String getChannelId() {
                return this.b;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @Nullable
            public String getItemId() {
                return this.c;
            }

            @NotNull
            public final String getMessageId() {
                return this.d;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Action
            @NotNull
            public String getUserId() {
                return this.a;
            }

            public int hashCode() {
                String userId = getUserId();
                int i = 0;
                int hashCode = (userId != null ? userId.hashCode() : 0) * 31;
                String channelId = getChannelId();
                int hashCode2 = (hashCode + (channelId != null ? channelId.hashCode() : 0)) * 31;
                String itemId = getItemId();
                int hashCode3 = (hashCode2 + (itemId != null ? itemId.hashCode() : 0)) * 31;
                String str = this.d;
                if (str != null) {
                    i = str.hashCode();
                }
                int i2 = (hashCode3 + i) * 31;
                boolean z = this.e;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            public final boolean isSpam() {
                return this.e;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ConfirmChatAsSpam(userId=");
                L.append(getUserId());
                L.append(", channelId=");
                L.append(getChannelId());
                L.append(", itemId=");
                L.append(getItemId());
                L.append(", messageId=");
                L.append(this.d);
                L.append(", isSpam=");
                return a.B(L, this.e, ")");
            }
        }

        public Action() {
        }

        @NotNull
        public abstract String getChannelId();

        @Nullable
        public abstract String getItemId();

        @NotNull
        public abstract String getUserId();

        public Action(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void blockUser$default(BlockUserInteractor blockUserInteractor, String str, String str2, String str3, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    l = null;
                }
                blockUserInteractor.blockUser(str, str2, str3, l);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blockUser");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "getAction", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "action", "<init>", "()V", "Error", "Success", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Success;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Result {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Error;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "component1", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "component2", "()Ljava/lang/Throwable;", "action", "error", "copy", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;Ljava/lang/Throwable;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "getAction", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Result {
            @NotNull
            public final Action a;
            @NotNull
            public final Throwable b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Action action, @NotNull Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(th, "error");
                this.a = action;
                this.b = th;
            }

            public static /* synthetic */ Error copy$default(Error error, Action action, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = error.getAction();
                }
                if ((i & 2) != 0) {
                    th = error.b;
                }
                return error.copy(action, th);
            }

            @NotNull
            public final Action component1() {
                return getAction();
            }

            @NotNull
            public final Throwable component2() {
                return this.b;
            }

            @NotNull
            public final Error copy(@NotNull Action action, @NotNull Throwable th) {
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(th, "error");
                return new Error(action, th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(getAction(), error.getAction()) && Intrinsics.areEqual(this.b, error.b);
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Result
            @NotNull
            public Action getAction() {
                return this.a;
            }

            @NotNull
            public final Throwable getError() {
                return this.b;
            }

            public int hashCode() {
                Action action = getAction();
                int i = 0;
                int hashCode = (action != null ? action.hashCode() : 0) * 31;
                Throwable th = this.b;
                if (th != null) {
                    i = th.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Error(action=");
                L.append(getAction());
                L.append(", error=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u000b\u0010\u0007¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Success;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "component1", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "component2", "()Z", "component3", "action", "isBlocked", "isLocal", "copy", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;ZZ)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Result$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "getAction", AuthSource.BOOKING_ORDER, "Z", "c", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;ZZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends Result {
            @NotNull
            public final Action a;
            public final boolean b;
            public final boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull Action action, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.a = action;
                this.b = z;
                this.c = z2;
            }

            public static /* synthetic */ Success copy$default(Success success, Action action, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = success.getAction();
                }
                if ((i & 2) != 0) {
                    z = success.b;
                }
                if ((i & 4) != 0) {
                    z2 = success.c;
                }
                return success.copy(action, z, z2);
            }

            @NotNull
            public final Action component1() {
                return getAction();
            }

            public final boolean component2() {
                return this.b;
            }

            public final boolean component3() {
                return this.c;
            }

            @NotNull
            public final Success copy(@NotNull Action action, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Success(action, z, z2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(getAction(), success.getAction()) && this.b == success.b && this.c == success.c;
            }

            @Override // com.avito.android.messenger.blacklist_reasons.BlockUserInteractor.Result
            @NotNull
            public Action getAction() {
                return this.a;
            }

            public int hashCode() {
                Action action = getAction();
                int hashCode = (action != null ? action.hashCode() : 0) * 31;
                boolean z = this.b;
                int i = 1;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                boolean z2 = this.c;
                if (!z2) {
                    i = z2 ? 1 : 0;
                }
                return i5 + i;
            }

            public final boolean isBlocked() {
                return this.b;
            }

            public final boolean isLocal() {
                return this.c;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Success(action=");
                L.append(getAction());
                L.append(", isBlocked=");
                L.append(this.b);
                L.append(", isLocal=");
                return a.B(L, this.c, ")");
            }
        }

        public Result() {
        }

        @NotNull
        public abstract Action getAction();

        public Result(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "", "<init>", "()V", "Blocked", "Empty", "Error", "InProgress", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Blocked;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$InProgress;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Blocked;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Blocked extends State {
            @NotNull
            public static final Blocked INSTANCE = new Blocked();

            public Blocked() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Error;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "component1", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "", "component2", "()Ljava/lang/Throwable;", "action", "error", "copy", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;Ljava/lang/Throwable;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "getAction", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final Action a;
            @Nullable
            public final Throwable b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Action action, @Nullable Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.a = action;
                this.b = th;
            }

            public static /* synthetic */ Error copy$default(Error error, Action action, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = error.a;
                }
                if ((i & 2) != 0) {
                    th = error.b;
                }
                return error.copy(action, th);
            }

            @NotNull
            public final Action component1() {
                return this.a;
            }

            @Nullable
            public final Throwable component2() {
                return this.b;
            }

            @NotNull
            public final Error copy(@NotNull Action action, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Error(action, th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.a, error.a) && Intrinsics.areEqual(this.b, error.b);
            }

            @NotNull
            public final Action getAction() {
                return this.a;
            }

            @Nullable
            public final Throwable getError() {
                return this.b;
            }

            public int hashCode() {
                Action action = this.a;
                int i = 0;
                int hashCode = (action != null ? action.hashCode() : 0) * 31;
                Throwable th = this.b;
                if (th != null) {
                    i = th.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Error(action=");
                L.append(this.a);
                L.append(", error=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$InProgress;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "component1", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "action", "copy", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$State$InProgress;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;", "getAction", "<init>", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor$Action;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends State {
            @NotNull
            public final Action a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InProgress(@NotNull Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.a = action;
            }

            public static /* synthetic */ InProgress copy$default(InProgress inProgress, Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = inProgress.a;
                }
                return inProgress.copy(action);
            }

            @NotNull
            public final Action component1() {
                return this.a;
            }

            @NotNull
            public final InProgress copy(@NotNull Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new InProgress(action);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof InProgress) && Intrinsics.areEqual(this.a, ((InProgress) obj).a);
                }
                return true;
            }

            @NotNull
            public final Action getAction() {
                return this.a;
            }

            public int hashCode() {
                Action action = this.a;
                if (action != null) {
                    return action.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("InProgress(action=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    void blockUser(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l);

    void confirmChatAsSpam(boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4);

    @NotNull
    Observable<Result> getResultStream();

    void reset();

    void retry();
}
