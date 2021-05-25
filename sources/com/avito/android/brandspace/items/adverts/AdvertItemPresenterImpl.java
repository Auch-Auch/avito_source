package com.avito.android.brandspace.items.adverts;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenterImpl;", "Lcom/avito/android/brandspace/items/adverts/AdvertItemPresenter;", "Lcom/avito/android/serp/adapter/RdsAdvertItemView;", "view", "Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/RdsAdvertItemView;Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;I)V", "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;", "innerPresenter", "<init>", "(Lcom/avito/android/serp/adapter/RdsAdvertItemPresenter;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemPresenterImpl implements AdvertItemPresenter {
    public final RdsAdvertItemPresenter a;

    @Inject
    public AdvertItemPresenterImpl(@NotNull RdsAdvertItemPresenter rdsAdvertItemPresenter) {
        Intrinsics.checkNotNullParameter(rdsAdvertItemPresenter, "innerPresenter");
        this.a = rdsAdvertItemPresenter;
    }

    public void bindView(@NotNull RdsAdvertItemView rdsAdvertItemView, @NotNull BrandspaceAdvertItem brandspaceAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(rdsAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(brandspaceAdvertItem, "item");
        this.a.bindView(rdsAdvertItemView, brandspaceAdvertItem.getAdvertItem(), i);
    }
}
