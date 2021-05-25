package com.avito.android.advert_core.analytics.broker;

import com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "event", "", "logEvent", "(Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;)V", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFlowEventListener", "(Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;)V", "clear", "()V", "Lcom/avito/android/advert_core/analytics/broker/BankData;", AuthSource.SEND_ABUSE, "(Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;)Lcom/avito/android/advert_core/analytics/broker/BankData;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "eventListener", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "banks", "<init>", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SravniAnalyticsEventLogger implements IAnalyticEventLogger {
    public CreditBrokerFlowEventLogger a;
    public List<String> b = CollectionsKt__CollectionsKt.emptyList();

    public SravniAnalyticsEventLogger() {
        LibKodeinProviderKt.setExternalAnalyticLogger(this);
    }

    public final BankData a(AnalyticEvent analyticEvent) {
        String str = analyticEvent.getParams().get(AnalyticFieldsName.organizationName);
        if (str != null) {
            return new BankData(this.b.indexOf(str) + 1, str);
        }
        return null;
    }

    public final void clear() {
        this.a = null;
        this.b = CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger
    public void logEvent(@NotNull AnalyticEvent analyticEvent) {
        String str;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger2;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger3;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger4;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger5;
        CreditBrokerFlowEventLogger creditBrokerFlowEventLogger6;
        Intrinsics.checkNotNullParameter(analyticEvent, "event");
        String id = analyticEvent.getId();
        switch (id.hashCode()) {
            case -1492138777:
                if (id.equals("productChat") && (str = analyticEvent.getParams().get(AnalyticFieldsName.step)) != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -1412476240) {
                        if (hashCode != -1006070924) {
                            if (hashCode == -313264082 && str.equals("Занятость и образование") && (creditBrokerFlowEventLogger3 = this.a) != null) {
                                creditBrokerFlowEventLogger3.onFormWork();
                                return;
                            }
                            return;
                        } else if (str.equals("Параметры кредита") && (creditBrokerFlowEventLogger2 = this.a) != null) {
                            creditBrokerFlowEventLogger2.onFormCreditData();
                            return;
                        } else {
                            return;
                        }
                    } else if (str.equals("Паспортные данные") && (creditBrokerFlowEventLogger = this.a) != null) {
                        creditBrokerFlowEventLogger.onFormPassport();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case -1491773479:
                if (id.equals("productOpen") && (creditBrokerFlowEventLogger4 = this.a) != null) {
                    creditBrokerFlowEventLogger4.onChatOpened();
                    return;
                }
                return;
            case 1944397510:
                if (id.equals("offerOpen") && (creditBrokerFlowEventLogger5 = this.a) != null) {
                    creditBrokerFlowEventLogger5.onOfferClick(a(analyticEvent));
                    return;
                }
                return;
            case 1944506372:
                if (id.equals("offerSend") && (creditBrokerFlowEventLogger6 = this.a) != null) {
                    CreditBrokerFlowEventLogger.DefaultImpls.onOfferAccept$default(creditBrokerFlowEventLogger6, a(analyticEvent), analyticEvent.getParams().get(AnalyticFieldsName.brokerSendPoint), null, 4, null);
                    return;
                }
                return;
            case 1944509305:
                if (id.equals("offerShow")) {
                    List<String> list = analyticEvent.getMassiveParams().get(AnalyticFieldsName.organizationName);
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    this.b = list;
                    CreditBrokerFlowEventLogger creditBrokerFlowEventLogger7 = this.a;
                    if (creditBrokerFlowEventLogger7 != null) {
                        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                        int i = 0;
                        for (T t : list) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            arrayList.add(new BankData(i2, t));
                            i = i2;
                        }
                        creditBrokerFlowEventLogger7.onCreditComplete(arrayList);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setOnFlowEventListener(@NotNull CreditBrokerFlowEventLogger creditBrokerFlowEventLogger) {
        Intrinsics.checkNotNullParameter(creditBrokerFlowEventLogger, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = creditBrokerFlowEventLogger;
    }
}
