package com.avito.android.in_app_calls.di;

import android.os.IBinder;
import com.avito.android.di.PerService;
import com.avito.android.in_app_calls.service.CallInfoLoader;
import com.avito.android.in_app_calls.service.CallInfoLoaderImpl;
import com.avito.android.in_app_calls.service.CallInfoSender;
import com.avito.android.in_app_calls.service.CallInfoSenderImpl;
import com.avito.android.in_app_calls.service.CallNotificationsDelegate;
import com.avito.android.in_app_calls.service.CallNotificationsDelegateImpl;
import com.avito.android.in_app_calls.service.CallReconnectHandler;
import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import com.avito.android.in_app_calls.service.ReconnectClient;
import com.avito.android.in_app_calls.service.ReconnectClientImpl;
import com.avito.android.in_app_calls.service.RingtoneDelegate;
import com.avito.android.in_app_calls.service.RingtoneDelegateImpl;
import com.avito.android.in_app_calls.service.binder.LocalCallManagerServiceBinder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallManagerServiceModule;", "", "Lcom/avito/android/in_app_calls/service/ReconnectClient;", "provideReconnectClient", "()Lcom/avito/android/in_app_calls/service/ReconnectClient;", "<init>", "()V", "Declarations", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CallManagerServiceModule {
    @NotNull
    public static final CallManagerServiceModule INSTANCE = new CallManagerServiceModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallManagerServiceModule$Declarations;", "", "Lcom/avito/android/in_app_calls/service/CallNotificationsDelegateImpl;", "impl", "Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "bindCallNotificationsDelegate", "(Lcom/avito/android/in_app_calls/service/CallNotificationsDelegateImpl;)Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "Lcom/avito/android/in_app_calls/service/binder/LocalCallManagerServiceBinder;", "Landroid/os/IBinder;", "bindCallManagerServiceBinder", "(Lcom/avito/android/in_app_calls/service/binder/LocalCallManagerServiceBinder;)Landroid/os/IBinder;", "Lcom/avito/android/in_app_calls/service/RingtoneDelegateImpl;", "Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "bindRingtoneDelegate", "(Lcom/avito/android/in_app_calls/service/RingtoneDelegateImpl;)Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "Lcom/avito/android/in_app_calls/service/CallInfoSenderImpl;", "Lcom/avito/android/in_app_calls/service/CallInfoSender;", "bindCallRegistrator", "(Lcom/avito/android/in_app_calls/service/CallInfoSenderImpl;)Lcom/avito/android/in_app_calls/service/CallInfoSender;", "Lcom/avito/android/in_app_calls/service/CallInfoLoaderImpl;", "Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "bindCallInfoLoader", "(Lcom/avito/android/in_app_calls/service/CallInfoLoaderImpl;)Lcom/avito/android/in_app_calls/service/CallInfoLoader;", "Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl;", "Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", "bindCallReconnectHandler", "(Lcom/avito/android/in_app_calls/service/CallReconnectHandlerImpl;)Lcom/avito/android/in_app_calls/service/CallReconnectHandler;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerService
        @Binds
        @NotNull
        CallInfoLoader bindCallInfoLoader(@NotNull CallInfoLoaderImpl callInfoLoaderImpl);

        @PerService
        @Binds
        @NotNull
        IBinder bindCallManagerServiceBinder(@NotNull LocalCallManagerServiceBinder localCallManagerServiceBinder);

        @PerService
        @Binds
        @NotNull
        CallNotificationsDelegate bindCallNotificationsDelegate(@NotNull CallNotificationsDelegateImpl callNotificationsDelegateImpl);

        @PerService
        @Binds
        @NotNull
        CallReconnectHandler bindCallReconnectHandler(@NotNull CallReconnectHandlerImpl callReconnectHandlerImpl);

        @PerService
        @Binds
        @NotNull
        CallInfoSender bindCallRegistrator(@NotNull CallInfoSenderImpl callInfoSenderImpl);

        @PerService
        @Binds
        @NotNull
        RingtoneDelegate bindRingtoneDelegate(@NotNull RingtoneDelegateImpl ringtoneDelegateImpl);
    }

    @PerService
    @Provides
    @NotNull
    public final ReconnectClient provideReconnectClient() {
        return new ReconnectClientImpl(new OkHttpClient());
    }
}
