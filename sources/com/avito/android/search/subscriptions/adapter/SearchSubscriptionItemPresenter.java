package com.avito.android.search.subscriptions.adapter;

import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemView;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "Listener", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionItemPresenter extends ItemPresenter<SearchSubscriptionItemView, SearchSubscriptionItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter$Listener;", "", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "searchSubscription", "", "onSubscriptionClicked", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;)V", "onRemoveSubscriptionClicked", "onMoreActionClicked", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onMoreActionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem);

        void onRemoveSubscriptionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem);

        void onSubscriptionClicked(@NotNull SearchSubscriptionItem searchSubscriptionItem);
    }
}
