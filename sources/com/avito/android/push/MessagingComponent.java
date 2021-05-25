package com.avito.android.push;

import androidx.core.app.NotificationCompat;
import com.avito.android.di.PerService;
import com.avito.android.push.debug.DebugMessagingReceiver;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/push/MessagingComponent;", "", "Lcom/avito/android/push/MessagingService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/push/MessagingService;)V", "Lcom/avito/android/push/debug/DebugMessagingReceiver;", "receiver", "(Lcom/avito/android/push/debug/DebugMessagingReceiver;)V", "Builder", "push_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {MessagingDependencies.class}, modules = {MessagingModule.class})
public interface MessagingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/push/MessagingComponent$Builder;", "", "Lcom/avito/android/push/MessagingDependencies;", "dependencies", "Lcom/avito/android/push/MessagingComponent;", "create", "(Lcom/avito/android/push/MessagingDependencies;)Lcom/avito/android/push/MessagingComponent;", "push_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Builder {
        @NotNull
        MessagingComponent create(@NotNull MessagingDependencies messagingDependencies);
    }

    void inject(@NotNull MessagingService messagingService);

    void inject(@NotNull DebugMessagingReceiver debugMessagingReceiver);
}
