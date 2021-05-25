package com.avito.android.publish.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.PublishContactsScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.html_editor.di.EditorHistoryModule;
import com.avito.android.photo_picker.legacy.di.UploadConverterModule;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.ProfileSourceInteractorImpl;
import com.avito.android.publish.PublishViewModelFactory;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.SubmissionPresenterImpl;
import com.avito.android.publish.WizardParameterForDraftTypeAdapter;
import com.avito.android.publish.analytics.PublishContactsTracker;
import com.avito.android.publish.analytics.PublishContactsTrackerImpl;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractor;
import com.avito.android.publish.draft_onboarding.DraftOnboardingInteractorImpl;
import com.avito.android.publish.draft_onboarding.DraftOnboardingResourceProvider;
import com.avito.android.publish.draft_onboarding.DraftOnboardingResourceProviderImpl;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.PublishMessageHandler;
import com.avito.android.publish.drafts.di.PublishDraftActivityModule;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b;\u0010<J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JY\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J'\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b+\u0010,J\u001f\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u0002042\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u0002082\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0007¢\u0006\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/avito/android/publish/di/PublishModule;", "", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "tracker", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "draftOnboardingInteractor", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/publish/PublishViewModelFactory;", "provideViewModelFactory$publish_release", "(Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/publish/PublishViewModelFactory;", "provideViewModelFactory", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "provideDialogRouter", "(Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "publishAnalyticsDataProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "publishDraftRepository", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "publishDraftDataHolder", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/publish/drafts/PublishMessageHandler;", "publishMessageHandler", "Lcom/avito/android/publish/SubmissionPresenter;", "provideSubmissionPresenter", "(Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/publish/drafts/PublishDraftDataHolder;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/util/BuildInfo;Lcom/google/gson/Gson;Lcom/avito/android/publish/drafts/PublishMessageHandler;)Lcom/avito/android/publish/SubmissionPresenter;", "provideGson", "()Lcom/google/gson/Gson;", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "provideConverter", "()Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/publish/analytics/PublishContactsTracker;", "Lcom/avito/android/publish/ProfileSourceInteractor;", "provideInteractor", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/publish/analytics/PublishContactsTracker;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/ProfileSourceInteractor;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$publish_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "<init>", "()V", "Dependencies", "StateSerializer", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PublishDraftActivityModule.class, UploadConverterModule.class, PublishParametersModule.class, DialogRouterModule.class, GsonModule.class, Dependencies.class, EditorHistoryModule.class, PublishAnalyticModule.class})
public final class PublishModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/di/PublishModule$Dependencies;", "", "Lcom/avito/android/publish/analytics/PublishContactsTrackerImpl;", "tracker", "Lcom/avito/android/publish/analytics/PublishContactsTracker;", "bindTracker", "(Lcom/avito/android/publish/analytics/PublishContactsTrackerImpl;)Lcom/avito/android/publish/analytics/PublishContactsTracker;", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractorImpl;", "interactor", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "provideInteractor", "(Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractorImpl;)Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProvider;", "provideResourceProvider", "(Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProviderImpl;)Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProvider;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerActivity
        @Binds
        @NotNull
        PublishContactsTracker bindTracker(@NotNull PublishContactsTrackerImpl publishContactsTrackerImpl);

        @PerActivity
        @Binds
        @NotNull
        DraftOnboardingInteractor provideInteractor(@NotNull DraftOnboardingInteractorImpl draftOnboardingInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        DraftOnboardingResourceProvider provideResourceProvider(@NotNull DraftOnboardingResourceProviderImpl draftOnboardingResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/di/PublishModule$StateSerializer;", "", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StateSerializer {
    }

    @Provides
    @PerActivity
    @NotNull
    public final CategoryParametersConverter provideConverter() {
        return new CategoryParametersConverter(null, null, null, 7, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ProgressDialogRouter provideDialogRouter(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        return new ProgressDialogRouter(fragmentActivity);
    }

    @Provides
    @NotNull
    @PerActivity
    @StateSerializer
    public final Gson provideGson() {
        Gson create = new GsonBuilder().registerTypeAdapter(WizardParameter.class, new WizardParameterForDraftTypeAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().registerTy…ftTypeAdapter()).create()");
        return create;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ProfileSourceInteractor provideInteractor(@NotNull ProfileApi profileApi, @NotNull PublishContactsTracker publishContactsTracker, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(publishContactsTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ProfileSourceInteractorImpl(profileApi, publishContactsTracker, schedulersFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SubmissionPresenter provideSubmissionPresenter(@NotNull PublishEventTracker publishEventTracker, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishDraftRepository publishDraftRepository, @NotNull PublishDraftDataHolder publishDraftDataHolder, @NotNull PublishDraftWiper publishDraftWiper, @NotNull BuildInfo buildInfo, @StateSerializer @NotNull Gson gson, @NotNull PublishMessageHandler publishMessageHandler) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "publishAnalyticsDataProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishDraftRepository, "publishDraftRepository");
        Intrinsics.checkNotNullParameter(publishDraftDataHolder, "publishDraftDataHolder");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(publishMessageHandler, "publishMessageHandler");
        return new SubmissionPresenterImpl(schedulersFactory, publishEventTracker, publishAnalyticsDataProvider, publishDraftRepository, publishDraftWiper, publishDraftDataHolder, gson, buildInfo, publishMessageHandler);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PublishViewModelFactory provideViewModelFactory$publish_release(@NotNull PublishEventTracker publishEventTracker, @NotNull DraftOnboardingInteractor draftOnboardingInteractor, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(draftOnboardingInteractor, "draftOnboardingInteractor");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new PublishViewModelFactory(draftOnboardingInteractor, buildInfo, publishEventTracker);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$publish_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, PublishContactsScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(PublishContactsScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, PublishContactsScreen.INSTANCE, timerFactory, null, 4, null);
    }
}
