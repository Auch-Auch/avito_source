package com.avito.android.advert.item.shorttermrent;

import android.net.Uri;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentItem;", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;)V", "detachRouter", "()V", "Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentView$Listener;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "followUri", "(Landroid/net/Uri;)V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsShortTermRentPresenter extends ItemPresenter<AdvertDetailsShortTermRentView, AdvertDetailsShortTermRentItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/shorttermrent/AdvertDetailsShortTermRentPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followShortTermRentLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followShortTermRentLink(@NotNull DeepLink deepLink);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void followUri(@NotNull Uri uri);

    void setListener(@NotNull AdvertDetailsShortTermRentView.Listener listener);
}
