package ru.avito.messenger.internal.connection;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.api.entity.MessengerResponse;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import ru.avito.messenger.internal.entity.messenger.UserSession;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0013J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\n\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder;", "Lru/avito/messenger/MessengerApi;", "T", "", "", "connect", "()V", "disconnect", "getApi", "()Lru/avito/messenger/MessengerApi;", "api", "Lio/reactivex/Observable;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lru/avito/messenger/api/entity/MessengerResponse;", "getMessagesStream", "messagesStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerConnectionHolder<T extends MessengerApi> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "", "", "getSequenceId", "()Ljava/lang/String;", "sequenceId", "", "isAwaitingConnection", "()Z", "<init>", "()V", "Connected", "Connecting", "Disconnected", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Disconnected;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connected;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connected;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "Lru/avito/messenger/internal/entity/messenger/UserSession;", "component1", "()Lru/avito/messenger/internal/entity/messenger/UserSession;", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", SessionContract.SESSION, "recovered", "sequenceId", "copy", "(Lru/avito/messenger/internal/entity/messenger/UserSession;ZLjava/lang/String;)Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connected;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/internal/entity/messenger/UserSession;", "getSession", "isAwaitingConnection", "Z", AuthSource.BOOKING_ORDER, "getRecovered", "c", "Ljava/lang/String;", "getSequenceId", "<init>", "(Lru/avito/messenger/internal/entity/messenger/UserSession;ZLjava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Connected extends State {
            @NotNull
            public final UserSession a;
            public final boolean b;
            @Nullable
            public final String c;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Connected(UserSession userSession, boolean z, String str, int i, j jVar) {
                this(userSession, (i & 2) != 0 ? false : z, (i & 4) != 0 ? userSession.getSequenceId() : str);
            }

            public static /* synthetic */ Connected copy$default(Connected connected, UserSession userSession, boolean z, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    userSession = connected.a;
                }
                if ((i & 2) != 0) {
                    z = connected.b;
                }
                if ((i & 4) != 0) {
                    str = connected.getSequenceId();
                }
                return connected.copy(userSession, z, str);
            }

            @NotNull
            public final UserSession component1() {
                return this.a;
            }

            public final boolean component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return getSequenceId();
            }

            @NotNull
            public final Connected copy(@NotNull UserSession userSession, boolean z, @Nullable String str) {
                Intrinsics.checkNotNullParameter(userSession, SessionContract.SESSION);
                return new Connected(userSession, z, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Connected)) {
                    return false;
                }
                Connected connected = (Connected) obj;
                return Intrinsics.areEqual(this.a, connected.a) && this.b == connected.b && Intrinsics.areEqual(getSequenceId(), connected.getSequenceId());
            }

            public final boolean getRecovered() {
                return this.b;
            }

            @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
            @Nullable
            public String getSequenceId() {
                return this.c;
            }

            @NotNull
            public final UserSession getSession() {
                return this.a;
            }

            public int hashCode() {
                UserSession userSession = this.a;
                int i = 0;
                int hashCode = (userSession != null ? userSession.hashCode() : 0) * 31;
                boolean z = this.b;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                String sequenceId = getSequenceId();
                if (sequenceId != null) {
                    i = sequenceId.hashCode();
                }
                return i5 + i;
            }

            @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
            public boolean isAwaitingConnection() {
                return false;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Connected(session=");
                L.append(this.a);
                L.append(", recovered=");
                L.append(this.b);
                L.append(", sequenceId=");
                L.append(getSequenceId());
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Connected(@NotNull UserSession userSession, boolean z, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(userSession, SessionContract.SESSION);
                this.a = userSession;
                this.b = z;
                this.c = str;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000b\u0010\u0004¨\u0006\""}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Disconnected;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "", "component1", "()Z", "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "component2", "()Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "", "component3", "()Ljava/lang/String;", "isAwaitingConnection", "terminationEvent", "sequenceId", "copy", "(ZLru/avito/messenger/internal/entity/messenger/TerminationEvent;Ljava/lang/String;)Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Disconnected;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getSequenceId", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/internal/entity/messenger/TerminationEvent;", "getTerminationEvent", AuthSource.SEND_ABUSE, "Z", "<init>", "(ZLru/avito/messenger/internal/entity/messenger/TerminationEvent;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Disconnected extends State {
            public final boolean a;
            @Nullable
            public final TerminationEvent b;
            @Nullable
            public final String c;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Disconnected(boolean z, TerminationEvent terminationEvent, String str, int i, j jVar) {
                this(z, (i & 2) != 0 ? null : terminationEvent, (i & 4) != 0 ? null : str);
            }

            public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, boolean z, TerminationEvent terminationEvent, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = disconnected.isAwaitingConnection();
                }
                if ((i & 2) != 0) {
                    terminationEvent = disconnected.b;
                }
                if ((i & 4) != 0) {
                    str = disconnected.getSequenceId();
                }
                return disconnected.copy(z, terminationEvent, str);
            }

            public final boolean component1() {
                return isAwaitingConnection();
            }

            @Nullable
            public final TerminationEvent component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return getSequenceId();
            }

            @NotNull
            public final Disconnected copy(boolean z, @Nullable TerminationEvent terminationEvent, @Nullable String str) {
                return new Disconnected(z, terminationEvent, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Disconnected)) {
                    return false;
                }
                Disconnected disconnected = (Disconnected) obj;
                return isAwaitingConnection() == disconnected.isAwaitingConnection() && Intrinsics.areEqual(this.b, disconnected.b) && Intrinsics.areEqual(getSequenceId(), disconnected.getSequenceId());
            }

            @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
            @Nullable
            public String getSequenceId() {
                return this.c;
            }

            @Nullable
            public final TerminationEvent getTerminationEvent() {
                return this.b;
            }

            public int hashCode() {
                boolean isAwaitingConnection = isAwaitingConnection();
                if (isAwaitingConnection) {
                    isAwaitingConnection = true;
                }
                int i = isAwaitingConnection ? 1 : 0;
                int i2 = isAwaitingConnection ? 1 : 0;
                int i3 = isAwaitingConnection ? 1 : 0;
                int i4 = i * 31;
                TerminationEvent terminationEvent = this.b;
                int i5 = 0;
                int hashCode = (i4 + (terminationEvent != null ? terminationEvent.hashCode() : 0)) * 31;
                String sequenceId = getSequenceId();
                if (sequenceId != null) {
                    i5 = sequenceId.hashCode();
                }
                return hashCode + i5;
            }

            @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
            public boolean isAwaitingConnection() {
                return this.a;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Disconnected(isAwaitingConnection=");
                L.append(isAwaitingConnection());
                L.append(", terminationEvent=");
                L.append(this.b);
                L.append(", sequenceId=");
                L.append(getSequenceId());
                L.append(")");
                return L.toString();
            }

            public Disconnected(boolean z, @Nullable TerminationEvent terminationEvent, @Nullable String str) {
                super(null);
                this.a = z;
                this.b = terminationEvent;
                this.c = str;
            }
        }

        public State() {
        }

        @Nullable
        public abstract String getSequenceId();

        public abstract boolean isAwaitingConnection();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State;", "", AuthSource.SEND_ABUSE, "Z", "isAwaitingConnection", "()Z", "<init>", "()V", "Session", "Socket", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Socket;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Session;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Connecting extends State {
            public final boolean a = true;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Session;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting;", "", "component1", "()Ljava/lang/String;", "sequenceId", "copy", "(Ljava/lang/String;)Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Session;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSequenceId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Session extends Connecting {
                @Nullable
                public final String b;

                public Session() {
                    this(null, 1, null);
                }

                public Session(@Nullable String str) {
                    super(null);
                    this.b = str;
                }

                public static /* synthetic */ Session copy$default(Session session, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = session.getSequenceId();
                    }
                    return session.copy(str);
                }

                @Nullable
                public final String component1() {
                    return getSequenceId();
                }

                @NotNull
                public final Session copy(@Nullable String str) {
                    return new Session(str);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Session) && Intrinsics.areEqual(getSequenceId(), ((Session) obj).getSequenceId());
                    }
                    return true;
                }

                @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
                @Nullable
                public String getSequenceId() {
                    return this.b;
                }

                public int hashCode() {
                    String sequenceId = getSequenceId();
                    if (sequenceId != null) {
                        return sequenceId.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Session(sequenceId=");
                    L.append(getSequenceId());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Session(String str, int i, j jVar) {
                    this((i & 1) != 0 ? null : str);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Socket;", "Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting;", "", "component1", "()Ljava/lang/String;", "sequenceId", "copy", "(Ljava/lang/String;)Lru/avito/messenger/internal/connection/MessengerConnectionHolder$State$Connecting$Socket;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSequenceId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Socket extends Connecting {
                @Nullable
                public final String b;

                public Socket() {
                    this(null, 1, null);
                }

                public Socket(@Nullable String str) {
                    super(null);
                    this.b = str;
                }

                public static /* synthetic */ Socket copy$default(Socket socket, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = socket.getSequenceId();
                    }
                    return socket.copy(str);
                }

                @Nullable
                public final String component1() {
                    return getSequenceId();
                }

                @NotNull
                public final Socket copy(@Nullable String str) {
                    return new Socket(str);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Socket) && Intrinsics.areEqual(getSequenceId(), ((Socket) obj).getSequenceId());
                    }
                    return true;
                }

                @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
                @Nullable
                public String getSequenceId() {
                    return this.b;
                }

                public int hashCode() {
                    String sequenceId = getSequenceId();
                    if (sequenceId != null) {
                        return sequenceId.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Socket(sequenceId=");
                    L.append(getSequenceId());
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Socket(String str, int i, j jVar) {
                    this((i & 1) != 0 ? null : str);
                }
            }

            public Connecting() {
                super(null);
            }

            @Override // ru.avito.messenger.internal.connection.MessengerConnectionHolder.State
            public boolean isAwaitingConnection() {
                return this.a;
            }

            public Connecting(j jVar) {
                super(null);
            }
        }

        public State(j jVar) {
        }
    }

    void connect();

    void disconnect();

    @NotNull
    T getApi();

    @NotNull
    Observable<MessengerResponse> getMessagesStream();

    @NotNull
    Observable<State> getStateObservable();
}
