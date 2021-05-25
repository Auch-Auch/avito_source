package com.avito.android.stories;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/stories/StartupBannerInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/stories/StartupStoryBanner;", "startupBanner", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/stories/StartupBannerLocker;", "lockStartupBanner", "()Lcom/avito/android/stories/StartupBannerLocker;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface StartupBannerInteractor {
    @NotNull
    StartupBannerLocker lockStartupBanner();

    @NotNull
    Observable<StartupStoryBanner> startupBanner();
}
