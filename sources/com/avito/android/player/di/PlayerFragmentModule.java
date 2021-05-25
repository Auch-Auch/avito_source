package com.avito.android.player.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.player.presenter.PlayerPresenter;
import com.avito.android.player.presenter.PlayerPresenterImpl;
import com.avito.android.player.presenter.PlayerResourcesProvider;
import com.avito.android.player.presenter.PlayerResourcesProviderImpl;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractorImpl;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import com.avito.android.player.presenter.tracker.PlayerTrackerImpl;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.CallAdapterFactoryResourceProviderImpl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/player/di/PlayerFragmentModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "provideCallAdapterResourceProvider$player_release", "(Landroid/app/Application;)Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "provideCallAdapterResourceProvider", "Landroid/content/Context;", "context", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "provideSimpleExoPlayer$player_release", "(Landroid/content/Context;)Lcom/google/android/exoplayer2/SimpleExoPlayer;", "provideSimpleExoPlayer", "<init>", "()V", "Declarations", "player_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PlayerFragmentModule {
    @NotNull
    public static final PlayerFragmentModule INSTANCE = new PlayerFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/player/di/PlayerFragmentModule$Declarations;", "", "Lcom/avito/android/player/presenter/PlayerPresenterImpl;", "presenter", "Lcom/avito/android/player/presenter/PlayerPresenter;", "playerPresenter", "(Lcom/avito/android/player/presenter/PlayerPresenterImpl;)Lcom/avito/android/player/presenter/PlayerPresenter;", "Lcom/avito/android/player/presenter/PlayerResourcesProviderImpl;", "resourceProvider", "Lcom/avito/android/player/presenter/PlayerResourcesProvider;", "playerResourceProvider", "(Lcom/avito/android/player/presenter/PlayerResourcesProviderImpl;)Lcom/avito/android/player/presenter/PlayerResourcesProvider;", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractorImpl;", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "playerAnalyticsInteractor", "(Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractorImpl;)Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "Lcom/avito/android/player/presenter/tracker/PlayerTrackerImpl;", "tracker", "Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "bindPlayerTracker", "(Lcom/avito/android/player/presenter/tracker/PlayerTrackerImpl;)Lcom/avito/android/player/presenter/tracker/PlayerTracker;", "player_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        PlayerTracker bindPlayerTracker(@NotNull PlayerTrackerImpl playerTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        PlayerAnalyticsInteractor playerAnalyticsInteractor(@NotNull PlayerAnalyticsInteractorImpl playerAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        PlayerPresenter playerPresenter(@NotNull PlayerPresenterImpl playerPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PlayerResourcesProvider playerResourceProvider(@NotNull PlayerResourcesProviderImpl playerResourcesProviderImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CallAdapterFactoryResourceProvider provideCallAdapterResourceProvider$player_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return new CallAdapterFactoryResourceProviderImpl(resources);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleExoPlayer provideSimpleExoPlayer$player_release(@ViewContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SimpleExoPlayer build = new SimpleExoPlayer.Builder(context).setTrackSelector(new DefaultTrackSelector(context)).build();
        Intrinsics.checkNotNullExpressionValue(build, "SimpleExoPlayer.Builder(…tor)\n            .build()");
        return build;
    }
}
