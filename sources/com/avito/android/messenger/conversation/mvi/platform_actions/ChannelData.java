package com.avito.android.messenger.conversation.mvi.platform_actions;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u001a\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelDataId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "component5", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "id", "channelId", ChannelEntity.COLUMN_UPDATED, "flow", "actions", "copy", "(JLjava/lang/String;JLjava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Ljava/lang/String;", "J", "<init>", "(JLjava/lang/String;JLjava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long EMPTY_ID = -1;
    @JvmField
    @NotNull
    public final PlatformActions actions;
    @JvmField
    @NotNull
    public final String channelId;
    @JvmField
    @Nullable
    public final String flow;
    @JvmField
    public final long id;
    @JvmField
    public final long updated;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData$Companion;", "", "", "EMPTY_ID", "J", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ChannelData(long j, @NotNull String str, long j2, @Nullable String str2, @NotNull PlatformActions platformActions) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(platformActions, "actions");
        this.id = j;
        this.channelId = str;
        this.updated = j2;
        this.flow = str2;
        this.actions = platformActions;
    }

    public static /* synthetic */ ChannelData copy$default(ChannelData channelData, long j, String str, long j2, String str2, PlatformActions platformActions, int i, Object obj) {
        return channelData.copy((i & 1) != 0 ? channelData.id : j, (i & 2) != 0 ? channelData.channelId : str, (i & 4) != 0 ? channelData.updated : j2, (i & 8) != 0 ? channelData.flow : str2, (i & 16) != 0 ? channelData.actions : platformActions);
    }

    public final long component1() {
        return this.id;
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
    public final ChannelData copy(long j, @NotNull String str, long j2, @Nullable String str2, @NotNull PlatformActions platformActions) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(platformActions, "actions");
        return new ChannelData(j, str, j2, str2, platformActions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelData)) {
            return false;
        }
        ChannelData channelData = (ChannelData) obj;
        return this.id == channelData.id && Intrinsics.areEqual(this.channelId, channelData.channelId) && this.updated == channelData.updated && Intrinsics.areEqual(this.flow, channelData.flow) && Intrinsics.areEqual(this.actions, channelData.actions);
    }

    public int hashCode() {
        int a = c.a(this.id) * 31;
        String str = this.channelId;
        int i = 0;
        int hashCode = (((a + (str != null ? str.hashCode() : 0)) * 31) + c.a(this.updated)) * 31;
        String str2 = this.flow;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PlatformActions platformActions = this.actions;
        if (platformActions != null) {
            i = platformActions.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChannelData(id=");
        L.append(this.id);
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
}
