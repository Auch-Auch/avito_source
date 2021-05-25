package com.avito.android.advert.item.dfpcreditinfo;

import a2.g.r.g;
import android.content.Context;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserItem;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert.item.dfpcreditinfo.calculator.Type;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.advert_core.analytics.broker.SravniEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.util.LoadingState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\bM\u0010NJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010 \u001a\u00020\b2\u0014\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u0018R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenterImpl;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoPresenter;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;I)V", "", "value", "updateLegalInfoDialog", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "creditInfo", "showCreditInfo", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)V", "clearFocus", "()V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "setPhoneChooserListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phonesState", "updatePhoneChooser", "(Lcom/avito/android/util/LoadingState;)V", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "router", "setRouter", "(Lcom/avito/android/advert_core/advert/AdvertCoreRouter;)V", "Landroid/content/Context;", "context", "phone", "openSravni", "(Landroid/content/Context;Ljava/lang/String;)V", "onResume", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "i", "Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "sravniConfiguration", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "phoneChoserListener", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "h", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "c", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;", "dfpButton", "d", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoItem;", "creditItem", "Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;", "j", "Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;", "sravniEventTracker", "e", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "dfpCreditListener", "", g.a, "Z", "isShowTopDivider", "f", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "dfpCreditInfo", "<init>", "(Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;Lcom/avito/android/advert_core/analytics/broker/SravniEventTracker;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsCreditInfoPresenterImpl implements AdvertDetailsCreditInfoPresenter {
    public PhoneChooserView.Listener a;
    public AdvertCoreRouter b;
    public AdvertDetailsCreditInfoView c;
    public AdvertDetailsCreditInfoItem d;
    public DfpCreditButton.Listener e;
    public DfpCreditInfo f;
    public boolean g = true;
    public final CreditInfoResourcesProvider h;
    public final SravniNetworkConfiguration i;
    public final SravniEventTracker j;

    @Inject
    public AdvertDetailsCreditInfoPresenterImpl(@NotNull CreditInfoResourcesProvider creditInfoResourcesProvider, @NotNull SravniNetworkConfiguration sravniNetworkConfiguration, @NotNull SravniEventTracker sravniEventTracker) {
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(sravniNetworkConfiguration, "sravniConfiguration");
        Intrinsics.checkNotNullParameter(sravniEventTracker, "sravniEventTracker");
        this.h = creditInfoResourcesProvider;
        this.i = sravniNetworkConfiguration;
        this.j = sravniEventTracker;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void clearFocus() {
        AdvertDetailsCreditInfoView advertDetailsCreditInfoView = this.c;
        if (advertDetailsCreditInfoView != null) {
            advertDetailsCreditInfoView.clearFocus();
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void onResume() {
        this.j.finish();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void openSravni(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "phone");
        this.j.start();
        context.startActivity(SravniChatActivity.Companion.getIntentToStartActivity(context, this.i, false, str));
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void setListener(@NotNull DfpCreditButton.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e = listener;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void setPhoneChooserListener(@NotNull PhoneChooserView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = listener;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void setRouter(@NotNull AdvertCoreRouter advertCoreRouter) {
        Intrinsics.checkNotNullParameter(advertCoreRouter, "router");
        this.b = advertCoreRouter;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void showCreditInfo(@NotNull DfpCreditInfo dfpCreditInfo) {
        AdvertDetailsCreditInfoView advertDetailsCreditInfoView;
        Type type;
        Intrinsics.checkNotNullParameter(dfpCreditInfo, "creditInfo");
        AdvertDetailsCreditInfoItem advertDetailsCreditInfoItem = this.d;
        if (advertDetailsCreditInfoItem != null) {
            advertDetailsCreditInfoItem.setCreditInfo(dfpCreditInfo);
        }
        this.f = dfpCreditInfo;
        if (dfpCreditInfo instanceof DfpCreditInfo.Web) {
            AdvertDetailsCreditInfoView advertDetailsCreditInfoView2 = this.c;
            if (advertDetailsCreditInfoView2 != null) {
                advertDetailsCreditInfoView2.showAdContent(this.g);
                DfpCreditInfo.Web web = (DfpCreditInfo.Web) dfpCreditInfo;
                if (web.getTitleWithPrice() != null) {
                    advertDetailsCreditInfoView2.setTitleWithPrice(web.getTitleWithPrice(), web.getText());
                } else {
                    advertDetailsCreditInfoView2.setTitle(web.getTitle(), false);
                    advertDetailsCreditInfoView2.setText(web.getText(), false);
                }
                advertDetailsCreditInfoView2.setIcon(web.getImageUri());
                DfpCreditButton.Listener listener = this.e;
                if (listener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dfpCreditListener");
                }
                advertDetailsCreditInfoView2.setListener(listener);
                web.getNativeCustomTemplateAd().recordImpression();
            }
        } else if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator) {
            AdvertDetailsCreditInfoView advertDetailsCreditInfoView3 = this.c;
            if (advertDetailsCreditInfoView3 != null) {
                advertDetailsCreditInfoView3.showAdContent(this.g);
                DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) dfpCreditInfo;
                String titleWithPrice = creditCalculator.getTitleWithPrice();
                if (titleWithPrice != null) {
                    advertDetailsCreditInfoView3.setTitle(titleWithPrice, true);
                } else {
                    advertDetailsCreditInfoView3.setTitle(creditCalculator.getTitle(), true);
                }
                advertDetailsCreditInfoView3.setText(creditCalculator.getText(), true);
                advertDetailsCreditInfoView3.setIcon(null);
                DfpCreditButton.Listener listener2 = this.e;
                if (listener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dfpCreditListener");
                }
                advertDetailsCreditInfoView3.setListener(listener2);
                String currency = this.h.getCurrency(creditCalculator.getLoanFormatted());
                String payment = this.h.getPayment(creditCalculator.getMonthlyPaymentFormatted());
                String currency2 = this.h.getCurrency(creditCalculator.getInitialPaymentFormatted());
                String percent = this.h.getPercent(creditCalculator.getPercentFormatted());
                if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator.Sravni) {
                    type = Type.SRAVNI;
                } else if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator.Tinkoff) {
                    type = Type.TINKOFF;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                advertDetailsCreditInfoView3.initializeCalculator(type);
                advertDetailsCreditInfoView3.showButton(creditCalculator.getButtonText(), creditCalculator.getPrivacyText(), creditCalculator.getPrivacyLink());
                advertDetailsCreditInfoView3.setCalculatorData(TuplesKt.to(Integer.valueOf(creditCalculator.getInitialPayment()), currency2), creditCalculator.getPaymentTerm(), creditCalculator.getTerms(), creditCalculator.getInputHint(), TuplesKt.to(Integer.valueOf(creditCalculator.getLoan()), currency), payment, percent);
                creditCalculator.getNativeCustomTemplateAd().recordImpression();
            }
        } else if (dfpCreditInfo instanceof DfpCreditInfo.Stub) {
            AdvertDetailsCreditInfoView advertDetailsCreditInfoView4 = this.c;
            if (advertDetailsCreditInfoView4 != null) {
                advertDetailsCreditInfoView4.showStubContent();
            }
        } else if ((dfpCreditInfo instanceof DfpCreditInfo.Empty) && (advertDetailsCreditInfoView = this.c) != null) {
            advertDetailsCreditInfoView.hideContent();
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void updateLegalInfoDialog(@Nullable String str) {
        AdvertDetailsCreditInfoView advertDetailsCreditInfoView;
        DfpCreditInfo dfpCreditInfo = this.f;
        if (dfpCreditInfo instanceof DfpCreditInfo.Web) {
            if (str != null) {
                AdvertDetailsCreditInfoView advertDetailsCreditInfoView2 = this.c;
                if (advertDetailsCreditInfoView2 != null) {
                    advertDetailsCreditInfoView2.showLegalInfoDialog(str);
                    return;
                }
                return;
            }
            AdvertDetailsCreditInfoView advertDetailsCreditInfoView3 = this.c;
            if (advertDetailsCreditInfoView3 != null) {
                advertDetailsCreditInfoView3.dismissDialog(false);
            }
        } else if ((dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator) && (advertDetailsCreditInfoView = this.c) != null) {
            advertDetailsCreditInfoView.showBrokerInfoSheetIfNeeded(str);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter
    public void updatePhoneChooser(@Nullable LoadingState<? super List<Phone>> loadingState) {
        List<? extends PhoneChooserItem> list;
        AdvertDetailsCreditInfoView advertDetailsCreditInfoView = this.c;
        if (advertDetailsCreditInfoView != null) {
            if (loadingState == null) {
                list = null;
            } else if (loadingState instanceof LoadingState.Loading) {
                list = d.listOf(PhoneChooserItem.Loading.INSTANCE);
            } else if (loadingState instanceof LoadingState.Error) {
                list = d.listOf(PhoneChooserItem.Error.INSTANCE);
            } else if (loadingState instanceof LoadingState.Loaded) {
                Iterable<Phone> iterable = (Iterable) ((LoadingState.Loaded) loadingState).getData();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(iterable, 10));
                for (Phone phone : iterable) {
                    arrayList.add(new PhoneChooserItem.Phone(phone.getPhone()));
                }
                list = arrayList;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            advertDetailsCreditInfoView.updatePhoneChooser(list);
        }
    }

    public void bindView(@NotNull AdvertDetailsCreditInfoView advertDetailsCreditInfoView, @NotNull AdvertDetailsCreditInfoItem advertDetailsCreditInfoItem, int i2) {
        Intrinsics.checkNotNullParameter(advertDetailsCreditInfoView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsCreditInfoItem, "item");
        this.g = advertDetailsCreditInfoItem.getShowDivider();
        this.c = advertDetailsCreditInfoView;
        PhoneChooserView.Listener listener = this.a;
        if (listener != null) {
            advertDetailsCreditInfoView.setPhoneChooserListener(listener);
        }
        this.d = advertDetailsCreditInfoItem;
        DfpCreditInfo dfpCreditInfo = this.f;
        if (dfpCreditInfo != null) {
            showCreditInfo(dfpCreditInfo);
        }
    }
}
