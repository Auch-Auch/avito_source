package a2.t.a.c.n0;

import com.voximplant.sdk.internal.Logger;
import org.webrtc.Loggable;
import org.webrtc.Logging;
public class i2 implements Loggable {
    public static i2 a;

    @Override // org.webrtc.Loggable
    public void onLogMessage(String str, Logging.Severity severity, String str2) {
        String replace = str.replace("\n", "");
        int ordinal = severity.ordinal();
        if (ordinal == 0) {
            Logger.v(str2 + replace);
        } else if (ordinal == 1) {
            Logger.i(str2 + replace);
        } else if (ordinal == 2) {
            Logger.w(str2 + replace);
        } else if (ordinal != 3) {
            Logger.i(str2 + replace);
        } else {
            Logger.e(str2 + replace);
        }
    }
}
