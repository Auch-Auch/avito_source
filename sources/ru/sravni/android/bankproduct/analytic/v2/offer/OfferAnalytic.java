package ru.sravni.android.bankproduct.analytic.v2.offer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b-\u0010.Jw\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u001a\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JM\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015JW\u0010\u0017\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJX\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u001dH\u0001¢\u0006\u0004\b \u0010!J8\u0010\"\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0001¢\u0006\u0004\b\"\u0010#JN\u0010$\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u001c\b\u0002\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u001dH\u0001¢\u0006\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/offer/OfferAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", AnalyticFieldsName.searchId, AnalyticFieldsName.productName, "", AnalyticFieldsName.offersCount, "", AnalyticFieldsName.organizationName, "Lkotlin/Pair;", AnalyticFieldsName.offerName, AnalyticFieldsName.orderId, "", AnalyticFieldsName.route, "isPush", "previousStep", "", "offerShow", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "offerOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", AnalyticFieldsName.brokerSendPoint, "offerSend", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "errorType", "offerFail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "eventId", "", "addedParams", "massiveParams", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sendOpenEvent", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", "getModuleName", "()Ljava/lang/String;", "moduleName", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferAnalytic implements IOfferAnalytic, IBaseAnalytic {
    public final IAnalyticEventLogger a;
    public final /* synthetic */ BaseAnalytic b;

    public OfferAnalytic(@NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        this.b = new BaseAnalytic(BaseAnalyticKt.ANALYTIC_MODULE_OFFER, iAnalyticEventLogger);
        this.a = iAnalyticEventLogger;
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic
    @NotNull
    public String getModuleName() {
        return this.b.getModuleName();
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic
    public void offerFail(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool, @Nullable Boolean bool2) {
        a.a1(str, "errorType", str2, AnalyticFieldsName.productName, str3, "previousStep");
        Map<String, String> mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.productName, str2));
        if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(bool2.booleanValue()));
        }
        if (bool != null) {
            mutableMapOf.put(AnalyticFieldsName.route, String.valueOf(bool.booleanValue()));
        }
        sendFailEvent(str, str3, mutableMapOf);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic
    public void offerOpen(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.searchId);
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(str5, "previousStep");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.searchId, str), TuplesKt.to(AnalyticFieldsName.organizationName, str3), TuplesKt.to(AnalyticFieldsName.productName, str2));
        if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(bool2.booleanValue()));
        }
        if (bool != null) {
            mutableMapOf.put(AnalyticFieldsName.route, String.valueOf(bool.booleanValue()));
        }
        if (str4 != null) {
            mutableMapOf.put(AnalyticFieldsName.offerName, str4);
        }
        IBaseAnalytic.DefaultImpls.sendOpenEvent$default(this, str5, mutableMapOf, null, 4, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic
    public void offerSend(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str6) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.orderId);
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(str3, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(str5, "previousStep");
        Map mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.orderId, str), TuplesKt.to(AnalyticFieldsName.organizationName, str3), TuplesKt.to(AnalyticFieldsName.productName, str2));
        if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(bool2.booleanValue()));
        }
        if (bool != null) {
            mutableMapOf.put(AnalyticFieldsName.route, String.valueOf(bool.booleanValue()));
        }
        if (str4 != null) {
            mutableMapOf.put(AnalyticFieldsName.offerName, str4);
        }
        if (str6 != null) {
            mutableMapOf.put(AnalyticFieldsName.brokerSendPoint, str6);
        }
        IBaseAnalytic.DefaultImpls.sendEvent$default(this, getModuleName() + BaseAnalyticKt.ANALYTIC_ACTION_SEND, str5, mutableMapOf, null, 8, null);
    }

    @Override // ru.sravni.android.bankproduct.analytic.v2.offer.IOfferAnalytic
    public void offerShow(@NotNull String str, @NotNull String str2, int i, @NotNull List<String> list, @Nullable List<Pair<String, String>> list2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.searchId);
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(list, AnalyticFieldsName.organizationName);
        Intrinsics.checkParameterIsNotNull(str4, "previousStep");
        Map<String, String> mutableMapOf = r.mutableMapOf(TuplesKt.to(AnalyticFieldsName.searchId, str), TuplesKt.to(AnalyticFieldsName.offersCount, String.valueOf(i)), TuplesKt.to(AnalyticFieldsName.productName, str2));
        if (bool != null) {
            mutableMapOf.put(AnalyticFieldsName.route, String.valueOf(bool.booleanValue()));
        }
        if (Intrinsics.areEqual(bool2, Boolean.TRUE)) {
            mutableMapOf.put("push", String.valueOf(bool2.booleanValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            for (T t : list2) {
                arrayList.add(((String) t.getFirst()) + "|" + ((String) t.getSecond()));
            }
            if (!arrayList.isEmpty()) {
                linkedHashMap.put(AnalyticFieldsName.offerName, arrayList);
            }
        }
        if (true ^ list.isEmpty()) {
            linkedHashMap.put(AnalyticFieldsName.organizationName, list);
        }
        sendEvent(getModuleName() + BaseAnalyticKt.ANALYTIC_ACTION_SHOW, str4, mutableMapOf, linkedHashMap);
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
