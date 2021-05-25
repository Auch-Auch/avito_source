package okhttp3.internal.http2;

import a2.b.a.a.a;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.iid.MessengerIpcClient;
import com.google.firebase.messaging.Constants;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 º\u00012\u00020\u0001:\b»\u0001º\u0001¼\u0001½\u0001B\u0015\b\u0000\u0012\b\u0010·\u0001\u001a\u00030¶\u0001¢\u0006\u0006\b¸\u0001\u0010¹\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ#\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u001fJ-\u0010$\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010/\u001a\u00020*H\u0000¢\u0006\u0004\b0\u0010-J\u001f\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0019H\u0000¢\u0006\u0004\b3\u00104J%\u00109\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u000e¢\u0006\u0004\b;\u0010<J\r\u00109\u001a\u00020\u000e¢\u0006\u0004\b9\u0010<J\r\u0010=\u001a\u00020\u000e¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020\u000e¢\u0006\u0004\b>\u0010<J\u0015\u0010?\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020*¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000eH\u0016¢\u0006\u0004\bA\u0010<J)\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\bE\u0010FJ#\u0010J\u001a\u00020\u000e2\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\bJ\u0010KJ\u0015\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0019¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u000eH\u0000¢\u0006\u0004\bS\u0010<J\u0017\u0010W\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\bU\u0010VJ%\u0010Z\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\bX\u0010YJ-\u0010^\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\\\u0010]J/\u0010c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010`\u001a\u00020_2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\ba\u0010bJ\u001f\u0010e\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\bd\u0010-R\"\u0010f\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u0012\"\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR$\u0010n\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00198\u0006@BX\u000e¢\u0006\f\n\u0004\bn\u0010l\u001a\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010lR\u0016\u0010r\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010lR\u001c\u0010t\u001a\u00020s8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010xR$\u0010y\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00198\u0006@BX\u000e¢\u0006\f\n\u0004\by\u0010l\u001a\u0004\bz\u0010pR\u001c\u0010{\u001a\u00020\u00078\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R$\u0010\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0014\n\u0004\b\u0010g\u001a\u0005\b\u0001\u0010\u0012\"\u0005\b\u0001\u0010jR\u0018\u0010\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010|R.\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00018\u0000@\u0000X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010lR\u001f\u0010\u0001\u001a\u00030\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u00020L8\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u00020L8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0005\b\u0001\u0010OR'\u0010\u0001\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00198\u0006@BX\u000e¢\u0006\u000e\n\u0005\b\u0001\u0010l\u001a\u0005\b\u0001\u0010pR \u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020 \u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\"\u0010¤\u0001\u001a\u00030£\u00018\u0000@\u0000X\u0004¢\u0006\u0010\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010¨\u0001\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010lR#\u0010ª\u0001\u001a\u00070©\u0001R\u00020\u00008\u0006@\u0006¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010­\u0001R\u0018\u0010®\u0001\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010lR'\u0010¯\u0001\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u00198\u0006@BX\u000e¢\u0006\u000e\n\u0005\b¯\u0001\u0010l\u001a\u0005\b°\u0001\u0010pR\u001a\u0010±\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b±\u0001\u0010\u0001R\u0018\u0010²\u0001\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010lR\u001a\u0010´\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001¨\u0006¾\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", VKApiConst.OUT, "Lokhttp3/internal/http2/Http2Stream;", "newStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "Ljava/io/IOException;", "e", "", "failConnection", "(Ljava/io/IOException;)V", "openStreamCount", "()I", "id", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "pushStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Lokio/Buffer;", "buffer", DecodeProducer.EXTRA_BITMAP_BYTES, "writeData", "(IZLokio/Buffer;J)V", "Lokhttp3/internal/http2/ErrorCode;", CommonKt.TAG_ERROR_CODE, "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", "statusCode", "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", Tracker.Events.CREATIVE_START, "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Lokio/BufferedSource;", "source", "pushDataLater$okhttp", "(ILokio/BufferedSource;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "lastGoodStreamId", "I", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "(I)V", "degradedPongsReceived", "J", "<set-?>", "readBytesTotal", "getReadBytesTotal", "()J", "degradedPingsSent", "awaitPongsReceived", "Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/internal/concurrent/TaskRunner;", "readBytesAcknowledged", "getReadBytesAcknowledged", "client", "Z", "getClient$okhttp", "()Z", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "isShutdown", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "Lokhttp3/internal/concurrent/TaskQueue;", "writerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "degradedPongDeadlineNs", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "settingsListenerQueue", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "peerSettings", "getPeerSettings", "setPeerSettings", "writeBytesTotal", "getWriteBytesTotal", "", "currentPushRequests", "Ljava/util/Set;", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "intervalPingsSent", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "awaitPingsSent", "writeBytesMaximum", "getWriteBytesMaximum", "pushQueue", "intervalPongsReceived", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    @NotNull
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    @NotNull
    private final Listener listener;
    private int nextStreamId;
    @NotNull
    private final Settings okHttpSettings;
    @NotNull
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @NotNull
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    @NotNull
    private final Socket socket;
    @NotNull
    private final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @NotNull
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\bG\u0010HJ5\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u00020&8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b\t\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Lokio/BufferedSource;Lokio/BufferedSink;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "I", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "", "client", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private boolean client;
        @NotNull
        public String connectionName;
        @NotNull
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private int pingIntervalMillis;
        @NotNull
        private PushObserver pushObserver = PushObserver.CANCEL;
        @NotNull
        public BufferedSink sink;
        @NotNull
        public Socket socket;
        @NotNull
        public BufferedSource source;
        @NotNull
        private final TaskRunner taskRunner;

        public Builder(boolean z, @NotNull TaskRunner taskRunner2) {
            Intrinsics.checkNotNullParameter(taskRunner2, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner2;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = Util.peerName(socket2);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket2));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket2));
            }
            return builder.socket(socket2, str, bufferedSource, bufferedSink);
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            }
            return str;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sink");
            }
            return bufferedSink;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket2 = this.socket;
            if (socket2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socket");
            }
            return socket2;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource == null) {
                Intrinsics.throwUninitializedPropertyAccessException("source");
            }
            return bufferedSource;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener2) {
            Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.listener = listener2;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver2) {
            Intrinsics.checkNotNullParameter(pushObserver2, "pushObserver");
            this.pushObserver = pushObserver2;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(@NotNull Listener listener2) {
            Intrinsics.checkNotNullParameter(listener2, "<set-?>");
            this.listener = listener2;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver2) {
            Intrinsics.checkNotNullParameter(pushObserver2, "<set-?>");
            this.pushObserver = pushObserver2;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(@NotNull Socket socket2) {
            Intrinsics.checkNotNullParameter(socket2, "<set-?>");
            this.socket = socket2;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket2) throws IOException {
            return socket$default(this, socket2, null, null, null, 14, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket2, @NotNull String str) throws IOException {
            return socket$default(this, socket2, str, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket2, @NotNull String str, @NotNull BufferedSource bufferedSource) throws IOException {
            return socket$default(this, socket2, str, bufferedSource, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket2, @NotNull String str, @NotNull BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink) throws IOException {
            String str2;
            Intrinsics.checkNotNullParameter(socket2, "socket");
            Intrinsics.checkNotNullParameter(str, "peerName");
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Intrinsics.checkNotNullParameter(bufferedSink, "sink");
            this.socket = socket2;
            if (this.client) {
                str2 = Util.okHttpName + ' ' + str;
            } else {
                str2 = a.c3("MockWebServer ", str);
            }
            this.connectionName = str2;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "Lokhttp3/internal/http2/Settings;", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "Lokhttp3/internal/http2/Http2Stream;", "stream", "", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "Lokhttp3/internal/http2/Http2Connection$Listener;", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public void onSettings(@NotNull Http2Connection http2Connection, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(http2Connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(@NotNull Http2Stream http2Stream) throws IOException;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J'\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#J'\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J/\u00100\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u00101J-\u00104\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b4\u00105J?\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0016¢\u0006\u0004\b<\u0010=R\u001c\u0010?\u001a\u00020>8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "invoke", "()V", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", "source", "length", "data", "(ZILokio/BufferedSource;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", CommonKt.TAG_ERROR_CODE, "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", MessengerIpcClient.KEY_ACK, "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", Constants.FirelogAnalytics.PARAM_PRIORITY, "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        @NotNull
        private final Http2Reader reader;
        public final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(@NotNull Http2Connection http2Connection, Http2Reader http2Reader) {
            Intrinsics.checkNotNullParameter(http2Reader, "reader");
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, @NotNull String str, @NotNull ByteString byteString, @NotNull String str2, int i2, long j) {
            Intrinsics.checkNotNullParameter(str, "origin");
            Intrinsics.checkNotNullParameter(byteString, "protocol");
            Intrinsics.checkNotNullParameter(str2, "host");
        }

        public final void applyAndAckSettings(boolean z, @NotNull Settings settings) {
            Http2Connection http2Connection;
            Throwable th;
            T t;
            T t2;
            Intrinsics.checkNotNullParameter(settings, "settings");
            Ref.LongRef longRef = new Ref.LongRef();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            synchronized (this.this$0.getWriter()) {
                Http2Connection http2Connection2 = this.this$0;
                synchronized (http2Connection2) {
                    try {
                        Settings peerSettings = this.this$0.getPeerSettings();
                        if (z) {
                            t = (T) settings;
                        } else {
                            t = (T) new Settings();
                            t.merge(peerSettings);
                            t.merge(settings);
                        }
                        objectRef2.element = t;
                        long initialWindowSize = ((long) t.getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                        longRef.element = initialWindowSize;
                        if (initialWindowSize != 0) {
                            if (!this.this$0.getStreams$okhttp().isEmpty()) {
                                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                                if (array != null) {
                                    t2 = (T) ((Http2Stream[]) array);
                                    objectRef.element = t2;
                                    this.this$0.setPeerSettings(objectRef2.element);
                                    String str = this.this$0.getConnectionName$okhttp() + " onSettings";
                                    http2Connection = http2Connection2;
                                    this.this$0.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(str, true, str, true, this, objectRef2, z, settings, longRef, objectRef), 0);
                                    try {
                                        this.this$0.getWriter().applyAndAckSettings(objectRef2.element);
                                    } catch (IOException e) {
                                        this.this$0.failConnection(e);
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                        }
                        t2 = null;
                        objectRef.element = t2;
                        this.this$0.setPeerSettings(objectRef2.element);
                        String str = this.this$0.getConnectionName$okhttp() + " onSettings";
                        http2Connection = http2Connection2;
                        try {
                            this.this$0.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(str, true, str, true, this, objectRef2, z, settings, longRef, objectRef), 0);
                            this.this$0.getWriter().applyAndAckSettings(objectRef2.element);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        http2Connection = http2Connection2;
                        throw th;
                    }
                }
            }
            T t3 = objectRef.element;
            if (((Http2Stream[]) t3) != null) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) t3;
                Intrinsics.checkNotNull(http2StreamArr);
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(longRef.element);
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, @NotNull BufferedSource bufferedSource, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushDataLater$okhttp(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i2;
                this.this$0.updateConnectionFlowControl$okhttp(j);
                bufferedSource.skip(j);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, @NotNull ErrorCode errorCode, @NotNull ByteString byteString) {
            int i2;
            Http2Stream[] http2StreamArr;
            Intrinsics.checkNotNullParameter(errorCode, CommonKt.TAG_ERROR_CODE);
            Intrinsics.checkNotNullParameter(byteString, "debugData");
            byteString.size();
            synchronized (this.this$0) {
                Object[] array = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (array != null) {
                    http2StreamArr = (Http2Stream[]) array;
                    this.this$0.isShutdown = true;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushHeadersLater$okhttp(i, list, z);
                return;
            }
            synchronized (this.this$0) {
                Http2Stream stream = this.this$0.getStream(i);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(list), z);
                } else if (!this.this$0.isShutdown) {
                    if (i > this.this$0.getLastGoodStreamId$okhttp()) {
                        if (i % 2 != this.this$0.getNextStreamId$okhttp() % 2) {
                            Http2Stream http2Stream = new Http2Stream(i, this.this$0, false, z, Util.toHeaders(list));
                            this.this$0.setLastGoodStreamId$okhttp(i);
                            this.this$0.getStreams$okhttp().put(Integer.valueOf(i), http2Stream);
                            String str = this.this$0.getConnectionName$okhttp() + '[' + i + "] onStream";
                            this.this$0.taskRunner.newQueue().schedule(new Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(str, true, str, true, http2Stream, this, stream, i, list, z), 0);
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (z) {
                synchronized (this.this$0) {
                    if (i == 1) {
                        this.this$0.intervalPongsReceived++;
                    } else if (i == 2) {
                        this.this$0.degradedPongsReceived++;
                    } else if (i == 3) {
                        this.this$0.awaitPongsReceived++;
                        Http2Connection http2Connection = this.this$0;
                        if (http2Connection != null) {
                            http2Connection.notifyAll();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                    }
                }
                return;
            }
            String str = this.this$0.getConnectionName$okhttp() + " ping";
            this.this$0.writerQueue.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$1(str, true, str, true, this, i, i2), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, @NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, CommonKt.TAG_ERROR_CODE);
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushResetLater$okhttp(i, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            String str = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            this.this$0.writerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(str, true, str, true, this, z, settings), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (this.this$0) {
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j;
                    Http2Connection http2Connection2 = this.this$0;
                    if (http2Connection2 != null) {
                        http2Connection2.notifyAll();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public void invoke() {
            Throwable th;
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                try {
                    this.this$0.close$okhttp(errorCode, ErrorCode.CANCEL, null);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                        this.this$0.close$okhttp(errorCode3, errorCode3, e);
                        Util.closeQuietly(this.reader);
                    } catch (Throwable th2) {
                        th = th2;
                        this.this$0.close$okhttp(errorCode, errorCode2, e);
                        Util.closeQuietly(this.reader);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                errorCode = errorCode2;
                ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                this.this$0.close$okhttp(errorCode3, errorCode3, e);
                Util.closeQuietly(this.reader);
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                this.this$0.close$okhttp(errorCode, errorCode2, e);
                Util.closeQuietly(this.reader);
                throw th;
            }
            Util.closeQuietly(this.reader);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = (long) settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) builder.getPingIntervalMillis$okhttp());
            String c3 = a.c3(connectionName$okhttp, " ping");
            newQueue.schedule(new Task(c3, c3, this, nanos) { // from class: okhttp3.internal.http2.Http2Connection$$special$$inlined$schedule$1
                public final /* synthetic */ String $name;
                public final /* synthetic */ long $pingIntervalNanos$inlined;
                public final /* synthetic */ Http2Connection this$0;

                {
                    this.$name = r1;
                    this.this$0 = r3;
                    this.$pingIntervalNanos$inlined = r4;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    boolean z;
                    synchronized (this.this$0) {
                        if (this.this$0.intervalPongsReceived < this.this$0.intervalPingsSent) {
                            z = true;
                        } else {
                            Http2Connection http2Connection = this.this$0;
                            http2Connection.intervalPingsSent = http2Connection.intervalPingsSent + 1;
                            z = false;
                        }
                    }
                    if (z) {
                        this.this$0.failConnection(null);
                        return -1;
                    }
                    this.this$0.writePing(false, 1, 0);
                    return this.$pingIntervalNanos$inlined;
                }
            }, nanos);
        }
    }

    private final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, TaskRunner taskRunner2, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            taskRunner2 = TaskRunner.INSTANCE;
        }
        http2Connection.start(z, taskRunner2);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode errorCode, @NotNull ErrorCode errorCode2, @Nullable IOException iOException) {
        int i;
        Intrinsics.checkNotNullParameter(errorCode, "connectionCode");
        Intrinsics.checkNotNullParameter(errorCode2, "streamCode");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            try {
                shutdown(errorCode);
            } catch (IOException unused) {
            }
            Http2Stream[] http2StreamArr = null;
            synchronized (this) {
                if (!this.streams.isEmpty()) {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array != null) {
                        http2StreamArr = (Http2Stream[]) array;
                        this.streams.clear();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(errorCode2, iOException);
                    } catch (IOException unused2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException unused3) {
            }
            try {
                this.socket.close();
            } catch (IOException unused4) {
            }
            this.writerQueue.shutdown();
            this.pushQueue.shutdown();
            this.settingsListenerQueue.shutdown();
            return;
        }
        StringBuilder L = a.L("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        L.append(currentThread.getName());
        L.append(" MUST NOT hold lock on ");
        L.append(this);
        throw new AssertionError(L.toString());
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Nullable
    public final synchronized Http2Stream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> list, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        return newStream(0, list, z);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(int i, @NotNull BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        String str = this.connectionName + '[' + i + "] onData";
        this.pushQueue.schedule(new Task(str, true, str, true, this, i, buffer, i2, z) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
            public final /* synthetic */ Buffer $buffer$inlined;
            public final /* synthetic */ int $byteCount$inlined;
            public final /* synthetic */ boolean $cancelable;
            public final /* synthetic */ boolean $inFinished$inlined;
            public final /* synthetic */ String $name;
            public final /* synthetic */ int $streamId$inlined;
            public final /* synthetic */ Http2Connection this$0;

            {
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = r5;
                this.$streamId$inlined = r6;
                this.$buffer$inlined = r7;
                this.$byteCount$inlined = r8;
                this.$inFinished$inlined = r9;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    boolean onData = this.this$0.pushObserver.onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
                    if (onData) {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    }
                    if (!onData && !this.$inFinished$inlined) {
                        return -1;
                    }
                    synchronized (this.this$0) {
                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    }
                    return -1;
                } catch (IOException unused) {
                    return -1;
                }
            }
        }, 0);
    }

    public final void pushHeadersLater$okhttp(int i, @NotNull List<Header> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        String str = this.connectionName + '[' + i + "] onHeaders";
        this.pushQueue.schedule(new Task(str, true, str, true, this, i, list, z) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$1
            public final /* synthetic */ boolean $cancelable;
            public final /* synthetic */ boolean $inFinished$inlined;
            public final /* synthetic */ String $name;
            public final /* synthetic */ List $requestHeaders$inlined;
            public final /* synthetic */ int $streamId$inlined;
            public final /* synthetic */ Http2Connection this$0;

            {
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = r5;
                this.$streamId$inlined = r6;
                this.$requestHeaders$inlined = r7;
                this.$inFinished$inlined = r8;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean onHeaders = this.this$0.pushObserver.onHeaders(this.$streamId$inlined, this.$requestHeaders$inlined, this.$inFinished$inlined);
                if (onHeaders) {
                    try {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1;
                    }
                }
                if (!onHeaders && !this.$inFinished$inlined) {
                    return -1;
                }
                synchronized (this.this$0) {
                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                }
                return -1;
            }
        }, 0);
    }

    public final void pushRequestLater$okhttp(int i, @NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            String str = this.connectionName + '[' + i + "] onRequest";
            this.pushQueue.schedule(new Task(str, true, str, true, this, i, list) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$1
                public final /* synthetic */ boolean $cancelable;
                public final /* synthetic */ String $name;
                public final /* synthetic */ List $requestHeaders$inlined;
                public final /* synthetic */ int $streamId$inlined;
                public final /* synthetic */ Http2Connection this$0;

                {
                    this.$name = r1;
                    this.$cancelable = r2;
                    this.this$0 = r5;
                    this.$streamId$inlined = r6;
                    this.$requestHeaders$inlined = r7;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    if (!this.this$0.pushObserver.onRequest(this.$streamId$inlined, this.$requestHeaders$inlined)) {
                        return -1;
                    }
                    try {
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1;
                    } catch (IOException unused) {
                        return -1;
                    }
                }
            }, 0);
        }
    }

    public final void pushResetLater$okhttp(int i, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, CommonKt.TAG_ERROR_CODE);
        String str = this.connectionName + '[' + i + "] onReset";
        this.pushQueue.schedule(new Task(str, true, str, true, this, i, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$1
            public final /* synthetic */ boolean $cancelable;
            public final /* synthetic */ ErrorCode $errorCode$inlined;
            public final /* synthetic */ String $name;
            public final /* synthetic */ int $streamId$inlined;
            public final /* synthetic */ Http2Connection this$0;

            {
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = r5;
                this.$streamId$inlined = r6;
                this.$errorCode$inlined = r7;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                this.this$0.pushObserver.onReset(this.$streamId$inlined, this.$errorCode$inlined);
                synchronized (this.this$0) {
                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                }
                return -1;
            }
        }, 0);
    }

    @NotNull
    public final Http2Stream pushStream(int i, @NotNull List<Header> list, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j >= j2) {
                this.degradedPingsSent = j2 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
                TaskQueue taskQueue = this.writerQueue;
                String t = a.t(new StringBuilder(), this.connectionName, " ping");
                taskQueue.schedule(new Task(t, true, t, true, this) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$1
                    public final /* synthetic */ boolean $cancelable;
                    public final /* synthetic */ String $name;
                    public final /* synthetic */ Http2Connection this$0;

                    {
                        this.$name = r1;
                        this.$cancelable = r2;
                        this.this$0 = r5;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePing(false, 2, 0);
                        return -1;
                    }
                }, 0);
            }
        }
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final void setSettings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.okHttpSettings.merge(settings);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(@NotNull ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.isShutdown = true;
                    int i = this.lastGoodStreamId;
                    Unit unit = Unit.INSTANCE;
                    this.writer.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    @JvmOverloads
    public final void start(boolean z) throws IOException {
        start$default(this, z, null, 2, null);
    }

    @JvmOverloads
    public final void start(boolean z, @NotNull TaskRunner taskRunner2) throws IOException {
        Intrinsics.checkNotNullParameter(taskRunner2, "taskRunner");
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - 65535));
            }
        }
        TaskQueue newQueue = taskRunner2.newQueue();
        String str = this.connectionName;
        newQueue.schedule(new TaskQueue$execute$1(this.readerRunnable, str, true, str, true), 0);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r5 - r3), r8.writer.maxDataLength());
        r6 = (long) r3;
        r8.writeBytesTotal += r6;
        r4 = kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeData(int r9, boolean r10, @org.jetbrains.annotations.Nullable okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x006c
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.writeBytesTotal     // Catch:{ InterruptedException -> 0x005d }
            long r5 = r8.writeBytesMaximum     // Catch:{ InterruptedException -> 0x005d }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0032
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x005d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005d }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005d }
            if (r3 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x005d }
            goto L_0x0012
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005d }
            throw r9     // Catch:{ InterruptedException -> 0x005d }
        L_0x0032:
            long r5 = r5 - r3
            long r3 = java.lang.Math.min(r12, r5)     // Catch:{ all -> 0x005b }
            int r4 = (int) r3     // Catch:{ all -> 0x005b }
            okhttp3.internal.http2.Http2Writer r3 = r8.writer     // Catch:{ all -> 0x005b }
            int r3 = r3.maxDataLength()     // Catch:{ all -> 0x005b }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x005b }
            long r4 = r8.writeBytesTotal     // Catch:{ all -> 0x005b }
            long r6 = (long) r3     // Catch:{ all -> 0x005b }
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch:{ all -> 0x005b }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L_0x0056
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0056
            r5 = 1
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            r4.data(r5, r9, r11, r3)
            goto L_0x000d
        L_0x005b:
            r9 = move-exception
            goto L_0x006a
        L_0x005d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException
            r9.<init>()
            throw r9
        L_0x006a:
            monitor-exit(r8)
            throw r9
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writeHeaders$okhttp(int i, boolean z, @NotNull List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "alternating");
        this.writer.headers(z, i, list);
    }

    public final void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i, @NotNull ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter(errorCode, "statusCode");
        this.writer.rstStream(i, errorCode);
    }

    public final void writeSynResetLater$okhttp(int i, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, CommonKt.TAG_ERROR_CODE);
        String str = this.connectionName + '[' + i + "] writeSynReset";
        this.writerQueue.schedule(new Task(str, true, str, true, this, i, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$1
            public final /* synthetic */ boolean $cancelable;
            public final /* synthetic */ ErrorCode $errorCode$inlined;
            public final /* synthetic */ String $name;
            public final /* synthetic */ int $streamId$inlined;
            public final /* synthetic */ Http2Connection this$0;

            {
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = r5;
                this.$streamId$inlined = r6;
                this.$errorCode$inlined = r7;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                    return -1;
                } catch (IOException e) {
                    this.this$0.failConnection(e);
                    return -1;
                }
            }
        }, 0);
    }

    public final void writeWindowUpdateLater$okhttp(int i, long j) {
        String str = this.connectionName + '[' + i + "] windowUpdate";
        this.writerQueue.schedule(new Task(str, true, str, true, this, i, j) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$1
            public final /* synthetic */ boolean $cancelable;
            public final /* synthetic */ String $name;
            public final /* synthetic */ int $streamId$inlined;
            public final /* synthetic */ long $unacknowledgedBytesRead$inlined;
            public final /* synthetic */ Http2Connection this$0;

            {
                this.$name = r1;
                this.$cancelable = r2;
                this.this$0 = r5;
                this.$streamId$inlined = r6;
                this.$unacknowledgedBytesRead$inlined = r7;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                    return -1;
                } catch (IOException e) {
                    this.this$0.failConnection(e);
                    return -1;
                }
            }
        }, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.Http2Writer r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0084 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0081 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0081 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0081 }
        L_0x0013:
            boolean r0 = r10.isShutdown     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x007b
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0081 }
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0081 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0081 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0081 }
            r0 = 1
            if (r13 == 0) goto L_0x0041
            long r1 = r10.writeBytesTotal     // Catch:{ all -> 0x0081 }
            long r3 = r10.writeBytesMaximum     // Catch:{ all -> 0x0081 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0041
            long r1 = r9.getWriteBytesTotal()     // Catch:{ all -> 0x0081 }
            long r3 = r9.getWriteBytesMaximum()     // Catch:{ all -> 0x0081 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r13 = 0
            goto L_0x0042
        L_0x0041:
            r13 = 1
        L_0x0042:
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0051
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r10.streams     // Catch:{ all -> 0x0081 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0081 }
            r1.put(r2, r9)     // Catch:{ all -> 0x0081 }
        L_0x0051:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0081 }
            monitor-exit(r10)
            if (r11 != 0) goto L_0x005c
            okhttp3.internal.http2.Http2Writer r11 = r10.writer
            r11.headers(r6, r8, r12)
            goto L_0x0066
        L_0x005c:
            boolean r1 = r10.client
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x006f
            okhttp3.internal.http2.Http2Writer r0 = r10.writer
            r0.pushPromise(r11, r8, r12)
        L_0x0066:
            monitor-exit(r7)
            if (r13 == 0) goto L_0x006e
            okhttp3.internal.http2.Http2Writer r11 = r10.writer
            r11.flush()
        L_0x006e:
            return r9
        L_0x006f:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        L_0x007b:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException
            r11.<init>()
            throw r11
        L_0x0081:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L_0x0084:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
