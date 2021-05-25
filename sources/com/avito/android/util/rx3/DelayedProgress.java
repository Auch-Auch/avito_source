package com.avito.android.util.rx3;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/rx3/DelayedProgress;", "T", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/util/rx3/DelayedProgress$Loading;", "Lcom/avito/android/util/rx3/DelayedProgress$Loaded;", "Lcom/avito/android/util/rx3/DelayedProgress$Error;", "rx"}, k = 1, mv = {1, 4, 2})
public abstract class DelayedProgress<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/util/rx3/DelayedProgress$Error;", "Lcom/avito/android/util/rx3/DelayedProgress;", "", "", "component1", "()Ljava/lang/Throwable;", "error", "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/util/rx3/DelayedProgress$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "<init>", "(Ljava/lang/Throwable;)V", "rx"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends DelayedProgress {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.a = th;
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = error.a;
            }
            return error.copy(th);
        }

        @NotNull
        public final Throwable component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
            return new Error(th);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
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
            StringBuilder L = a.L("Error(error=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/util/rx3/DelayedProgress$Loaded;", "T", "Lcom/avito/android/util/rx3/DelayedProgress;", "component1", "()Ljava/lang/Object;", "data", "copy", "(Ljava/lang/Object;)Lcom/avito/android/util/rx3/DelayedProgress$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getData", "<init>", "(Ljava/lang/Object;)V", "rx"}, k = 1, mv = {1, 4, 2})
    public static final class Loaded<T> extends DelayedProgress<T> {
        public final T a;

        public Loaded(T t) {
            super(null);
            this.a = t;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.util.rx3.DelayedProgress$Loaded */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = loaded.a;
            }
            return loaded.copy(obj);
        }

        public final T component1() {
            return this.a;
        }

        @NotNull
        public final Loaded<T> copy(T t) {
            return new Loaded<>(t);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Loaded) && Intrinsics.areEqual(this.a, ((Loaded) obj).a);
            }
            return true;
        }

        public final T getData() {
            return this.a;
        }

        public int hashCode() {
            T t = this.a;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.r(a.L("Loaded(data="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/rx3/DelayedProgress$Loading;", "Lcom/avito/android/util/rx3/DelayedProgress;", "", "<init>", "()V", "rx"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends DelayedProgress {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    public DelayedProgress() {
    }

    public DelayedProgress(j jVar) {
    }
}
