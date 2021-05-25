package ru.sravni.android.bankproduct.analytic.v2.browser;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/browser/IBrowserAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "analyticOpenInfo", "", "previousStep", "", "sendBrowserOpenEvent", "(Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;Ljava/lang/String;)V", "errorType", AnalyticFieldsName.productName, "", "push", "sendBrowserFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IBrowserAnalytic extends IBaseAnalytic {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendBrowserFailEvent$default(IBrowserAnalytic iBrowserAnalytic, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    bool = null;
                }
                iBrowserAnalytic.sendBrowserFailEvent(str, str2, str3, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBrowserFailEvent");
        }
    }

    void sendBrowserFailEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool);

    void sendBrowserOpenEvent(@NotNull BrowserAnalyticOpenInfo browserAnalyticOpenInfo, @NotNull String str);
}
