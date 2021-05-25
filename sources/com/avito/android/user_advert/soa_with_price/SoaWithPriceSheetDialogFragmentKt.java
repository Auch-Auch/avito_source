package com.avito.android.user_advert.soa_with_price;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;", "arguments", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceSheetDialogFragment;", "createSoaWithPriceSheetDialogFragment", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;)Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceSheetDialogFragment;", "user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class SoaWithPriceSheetDialogFragmentKt {
    @NotNull
    public static final SoaWithPriceSheetDialogFragment createSoaWithPriceSheetDialogFragment(@NotNull SoaWithPriceArguments soaWithPriceArguments) {
        Intrinsics.checkNotNullParameter(soaWithPriceArguments, "arguments");
        SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment = new SoaWithPriceSheetDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arguments", soaWithPriceArguments);
        soaWithPriceSheetDialogFragment.setArguments(bundle);
        return soaWithPriceSheetDialogFragment;
    }
}
