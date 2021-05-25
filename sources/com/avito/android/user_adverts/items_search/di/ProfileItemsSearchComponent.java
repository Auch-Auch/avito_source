package com.avito.android.user_adverts.items_search.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.user_adverts.di.UserAdvertsListItemsModule;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
import com.avito.android.user_adverts.items_search.di.ProfileItemsSearchModule;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent;", "", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment;", "fragment", "", "inject", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment;)V", "Builder", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ProfileItemsSearchDependencies.class}, modules = {UserAdvertsListItemsModule.class, UserAdvertsListAdapterModule.class, ProfileItemsSearchTrackerModule.class, ProfileItemsSearchModule.class})
@PerFragment
public interface ProfileItemsSearchComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "", "shortcut", "bindShortcut", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchDependencies;", "component", "profileItemsSearchComponentDependencies", "(Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchDependencies;)Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertsListAdapterModule;", "userAdvertsListAdapterModule", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertsListAdapterModule;)Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent$Builder;", "Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent;", "build", "()Lcom/avito/android/user_adverts/items_search/di/ProfileItemsSearchComponent;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindShortcut(@ProfileItemsSearchModule.Shortcut @NotNull String str);

        @NotNull
        ProfileItemsSearchComponent build();

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @NotNull
        Builder profileItemsSearchComponentDependencies(@NotNull ProfileItemsSearchDependencies profileItemsSearchDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @NotNull
        Builder userAdvertsListAdapterModule(@NotNull UserAdvertsListAdapterModule userAdvertsListAdapterModule);
    }

    void inject(@NotNull ProfileItemsSearchFragment profileItemsSearchFragment);
}
