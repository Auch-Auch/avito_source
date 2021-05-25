package com.avito.android.advert_core.analytics.broker;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000f\u0010\u0005J0\u0010\u0014\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/SravniEventTrackerImpl;", "Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "", Tracker.Events.CREATIVE_START, "()V", "finish", "onChatOpened", "", "Lcom/avito/android/advert_core/analytics/broker/BankData;", "banksData", "onCreditComplete", "(Ljava/util/List;)V", "onFormCreditData", "onFormPassport", "onFormWork", "bankData", "", "source", "requestId", "onOfferAccept", "(Lcom/avito/android/advert_core/analytics/broker/BankData;Ljava/lang/String;Ljava/lang/String;)V", "onOfferClick", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)V", "Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "sravniEventLogger", "creditBrokerFlowEventLogger", "<init>", "(Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SravniEventTrackerImpl implements SravniEventTracker, CreditBrokerFlowEventLogger {
    public final SravniAnalyticsEventLogger a;
    public final /* synthetic */ CreditBrokerFlowEventLogger b;

    @Inject
    public SravniEventTrackerImpl(@NotNull SravniAnalyticsEventLogger sravniAnalyticsEventLogger, @NotNull CreditBrokerFlowEventLogger creditBrokerFlowEventLogger) {
        Intrinsics.checkNotNullParameter(sravniAnalyticsEventLogger, "sravniEventLogger");
        Intrinsics.checkNotNullParameter(creditBrokerFlowEventLogger, "creditBrokerFlowEventLogger");
        this.b = creditBrokerFlowEventLogger;
        this.a = sravniAnalyticsEventLogger;
    }

    @Override // com.avito.android.advert_core.analytics.broker.SravniEventTracker
    public void finish() {
        this.a.clear();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onChatOpened() {
        this.b.onChatOpened();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onCreditComplete(@NotNull List<BankData> list) {
        Intrinsics.checkNotNullParameter(list, "banksData");
        this.b.onCreditComplete(list);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormCreditData() {
        this.b.onFormCreditData();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormPassport() {
        this.b.onFormPassport();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onFormWork() {
        this.b.onFormWork();
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferAccept(@Nullable BankData bankData, @Nullable String str, @Nullable String str2) {
        this.b.onOfferAccept(bankData, str, str2);
    }

    @Override // com.avito.android.advert_core.analytics.broker.CreditBrokerFlowEventLogger
    public void onOfferClick(@Nullable BankData bankData) {
        this.b.onOfferClick(bankData);
    }

    @Override // com.avito.android.advert_core.analytics.broker.SravniEventTracker
    public void start() {
        this.a.setOnFlowEventListener(this);
    }
}
