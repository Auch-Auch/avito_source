package ru.sravni.android.bankproduct.analytic.v2;

import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJI\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJS\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/BaseAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", "previousStep", "", "addedParams", "", "massiveParams", "", "sendOpenEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "errorType", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "eventId", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "moduleName", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BaseAnalytic implements IBaseAnalytic {
    @NotNull
    public final String a;
    public final IAnalyticEventLogger b;

    public BaseAnalytic(@NotNull String str, @NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(str, "moduleName");
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        this.a = str;
        this.b = iAnalyticEventLogger;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    @NotNull
    public String getModuleName() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendEvent(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Set<Map.Entry<String, String>> entrySet;
        Intrinsics.checkParameterIsNotNull(str, "eventId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str2 != null) {
            linkedHashMap.put("previousStep", str2);
        }
        if (!(map == null || (entrySet = map.entrySet()) == null)) {
            for (T t : entrySet) {
                linkedHashMap.put(t.getKey(), t.getValue());
            }
        }
        if (map2 == null) {
            map2 = r.emptyMap();
        }
        this.b.logEvent(new AnalyticEvent(str, linkedHashMap, map2));
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendFailEvent(@NotNull String str, @NotNull String str2, @Nullable Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet;
        Intrinsics.checkParameterIsNotNull(str, "errorType");
        Intrinsics.checkParameterIsNotNull(str2, "previousStep");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to("errorType", str));
        if (!(map == null || (entrySet = map.entrySet()) == null)) {
            for (T t : entrySet) {
                mutableMapOf.put(t.getKey(), t.getValue());
            }
        }
        IBaseAnalytic.DefaultImpls.sendEvent$default(this, getModuleName() + "Fail", str2, mutableMapOf, null, 8, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    public void sendOpenEvent(@NotNull String str, @Nullable Map<String, String> map, @Nullable Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "previousStep");
        sendEvent(getModuleName() + "Open", str, map, map2);
    }
}
