package com.avito.android.stories.di;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.CookieProviderImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.interceptor.FingerprintHeaderProvider;
import com.avito.android.stories.LocalStartupBannerInteractor;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StoriesInteractor;
import com.avito.android.stories.StoriesInteractorImpl;
import com.avito.android.stories.adapter.StoriesItemPresenter;
import com.avito.android.stories.adapter.StoriesItemPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/stories/di/StoriesModule;", "", "Landroid/webkit/CookieManager;", "provideCookieManager$serp_core_release", "()Landroid/webkit/CookieManager;", "provideCookieManager", "Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;", "fingerPrintHeaderProvider", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "cookieExpiredTime", "Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider$serp_core_release", "(Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;Lcom/avito/android/cookie_provider/CookieExpiredTime;)Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider", "<init>", "()V", "Dependencies", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class StoriesModule {
    @NotNull
    public static final StoriesModule INSTANCE = new StoriesModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/stories/di/StoriesModule$Dependencies;", "", "Lcom/avito/android/stories/StoriesInteractorImpl;", "interactor", "Lcom/avito/android/stories/StoriesInteractor;", "bindStoriesInteractor", "(Lcom/avito/android/stories/StoriesInteractorImpl;)Lcom/avito/android/stories/StoriesInteractor;", "Lcom/avito/android/stories/adapter/StoriesItemPresenterImpl;", "itemPresenter", "Lcom/avito/android/stories/adapter/StoriesItemPresenter;", "bindStoriesItemPresenter", "(Lcom/avito/android/stories/adapter/StoriesItemPresenterImpl;)Lcom/avito/android/stories/adapter/StoriesItemPresenter;", "Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;", "time", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "bindCookieExpiredTime", "(Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;)Lcom/avito/android/cookie_provider/CookieExpiredTime;", "Lcom/avito/android/stories/LocalStartupBannerInteractor;", "Lcom/avito/android/stories/StartupBannerInteractor;", "bindStartupBannerInteractor", "(Lcom/avito/android/stories/LocalStartupBannerInteractor;)Lcom/avito/android/stories/StartupBannerInteractor;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @Binds
        @NotNull
        CookieExpiredTime bindCookieExpiredTime(@NotNull CookieExpiredTimeImpl cookieExpiredTimeImpl);

        @PerFragment
        @Binds
        @NotNull
        StartupBannerInteractor bindStartupBannerInteractor(@NotNull LocalStartupBannerInteractor localStartupBannerInteractor);

        @Binds
        @NotNull
        StoriesInteractor bindStoriesInteractor(@NotNull StoriesInteractorImpl storiesInteractorImpl);

        @Binds
        @NotNull
        StoriesItemPresenter bindStoriesItemPresenter(@NotNull StoriesItemPresenterImpl storiesItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CookieManager provideCookieManager$serp_core_release() {
        CookieManager instance = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "CookieManager.getInstance()");
        return instance;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CookieProvider provideCookieProvider$serp_core_release(@NotNull FingerprintHeaderProvider fingerprintHeaderProvider, @NotNull CookieExpiredTime cookieExpiredTime) {
        Intrinsics.checkNotNullParameter(fingerprintHeaderProvider, "fingerPrintHeaderProvider");
        Intrinsics.checkNotNullParameter(cookieExpiredTime, "cookieExpiredTime");
        return new CookieProviderImpl(d.listOf(fingerprintHeaderProvider), cookieExpiredTime);
    }
}
