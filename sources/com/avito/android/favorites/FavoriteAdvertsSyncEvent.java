package com.avito.android.favorites;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Started", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Started;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Completed;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Failed;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoriteAdvertsSyncEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Completed;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;", "", "component1", "()Ljava/lang/String;", "id", "copy", "(Ljava/lang/String;)Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Completed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Completed extends FavoriteAdvertsSyncEvent {
        @NotNull
        public final String a;

        public Completed() {
            this(null, 1, null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Completed(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.a = str;
        }

        public static /* synthetic */ Completed copy$default(Completed completed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = completed.a;
            }
            return completed.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Completed copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Completed(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Completed) && Intrinsics.areEqual(this.a, ((Completed) obj).a);
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
            return a.t(a.L("Completed(id="), this.a, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Completed(String str, int i, j jVar) {
            this((i & 1) != 0 ? FavoriteAdvertsSyncEventKt.access$generateId() : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Failed;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;", "", "component1", "()Ljava/lang/Throwable;", "reason", "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Failed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getReason", "<init>", "(Ljava/lang/Throwable;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failed extends FavoriteAdvertsSyncEvent {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "reason");
            this.a = th;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = failed.a;
            }
            return failed.copy(th);
        }

        @NotNull
        public final Throwable component1() {
            return this.a;
        }

        @NotNull
        public final Failed copy(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "reason");
            return new Failed(th);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Failed) && Intrinsics.areEqual(this.a, ((Failed) obj).a);
            }
            return true;
        }

        @NotNull
        public final Throwable getReason() {
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
            StringBuilder L = a.L("Failed(reason=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent$Started;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEvent;", "<init>", "()V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Started extends FavoriteAdvertsSyncEvent {
        public Started() {
            super(null);
        }
    }

    public FavoriteAdvertsSyncEvent() {
    }

    public FavoriteAdvertsSyncEvent(j jVar) {
    }
}
