package ru.sravni.android.bankproduct.analytic.v2.product;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u0012\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JX\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ8\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\r\u0010\u001bJN\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\n\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/product/ProductAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", "previousStep", AnalyticFieldsName.productName, AnalyticFieldsName.draft, "", "isPush", "", "sendOpenEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "errorType", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", AnalyticFieldsName.step, "conversationID", "isProlongation", "sendChatEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;)V", "eventId", "", "addedParams", "", "massiveParams", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getModuleName", "()Ljava/lang/String;", "moduleName", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProductAnalytic implements IProductAnalytic, IBaseAnalytic {
    public final IAnalyticEventLogger a;
    public final /* synthetic */ BaseAnalytic b;

    public ProductAnalytic(@NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        this.b = new BaseAnalytic(BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT, iAnalyticEventLogger);
        this.a = iAnalyticEventLogger;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    @NotNull
    public String getModuleName() {
        return this.b.getModuleName();
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic
    public void sendChatEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable Boolean bool, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str4, "previousStep");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("push", String.valueOf(z)));
        if (str != null) {
            mutableMapOf.put(AnalyticFieldsName.productName, str);
        }
        if (str2 != null) {
            mutableMapOf.put(AnalyticFieldsName.step, str2);
        }
        if (str3 != null) {
            mutableMapOf.put(AnalyticFieldsName.conversationID, str3);
        }
        if (bool != null) {
            mutableMapOf.put(AnalyticFieldsName.prolongation, String.valueOf(bool.booleanValue()));
        }
        IBaseAnalytic.DefaultImpls.sendEvent$default(this, getModuleName() + BaseAnalyticKt.ANALYTIC_ACTION_CHAT, str4, mutableMapOf, null, 8, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendEvent(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "eventId");
        this.b.sendEvent(str, str2, map, map2);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic
    public void sendFailEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.a1(str, "errorType", str2, "previousStep", str3, AnalyticFieldsName.productName);
        sendFailEvent(str, str2, r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.productName, str3)));
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendFailEvent(@NotNull String str, @NotNull String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "errorType");
        Intrinsics.checkParameterIsNotNull(str2, "previousStep");
        this.b.sendFailEvent(str, str2, map);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic
    public void sendOpenEvent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "previousStep");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.productName, str2));
        if (str3 != null) {
            mutableMapOf.put(AnalyticFieldsName.draft, str3);
        }
        if (z) {
            mutableMapOf.put("push", String.valueOf(z));
        }
        IBaseAnalytic.DefaultImpls.sendOpenEvent$default(this, str, mutableMapOf, null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendOpenEvent(@NotNull String str, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "previousStep");
        this.b.sendOpenEvent(str, map, map2);
    }
}
