package com.avito.android.messenger.di;

import androidx.core.app.NotificationCompat;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerService;
import com.avito.android.messenger.conversation.mvi.sync.MessageIsReadMarkerWorker;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {MessageIsReadMarkerDependencies.class}, modules = {MessageIsReadMarkerModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/di/MessageIsReadMarkerComponent;", "", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerService;", NotificationCompat.CATEGORY_SERVICE, "", "inject", "(Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerService;)V", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerWorker;", "worker", "(Lcom/avito/android/messenger/conversation/mvi/sync/MessageIsReadMarkerWorker;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageIsReadMarkerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/di/MessageIsReadMarkerComponent$Builder;", "", "Lcom/avito/android/messenger/di/MessageIsReadMarkerDependencies;", "dependencies", "messageIsReadMarkerDependencies", "(Lcom/avito/android/messenger/di/MessageIsReadMarkerDependencies;)Lcom/avito/android/messenger/di/MessageIsReadMarkerComponent$Builder;", "Lcom/avito/android/messenger/di/MessageIsReadMarkerComponent;", "build", "()Lcom/avito/android/messenger/di/MessageIsReadMarkerComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        MessageIsReadMarkerComponent build();

        @NotNull
        Builder messageIsReadMarkerDependencies(@NotNull MessageIsReadMarkerDependencies messageIsReadMarkerDependencies);
    }

    void inject(@NotNull MessageIsReadMarkerService messageIsReadMarkerService);

    void inject(@NotNull MessageIsReadMarkerWorker messageIsReadMarkerWorker);
}
