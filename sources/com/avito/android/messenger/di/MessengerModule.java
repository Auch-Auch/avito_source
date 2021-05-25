package com.avito.android.messenger.di;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.MessengerTasksModule;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.app.core.R;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.MessengerInfoModule;
import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.messenger.MessageLocalIdGeneratorImpl;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.MessengerEntityConverterImpl;
import com.avito.android.messenger.NetworkMonitorImpl;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.TextToChunkConverterImpl;
import com.avito.android.messenger.analytics.MessengerErrorTracker;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProviderImpl;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractorImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializerImpl;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializerImpl;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgentImpl;
import com.avito.android.messenger.config.PersistentMessengerConfigStorage;
import com.avito.android.messenger.connection.AvitoMessengerKeepConnectionProvider;
import com.avito.android.messenger.connection.AvitoMessengerSessionRefresher;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializerImpl;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorageImpl;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.messenger.service.MessengerSessionProvider;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChannelMenuAction;
import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.parse.adapter.ActionTypeAdapter;
import com.avito.android.remote.parse.adapter.AppCallMessageBodyTypeAdapter;
import com.avito.android.remote.parse.adapter.AttributedTextAdapter;
import com.avito.android.remote.parse.adapter.ChannelMenuActionTypeAdapter;
import com.avito.android.remote.parse.adapter.ChatReplyTimeTypeAdapter;
import com.avito.android.remote.parse.adapter.ColorTypeAdapter;
import com.avito.android.remote.parse.adapter.DealActionDeserializer;
import com.avito.android.remote.parse.adapter.DeepLinkTypeAdapter;
import com.avito.android.remote.parse.adapter.ImageTypeAdapter;
import com.avito.android.remote.parse.adapter.ItemChannelContextTypeAdapter;
import com.avito.android.remote.parse.adapter.MessageBodySystemDeserializer;
import com.avito.android.remote.parse.adapter.SerpElementTypeAdapter;
import com.avito.android.remote.parse.adapter.SystemChannelContextTypeAdapter;
import com.avito.android.remote.parse.adapter.UriTypeAdapter;
import com.avito.android.remote.parse.adapter.UserToUserChannelContextTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.AttachMenuTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.ContextActionHandlerTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.ContextActionsTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.FileMessageBodyTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.LinkMessageBodyTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.LinkMessagePreviewTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.platform.PlatformFromAvitoMessageBodyTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.platform.PlatformFromUserMessageBodyTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.platform.PlatformMessageBubbleTypeAdapter;
import com.avito.android.remote.parse.adapter.messenger.platform.TextMessageChunkTypeAdapter;
import com.avito.android.session_refresh.SessionRefresher;
import com.avito.android.util.AvitoBuildInfo;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageDao;
import ru.avito.messenger.KeepConnectionProvider;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.MessengerApiWrapper;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerConnection;
import ru.avito.messenger.MessengerSessionRefresher;
import ru.avito.messenger.NetworkMonitor;
import ru.avito.messenger.ReconnectPolicy;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import ru.avito.messenger.api.entity.context.ChannelDealAction;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.reporter.WebSocketReporter;
import ru.ok.android.sdk.Shared;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001:\u0004z{|}B\u0007¢\u0006\u0004\bx\u0010yJ%\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0011¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0018\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ¡\u0001\u0010;\u001a\b\u0012\u0004\u0012\u000208072\b\b\u0001\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00152\u0006\u00106\u001a\u000205H\u0011¢\u0006\u0004\b9\u0010:J\u0011\u0010<\u001a\u0004\u0018\u00010/H\u0017¢\u0006\u0004\b<\u0010=J'\u0010D\u001a\u00020+2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010*\u001a\u00020)H\u0011¢\u0006\u0004\bB\u0010CJ\"\u0010H\u001a\u00020G2\u0011\u0010F\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE07H\u0007¢\u0006\u0004\bH\u0010IJ(\u0010M\u001a\b\u0012\u0004\u0012\u0002080J2\u0011\u0010F\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE07H\u0011¢\u0006\u0004\bK\u0010LJ\u0017\u0010R\u001a\u00020#2\u0006\u0010O\u001a\u00020NH\u0011¢\u0006\u0004\bP\u0010QJ\"\u0010T\u001a\u0002082\u0011\u0010S\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE0JH\u0017¢\u0006\u0004\bT\u0010UJ\"\u0010W\u001a\u00020V2\u0011\u0010F\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE07H\u0017¢\u0006\u0004\bW\u0010XJ\"\u0010Z\u001a\u00020Y2\u0011\u0010F\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE07H\u0017¢\u0006\u0004\bZ\u0010[J\"\u0010]\u001a\u00020\\2\u0011\u0010F\u001a\r\u0012\t\u0012\u000708¢\u0006\u0002\bE07H\u0017¢\u0006\u0004\b]\u0010^J\u0017\u0010b\u001a\u00020a2\u0006\u0010`\u001a\u00020_H\u0017¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020!H\u0017¢\u0006\u0004\bd\u0010eJ\u0017\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020fH\u0007¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020k2\u0006\u0010g\u001a\u00020fH\u0007¢\u0006\u0004\bl\u0010mJ\u0017\u0010q\u001a\u00020\u001f2\u0006\u00102\u001a\u00020nH\u0011¢\u0006\u0004\bo\u0010pJ\u001f\u0010v\u001a\u00020u2\u0006\u0010r\u001a\u00020>2\u0006\u0010t\u001a\u00020sH\u0017¢\u0006\u0004\bv\u0010w¨\u0006~"}, d2 = {"Lcom/avito/android/messenger/di/MessengerModule;", "", "Lcom/avito/android/session_refresh/SessionRefresher;", "sessionRefresher", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "client", "Lru/avito/messenger/MessengerSessionRefresher;", "provideMessengerSessionRefresher$messenger_release", "(Lcom/avito/android/session_refresh/SessionRefresher;Ldagger/Lazy;)Lru/avito/messenger/MessengerSessionRefresher;", "provideMessengerSessionRefresher", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lru/avito/android/persistence/messenger/MessageDao;", "messageDao", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "channelSyncOnPushAgent", "Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;", "errorHandler", "Lru/avito/messenger/KeepConnectionProvider;", "provideKeepConnectionProvider$messenger_release", "(Lcom/avito/android/account/AccountStateProvider;Lru/avito/android/persistence/messenger/MessageDao;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;Lcom/avito/android/messenger/conversation/mvi/data/DatabaseErrorHandler;)Lru/avito/messenger/KeepConnectionProvider;", "provideKeepConnectionProvider", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "provideMessengerErrorTracker$messenger_release", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "provideMessengerErrorTracker", "", "logLevel", "", "jsonRpcTimeout", "Lru/avito/messenger/SessionProvider;", "sessionProvider", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "infoProvider", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/Features;", "features", "Lru/avito/messenger/NetworkMonitor;", "networkMonitor", "Lru/avito/reporter/WebSocketReporter;", "webSocketReporter", "Lru/avito/messenger/MessengerApiWrapper;", "messengerApiWrapper", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "errorTracker", "keepConnectionProvider", "Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/api/AvitoMessengerApi;", "provideMessenger$messenger_release", "(IJLru/avito/messenger/SessionProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/messenger/service/MessengerInfoProvider;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/Features;Ldagger/Lazy;Lru/avito/messenger/NetworkMonitor;Lru/avito/reporter/WebSocketReporter;Lru/avito/messenger/MessengerApiWrapper;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/messenger/analytics/MessengerErrorTracker;Lru/avito/messenger/MessengerSessionRefresher;Lru/avito/messenger/KeepConnectionProvider;Lru/avito/messenger/config/MessengerConfigStorage;)Lru/avito/messenger/Messenger;", "provideMessenger", "provideMessengerApiWrapper", "()Lru/avito/messenger/MessengerApiWrapper;", "Landroid/app/Application;", "app", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "provideNetworkMonitor$messenger_release", "(Landroid/app/Application;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;Lcom/avito/android/Features;)Lru/avito/messenger/NetworkMonitor;", "provideNetworkMonitor", "Lkotlin/jvm/JvmSuppressWildcards;", "messenger", "Lru/avito/messenger/config/MessengerConfigProvider;", "providerMessengerConfigProvider", "(Lru/avito/messenger/Messenger;)Lru/avito/messenger/config/MessengerConfigProvider;", "Lru/avito/messenger/MessengerClient;", "provideMessengerClient$messenger_release", "(Lru/avito/messenger/Messenger;)Lru/avito/messenger/MessengerClient;", "provideMessengerClient", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "provideSessionProvider$messenger_release", "(Lcom/avito/android/account/AccountStorageInteractor;)Lru/avito/messenger/SessionProvider;", "provideSessionProvider", "messengerClient", "provideFallbackMessengerApi", "(Lru/avito/messenger/MessengerClient;)Lru/avito/messenger/api/AvitoMessengerApi;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "provideMessageBodySerializer", "(Lru/avito/messenger/Messenger;)Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "provideChannelContextSerializer", "(Lru/avito/messenger/Messenger;)Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "provideChannelPropertySerializer", "(Lru/avito/messenger/Messenger;)Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "Lcom/avito/android/util/RandomKeyProvider;", "keyGenerator", "Lcom/avito/android/messenger/MessageLocalIdGenerator;", "provideMessageMessageLocalIdGenerator", "(Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/messenger/MessageLocalIdGenerator;", "provideJsonRpcTimeout", "()J", "Landroid/content/Context;", "context", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "provideGoogleApiKey", "(Landroid/content/Context;)Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "provideYandexApiKey", "(Landroid/content/Context;)Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "Lcom/avito/android/util/BuildInfo;", "provideLogLevel$messenger_release", "(Lcom/avito/android/util/BuildInfo;)I", "provideLogLevel", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/util/preferences/Preferences;", "provideMessengerPreferences", "(Landroid/app/Application;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/util/preferences/Preferences;", "<init>", "()V", "Declarations", "JsonRpcTimeout", "LogLevel", "MessengerPreferences", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerInfoModule.class, MessengerRepoModule.class, MessengerWorkFactoryModule.class, MessengerSyncModule.class, MessengerTasksModule.class, Declarations.class, FileUploadModule.class})
public class MessengerModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u001b\u001a\u00020\u001a2\u0011\u0010\u0003\u001a\r\u0012\t\u0012\u00070\u0018¢\u0006\u0002\b\u00190\u0017H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020!H'¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/di/MessengerModule$Declarations;", "", "Lcom/avito/android/messenger/MessengerEntityConverterImpl;", "impl", "Lcom/avito/android/messenger/MessengerEntityConverter;", "bindMessengerEntityConverter", "(Lcom/avito/android/messenger/MessengerEntityConverterImpl;)Lcom/avito/android/messenger/MessengerEntityConverter;", "Lcom/avito/android/messenger/TextToChunkConverterImpl;", "Lcom/avito/android/messenger/TextToChunkConverter;", "bindTextToChunkConverter", "(Lcom/avito/android/messenger/TextToChunkConverterImpl;)Lcom/avito/android/messenger/TextToChunkConverter;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "bindChannelSyncOnPushAgent", "(Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgentImpl;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "bindBlacklistReasonsProvider", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProviderImpl;)Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "bindBlockUserInteractor", "(Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractorImpl;)Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lru/avito/messenger/MessengerConnection;", "bindMessengerConnection", "(Lru/avito/messenger/MessengerClient;)Lru/avito/messenger/MessengerConnection;", "Lcom/avito/android/messenger/config/PersistentMessengerConfigStorage;", "Lru/avito/messenger/config/MessengerConfigStorage;", "bindMessengerConfigStorage", "(Lcom/avito/android/messenger/config/PersistentMessengerConfigStorage;)Lru/avito/messenger/config/MessengerConfigStorage;", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorageImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "bindMessengerPhotoStorage", "(Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorageImpl;)Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        BlacklistReasonsProvider bindBlacklistReasonsProvider(@NotNull BlacklistReasonsProviderImpl blacklistReasonsProviderImpl);

        @Singleton
        @Binds
        @NotNull
        BlockUserInteractor bindBlockUserInteractor(@NotNull BlockUserInteractorImpl blockUserInteractorImpl);

        @Singleton
        @Binds
        @NotNull
        ChannelSyncOnPushAgent bindChannelSyncOnPushAgent(@NotNull ChannelSyncOnPushAgentImpl channelSyncOnPushAgentImpl);

        @Singleton
        @Binds
        @NotNull
        MessengerConfigStorage bindMessengerConfigStorage(@NotNull PersistentMessengerConfigStorage persistentMessengerConfigStorage);

        @Binds
        @NotNull
        MessengerConnection bindMessengerConnection(@NotNull MessengerClient<AvitoMessengerApi> messengerClient);

        @Reusable
        @Binds
        @NotNull
        MessengerEntityConverter bindMessengerEntityConverter(@NotNull MessengerEntityConverterImpl messengerEntityConverterImpl);

        @Singleton
        @Binds
        @NotNull
        MessengerPhotoStorage bindMessengerPhotoStorage(@NotNull MessengerPhotoStorageImpl messengerPhotoStorageImpl);

        @Reusable
        @Binds
        @NotNull
        TextToChunkConverter bindTextToChunkConverter(@NotNull TextToChunkConverterImpl textToChunkConverterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/di/MessengerModule$JsonRpcTimeout;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface JsonRpcTimeout {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/di/MessengerModule$LogLevel;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface LogLevel {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/di/MessengerModule$MessengerPreferences;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface MessengerPreferences {
    }

    @Provides
    @NotNull
    public ChannelContextSerializer provideChannelContextSerializer(@NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return new ChannelContextSerializerImpl(messenger.getGson());
    }

    @Provides
    @NotNull
    public ChannelPropertySerializer provideChannelPropertySerializer(@NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return new ChannelPropertySerializerImpl(messenger.getGson());
    }

    @Provides
    @NotNull
    public AvitoMessengerApi provideFallbackMessengerApi(@NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        Intrinsics.checkNotNullParameter(messengerClient, "messengerClient");
        return messengerClient.getFallbackApi();
    }

    @Provides
    @Singleton
    @NotNull
    public final GoogleApiKey provideGoogleApiKey(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.google_api_key);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_R.string.google_api_key)");
        return new GoogleApiKey(string);
    }

    @Provides
    @JsonRpcTimeout
    public long provideJsonRpcTimeout() {
        return 15;
    }

    @Provides
    @NotNull
    public KeepConnectionProvider provideKeepConnectionProvider$messenger_release(@NotNull AccountStateProvider accountStateProvider, @NotNull MessageDao messageDao, @NotNull SchedulersFactory schedulersFactory, @NotNull ChannelSyncOnPushAgent channelSyncOnPushAgent, @NotNull DatabaseErrorHandler databaseErrorHandler) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(channelSyncOnPushAgent, "channelSyncOnPushAgent");
        Intrinsics.checkNotNullParameter(databaseErrorHandler, "errorHandler");
        return new AvitoMessengerKeepConnectionProvider(accountStateProvider, messageDao, schedulersFactory, channelSyncOnPushAgent, databaseErrorHandler);
    }

    @Provides
    @LogLevel
    public int provideLogLevel$messenger_release(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return buildInfo.isDebug() ? 1 : 0;
    }

    @Provides
    @NotNull
    public MessageBodySerializer provideMessageBodySerializer(@NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return new MessageBodySerializerImpl(messenger.getGson());
    }

    @Provides
    @Singleton
    @NotNull
    public MessageLocalIdGenerator provideMessageMessageLocalIdGenerator(@NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyGenerator");
        return new MessageLocalIdGeneratorImpl(randomKeyProvider);
    }

    @Provides
    @NotNull
    @Singleton
    public Messenger<AvitoMessengerApi> provideMessenger$messenger_release(@LogLevel int i, @JsonRpcTimeout long j, @NotNull SessionProvider sessionProvider, @NotNull Analytics analytics, @NotNull MessengerInfoProvider messengerInfoProvider, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Features features, @NotNull Lazy<OkHttpClient> lazy, @NotNull NetworkMonitor networkMonitor, @NotNull WebSocketReporter webSocketReporter, @Nullable MessengerApiWrapper messengerApiWrapper, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull MessengerErrorTracker messengerErrorTracker, @NotNull MessengerSessionRefresher messengerSessionRefresher, @NotNull KeepConnectionProvider keepConnectionProvider, @NotNull MessengerConfigStorage messengerConfigStorage) {
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(messengerInfoProvider, "infoProvider");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(webSocketReporter, "webSocketReporter");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(messengerErrorTracker, "errorTracker");
        Intrinsics.checkNotNullParameter(messengerSessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(keepConnectionProvider, "keepConnectionProvider");
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
        Messenger.Builder apiWrapper = Messenger.Builder.registerMessageBodyType$default(Messenger.Builder.registerMessageBodyType$default(Messenger.Builder.registerMessageBodyType$default(new Messenger.Builder().endpoint(messengerInfoProvider.provideEndpoint()).origin(messengerInfoProvider.provideOrigin()).logLevel(i).imageUploadEndpoint(messengerInfoProvider.provideImageUploadEndpoint()).sessionProvider(sessionProvider).analyticsProvider(analytics).networkMonitor(networkMonitor).registerCustomDeserializer(AttachMenu.class, new AttachMenuTypeAdapter()).registerCustomDeserializer(MessageBody.SystemMessageBody.Platform.Bubble.class, new PlatformMessageBubbleTypeAdapter()).registerCustomDeserializer(MessageBody.Text.Chunk.class, new TextMessageChunkTypeAdapter()).registerCustomDeserializer(MessageBody.Link.Preview.class, new LinkMessagePreviewTypeAdapter()).registerMessageBodyType("link", MessageBody.Link.class, new LinkMessageBodyTypeAdapter()), "location", MessageBody.Location.class, null, 4, null), "text", ContextActionHandler.MethodCall.REACTION, MessageBody.Text.Reaction.class, null, 8, null).registerMessageBodyType(ChannelContext.System.TYPE, Shared.PARAM_PLATFORM, MessageBody.SystemMessageBody.Platform.FromAvito.class, new PlatformFromAvitoMessageBodyTypeAdapter()).registerMessageBodyType(ChannelContext.System.TYPE, "platformFromUser", MessageBody.SystemMessageBody.Platform.FromUser.class, new PlatformFromUserMessageBodyTypeAdapter()).registerMessageBodyType(ChannelContext.System.TYPE, MessageBody.SystemMessageBody.class, new MessageBodySystemDeserializer()), "deleted", MessageBody.Deleted.class, null, 4, null).registerMessageBodyType(MessageBody.AppCall.TYPE, MessageBody.AppCall.class, new AppCallMessageBodyTypeAdapter()).registerMessageBodyType("file", MessageBody.File.class, new FileMessageBodyTypeAdapter()).registerChannelContextType("item", ChannelContext.Item.class, new ItemChannelContextTypeAdapter()).registerChannelContextType("user", ChannelContext.UserToUser.class, new UserToUserChannelContextTypeAdapter()).registerChannelContextType(ChannelContext.System.TYPE, ChannelContext.System.class, new SystemChannelContextTypeAdapter()).registerCustomDeserializer(Action.class, new ActionTypeAdapter()).registerCustomDeserializer(ChannelMenuAction.class, new ChannelMenuActionTypeAdapter()).registerCustomDeserializer(ChatReplyTime.class, new ChatReplyTimeTypeAdapter()).registerCustomTypeAdapter(DeepLink.class, new DeepLinkTypeAdapter(deepLinkFactory)).registerCustomTypeAdapter(Image.class, new ImageTypeAdapter()).registerCustomTypeAdapter(Uri.class, new UriTypeAdapter()).registerCustomDeserializer(AttributedText.class, new AttributedTextAdapter()).registerCustomDeserializer(ChannelContextActions.class, new ContextActionsTypeAdapter()).registerCustomDeserializer(ContextActionHandler.class, new ContextActionHandlerTypeAdapter()).registerCustomDeserializer(ChannelDealAction.class, new DealActionDeserializer()).registerCustomTypeAdapter(Color.class, new ColorTypeAdapter()).registerCustomDeserializer(SerpElement.class, new SerpElementTypeAdapter(null, 1, null)).handshakeHeaders(Headers.Companion.of(messengerInfoProvider.provideHandshakeHeaders())).sessionRefresher(messengerSessionRefresher).keepConnectionProvider(keepConnectionProvider).okHttpClient(lazy).webSocketReporter(webSocketReporter).useNewWebsocket(features.getMessengerNewWebsocket().invoke().booleanValue()).apiWrapper(messengerApiWrapper);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Messenger.Builder imageUploadTimeout = apiWrapper.jsonRpcTimeout(j, timeUnit).commandTimeout(j, timeUnit).pingTimeout(j, timeUnit).imageUploadTimeout(60, timeUnit);
        if (features.getMessengerUseFixedReconnectInterval().invoke().booleanValue()) {
            imageUploadTimeout.reconnectPolicy(new ReconnectPolicy.Fixed(5));
        }
        return imageUploadTimeout.connectionParams(messengerInfoProvider.provideConnectionParameters()).errorTracker(messengerErrorTracker).configStorage(messengerConfigStorage).build(AvitoMessengerApi.class);
    }

    @Provides
    @Nullable
    public MessengerApiWrapper provideMessengerApiWrapper() {
        return null;
    }

    @Provides
    @NotNull
    public MessengerClient<AvitoMessengerApi> provideMessengerClient$messenger_release(@NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return messenger.getClient();
    }

    @Provides
    @NotNull
    public MessengerErrorTracker provideMessengerErrorTracker$messenger_release(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new MessengerErrorTracker(analytics);
    }

    @Provides
    @MessengerPreferences
    @NotNull
    @Singleton
    public Preferences provideMessengerPreferences(@NotNull Application application, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return preferenceFactory.getCustomPreferences(application, "messenger");
    }

    @Provides
    @NotNull
    public MessengerSessionRefresher provideMessengerSessionRefresher$messenger_release(@NotNull SessionRefresher sessionRefresher, @NotNull Lazy<OkHttpClient> lazy) {
        Intrinsics.checkNotNullParameter(sessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(lazy, "client");
        return new AvitoMessengerSessionRefresher(sessionRefresher, lazy);
    }

    @Provides
    @NotNull
    public NetworkMonitor provideNetworkMonitor$messenger_release(@NotNull Application application, @NotNull ConnectivityProvider connectivityProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, "app");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        return new NetworkMonitorImpl(connectivityProvider);
    }

    @Provides
    @NotNull
    public SessionProvider provideSessionProvider$messenger_release(@NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        return new MessengerSessionProvider(accountStorageInteractor);
    }

    @Provides
    @Singleton
    @NotNull
    public final YandexApiKey provideYandexApiKey(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.yandex_api_key);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_R.string.yandex_api_key)");
        return new YandexApiKey(string);
    }

    @Provides
    @NotNull
    public final MessengerConfigProvider providerMessengerConfigProvider(@NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        return messenger.getConfigProvider();
    }
}
