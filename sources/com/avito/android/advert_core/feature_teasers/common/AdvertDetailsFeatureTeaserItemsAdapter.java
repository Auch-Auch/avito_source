package com.avito.android.advert_core.feature_teasers.common;

import com.avito.android.remote.model.feature_teaser.ApartmentFeature;
import com.avito.android.remote.model.feature_teaser.CheckedByAvito;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "", "", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", "apartmentFeatures", "", "span", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "teaserIndex", "", "idGenerator", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "createItems", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "checkedByAvito", "itemId", "createItem", "(Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;IJ)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFeatureTeaserItemsAdapter {
    @Nullable
    AdvertDetailsFeatureTeaserItem createItem(@Nullable CheckedByAvito checkedByAvito, int i, long j);

    @Nullable
    List<AdvertDetailsFeatureTeaserItem> createItems(@Nullable List<ApartmentFeature> list, int i, @NotNull Function1<? super Integer, Long> function1);
}
