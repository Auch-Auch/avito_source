package ru.sravni.android.bankproduct.analytic.v2.main;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJX\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/main/MainAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", "eventId", "previousStep", "", "addedParams", "", "massiveParams", "", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "errorType", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sendOpenEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", "getModuleName", "()Ljava/lang/String;", "moduleName", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MainAnalytic implements IMainAnalytic, IBaseAnalytic {
    public final IAnalyticEventLogger a;
    public final /* synthetic */ BaseAnalytic b;

    public MainAnalytic(@NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        this.b = new BaseAnalytic("main", iAnalyticEventLogger);
        this.a = iAnalyticEventLogger;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    @NotNull
    public String getModuleName() {
        return this.b.getModuleName();
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
