package com.avito.android.help_center.help_center_request.di;

import android.webkit.CookieManager;
import com.avito.android.cookie_provider.di.CookieProviderModule;
import com.avito.android.di.PerFragment;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterJSInterfaceImpl;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlInterceptorImpl;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.help_center.HelpCenterUrlProviderImpl;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestModule;", "", "Landroid/webkit/CookieManager;", "provideCookieManager$help_center_release", "()Landroid/webkit/CookieManager;", "provideCookieManager", "<init>", "()V", "Declarations", "help-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, CookieProviderModule.class})
public final class HelpCenterRequestModule {
    @NotNull
    public static final HelpCenterRequestModule INSTANCE = new HelpCenterRequestModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/help_center/help_center_request/di/HelpCenterRequestModule$Declarations;", "", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenterImpl;", "value", "Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "bindsHelpCenterRequestPresenter", "(Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenterImpl;)Lcom/avito/android/help_center/help_center_request/HelpCenterRequestPresenter;", "Lcom/avito/android/help_center/HelpCenterJSInterfaceImpl;", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "bindsHelpCenterJSInterface", "(Lcom/avito/android/help_center/HelpCenterJSInterfaceImpl;)Lcom/avito/android/help_center/HelpCenterJSInterface;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptorImpl;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "bindsHelpCenterUrlInterceptor", "(Lcom/avito/android/help_center/HelpCenterUrlInterceptorImpl;)Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "Lcom/avito/android/help_center/HelpCenterUrlProviderImpl;", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "bindsHelpCenterUrlProvider", "(Lcom/avito/android/help_center/HelpCenterUrlProviderImpl;)Lcom/avito/android/help_center/HelpCenterUrlProvider;", "help-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        HelpCenterJSInterface bindsHelpCenterJSInterface(@NotNull HelpCenterJSInterfaceImpl helpCenterJSInterfaceImpl);

        @PerFragment
        @Binds
        @NotNull
        HelpCenterRequestPresenter bindsHelpCenterRequestPresenter(@NotNull HelpCenterRequestPresenterImpl helpCenterRequestPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        HelpCenterUrlInterceptor bindsHelpCenterUrlInterceptor(@NotNull HelpCenterUrlInterceptorImpl helpCenterUrlInterceptorImpl);

        @PerFragment
        @Binds
        @NotNull
        HelpCenterUrlProvider bindsHelpCenterUrlProvider(@NotNull HelpCenterUrlProviderImpl helpCenterUrlProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CookieManager provideCookieManager$help_center_release() {
        CookieManager instance = CookieManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "CookieManager.getInstance()");
        return instance;
    }
}
