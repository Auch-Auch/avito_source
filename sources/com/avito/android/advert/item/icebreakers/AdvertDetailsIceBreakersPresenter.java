package com.avito.android.advert.item.icebreakers;

import com.avito.android.advert.item.AdvertDetailsRouter;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersView;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert/item/AdvertDetailsRouter;)V", "detachRouter", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsIceBreakersPresenter extends ItemPresenter<AdvertDetailsIceBreakersView, AdvertDetailsIceBreakersItem> {
    void attachRouter(@NotNull AdvertDetailsRouter advertDetailsRouter);

    void detachRouter();
}
