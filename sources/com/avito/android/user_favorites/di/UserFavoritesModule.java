package com.avito.android.user_favorites.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.di.PerActivity;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_favorites.UserFavoritesInteractor;
import com.avito.android.user_favorites.UserFavoritesInteractorImpl;
import com.avito.android.user_favorites.UserFavoritesPresenter;
import com.avito.android.user_favorites.UserFavoritesPresenterImpl;
import com.avito.android.user_favorites.UserFavoritesResourceProvider;
import com.avito.android.user_favorites.UserFavoritesResourceProviderImpl;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.util.UrlParams;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0019\u0010\u0013\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011¢\u0006\u0002\b\u00120\u0010H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/user_favorites/di/UserFavoritesModule;", "", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "provideTabsDataProvider$user_favorites_release", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "provideTabsDataProvider", "tabsDataProvider", "Landroid/content/Context;", "context", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabsLayout$user_favorites_release", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;)Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "provideTabsLayout", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "provideTabPagerAdapter$user_favorites_release", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Ljava/util/Set;)Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "provideTabPagerAdapter", "Landroidx/fragment/app/Fragment;", "fragment", "provideFragmentManager", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentManager;", "Landroid/content/res/Resources;", "provideResource", "(Landroidx/fragment/app/Fragment;)Landroid/content/res/Resources;", "provideContext", "(Landroidx/fragment/app/Fragment;)Landroid/content/Context;", "<init>", "()V", "Declarations", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, CartFabModule.class})
public final class UserFavoritesModule {
    @NotNull
    public static final UserFavoritesModule INSTANCE = new UserFavoritesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_favorites/di/UserFavoritesModule$Declarations;", "", "Lcom/avito/android/user_favorites/UserFavoritesInteractorImpl;", "interactor", "Lcom/avito/android/user_favorites/UserFavoritesInteractor;", "bindUserFavoritesInteractor", "(Lcom/avito/android/user_favorites/UserFavoritesInteractorImpl;)Lcom/avito/android/user_favorites/UserFavoritesInteractor;", "Lcom/avito/android/user_favorites/UserFavoritesPresenterImpl;", "presenter", "Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "bindUserFavoritesPresenter", "(Lcom/avito/android/user_favorites/UserFavoritesPresenterImpl;)Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "Lcom/avito/android/user_favorites/UserFavoritesResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "bindUserFavoritesResourceProvider", "(Lcom/avito/android/user_favorites/UserFavoritesResourceProviderImpl;)Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "Landroidx/fragment/app/Fragment;", UrlParams.OWNER, "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        UserFavoritesInteractor bindUserFavoritesInteractor(@NotNull UserFavoritesInteractorImpl userFavoritesInteractorImpl);

        @Binds
        @NotNull
        UserFavoritesPresenter bindUserFavoritesPresenter(@NotNull UserFavoritesPresenterImpl userFavoritesPresenterImpl);

        @Binds
        @NotNull
        UserFavoritesResourceProvider bindUserFavoritesResourceProvider(@NotNull UserFavoritesResourceProviderImpl userFavoritesResourceProviderImpl);

        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Context provideContext(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return requireContext;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final FragmentManager provideFragmentManager(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        return childFragmentManager;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Resources provideResource(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Resources resources = fragment.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "fragment.resources");
        return resources;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TabPagerAdapter provideTabPagerAdapter$user_favorites_release(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<FavoritesTab> tabsDataProvider, @NotNull Set<TabBlueprint<? extends FavoritesTab>> set) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        return new TabPagerAdapter(fragmentManager, tabsDataProvider, set, TabPagerAdapter.Behaviour.RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TabsDataProvider<FavoritesTab> provideTabsDataProvider$user_favorites_release() {
        return new TabsDataProvider<>();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TabLayoutAdapter<FavoritesTab> provideTabsLayout$user_favorites_release(@NotNull TabsDataProvider<FavoritesTab> tabsDataProvider, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        return new TabLayoutAdapter<>(tabsDataProvider, context, 0, 4, null);
    }
}
