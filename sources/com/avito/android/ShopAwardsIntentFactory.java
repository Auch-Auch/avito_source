package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.SellerVerification;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/ShopAwardsIntentFactory;", "", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "", "arrowBackNavigation", "Landroid/content/Intent;", "showAwardsIntent", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;Z)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ShopAwardsIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent showAwardsIntent$default(ShopAwardsIntentFactory shopAwardsIntentFactory, SellerVerification.AwardsItem awardsItem, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return shopAwardsIntentFactory.showAwardsIntent(awardsItem, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAwardsIntent");
        }
    }

    @NotNull
    Intent showAwardsIntent(@NotNull SellerVerification.AwardsItem awardsItem, boolean z);
}
