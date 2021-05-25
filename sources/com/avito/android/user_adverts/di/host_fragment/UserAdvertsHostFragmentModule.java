package com.avito.android.user_adverts.di.host_fragment;

import com.avito.android.app_rater.di.AppRaterModule;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AbTestGroupModule;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_adverts.root_screen.adverts_host.TabItem;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenterImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractorImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractorImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProvider;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProviderImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.SoaPriceFormatter;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractorImpl;
import com.avito.android.user_adverts_common.charity.CharityModule;
import com.avito.android.user_adverts_common.safety.di.SafetyInfoModule;
import com.avito.android.user_stats.di.UserStatsStorageModule;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentModule;", "", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabItem;", "provideTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "<init>", "()V", "Declarations", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AppRaterModule.class, SafetyInfoModule.class, CharityModule.class, AbTestGroupModule.class, CartFabModule.class, UserStatsStorageModule.class})
public final class UserAdvertsHostFragmentModule {
    @NotNull
    public static final UserAdvertsHostFragmentModule INSTANCE = new UserAdvertsHostFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/user_adverts/di/host_fragment/UserAdvertsHostFragmentModule$Declarations;", "", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenterImpl;", "presenter", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "providePresenter", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenterImpl;)Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractorImpl;", "interactor", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "provideInteractor", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractorImpl;)Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsInteractor;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractorImpl;", "storage", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "provideProfileHeaderInteractor", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractorImpl;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/SoaPriceFormatter;", "formatter", "Lcom/avito/android/util/Formatter;", "", "provideSoaPriceFormatter", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/SoaPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractorImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractor;", "provideSoaInfoInteractor", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractorImpl;)Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoInteractor;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProviderImpl;", "impl", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "provideResourcesProvider", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProviderImpl;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        UserAdvertsInteractor provideInteractor(@NotNull UserAdvertsInteractorImpl userAdvertsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        UserAdvertsHostPresenter providePresenter(@NotNull UserAdvertsHostPresenterImpl userAdvertsHostPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ProfileHeaderInteractor provideProfileHeaderInteractor(@NotNull ProfileHeaderInteractorImpl profileHeaderInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ProfileHeaderResourceProvider provideResourcesProvider(@NotNull ProfileHeaderResourceProviderImpl profileHeaderResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SoaInfoInteractor provideSoaInfoInteractor(@NotNull SoaInfoInteractorImpl soaInfoInteractorImpl);

        @Binds
        @NotNull
        @PerFragment
        Formatter<String> provideSoaPriceFormatter(@NotNull SoaPriceFormatter soaPriceFormatter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TabsDataProvider<TabItem> provideTabsDataProvider() {
        return new TabsDataProvider<>();
    }
}
