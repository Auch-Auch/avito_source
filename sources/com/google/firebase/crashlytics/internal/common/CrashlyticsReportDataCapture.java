package com.google.firebase.crashlytics.internal.common;

import a2.j.e.d.d.a.a;
import a2.j.e.d.d.a.c;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class CrashlyticsReportDataCapture {
    public static final String e = String.format(Locale.US, "Crashlytics Android SDK/%s", BuildConfig.VERSION_NAME);
    public static final Map<String, Integer> f;
    public final Context a;
    public final IdManager b;
    public final a c;
    public final StackTraceTrimmingStrategy d;

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        a2.b.a.a.a.D0(5, hashMap, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        hashMap.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, a aVar, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.a = context;
        this.b = idManager;
        this.c = aVar;
        this.d = stackTraceTrimmingStrategy;
    }

    public final CrashlyticsReport.Builder a() {
        return CrashlyticsReport.builder().setSdkVersion(BuildConfig.VERSION_NAME).setGmpAppId(this.c.a).setInstallationUuid(this.b.getCrashlyticsInstallId()).setBuildVersion(this.c.e).setDisplayVersion(this.c.f).setPlatform(4);
    }

    public final CrashlyticsReport.Session.Event.Application.Execution.Exception b(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.className;
        String str2 = trimmedThrowableData.localizedMessage;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.cause;
                i4++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder overflowCount = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder().setType(str).setReason(str2).setFrames(ImmutableList.from(c(stackTraceElementArr, i))).setOverflowCount(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            overflowCount.setCausedBy(b(trimmedThrowableData2, i, i2, i3 + 1));
        }
        return overflowCount.build();
    }

    public final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder importance = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder().setImportance(i);
            long j = 0;
            long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0L) : 0;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                j = (long) stackTraceElement.getLineNumber();
            }
            arrayList.add(importance.setPc(max).setSymbol(str).setFile(fileName).setOffset(j).build());
        }
        return ImmutableList.from(arrayList);
    }

    public CrashlyticsReport.Session.Event captureEventData(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        Boolean bool;
        int i3 = this.a.getResources().getConfiguration().orientation;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.d);
        CrashlyticsReport.Session.Event.Builder timestamp = CrashlyticsReport.Session.Event.builder().setType(str).setTimestamp(j);
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(this.c.d, this.a);
        Double d2 = null;
        if (appProcessInfo != null) {
            bool = Boolean.valueOf(appProcessInfo.importance != 100);
        } else {
            bool = null;
        }
        CrashlyticsReport.Session.Event.Application.Builder uiOrientation = CrashlyticsReport.Session.Event.Application.builder().setBackground(bool).setUiOrientation(i3);
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(thread, trimmedThrowableData.stacktrace, i));
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(d(key, this.d.getTrimmedStackTrace(entry.getValue()), 0));
                }
            }
        }
        CrashlyticsReport.Session.Event.Builder app = timestamp.setApp(uiOrientation.setExecution(builder.setThreads(ImmutableList.from(arrayList)).setException(b(trimmedThrowableData, i, i2, 0)).setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal.builder().setName("0").setCode("0").setAddress(0).build()).setBinaries(ImmutableList.from(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder().setBaseAddress(0).setSize(0).setName(this.c.d).setUuid(this.c.b).build())).build()).build());
        c a3 = c.a(this.a);
        Float f2 = a3.a;
        if (f2 != null) {
            d2 = Double.valueOf(f2.doubleValue());
        }
        return app.setDevice(CrashlyticsReport.Session.Event.Device.builder().setBatteryLevel(d2).setBatteryVelocity(a3.b()).setProximityOn(CommonUtils.getProximitySensorEnabled(this.a)).setOrientation(i3).setRamUsed(CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(this.a)).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build()).build();
    }

    public CrashlyticsReport captureReportData(String str, long j) {
        Integer num;
        CrashlyticsReport.Builder a3 = a();
        CrashlyticsReport.Session.Builder os = CrashlyticsReport.Session.builder().setStartedAt(j).setIdentifier(str).setGenerator(e).setApp(CrashlyticsReport.Session.Application.builder().setIdentifier(this.b.getAppIdentifier()).setVersion(this.c.e).setDisplayVersion(this.c.f).setInstallationUuid(this.b.getCrashlyticsInstallId()).build()).setOs(CrashlyticsReport.Session.OperatingSystem.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted(this.a)).build());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str2 = Build.CPU_ABI;
        int i = 7;
        if (!TextUtils.isEmpty(str2) && (num = f.get(str2.toLowerCase(Locale.US))) != null) {
            i = num.intValue();
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(this.a);
        int deviceState = CommonUtils.getDeviceState(this.a);
        return a3.setSession(os.setDevice(CrashlyticsReport.Session.Device.builder().setArch(i).setModel(Build.MODEL).setCores(availableProcessors).setRam(totalRamInBytes).setDiskSpace(blockCount).setSimulator(isEmulator).setState(deviceState).setManufacturer(Build.MANUFACTURER).setModelClass(Build.PRODUCT).build()).setGeneratorType(3).build()).build();
    }

    public final CrashlyticsReport.Session.Event.Application.Execution.Thread d(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.builder().setName(thread.getName()).setImportance(i).setFrames(ImmutableList.from(c(stackTraceElementArr, i))).build();
    }

    public CrashlyticsReport captureReportData() {
        return a().build();
    }
}
