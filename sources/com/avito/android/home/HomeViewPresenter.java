package com.avito.android.home;

import com.avito.android.home.appending_item.retry.RetryItemsLoadingListener;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/home/HomeViewPresenter;", "Lcom/avito/android/home/appending_item/retry/RetryItemsLoadingListener;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler$Listener;", "", "retryLoading", "()V", "onClarifyClicked", "onRefresh", "showAllCategories", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeViewPresenter extends RetryItemsLoadingListener, SnippetScrollDepthRecyclerViewScrollHandler.Listener {
    void onClarifyClicked();

    void onRefresh();

    void retryLoading();

    void showAllCategories();
}
