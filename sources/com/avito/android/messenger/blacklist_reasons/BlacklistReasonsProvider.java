package com.avito.android.messenger.blacklist_reasons;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BlacklistReasons;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "", "suppressError", "", "loadBlacklistReasons", "(Z)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistReasonsProvider extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void loadBlacklistReasons$default(BlacklistReasonsProvider blacklistReasonsProvider, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                blacklistReasonsProvider.loadBlacklistReasons(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBlacklistReasons");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "", "<init>", "()V", "Empty", "Loaded", "Loading", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Loading;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Loaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "", "component1", "()Ljava/lang/Throwable;", "error", "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @Nullable
            public final Throwable a;

            public Empty() {
                this(null, 1, null);
            }

            public Empty(@Nullable Throwable th) {
                super(null);
                this.a = th;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = empty.a;
                }
                return empty.copy(th);
            }

            @Nullable
            public final Throwable component1() {
                return this.a;
            }

            @NotNull
            public final Empty copy(@Nullable Throwable th) {
                return new Empty(th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Empty) && Intrinsics.areEqual(this.a, ((Empty) obj).a);
                }
                return true;
            }

            @Nullable
            public final Throwable getError() {
                return this.a;
            }

            public int hashCode() {
                Throwable th = this.a;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Empty(error=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Empty(Throwable th, int i, j jVar) {
                this((i & 1) != 0 ? null : th);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Loaded;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "Lru/avito/messenger/api/entity/BlacklistReasons;", "component1", "()Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "copy", "(Lru/avito/messenger/api/entity/BlacklistReasons;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/api/entity/BlacklistReasons;", "getReasons", "<init>", "(Lru/avito/messenger/api/entity/BlacklistReasons;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final BlacklistReasons a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull BlacklistReasons blacklistReasons) {
                super(null);
                Intrinsics.checkNotNullParameter(blacklistReasons, "reasons");
                this.a = blacklistReasons;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, BlacklistReasons blacklistReasons, int i, Object obj) {
                if ((i & 1) != 0) {
                    blacklistReasons = loaded.a;
                }
                return loaded.copy(blacklistReasons);
            }

            @NotNull
            public final BlacklistReasons component1() {
                return this.a;
            }

            @NotNull
            public final Loaded copy(@NotNull BlacklistReasons blacklistReasons) {
                Intrinsics.checkNotNullParameter(blacklistReasons, "reasons");
                return new Loaded(blacklistReasons);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Loaded) && Intrinsics.areEqual(this.a, ((Loaded) obj).a);
                }
                return true;
            }

            @NotNull
            public final BlacklistReasons getReasons() {
                return this.a;
            }

            public int hashCode() {
                BlacklistReasons blacklistReasons = this.a;
                if (blacklistReasons != null) {
                    return blacklistReasons.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded(reasons=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State$Loading;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    void loadBlacklistReasons(boolean z);
}
