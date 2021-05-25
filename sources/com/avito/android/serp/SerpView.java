package com.avito.android.serp;

import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.legacy_mvp.ErrorMessageView;
import com.avito.android.serp.adapter.closable.ClosedItemView;
import com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/SerpView;", "Lcom/avito/android/serp/SerpPresenterView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/util/architecture_components/auto_clear/LifecycleDestroyable;", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "Lcom/avito/android/legacy_mvp/ErrorMessageView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "Lcom/avito/android/serp/adapter/closable/ClosedItemView;", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SerpView extends SerpPresenterView, FavoriteAdvertsView, LifecycleDestroyable, FloatingViewsPresenter.Subscriber, ErrorMessageView, ViewedAdvertsView, ClosedItemView {
}
