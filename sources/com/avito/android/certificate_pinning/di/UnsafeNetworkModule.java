package com.avito.android.certificate_pinning.di;

import com.avito.android.certificate_pinning.UnsafeNetworkInteractor;
import com.avito.android.certificate_pinning.UnsafeNetworkInteractorImpl;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenter;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.session_refresh.RequestParamsInterceptorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/certificate_pinning/di/UnsafeNetworkModule;", "", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenterImpl;", "interactor", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "bindUnsafeNetworkPresenter", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenterImpl;)Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractorImpl;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;", "bindUnsafeNetworkInteractor", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractorImpl;)Lcom/avito/android/certificate_pinning/UnsafeNetworkInteractor;", "Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "interceptor", "Lokhttp3/Interceptor;", "bindCertificatePinningInterceptor", "(Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;)Lokhttp3/Interceptor;", "Lcom/avito/android/session_refresh/RequestParamsInterceptorImpl;", "bindRequestParamsInterceptor", "(Lcom/avito/android/session_refresh/RequestParamsInterceptorImpl;)Lokhttp3/Interceptor;", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "bindUserAgentInterceptor", "(Lcom/avito/android/remote/interceptor/UserAgentInterceptor;)Lokhttp3/Interceptor;", "Silent", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface UnsafeNetworkModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/certificate_pinning/di/UnsafeNetworkModule$Silent;", "", "<init>", "()V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Silent {
    }

    @Binds
    @IntoSet
    @NotNull
    @Silent
    @PerActivity
    Interceptor bindCertificatePinningInterceptor(@NotNull CertificatePinningInterceptor certificatePinningInterceptor);

    @Binds
    @IntoSet
    @NotNull
    @Silent
    @PerActivity
    Interceptor bindRequestParamsInterceptor(@NotNull RequestParamsInterceptorImpl requestParamsInterceptorImpl);

    @PerActivity
    @Binds
    @NotNull
    UnsafeNetworkInteractor bindUnsafeNetworkInteractor(@NotNull UnsafeNetworkInteractorImpl unsafeNetworkInteractorImpl);

    @PerActivity
    @Binds
    @NotNull
    UnsafeNetworkPresenter bindUnsafeNetworkPresenter(@NotNull UnsafeNetworkPresenterImpl unsafeNetworkPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    @Silent
    @PerActivity
    Interceptor bindUserAgentInterceptor(@NotNull UserAgentInterceptor userAgentInterceptor);
}
