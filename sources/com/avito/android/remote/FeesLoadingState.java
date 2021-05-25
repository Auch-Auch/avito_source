package com.avito.android.remote;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/FeesLoadingState;", "", "<init>", "()V", "Error", "Loading", "Success", "Lcom/avito/android/remote/FeesLoadingState$Success;", "Lcom/avito/android/remote/FeesLoadingState$Loading;", "Lcom/avito/android/remote/FeesLoadingState$Error;", "fees_release"}, k = 1, mv = {1, 4, 2})
public abstract class FeesLoadingState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/FeesLoadingState$Error;", "Lcom/avito/android/remote/FeesLoadingState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends FeesLoadingState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/FeesLoadingState$Loading;", "Lcom/avito/android/remote/FeesLoadingState;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends FeesLoadingState {
        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/FeesLoadingState$Success;", "Lcom/avito/android/remote/FeesLoadingState;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends FeesLoadingState {
        public Success() {
            super(null);
        }
    }

    public FeesLoadingState() {
    }

    public FeesLoadingState(j jVar) {
    }
}
