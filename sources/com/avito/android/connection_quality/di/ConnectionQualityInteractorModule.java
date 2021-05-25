package com.avito.android.connection_quality.di;

import android.app.Application;
import android.net.ConnectivityManager;
import com.avito.android.connection_quality.ConnectionManager;
import com.avito.android.connection_quality.ConnectionQualityInteractor;
import com.avito.android.connection_quality.ConnectionQualityInteractorImpl;
import com.avito.android.connection_quality.ConnectionQualitySubscriber;
import com.avito.android.connection_quality.ConnectionQualitySubscriberImpl;
import com.avito.android.connection_quality.NetworkInfoBroadcastReceiver;
import com.avito.android.connection_quality.NetworkInfoChangeListener;
import com.avito.android.connection_quality.SafeConnectionManager;
import com.facebook.network.connectionclass.ConnectionClassManager;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.IntoSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0018\u001a\u00020\u00152\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00130\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010 \u001a\u00020\bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010%\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/connection_quality/di/ConnectionQualityInteractorModule;", "", "Lcom/avito/android/connection_quality/ConnectionManager;", "provideConnectionManager$connection_quality_release", "()Lcom/avito/android/connection_quality/ConnectionManager;", "provideConnectionManager", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lcom/facebook/network/connectionclass/ConnectionClassManager;", "connectionClassManager", "Lcom/avito/android/connection_quality/ConnectionQualityInteractor;", "provideConnectionQualityInteractor$connection_quality_release", "(Landroid/net/ConnectivityManager;Lcom/facebook/network/connectionclass/ConnectionClassManager;)Lcom/avito/android/connection_quality/ConnectionQualityInteractor;", "provideConnectionQualityInteractor", "connectionQualityInteractor", "Lcom/avito/android/connection_quality/NetworkInfoChangeListener;", "provideConnectionQualityNetworkListener", "(Lcom/avito/android/connection_quality/ConnectionQualityInteractor;)Lcom/avito/android/connection_quality/NetworkInfoChangeListener;", "", "Lkotlin/jvm/JvmSuppressWildcards;", "observers", "Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "provideNetworkInfoBroadcastReceiver$connection_quality_release", "(Ljava/util/Set;)Lcom/avito/android/connection_quality/NetworkInfoBroadcastReceiver;", "provideNetworkInfoBroadcastReceiver", "Landroid/app/Application;", "app", "provideConnectivityManager$connection_quality_release", "(Landroid/app/Application;)Landroid/net/ConnectivityManager;", "provideConnectivityManager", "provideConnectionClassManager$connection_quality_release", "()Lcom/facebook/network/connectionclass/ConnectionClassManager;", "provideConnectionClassManager", "interactor", "Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "provideConnectionClassSubscriber$connection_quality_release", "(Lcom/avito/android/connection_quality/ConnectionManager;Lcom/avito/android/connection_quality/ConnectionQualityInteractor;)Lcom/avito/android/connection_quality/ConnectionQualitySubscriber;", "provideConnectionClassSubscriber", "<init>", "()V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ConnectionQualityInteractorModule {
    @Provides
    @Reusable
    @NotNull
    public final ConnectionClassManager provideConnectionClassManager$connection_quality_release() {
        ConnectionClassManager instance = ConnectionClassManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "ConnectionClassManager.getInstance()");
        return instance;
    }

    @Provides
    @Reusable
    @NotNull
    public final ConnectionQualitySubscriber provideConnectionClassSubscriber$connection_quality_release(@NotNull ConnectionManager connectionManager, @NotNull ConnectionQualityInteractor connectionQualityInteractor) {
        Intrinsics.checkNotNullParameter(connectionManager, "connectionClassManager");
        Intrinsics.checkNotNullParameter(connectionQualityInteractor, "interactor");
        return new ConnectionQualitySubscriberImpl(connectionManager, connectionQualityInteractor);
    }

    @Provides
    @Reusable
    @NotNull
    public final ConnectionManager provideConnectionManager$connection_quality_release() {
        ConnectionClassManager instance = ConnectionClassManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "ConnectionClassManager.getInstance()");
        return new SafeConnectionManager(instance);
    }

    @Provides
    @Reusable
    @NotNull
    public final ConnectionQualityInteractor provideConnectionQualityInteractor$connection_quality_release(@NotNull ConnectivityManager connectivityManager, @NotNull ConnectionClassManager connectionClassManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        Intrinsics.checkNotNullParameter(connectionClassManager, "connectionClassManager");
        return new ConnectionQualityInteractorImpl(connectivityManager, connectionClassManager);
    }

    @Provides
    @Reusable
    @IntoSet
    @NotNull
    public final NetworkInfoChangeListener provideConnectionQualityNetworkListener(@NotNull ConnectionQualityInteractor connectionQualityInteractor) {
        Intrinsics.checkNotNullParameter(connectionQualityInteractor, "connectionQualityInteractor");
        return connectionQualityInteractor;
    }

    @Provides
    @Reusable
    @NotNull
    public final ConnectivityManager provideConnectivityManager$connection_quality_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "app");
        Object systemService = application.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    @Provides
    @Reusable
    @NotNull
    public final NetworkInfoBroadcastReceiver provideNetworkInfoBroadcastReceiver$connection_quality_release(@NotNull Set<NetworkInfoChangeListener> set) {
        Intrinsics.checkNotNullParameter(set, "observers");
        return new NetworkInfoBroadcastReceiver(set);
    }
}
