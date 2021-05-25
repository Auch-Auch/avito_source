package com.avito.android.advert_core.feature_teasers.common.di;

import a2.b.a.a.a;
import com.avito.android.IdProvider;
import com.avito.android.IdProviderImpl;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.CommonAdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemBlueprint;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemPresenter;
import com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\t\u001a\u00020\u00062\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/di/CommonFeatureTeaserModule;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$advert_core_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "<init>", "()V", "Declarations", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CommonFeatureTeaserModule {
    @NotNull
    public static final CommonFeatureTeaserModule INSTANCE = new CommonFeatureTeaserModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\u0006\u0010\u0011\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/di/CommonFeatureTeaserModule$Declarations;", "", "Lcom/avito/android/advert_core/feature_teasers/common/CommonAdvertDetailsFeatureTeaserItemsAdapter;", "adapter", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "getAdvertDetailsFeatureTeaserItemsAdapter", "(Lcom/avito/android/advert_core/feature_teasers/common/CommonAdvertDetailsFeatureTeaserItemsAdapter;)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItemsAdapter;", "Lcom/avito/android/IdProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/IdProvider;", "getIdProvider", "(Lcom/avito/android/IdProviderImpl;)Lcom/avito/android/IdProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemPresenter;", "presenter", "provideAdvertDetailsFeatureTeaserDialogTextItemPresenter", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemPresenter;)Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideTextItemBlueprint", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert_core/gap/AdvertDetailsGapBlueprint;", "provideGapBlueprint", "(Lcom/avito/android/advert_core/gap/AdvertDetailsGapBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/CommonFeatureTeaserDialogFactory;", "factory", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "getAdvertDetailsDialogFactory", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/CommonFeatureTeaserDialogFactory;)Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        FeatureTeaserDialogFactory getAdvertDetailsDialogFactory(@NotNull CommonFeatureTeaserDialogFactory commonFeatureTeaserDialogFactory);

        @Binds
        @NotNull
        AdvertDetailsFeatureTeaserItemsAdapter getAdvertDetailsFeatureTeaserItemsAdapter(@NotNull CommonAdvertDetailsFeatureTeaserItemsAdapter commonAdvertDetailsFeatureTeaserItemsAdapter);

        @Binds
        @AdvertDetailsFeatureTeaser
        @NotNull
        IdProvider getIdProvider(@NotNull IdProviderImpl idProviderImpl);

        @Reusable
        @Binds
        @NotNull
        @AdvertDetailsFeatureTeaser
        AdvertDetailsFeatureTeaserDialogTextItemPresenter provideAdvertDetailsFeatureTeaserDialogTextItemPresenter(@NotNull AdvertDetailsFeatureTeaserDialogTextItemPresenter advertDetailsFeatureTeaserDialogTextItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @AdvertDetailsFeatureTeaser
        ItemBlueprint<?, ?> provideGapBlueprint(@NotNull AdvertDetailsGapBlueprint advertDetailsGapBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @AdvertDetailsFeatureTeaser
        ItemBlueprint<?, ?> provideTextItemBlueprint(@NotNull AdvertDetailsFeatureTeaserDialogTextItemBlueprint advertDetailsFeatureTeaserDialogTextItemBlueprint);
    }

    @Provides
    @JvmStatic
    @NotNull
    @AdvertDetailsFeatureTeaser
    public static final SimpleAdapterPresenter provideAdapter(@AdvertDetailsFeatureTeaser @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @AdvertDetailsFeatureTeaser
    public static final ItemBinder provideItemBinder$advert_core_release(@AdvertDetailsFeatureTeaser @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }
}
