package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u000e\u000f\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "data", "", "updateContent", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;)V", "onBottomSheetOpened", "()V", "Landroidx/lifecycle/LiveData;", "getHideKeyboardStream", "()Landroidx/lifecycle/LiveData;", "hideKeyboardStream", "ChannelData", "ContentData", "State", "UiData", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyPlatformActionsPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component5", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "currentUserId", "channelId", ChannelEntity.COLUMN_UPDATED, "flow", "actions", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelData {
        @JvmField
        @NotNull
        public final PlatformActions actions;
        @JvmField
        @NotNull
        public final String channelId;
        @JvmField
        @NotNull
        public final String currentUserId;
        @JvmField
        @Nullable
        public final String flow;
        @JvmField
        public final long updated;

        public ChannelData() {
            this(null, null, 0, null, null, 31, null);
        }

        public ChannelData(@NotNull String str, @NotNull String str2, long j, @Nullable String str3, @NotNull PlatformActions platformActions) {
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(platformActions, "actions");
            this.currentUserId = str;
            this.channelId = str2;
            this.updated = j;
            this.flow = str3;
            this.actions = platformActions;
        }

        public static /* synthetic */ ChannelData copy$default(ChannelData channelData, String str, String str2, long j, String str3, PlatformActions platformActions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelData.currentUserId;
            }
            if ((i & 2) != 0) {
                str2 = channelData.channelId;
            }
            if ((i & 4) != 0) {
                j = channelData.updated;
            }
            if ((i & 8) != 0) {
                str3 = channelData.flow;
            }
            if ((i & 16) != 0) {
                platformActions = channelData.actions;
            }
            return channelData.copy(str, str2, j, str3, platformActions);
        }

        @NotNull
        public final String component1() {
            return this.currentUserId;
        }

        @NotNull
        public final String component2() {
            return this.channelId;
        }

        public final long component3() {
            return this.updated;
        }

        @Nullable
        public final String component4() {
            return this.flow;
        }

        @NotNull
        public final PlatformActions component5() {
            return this.actions;
        }

        @NotNull
        public final ChannelData copy(@NotNull String str, @NotNull String str2, long j, @Nullable String str3, @NotNull PlatformActions platformActions) {
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(str2, "channelId");
            Intrinsics.checkNotNullParameter(platformActions, "actions");
            return new ChannelData(str, str2, j, str3, platformActions);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChannelData)) {
                return false;
            }
            ChannelData channelData = (ChannelData) obj;
            return Intrinsics.areEqual(this.currentUserId, channelData.currentUserId) && Intrinsics.areEqual(this.channelId, channelData.channelId) && this.updated == channelData.updated && Intrinsics.areEqual(this.flow, channelData.flow) && Intrinsics.areEqual(this.actions, channelData.actions);
        }

        public int hashCode() {
            String str = this.currentUserId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.channelId;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.updated)) * 31;
            String str3 = this.flow;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            PlatformActions platformActions = this.actions;
            if (platformActions != null) {
                i = platformActions.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelData(currentUserId=");
            L.append(this.currentUserId);
            L.append(", channelId=");
            L.append(this.channelId);
            L.append(", updated=");
            L.append(this.updated);
            L.append(", flow=");
            L.append(this.flow);
            L.append(", actions=");
            L.append(this.actions);
            L.append(")");
            return L.toString();
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ChannelData(java.lang.String r5, java.lang.String r6, long r7, java.lang.String r9, com.avito.android.remote.model.messenger.context_actions.PlatformActions r10, int r11, t6.r.a.j r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                java.lang.String r0 = ""
                if (r12 == 0) goto L_0x0008
                r12 = r0
                goto L_0x0009
            L_0x0008:
                r12 = r5
            L_0x0009:
                r5 = r11 & 2
                if (r5 == 0) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r0 = r6
            L_0x000f:
                r5 = r11 & 4
                if (r5 == 0) goto L_0x0015
                r7 = 0
            L_0x0015:
                r1 = r7
                r5 = r11 & 8
                r6 = 0
                if (r5 == 0) goto L_0x001d
                r3 = r6
                goto L_0x001e
            L_0x001d:
                r3 = r9
            L_0x001e:
                r5 = r11 & 16
                if (r5 == 0) goto L_0x0027
                com.avito.android.remote.model.messenger.context_actions.PlatformActions$None r10 = new com.avito.android.remote.model.messenger.context_actions.PlatformActions$None
                r10.<init>(r6)
            L_0x0027:
                r11 = r10
                r5 = r4
                r6 = r12
                r7 = r0
                r8 = r1
                r10 = r3
                r5.<init>(r6, r7, r8, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.ChannelData.<init>(java.lang.String, java.lang.String, long, java.lang.String, com.avito.android.remote.model.messenger.context_actions.PlatformActions, int, t6.r.a.j):void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "", "Unsupported", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface ContentData {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData$Unsupported;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public interface Unsupported extends ContentData {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "getUiData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "uiData", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "getChannelData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "channelData", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "getContentData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "contentData", "<init>", "()V", "Actions", "Empty", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State$Actions;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State$Actions;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "component3", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "channelData", "uiData", "contentData", "copy", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State$Actions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "getContentData", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "getUiData", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "getChannelData", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Actions extends State {
            @NotNull
            public final ChannelData a;
            @NotNull
            public final UiData b;
            @Nullable
            public final ContentData c;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Actions(ChannelData channelData, UiData uiData, ContentData contentData, int i, j jVar) {
                this(channelData, uiData, (i & 4) != 0 ? null : contentData);
            }

            public static /* synthetic */ Actions copy$default(Actions actions, ChannelData channelData, UiData uiData, ContentData contentData, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelData = actions.getChannelData();
                }
                if ((i & 2) != 0) {
                    uiData = actions.getUiData();
                }
                if ((i & 4) != 0) {
                    contentData = actions.getContentData();
                }
                return actions.copy(channelData, uiData, contentData);
            }

            @NotNull
            public final ChannelData component1() {
                return getChannelData();
            }

            @NotNull
            public final UiData component2() {
                return getUiData();
            }

            @Nullable
            public final ContentData component3() {
                return getContentData();
            }

            @NotNull
            public final Actions copy(@NotNull ChannelData channelData, @NotNull UiData uiData, @Nullable ContentData contentData) {
                Intrinsics.checkNotNullParameter(channelData, "channelData");
                Intrinsics.checkNotNullParameter(uiData, "uiData");
                return new Actions(channelData, uiData, contentData);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Actions)) {
                    return false;
                }
                Actions actions = (Actions) obj;
                return Intrinsics.areEqual(getChannelData(), actions.getChannelData()) && Intrinsics.areEqual(getUiData(), actions.getUiData()) && Intrinsics.areEqual(getContentData(), actions.getContentData());
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @NotNull
            public ChannelData getChannelData() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @Nullable
            public ContentData getContentData() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @NotNull
            public UiData getUiData() {
                return this.b;
            }

            public int hashCode() {
                ChannelData channelData = getChannelData();
                int i = 0;
                int hashCode = (channelData != null ? channelData.hashCode() : 0) * 31;
                UiData uiData = getUiData();
                int hashCode2 = (hashCode + (uiData != null ? uiData.hashCode() : 0)) * 31;
                ContentData contentData = getContentData();
                if (contentData != null) {
                    i = contentData.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Actions(channelData=");
                L.append(getChannelData());
                L.append(", uiData=");
                L.append(getUiData());
                L.append(", contentData=");
                L.append(getContentData());
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Actions(@NotNull ChannelData channelData, @NotNull UiData uiData, @Nullable ContentData contentData) {
                super(null);
                Intrinsics.checkNotNullParameter(channelData, "channelData");
                Intrinsics.checkNotNullParameter(uiData, "uiData");
                this.a = channelData;
                this.b = uiData;
                this.c = contentData;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "getChannelData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ChannelData;", "channelData", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "getUiData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "uiData", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "getContentData", "()Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "contentData", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @Nullable
            public ChannelData getChannelData() {
                return null;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @Nullable
            public ContentData getContentData() {
                return null;
            }

            @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.State
            @Nullable
            public UiData getUiData() {
                return null;
            }

            @NotNull
            public String toString() {
                return "Empty";
            }
        }

        public State() {
        }

        @Nullable
        public abstract ChannelData getChannelData();

        @Nullable
        public abstract ContentData getContentData();

        @Nullable
        public abstract UiData getUiData();

        public State(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "", "<init>", "()V", "Sheet", "Sticky", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData$Sticky;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData$Sheet;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class UiData {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData$Sheet;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Sheet extends UiData {
            @NotNull
            public static final Sheet INSTANCE = new Sheet();

            public Sheet() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData$Sticky;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Sticky extends UiData {
            @NotNull
            public static final Sticky INSTANCE = new Sticky();

            public Sticky() {
                super(null);
            }
        }

        public UiData() {
        }

        public UiData(j jVar) {
        }
    }

    @NotNull
    LiveData<Unit> getHideKeyboardStream();

    void onBottomSheetOpened();

    void updateContent(@NotNull ContentData contentData);
}
