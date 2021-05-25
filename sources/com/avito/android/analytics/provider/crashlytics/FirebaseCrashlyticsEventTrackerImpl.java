package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Initializable;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.concurrent.RxExecutor;
import com.facebook.applinks.AppLinkData;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0017\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTrackerImpl;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "Lcom/avito/android/util/Initializable;", "", "message", "", "trackEvent", "(Ljava/lang/String;)V", "", "cause", "", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "trackException", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "dumpLogsFromBuffer", "()V", "", "logs", "dumpLogs", "(Ljava/util/List;)V", "Lkotlin/Function0;", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", "isInitialized", "()Z", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/avito/android/util/rx3/concurrent/RxExecutor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/rx3/concurrent/RxExecutor;", "executor", "Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;", "c", "Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;", "logBufferProvider", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public class FirebaseCrashlyticsEventTrackerImpl implements FirebaseCrashlyticsEventTracker, Initializable {
    public final RxExecutor a;
    public final FirebaseCrashlytics b;
    public final LogBufferProvider c;

    @Inject
    public FirebaseCrashlyticsEventTrackerImpl(@NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull LogBufferProvider logBufferProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        Intrinsics.checkNotNullParameter(logBufferProvider, "logBufferProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.b = firebaseCrashlytics;
        this.c = logBufferProvider;
        this.a = new RxExecutor(schedulersFactory3.newThread());
    }

    public static final void access$attachExtras(FirebaseCrashlyticsEventTrackerImpl firebaseCrashlyticsEventTrackerImpl, Map map) {
        Objects.requireNonNull(firebaseCrashlyticsEventTrackerImpl);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                firebaseCrashlyticsEventTrackerImpl.b.setInt(str, ((Number) value).intValue());
            } else if (value instanceof String) {
                firebaseCrashlyticsEventTrackerImpl.b.setString(str, (String) value);
            } else {
                firebaseCrashlyticsEventTrackerImpl.b.setString(str, value.toString());
            }
        }
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker
    public void dumpLogs(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "logs");
        int size = list.size() - 1;
        int i = 0;
        while (size >= 0 && i < 26624) {
            i += list.get(size).length();
            size--;
        }
        if (i > 26624) {
            size++;
        }
        List<String> subList = list.subList(size + 1, list.size());
        this.b.log("====== LOG DUMP (in reversed order): ======");
        for (String str : i.asReversed(subList)) {
            this.b.log(str);
        }
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker
    public void dumpLogsFromBuffer() {
        dumpLogs(this.c.getBufferedLogs());
    }

    @Override // com.avito.android.util.Initializable
    public void initialize(@Nullable Function0<Unit> function0) {
        this.b.initialize(function0);
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.b.isInitialized();
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker
    public void trackEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Logs.debug$default("CrashlyticsEventTracker", str, null, 4, null);
        this.b.log(str);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker
    public void trackException(@Nullable String str, @NotNull Throwable th, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        this.a.execute(new Runnable(this, map, str, th) { // from class: com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl$trackException$$inlined$invoke$1
            public final /* synthetic */ FirebaseCrashlyticsEventTrackerImpl a;
            public final /* synthetic */ Map b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Throwable d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0065 A[Catch:{ Exception -> 0x009a }] */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r5 = this;
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl r0 = r5.a     // Catch:{ Exception -> 0x009a }
                    r0.dumpLogsFromBuffer()     // Catch:{ Exception -> 0x009a }
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl r0 = r5.a     // Catch:{ Exception -> 0x009a }
                    java.util.Map r1 = r5.b     // Catch:{ Exception -> 0x009a }
                    java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x009a }
                    java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x009a }
                L_0x0011:
                    boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x009a }
                    if (r2 == 0) goto L_0x0053
                    java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x009a }
                    java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ Exception -> 0x009a }
                    java.lang.Object r3 = r2.getKey()     // Catch:{ Exception -> 0x009a }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x009a }
                    java.lang.Object r2 = r2.getValue()     // Catch:{ Exception -> 0x009a }
                    boolean r4 = r2 instanceof java.lang.Integer     // Catch:{ Exception -> 0x009a }
                    if (r4 == 0) goto L_0x0039
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics r4 = com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl.access$getCrashlytics$p(r0)     // Catch:{ Exception -> 0x009a }
                    java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Exception -> 0x009a }
                    int r2 = r2.intValue()     // Catch:{ Exception -> 0x009a }
                    r4.setInt(r3, r2)     // Catch:{ Exception -> 0x009a }
                    goto L_0x0011
                L_0x0039:
                    boolean r4 = r2 instanceof java.lang.String     // Catch:{ Exception -> 0x009a }
                    if (r4 == 0) goto L_0x0047
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics r4 = com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl.access$getCrashlytics$p(r0)     // Catch:{ Exception -> 0x009a }
                    java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x009a }
                    r4.setString(r3, r2)     // Catch:{ Exception -> 0x009a }
                    goto L_0x0011
                L_0x0047:
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics r4 = com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl.access$getCrashlytics$p(r0)     // Catch:{ Exception -> 0x009a }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009a }
                    r4.setString(r3, r2)     // Catch:{ Exception -> 0x009a }
                    goto L_0x0011
                L_0x0053:
                    java.lang.String r0 = r5.c     // Catch:{ Exception -> 0x009a }
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L_0x0062
                    int r0 = r0.length()     // Catch:{ Exception -> 0x009a }
                    if (r0 != 0) goto L_0x0060
                    goto L_0x0062
                L_0x0060:
                    r0 = 0
                    goto L_0x0063
                L_0x0062:
                    r0 = 1
                L_0x0063:
                    if (r0 != 0) goto L_0x008e
                    java.lang.Throwable r0 = r5.d     // Catch:{ Exception -> 0x009a }
                    boolean r3 = r0 instanceof com.avito.android.analytics.provider.crashlytics.NonFatalException     // Catch:{ Exception -> 0x009a }
                    if (r3 == 0) goto L_0x007b
                    java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x009a }
                    if (r0 == 0) goto L_0x0077
                    int r0 = r0.length()     // Catch:{ Exception -> 0x009a }
                    if (r0 != 0) goto L_0x0078
                L_0x0077:
                    r1 = 1
                L_0x0078:
                    if (r1 != 0) goto L_0x007b
                    goto L_0x008e
                L_0x007b:
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl r0 = r5.a     // Catch:{ Exception -> 0x009a }
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics r0 = com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl.access$getCrashlytics$p(r0)     // Catch:{ Exception -> 0x009a }
                    com.avito.android.analytics.provider.crashlytics.NonFatalException r1 = new com.avito.android.analytics.provider.crashlytics.NonFatalException     // Catch:{ Exception -> 0x009a }
                    java.lang.String r2 = r5.c     // Catch:{ Exception -> 0x009a }
                    java.lang.Throwable r3 = r5.d     // Catch:{ Exception -> 0x009a }
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x009a }
                    r0.trackException(r1)     // Catch:{ Exception -> 0x009a }
                    goto L_0x00a2
                L_0x008e:
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl r0 = r5.a     // Catch:{ Exception -> 0x009a }
                    com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics r0 = com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl.access$getCrashlytics$p(r0)     // Catch:{ Exception -> 0x009a }
                    java.lang.Throwable r1 = r5.d     // Catch:{ Exception -> 0x009a }
                    r0.trackException(r1)     // Catch:{ Exception -> 0x009a }
                    goto L_0x00a2
                L_0x009a:
                    r0 = move-exception
                    java.lang.String r1 = "CrashlyticsEventTracker"
                    java.lang.String r2 = "Failed to log exception"
                    com.avito.android.util.Logs.debug(r1, r2, r0)
                L_0x00a2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTrackerImpl$trackException$$inlined$invoke$1.run():void");
            }
        });
    }
}
