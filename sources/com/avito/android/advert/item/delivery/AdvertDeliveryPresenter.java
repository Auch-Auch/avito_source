package com.avito.android.advert.item.delivery;

import android.net.Uri;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsView;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;)V", "detachRouter", "()V", "", "categoryId", "setCategoryId", "(Ljava/lang/String;)V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDeliveryPresenter extends AdvertDetailsDeliveryActionsView.Router {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDeliveryPresenter$Router;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "followDeliveryExternalLink", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeliveryDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        boolean followDeliveryDeepLink(@NotNull DeepLink deepLink);

        void followDeliveryExternalLink(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void setCategoryId(@Nullable String str);
}
