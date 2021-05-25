package com.avito.android.advert_core.analytics.broker;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/analytics/broker/CreditBrokerFlowEventLogger;", "", "", "onChatOpened", "()V", "onFormCreditData", "onFormPassport", "onFormWork", "", "Lcom/avito/android/advert_core/analytics/broker/BankData;", "banksData", "onCreditComplete", "(Ljava/util/List;)V", "bankData", "onOfferClick", "(Lcom/avito/android/advert_core/analytics/broker/BankData;)V", "", "source", "requestId", "onOfferAccept", "(Lcom/avito/android/advert_core/analytics/broker/BankData;Ljava/lang/String;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface CreditBrokerFlowEventLogger {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onOfferAccept$default(CreditBrokerFlowEventLogger creditBrokerFlowEventLogger, BankData bankData, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                creditBrokerFlowEventLogger.onOfferAccept(bankData, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOfferAccept");
        }
    }

    void onChatOpened();

    void onCreditComplete(@NotNull List<BankData> list);

    void onFormCreditData();

    void onFormPassport();

    void onFormWork();

    void onOfferAccept(@Nullable BankData bankData, @Nullable String str, @Nullable String str2);

    void onOfferClick(@Nullable BankData bankData);
}
