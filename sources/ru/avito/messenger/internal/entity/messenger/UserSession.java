package ru.avito.messenger.internal.entity.messenger;

import a2.b.a.a.a;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b$\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/UserSession;", "", "", "toString", "()Ljava/lang/String;", "component1", "", "component2", "()Ljava/lang/Long;", "Lru/avito/messenger/internal/entity/messenger/UserOptions;", "component3", "()Lru/avito/messenger/internal/entity/messenger/UserOptions;", "component4", "Lru/avito/messenger/internal/entity/messenger/ServerConfig;", "component5", "()Lru/avito/messenger/internal/entity/messenger/ServerConfig;", ChannelContext.Item.USER_ID, "serverTime", "options", "sequenceId", Navigation.CONFIG, "copy", "(Ljava/lang/String;Ljava/lang/Long;Lru/avito/messenger/internal/entity/messenger/UserOptions;Ljava/lang/String;Lru/avito/messenger/internal/entity/messenger/ServerConfig;)Lru/avito/messenger/internal/entity/messenger/UserSession;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/avito/messenger/internal/entity/messenger/UserOptions;", "getOptions", "Lru/avito/messenger/internal/entity/messenger/ServerConfig;", "getConfig", "Ljava/lang/String;", "getUserId", "getSequenceId", "Ljava/lang/Long;", "getServerTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lru/avito/messenger/internal/entity/messenger/UserOptions;Ljava/lang/String;Lru/avito/messenger/internal/entity/messenger/ServerConfig;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserSession {
    @SerializedName(Navigation.CONFIG)
    @Nullable
    private final ServerConfig config;
    @SerializedName("options")
    @Nullable
    private final UserOptions options;
    @SerializedName("seq")
    @Nullable
    private final String sequenceId;
    @SerializedName("serverTime")
    @Nullable
    private final Long serverTime;
    @SerializedName(ChannelContext.Item.USER_ID)
    @NotNull
    private final String userId;

    public UserSession(@NotNull String str, @Nullable Long l, @Nullable UserOptions userOptions, @Nullable String str2, @Nullable ServerConfig serverConfig) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.userId = str;
        this.serverTime = l;
        this.options = userOptions;
        this.sequenceId = str2;
        this.config = serverConfig;
    }

    public static /* synthetic */ UserSession copy$default(UserSession userSession, String str, Long l, UserOptions userOptions, String str2, ServerConfig serverConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userSession.userId;
        }
        if ((i & 2) != 0) {
            l = userSession.serverTime;
        }
        if ((i & 4) != 0) {
            userOptions = userSession.options;
        }
        if ((i & 8) != 0) {
            str2 = userSession.sequenceId;
        }
        if ((i & 16) != 0) {
            serverConfig = userSession.config;
        }
        return userSession.copy(str, l, userOptions, str2, serverConfig);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final Long component2() {
        return this.serverTime;
    }

    @Nullable
    public final UserOptions component3() {
        return this.options;
    }

    @Nullable
    public final String component4() {
        return this.sequenceId;
    }

    @Nullable
    public final ServerConfig component5() {
        return this.config;
    }

    @NotNull
    public final UserSession copy(@NotNull String str, @Nullable Long l, @Nullable UserOptions userOptions, @Nullable String str2, @Nullable ServerConfig serverConfig) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        return new UserSession(str, l, userOptions, str2, serverConfig);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSession)) {
            return false;
        }
        UserSession userSession = (UserSession) obj;
        return Intrinsics.areEqual(this.userId, userSession.userId) && Intrinsics.areEqual(this.serverTime, userSession.serverTime) && Intrinsics.areEqual(this.options, userSession.options) && Intrinsics.areEqual(this.sequenceId, userSession.sequenceId) && Intrinsics.areEqual(this.config, userSession.config);
    }

    @Nullable
    public final ServerConfig getConfig() {
        return this.config;
    }

    @Nullable
    public final UserOptions getOptions() {
        return this.options;
    }

    @Nullable
    public final String getSequenceId() {
        return this.sequenceId;
    }

    @Nullable
    public final Long getServerTime() {
        return this.serverTime;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.serverTime;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        UserOptions userOptions = this.options;
        int hashCode3 = (hashCode2 + (userOptions != null ? userOptions.hashCode() : 0)) * 31;
        String str2 = this.sequenceId;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ServerConfig serverConfig = this.config;
        if (serverConfig != null) {
            i = serverConfig.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("UserSession(userId='"), this.userId, "')");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserSession(String str, Long l, UserOptions userOptions, String str2, ServerConfig serverConfig, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : userOptions, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : serverConfig);
    }
}
