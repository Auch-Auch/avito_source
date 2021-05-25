package com.avito.android.advert.item.domoteka.conveyor;

import android.net.Uri;
import com.avito.android.advert.item.teaser.AdvertDetailsTeaserView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eJ\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/teaser/AdvertDetailsTeaserView;", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserItem;", "", "showFlatNumberRequestDialog", "()V", "detachView", "Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "getRouter", "()Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "setRouter", "(Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;)V", "router", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDomotekaTeaserPresenter extends ItemPresenter<AdvertDetailsTeaserView, AdvertDetailsDomotekaTeaserItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/domoteka/conveyor/AdvertDetailsDomotekaTeaserPresenter$Router;", "", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "openDomotekaReport", "(Landroid/net/Uri;)V", "loginForDomotekaFlatNumberRequest", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "followDomotekaOpenChatDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followDomotekaOpenChatDeeplink(@NotNull DeepLink deepLink);

        void loginForDomotekaFlatNumberRequest();

        void openDomotekaReport(@NotNull Uri uri);
    }

    void detachView();

    @Nullable
    Router getRouter();

    void setRouter(@Nullable Router router);

    void showFlatNumberRequestDialog();
}
