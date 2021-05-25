package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002:\u0006\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/util/MultiStateLoading;", "T", "", "<init>", "()V", "Error", "InitError", "InitLoading", "Loaded", "Loading", "LoadingComplete", "Lcom/avito/android/util/MultiStateLoading$Loaded;", "Lcom/avito/android/util/MultiStateLoading$LoadingComplete;", "Lcom/avito/android/util/MultiStateLoading$Loading;", "Lcom/avito/android/util/MultiStateLoading$Error;", "Lcom/avito/android/util/MultiStateLoading$InitLoading;", "Lcom/avito/android/util/MultiStateLoading$InitError;", "loading-state_release"}, k = 1, mv = {1, 4, 2})
public abstract class MultiStateLoading<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$Error;", "Lcom/avito/android/util/MultiStateLoading;", "", "Lcom/avito/android/remote/error/ErrorResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getError", "()Lcom/avito/android/remote/error/ErrorResult;", "error", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends MultiStateLoading<Object> {
        @NotNull
        public final ErrorResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull ErrorResult errorResult) {
            super(null);
            Intrinsics.checkNotNullParameter(errorResult, "error");
            this.a = errorResult;
        }

        @NotNull
        public final ErrorResult getError() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$InitError;", "Lcom/avito/android/util/MultiStateLoading;", "", "Lcom/avito/android/remote/error/ErrorResult;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/ErrorResult;", "getError", "()Lcom/avito/android/remote/error/ErrorResult;", "error", "<init>", "(Lcom/avito/android/remote/error/ErrorResult;)V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitError extends MultiStateLoading<Object> {
        @NotNull
        public final ErrorResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitError(@NotNull ErrorResult errorResult) {
            super(null);
            Intrinsics.checkNotNullParameter(errorResult, "error");
            this.a = errorResult;
        }

        @NotNull
        public final ErrorResult getError() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$InitLoading;", "Lcom/avito/android/util/MultiStateLoading;", "", "<init>", "()V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitLoading extends MultiStateLoading<Object> {
        @NotNull
        public static final InitLoading INSTANCE = new InitLoading();

        public InitLoading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$Loaded;", "T", "Lcom/avito/android/util/MultiStateLoading;", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "data", "<init>", "(Ljava/lang/Object;)V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loaded<T> extends MultiStateLoading<T> {
        public final T a;

        public Loaded(T t) {
            super(null);
            this.a = t;
        }

        public final T getData() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$Loading;", "Lcom/avito/android/util/MultiStateLoading;", "", "<init>", "()V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends MultiStateLoading<Object> {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/MultiStateLoading$LoadingComplete;", "Lcom/avito/android/util/MultiStateLoading;", "", "<init>", "()V", "loading-state_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadingComplete extends MultiStateLoading<Object> {
        @NotNull
        public static final LoadingComplete INSTANCE = new LoadingComplete();

        public LoadingComplete() {
            super(null);
        }
    }

    public MultiStateLoading() {
    }

    public MultiStateLoading(j jVar) {
    }
}
