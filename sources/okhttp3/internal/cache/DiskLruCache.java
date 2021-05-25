package okhttp3.internal.cache;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001H\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004mnopB9\b\u0000\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010W\u001a\u00020D\u0012\u0006\u0010P\u001a\u000209\u0012\u0006\u0010Z\u001a\u000209\u0012\u0006\u0010_\u001a\u00020\u001b\u0012\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0016\u0010\u0005J\u001e\u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\b\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001b¢\u0006\u0004\b \u0010!J#\u0010&\u001a\u00020\u00032\n\u0010\"\u001a\u00060\u001dR\u00020\u00002\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u001b\u0010-\u001a\u00020\u000e2\n\u0010*\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b.\u0010\u0005J\r\u0010/\u001a\u00020\u000e¢\u0006\u0004\b/\u0010\u0010J\u000f\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\b0\u0010\u0005J\r\u00101\u001a\u00020\u0003¢\u0006\u0004\b1\u0010\u0005J\r\u00102\u001a\u00020\u0003¢\u0006\u0004\b2\u0010\u0005J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\b3\u0010\u0005J\u0017\u00105\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u000004¢\u0006\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010>R\"\u0010?\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b?\u0010=\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010=R\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010L\u001a\u00020K8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0016\u0010P\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010;R\u0016\u0010Q\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010=R\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010=R\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010>R\u0019\u0010W\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010F\u001a\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0002098\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bZ\u0010;\u001a\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010=R*\u0010_\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\u001b8F@FX\u000e¢\u0006\u0012\n\u0004\b_\u0010>\u001a\u0004\b`\u0010!\"\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010FR,\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u00060)R\u00020\u00000d8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010h¨\u0006q"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "", "readJournal", "()V", "Lokio/BufferedSink;", "newJournalWriter", "()Lokio/BufferedSink;", "", "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "", "journalRebuildRequired", "()Z", "checkNotClosed", "removeOldestEntry", "key", "validateKey", "initialize", "rebuildJournal$okhttp", "rebuildJournal", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "success", "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "close", "trimToSize", PhoneActionStrings.REMOVE, "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "journalWriter", "Lokio/BufferedSink;", "", "redundantOpCount", "I", "initialized", "Z", "J", "closed", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "mostRecentTrimFailed", "Ljava/io/File;", "journalFile", "Ljava/io/File;", "journalFileTmp", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "appVersion", "civilizedFileSystem", "hasJournalErrors", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "nextSequenceNumber", "directory", "getDirectory", "()Ljava/io/File;", "valueCount", "getValueCount$okhttp", "()I", "mostRecentRebuildFailed", "value", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "getMaxSize", "setMaxSize", "(J)V", "journalFileBackup", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class DiskLruCache implements Closeable, Flushable {
    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = -1;
    @JvmField
    @NotNull
    public static final String CLEAN = "CLEAN";
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final String DIRTY = "DIRTY";
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE = "journal";
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    @JvmField
    @NotNull
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    @JvmField
    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";
    @JvmField
    @NotNull
    public static final String READ = "READ";
    @JvmField
    @NotNull
    public static final String REMOVE = "REMOVE";
    @JvmField
    @NotNull
    public static final String VERSION_1 = "1";
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    @NotNull
    private final File directory;
    @NotNull
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    @NotNull
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0007XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "", "ANY_SEQUENCE_NUMBER", "J", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "Lkotlin/text/Regex;", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0015\u001a\u00060\u0013R\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0015\u001a\u00060\u0013R\u00020\u00148\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "", "detach$okhttp", "()V", "detach", "", FirebaseAnalytics.Param.INDEX, "Lokio/Source;", "newSource", "(I)Lokio/Source;", "Lokio/Sink;", "newSink", "(I)Lokio/Sink;", "commit", "abort", "", PaymentStateKt.PAYMENT_STATE_DONE, "Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "written", "[Z", "getWritten$okhttp", "()[Z", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Editor {
        private boolean done;
        @NotNull
        private final Entry entry;
        public final /* synthetic */ DiskLruCache this$0;
        @Nullable
        private final boolean[] written;

        public Editor(@NotNull DiskLruCache diskLruCache, Entry entry2) {
            Intrinsics.checkNotNullParameter(entry2, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry2;
            this.written = entry2.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                return;
            }
            if (this.this$0.civilizedFileSystem) {
                this.this$0.completeEdit$okhttp(this, false);
            } else {
                this.entry.setZombie$okhttp(true);
            }
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        @NotNull
        public final Sink newSink(int i) {
            synchronized (this.this$0) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                } else if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    return Okio.blackhole();
                } else {
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        Intrinsics.checkNotNull(zArr);
                        zArr[i] = true;
                    }
                    try {
                        return new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i)), new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, i));
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                }
            }
        }

        @Nullable
        public final Source newSource(int i) {
            synchronized (this.this$0) {
                if (!this.done) {
                    Source source = null;
                    if (!this.entry.getReadable$okhttp() || (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) || this.entry.getZombie$okhttp()) {
                        return null;
                    }
                    try {
                        source = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i));
                    } catch (FileNotFoundException unused) {
                    }
                    return source;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010:\u001a\u00020\u0003¢\u0006\u0004\bJ\u0010KJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u001a\u001a\b\u0018\u00010\u0016R\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u00178\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u00020\"8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00104\u001a\u00020\b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u00020\u00038\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020>8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bE\u0010@\u001a\u0004\bF\u0010B\"\u0004\bG\u0010DR\"\u0010H\u001a\b\u0012\u0004\u0012\u00020/0.8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bH\u00101\u001a\u0004\bI\u00103¨\u0006L"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "", "strings", "", "invalidLengths", "(Ljava/util/List;)Ljava/lang/Void;", "", FirebaseAnalytics.Param.INDEX, "Lokio/Source;", "newSource", "(I)Lokio/Source;", "", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lokio/BufferedSink;", "writer", "writeLengths$okhttp", "(Lokio/BufferedSink;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "", "lengths", "[J", "getLengths$okhttp", "()[J", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "", "Ljava/io/File;", "cleanFiles", "Ljava/util/List;", "getCleanFiles$okhttp", "()Ljava/util/List;", "lockingSourceCount", "I", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "key", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "dirtyFiles", "getDirtyFiles$okhttp", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Entry {
        @NotNull
        private final List<File> cleanFiles = new ArrayList();
        @Nullable
        private Editor currentEditor;
        @NotNull
        private final List<File> dirtyFiles = new ArrayList();
        @NotNull
        private final String key;
        @NotNull
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(@NotNull DiskLruCache diskLruCache, String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FormatterType.defaultDecimalSeparator);
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                sb.append(i);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(this, source, source);
        }

        @NotNull
        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        @NotNull
        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(@NotNull List<String> list) throws IOException {
            Intrinsics.checkNotNullParameter(list, "strings");
            if (list.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    invalidLengths(list);
                    throw new KotlinNothingValueException();
                }
            } else {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                StringBuilder L = a.L("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                L.append(currentThread.getName());
                L.append(" MUST hold lock on ");
                L.append(diskLruCache);
                throw new AssertionError(L.toString());
            } else if (!this.readable) {
                return null;
            } else {
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                ArrayList<Source> arrayList = new ArrayList();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i = 0; i < valueCount$okhttp; i++) {
                        arrayList.add(newSource(i));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (Source source : arrayList) {
                        Util.closeQuietly(source);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink bufferedSink) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSink, "writer");
            for (long j : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", FirebaseAnalytics.Param.INDEX, "Lokio/Source;", "getSource", "(I)Lokio/Source;", "", "getLength", "(I)J", "", "close", "()V", "", "lengths", "[J", "sequenceNumber", "J", "Ljava/lang/String;", "", "sources", "Ljava/util/List;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        public final /* synthetic */ DiskLruCache this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends okio.Source> */
        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(@NotNull DiskLruCache diskLruCache, String str, @NotNull long j, @NotNull List<? extends Source> list, long[] jArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }

        @Nullable
        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        @NotNull
        public final Source getSource(int i) {
            return this.sources.get(i);
        }

        @NotNull
        public final String key() {
            return this.key;
        }
    }

    public DiskLruCache(@NotNull FileSystem fileSystem2, @NotNull File file, int i, int i2, long j, @NotNull TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i;
        this.valueCount = i2;
        this.maxSize = j;
        boolean z = false;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, a.t(new StringBuilder(), Util.okHttpName, " Cache"));
        if (j > 0) {
            if (i2 > 0 ? true : z) {
                this.journalFile = new File(file, JOURNAL_FILE);
                this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* access modifiers changed from: public */
    private final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new Function1<IOException, Unit>(this) { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            public final /* synthetic */ DiskLruCache this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                invoke(iOException);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IOException iOException) {
                Intrinsics.checkNotNullParameter(iOException, "it");
                DiskLruCache diskLruCache = this.this$0;
                if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
                    this.this$0.hasJournalErrors = true;
                    return;
                }
                StringBuilder L = a.L("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                L.append(currentThread.getName());
                L.append(" MUST hold lock on ");
                L.append(diskLruCache);
                throw new AssertionError(L.toString());
            }
        }));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b5, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer(r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b3 }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b3 }
            java.lang.String r7 = okhttp3.internal.cache.DiskLruCache.MAGIC     // Catch:{ all -> 0x00b3 }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)     // Catch:{ all -> 0x00b3 }
            r8 = 1
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0084
            java.lang.String r7 = okhttp3.internal.cache.DiskLruCache.VERSION_1     // Catch:{ all -> 0x00b3 }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r3)     // Catch:{ all -> 0x00b3 }
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0084
            int r7 = r9.appVersion     // Catch:{ all -> 0x00b3 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00b3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)     // Catch:{ all -> 0x00b3 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0084
            int r4 = r9.valueCount     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00b3 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ all -> 0x00b3 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0084
            int r4 = r6.length()     // Catch:{ all -> 0x00b3 }
            r7 = 0
            if (r4 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 != 0) goto L_0x0084
        L_0x005a:
            java.lang.String r0 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x0064 }
            r9.readJournalLine(r0)     // Catch:{ EOFException -> 0x0064 }
            int r7 = r7 + 1
            goto L_0x005a
        L_0x0064:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r9.lruEntries
            int r0 = r0.size()
            int r7 = r7 - r0
            r9.redundantOpCount = r7
            boolean r0 = r1.exhausted()
            if (r0 != 0) goto L_0x0077
            r9.rebuildJournal$okhttp()
            goto L_0x007d
        L_0x0077:
            okio.BufferedSink r0 = r9.newJournalWriter()
            r9.journalWriter = r0
        L_0x007d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            return
        L_0x0084:
            java.io.IOException r4 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)
            r7.append(r2)
            r7.append(r0)
            r7.append(r3)
            r7.append(r0)
            r7.append(r5)
            r7.append(r0)
            r7.append(r6)
            r0 = 93
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r4.<init>(r0)
            throw r4
        L_0x00b3:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str2 = str.substring(i);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
                String str3 = REMOVE;
                if (indexOf$default == str3.length() && m.startsWith$default(str, str3, false, 2, null)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str2 = str.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf$default2 != -1) {
                String str4 = CLEAN;
                if (indexOf$default == str4.length() && m.startsWith$default(str, str4, false, 2, null)) {
                    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(indexOf$default2 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp(null);
                    entry.setLengths$okhttp(split$default);
                    return;
                }
            }
            if (indexOf$default2 == -1) {
                String str5 = DIRTY;
                if (indexOf$default == str5.length() && m.startsWith$default(str, str5, false, 2, null)) {
                    entry.setCurrentEditor$okhttp(new Editor(this, entry));
                    return;
                }
            }
            if (indexOf$default2 == -1) {
                String str6 = READ;
                if (indexOf$default == str6.length() && m.startsWith$default(str, str6, false, 2, null)) {
                    return;
                }
            }
            throw new IOException(a.c3("unexpected journal line: ", str));
        }
        throw new IOException(a.c3("unexpected journal line: ", str));
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie$okhttp()) {
                Intrinsics.checkNotNullExpressionValue(entry, "toEvict");
                removeEntry$okhttp(entry);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(a.d3("keys must match regex [a-z0-9_-]{1,120}: \"", str, Typography.quote).toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        if (this.initialized) {
            if (!this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array != null) {
                    Entry[] entryArr = (Entry[]) array;
                    for (Entry entry : entryArr) {
                        if (!(entry.getCurrentEditor$okhttp() == null || (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) == null)) {
                            currentEditor$okhttp.detach$okhttp();
                        }
                    }
                    trimToSize();
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.closed = true;
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor editor, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (Intrinsics.areEqual(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            if (z && !entry$okhttp.getReadable$okhttp()) {
                int i = this.valueCount;
                for (int i2 = 0; i2 < i; i2++) {
                    boolean[] written$okhttp = editor.getWritten$okhttp();
                    Intrinsics.checkNotNull(written$okhttp);
                    if (!written$okhttp[i2]) {
                        editor.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i2))) {
                        editor.abort();
                        return;
                    }
                }
            }
            int i3 = this.valueCount;
            for (int i4 = 0; i4 < i3; i4++) {
                File file = entry$okhttp.getDirtyFiles$okhttp().get(i4);
                if (!z || entry$okhttp.getZombie$okhttp()) {
                    this.fileSystem.delete(file);
                } else if (this.fileSystem.exists(file)) {
                    File file2 = entry$okhttp.getCleanFiles$okhttp().get(i4);
                    this.fileSystem.rename(file, file2);
                    long j = entry$okhttp.getLengths$okhttp()[i4];
                    long size2 = this.fileSystem.size(file2);
                    entry$okhttp.getLengths$okhttp()[i4] = size2;
                    this.size = (this.size - j) + size2;
                }
            }
            entry$okhttp.setCurrentEditor$okhttp(null);
            if (entry$okhttp.getZombie$okhttp()) {
                removeEntry$okhttp(entry$okhttp);
                return;
            }
            this.redundantOpCount++;
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            if (entry$okhttp.getReadable$okhttp() || z) {
                entry$okhttp.setReadable$okhttp(true);
                bufferedSink.writeUtf8(CLEAN).writeByte(32);
                bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
                entry$okhttp.writeLengths$okhttp(bufferedSink);
                bufferedSink.writeByte(10);
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    entry$okhttp.setSequenceNumber$okhttp(j2);
                }
            } else {
                this.lruEntries.remove(entry$okhttp.getKey$okhttp());
                bufferedSink.writeUtf8(REMOVE).writeByte(32);
                bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
                bufferedSink.writeByte(10);
            }
            bufferedSink.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @JvmOverloads
    @Nullable
    public final Editor edit(@NotNull String str) throws IOException {
        return edit$default(this, str, 0, 2, null);
    }

    @JvmOverloads
    @Nullable
    public final synchronized Editor edit(@NotNull String str, long j) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (this.mostRecentTrimFailed || this.mostRecentRebuildFailed) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
            return null;
        }
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
        bufferedSink.flush();
        if (this.hasJournalErrors) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(this, str);
            this.lruEntries.put(str, entry);
        }
        Editor editor = new Editor(this, entry);
        entry.setCurrentEditor$okhttp(editor);
        return editor;
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            Entry[] entryArr = (Entry[]) array;
            for (Entry entry : entryArr) {
                Intrinsics.checkNotNullExpressionValue(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(entry, "lruEntries[key] ?: return null");
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
        return snapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(this);
                throw new AssertionError(sb.toString());
            }
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.Companion.get();
                    platform.log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00be, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bf, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$okhttp() throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            okio.BufferedSink r0 = r7.journalWriter     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00c3 }
        L_0x0008:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFileTmp     // Catch:{ all -> 0x00c3 }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00c3 }
            okio.BufferedSink r0 = okio.Okio.buffer(r0)     // Catch:{ all -> 0x00c3 }
            r1 = 0
            java.lang.String r2 = okhttp3.internal.cache.DiskLruCache.MAGIC     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00bc }
            r3 = 10
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = okhttp3.internal.cache.DiskLruCache.VERSION_1     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            int r2 = r7.appVersion     // Catch:{ all -> 0x00bc }
            long r4 = (long) r2     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            int r2 = r7.valueCount     // Catch:{ all -> 0x00bc }
            long r4 = (long) r2     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r2 = r7.lruEntries     // Catch:{ all -> 0x00bc }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00bc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00bc }
        L_0x004a:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00bc }
            okhttp3.internal.cache.DiskLruCache$Entry r4 = (okhttp3.internal.cache.DiskLruCache.Entry) r4     // Catch:{ all -> 0x00bc }
            okhttp3.internal.cache.DiskLruCache$Editor r5 = r4.getCurrentEditor$okhttp()     // Catch:{ all -> 0x00bc }
            r6 = 32
            if (r5 == 0) goto L_0x0072
            java.lang.String r5 = okhttp3.internal.cache.DiskLruCache.DIRTY     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r4.getKey$okhttp()     // Catch:{ all -> 0x00bc }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            goto L_0x004a
        L_0x0072:
            java.lang.String r5 = okhttp3.internal.cache.DiskLruCache.CLEAN     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r4.getKey$okhttp()     // Catch:{ all -> 0x00bc }
            r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r4.writeLengths$okhttp(r0)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            goto L_0x004a
        L_0x0089:
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem
            java.io.File r1 = r7.journalFile
            boolean r0 = r0.exists(r1)
            if (r0 == 0) goto L_0x009f
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem
            java.io.File r1 = r7.journalFile
            java.io.File r2 = r7.journalFileBackup
            r0.rename(r1, r2)
        L_0x009f:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem
            java.io.File r1 = r7.journalFileTmp
            java.io.File r2 = r7.journalFile
            r0.rename(r1, r2)
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem
            java.io.File r1 = r7.journalFileBackup
            r0.delete(r1)
            okio.BufferedSink r0 = r7.newJournalWriter()
            r7.journalWriter = r0
            r0 = 0
            r7.hasJournalErrors = r0
            r7.mostRecentRebuildFailed = r0
            monitor-exit(r7)
            return
        L_0x00bc:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00be }
        L_0x00be:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x00c3:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.rebuildJournal$okhttp():void");
    }

    public final synchronized boolean remove(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(entry, "lruEntries[key] ?: return false");
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry entry) throws IOException {
        BufferedSink bufferedSink;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    @NotNull
    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Object(this) { // from class: okhttp3.internal.cache.DiskLruCache$snapshots$1
            private final Iterator<DiskLruCache.Entry> delegate;
            private DiskLruCache.Snapshot nextSnapshot;
            private DiskLruCache.Snapshot removeSnapshot;
            public final /* synthetic */ DiskLruCache this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r2;
                Iterator<DiskLruCache.Entry> it = new ArrayList(r2.getLruEntries$okhttp().values()).iterator();
                Intrinsics.checkNotNullExpressionValue(it, "ArrayList(lruEntries.values).iterator()");
                this.delegate = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                DiskLruCache.Snapshot snapshot$okhttp;
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (this.this$0) {
                    if (this.this$0.getClosed$okhttp()) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        DiskLruCache.Entry next = this.delegate.next();
                        if (next != null && (snapshot$okhttp = next.snapshot$okhttp()) != null) {
                            this.nextSnapshot = snapshot$okhttp;
                            return true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return false;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                DiskLruCache.Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        this.this$0.remove(snapshot.key());
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        this.removeSnapshot = null;
                        throw th;
                    }
                    this.removeSnapshot = null;
                    return;
                }
                throw new IllegalStateException("remove() before next()".toString());
            }

            @Override // java.util.Iterator
            @NotNull
            public DiskLruCache.Snapshot next() {
                if (hasNext()) {
                    DiskLruCache.Snapshot snapshot = this.nextSnapshot;
                    this.removeSnapshot = snapshot;
                    this.nextSnapshot = null;
                    Intrinsics.checkNotNull(snapshot);
                    return snapshot;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}
