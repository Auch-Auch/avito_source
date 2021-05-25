package com.avito.android.advert_core.feature_teasers.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", "", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "view", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "item", "", "bindView", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;)V", "onAction", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface FeatureTeaserPresenter {
    void bindView(@NotNull FeatureTeaserView featureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem);

    void onAction(@NotNull FeatureTeaserView featureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem);
}
