package com.avito.android.favorite_sellers.adapter.advert_list;

import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.di.ForAdvertList;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.Kundle;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemView;", "view", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemView;Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem;I)V", "", "id", "onCurrentPositionChanged", "(Ljava/lang/String;I)V", "invalidateState", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Kundle;", "state", "<init>", "(Lcom/avito/android/util/Kundle;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertListItemPresenterImpl implements AdvertListItemPresenter {
    public final Kundle a;

    @Inject
    public AdvertListItemPresenterImpl(@ForAdvertList @Nullable Kundle kundle) {
        this.a = kundle == null ? new Kundle() : kundle;
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter
    public void invalidateState() {
        this.a.clear();
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter
    public void onCurrentPositionChanged(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a.putInt(str, Integer.valueOf(i));
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter
    @NotNull
    public Kundle onSaveState() {
        return this.a;
    }

    public void viewAttached(@NotNull AdvertListItemView advertListItemView, int i) {
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        AdvertListItemPresenter.DefaultImpls.viewAttached(this, advertListItemView, i);
    }

    public void viewDetached(@NotNull AdvertListItemView advertListItemView, int i) {
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        AdvertListItemPresenter.DefaultImpls.viewDetached(this, advertListItemView, i);
    }

    public void bindView(@NotNull AdvertListItemView advertListItemView, @NotNull AdvertListItem advertListItem, int i) {
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(advertListItemView, "view");
        Intrinsics.checkNotNullParameter(advertListItem, "item");
        Iterator<T> it = advertListItem.getItems().iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            if (!(t2 instanceof AdvertItem) || t2.getViewType() != SerpViewType.BIG) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t != null) {
            advertListItemView.setupViewForLargeItems();
        } else {
            advertListItemView.setupViewForSmallItems();
        }
        ListDataSource listDataSource = new ListDataSource(advertListItem.getItems());
        advertListItemView.getAdapterPresenter().onDataSourceChanged(listDataSource);
        advertListItemView.getFavoritesPresenter().onDataSourceChanged(listDataSource);
        advertListItemView.getFavoritesPresenter().attachView(advertListItemView);
        advertListItemView.getViewedAdvertsPresenter().onDataSourceChanged(listDataSource);
        advertListItemView.getViewedAdvertsPresenter().attachView(advertListItemView);
        advertListItemView.onDataSourceChanged();
        advertListItemView.setTag(String.valueOf(advertListItem.getId()));
        if (advertListItem.isDisabled() || !advertListItem.isSubscribed()) {
            z = true;
        }
        advertListItemView.setDisabled(z);
        Integer num = this.a.getInt(String.valueOf(advertListItem.getId()));
        if (num != null) {
            advertListItemView.setCurrentPosition(num.intValue());
        }
    }
}
