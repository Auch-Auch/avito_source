package com.avito.android.advert.item.guide;

import android.net.Uri;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\fJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideView;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideItem;", "Lcom/avito/android/advert/item/guide/OnGuideLinkClickListener;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;)V", "detachRouter", "()V", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsGuidePresenter extends ItemPresenter<AdvertDetailsGuideView, AdvertDetailsGuideItem>, OnGuideLinkClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuidePresenter$Router;", "", "Landroid/net/Uri;", "url", "", "openGuideLink", "(Landroid/net/Uri;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void openGuideLink(@NotNull Uri uri);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();
}
