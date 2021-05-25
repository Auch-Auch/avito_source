package com.avito.android.player.presenter.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.player.di.PlayerMediaBockType;
import com.avito.android.player.di.PlayerMediaSlug;
import com.avito.android.player.di.PlayerMediaUrl;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor;
import com.avito.android.player.presenter.analytics.events.PlayerCloseEvent;
import com.avito.android.player.presenter.analytics.events.PlayerFastForwardEvent;
import com.avito.android.player.presenter.analytics.events.PlayerMediaCompleteEvent;
import com.avito.android.player.presenter.analytics.events.PlayerMediaFirstQuartileEvent;
import com.avito.android.player.presenter.analytics.events.PlayerMediaMidpointEvent;
import com.avito.android.player.presenter.analytics.events.PlayerMediaStartEvent;
import com.avito.android.player.presenter.analytics.events.PlayerMediaThirdQuartileEvent;
import com.avito.android.player.presenter.analytics.events.PlayerPauseEvent;
import com.avito.android.player.presenter.analytics.events.PlayerResumeEvent;
import com.avito.android.player.presenter.analytics.events.PlayerRewindEvent;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0014\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nR\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001b\u0010+\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018¨\u0006."}, d2 = {"Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractorImpl;", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor;", "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "saveState", "()Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "state", "", "restoreState", "(Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;)V", "trackClose", "()V", "trackRewind", "trackFastForward", "trackPause", "trackResume", "trackMediaStartIfNeeded", "trackMediaFirstQuartileIfNeeded", "trackMediaMidpointIfNeeded", "trackMediaThirdQuartileIfNeeded", "trackMediaCompleteIfNeeded", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", AuthSource.SEND_ABUSE, "Lcom/avito/android/player/presenter/analytics/PlayerAnalyticsInteractor$State;", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/rec/ScreenSource;", "e", "Lcom/avito/android/rec/ScreenSource;", "getScreenSource", "()Lcom/avito/android/rec/ScreenSource;", "screenSource", "d", "getBlockType", "blockType", "c", "getSlug", "slug", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/rec/ScreenSource;Lcom/avito/android/analytics/Analytics;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerAnalyticsInteractorImpl implements PlayerAnalyticsInteractor {
    public PlayerAnalyticsInteractor.State a = new PlayerAnalyticsInteractor.State(false, false, false, false, false, 31, null);
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final ScreenSource e;
    public final Analytics f;

    @Inject
    public PlayerAnalyticsInteractorImpl(@PlayerMediaUrl @NotNull String str, @PlayerMediaSlug @Nullable String str2, @PlayerMediaBockType @Nullable String str3, @NotNull ScreenSource screenSource, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = screenSource;
        this.f = analytics;
    }

    @Nullable
    public final String getBlockType() {
        return this.d;
    }

    @NotNull
    public final ScreenSource getScreenSource() {
        return this.e;
    }

    @Nullable
    public final String getSlug() {
        return this.c;
    }

    @NotNull
    public final String getUrl() {
        return this.b;
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void restoreState(@NotNull PlayerAnalyticsInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    @NotNull
    public PlayerAnalyticsInteractor.State saveState() {
        return this.a;
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackClose() {
        this.f.track(new PlayerCloseEvent(this.b, this.e, this.d, this.c));
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackFastForward() {
        this.f.track(new PlayerFastForwardEvent(this.b, this.e, this.d, this.c));
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackMediaCompleteIfNeeded() {
        if (!this.a.isMediaCompleteTracked()) {
            this.a.setMediaCompleteTracked(true);
            this.f.track(new PlayerMediaCompleteEvent(this.b, this.e, this.d, this.c));
        }
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackMediaFirstQuartileIfNeeded() {
        if (!this.a.isMediaFirstQuartileTracked()) {
            this.a.setMediaFirstQuartileTracked(true);
            this.f.track(new PlayerMediaFirstQuartileEvent(this.b, this.e, this.d, this.c));
        }
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackMediaMidpointIfNeeded() {
        if (!this.a.isMediaMidpointTracked()) {
            this.a.setMediaMidpointTracked(true);
            this.f.track(new PlayerMediaMidpointEvent(this.b, this.e, this.d, this.c));
        }
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackMediaStartIfNeeded() {
        if (!this.a.isMediaStartTracked()) {
            this.a.setMediaStartTracked(true);
            this.f.track(new PlayerMediaStartEvent(this.b, this.e, this.d, this.c));
        }
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackMediaThirdQuartileIfNeeded() {
        if (!this.a.isMediaThirdQuartileTracked()) {
            this.a.setMediaThirdQuartileTracked(true);
            this.f.track(new PlayerMediaThirdQuartileEvent(this.b, this.e, this.d, this.c));
        }
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackPause() {
        this.f.track(new PlayerPauseEvent(this.b, this.e, this.d, this.c));
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackResume() {
        this.f.track(new PlayerResumeEvent(this.b, this.e, this.d, this.c));
    }

    @Override // com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor
    public void trackRewind() {
        this.f.track(new PlayerRewindEvent(this.b, this.e, this.d, this.c));
    }
}
