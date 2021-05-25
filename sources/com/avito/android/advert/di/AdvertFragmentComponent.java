package com.avito.android.advert.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.AdvertDetailsFastOpenParams;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractorState;
import com.avito.android.advert.item.questionnaire.di.QuestionnaireState;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule;
import com.avito.android.advert_core.analytics.InitialTreeParent;
import com.avito.android.advert_core.analytics.broker.BrokerAnalyticsState;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.autoteka_details.core.di.AutotekaInteractorState;
import com.avito.android.autoteka_details.core.di.AutotekaTeaserInteractorState;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.di.PerScreen;
import com.avito.android.di.module.AdvertId;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.recommendation.ForRecommendation;
import com.avito.android.fps.di.FpsModule;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.section.di.SectionModule;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.UrlParams;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@PerScreen
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentComponent;", "", "Lcom/avito/android/advert/item/AdvertDetailsFragment;", "fragment", "", "inject", "(Lcom/avito/android/advert/item/AdvertDetailsFragment;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AdvertFragmentDependencies.class, ScreenAnalyticsDependencies.class}, modules = {AdvertFragmentModule.class, DateTimeFormatterModule.class, FpsModule.class, CompositeSnackbarModule.class})
@PerFragment
public interface AdvertFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00002\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*H'¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.H'¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u00020\u00002\n\b\u0001\u00103\u001a\u0004\u0018\u000102H'¢\u0006\u0004\b4\u00105J\u001b\u00108\u001a\u00020\u00002\n\b\u0001\u00107\u001a\u0004\u0018\u000106H'¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010:H'¢\u0006\u0004\b<\u0010=J\u001b\u0010?\u001a\u00020\u00002\n\b\u0001\u0010>\u001a\u0004\u0018\u000106H'¢\u0006\u0004\b?\u00109J\u001b\u0010A\u001a\u00020\u00002\n\b\u0001\u0010@\u001a\u0004\u0018\u000106H'¢\u0006\u0004\bA\u00109J\u001b\u0010C\u001a\u00020\u00002\n\b\u0001\u0010B\u001a\u0004\u0018\u000106H'¢\u0006\u0004\bC\u00109J\u001b\u0010E\u001a\u00020\u00002\n\b\u0001\u0010D\u001a\u0004\u0018\u000102H'¢\u0006\u0004\bE\u00105J\u001b\u0010H\u001a\u00020\u00002\n\b\u0001\u0010G\u001a\u0004\u0018\u00010FH'¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00002\u0006\u0010K\u001a\u00020JH'¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u00002\u0006\u0010O\u001a\u00020NH'¢\u0006\u0004\bP\u0010QJ\u001d\u0010U\u001a\u00020\u00002\f\u0010T\u001a\b\u0012\u0004\u0012\u00020S0RH'¢\u0006\u0004\bU\u0010VJ\u001b\u0010X\u001a\u00020\u00002\n\b\u0001\u0010W\u001a\u0004\u0018\u000106H'¢\u0006\u0004\bX\u00109J\u001b\u0010Y\u001a\u00020\u00002\n\b\u0001\u0010W\u001a\u0004\u0018\u000106H'¢\u0006\u0004\bY\u00109J\u0017\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020ZH'¢\u0006\u0004\b\\\u0010]J\u0017\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020^H'¢\u0006\u0004\b`\u0010aJ\u001b\u0010c\u001a\u00020\u00002\n\b\u0001\u0010b\u001a\u0004\u0018\u000102H'¢\u0006\u0004\bc\u00105J\u001b\u0010e\u001a\u00020\u00002\n\b\u0001\u0010d\u001a\u0004\u0018\u000106H'¢\u0006\u0004\be\u00109J\u001b\u0010g\u001a\u00020\u00002\n\b\u0001\u0010f\u001a\u0004\u0018\u000106H'¢\u0006\u0004\bg\u00109J\u000f\u0010i\u001a\u00020hH&¢\u0006\u0004\bi\u0010j¨\u0006k"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "", "Lcom/avito/android/advert/di/AdvertFragmentDependencies;", "advertDependencies", "(Lcom/avito/android/advert/di/AdvertFragmentDependencies;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/di/module/ScreenAnalyticsDependencies;", "dependencies", "screenAnalyticsDependencies", "(Lcom/avito/android/di/module/ScreenAnalyticsDependencies;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "", BookingInfoActivity.EXTRA_ITEM_ID, "withAdvertId", "(Ljava/lang/String;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "context", "withSearchContext", "Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;", "params", "withFastOpenParams", "(Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "withScreenSource", "(Lcom/avito/android/rec/ScreenSource;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "", "isMarketPlaceFastFlag", "withMarketplaceFlag", "(Z)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "", "lickTime", "withClickTime", "(J)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "", "imagePosition", "withStartingGalleryPosition", "(I)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "fragmentDelegate", "withFragmentDelegate", "(Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Landroid/os/Bundle;", "savedState", "withSectionSavedState", "(Landroid/os/Bundle;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/util/Kundle;", "autotekaInteractorState", "withAutotekaInteractorState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", CommonKt.EXTRA_RESPONSE, "withAutotekaDetailsResponse", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "autotekaTeaserInteractorState", "withAutotekaTeaserInteractorState", "domotekaTeaserInteractorState", "withDomotekaTeaserInteractorState", "toolbarPresenterState", "withToolbarPresenterState", "defaultVisibilityTrackerState", "withItemVisibilityTrackerState", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "withTreeParent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "withLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Landroidx/lifecycle/ViewModelStoreOwner;", UrlParams.OWNER, "withViewModelStoreOwner", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", "relay", "withRelay", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "state", "withRecommendationPresenterState", "withBrokerAnalyticsState", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "source", "withAnalyticsRecommendationSource", "(Lcom/avito/android/analytics/event/favorite/SubscriptionSource;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "withBannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/advert/di/AdvertFragmentComponent$Builder;", "questionnaireState", "withQuestionnaireState", "replacementsState", "witReplacementsPresenterState", "compatibilitiesState", "withCompatibilitiesPresenterState", "Lcom/avito/android/advert/di/AdvertFragmentComponent;", "build", "()Lcom/avito/android/advert/di/AdvertFragmentComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder advertDependencies(@NotNull AdvertFragmentDependencies advertFragmentDependencies);

        @NotNull
        AdvertFragmentComponent build();

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);

        @NotNull
        Builder screenAnalyticsDependencies(@NotNull ScreenAnalyticsDependencies screenAnalyticsDependencies);

        @BindsInstance
        @NotNull
        Builder witReplacementsPresenterState(@SparePartsModule.ReplacementsPresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withAdvertId(@AdvertId @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withAnalyticsRecommendationSource(@NotNull SubscriptionSource subscriptionSource);

        @BindsInstance
        @NotNull
        Builder withAutotekaDetailsResponse(@Nullable AutotekaDetailsResponse autotekaDetailsResponse);

        @BindsInstance
        @NotNull
        Builder withAutotekaInteractorState(@AutotekaInteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withAutotekaTeaserInteractorState(@AutotekaTeaserInteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withBannerPageSource(@NotNull BannerPageSource bannerPageSource);

        @BindsInstance
        @NotNull
        Builder withBrokerAnalyticsState(@BrokerAnalyticsState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withClickTime(long j);

        @BindsInstance
        @NotNull
        Builder withCompatibilitiesPresenterState(@SparePartsModule.CompatibilitiesPresenterState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withDomotekaTeaserInteractorState(@DomotekaTeaserInteractorState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withFastOpenParams(@Nullable AdvertDetailsFastOpenParams advertDetailsFastOpenParams);

        @BindsInstance
        @NotNull
        Builder withFragmentDelegate(@NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate);

        @BindsInstance
        @NotNull
        Builder withItemVisibilityTrackerState(@AdvertFragmentModule.AdvertDetailsItemVisibilityTrackerState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner);

        @BindsInstance
        @NotNull
        Builder withMarketplaceFlag(boolean z);

        @BindsInstance
        @NotNull
        Builder withQuestionnaireState(@QuestionnaireState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withRecommendationPresenterState(@ForRecommendation @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withRelay(@NotNull PublishRelay<FavoriteSellersItemAction> publishRelay);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withScreenSource(@NotNull ScreenSource screenSource);

        @BindsInstance
        @NotNull
        Builder withSearchContext(@AdvertFragmentModule.SearchContext @Nullable String str);

        @BindsInstance
        @NotNull
        Builder withSectionSavedState(@SectionModule.SavedState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withStartingGalleryPosition(int i);

        @BindsInstance
        @NotNull
        Builder withToolbarPresenterState(@AdvertFragmentModule.ToolbarPresenterSavedState @Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withTreeParent(@InitialTreeParent @Nullable TreeClickStreamParent treeClickStreamParent);

        @BindsInstance
        @NotNull
        Builder withViewModelStoreOwner(@NotNull ViewModelStoreOwner viewModelStoreOwner);
    }

    void inject(@NotNull AdvertDetailsFragment advertDetailsFragment);
}
