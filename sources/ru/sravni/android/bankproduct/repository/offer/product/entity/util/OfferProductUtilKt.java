package ru.sravni.android.bankproduct.repository.offer.product.entity.util;

import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.product.entity.CardTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductTypeEnum;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductDisplaySettingsRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "", "productType", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "createDisplaySettings", "(Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "type", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;", "getProductType", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductTypeEnum;", "status", "Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "statusParse", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferProductUtilKt {
    @NotNull
    public static final OfferProductDisplaySettingsDomain createDisplaySettings(@NotNull OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, @NotNull String str) {
        CardTypeEnum cardTypeEnum;
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsRepo, "$this$createDisplaySettings");
        Intrinsics.checkParameterIsNotNull(str, "productType");
        ProductTypeEnum productType = getProductType(str);
        int titleColor = UtilFunctionsKt.getTitleColor(offerProductDisplaySettingsRepo.getBackgroundColor());
        String bankName = offerProductDisplaySettingsRepo.getBankName();
        String offerTitle = offerProductDisplaySettingsRepo.getOfferTitle();
        String detailTitle = offerProductDisplaySettingsRepo.getDetailTitle();
        String productName = offerProductDisplaySettingsRepo.getProductName();
        int titleColor2 = UtilFunctionsKt.getTitleColor(offerProductDisplaySettingsRepo.getFontColor());
        String iconTitle = offerProductDisplaySettingsRepo.getIconTitle();
        String cardType = offerProductDisplaySettingsRepo.getCardType();
        if (cardType != null) {
            int hashCode = cardType.hashCode();
            if (hashCode != -2038717326) {
                if (hashCode != 108118) {
                    if (hashCode == 3619905 && cardType.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_VISA)) {
                        cardTypeEnum = CardTypeEnum.VISA;
                        return new OfferProductDisplaySettingsDomain(titleColor, cardTypeEnum, titleColor2, iconTitle, productName, offerTitle, detailTitle, productType, bankName, offerProductDisplaySettingsRepo.getBankLogoUrlSVG());
                    }
                } else if (cardType.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_MIR)) {
                    cardTypeEnum = CardTypeEnum.MIR;
                    return new OfferProductDisplaySettingsDomain(titleColor, cardTypeEnum, titleColor2, iconTitle, productName, offerTitle, detailTitle, productType, bankName, offerProductDisplaySettingsRepo.getBankLogoUrlSVG());
                }
            } else if (cardType.equals("mastercard")) {
                cardTypeEnum = CardTypeEnum.MASTER_CARD;
                return new OfferProductDisplaySettingsDomain(titleColor, cardTypeEnum, titleColor2, iconTitle, productName, offerTitle, detailTitle, productType, bankName, offerProductDisplaySettingsRepo.getBankLogoUrlSVG());
            }
        }
        cardTypeEnum = CardTypeEnum.UNKNOWN;
        return new OfferProductDisplaySettingsDomain(titleColor, cardTypeEnum, titleColor2, iconTitle, productName, offerTitle, detailTitle, productType, bankName, offerProductDisplaySettingsRepo.getBankLogoUrlSVG());
    }

    @NotNull
    public static final ProductTypeEnum getProductType(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        switch (str.hashCode()) {
            case -1626067286:
                if (str.equals("creditpolling")) {
                    return ProductTypeEnum.CREDIT_POLLING;
                }
                break;
            case -1352291591:
                if (str.equals(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT)) {
                    return ProductTypeEnum.CREDIT;
                }
                break;
            case -814364995:
                if (str.equals("microcredit")) {
                    return ProductTypeEnum.MICRO_CREDIT;
                }
                break;
            case -563871351:
                if (str.equals("creditcard")) {
                    return ProductTypeEnum.CREDIT_CARD;
                }
                break;
            case 108022:
                if (str.equals("mfo")) {
                    return ProductTypeEnum.MICRO_CREDIT;
                }
                break;
            case 1242715674:
                if (str.equals("creditcardpolling")) {
                    return ProductTypeEnum.CREDIT_CARD_POLLING;
                }
                break;
        }
        return ProductTypeEnum.UNKNOWN;
    }

    @Nullable
    public static final ProductStatusEnum statusParse(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -2146525273:
                if (str.equals("accepted")) {
                    return ProductStatusEnum.ACCEPTED;
                }
                break;
            case -1734042410:
                if (str.equals("waitingpolling")) {
                    return ProductStatusEnum.WAITING_POLLING;
                }
                break;
            case -905962969:
                if (str.equals("sended")) {
                    return ProductStatusEnum.SENDED;
                }
                break;
            case 108960:
                if (str.equals(AppSettingsData.STATUS_NEW)) {
                    return ProductStatusEnum.NEW;
                }
                break;
            case 568196142:
                if (str.equals("declined")) {
                    return ProductStatusEnum.DECLINED;
                }
                break;
            case 1116313165:
                if (str.equals("waiting")) {
                    return ProductStatusEnum.WAITING;
                }
                break;
        }
        return ProductStatusEnum.UNKNOWN;
    }
}
