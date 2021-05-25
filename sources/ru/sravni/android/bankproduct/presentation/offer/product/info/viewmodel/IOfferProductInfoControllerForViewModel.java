package ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusNavInfo;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoAnalytic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H&¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0017H&¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/viewmodel/IOfferProductInfoControllerForViewModel;", "", "", "value", "", "setWaitingRetry", "(Z)V", "setWaitingSend", "", OkListener.KEY_EXCEPTION, "errorLogger", "(Ljava/lang/Throwable;)V", "errorServer", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "offerProductDetailDomain", "setValueFromProductInfo", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;)V", "", "url", AnalyticFieldsName.productName, "openWebView", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/Function1;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;", "processResponse", "sendRequestLegacy", "(Lkotlin/jvm/functions/Function1;)V", "sendRequest", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answerInfo", "setAnswerInfo", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "chatInfo", "restoreChat", "(Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;)V", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;", "navInfo", "openProductStatusFragment", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusNavInfo;)V", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "analyticInfo", "setAnalyticInfo", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;)V", "openOfferAnalytic", "()V", "offerProductStatusDomain", "sendOfferAnalytic", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductStatusDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferProductInfoControllerForViewModel {
    void errorLogger(@Nullable Throwable th);

    void errorServer(@Nullable Throwable th);

    void openOfferAnalytic();

    void openProductStatusFragment(@NotNull OfferProductStatusNavInfo offerProductStatusNavInfo);

    void openWebView(@Nullable String str, @NotNull String str2);

    void restoreChat(@NotNull ChatInfo chatInfo);

    void sendOfferAnalytic(@NotNull OfferProductStatusDomain offerProductStatusDomain);

    void sendRequest(@NotNull Function1<? super OfferProductStatusDomain, Unit> function1);

    void sendRequestLegacy(@NotNull Function1<? super OfferProductStatusDomain, Unit> function1);

    void setAnalyticInfo(@NotNull OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic);

    void setAnswerInfo(@NotNull AnswerInfoDomain answerInfoDomain);

    void setValueFromProductInfo(@NotNull OfferProductDetailDomain offerProductDetailDomain);

    void setWaitingRetry(boolean z);

    void setWaitingSend(boolean z);
}
