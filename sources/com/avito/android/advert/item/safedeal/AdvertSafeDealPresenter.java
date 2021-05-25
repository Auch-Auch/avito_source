package com.avito.android.advert.item.safedeal;

import android.os.Bundle;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonView;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonView;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoView;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelView;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsView;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001%J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH&¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH&¢\u0006\u0004\b$\u0010\u0014¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter;", "Lcom/avito/android/advert/item/safedeal/info/AdvertDetailsSafeDealInfoView$Router;", "Lcom/avito/android/advert/item/safedeal/button/legacy/AdvertDetailsSafeDealLegacyButtonView$Router;", "Lcom/avito/android/advert/item/safedeal/button/AdvertDetailsSafeDealButtonView$Router;", "Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelView$Router;", "Lcom/avito/android/advert/item/safedeal/trust_factors/AdvertDetailsSafeDealTrustFactorsView$Router;", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", "Landroid/os/Bundle;", "state", "", "restoreState", "(Landroid/os/Bundle;)V", "saveState", "()Landroid/os/Bundle;", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "view", "attachCoreView", "(Lcom/avito/android/advert_core/advert/AdvertCoreView;)V", "detachView", "()V", "Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;)V", "detachRouter", "", "categoryId", "setCategoryId", "(Ljava/lang/String;)V", "userHashId", "setUserHashId", "", "isMarketplace", "setIsMarketplace", "(Z)V", "showNoPurchaseFeedbackIfNeeded", "Router", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertSafeDealPresenter extends AdvertDetailsSafeDealInfoView.Router, AdvertDetailsSafeDealLegacyButtonView.Router, AdvertDetailsSafeDealButtonView.Router, AdvertDetailsSafeDealLabelView.Router, AdvertDetailsSafeDealTrustFactorsView.Router, MyAdvertSafeDealServicesView.Router, FeedbackDialog.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/safedeal/AdvertSafeDealPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followSafeDealDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followSafeDealDeepLink(@NotNull DeepLink deepLink);
    }

    void attachCoreView(@Nullable AdvertCoreView advertCoreView);

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void detachView();

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();

    void setCategoryId(@Nullable String str);

    void setIsMarketplace(boolean z);

    void setUserHashId(@Nullable String str);

    void showNoPurchaseFeedbackIfNeeded();
}
