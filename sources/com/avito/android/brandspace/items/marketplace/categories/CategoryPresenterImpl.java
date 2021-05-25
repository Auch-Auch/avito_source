package com.avito.android.brandspace.items.marketplace.categories;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryPresenter;", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItemView;", "view", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItemView;Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryPresenterImpl implements CategoryPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CategoryPresenterImpl a;
        public final /* synthetic */ CategoryItem b;

        public a(CategoryPresenterImpl categoryPresenterImpl, CategoryItem categoryItem) {
            this.a = categoryPresenterImpl;
            this.b = categoryItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor = this.a.b;
            CategoryItem categoryItem = this.b;
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(brandspaceAnalyticsInteractor, categoryItem, categoryItem.getAction().getDeepLink(), false, 4, null);
            this.a.a.openDeeplink(this.b.getAction().getDeepLink());
        }
    }

    @Inject
    public CategoryPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
    }

    public void bindView(@NotNull CategoryItemView categoryItemView, @NotNull CategoryItem categoryItem, int i) {
        Intrinsics.checkNotNullParameter(categoryItemView, "view");
        Intrinsics.checkNotNullParameter(categoryItem, "item");
        a aVar = new a(this, categoryItem);
        categoryItemView.setPreviewImage(categoryItem.getImage());
        categoryItemView.setTitle(categoryItem.getTitle());
        categoryItemView.setBackgroundColor(categoryItem.getBackgroundColor());
        categoryItemView.setOnClickListener(aVar);
    }
}
