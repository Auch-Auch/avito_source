package com.avito.android.user_advert.advert.feature_teasers.di;

import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserPresenter;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.di.CommonFeatureTeaserModule;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenter;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenterImpl;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenter;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenterImpl;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserResourceProvider;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_advert/advert/feature_teasers/di/MyAdvertDetailsFeaturesTeasersModule;", "", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenterImpl;", "presenter", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;", "getMyAdvertDetailsFeatureTeaserPresenter", "(Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenterImpl;)Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserResourceProvider;", GeoContract.PROVIDER, "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "getFeatureTeaserResourceProvider", "(Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserResourceProvider;)Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/CommonFeatureTeaserPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", "getFeatureTeaserPresenter", "(Lcom/avito/android/advert_core/feature_teasers/common/CommonFeatureTeaserPresenter;)Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserPresenter;", "Lcom/avito/android/advert_core/gap/AdvertDetailsGapPresenterImpl;", "Lcom/avito/android/advert_core/gap/AdvertDetailsGapPresenter;", "getAdvertDetailsGapPresenter", "(Lcom/avito/android/advert_core/gap/AdvertDetailsGapPresenterImpl;)Lcom/avito/android/advert_core/gap/AdvertDetailsGapPresenter;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CommonFeatureTeaserModule.class})
public interface MyAdvertDetailsFeaturesTeasersModule {
    @Binds
    @NotNull
    AdvertDetailsGapPresenter getAdvertDetailsGapPresenter(@NotNull AdvertDetailsGapPresenterImpl advertDetailsGapPresenterImpl);

    @Binds
    @NotNull
    FeatureTeaserPresenter getFeatureTeaserPresenter(@NotNull CommonFeatureTeaserPresenter commonFeatureTeaserPresenter);

    @Binds
    @NotNull
    FeatureTeaserResourceProvider getFeatureTeaserResourceProvider(@NotNull MyAdvertDetailsFeatureTeaserResourceProvider myAdvertDetailsFeatureTeaserResourceProvider);

    @Binds
    @NotNull
    MyAdvertDetailsFeatureTeaserPresenter getMyAdvertDetailsFeatureTeaserPresenter(@NotNull MyAdvertDetailsFeatureTeaserPresenterImpl myAdvertDetailsFeatureTeaserPresenterImpl);
}
