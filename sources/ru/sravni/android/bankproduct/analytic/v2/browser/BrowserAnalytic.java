package ru.sravni.android.bankproduct.analytic.v2.browser;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0017\u0010\u0018JN\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/browser/IBrowserAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "analyticOpenInfo", "", "previousStep", "", "sendBrowserOpenEvent", "(Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;Ljava/lang/String;)V", "errorType", AnalyticFieldsName.productName, "", "push", "sendBrowserFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "eventId", "", "addedParams", "", "massiveParams", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sendOpenEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", "getModuleName", "()Ljava/lang/String;", "moduleName", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BrowserAnalytic implements IBrowserAnalytic, IBaseAnalytic {
    public final IAnalyticEventLogger a;
    public final /* synthetic */ BaseAnalytic b;

    public BrowserAnalytic(@NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        this.b = new BaseAnalytic(BaseAnalyticKt.ANALYTIC_MODULE_BROWSER, iAnalyticEventLogger);
        this.a = iAnalyticEventLogger;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    @NotNull
    public String getModuleName() {
        return this.b.getModuleName();
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.browser.IBrowserAnalytic
    public void sendBrowserFailEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool) {
        a.a1(str, "errorType", str2, "previousStep", str3, AnalyticFieldsName.productName);
        Map<String, String> mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.productName, str3));
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(bool.booleanValue()));
        }
        sendFailEvent(str, str2, mutableMapOf);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.browser.IBrowserAnalytic
    public void sendBrowserOpenEvent(@NotNull BrowserAnalyticOpenInfo browserAnalyticOpenInfo, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(browserAnalyticOpenInfo, "analyticOpenInfo");
        Intrinsics.checkParameterIsNotNull(str, "previousStep");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.productName, browserAnalyticOpenInfo.getProductName()));
        if (Intrinsics.areEqual(browserAnalyticOpenInfo.getPush(), Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(browserAnalyticOpenInfo.getPush().booleanValue()));
        }
        Boolean route = browserAnalyticOpenInfo.getRoute();
        if (route != null) {
            mutableMapOf.put(AnalyticFieldsName.route, String.valueOf(route.booleanValue()));
        }
        String orderId = browserAnalyticOpenInfo.getOrderId();
        if (orderId != null) {
            mutableMapOf.put(AnalyticFieldsName.offerName, orderId);
        }
        String organizationName = browserAnalyticOpenInfo.getOrganizationName();
        if (organizationName != null) {
            mutableMapOf.put(AnalyticFieldsName.offerName, organizationName);
        }
        IBaseAnalytic.DefaultImpls.sendOpenEvent$default(this, str, mutableMapOf, null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendEvent(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "eventId");
        this.b.sendEvent(str, str2, map, map2);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendFailEvent(@NotNull String str, @NotNull String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "errorType");
        Intrinsics.checkParameterIsNotNull(str2, "previousStep");
        this.b.sendFailEvent(str, str2, map);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendOpenEvent(@NotNull String str, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "previousStep");
        this.b.sendOpenEvent(str, map, map2);
    }
}
