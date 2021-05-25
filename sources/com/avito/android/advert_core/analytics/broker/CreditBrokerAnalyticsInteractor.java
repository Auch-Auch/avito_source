package com.avito.android.advert_core.analytics.broker;

import com.avito.android.util.Kundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J'\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "", "sendCreditCalculatorRender", "()V", "sendCreditCalculatorView", "sendCreditCalculatorValueChanged", "", "amount", "payment", FirebaseAnalytics.Param.TERM, "sendCreditCalculatorSubmit", "(III)V", "sendCreditCalculatorLinkClick", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "getCalculatorType", "()Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "setCalculatorType", "(Lcom/avito/android/advert_core/analytics/broker/CalculatorType;)V", "calculatorType", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CreditBrokerAnalyticsInteractor extends CreditBrokerFlowEventLogger, CreditBrokerSessionProvider {
    @Nullable
    CalculatorType getCalculatorType();

    @NotNull
    Kundle onSaveState();

    void sendCreditCalculatorLinkClick();

    void sendCreditCalculatorRender();

    void sendCreditCalculatorSubmit(int i, int i2, int i3);

    void sendCreditCalculatorValueChanged();

    void sendCreditCalculatorView();

    void setCalculatorType(@Nullable CalculatorType calculatorType);
}
