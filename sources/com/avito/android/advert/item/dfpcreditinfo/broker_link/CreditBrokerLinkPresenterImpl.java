package com.avito.android.advert.item.dfpcreditinfo.broker_link;

import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenterImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkView;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkView;Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkItem;I)V", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkPresenter$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBrokerLinkPresenterImpl implements CreditBrokerLinkPresenter {
    public final CreditBrokerLinkPresenter.Listener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CreditBrokerLinkPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CreditBrokerLinkPresenterImpl creditBrokerLinkPresenterImpl) {
            super(0);
            this.a = creditBrokerLinkPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onCreditBrokerLinkClick();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CreditBrokerLinkPresenterImpl(@NotNull CreditBrokerLinkPresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = listener;
    }

    public void bindView(@NotNull CreditBrokerLinkView creditBrokerLinkView, @NotNull CreditBrokerLinkItem creditBrokerLinkItem, int i) {
        Intrinsics.checkNotNullParameter(creditBrokerLinkView, "view");
        Intrinsics.checkNotNullParameter(creditBrokerLinkItem, "item");
        creditBrokerLinkView.setPayment(creditBrokerLinkItem.getPayment());
        creditBrokerLinkView.setTinkoffIcon(creditBrokerLinkItem.getLinkType() == DfpCreditInfo.CreditCalculator.CalculatorLinkType.TINKOFF);
        creditBrokerLinkView.setOnClickListener(new a(this));
    }
}
