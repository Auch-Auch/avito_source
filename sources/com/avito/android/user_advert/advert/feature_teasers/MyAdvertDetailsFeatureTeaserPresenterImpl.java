package com.avito.android.user_advert.advert.feature_teasers;

import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.feature_teaser.AdvertDetailsFeaturesTeasers;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenterImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenterImpl;", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "advertDetails", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "myAdvertDetailsView", "", "bindFeatures", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;)V", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "itemsAdapter", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", "featureTeaserPresenter", "<init>", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsFeatureTeaserPresenterImpl implements MyAdvertDetailsFeatureTeaserPresenter {
    public final FeatureTeaserPresenter a;
    public final AdvertDetailsFeatureTeaserItemsAdapter b;

    @Inject
    public MyAdvertDetailsFeatureTeaserPresenterImpl(@NotNull FeatureTeaserPresenter featureTeaserPresenter, @NotNull AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter) {
        Intrinsics.checkNotNullParameter(featureTeaserPresenter, "featureTeaserPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItemsAdapter, "itemsAdapter");
        this.a = featureTeaserPresenter;
        this.b = advertDetailsFeatureTeaserItemsAdapter;
    }

    public static final long access$createId(MyAdvertDetailsFeatureTeaserPresenterImpl myAdvertDetailsFeatureTeaserPresenterImpl, int i) {
        Objects.requireNonNull(myAdvertDetailsFeatureTeaserPresenterImpl);
        return (long) i;
    }

    @Override // com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenter
    public void bindFeatures(@NotNull MyAdvertDetailsItem myAdvertDetailsItem, @NotNull MyAdvertDetailsView myAdvertDetailsView) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem, "advertDetails");
        Intrinsics.checkNotNullParameter(myAdvertDetailsView, "myAdvertDetailsView");
        ArrayList arrayList = new ArrayList();
        List<AdvertDetailsFeatureTeaserItem> createItems = this.b.createItems(myAdvertDetailsItem.getApartmentFeatures(), 0, new Function1<Integer, Long>(this) { // from class: a2.a.a.h3.a.g1.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Long invoke(Integer num) {
                return Long.valueOf(MyAdvertDetailsFeatureTeaserPresenterImpl.access$createId((MyAdvertDetailsFeatureTeaserPresenterImpl) this.receiver, num.intValue()));
            }
        });
        if (createItems != null) {
            arrayList.addAll(createItems);
        }
        AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter = this.b;
        AdvertDetailsFeaturesTeasers teasers = myAdvertDetailsItem.getTeasers();
        AdvertDetailsFeatureTeaserItem createItem = advertDetailsFeatureTeaserItemsAdapter.createItem(teasers != null ? teasers.getCheckedByAvito() : null, 0, 0);
        if (createItem != null) {
            arrayList.add(createItem);
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem = (AdvertDetailsFeatureTeaserItem) obj;
            boolean z = true;
            boolean z2 = i == 0;
            if (i != arrayList.size() - 1) {
                z = false;
            }
            this.a.bindView(myAdvertDetailsView.createFeatureTeaser(z2, z), advertDetailsFeatureTeaserItem);
            i = i2;
        }
    }
}
