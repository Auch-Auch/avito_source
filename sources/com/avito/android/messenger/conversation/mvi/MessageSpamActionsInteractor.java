package com.avito.android.messenger.conversation.mvi;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "", "messageUserId", "", "markChatAsSpam", "(Ljava/lang/String;)V", "markChatAsNonSpam", "Lio/reactivex/Observable;", "", "getErrorStream", "()Lio/reactivex/Observable;", "errorStream", "ChannelData", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageSpamActionsInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", ChannelContext.Item.USER_ID, "channelId", "itemId", "suspectMessageId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannelId", "d", "getSuspectMessageId", AuthSource.SEND_ABUSE, "getUserId", "c", "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelData {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @NotNull
        public final String d;

        public ChannelData(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4) {
            a.Z0(str, ChannelContext.Item.USER_ID, str2, "channelId", str4, "suspectMessageId");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public static /* synthetic */ ChannelData copy$default(ChannelData channelData, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelData.a;
            }
            if ((i & 2) != 0) {
                str2 = channelData.b;
            }
            if ((i & 4) != 0) {
                str3 = channelData.c;
            }
            if ((i & 8) != 0) {
                str4 = channelData.d;
            }
            return channelData.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final String component4() {
            return this.d;
        }

        @NotNull
        public final ChannelData copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(str4, "suspectMessageId");
            return new ChannelData(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChannelData)) {
                return false;
            }
            ChannelData channelData = (ChannelData) obj;
            return Intrinsics.areEqual(this.a, channelData.a) && Intrinsics.areEqual(this.b, channelData.b) && Intrinsics.areEqual(this.c, channelData.c) && Intrinsics.areEqual(this.d, channelData.d);
        }

        @NotNull
        public final String getChannelId() {
            return this.b;
        }

        @Nullable
        public final String getItemId() {
            return this.c;
        }

        @NotNull
        public final String getSuspectMessageId() {
            return this.d;
        }

        @NotNull
        public final String getUserId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelData(userId=");
            L.append(this.a);
            L.append(", channelId=");
            L.append(this.b);
            L.append(", itemId=");
            L.append(this.c);
            L.append(", suspectMessageId=");
            return a.t(L, this.d, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "getData", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "data", "<init>", "()V", "Empty", "InProgress", "Static", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$InProgress;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$Static;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "getData", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "data", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor.State
            @Nullable
            public ChannelData getData() {
                return null;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\f\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$InProgress;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", "data", "isSpam", "spamUserId", "copy", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;ZLjava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$InProgress;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getSpamUserId", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "getData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;ZLjava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends State {
            @NotNull
            public final ChannelData a;
            public final boolean b;
            @Nullable
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InProgress(@NotNull ChannelData channelData, boolean z, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(channelData, "data");
                this.a = channelData;
                this.b = z;
                this.c = str;
            }

            public static /* synthetic */ InProgress copy$default(InProgress inProgress, ChannelData channelData, boolean z, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelData = inProgress.getData();
                }
                if ((i & 2) != 0) {
                    z = inProgress.b;
                }
                if ((i & 4) != 0) {
                    str = inProgress.c;
                }
                return inProgress.copy(channelData, z, str);
            }

            @NotNull
            public final ChannelData component1() {
                return getData();
            }

            public final boolean component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final InProgress copy(@NotNull ChannelData channelData, boolean z, @Nullable String str) {
                Intrinsics.checkNotNullParameter(channelData, "data");
                return new InProgress(channelData, z, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InProgress)) {
                    return false;
                }
                InProgress inProgress = (InProgress) obj;
                return Intrinsics.areEqual(getData(), inProgress.getData()) && this.b == inProgress.b && Intrinsics.areEqual(this.c, inProgress.c);
            }

            @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor.State
            @NotNull
            public ChannelData getData() {
                return this.a;
            }

            @Nullable
            public final String getSpamUserId() {
                return this.c;
            }

            public int hashCode() {
                ChannelData data = getData();
                int i = 0;
                int hashCode = (data != null ? data.hashCode() : 0) * 31;
                boolean z = this.b;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                String str = this.c;
                if (str != null) {
                    i = str.hashCode();
                }
                return i5 + i;
            }

            public final boolean isSpam() {
                return this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("InProgress(data=");
                L.append(getData());
                L.append(", isSpam=");
                L.append(this.b);
                L.append(", spamUserId=");
                return a.t(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$Static;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "data", "copy", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;)Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$State$Static;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;", "getData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/MessageSpamActionsInteractor$ChannelData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Static extends State {
            @NotNull
            public final ChannelData a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Static(@NotNull ChannelData channelData) {
                super(null);
                Intrinsics.checkNotNullParameter(channelData, "data");
                this.a = channelData;
            }

            public static /* synthetic */ Static copy$default(Static r0, ChannelData channelData, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelData = r0.getData();
                }
                return r0.copy(channelData);
            }

            @NotNull
            public final ChannelData component1() {
                return getData();
            }

            @NotNull
            public final Static copy(@NotNull ChannelData channelData) {
                Intrinsics.checkNotNullParameter(channelData, "data");
                return new Static(channelData);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Static) && Intrinsics.areEqual(getData(), ((Static) obj).getData());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.mvi.MessageSpamActionsInteractor.State
            @NotNull
            public ChannelData getData() {
                return this.a;
            }

            public int hashCode() {
                ChannelData data = getData();
                if (data != null) {
                    return data.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Static(data=");
                L.append(getData());
                L.append(")");
                return L.toString();
            }
        }

        public State() {
        }

        @Nullable
        public abstract ChannelData getData();

        public State(j jVar) {
        }
    }

    @NotNull
    Observable<Throwable> getErrorStream();

    void markChatAsNonSpam(@NotNull String str);

    void markChatAsSpam(@NotNull String str);
}
