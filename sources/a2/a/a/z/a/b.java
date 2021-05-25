package a2.a.a.z.a;

import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import com.voximplant.sdk.client.ILogListener;
import com.voximplant.sdk.client.LogLevel;
import kotlin.jvm.internal.Intrinsics;
public final class b implements ILogListener {
    public static final b a = new b();

    @Override // com.voximplant.sdk.client.ILogListener
    public final void onLogMessage(LogLevel logLevel, String str) {
        if (logLevel != null) {
            int ordinal = logLevel.ordinal();
            if (ordinal == 0) {
                Intrinsics.checkNotNullExpressionValue(str, "message");
                Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
            } else if (ordinal == 1) {
                Intrinsics.checkNotNullExpressionValue(str, "message");
                Logs.debug$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
            } else if (ordinal == 2) {
                Intrinsics.checkNotNullExpressionValue(str, "message");
                Logs.info$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
            } else if (ordinal == 3) {
                Intrinsics.checkNotNullExpressionValue(str, "message");
                Logs.warning$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
            } else if (ordinal == 4) {
                Intrinsics.checkNotNullExpressionValue(str, "message");
                Logs.error$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
            }
        }
    }
}
