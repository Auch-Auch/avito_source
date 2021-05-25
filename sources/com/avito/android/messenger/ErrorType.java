package com.avito.android.messenger;

import com.avito.android.util.UnauthorizedException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00042\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/ErrorType;", "", "<init>", "()V", "Companion", "Network", "Other", "Unauthorized", "Lcom/avito/android/messenger/ErrorType$Unauthorized;", "Lcom/avito/android/messenger/ErrorType$Network;", "Lcom/avito/android/messenger/ErrorType$Other;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ErrorType {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/ErrorType$Companion;", "", "", "throwable", "Lcom/avito/android/messenger/ErrorType;", "invoke", "(Ljava/lang/Throwable;)Lcom/avito/android/messenger/ErrorType;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ErrorType invoke(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            if (th instanceof UnauthorizedException) {
                return Unauthorized.INSTANCE;
            }
            if (th instanceof IOException) {
                return Network.INSTANCE;
            }
            return Other.INSTANCE;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/ErrorType$Network;", "Lcom/avito/android/messenger/ErrorType;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Network extends ErrorType {
        @NotNull
        public static final Network INSTANCE = new Network();

        public Network() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/ErrorType$Other;", "Lcom/avito/android/messenger/ErrorType;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Other extends ErrorType {
        @NotNull
        public static final Other INSTANCE = new Other();

        public Other() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/ErrorType$Unauthorized;", "Lcom/avito/android/messenger/ErrorType;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unauthorized extends ErrorType {
        @NotNull
        public static final Unauthorized INSTANCE = new Unauthorized();

        public Unauthorized() {
            super(null);
        }
    }

    public ErrorType() {
    }

    public ErrorType(j jVar) {
    }
}
