package ru.avito.messenger;

import a2.g.r.g;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.Analytics;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.KeepConnectionProvider;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerSessionRefresher;
import ru.avito.messenger.ReconnectPolicy;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.api.entity.body.item.BodyItem;
import ru.avito.messenger.api.entity.body.notification.NotificationBody;
import ru.avito.messenger.api.entity.context.ChannelContext;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
import ru.avito.messenger.internal.Config;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.ImageUploadConfig;
import ru.avito.messenger.internal.config.InMemoryConfigStorage;
import ru.avito.messenger.internal.di.ConfigModule;
import ru.avito.messenger.internal.di.DaggerMessengerComponent;
import ru.avito.messenger.internal.di.ErrorTrackerModule;
import ru.avito.messenger.internal.di.GsonModule;
import ru.avito.messenger.internal.di.ImageUploadModule;
import ru.avito.messenger.internal.di.LoggerModule;
import ru.avito.messenger.internal.di.MessengerClientModule;
import ru.avito.messenger.internal.di.OkHttpModule;
import ru.avito.messenger.internal.di.ServiceModule;
import ru.avito.messenger.internal.gson.TypeId;
import ru.avito.messenger.internal.gson.TypeInfo;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.reporter.WebSocketReporter;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0014R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lru/avito/messenger/Messenger;", "Lru/avito/messenger/MessengerApi;", "T", "", "Lru/avito/messenger/MessengerClient;", "getClient", "()Lru/avito/messenger/MessengerClient;", "client", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lru/avito/messenger/config/MessengerConfigProvider;", "getConfigProvider", "()Lru/avito/messenger/config/MessengerConfigProvider;", "configProvider", "Lru/avito/messenger/MessengerImageUploadApi;", "getImageUploadApi", "()Lru/avito/messenger/MessengerImageUploadApi;", "imageUploadApi", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface Messenger<T extends MessengerApi> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010#\n\u0002\b(\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¦\u0001\u0010\u0001J?\u0010\n\u001a\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJK\u0010\n\u001a\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0004\b\n\u0010\rJA\u0010\u0010\u001a\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u000bJ?\u0010\u0012\u001a\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u000bJ?\u0010\u0014\u001a\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u000bJ/\u0010\u0016\u001a\u00020\u0000\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001a\u001a\u00020\u0000\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u00002\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\u0015\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\"¢\u0006\u0004\b \u0010#J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010!J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010!J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\u001d\u00107\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205¢\u0006\u0004\b9\u00108J\u001d\u0010:\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205¢\u0006\u0004\b:\u00108J\u0015\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020A¢\u0006\u0004\bB\u0010CJ!\u0010F\u001a\u00020\u00002\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040D¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\bL\u0010!J\u001d\u0010M\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205¢\u0006\u0004\bM\u00108J\u0015\u0010P\u001a\u00020\u00002\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0015\u0010T\u001a\u00020\u00002\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u00020\u00002\u0006\u0010W\u001a\u00020V¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\u00002\b\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\u00002\b\u0010]\u001a\u0004\u0018\u00010\\¢\u0006\u0004\b]\u0010^J\u0015\u0010`\u001a\u00020\u00002\u0006\u0010`\u001a\u00020_¢\u0006\u0004\b`\u0010aJ\u0013\u0010d\u001a\b\u0012\u0004\u0012\u00020c0b¢\u0006\u0004\bd\u0010eJ+\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00010b\"\b\b\u0001\u0010\u0003*\u00020c2\f\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\bd\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010jR$\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR&\u0010t\u001a\u0012\u0012\u0004\u0012\u00020q\u0012\b\u0012\u0006\u0012\u0002\b\u00030r0p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010mR&\u0010v\u001a\u0012\u0012\u0004\u0012\u00020q\u0012\b\u0012\u0006\u0012\u0002\b\u00030r0p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010mR\u0018\u0010:\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR&\u0010z\u001a\u0012\u0012\u0004\u0012\u00020q\u0012\b\u0012\u0006\u0012\u0002\b\u00030r0p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010mR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b}\u0010~R#\u0010\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030r08\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010$\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u00107\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010xR\u001a\u0010L\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010W\u001a\u00020V8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u00109\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010xR\u0019\u0010M\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010xR\u001a\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u0012\u0006\b\u0001\u0010\u0001R \u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001a\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R(\u0010¥\u0001\u001a\u0012\u0012\u0004\u0012\u00020q\u0012\b\u0012\u0006\u0012\u0002\b\u00030r0p8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010m¨\u0006§\u0001"}, d2 = {"Lru/avito/messenger/Messenger$Builder;", "", "Lru/avito/messenger/api/entity/body/MessageBody;", "T", "", "type", "Ljava/lang/Class;", "typeClass", "Lcom/google/gson/JsonDeserializer;", "adapter", "registerMessageBodyType", "(Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/JsonDeserializer;)Lru/avito/messenger/Messenger$Builder;", "subtype", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/JsonDeserializer;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/api/entity/context/ChannelContext;", "id", "registerChannelContextType", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "registerBodyItemType", "Lru/avito/messenger/api/entity/body/notification/NotificationBody;", "registerNotificationBodyType", "deserializer", "registerCustomDeserializer", "(Ljava/lang/Class;Lcom/google/gson/JsonDeserializer;)Lru/avito/messenger/Messenger$Builder;", "Lcom/google/gson/TypeAdapter;", "typeAdapter", "registerCustomTypeAdapter", "(Ljava/lang/Class;Lcom/google/gson/TypeAdapter;)Lru/avito/messenger/Messenger$Builder;", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "okHttpClient", "(Ldagger/Lazy;)Lru/avito/messenger/Messenger$Builder;", "endpoint", "(Ljava/lang/String;)Lru/avito/messenger/Messenger$Builder;", "Lokhttp3/HttpUrl;", "(Lokhttp3/HttpUrl;)Lru/avito/messenger/Messenger$Builder;", "origin", "sessionParameter", "Lru/avito/messenger/SessionProvider;", "sessionProvider", "(Lru/avito/messenger/SessionProvider;)Lru/avito/messenger/Messenger$Builder;", "Lcom/avito/android/analytics/Analytics;", "analytics", "analyticsProvider", "(Lcom/avito/android/analytics/Analytics;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/MessengerSessionRefresher;", "sessionRefresher", "(Lru/avito/messenger/MessengerSessionRefresher;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/KeepConnectionProvider;", "keepConnectionProvider", "(Lru/avito/messenger/KeepConnectionProvider;)Lru/avito/messenger/Messenger$Builder;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "jsonRpcTimeout", "(JLjava/util/concurrent/TimeUnit;)Lru/avito/messenger/Messenger$Builder;", "commandTimeout", "pingTimeout", "Lru/avito/messenger/ReconnectPolicy;", "reconnectPolicy", "(Lru/avito/messenger/ReconnectPolicy;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/internal/log/Logger;", "logger", "(Lru/avito/messenger/internal/log/Logger;)Lru/avito/messenger/Messenger$Builder;", "", "logLevel", "(I)Lru/avito/messenger/Messenger$Builder;", "", "params", "connectionParams", "(Ljava/util/Map;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/reporter/WebSocketReporter;", "reporter", "webSocketReporter", "(Lru/avito/reporter/WebSocketReporter;)Lru/avito/messenger/Messenger$Builder;", "imageUploadEndpoint", "imageUploadTimeout", "Lru/avito/messenger/NetworkMonitor;", "monitor", "networkMonitor", "(Lru/avito/messenger/NetworkMonitor;)Lru/avito/messenger/Messenger$Builder;", "Lokhttp3/Headers;", "headers", "handshakeHeaders", "(Lokhttp3/Headers;)Lru/avito/messenger/Messenger$Builder;", "", "useNewWebsocket", "(Z)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/MessengerApiWrapper;", "apiWrapper", "(Lru/avito/messenger/MessengerApiWrapper;)Lru/avito/messenger/Messenger$Builder;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "(Lcom/avito/android/communications_common/analytics/ErrorTracker;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/config/MessengerConfigStorage;", "configStorage", "(Lru/avito/messenger/config/MessengerConfigStorage;)Lru/avito/messenger/Messenger$Builder;", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/MessengerApi;", "build", "()Lru/avito/messenger/Messenger;", NotificationCompat.CATEGORY_SERVICE, "(Ljava/lang/Class;)Lru/avito/messenger/Messenger;", "Lru/avito/messenger/EndpointProvider;", g.a, "Lru/avito/messenger/EndpointProvider;", "endpointProvider", VKApiConst.Q, "Ljava/util/Map;", "y", "Lru/avito/reporter/WebSocketReporter;", "", "Lru/avito/messenger/internal/gson/TypeId;", "Lru/avito/messenger/internal/gson/TypeInfo;", AuthSource.BOOKING_ORDER, "contextTypes", "d", "notificationBodyTypes", "p", "Ljava/lang/Long;", AuthSource.SEND_ABUSE, "bodyTypes", "i", "Lru/avito/messenger/SessionProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lru/avito/messenger/config/MessengerConfigStorage;", "", "e", "Ljava/util/Set;", "customTypes", "l", "Lru/avito/messenger/KeepConnectionProvider;", "r", "Lru/avito/messenger/internal/log/Logger;", "h", "Ljava/lang/String;", "n", "u", "Lokhttp3/HttpUrl;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lru/avito/messenger/MessengerApiWrapper;", "t", "Lru/avito/messenger/ReconnectPolicy;", "B", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "j", "Lcom/avito/android/analytics/Analytics;", "z", "Z", "o", VKApiConst.VERSION, "w", "Lru/avito/messenger/NetworkMonitor;", "k", "Lru/avito/messenger/MessengerSessionRefresher;", "s", "Ljava/lang/Integer;", "getLogLevel$annotations", "()V", "f", "Ldagger/Lazy;", "x", "Lokhttp3/Headers;", "c", "bodyItemTypes", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public MessengerApiWrapper A;
        public ErrorTracker B;
        public final Map<TypeId, TypeInfo<?>> a = new LinkedHashMap();
        public final Map<TypeId, TypeInfo<?>> b = new LinkedHashMap();
        public final Map<TypeId, TypeInfo<?>> c = new LinkedHashMap();
        public final Map<TypeId, TypeInfo<?>> d = new LinkedHashMap();
        public final Set<TypeInfo<?>> e = new LinkedHashSet();
        public Lazy<OkHttpClient> f = a.a;
        public EndpointProvider g;
        public String h;
        public SessionProvider i;
        public Analytics j;
        public MessengerSessionRefresher k;
        public KeepConnectionProvider l;
        public MessengerConfigStorage m;
        public Long n;
        public Long o;
        public Long p;
        public Map<String, String> q;
        public Logger r;
        public Integer s;
        public ReconnectPolicy t;
        public HttpUrl u;
        public Long v;
        public NetworkMonitor w;
        public Headers x;
        public WebSocketReporter y;
        public boolean z;

        public static final class a<T> implements Lazy<OkHttpClient> {
            public static final a a = new a();

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // dagger.Lazy
            public /* bridge */ /* synthetic */ OkHttpClient get() {
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.Messenger$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder registerBodyItemType$default(Builder builder, String str, Class cls, JsonDeserializer jsonDeserializer, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                jsonDeserializer = null;
            }
            return builder.registerBodyItemType(str, cls, jsonDeserializer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.Messenger$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder registerChannelContextType$default(Builder builder, String str, Class cls, JsonDeserializer jsonDeserializer, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                jsonDeserializer = null;
            }
            return builder.registerChannelContextType(str, cls, jsonDeserializer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.Messenger$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder registerMessageBodyType$default(Builder builder, String str, Class cls, JsonDeserializer jsonDeserializer, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                jsonDeserializer = null;
            }
            return builder.registerMessageBodyType(str, cls, jsonDeserializer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.Messenger$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder registerNotificationBodyType$default(Builder builder, String str, Class cls, JsonDeserializer jsonDeserializer, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                jsonDeserializer = null;
            }
            return builder.registerNotificationBodyType(str, cls, jsonDeserializer);
        }

        @NotNull
        public final Builder analyticsProvider(@NotNull Analytics analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            this.j = analytics;
            return this;
        }

        @NotNull
        public final Builder apiWrapper(@Nullable MessengerApiWrapper messengerApiWrapper) {
            this.A = messengerApiWrapper;
            return this;
        }

        @NotNull
        public final Messenger<MessengerApi> build() {
            return build(MessengerApi.class);
        }

        @NotNull
        public final Builder commandTimeout(long j2, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "unit");
            this.o = Long.valueOf(timeUnit.toMillis(j2));
            return this;
        }

        @NotNull
        public final Builder configStorage(@NotNull MessengerConfigStorage messengerConfigStorage) {
            Intrinsics.checkNotNullParameter(messengerConfigStorage, "configStorage");
            this.m = messengerConfigStorage;
            return this;
        }

        @NotNull
        public final Builder connectionParams(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "params");
            this.q = map;
            return this;
        }

        @NotNull
        public final Builder endpoint(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            this.g = new EndpointProviderImpl(str);
            return this;
        }

        @NotNull
        public final Builder errorTracker(@Nullable ErrorTracker errorTracker) {
            this.B = errorTracker;
            return this;
        }

        @NotNull
        public final Builder handshakeHeaders(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.x = headers;
            return this;
        }

        @NotNull
        public final Builder imageUploadEndpoint(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            this.u = HttpUrl.Companion.parse(str);
            return this;
        }

        @NotNull
        public final Builder imageUploadTimeout(long j2, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "unit");
            this.v = Long.valueOf(timeUnit.toMillis(j2));
            return this;
        }

        @NotNull
        public final Builder jsonRpcTimeout(long j2, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "unit");
            this.n = Long.valueOf(timeUnit.toMillis(j2));
            return this;
        }

        @NotNull
        public final Builder keepConnectionProvider(@NotNull KeepConnectionProvider keepConnectionProvider) {
            Intrinsics.checkNotNullParameter(keepConnectionProvider, "keepConnectionProvider");
            this.l = keepConnectionProvider;
            return this;
        }

        @NotNull
        public final Builder logLevel(@LogLevel int i2) {
            this.s = Integer.valueOf(i2);
            return this;
        }

        @NotNull
        public final Builder logger(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.r = logger;
            return this;
        }

        @NotNull
        public final Builder networkMonitor(@NotNull NetworkMonitor networkMonitor) {
            Intrinsics.checkNotNullParameter(networkMonitor, "monitor");
            this.w = networkMonitor;
            return this;
        }

        @NotNull
        public final Builder okHttpClient(@NotNull Lazy<OkHttpClient> lazy) {
            Intrinsics.checkNotNullParameter(lazy, "okHttpClient");
            this.f = lazy;
            return this;
        }

        @NotNull
        public final Builder origin(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "origin");
            this.h = str;
            return this;
        }

        @NotNull
        public final Builder pingTimeout(long j2, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "unit");
            this.p = Long.valueOf(timeUnit.toMillis(j2));
            return this;
        }

        @NotNull
        public final Builder reconnectPolicy(@NotNull ReconnectPolicy reconnectPolicy) {
            Intrinsics.checkNotNullParameter(reconnectPolicy, "reconnectPolicy");
            this.t = reconnectPolicy;
            return this;
        }

        @NotNull
        public final <T extends BodyItem> Builder registerBodyItemType(@NotNull String str, @NotNull Class<T> cls, @Nullable JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.c.put(new TypeId(str, null, 2, null), new TypeInfo<>(cls, jsonDeserializer));
            return this;
        }

        @NotNull
        public final <T extends ChannelContext> Builder registerChannelContextType(@NotNull String str, @NotNull Class<? extends T> cls, @Nullable JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.b.put(new TypeId(str, null, 2, null), new TypeInfo<>(cls, jsonDeserializer));
            return this;
        }

        @NotNull
        public final <T> Builder registerCustomDeserializer(@NotNull Class<T> cls, @NotNull JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(jsonDeserializer, "deserializer");
            this.e.add(new TypeInfo<>(cls, jsonDeserializer));
            return this;
        }

        @NotNull
        public final <T> Builder registerCustomTypeAdapter(@NotNull Class<T> cls, @NotNull TypeAdapter<T> typeAdapter) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(typeAdapter, "typeAdapter");
            this.e.add(new TypeInfo<>(cls, typeAdapter));
            return this;
        }

        @NotNull
        public final <T extends MessageBody> Builder registerMessageBodyType(@NotNull String str, @NotNull Class<T> cls, @Nullable JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(cls, "typeClass");
            return registerMessageBodyType(str, null, cls, jsonDeserializer);
        }

        @NotNull
        public final <T extends NotificationBody> Builder registerNotificationBodyType(@NotNull String str, @NotNull Class<T> cls, @Nullable JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.d.put(new TypeId(str, null, 2, null), new TypeInfo<>(cls, jsonDeserializer));
            return this;
        }

        @Deprecated(message = "This is not supported, you can remove this call")
        @NotNull
        public final Builder sessionParameter(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "sessionParameter");
            return this;
        }

        @NotNull
        public final Builder sessionProvider(@NotNull SessionProvider sessionProvider) {
            Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
            this.i = sessionProvider;
            return this;
        }

        @NotNull
        public final Builder sessionRefresher(@NotNull MessengerSessionRefresher messengerSessionRefresher) {
            Intrinsics.checkNotNullParameter(messengerSessionRefresher, "sessionRefresher");
            this.k = messengerSessionRefresher;
            return this;
        }

        @NotNull
        public final Builder useNewWebsocket(boolean z2) {
            this.z = z2;
            return this;
        }

        @NotNull
        public final Builder webSocketReporter(@Nullable WebSocketReporter webSocketReporter) {
            this.y = webSocketReporter;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.Messenger$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder registerMessageBodyType$default(Builder builder, String str, String str2, Class cls, JsonDeserializer jsonDeserializer, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                jsonDeserializer = null;
            }
            return builder.registerMessageBodyType(str, str2, cls, jsonDeserializer);
        }

        @NotNull
        public final <T extends MessengerApi> Messenger<T> build(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
            SessionProvider sessionProvider = this.i;
            if (sessionProvider != null) {
                Analytics analytics = this.j;
                if (analytics != null) {
                    EndpointProvider endpointProvider = this.g;
                    if (endpointProvider == null) {
                        endpointProvider = new EndpointProviderImpl("https://socket.avito.ru/socket");
                    }
                    String str = this.h;
                    if (str == null) {
                        str = ConstantsKt.DEFAULT_ORIGIN;
                    }
                    Map plus = r.plus(ConstantsKt.getDEFAULT_PARAMS(), q.mapOf(TuplesKt.to("use_seq", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
                    Map<String, String> map = this.q;
                    if (map == null) {
                        map = r.emptyMap();
                    }
                    Map plus2 = r.plus(plus, map);
                    Long l2 = this.n;
                    long j2 = 15000;
                    long longValue = l2 != null ? l2.longValue() : 15000;
                    Long l3 = this.o;
                    long longValue2 = l3 != null ? l3.longValue() : 15000;
                    Long l4 = this.p;
                    long longValue3 = l4 != null ? l4.longValue() : 15000;
                    ReconnectPolicy reconnectPolicy = this.t;
                    if (reconnectPolicy == null) {
                        reconnectPolicy = new ReconnectPolicy.Backoff(null, 0.0d, 3, null);
                    }
                    NetworkMonitor networkMonitor = this.w;
                    if (networkMonitor == null) {
                        networkMonitor = new NetworkMonitorImpl();
                    }
                    Headers headers = this.x;
                    WebSocketReporter webSocketReporter = this.y;
                    boolean z2 = this.z;
                    MessengerApiWrapper messengerApiWrapper = this.A;
                    MessengerSessionRefresher messengerSessionRefresher = this.k;
                    if (messengerSessionRefresher == null) {
                        messengerSessionRefresher = new MessengerSessionRefresher.Dummy();
                    }
                    KeepConnectionProvider keepConnectionProvider = this.l;
                    if (keepConnectionProvider == null) {
                        keepConnectionProvider = new KeepConnectionProvider.Dummy();
                    }
                    MessengerConfigStorage messengerConfigStorage = this.m;
                    if (messengerConfigStorage == null) {
                        messengerConfigStorage = new InMemoryConfigStorage();
                    }
                    Config config = new Config(endpointProvider, str, analytics, plus2, longValue, longValue2, longValue3, reconnectPolicy, networkMonitor, headers, webSocketReporter, z2, messengerApiWrapper, sessionProvider, messengerSessionRefresher, keepConnectionProvider, messengerConfigStorage);
                    HttpUrl parse = HttpUrl.Companion.parse("https://socket.avito.ru/images");
                    if (parse != null) {
                        HttpUrl httpUrl = this.u;
                        if (httpUrl != null) {
                            parse = httpUrl;
                        }
                        String origin = config.getOrigin();
                        Long l5 = this.v;
                        if (l5 != null) {
                            j2 = l5.longValue();
                        }
                        ImageUploadConfig imageUploadConfig = new ImageUploadConfig(parse, origin, j2);
                        DaggerMessengerComponent.Builder gsonModule = DaggerMessengerComponent.builder().configModule(new ConfigModule(config)).gsonModule(new GsonModule(this.a, this.b, this.c, this.d, this.e));
                        Integer num = this.s;
                        MessengerImpl<MessengerApi> createMessenger = gsonModule.loggerModule(new LoggerModule(num != null ? num.intValue() : 4, this.r)).okHttpModule(new OkHttpModule(this.f)).serviceModule(new ServiceModule(cls)).imageUploadModule(new ImageUploadModule(imageUploadConfig, null)).messengerClientModule(MessengerClientModule.INSTANCE).errorTrackerModule(new ErrorTrackerModule(this.B)).build().createMessenger();
                        Objects.requireNonNull(createMessenger, "null cannot be cast to non-null type ru.avito.messenger.Messenger<T>");
                        return createMessenger;
                    }
                    throw new IllegalArgumentException("Invalid uri: https://socket.avito.ru/images".toString());
                }
                throw new IllegalArgumentException(a2.b.a.a.a.E2(Analytics.class, new StringBuilder(), " is not provided").toString());
            }
            throw new IllegalArgumentException(a2.b.a.a.a.E2(SessionProvider.class, new StringBuilder(), " is not provided").toString());
        }

        @NotNull
        public final Builder endpoint(@NotNull HttpUrl httpUrl) {
            Intrinsics.checkNotNullParameter(httpUrl, "endpoint");
            this.g = new EndpointProviderImpl(httpUrl);
            return this;
        }

        @NotNull
        public final <T extends MessageBody> Builder registerMessageBodyType(@NotNull String str, @Nullable String str2, @NotNull Class<? extends T> cls, @Nullable JsonDeserializer<T> jsonDeserializer) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(cls, "typeClass");
            this.a.put(new TypeId(str, str2), new TypeInfo<>(cls, jsonDeserializer));
            return this;
        }
    }

    @NotNull
    MessengerClient<T> getClient();

    @NotNull
    MessengerConfigProvider getConfigProvider();

    @NotNull
    Gson getGson();

    @NotNull
    MessengerImageUploadApi getImageUploadApi();
}
