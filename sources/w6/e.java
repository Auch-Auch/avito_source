package w6;

import a2.b.a.a.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class e extends AsyncTimeout {
    public final Socket a;

    public e(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.a = socket;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        try {
            this.a.close();
        } catch (Exception e) {
            Logger logger = c.a;
            Level level = Level.WARNING;
            StringBuilder L = a.L("Failed to close timed out socket ");
            L.append(this.a);
            logger.log(level, L.toString(), (Throwable) e);
        } catch (AssertionError e2) {
            if (Okio.isAndroidGetsocknameError(e2)) {
                Logger logger2 = c.a;
                Level level2 = Level.WARNING;
                StringBuilder L2 = a.L("Failed to close timed out socket ");
                L2.append(this.a);
                logger2.log(level2, L2.toString(), (Throwable) e2);
                return;
            }
            throw e2;
        }
    }
}
