package com.avito.android.user_adverts.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListComponent;", "", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment;", "fragment", "", "inject", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListFragment;)V", "Builder", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserAdvertsListComponentDependencies.class}, modules = {UserAdvertsListItemsModule.class, UserAdvertsListModule.class, UserAdvertsListAdapterModule.class, UserAdvertsListTrackerModule.class})
@PerFragment
public interface UserAdvertsListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0017J!\u0010\u001d\u001a\u00020\u00002\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "", "Landroid/content/Context;", "context", "(Landroid/content/Context;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "", "shortcut", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Landroid/os/Bundle;", "interactorState", "(Landroid/os/Bundle;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "screenName", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "", "isSubComponent", "(Z)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "isFirstTab", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionRelay;", "relay", "with", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Lcom/avito/android/user_adverts/di/UserAdvertsListComponentDependencies;", "component", "userAdvertsListComponentDependencies", "(Lcom/avito/android/user_adverts/di/UserAdvertsListComponentDependencies;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertsListAdapterModule;", "userAdvertsListAdapterModule", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertsListAdapterModule;)Lcom/avito/android/user_adverts/di/UserAdvertsListComponent$Builder;", "Lcom/avito/android/user_adverts/di/UserAdvertsListComponent;", "build", "()Lcom/avito/android/user_adverts/di/UserAdvertsListComponent;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UserAdvertsListComponent build();

        @BindsInstance
        @NotNull
        Builder context(@NotNull Context context);

        @BindsInstance
        @NotNull
        Builder interactorState(@Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder isFirstTab(@IsFirstTab boolean z);

        @BindsInstance
        @NotNull
        Builder isSubComponent(@ScreenAnalytics boolean z);

        @BindsInstance
        @NotNull
        Builder presenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder screenName(@ScreenAnalytics @NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder shortcut(@NotNull String str);

        @NotNull
        Builder userAdvertsListAdapterModule(@NotNull UserAdvertsListAdapterModule userAdvertsListAdapterModule);

        @NotNull
        Builder userAdvertsListComponentDependencies(@NotNull UserAdvertsListComponentDependencies userAdvertsListComponentDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull PublishRelay<UserAdvertItemAction> publishRelay);
    }

    void inject(@NotNull UserAdvertsListFragment userAdvertsListFragment);
}
