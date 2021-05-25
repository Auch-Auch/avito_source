package com.avito.android.messenger.blacklist_reasons;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BlacklistReasons;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView;", "", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "state", "", "render", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;)V", "destroyView", "()V", "Lio/reactivex/Observable;", "", "getReasonSelections", "()Lio/reactivex/Observable;", "reasonSelections", "getBackNavigationClicks", "backNavigationClicks", "getRetryClicks", "retryClicks", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistReasonsView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "", "<init>", "()V", "Empty", "InProgress", "List", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$Empty;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "Empty";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "<init>", "()V", "BlockUser", "Reasons", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress$Reasons;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress$BlockUser;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class InProgress extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress$BlockUser;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class BlockUser extends InProgress {
                @NotNull
                public static final BlockUser INSTANCE = new BlockUser();

                public BlockUser() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "InProgress.BlockUser";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress$Reasons;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$InProgress;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Reasons extends InProgress {
                @NotNull
                public static final Reasons INSTANCE = new Reasons();

                public Reasons() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "InProgress.Reasons";
                }
            }

            public InProgress() {
                super(null);
            }

            public InProgress(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "Lru/avito/messenger/api/entity/BlacklistReasons;", "getReasons", "()Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "<init>", "()V", "BlockUserError", "Ok", "ReasonsError", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$Ok;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$ReasonsError;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$BlockUserError;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class List extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$BlockUserError;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getError", "error", "Lru/avito/messenger/api/entity/BlacklistReasons;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/api/entity/BlacklistReasons;", "getReasons", "()Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "<init>", "(Lru/avito/messenger/api/entity/BlacklistReasons;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class BlockUserError extends List {
                @NotNull
                public final BlacklistReasons a;
                @NotNull
                public final String b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public BlockUserError(@NotNull BlacklistReasons blacklistReasons, @NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(blacklistReasons, "reasons");
                    Intrinsics.checkNotNullParameter(str, "error");
                    this.a = blacklistReasons;
                    this.b = str;
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof BlockUserError)) {
                        return false;
                    }
                    BlockUserError blockUserError = (BlockUserError) obj;
                    return !(Intrinsics.areEqual(getReasons(), blockUserError.getReasons()) ^ true) && !(Intrinsics.areEqual(this.b, blockUserError.b) ^ true);
                }

                @NotNull
                public final String getError() {
                    return this.b;
                }

                @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView.State.List
                @NotNull
                public BlacklistReasons getReasons() {
                    return this.a;
                }

                public int hashCode() {
                    return this.b.hashCode() + (getReasons().hashCode() * 31);
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("List.BlockUserError(reasons=");
                    L.append(getReasons());
                    L.append(", error='");
                    return a.t(L, this.b, "')");
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$Ok;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lru/avito/messenger/api/entity/BlacklistReasons;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/api/entity/BlacklistReasons;", "getReasons", "()Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "<init>", "(Lru/avito/messenger/api/entity/BlacklistReasons;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Ok extends List {
                @NotNull
                public final BlacklistReasons a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Ok(@NotNull BlacklistReasons blacklistReasons) {
                    super(null);
                    Intrinsics.checkNotNullParameter(blacklistReasons, "reasons");
                    this.a = blacklistReasons;
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Ok) && !(Intrinsics.areEqual(getReasons(), ((Ok) obj).getReasons()) ^ true);
                }

                @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView.State.List
                @NotNull
                public BlacklistReasons getReasons() {
                    return this.a;
                }

                public int hashCode() {
                    return getReasons().hashCode();
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("List.Ok(reasons=");
                    L.append(getReasons());
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List$ReasonsError;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State$List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "Lru/avito/messenger/api/entity/BlacklistReasons;", "getReasons", "()Lru/avito/messenger/api/entity/BlacklistReasons;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getError", "error", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class ReasonsError extends List {
                @NotNull
                public final String a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ReasonsError(@NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "error");
                    this.a = str;
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof ReasonsError) && !(Intrinsics.areEqual(this.a, ((ReasonsError) obj).a) ^ true);
                }

                @NotNull
                public final String getError() {
                    return this.a;
                }

                @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView.State.List
                @Nullable
                public BlacklistReasons getReasons() {
                    return null;
                }

                public int hashCode() {
                    return this.a.hashCode();
                }

                @NotNull
                public String toString() {
                    return a.t(a.L("List.ReasonsError(error='"), this.a, "')");
                }
            }

            public List() {
                super(null);
            }

            @Nullable
            public abstract BlacklistReasons getReasons();

            public List(j jVar) {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    void destroyView();

    @NotNull
    Observable<Unit> getBackNavigationClicks();

    @NotNull
    Observable<Long> getReasonSelections();

    @NotNull
    Observable<Unit> getRetryClicks();

    void render(@NotNull State state);
}
