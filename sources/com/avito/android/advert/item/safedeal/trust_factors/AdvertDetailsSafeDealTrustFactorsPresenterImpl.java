package com.avito.android.advert.item.safedeal.trust_factors;

import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.remote.model.text.AttributedText;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenterImpl;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsPresenter;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView;", "view", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView;Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsItem;I)V", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "safedealPresenter", "<init>", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealTrustFactorsPresenterImpl implements AdvertDetailsSafeDealTrustFactorsPresenter {
    public final AdvertSafeDealPresenter a;

    @Inject
    public AdvertDetailsSafeDealTrustFactorsPresenterImpl(@NotNull AdvertSafeDealPresenter advertSafeDealPresenter) {
        Intrinsics.checkNotNullParameter(advertSafeDealPresenter, "safedealPresenter");
        this.a = advertSafeDealPresenter;
    }

    public void bindView(@NotNull AdvertDetailsSafeDealTrustFactorsView advertDetailsSafeDealTrustFactorsView, @NotNull AdvertDetailsSafeDealTrustFactorsItem advertDetailsSafeDealTrustFactorsItem, int i) {
        List<SafeDeal.About.ListComponent> listComponents;
        AttributedText title;
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealTrustFactorsView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsSafeDealTrustFactorsItem, "item");
        SafeDeal.About about = advertDetailsSafeDealTrustFactorsItem.getSafeDeal().getAbout();
        if (!(about == null || (listComponents = about.getListComponents()) == null)) {
            for (T t : listComponents) {
                if ((t instanceof SafeDeal.About.ListComponent.ListItem) && (title = t.getTitle()) != null) {
                    title.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this, advertDetailsSafeDealTrustFactorsItem) { // from class: com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenterImpl$bindView$$inlined$let$lambda$1
                        public final /* synthetic */ AdvertDetailsSafeDealTrustFactorsPresenterImpl a;
                        public final /* synthetic */ AdvertDetailsSafeDealTrustFactorsItem b;

                        {
                            this.a = r1;
                            this.b = r2;
                        }

                        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                        public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                            this.a.a.followTrustFactorsDeepLink(deepLink, this.b.getSafeDeal().getFormattedOrderTypes());
                        }
                    });
                }
            }
        }
        advertDetailsSafeDealTrustFactorsView.showTrustFactors(advertDetailsSafeDealTrustFactorsItem.getSafeDeal(), this.a);
    }
}
