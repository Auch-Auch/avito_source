package com.avito.android.favorites.event;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "", "<init>", "()V", "UpdateError", "UpdateFinished", "UpdateStarted", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateStarted;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateFinished;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateError;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoriteListUpdateEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateError;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "", "component1", "()Ljava/lang/Throwable;", "error", "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "<init>", "(Ljava/lang/Throwable;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateError extends FavoriteListUpdateEvent {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateError(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.a = th;
        }

        public static /* synthetic */ UpdateError copy$default(UpdateError updateError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = updateError.a;
            }
            return updateError.copy(th);
        }

        @NotNull
        public final Throwable component1() {
            return this.a;
        }

        @NotNull
        public final UpdateError copy(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
            return new UpdateError(th);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof UpdateError) && Intrinsics.areEqual(this.a, ((UpdateError) obj).a);
            }
            return true;
        }

        @NotNull
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
            StringBuilder L = a.L("UpdateError(error=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateFinished;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "", "component1", "()Ljava/lang/String;", "id", "copy", "(Ljava/lang/String;)Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateFinished;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateFinished extends FavoriteListUpdateEvent {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateFinished(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.a = str;
        }

        public static /* synthetic */ UpdateFinished copy$default(UpdateFinished updateFinished, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateFinished.a;
            }
            return updateFinished.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final UpdateFinished copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new UpdateFinished(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof UpdateFinished) && Intrinsics.areEqual(this.a, ((UpdateFinished) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getId() {
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
            return a.t(a.L("UpdateFinished(id="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorites/event/FavoriteListUpdateEvent$UpdateStarted;", "Lcom/avito/android/favorites/event/FavoriteListUpdateEvent;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateStarted extends FavoriteListUpdateEvent {
        @NotNull
        public static final UpdateStarted INSTANCE = new UpdateStarted();

        public UpdateStarted() {
            super(null);
        }
    }

    public FavoriteListUpdateEvent() {
    }

    public FavoriteListUpdateEvent(j jVar) {
    }
}
