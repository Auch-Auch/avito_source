package ru.avito.messenger.internal.entity.messenger;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/ServerConfig;", "", "", "component1", "()Ljava/lang/Long;", "timeToModifyMessage", "copy", "(Ljava/lang/Long;)Lru/avito/messenger/internal/entity/messenger/ServerConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getTimeToModifyMessage", "<init>", "(Ljava/lang/Long;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ServerConfig {
    @SerializedName("timeToModifyMessage")
    @Nullable
    private final Long timeToModifyMessage;

    public ServerConfig() {
        this(null, 1, null);
    }

    public ServerConfig(@Nullable Long l) {
        this.timeToModifyMessage = l;
    }

    public static /* synthetic */ ServerConfig copy$default(ServerConfig serverConfig, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = serverConfig.timeToModifyMessage;
        }
        return serverConfig.copy(l);
    }

    @Nullable
    public final Long component1() {
        return this.timeToModifyMessage;
    }

    @NotNull
    public final ServerConfig copy(@Nullable Long l) {
        return new ServerConfig(l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ServerConfig) && Intrinsics.areEqual(this.timeToModifyMessage, ((ServerConfig) obj).timeToModifyMessage);
        }
        return true;
    }

    @Nullable
    public final Long getTimeToModifyMessage() {
        return this.timeToModifyMessage;
    }

    public int hashCode() {
        Long l = this.timeToModifyMessage;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ServerConfig(timeToModifyMessage=");
        L.append(this.timeToModifyMessage);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServerConfig(Long l, int i, j jVar) {
        this((i & 1) != 0 ? null : l);
    }
}
