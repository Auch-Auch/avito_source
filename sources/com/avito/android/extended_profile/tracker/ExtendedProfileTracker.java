package com.avito.android.extended_profile.tracker;

import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "", "", "durationMs", "", "trackDiInject", "(J)V", "startInit", "()V", "trackInit", "startProfileLoading", "trackProfileLoaded", "trackProfileLoadError", "startProfilePreparing", "trackProfilePreparing", "startProfileDraw", "trackProfileDraw", "trackProfileErrorDraw", "startExtendedProfileLoading", "trackExtendedProfileLoaded", "trackExtendedProfileLoadError", "startExtendedProfilePreparing", "trackExtendedProfilePreparing", "trackExtendedProfileErrorPreparing", "startExtendedProfileDraw", "trackExtendedProfileDraw", "trackExtendedProfileErrorDraw", "stopTracking", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "TrackFlow", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ExtendedProfileTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;", "", "<init>", "(Ljava/lang/String;I)V", "PROFILE_SUCCESS", "PROFILE_FAILURE", "EXTENDED_PROFILE_SUCCESS", "EXTENDED_PROFILE_FAILURE", "SKIP_TRACKING", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public enum TrackFlow {
        PROFILE_SUCCESS,
        PROFILE_FAILURE,
        EXTENDED_PROFILE_SUCCESS,
        EXTENDED_PROFILE_FAILURE,
        SKIP_TRACKING
    }

    void recover(@NotNull ScreenTransfer screenTransfer);

    void startExtendedProfileDraw();

    void startExtendedProfileLoading();

    void startExtendedProfilePreparing();

    void startInit();

    void startProfileDraw();

    void startProfileLoading();

    void startProfilePreparing();

    void stopTracking();

    void trackDiInject(long j);

    void trackExtendedProfileDraw();

    void trackExtendedProfileErrorDraw();

    void trackExtendedProfileErrorPreparing();

    void trackExtendedProfileLoadError();

    void trackExtendedProfileLoaded();

    void trackExtendedProfilePreparing();

    void trackInit();

    void trackProfileDraw();

    void trackProfileErrorDraw();

    void trackProfileLoadError();

    void trackProfileLoaded();

    void trackProfilePreparing();
}
