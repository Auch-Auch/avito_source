package com.avito.android.developments_catalog.items.avitoOffers;

import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersPresenterImpl;", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersPresenter;", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersView;", "view", "Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersView;Lcom/avito/android/developments_catalog/items/avitoOffers/AvitoOffersItem;I)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "presenter", "<init>", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoOffersPresenterImpl implements AvitoOffersPresenter {
    public final DevelopmentsCatalogPresenter a;

    @Inject
    public AvitoOffersPresenterImpl(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        Intrinsics.checkNotNullParameter(developmentsCatalogPresenter, "presenter");
        this.a = developmentsCatalogPresenter;
    }

    public void bindView(@NotNull AvitoOffersView avitoOffersView, @NotNull AvitoOffersItem avitoOffersItem, int i) {
        Intrinsics.checkNotNullParameter(avitoOffersView, "view");
        Intrinsics.checkNotNullParameter(avitoOffersItem, "item");
        avitoOffersView.bindAvitoOffers(avitoOffersItem.getAvitoOffers(), this.a);
    }
}
