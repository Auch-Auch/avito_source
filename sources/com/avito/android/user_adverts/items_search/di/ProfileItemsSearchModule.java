package com.avito.android.user_adverts.items_search.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemListBlueprint;
import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractor;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchInteractorImpl;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelFactory;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelImpl;
import com.avito.android.user_adverts.items_search.advert_list.SearchCountBlueprint;
import com.avito.android.user_adverts.items_search.advert_list.SmallShortcutTitleBlueprint;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverterImpl;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItemBlueprint;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerBlueprint;
import com.avito.konveyor.ItemBinder;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u000278B\t\b\u0002¢\u0006\u0004\b5\u00106JW\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b%\u0010&J\u0019\u0010*\u001a\f\u0012\u0004\u0012\u00020(0'j\u0002`)H\u0007¢\u0006\u0004\b*\u0010+J\u0019\u0010.\u001a\f\u0012\u0004\u0012\u00020(0,j\u0002`-H\u0007¢\u0006\u0004\b.\u0010/R \u00104\u001a\f\u0012\u0004\u0012\u00020(00j\u0002`18\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00069"}, d2 = {"Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchModule;", "", "Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "shortcutBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerBlueprint;", "linkedInfoBannerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;", "disclaimerBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;", "discountBannerBlueprint", "Lcom/avito/android/user_adverts/items_search/advert_list/SmallShortcutTitleBlueprint;", "shortcutTitleBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;", "performanceVasBannerBlueprint", "Lcom/avito/android/user_adverts/items_search/advert_list/SearchCountBlueprint;", "searchCountBlueprint", "Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;", "loadingItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$user_adverts_release", "(Lcom/avito/android/component/user_advert/UserAdvertItemListBlueprint;Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/disclaimer/DisclaimerBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerBlueprint;Lcom/avito/android/user_adverts/items_search/advert_list/SmallShortcutTitleBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerBlueprint;Lcom/avito/android/user_adverts/items_search/advert_list/SearchCountBlueprint;Lcom/avito/android/user_adverts/tab_screens/advert_list/loading/LoadingItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;", "presenter", "provideShortcutTitleBlueprint$user_adverts_release", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;)Lcom/avito/android/user_adverts/items_search/advert_list/SmallShortcutTitleBlueprint;", "provideShortcutTitleBlueprint", "provideSearchCountBlueprint$user_adverts_release", "(Lcom/avito/android/conveyor_shared_item/single_text/SingleTextPresenter;)Lcom/avito/android/user_adverts/items_search/advert_list/SearchCountBlueprint;", "provideSearchCountBlueprint", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionConsumer;", "bindConsumer", "()Lio/reactivex/functions/Consumer;", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "bindObservable", "()Lio/reactivex/Observable;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "userAdvertActionsStream", "<init>", "()V", "Declarations", "Shortcut", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ProfileItemsSearchModule {
    @NotNull
    public static final ProfileItemsSearchModule INSTANCE = new ProfileItemsSearchModule();
    public static final PublishRelay<UserAdvertItemAction> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchModule$Declarations;", "", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "presenter", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "provideShortcutBannerItemListener", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;)Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractorImpl;", "interactor", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "provideInteractor", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractorImpl;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "viewModel", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "provideClickListener", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;)Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverterImpl;", "converter", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "provideUserSearchItemConverter", "(Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverterImpl;)Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverterImpl;", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "provideSuggestItemConverter", "(Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverterImpl;)Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        UserAdvertItemClickListener provideClickListener(@NotNull ProfileItemsSearchViewModel profileItemsSearchViewModel);

        @PerFragment
        @Binds
        @NotNull
        ProfileItemsSearchInteractor provideInteractor(@NotNull ProfileItemsSearchInteractorImpl profileItemsSearchInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ShortcutBannerItemListener provideShortcutBannerItemListener(@NotNull ProfileItemsSearchViewModel profileItemsSearchViewModel);

        @PerFragment
        @Binds
        @NotNull
        SuggestsItemConverter provideSuggestItemConverter(@NotNull SuggestsItemConverterImpl suggestsItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserSearchItemConverter provideUserSearchItemConverter(@NotNull UserSearchItemConverterImpl userSearchItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull ProfileItemsSearchViewModelFactory profileItemsSearchViewModelFactory);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchModule$Shortcut;", "", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Shortcut {
    }

    static {
        PublishRelay<UserAdvertItemAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<UserAdvertItemAction>()");
        a = create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$user_adverts_release(@NotNull UserAdvertItemListBlueprint userAdvertItemListBlueprint, @NotNull ShortcutBannerBlueprint shortcutBannerBlueprint, @NotNull LinkedInfoBannerBlueprint linkedInfoBannerBlueprint, @NotNull DisclaimerBlueprint disclaimerBlueprint, @NotNull DiscountBannerBlueprint discountBannerBlueprint, @NotNull SmallShortcutTitleBlueprint smallShortcutTitleBlueprint, @NotNull PerformanceVasBannerBlueprint performanceVasBannerBlueprint, @NotNull SearchCountBlueprint searchCountBlueprint, @NotNull LoadingItemBlueprint loadingItemBlueprint) {
        Intrinsics.checkNotNullParameter(userAdvertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(shortcutBannerBlueprint, "shortcutBannerBlueprint");
        Intrinsics.checkNotNullParameter(linkedInfoBannerBlueprint, "linkedInfoBannerBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerBlueprint, "disclaimerBlueprint");
        Intrinsics.checkNotNullParameter(discountBannerBlueprint, "discountBannerBlueprint");
        Intrinsics.checkNotNullParameter(smallShortcutTitleBlueprint, "shortcutTitleBlueprint");
        Intrinsics.checkNotNullParameter(performanceVasBannerBlueprint, "performanceVasBannerBlueprint");
        Intrinsics.checkNotNullParameter(searchCountBlueprint, "searchCountBlueprint");
        Intrinsics.checkNotNullParameter(loadingItemBlueprint, "loadingItemBlueprint");
        return new ItemBinder.Builder().registerItem(disclaimerBlueprint).registerItem(userAdvertItemListBlueprint).registerItem(shortcutBannerBlueprint).registerItem(linkedInfoBannerBlueprint).registerItem(discountBannerBlueprint).registerItem(smallShortcutTitleBlueprint).registerItem(performanceVasBannerBlueprint).registerItem(searchCountBlueprint).registerItem(loadingItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Consumer<UserAdvertItemAction> bindConsumer() {
        return a;
    }

    @Provides
    @NotNull
    @PerFragment
    public final Observable<UserAdvertItemAction> bindObservable() {
        return a;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SearchCountBlueprint provideSearchCountBlueprint$user_adverts_release(@NotNull SingleTextPresenter singleTextPresenter) {
        Intrinsics.checkNotNullParameter(singleTextPresenter, "presenter");
        return new SearchCountBlueprint(singleTextPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SmallShortcutTitleBlueprint provideShortcutTitleBlueprint$user_adverts_release(@NotNull SingleTextPresenter singleTextPresenter) {
        Intrinsics.checkNotNullParameter(singleTextPresenter, "presenter");
        return new SmallShortcutTitleBlueprint(singleTextPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ProfileItemsSearchViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, factory).get(ProfileItemsSearchViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (ProfileItemsSearchViewModel) viewModel;
    }
}
