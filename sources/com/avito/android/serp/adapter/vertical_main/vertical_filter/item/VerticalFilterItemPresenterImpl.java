package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAnalyticParams;
import com.avito.android.serp.adapter.vertical_main.analytics.VerticalMainShowWidgetEvent;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemView;", "view", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemView;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;I)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "verticalFilterPresenter", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItemPresenterImpl implements VerticalFilterItemPresenter {
    public final VerticalFilterPresenter a;
    public final Analytics b;

    @Inject
    public VerticalFilterItemPresenterImpl(@NotNull VerticalFilterPresenter verticalFilterPresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(verticalFilterPresenter, "verticalFilterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = verticalFilterPresenter;
        this.b = analytics;
    }

    public void bindView(@NotNull VerticalFilterItemView verticalFilterItemView, @NotNull VerticalFilterItem verticalFilterItem, int i) {
        Intrinsics.checkNotNullParameter(verticalFilterItemView, "view");
        Intrinsics.checkNotNullParameter(verticalFilterItem, "item");
        this.a.attachView(verticalFilterItemView, verticalFilterItem.getFilters(), verticalFilterItem.getAction(), verticalFilterItem.getSubmitParams(), verticalFilterItem.getAnalyticParams());
        verticalFilterItemView.setTitle(verticalFilterItem.getTitle());
        Analytics analytics = this.b;
        SearchFormWidgetAnalyticParams analyticParams = verticalFilterItem.getAnalyticParams();
        analytics.track(new VerticalMainShowWidgetEvent(analyticParams != null ? analyticParams.getCategoryId() : null, i, this.a.getXHash(), verticalFilterItem.getStringId()));
    }
}
