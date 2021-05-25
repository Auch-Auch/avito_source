package com.avito.android.advert.item.delivery;

import android.net.Uri;
import androidx.annotation.StyleRes;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "delivery", "", "secondaryLabelStyle", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDelivery", "(Lcom/avito/android/remote/model/AdvertDeliveryC2C;ILcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;)V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDeliveryActionsView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsDeliveryActionsView advertDetailsDeliveryActionsView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsDeliveryActionsView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "isDeliveryButtonClicked", "", "followUri", "(Landroid/net/Uri;Z)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followUri(@NotNull Uri uri, boolean z);
    }

    void showDelivery(@NotNull AdvertDeliveryC2C advertDeliveryC2C, @StyleRes int i, @NotNull Router router);
}
