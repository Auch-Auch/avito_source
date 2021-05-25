package com.avito.android.brandspace.items.productdescriptions;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.items.news.NewsItemView;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenterImpl;", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionPresenter;", "Lcom/avito/android/brandspace/items/news/NewsItemView;", "view", "Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/news/NewsItemView;Lcom/avito/android/brandspace/items/productdescriptions/ProductDescriptionItem;I)V", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductDescriptionPresenterImpl implements ProductDescriptionPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ ProductDescriptionPresenterImpl b;
        public final /* synthetic */ ProductDescriptionItem c;

        public a(DeepLink deepLink, ProductDescriptionPresenterImpl productDescriptionPresenterImpl, ProductDescriptionItem productDescriptionItem) {
            this.a = deepLink;
            this.b = productDescriptionPresenterImpl;
            this.c = productDescriptionItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(this.b.b, this.c, this.a, false, 4, null);
            this.b.a.openDeeplink(this.a);
        }
    }

    @Inject
    public ProductDescriptionPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
    }

    public void bindView(@NotNull NewsItemView newsItemView, @NotNull ProductDescriptionItem productDescriptionItem, int i) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(newsItemView, "view");
        Intrinsics.checkNotNullParameter(productDescriptionItem, "item");
        Image image = productDescriptionItem.getImage();
        String title = productDescriptionItem.getTitle();
        String description = productDescriptionItem.getDescription();
        int precalculatedTextHeight = productDescriptionItem.getPrecalculatedTextHeight();
        Action action = productDescriptionItem.getAction();
        a aVar = null;
        if (!(action == null || (deepLink = action.getDeepLink()) == null)) {
            if (!(!(deepLink instanceof NoMatchLink))) {
                deepLink = null;
            }
            if (deepLink != null) {
                aVar = new a(deepLink, this, productDescriptionItem);
            }
        }
        newsItemView.bind(image, title, description, null, precalculatedTextHeight, aVar);
    }
}
