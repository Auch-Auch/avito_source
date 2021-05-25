package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.app.ActivityProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.interceptors.FirewallErrorInterceptor;
import com.avito.android.remote.interceptors.FirewallErrorRouter;
import com.avito.android.remote.interceptors.FirewallErrorRouterImpl;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/di/module/FirewallErrorModule;", "", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/remote/interceptors/FirewallErrorRouter;", "router", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/remote/interceptors/FirewallErrorInterceptor;", "provideFirewallErrorInterceptor", "(Lcom/google/gson/Gson;Lcom/avito/android/remote/interceptors/FirewallErrorRouter;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/remote/interceptors/FirewallErrorInterceptor;", "Lcom/avito/android/app/ActivityProvider;", "activityProvider", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "intentFactory", "provideFirewallErrorRouter", "(Lcom/avito/android/app/ActivityProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)Lcom/avito/android/remote/interceptors/FirewallErrorRouter;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FirewallErrorModule {
    @NotNull
    public static final FirewallErrorModule INSTANCE = new FirewallErrorModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final FirewallErrorInterceptor provideFirewallErrorInterceptor(@NotNull Gson gson, @NotNull FirewallErrorRouter firewallErrorRouter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(firewallErrorRouter, "router");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new FirewallErrorInterceptor(gson, firewallErrorRouter, analytics);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final FirewallErrorRouter provideFirewallErrorRouter(@NotNull ActivityProvider activityProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "intentFactory");
        return new FirewallErrorRouterImpl(activityProvider, deepLinkIntentFactory);
    }
}
