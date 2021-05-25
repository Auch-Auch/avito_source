package com.avito.android.advert.item.safedeal.button.legacy;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonPresenter;", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView;", "view", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView;Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonItem;I)V", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safedealPresenter", "<init>", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealLegacyButtonPresenterImpl implements AdvertDetailsSafeDealLegacyButtonPresenter {
    public final AdvertSafeDealPresenter a;

    @Inject
    public AdvertDetailsSafeDealLegacyButtonPresenterImpl(@NotNull AdvertSafeDealPresenter advertSafeDealPresenter) {
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "safedealPresenter");
        this.a = advertSafeDealPresenter;
    }

    public void bindView(@NotNull AdvertDetailsSafeDealLegacyButtonView advertDetailsSafeDealLegacyButtonView, @NotNull AdvertDetailsSafeDealLegacyButtonItem advertDetailsSafeDealLegacyButtonItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealLegacyButtonView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealLegacyButtonItem, "item");
        this.a.setCategoryId(advertDetailsSafeDealLegacyButtonItem.getCategoryId());
        this.a.setUserHashId(advertDetailsSafeDealLegacyButtonItem.getUserHashId());
        this.a.setIsMarketplace(advertDetailsSafeDealLegacyButtonItem.isMarketplace());
        advertDetailsSafeDealLegacyButtonView.showLegacyButton(advertDetailsSafeDealLegacyButtonItem.getActions(), this.a);
    }
}
