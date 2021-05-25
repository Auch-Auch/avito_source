package com.avito.android.rating.publish.select_advert.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.dialog.di.DialogModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.SelectAdvertFragment;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.rating.publish.select_advert.adapter.advert.di.AdvertItemModule;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.rating.publish.select_advert.adapter.loading.LoadingItemModule;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent;", "", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertFragment;", "fragment", "", "inject", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertFragment;)V", "Builder", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SelectAdvertDependencies.class}, modules = {SelectAdvertModule.class, DialogModule.class, AdvertItemModule.class, ErrorSnippetItemModule.class, SelectAdvertAnalyticsModule.class, ErrorHelperModule.class, LoadingItemModule.class})
@PerFragment
public interface SelectAdvertComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\b\u0010\u000fJ\u001d\u0010\b\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H'¢\u0006\u0004\b\b\u0010\u0013J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\b\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\b\u0010!J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b\b\u0010$J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b\b\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "", "Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertDependencies;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "with", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", "relay", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "", "hash", "(Ljava/lang/String;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "", "isSubComponent", "withSubComponent", "(Z)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "(Lcom/avito/android/rating/publish/StepListener;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "(Lcom/avito/android/ratings/RatingPublishData;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "(Lcom/avito/android/rating/publish/RatingPublishViewData;)Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent$Builder;", "Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent;", "build", "()Lcom/avito/android/rating/publish/select_advert/di/SelectAdvertComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SelectAdvertComponent build();

        @NotNull
        Builder dependentOn(@NotNull SelectAdvertDependencies selectAdvertDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@NotNull RatingPublishViewData ratingPublishViewData);

        @BindsInstance
        @NotNull
        Builder with(@NotNull StepListener stepListener);

        @BindsInstance
        @NotNull
        Builder with(@NotNull RatingPublishData ratingPublishData);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder with(@NotNull PublishRelay<SelectAdvertAction> publishRelay);

        @BindsInstance
        @NotNull
        Builder with(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withScreen(@ScreenAnalytics @NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder withSubComponent(@ScreenAnalytics boolean z);
    }

    void inject(@NotNull SelectAdvertFragment selectAdvertFragment);
}
