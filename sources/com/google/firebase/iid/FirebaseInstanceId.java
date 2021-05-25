package com.google.firebase.iid;

import a2.j.e.i.b0;
import a2.j.e.i.g;
import a2.j.e.i.i0;
import a2.j.e.i.j;
import a2.j.e.i.j0;
import a2.j.e.i.r;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
public class FirebaseInstanceId {
    public static final long i = TimeUnit.HOURS.toSeconds(8);
    public static i0 j;
    public static final Pattern k = Pattern.compile("\\AA[\\w-]{38}\\z");
    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")
    public static ScheduledExecutorService l;
    @VisibleForTesting
    public final Executor a;
    public final FirebaseApp b;
    public final Metadata c;
    public final GmsRpc d;
    public final b0 e;
    public final FirebaseInstallationsApi f;
    @GuardedBy("this")
    public boolean g = false;
    public final a h;

    public class a {
        public boolean a;
        public final Subscriber b;
        @GuardedBy("this")
        public boolean c;
        @Nullable
        @GuardedBy("this")
        public EventHandler<DataCollectionDefaultChange> d;
        @Nullable
        @GuardedBy("this")
        public Boolean e;

        public a(Subscriber subscriber) {
            this.b = subscriber;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            if (r1.serviceInfo != null) goto L_0x000d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void a() {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.c     // Catch:{ all -> 0x0055 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r4)
                return
            L_0x0007:
                r0 = 1
                java.lang.String r1 = "com.google.firebase.messaging.FirebaseMessaging"
                java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x000f }
            L_0x000d:
                r3 = 1
                goto L_0x0035
            L_0x000f:
                com.google.firebase.iid.FirebaseInstanceId r1 = com.google.firebase.iid.FirebaseInstanceId.this
                com.google.firebase.FirebaseApp r1 = r1.b
                android.content.Context r1 = r1.getApplicationContext()
                android.content.Intent r2 = new android.content.Intent
                java.lang.String r3 = "com.google.firebase.MESSAGING_EVENT"
                r2.<init>(r3)
                java.lang.String r3 = r1.getPackageName()
                r2.setPackage(r3)
                android.content.pm.PackageManager r1 = r1.getPackageManager()
                r3 = 0
                android.content.pm.ResolveInfo r1 = r1.resolveService(r2, r3)
                if (r1 == 0) goto L_0x0035
                android.content.pm.ServiceInfo r1 = r1.serviceInfo
                if (r1 == 0) goto L_0x0035
                goto L_0x000d
            L_0x0035:
                r4.a = r3
                java.lang.Boolean r1 = r4.c()
                r4.e = r1
                if (r1 != 0) goto L_0x0051
                boolean r1 = r4.a
                if (r1 == 0) goto L_0x0051
                a2.j.e.i.m r1 = new a2.j.e.i.m
                r1.<init>(r4)
                r4.d = r1
                com.google.firebase.events.Subscriber r2 = r4.b
                java.lang.Class<com.google.firebase.DataCollectionDefaultChange> r3 = com.google.firebase.DataCollectionDefaultChange.class
                r2.subscribe(r3, r1)
            L_0x0051:
                r4.c = r0
                monitor-exit(r4)
                return
            L_0x0055:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.a.a():void");
        }

        public synchronized boolean b() {
            a();
            Boolean bool = this.e;
            if (bool == null) {
                return this.a && FirebaseInstanceId.this.b.isDataCollectionDefaultEnabled();
            }
            return bool.booleanValue();
        }

        @Nullable
        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseInstanceId.this.b.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        Metadata metadata = new Metadata(firebaseApp.getApplicationContext());
        ExecutorService a3 = g.a();
        ExecutorService a4 = g.a();
        if (Metadata.getDefaultSenderId(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (j == null) {
                    j = new i0(firebaseApp.getApplicationContext());
                }
            }
            this.b = firebaseApp;
            this.c = metadata;
            this.d = new GmsRpc(firebaseApp, metadata, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
            this.a = a4;
            this.h = new a(subscriber);
            this.e = new b0(a3);
            this.f = firebaseInstallationsApi;
            ((ThreadPoolExecutor) a4).execute(new Runnable(this) { // from class: a2.j.e.i.h
                public final FirebaseInstanceId a;

                {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseInstanceId firebaseInstanceId = this.a;
                    if (firebaseInstanceId.isFcmAutoInitEnabled()) {
                        firebaseInstanceId.p();
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static <T> T b(@NonNull Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(j.a, new OnCompleteListener(countDownLatch) { // from class: a2.j.e.i.k
            public final CountDownLatch a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                CountDownLatch countDownLatch2 = this.a;
                i0 i0Var = FirebaseInstanceId.j;
                countDownLatch2.countDown();
            }
        });
        countDownLatch.await(30000, TimeUnit.MILLISECONDS);
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public static void c(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(firebaseApp.getOptions().getApplicationId().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(k.matcher(firebaseApp.getOptions().getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @VisibleForTesting
    @KeepForSdk
    public static synchronized void clearInstancesForTest() {
        synchronized (FirebaseInstanceId.class) {
            ScheduledExecutorService scheduledExecutorService = l;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            l = null;
            j = null;
        }
    }

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static boolean j() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    public static String l(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase(Constants.MessageTypes.MESSAGE)) ? "*" : str;
    }

    public final <T> T a(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    m();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
        }
    }

    public void d(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (l == null) {
                l = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            l.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        c(this.b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            a(this.f.delete());
            m();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @WorkerThread
    public void deleteToken(@NonNull String str, @NonNull String str2) throws IOException {
        c(this.b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String l2 = l(str2);
            a(this.d.deleteToken(e(), str, l2));
            i0 i0Var = j;
            String g2 = g();
            synchronized (i0Var) {
                String b2 = i0Var.b(g2, str, l2);
                SharedPreferences.Editor edit = i0Var.a.edit();
                edit.remove(b2);
                edit.commit();
            }
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public String e() {
        try {
            j.e(this.b.getPersistenceKey());
            return (String) b(this.f.getId());
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final Task<InstanceIdResult> f(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.a, new Continuation(this, str, l(str2)) { // from class: a2.j.e.i.i
            public final FirebaseInstanceId a;
            public final String b;
            public final String c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.a.k(this.b, this.c);
            }
        });
    }

    public final String g() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.b.getName())) {
            return "";
        }
        return this.b.getPersistenceKey();
    }

    public long getCreationTime() {
        long j2;
        i0 i0Var = j;
        String persistenceKey = this.b.getPersistenceKey();
        synchronized (i0Var) {
            Long l2 = i0Var.c.get(persistenceKey);
            if (l2 != null) {
                j2 = l2.longValue();
            } else {
                j2 = i0Var.d(persistenceKey);
            }
        }
        return j2;
    }

    @NonNull
    @WorkerThread
    public String getId() {
        c(this.b);
        p();
        return e();
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        c(this.b);
        return f(Metadata.getDefaultSenderId(this.b), "*");
    }

    @Nullable
    @Deprecated
    public String getToken() {
        c(this.b);
        i0.a h2 = h();
        if (r(h2)) {
            o();
        }
        int i2 = i0.a.e;
        if (h2 == null) {
            return null;
        }
        return h2.a;
    }

    @Nullable
    public i0.a h() {
        return i(Metadata.getDefaultSenderId(this.b), "*");
    }

    @Nullable
    @VisibleForTesting
    public i0.a i(String str, String str2) {
        i0.a a3;
        i0 i0Var = j;
        String g2 = g();
        synchronized (i0Var) {
            a3 = i0.a.a(i0Var.a.getString(i0Var.b(g2, str, str2), null));
        }
        return a3;
    }

    @VisibleForTesting
    @KeepForSdk
    public boolean isFcmAutoInitEnabled() {
        return this.h.b();
    }

    @VisibleForTesting
    public boolean isGmsCorePresent() {
        return this.c.isGmscorePresent();
    }

    public final Task k(String str, String str2) throws Exception {
        Task<InstanceIdResult> task;
        String e2 = e();
        i0.a i2 = i(str, str2);
        if (!r(i2)) {
            return Tasks.forResult(new r(e2, i2.a));
        }
        b0 b0Var = this.e;
        synchronized (b0Var) {
            Pair<String, String> pair = new Pair<>(str, str2);
            task = b0Var.b.get(pair);
            if (task == null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String.valueOf(pair).length();
                }
                task = this.d.getToken(e2, str, str2).onSuccessTask(this.a, new SuccessContinuation(this, str, str2, e2) { // from class: a2.j.e.i.l
                    public final FirebaseInstanceId a;
                    public final String b;
                    public final String c;
                    public final String d;

                    {
                        this.a = r1;
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // com.google.android.gms.tasks.SuccessContinuation
                    public final Task then(Object obj) {
                        String str3;
                        FirebaseInstanceId firebaseInstanceId = this.a;
                        String str4 = this.b;
                        String str5 = this.c;
                        String str6 = this.d;
                        String str7 = (String) obj;
                        i0 i0Var = FirebaseInstanceId.j;
                        String g2 = firebaseInstanceId.g();
                        String appVersionCode = firebaseInstanceId.c.getAppVersionCode();
                        synchronized (i0Var) {
                            long currentTimeMillis = System.currentTimeMillis();
                            int i3 = i0.a.e;
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, str7);
                                jSONObject.put("appVersion", appVersionCode);
                                jSONObject.put("timestamp", currentTimeMillis);
                                str3 = jSONObject.toString();
                            } catch (JSONException e3) {
                                String.valueOf(e3).length();
                                str3 = null;
                            }
                            if (str3 != null) {
                                SharedPreferences.Editor edit = i0Var.a.edit();
                                edit.putString(i0Var.b(g2, str4, str5), str3);
                                edit.commit();
                            }
                        }
                        return Tasks.forResult(new r(str6, str7));
                    }
                }).continueWithTask(b0Var.a, new Continuation(b0Var, pair) { // from class: a2.j.e.i.a0
                    public final b0 a;
                    public final Pair b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task2) {
                        b0 b0Var2 = this.a;
                        Pair pair2 = this.b;
                        synchronized (b0Var2) {
                            b0Var2.b.remove(pair2);
                        }
                        return task2;
                    }
                });
                b0Var.b.put(pair, task);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String.valueOf(pair).length();
            }
        }
        return task;
    }

    public synchronized void m() {
        j.c();
        if (isFcmAutoInitEnabled()) {
            o();
        }
    }

    public synchronized void n(boolean z) {
        this.g = z;
    }

    public synchronized void o() {
        if (!this.g) {
            q(0);
        }
    }

    public final void p() {
        if (r(h())) {
            o();
        }
    }

    public synchronized void q(long j2) {
        d(new j0(this, Math.min(Math.max(30L, j2 << 1), i)), j2);
        this.g = true;
    }

    public boolean r(@Nullable i0.a aVar) {
        if (aVar != null) {
            if (!(System.currentTimeMillis() > aVar.c + i0.a.d || !this.c.getAppVersionCode().equals(aVar.b))) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    @KeepForSdk
    public void setFcmAutoInitEnabled(boolean z) {
        a aVar = this.h;
        synchronized (aVar) {
            aVar.a();
            EventHandler<DataCollectionDefaultChange> eventHandler = aVar.d;
            if (eventHandler != null) {
                aVar.b.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                aVar.d = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.b.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.p();
            }
            aVar.e = Boolean.valueOf(z);
        }
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        c(firebaseApp);
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    @Nullable
    @WorkerThread
    public String getToken(@NonNull String str, @NonNull String str2) throws IOException {
        c(this.b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) a(f(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }
}
