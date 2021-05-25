package com.avito.android.advert_core.analytics.broker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u001d\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001f\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004R\u001c\u0010&\u001a\u00020\u001c8\u0016@\u0016XD¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorNoOp;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "", "sendCreditCalculatorRender", "()V", "sendCreditCalculatorView", "sendCreditCalculatorValueChanged", "", "amount", "payment", FirebaseAnalytics.Param.TERM, "sendCreditCalculatorSubmit", "(III)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onChatOpened", "onFormCreditData", "onFormPassport", "onFormWork", "", "Lcom/avito/android/advert_core/analytics/broker/BankData;", "banksData", "onCreditComplete", "(Ljava/util/List;)V", "bankData", "onOfferClick", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)V", "", "source", "requestId", "onOfferAccept", "(Lcom/avito/android/advert_core/analytics/broker/BankData;Ljava/lang/String;Ljava/lang/String;)V", "sendCreditCalculatorLinkClick", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSession", "()Ljava/lang/String;", SessionContract.SESSION, "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "getCalculatorType", "()Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "setCalculatorType", "(Lcom/avito/android/advert_core/analytics/broker/CalculatorType;)V", "calculatorType", "<init>", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBrokerAnalyticsInteractorNoOp implements CreditBrokerAnalyticsInteractor {
    @Nullable
    public CalculatorType a;
    @NotNull
    public final String b = "";

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @Nullable
    public CalculatorType getCalculatorType() {
        return this.a;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider
    @NotNull
    public String getSession() {
        return this.b;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onChatOpened() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onCreditComplete(@NotNull List<BankData> list) {
        Intrinsics.checkNotNullParameter(list, "banksData");
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormCreditData() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormPassport() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormWork() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferAccept(@Nullable BankData bankData, @Nullable String str, @Nullable String str2) {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferClick(@Nullable BankData bankData) {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @NotNull
    public Kundle onSaveState() {
        return new Kundle();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorLinkClick() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorRender() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorSubmit(int i, int i2, int i3) {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorValueChanged() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorView() {
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void setCalculatorType(@Nullable CalculatorType calculatorType) {
        this.a = calculatorType;
    }
}
