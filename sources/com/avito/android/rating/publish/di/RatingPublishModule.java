package com.avito.android.rating.publish.di;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Looper;
import com.avito.android.analytics.screens.RatingPublishScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerActivity;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.rating.publish.RatingPublishInteractor;
import com.avito.android.rating.publish.RatingPublishInteractorImpl;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import com.avito.android.rating.publish.tracker.RatingPublishTracker;
import com.avito.android.rating.publish.tracker.RatingPublishTrackerImpl;
import com.avito.android.util.BuildInfo;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/rating/publish/di/RatingPublishModule;", "", "Landroid/app/Activity;", "activity", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor$rating_release", "(Landroid/app/Activity;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "provideScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "provideScreenDiInjectTracker$rating_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "provideScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "provideScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class RatingPublishModule {
    @NotNull
    public static final RatingPublishModule INSTANCE = new RatingPublishModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/rating/publish/di/RatingPublishModule$Declarations;", "", "Lcom/avito/android/rating/publish/RatingPublishInteractorImpl;", "interactor", "Lcom/avito/android/rating/publish/RatingPublishInteractor;", "bindRatingPublishInteractor", "(Lcom/avito/android/rating/publish/RatingPublishInteractorImpl;)Lcom/avito/android/rating/publish/RatingPublishInteractor;", "Lcom/avito/android/rating/publish/RatingPublishPresenterImpl;", "presenter", "Lcom/avito/android/rating/publish/RatingPublishPresenter;", "bindRatingPublishPresenter", "(Lcom/avito/android/rating/publish/RatingPublishPresenterImpl;)Lcom/avito/android/rating/publish/RatingPublishPresenter;", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;", "recovery", "Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "bindScreenTransferRecovery", "(Lcom/avito/android/analytics/screens/ScreenTransferRecovery$Impl;)Lcom/avito/android/analytics/screens/ScreenTransferRecovery;", "Lcom/avito/android/rating/publish/tracker/RatingPublishTrackerImpl;", "tracker", "Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "bindRatingPublishTracker", "(Lcom/avito/android/rating/publish/tracker/RatingPublishTrackerImpl;)Lcom/avito/android/rating/publish/tracker/RatingPublishTracker;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        RatingPublishInteractor bindRatingPublishInteractor(@NotNull RatingPublishInteractorImpl ratingPublishInteractorImpl);

        @Binds
        @NotNull
        RatingPublishPresenter bindRatingPublishPresenter(@NotNull RatingPublishPresenterImpl ratingPublishPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        RatingPublishTracker bindRatingPublishTracker(@NotNull RatingPublishTrackerImpl ratingPublishTrackerImpl);

        @PerActivity
        @Binds
        @NotNull
        ScreenTransferRecovery bindScreenTransferRecovery(@NotNull ScreenTransferRecovery.Impl impl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PhotoInteractor providePhotoInteractor$rating_release(@NotNull Activity activity, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Looper mainLooper = activity.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "activity.mainLooper");
        ContentResolver contentResolver = activity.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "activity.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ScreenDiInjectTracker provideScreenDiInjectTracker$rating_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, RatingPublishScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ScreenFlowTrackerProvider provideScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(RatingPublishScreen.INSTANCE, timerFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ScreenInitTracker provideScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, RatingPublishScreen.INSTANCE, timerFactory, null, 4, null);
    }
}
