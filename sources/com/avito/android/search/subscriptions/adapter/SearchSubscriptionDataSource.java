package com.avito.android.search.subscriptions.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchSubscription;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionDataSource;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "getCount", "()I", "count", "Lcom/avito/android/remote/model/SearchSubscription;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "<init>", "(Lcom/avito/konveyor/data_source/DataSource;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionDataSource implements DataSource<SearchSubscriptionItem> {
    public final DataSource<SearchSubscription> a;

    public SearchSubscriptionDataSource(@NotNull DataSource<SearchSubscription> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    @NotNull
    public SearchSubscriptionItem getItem(int i) {
        SearchSubscription item = this.a.getItem(i);
        String id = item.getId();
        String title = item.getTitle();
        String description = item.getDescription();
        long lastUpdateTime = item.getLastUpdateTime();
        int count = item.getCount();
        String ssid = item.getSsid();
        SearchParams searchParams = item.getSearchParams();
        DeepLink editAction = item.getEditAction();
        if (!(editAction instanceof SaveSearchLink)) {
            editAction = null;
        }
        return new SearchSubscriptionItem(id, title, description, lastUpdateTime, count, ssid, searchParams, (SaveSearchLink) editAction, item.getDeeplink());
    }
}
