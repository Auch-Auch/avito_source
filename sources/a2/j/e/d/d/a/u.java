package a2.j.e.d.d.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
public class u {
    public static final FilenameFilter A = new b();
    public static final Comparator<File> B = new c();
    public static final Comparator<File> C = new d();
    public static final Pattern D = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    public static final Map<String, String> E = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String[] F = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public static final FilenameFilter z = new a("BeginSession");
    public final AtomicInteger a = new AtomicInteger(0);
    public final Context b;
    public final DataCollectionArbiter c;
    public final h0 d;
    public final UserMetadata e;
    public final f f;
    public final HttpRequestFactory g;
    public final IdManager h;
    public final FileStore i;
    public final a j;
    public final ReportUploader.Provider k;
    public final j l;
    public final LogFileManager m;
    public final ReportManager n;
    public final ReportUploader.HandlingExceptionCheck o;
    public final CrashlyticsNativeComponent p;
    public final StackTraceTrimmingStrategy q;
    public final String r;
    public final AnalyticsEventLogger s;
    public final q0 t;
    public i0 u;
    public TaskCompletionSource<Boolean> v = new TaskCompletionSource<>();
    public TaskCompletionSource<Boolean> w = new TaskCompletionSource<>();
    public TaskCompletionSource<Void> x = new TaskCompletionSource<>();
    public AtomicBoolean y = new AtomicBoolean(false);

    public class a extends h {
        public a(String str) {
            super(str);
        }

        @Override // a2.j.e.d.d.a.u.h, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    public class c implements Comparator<File> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    public class d implements Comparator<File> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    public class e implements SuccessContinuation<Boolean, Void> {
        public final /* synthetic */ Task a;
        public final /* synthetic */ float b;

        public e(Task task, float f) {
            this.a = task;
            this.b = f;
        }

        /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        public Task<Void> then(@Nullable Boolean bool) throws Exception {
            return u.this.f.c(new d0(this, bool));
        }
    }

    public static class f implements FilenameFilter {
        public f(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !((b) u.A).accept(file, str) && u.D.matcher(str).matches();
        }
    }

    public interface g {
        void a(CodedOutputStream codedOutputStream) throws Exception;
    }

    public static class h implements FilenameFilter {
        public final String a;

        public h(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    public static final class j implements LogFileManager.DirectoryProvider {
        public final FileStore a;

        public j(FileStore fileStore) {
            this.a = fileStore;
        }

        @Override // com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider
        public File getLogFileDir() {
            File file = new File(this.a.getFilesDir(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    public final class k implements ReportUploader.ReportFilesProvider {
        public k(a aVar) {
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        public File[] getCompleteSessionFiles() {
            return u.this.o();
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        public File[] getNativeReportFiles() {
            File[] listFiles = u.this.k().listFiles();
            return listFiles == null ? new File[0] : listFiles;
        }
    }

    public final class l implements ReportUploader.HandlingExceptionCheck {
        public l(a aVar) {
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.HandlingExceptionCheck
        public boolean isHandlingException() {
            return u.this.n();
        }
    }

    public static final class m implements Runnable {
        public final Context a;
        public final Report b;
        public final ReportUploader c;
        public final boolean d;

        public m(Context context, Report report, ReportUploader reportUploader, boolean z) {
            this.a = context;
            this.b = report;
            this.c = reportUploader;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.canTryConnection(this.a)) {
                Logger.getLogger().d("Attempting to send crash report at time of crash...");
                this.c.uploadReport(this.b, this.d);
            }
        }
    }

    public static class n implements FilenameFilter {
        public final String a;

        public n(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (!str.equals(this.a + ClsFileOutputStream.SESSION_FILE_EXTENSION) && str.contains(this.a) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) {
                return true;
            }
            return false;
        }
    }

    public u(Context context, f fVar, HttpRequestFactory httpRequestFactory, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, h0 h0Var, a aVar, ReportManager reportManager, ReportUploader.Provider provider, CrashlyticsNativeComponent crashlyticsNativeComponent, UnityVersionProvider unityVersionProvider, AnalyticsEventLogger analyticsEventLogger, SettingsDataProvider settingsDataProvider) {
        this.b = context;
        this.f = fVar;
        this.g = httpRequestFactory;
        this.h = idManager;
        this.c = dataCollectionArbiter;
        this.i = fileStore;
        this.d = h0Var;
        this.j = aVar;
        this.k = new e0(this);
        this.p = crashlyticsNativeComponent;
        this.r = unityVersionProvider.getUnityVersion();
        this.s = analyticsEventLogger;
        UserMetadata userMetadata = new UserMetadata();
        this.e = userMetadata;
        j jVar = new j(fileStore);
        this.l = jVar;
        LogFileManager logFileManager = new LogFileManager(context, jVar);
        this.m = logFileManager;
        this.n = new ReportManager(new k(null));
        this.o = new l(null);
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
        this.q = middleOutFallbackStrategy;
        this.t = new q0(new CrashlyticsReportDataCapture(context, idManager, aVar, middleOutFallbackStrategy), new CrashlyticsReportPersistence(new File(fileStore.getFilesDirPath()), settingsDataProvider), DataTransportCrashlyticsReportSender.create(context), logFileManager, userMetadata);
    }

    public static Task a(u uVar) {
        boolean z2;
        Task task;
        Objects.requireNonNull(uVar);
        ArrayList arrayList = new ArrayList();
        File[] p2 = uVar.p(j.a);
        for (File file : p2) {
            try {
                long parseLong = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    task = Tasks.forResult(null);
                } else {
                    task = Tasks.call(new ScheduledThreadPoolExecutor(1), new x(uVar, parseLong));
                }
                arrayList.add(task);
            } catch (NumberFormatException unused2) {
                Logger logger = Logger.getLogger();
                StringBuilder L = a2.b.a.a.a.L("Could not parse timestamp from file ");
                L.append(file.getName());
                logger.d(L.toString());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    public static void b(u uVar) throws Exception {
        Objects.requireNonNull(uVar);
        long h2 = h();
        new e(uVar.h);
        String str = e.b;
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + str);
        uVar.p.openSession(str);
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", CrashlyticsCore.getVersion());
        uVar.x(str, "BeginSession", new r(uVar, str, format, h2));
        uVar.p.writeBeginSession(str, format, h2);
        String appIdentifier = uVar.h.getAppIdentifier();
        a aVar = uVar.j;
        String str2 = aVar.e;
        String str3 = aVar.f;
        String crashlyticsInstallId = uVar.h.getCrashlyticsInstallId();
        int id = DeliveryMechanism.determineFrom(uVar.j.c).getId();
        uVar.x(str, "SessionApp", new s(uVar, appIdentifier, str2, str3, crashlyticsInstallId, id));
        uVar.p.writeSessionApp(str, appIdentifier, str2, str3, crashlyticsInstallId, id, uVar.r);
        String str4 = Build.VERSION.RELEASE;
        String str5 = Build.VERSION.CODENAME;
        boolean isRooted = CommonUtils.isRooted(uVar.b);
        uVar.x(str, "SessionOS", new t(uVar, str4, str5, isRooted));
        uVar.p.writeSessionOs(str, str4, str5, isRooted);
        Context context = uVar.b;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        String str6 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(context);
        int deviceState = CommonUtils.getDeviceState(context);
        String str7 = Build.MANUFACTURER;
        String str8 = Build.PRODUCT;
        uVar.x(str, "SessionDevice", new v(uVar, cpuArchitectureInt, str6, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str7, str8));
        uVar.p.writeSessionDevice(str, cpuArchitectureInt, str6, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str7, str8);
        uVar.m.setCurrentSession(str);
        q0 q0Var = uVar.t;
        String replaceAll = str.replaceAll("-", "");
        q0Var.f = replaceAll;
        q0Var.b.persistReport(q0Var.a.captureReportData(replaceAll, h2));
    }

    public static void c(@Nullable String str, @NonNull File file) throws Exception {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (str != null) {
            CodedOutputStream codedOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    codedOutputStream = CodedOutputStream.newInstance(fileOutputStream);
                    SessionProtobufHelper.writeSessionAppClsId(codedOutputStream, str);
                    StringBuilder L = a2.b.a.a.a.L("Failed to flush to append to ");
                    L.append(file.getPath());
                    CommonUtils.flushOrLog(codedOutputStream, L.toString());
                    CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
                } catch (Throwable th2) {
                    th = th2;
                    StringBuilder L2 = a2.b.a.a.a.L("Failed to flush to append to ");
                    L2.append(file.getPath());
                    CommonUtils.flushOrLog(codedOutputStream, L2.toString());
                    CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                StringBuilder L2 = a2.b.a.a.a.L("Failed to flush to append to ");
                L2.append(file.getPath());
                CommonUtils.flushOrLog(codedOutputStream, L2.toString());
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        }
    }

    public static long h() {
        return new Date().getTime() / 1000;
    }

    public static String m(File file) {
        return file.getName().substring(0, 35);
    }

    public static void v(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.FILE_MODIFIED_COMPARATOR);
        for (File file : fileArr) {
            try {
                Logger.getLogger().d(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                y(codedOutputStream, file);
            } catch (Exception e2) {
                Logger.getLogger().e("Error writting non-fatal to session.", e2);
            }
        }
    }

    public static void y(CodedOutputStream codedOutputStream, File file) throws IOException {
        Throwable th;
        if (!file.exists()) {
            Logger logger = Logger.getLogger();
            StringBuilder L = a2.b.a.a.a.L("Tried to include a file that doesn't exist: ");
            L.append(file.getName());
            logger.e(L.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int length = (int) file.length();
                byte[] bArr = new byte[length];
                int i2 = 0;
                while (i2 < length) {
                    int read = fileInputStream2.read(bArr, i2, length - i2);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                codedOutputStream.writeRawBytes(bArr);
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    public final void d(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException e2) {
                Logger.getLogger().e("Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.Closeable] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0472 A[LOOP:5: B:134:0x0470->B:135:0x0472, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r14, boolean r15) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 1180
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.e.d.d.a.u.e(int, boolean):void");
    }

    public boolean f(int i2) {
        this.f.a();
        if (n()) {
            Logger.getLogger().d("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().d("Finalizing previously open sessions.");
        try {
            e(i2, false);
            Logger.getLogger().d("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    public final String g() {
        File[] q2 = q();
        if (q2.length > 0) {
            return m(q2[0]);
        }
        return null;
    }

    public File i() {
        return new File(j(), "fatal-sessions");
    }

    public File j() {
        return this.i.getFilesDir();
    }

    public File k() {
        return new File(j(), "native-sessions");
    }

    public File l() {
        return new File(j(), "nonfatal-sessions");
    }

    public boolean n() {
        i0 i0Var = this.u;
        return i0Var != null && i0Var.d.get();
    }

    public File[] o() {
        LinkedList linkedList = new LinkedList();
        File i2 = i();
        FilenameFilter filenameFilter = A;
        File[] listFiles = i2.listFiles(filenameFilter);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        Collections.addAll(linkedList, listFiles);
        File[] listFiles2 = l().listFiles(filenameFilter);
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        Collections.addAll(linkedList, listFiles2);
        File[] listFiles3 = j().listFiles(filenameFilter);
        if (listFiles3 == null) {
            listFiles3 = new File[0];
        }
        Collections.addAll(linkedList, listFiles3);
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public final File[] p(FilenameFilter filenameFilter) {
        File[] listFiles = j().listFiles(filenameFilter);
        return listFiles == null ? new File[0] : listFiles;
    }

    public final File[] q() {
        File[] p2 = p(z);
        Arrays.sort(p2, B);
        return p2;
    }

    public Task<Void> r(float f2, Task<AppSettingsData> task) {
        Task task2;
        if (!this.n.areReportsAvailable()) {
            Logger.getLogger().d("No reports are available.");
            this.v.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Unsent reports are available.");
        if (this.c.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.v.trySetResult(Boolean.FALSE);
            task2 = Tasks.forResult(Boolean.TRUE);
        } else {
            Logger.getLogger().d("Automatic data collection is disabled.");
            Logger.getLogger().d("Notifying that unsent reports are available.");
            this.v.trySetResult(Boolean.TRUE);
            Task<TContinuationResult> onSuccessTask = this.c.waitForAutomaticDataCollectionEnabled().onSuccessTask(new b0(this));
            Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
            task2 = Utils.race(onSuccessTask, this.w.getTask());
        }
        return task2.onSuccessTask(new e(task, f2));
    }

    public final void s(String str, int i2) {
        Utils.a(j(), new h(a2.b.a.a.a.c3(str, "SessionEvent")), i2, C);
    }

    public final void t(long j2) {
        try {
            File j3 = j();
            new File(j3, ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            Logger.getLogger().d("Could not write app exception marker.");
        }
    }

    public final void u(CodedOutputStream codedOutputStream, String str) throws IOException {
        String[] strArr = F;
        for (String str2 : strArr) {
            File[] p2 = p(new h(a2.b.a.a.a.e3(str, str2, ClsFileOutputStream.SESSION_FILE_EXTENSION)));
            if (p2.length == 0) {
                Logger.getLogger().d("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger.getLogger().d("Collecting " + str2 + " data for session ID " + str);
                y(codedOutputStream, p2[0]);
            }
        }
    }

    public final void w(CodedOutputStream codedOutputStream, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        TreeMap treeMap;
        Map<String, String> map;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.q);
        Context context = this.b;
        c a3 = c.a(context);
        Float f2 = a3.a;
        int b2 = a3.b();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(context);
        int i2 = context.getResources().getConfiguration().orientation;
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(context);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.j.b;
        String appIdentifier = this.h.getAppIdentifier();
        int i3 = 0;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i3] = entry.getKey();
                linkedList.add(this.q.getTrimmedStackTrace(entry.getValue()));
                i3++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectCustomKeys", true)) {
            map = new TreeMap<>();
        } else {
            map = this.e.getCustomKeys();
            if (map != null && map.size() > 1) {
                treeMap = new TreeMap(map);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, j2, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.m.getBytesForLog(), appProcessInfo, i2, appIdentifier, str2, f2, b2, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
                this.m.clearLog();
            }
        }
        treeMap = map;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, j2, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.m.getBytesForLog(), appProcessInfo, i2, appIdentifier, str2, f2, b2, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
        this.m.clearLog();
    }

    public final void x(String str, String str2, g gVar) throws Exception {
        Throwable th;
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream newInstance;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(j(), str + str2);
            try {
                newInstance = CodedOutputStream.newInstance(clsFileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
            try {
                gVar.a(newInstance);
                CommonUtils.flushOrLog(newInstance, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            } catch (Throwable th3) {
                th = th3;
                codedOutputStream = newInstance;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }
}
