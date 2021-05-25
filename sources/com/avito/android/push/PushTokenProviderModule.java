package com.avito.android.push;

import android.content.Context;
import com.avito.android.push.provider.GcmPushTokenProvider;
import com.avito.android.push.provider.GcmPushTokenProviderImpl;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.push.provider.PushTokenProviderImpl;
import com.avito.android.serviceAvailability.MobileService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/push/PushTokenProviderModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/push/provider/GcmPushTokenProvider;", "gcmPushTokenProvider", "Lcom/avito/android/push/provider/PushTokenProvider;", "providePushTokenProvider", "(Landroid/content/Context;Lcom/avito/android/push/provider/GcmPushTokenProvider;)Lcom/avito/android/push/provider/PushTokenProvider;", "<init>", "()V", "Bindings", "push_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class PushTokenProviderModule {
    @NotNull
    public static final PushTokenProviderModule INSTANCE = new PushTokenProviderModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/push/PushTokenProviderModule$Bindings;", "", "Lcom/avito/android/push/provider/GcmPushTokenProviderImpl;", "impl", "Lcom/avito/android/push/provider/GcmPushTokenProvider;", "bindGcmPushTokenProvider", "(Lcom/avito/android/push/provider/GcmPushTokenProviderImpl;)Lcom/avito/android/push/provider/GcmPushTokenProvider;", "push_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Singleton
        @Binds
        @NotNull
        GcmPushTokenProvider bindGcmPushTokenProvider(@NotNull GcmPushTokenProviderImpl gcmPushTokenProviderImpl);
    }

    @Provides
    @NotNull
    public final PushTokenProvider providePushTokenProvider(@NotNull Context context, @NotNull GcmPushTokenProvider gcmPushTokenProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gcmPushTokenProvider, "gcmPushTokenProvider");
        PushTokenProviderImpl pushTokenProviderImpl = new PushTokenProviderImpl(context);
        pushTokenProviderImpl.registerPushTokenProvider(MobileService.GOOGLE, gcmPushTokenProvider);
        return pushTokenProviderImpl;
    }
}
