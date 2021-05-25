package com.avito.android.messenger.channels.mvi.common;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/Loading;", "T", "", "<init>", "()V", "Empty", "Error", "InProgress", "Success", "Lcom/avito/android/messenger/channels/mvi/common/Loading$Empty;", "Lcom/avito/android/messenger/channels/mvi/common/Loading$InProgress;", "Lcom/avito/android/messenger/channels/mvi/common/Loading$Success;", "Lcom/avito/android/messenger/channels/mvi/common/Loading$Error;", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class Loading<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/Loading$Empty;", "T", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty<T> extends Loading<T> {
        public Empty() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Loading.Empty";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/Loading$Error;", "T", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error<T> extends Loading<T> {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.a = th;
        }

        @NotNull
        public final Throwable getError() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Loading.Error(error = ");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/Loading$InProgress;", "T", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class InProgress<T> extends Loading<T> {
        public final long a;

        public InProgress() {
            this(0, 1, null);
        }

        public InProgress(long j) {
            super(null);
            this.a = j;
        }

        public final long getId() {
            return this.a;
        }

        @NotNull
        public String toString() {
            return a.k(a.L("Loading.InProgress(id = "), this.a, ')');
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InProgress(long j, int i, j jVar) {
            this((i & 1) != 0 ? 0 : j);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\n\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/Loading$Success;", "T", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "value", "<init>", "(Ljava/lang/Object;)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success<T> extends Loading<T> {
        public final T a;

        public Success(T t) {
            super(null);
            this.a = t;
        }

        public final T getValue() {
            return this.a;
        }

        @NotNull
        public String toString() {
            return a.q(a.L("Loading.Success(value = "), this.a, ')');
        }
    }

    public Loading() {
    }

    public Loading(j jVar) {
    }
}
