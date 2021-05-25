package com.avito.android.advert_core.analytics.broker;

import a2.a.a.g.b.a.a;
import a2.a.a.g.b.a.b;
import a2.a.a.g.b.a.c;
import a2.a.a.g.b.a.d;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.GsonsKt;
import com.avito.android.util.Logs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/SravniWebAnalyticsEventLogger;", "", "", "type", "json", "", "logEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "getEventListener", "()Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "eventListener", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SravniWebAnalyticsEventLogger {
    public final Gson a = new Gson();
    @NotNull
    public final CreditBrokerFlowEventLogger b;

    @Inject
    public SravniWebAnalyticsEventLogger(@NotNull CreditBrokerFlowEventLogger creditBrokerFlowEventLogger) {
        Intrinsics.checkNotNullParameter(creditBrokerFlowEventLogger, "eventListener");
        this.b = creditBrokerFlowEventLogger;
    }

    @NotNull
    public final CreditBrokerFlowEventLogger getEventListener() {
        return this.b;
    }

    public final void logEvent(@NotNull String str, @NotNull String str2) {
        Type type;
        Type type2;
        Type type3;
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "json");
        try {
            switch (str.hashCode()) {
                case -1173159389:
                    if (str.equals(SravniWebAnalyticsEventLoggerKt.OFFER_ACCEPT_TYPE)) {
                        Gson gson = this.a;
                        Type type4 = new TypeToken<a>() { // from class: com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger$logEvent$$inlined$fromJson$3
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type4, "object : TypeToken<T>() {}.type");
                        if (!(type4 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type4)) {
                            type = GsonsKt.removeTypeWildcards(type4);
                        } else {
                            type = ((ParameterizedType) type4).getRawType();
                            Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                        }
                        Object fromJson = gson.fromJson(str2, type);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                        a aVar = (a) fromJson;
                        this.b.onOfferAccept(new BankData(-1, aVar.a().a()), "result", aVar.b());
                        return;
                    }
                    return;
                case -183950321:
                    if (str.equals("framePageCompleted")) {
                        Gson gson2 = this.a;
                        Type type5 = new TypeToken<d>() { // from class: com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger$logEvent$$inlined$fromJson$1
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type5, "object : TypeToken<T>() {}.type");
                        if (!(type5 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type5)) {
                            type2 = GsonsKt.removeTypeWildcards(type5);
                        } else {
                            type2 = ((ParameterizedType) type5).getRawType();
                            Intrinsics.checkNotNullExpressionValue(type2, "type.rawType");
                        }
                        Object fromJson2 = gson2.fromJson(str2, type2);
                        Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(json, typeToken<T>())");
                        int a3 = ((d) fromJson2).a();
                        if (a3 == 1) {
                            this.b.onFormCreditData();
                            return;
                        } else if (a3 == 2) {
                            this.b.onFormPassport();
                            return;
                        } else if (a3 == 3) {
                            this.b.onFormWork();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 103299:
                    if (str.equals("hid")) {
                        this.b.onChatOpened();
                        return;
                    }
                    return;
                case 1259194810:
                    if (str.equals(SravniWebAnalyticsEventLoggerKt.OFFERS_SHOWN_TYPE)) {
                        Gson gson3 = this.a;
                        Type type6 = new TypeToken<c>() { // from class: com.avito.android.advert_core.analytics.broker.SravniWebAnalyticsEventLogger$logEvent$$inlined$fromJson$2
                        }.getType();
                        Intrinsics.checkNotNullExpressionValue(type6, "object : TypeToken<T>() {}.type");
                        if (!(type6 instanceof ParameterizedType) || !GsonsKt.isWildcard((ParameterizedType) type6)) {
                            type3 = GsonsKt.removeTypeWildcards(type6);
                        } else {
                            type3 = ((ParameterizedType) type6).getRawType();
                            Intrinsics.checkNotNullExpressionValue(type3, "type.rawType");
                        }
                        Object fromJson3 = gson3.fromJson(str2, type3);
                        Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(json, typeToken<T>())");
                        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger = this.b;
                        List<b> a4 = ((c) fromJson3).a();
                        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(a4, 10));
                        Iterator<T> it = a4.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new BankData(-1, it.next().a()));
                        }
                        creditBrokerFlowEventLogger.onCreditComplete(arrayList);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            Logs.error(CreditPartnerFragment.SRAVNI_TAG, "Web event handling error", e);
        }
    }
}
