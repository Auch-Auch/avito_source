package com.avito.android.public_profile.di;

import android.content.res.Resources;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.public_profile.ProfileAdvertsFragment;
import com.avito.android.public_profile.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.public_profile.adapter.loading_item.di.PageLoadingItemModule;
import com.avito.android.public_profile.adapter.placeholder.di.PlaceholderItemModule;
import com.avito.android.public_profile.di.ProfileAdvertsModule;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsComponent;", "", "Lcom/avito/android/public_profile/ProfileAdvertsFragment;", "fragment", "", "inject", "(Lcom/avito/android/public_profile/ProfileAdvertsFragment;)V", "Builder", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ProfileAdvertsDependencies.class}, modules = {ProfileAdvertsModule.class, ProfileAdvertsAdapterModule.class, SerpItemConverterModule.class, FavoriteAdvertsPresenterModule.class, PlaceholderItemModule.class, ErrorSnippetItemModule.class, PageLoadingItemModule.class, PublicProfileAdvertsTrackerModule.class})
@PerFragment
public interface ProfileAdvertsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u00002\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u001d\u0010\u000fJ\u0019\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH'¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "", "Lcom/avito/android/public_profile/di/ProfileAdvertsDependencies;", "profileAdvertsDependencies", "(Lcom/avito/android/public_profile/di/ProfileAdvertsDependencies;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "Lcom/avito/android/public_profile/di/ProfileAdvertsModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "profileAdvertsModule", "(Lcom/avito/android/public_profile/di/ProfileAdvertsModule;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "Lcom/avito/android/public_profile/di/ProfileAdvertsAdapterModule;", "profileAdvertsAdapterModule", "(Lcom/avito/android/public_profile/di/ProfileAdvertsAdapterModule;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "", "shortcut", "bindShortcut", "(Ljava/lang/String;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", "screenName", "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "", "isSubComponent", "withSubComponent", "(Z)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "contextId", "bindContextId", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "handler", "withSerpOnboardingHandler", "(Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;)Lcom/avito/android/public_profile/di/ProfileAdvertsComponent$Builder;", "Lcom/avito/android/public_profile/di/ProfileAdvertsComponent;", "build", "()Lcom/avito/android/public_profile/di/ProfileAdvertsComponent;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindContextId(@ProfileAdvertsModule.ContextId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder bindShortcut(@ProfileAdvertsModule.Shortcut @NotNull String str);

        @NotNull
        ProfileAdvertsComponent build();

        @NotNull
        Builder profileAdvertsAdapterModule(@NotNull ProfileAdvertsAdapterModule profileAdvertsAdapterModule);

        @NotNull
        Builder profileAdvertsDependencies(@NotNull ProfileAdvertsDependencies profileAdvertsDependencies);

        @NotNull
        Builder profileAdvertsModule(@NotNull ProfileAdvertsModule profileAdvertsModule);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withScreen(@ScreenAnalytics @NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder withSerpOnboardingHandler(@Nullable SerpOnboardingHandler serpOnboardingHandler);

        @BindsInstance
        @NotNull
        Builder withSubComponent(@ScreenAnalytics boolean z);
    }

    void inject(@NotNull ProfileAdvertsFragment profileAdvertsFragment);
}
