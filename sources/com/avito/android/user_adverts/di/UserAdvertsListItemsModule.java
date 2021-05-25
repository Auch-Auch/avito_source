package com.avito.android.user_adverts.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.floating_views.StatelessFloatingViewsPresenterImpl;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.serp.adapter.ShortcutBannerConverterImpl;
import com.avito.android.ui_components.R;
import com.avito.android.user_adverts.tab_screens.UserAdvertsCountUpdater;
import com.avito.android.user_adverts.tab_screens.UserAdvertsCountUpdaterImpl;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractor;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListInteractorImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemPresenter;
import com.avito.android.user_adverts.tab_screens.converters.DisclaimerConverter;
import com.avito.android.user_adverts.tab_screens.converters.DisclaimerConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.DiscountBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.DiscountBannerConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.LinkedInfoBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.LinkedInfoBannerConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.PerformanceVasBannerConverter;
import com.avito.android.user_adverts.tab_screens.converters.PerformanceVasBannerConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.UserAdvertConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserAdvertConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverterImpl;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverterImpl;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListItemsModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter$user_adverts_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$user_adverts_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$user_adverts_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "provideShortcutBannerConverter$user_adverts_release", "(Landroid/content/res/Resources;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "provideShortcutBannerConverter", "Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;", "provideLinkedInfoBannerConverter$user_adverts_release", "(Landroid/content/res/Resources;)Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;", "provideLinkedInfoBannerConverter", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "provideFloatingViewsPresenter$user_adverts_release", "()Lcom/avito/android/floating_views/FloatingViewsPresenter;", "provideFloatingViewsPresenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenter;", "presenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;", "provideLoadingItemBlueprint$user_adverts_release", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenter;)Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;", "provideLoadingItemBlueprint", "<init>", "()V", "Declarations", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class})
public final class UserAdvertsListItemsModule {
    @NotNull
    public static final UserAdvertsListItemsModule INSTANCE = new UserAdvertsListItemsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020$2\u0006\u0010#\u001a\u00020'H'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020$2\u0006\u0010#\u001a\u00020*H'¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H'¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListItemsModule$Declarations;", "", "Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverterImpl;", "converter", "Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;", "provideDisclaimerConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "provideUserItemConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;", "provideUserElementItemConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;", "provideUserAdvertConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdaterImpl;", "updater", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdater;", "provideUserAdvertsCountUpdaterImpl", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdaterImpl;)Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdater;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractorImpl;", "interactor", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "provideInteractor", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractorImpl;)Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverterImpl;", "discountBannerConverterImpl", "Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "provideDiscountConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "presenter", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "provideLinkedInfoDeeplinkClickStreamProvider", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;)Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;", "provideDiscountDeeplinkClickStreamProvider", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;)Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemPresenter;", "provideBannerDeeplinkClickStreamProvider", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemPresenter;)Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverterImpl;", "bannerConverterImpl", "Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;", "providePerformanceVasBannerConverter", "(Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverterImpl;)Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenterImpl;", "itemPresenter", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenter;", "provideLoadingItemPresenter", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenterImpl;)Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemPresenter;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        DeeplinkClickStreamProvider provideBannerDeeplinkClickStreamProvider(@NotNull PerformanceVasBannerItemPresenter performanceVasBannerItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        DisclaimerConverter provideDisclaimerConverter(@NotNull DisclaimerConverterImpl disclaimerConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        DiscountBannerConverter provideDiscountConverter(@NotNull DiscountBannerConverterImpl discountBannerConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        DeeplinkClickStreamProvider provideDiscountDeeplinkClickStreamProvider(@NotNull DiscountBannerPresenter discountBannerPresenter);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertsListInteractor provideInteractor(@NotNull UserAdvertsListInteractorImpl userAdvertsListInteractorImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        DeeplinkClickStreamProvider provideLinkedInfoDeeplinkClickStreamProvider(@NotNull LinkedInfoBannerPresenter linkedInfoBannerPresenter);

        @PerFragment
        @Binds
        @NotNull
        LoadingItemPresenter provideLoadingItemPresenter(@NotNull LoadingItemPresenterImpl loadingItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PerformanceVasBannerConverter providePerformanceVasBannerConverter(@NotNull PerformanceVasBannerConverterImpl performanceVasBannerConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertConverter provideUserAdvertConverter(@NotNull UserAdvertConverterImpl userAdvertConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertsCountUpdater provideUserAdvertsCountUpdaterImpl(@NotNull UserAdvertsCountUpdaterImpl userAdvertsCountUpdaterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserElementItemConverter provideUserElementItemConverter(@NotNull UserElementItemConverterImpl userElementItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserItemConverter provideUserItemConverter(@NotNull UserItemConverterImpl userItemConverterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$user_adverts_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$user_adverts_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ErrorFormatter provideErrorFormatter$user_adverts_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final FloatingViewsPresenter provideFloatingViewsPresenter$user_adverts_release() {
        return new StatelessFloatingViewsPresenterImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LinkedInfoBannerConverter provideLinkedInfoBannerConverter$user_adverts_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new LinkedInfoBannerConverterImpl(resources.getInteger(R.integer.serp_columns));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LoadingItemBlueprint provideLoadingItemBlueprint$user_adverts_release(@NotNull LoadingItemPresenter loadingItemPresenter) {
        Intrinsics.checkNotNullParameter(loadingItemPresenter, "presenter");
        return new LoadingItemBlueprint(loadingItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ShortcutBannerConverter provideShortcutBannerConverter$user_adverts_release(@NotNull Resources resources, @NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        return new ShortcutBannerConverterImpl(deepLinkFactory, resources.getInteger(R.integer.serp_columns));
    }
}
