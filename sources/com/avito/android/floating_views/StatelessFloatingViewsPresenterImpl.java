package com.avito.android.floating_views;

import com.avito.android.floating_views.FloatingViewsPresenter;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/floating_views/StatelessFloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/BaseFloatingViewsPresenterImpl;", "", "show", "()V", "hide", "<init>", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public final class StatelessFloatingViewsPresenterImpl extends BaseFloatingViewsPresenterImpl {
    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void hide() {
        FloatingViewsPresenter.Subscriber subscriber = getSubscriber();
        if (subscriber != null) {
            subscriber.hideFloatingViews(true);
        }
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void show() {
        FloatingViewsPresenter.Subscriber subscriber = getSubscriber();
        if (subscriber != null) {
            subscriber.showFloatingViews(true);
        }
    }
}
