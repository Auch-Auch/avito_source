package ru.sravni.android.bankproduct.utils.navigation;

import androidx.navigation.NavOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.browser.BrowserAnalyticOpenInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0010¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "", "", "screenID", "", "argumentJson", "Landroidx/navigation/NavOptions$Builder;", "navOptions", "", AnalyticFieldsName.route, "(ILjava/lang/String;Landroidx/navigation/NavOptions$Builder;)V", "", "inclusive", "popBackStack", "(IZ)V", "popBack", "()V", "urlProduct", "Ljava/lang/Runnable;", "completion", "Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "analyticOpenInfo", "openWebView", "(Ljava/lang/String;Ljava/lang/Runnable;Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;)V", "exitFromProfile", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface INavigator {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void openWebView$default(INavigator iNavigator, String str, Runnable runnable, BrowserAnalyticOpenInfo browserAnalyticOpenInfo, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    runnable = null;
                }
                iNavigator.openWebView(str, runnable, browserAnalyticOpenInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openWebView");
        }

        public static /* synthetic */ void route$default(INavigator iNavigator, int i, String str, NavOptions.Builder builder, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                if ((i2 & 4) != 0) {
                    builder = null;
                }
                iNavigator.route(i, str, builder);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: route");
        }
    }

    void exitFromProfile();

    void openWebView(@Nullable String str, @Nullable Runnable runnable, @NotNull BrowserAnalyticOpenInfo browserAnalyticOpenInfo);

    void popBack();

    void popBackStack(int i, boolean z);

    void route(int i, @Nullable String str, @Nullable NavOptions.Builder builder);
}
