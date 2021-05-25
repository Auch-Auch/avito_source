package a2.a.a.f.x.t.j;

import android.webkit.JavascriptInterface;
import com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"La2/a/a/f/x/t/j/a;", "", "", "type", "result", "data", "", "receiveMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", "eventLogger", "<init>", "(Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class a {
    public final SravniWebAnalyticsEventLogger a;

    public a(@NotNull SravniWebAnalyticsEventLogger sravniWebAnalyticsEventLogger) {
        Intrinsics.checkNotNullParameter(sravniWebAnalyticsEventLogger, "eventLogger");
        this.a = sravniWebAnalyticsEventLogger;
    }

    @JavascriptInterface
    public final void receiveMessage(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (!(str == null || str2 == null)) {
            this.a.logEvent(str, str2);
        }
        Logs.debug$default("SravniAnalytics", a2.b.a.a.a.f(str, " : ", str2, " : ", str3), null, 4, null);
    }
}
