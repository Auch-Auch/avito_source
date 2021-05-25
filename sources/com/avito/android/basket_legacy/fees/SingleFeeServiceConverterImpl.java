package com.avito.android.basket_legacy.fees;

import com.avito.android.basket_legacy.utils.SingleFeeService;
import com.avito.android.remote.model.FeeParam;
import com.avito.android.remote.model.SingleFee;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverterImpl;", "Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;", "Lcom/avito/android/remote/model/SingleFee;", "singleFee", "Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "convert", "(Lcom/avito/android/remote/model/SingleFee;)Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class SingleFeeServiceConverterImpl implements SingleFeeServiceConverter {
    @Override // com.avito.android.basket_legacy.fees.SingleFeeServiceConverter
    @NotNull
    public SingleFeeService convert(@NotNull SingleFee singleFee) {
        String str;
        String str2;
        String name;
        String name2;
        Intrinsics.checkNotNullParameter(singleFee, "singleFee");
        long serviceId = singleFee.getServiceId();
        String paymentServiceId = singleFee.getPaymentServiceId();
        long price = (long) singleFee.getPrice();
        String priceDetails = singleFee.getPriceDetails();
        String description = singleFee.getDescription();
        String str3 = description != null ? description : "";
        FeeParam category = singleFee.getCategory();
        if (category == null || (name2 = category.getName()) == null) {
            str = "";
        } else {
            str = name2;
        }
        FeeParam location = singleFee.getLocation();
        if (location == null || (name = location.getName()) == null) {
            str2 = "";
        } else {
            str2 = name;
        }
        return new SingleFeeService(serviceId, paymentServiceId, price, priceDetails, str3, str, str2, singleFee.getIcon());
    }
}
