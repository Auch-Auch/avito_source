package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerRouter;", "", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;", VKApiUserFull.RelativeType.PARTNER, "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "brokerSession", "", "showCreditPartnerScreen", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;Landroid/net/Uri;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface CreditPartnerRouter {
    void showCreditPartnerScreen(@NotNull CreditPartner creditPartner, @NotNull Uri uri, @NotNull String str);
}
