package com.avito.android;

import android.app.Application;
import android.content.ContentResolver;
import android.os.Looper;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.app.task.LocalMessageSender;
import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.app.task.MessageSendingTrackerFactory;
import com.avito.android.app.task.MessageSendingTrackerFactoryImpl;
import com.avito.android.app.task.PendingMessageHandler;
import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.sync.MessageBodyResolver;
import com.avito.android.messenger.di.MessengerRepoModule;
import com.avito.android.messenger.service.ImageUploadStarter;
import com.avito.android.messenger.service.ImageUploadStarterImpl;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:Jr\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0007\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b)\u0010*Jj\u00107\u001a\u00020\n2\u0011\u0010\u0007\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020(2\u0006\u00104\u001a\u0002032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/avito/android/PendingMessageHandlerModule;", "", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "client", "Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;", "messageRepo", "Lcom/avito/android/app/task/LocalMessageSender;", "messageSender", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/app/task/MessageSendingTrackerFactory;", "trackerFactory", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "errorTracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "Lcom/avito/android/app/task/PendingMessageHandler;", "providePendingMessageHandler", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/conversation/mvi/data/MessageRepo;Lcom/avito/android/app/task/LocalMessageSender;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/app/task/MessageSendingTrackerFactory;Lcom/avito/android/messenger/analytics/MessengerErrorTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/NetworkTypeProvider;)Lcom/avito/android/app/task/PendingMessageHandler;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "provideMessageSendingTrackerFactory", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/app/task/MessageSendingTrackerFactory;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/messenger/service/ImageUploadStarter;", "provideImageUploadStarter", "(Landroid/app/Application;Lcom/avito/android/ServiceIntentFactory;)Lcom/avito/android/messenger/service/ImageUploadStarter;", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "(Lcom/avito/android/util/BuildInfo;Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "fileUploadInteractor", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;", "messageBodyResolver", "Lcom/avito/android/messenger/MessengerEntityConverter;", "converter", "imageUploadStarter", "photoInteractor", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "photoStorage", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "canceller", "provideLocalMessageSender", "(Lru/avito/messenger/MessengerClient;Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;Lcom/avito/android/messenger/conversation/mvi/sync/MessageBodyResolver;Lcom/avito/android/messenger/MessengerEntityConverter;Lcom/avito/android/messenger/service/ImageUploadStarter;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;)Lcom/avito/android/app/task/LocalMessageSender;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerRepoModule.class})
public final class PendingMessageHandlerModule {
    @NotNull
    public static final PendingMessageHandlerModule INSTANCE = new PendingMessageHandlerModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final ImageUploadStarter provideImageUploadStarter(@NotNull Application application, @NotNull ServiceIntentFactory serviceIntentFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(serviceIntentFactory, "serviceIntentFactory");
        return new ImageUploadStarterImpl(application, serviceIntentFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final MessageSendingTrackerFactory provideMessageSendingTrackerFactory(@NotNull Analytics analytics, @NotNull TimeSource timeSource, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new MessageSendingTrackerFactoryImpl(analytics, timeSource, buildInfo.isDebug());
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PendingMessageHandler providePendingMessageHandler(@NotNull AccountStateProvider accountStateProvider, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull MessageRepo messageRepo, @NotNull LocalMessageSender localMessageSender, @NotNull TimeSource timeSource, @NotNull MessageSendingTrackerFactory messageSendingTrackerFactory, @NotNull MessengerErrorTracker messengerErrorTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull Analytics analytics, @NotNull NetworkTypeProvider networkTypeProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        Intrinsics.checkNotNullParameter(localMessageSender, "messageSender");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(messageSendingTrackerFactory, "trackerFactory");
        Intrinsics.checkNotNullParameter(messengerErrorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        return new PendingMessageHandlerImpl(messengerClient, accountStateProvider, messageRepo, localMessageSender, timeSource, messageSendingTrackerFactory, messengerErrorTracker, schedulersFactory, analytics, networkTypeProvider, features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final PhotoInteractor providePhotoInteractor(@NotNull BuildInfo buildInfo, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }

    @Provides
    @NotNull
    public final LocalMessageSender provideLocalMessageSender(@NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull FileUploadInteractor fileUploadInteractor, @NotNull MessageBodyResolver messageBodyResolver, @NotNull MessengerEntityConverter messengerEntityConverter, @NotNull ImageUploadStarter imageUploadStarter, @NotNull PhotoInteractor photoInteractor, @NotNull MessengerPhotoStorage messengerPhotoStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull MessengerFileUploadCanceller messengerFileUploadCanceller) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(fileUploadInteractor, "fileUploadInteractor");
        Intrinsics.checkNotNullParameter(messageBodyResolver, "messageBodyResolver");
        Intrinsics.checkNotNullParameter(messengerEntityConverter, "converter");
        Intrinsics.checkNotNullParameter(imageUploadStarter, "imageUploadStarter");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(messengerPhotoStorage, "photoStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(messengerFileUploadCanceller, "canceller");
        return new LocalMessageSenderImpl(messengerClient, fileUploadInteractor, imageUploadStarter, photoInteractor, messengerPhotoStorage, messengerEntityConverter, messageBodyResolver, schedulersFactory, features, messengerFileUploadCanceller);
    }
}
