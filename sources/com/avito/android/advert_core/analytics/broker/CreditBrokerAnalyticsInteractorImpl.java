package com.avito.android.advert_core.analytics.broker;

import com.avito.android.advert_core.analytics.broker.events.CreditCalculatorLinkClickEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditCalculatorRenderEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditCalculatorSubmitEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditCalculatorValueChangedEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditCalculatorViewEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditChatOpenedEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditFormCompleteEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditFormPassportEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditFormPrimaryDataEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditFormWorkEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditOfferAcceptEvent;
import com.avito.android.advert_core.analytics.broker.events.CreditOfferClickEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.UUIDRandomKeyProvider;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0001\u00100\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u001d\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001d\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010/\u001a\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractorImpl;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "", "sendCreditCalculatorRender", "()V", "sendCreditCalculatorView", "sendCreditCalculatorValueChanged", "", "amount", "payment", FirebaseAnalytics.Param.TERM, "sendCreditCalculatorSubmit", "(III)V", "sendCreditCalculatorLinkClick", "onChatOpened", "onFormCreditData", "onFormPassport", "onFormWork", "", "Lcom/avito/android/advert_core/analytics/broker/BankData;", "banksData", "onCreditComplete", "(Ljava/util/List;)V", "bankData", "onOfferClick", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)V", "", "source", "requestId", "onOfferAccept", "(Lcom/avito/android/advert_core/analytics/broker/BankData;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "c", "Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "getCalculatorType", "()Lcom/avito/android/advert_core/analytics/broker/CalculatorType;", "setCalculatorType", "(Lcom/avito/android/advert_core/analytics/broker/CalculatorType;)V", "calculatorType", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.SEND_ABUSE, "getSession", "()Ljava/lang/String;", SessionContract.SESSION, "", AuthSource.BOOKING_ORDER, "Z", "useCalcSent", "Lcom/avito/android/util/UUIDRandomKeyProvider;", "uuidProvider", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/UUIDRandomKeyProvider;Lcom/avito/android/util/Kundle;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBrokerAnalyticsInteractorImpl implements CreditBrokerAnalyticsInteractor {
    @NotNull
    public final String a;
    public boolean b;
    @Nullable
    public CalculatorType c;
    public final String d;
    public final Analytics e;

    @Inject
    public CreditBrokerAnalyticsInteractorImpl(@AdvertId @NotNull String str, @NotNull Analytics analytics, @NotNull UUIDRandomKeyProvider uUIDRandomKeyProvider, @BrokerAnalyticsState @Nullable Kundle kundle) {
        String generateKey;
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(uUIDRandomKeyProvider, "uuidProvider");
        this.d = str;
        this.e = analytics;
        this.a = (kundle == null || (generateKey = kundle.getString(CreditBrokerAnalyticsInteractorKt.KEY_SESSION)) == null) ? uUIDRandomKeyProvider.generateKey() : generateKey;
        this.b = (kundle == null || (bool = kundle.getBoolean("key_use_calc_sent")) == null) ? false : bool.booleanValue();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @Nullable
    public CalculatorType getCalculatorType() {
        return this.c;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider
    @NotNull
    public String getSession() {
        return this.a;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onChatOpened() {
        this.e.track(new CreditChatOpenedEvent(this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onCreditComplete(@NotNull List<BankData> list) {
        Intrinsics.checkNotNullParameter(list, "banksData");
        this.e.track(new CreditFormCompleteEvent(this.d, getSession(), list));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormCreditData() {
        this.e.track(new CreditFormPrimaryDataEvent(this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormPassport() {
        this.e.track(new CreditFormPassportEvent(this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormWork() {
        this.e.track(new CreditFormWorkEvent(this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferAccept(@Nullable BankData bankData, @Nullable String str, @Nullable String str2) {
        this.e.track(new CreditOfferAcceptEvent(this.d, getSession(), bankData, str, str2));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferClick(@Nullable BankData bankData) {
        this.e.track(new CreditOfferClickEvent(this.d, getSession(), bankData));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putString(CreditBrokerAnalyticsInteractorKt.KEY_SESSION, getSession());
        kundle.putBoolean("key_use_calc_sent", Boolean.valueOf(this.b));
        return kundle;
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorLinkClick() {
        Analytics analytics = this.e;
        CalculatorType calculatorType = getCalculatorType();
        analytics.track(new CreditCalculatorLinkClickEvent(calculatorType != null ? calculatorType.getValue() : null, this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorRender() {
        Analytics analytics = this.e;
        CalculatorType calculatorType = getCalculatorType();
        analytics.track(new CreditCalculatorRenderEvent(calculatorType != null ? calculatorType.getValue() : null, this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorSubmit(int i, int i2, int i3) {
        Analytics analytics = this.e;
        CalculatorType calculatorType = getCalculatorType();
        analytics.track(new CreditCalculatorSubmitEvent(calculatorType != null ? calculatorType.getValue() : null, this.d, getSession(), i, i2, i3));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorValueChanged() {
        if (!this.b) {
            Analytics analytics = this.e;
            CalculatorType calculatorType = getCalculatorType();
            analytics.track(new CreditCalculatorValueChangedEvent(calculatorType != null ? calculatorType.getValue() : null, this.d, getSession()));
            this.b = true;
        }
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void sendCreditCalculatorView() {
        Analytics analytics = this.e;
        CalculatorType calculatorType = getCalculatorType();
        analytics.track(new CreditCalculatorViewEvent(calculatorType != null ? calculatorType.getValue() : null, this.d, getSession()));
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor
    public void setCalculatorType(@Nullable CalculatorType calculatorType) {
        this.c = calculatorType;
    }
}
