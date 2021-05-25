package com.avito.android.notification_center.push;

import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/notification_center/push/NcPushClicksModule;", "", "Lcom/avito/android/notification_center/push/NcPushClicksImpl;", "impl", "Lcom/avito/android/notification_center/push/NcPushClicks;", "bindPushClicks", "(Lcom/avito/android/notification_center/push/NcPushClicksImpl;)Lcom/avito/android/notification_center/push/NcPushClicks;", "pushClicks", "Lcom/avito/android/notification_center/push/NcPushClicksInteractor;", "bindPushClicksInteractor", "(Lcom/avito/android/notification_center/push/NcPushClicks;)Lcom/avito/android/notification_center/push/NcPushClicksInteractor;", "Lcom/avito/android/notification_center/push/NcPushClicksListener;", "bindPushClicksListener", "(Lcom/avito/android/notification_center/push/NcPushClicks;)Lcom/avito/android/notification_center/push/NcPushClicksListener;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface NcPushClicksModule {
    @Singleton
    @Binds
    @NotNull
    NcPushClicks bindPushClicks(@NotNull NcPushClicksImpl ncPushClicksImpl);

    @Singleton
    @Binds
    @NotNull
    NcPushClicksInteractor bindPushClicksInteractor(@NotNull NcPushClicks ncPushClicks);

    @Singleton
    @Binds
    @NotNull
    NcPushClicksListener bindPushClicksListener(@NotNull NcPushClicks ncPushClicks);
}
