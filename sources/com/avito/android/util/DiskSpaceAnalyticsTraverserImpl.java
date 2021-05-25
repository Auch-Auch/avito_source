package com.avito.android.util;

import a2.g.r.g;
import android.support.v4.media.session.PlaybackStateCompat;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import t6.q.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001d8B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010(\u001a\u00020\f8B@\u0002X\u0002¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b&\u0010'R%\u0010,\u001a\n )*\u0004\u0018\u00010\u00050\u00058B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/util/DiskSpaceAnalyticsTraverserImpl;", "Lcom/avito/android/util/DiskSpaceAnalyticsTraverser;", "", "traverse", "()V", "", "key", "", "value", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;J)V", "type", "Ljava/io/File;", "file", "fileSize", "c", "(Ljava/lang/String;Ljava/io/File;J)V", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "f", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/util/DataDirectoryProvider;", "d", "Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "Lcom/avito/android/util/DataDiskUsageDelegate;", "e", "Lcom/avito/android/util/DataDiskUsageDelegate;", "delegate", "Lkotlin/text/Regex;", "Lkotlin/Lazy;", "getCleanUpRegex", "()Lkotlin/text/Regex;", "cleanUpRegex", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.SEND_ABUSE, "()Ljava/io/File;", "dataDir", "kotlin.jvm.PlatformType", "getFilePathPrefixToRemove", "()Ljava/lang/String;", "filePathPrefixToRemove", "<init>", "(Lcom/avito/android/util/DataDirectoryProvider;Lcom/avito/android/util/DataDiskUsageDelegate;Lcom/avito/android/analytics/grafana/GraphitePrefix;Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DiskSpaceAnalyticsTraverserImpl implements DiskSpaceAnalyticsTraverser {
    public final Lazy a = t6.c.lazy(new b(this));
    public final Lazy b = t6.c.lazy(a.a);
    public final Lazy c = t6.c.lazy(new c(this));
    public final DataDirectoryProvider d;
    public final DataDiskUsageDelegate e;
    public final GraphitePrefix f;
    public final Analytics g;

    public static final class a extends Lambda implements Function0<Regex> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Regex invoke() {
            return new Regex("[^a-zA-Z0-9_\\-/+=#]");
        }
    }

    public static final class b extends Lambda implements Function0<File> {
        public final /* synthetic */ DiskSpaceAnalyticsTraverserImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DiskSpaceAnalyticsTraverserImpl diskSpaceAnalyticsTraverserImpl) {
            super(0);
            this.a = diskSpaceAnalyticsTraverserImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            return this.a.d.getDataDir();
        }
    }

    public static final class c extends Lambda implements Function0<String> {
        public final /* synthetic */ DiskSpaceAnalyticsTraverserImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DiskSpaceAnalyticsTraverserImpl diskSpaceAnalyticsTraverserImpl) {
            super(0);
            this.a = diskSpaceAnalyticsTraverserImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return this.a.a().getCanonicalPath();
        }
    }

    @Inject
    public DiskSpaceAnalyticsTraverserImpl(@NotNull DataDirectoryProvider dataDirectoryProvider, @NotNull DataDiskUsageDelegate dataDiskUsageDelegate, @NotNull GraphitePrefix graphitePrefix, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        Intrinsics.checkNotNullParameter(dataDiskUsageDelegate, "delegate");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = dataDirectoryProvider;
        this.e = dataDiskUsageDelegate;
        this.f = graphitePrefix;
        this.g = analytics;
    }

    public final File a() {
        return (File) this.a.getValue();
    }

    public final void b(String str, long j) {
        Analytics analytics = this.g;
        analytics.track(new StatsdEvent.TimeEvent(this.f.getVersionsPrefix() + ".performance.disk_space_info." + str, Long.valueOf(j)));
    }

    public final void c(String str, File file, long j) {
        String str2 = (String) this.c.getValue();
        Intrinsics.checkNotNullExpressionValue(str2, "filePathPrefixToRemove");
        String access$getName = DiskSpaceAnalyticsTraverserKt.access$getName(file, str2, (Regex) this.b.getValue());
        b("resource_size." + str + FormatterType.defaultDecimalSeparator + access$getName, j);
    }

    @Override // com.avito.android.util.DiskSpaceAnalyticsTraverser
    public void traverse() {
        long dataSize = this.e.getDataSize();
        b("total_resources_space", this.e.getDataSize());
        b("total_system_space", a().getTotalSpace());
        b("free_system_space", a().getFreeSpace());
        long max = Math.max(dataSize / 10, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        long max2 = Math.max(dataSize / 100, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        File[] listFiles = a().listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "dataDir.listFiles()");
        for (File file : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file, "root");
            for (File file2 : d.walk$default(file, null, 1, null)) {
                long size = Files.size(file2);
                if (file2.isFile() && size >= max2) {
                    c("file", file2, size);
                } else if (size >= max) {
                    c("dir", file2, size);
                }
            }
        }
    }
}
