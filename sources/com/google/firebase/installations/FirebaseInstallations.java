package com.google.firebase.installations;

import a2.j.e.j.b;
import a2.j.e.j.h;
import a2.j.e.j.i;
import a2.j.e.j.j;
import a2.j.e.j.k;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
public class FirebaseInstallations implements FirebaseInstallationsApi {
    public static final Object l = new Object();
    public static final ThreadFactory m = new a();
    public final FirebaseApp a;
    public final FirebaseInstallationServiceClient b;
    public final PersistedInstallation c;
    public final k d;
    public final IidStore e;
    public final RandomFidGenerator f;
    public final Object g = new Object();
    public final ExecutorService h;
    public final ExecutorService i;
    @GuardedBy("this")
    public String j;
    @GuardedBy("lock")
    public final List<j> k = new ArrayList();

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    public FirebaseInstallations(FirebaseApp firebaseApp, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = m;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, timeUnit, linkedBlockingQueue, threadFactory);
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.getApplicationContext(), userAgentPublisher, heartBeatInfo);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        k kVar = new k();
        IidStore iidStore = new IidStore(firebaseApp);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.a = firebaseApp;
        this.b = firebaseInstallationServiceClient;
        this.c = persistedInstallation;
        this.d = kVar;
        this.e = iidStore;
        this.f = randomFidGenerator;
        this.h = threadPoolExecutor;
        this.i = new ThreadPoolExecutor(0, 1, 30, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public final void a(boolean z) {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        String str;
        synchronized (l) {
            b a3 = b.a(this.a.getApplicationContext(), "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.c.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    if ((this.a.getName().equals("CHIME_ANDROID_SDK") || this.a.isDefaultApp()) && readPersistedInstallationEntryValue.shouldAttemptMigration()) {
                        str = this.e.readIid();
                        if (TextUtils.isEmpty(str)) {
                            str = this.f.createRandomFid();
                        }
                    } else {
                        str = this.f.createRandomFid();
                    }
                    readPersistedInstallationEntryValue = this.c.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(str));
                }
            } finally {
                if (a3 != null) {
                    a3.b();
                }
            }
        }
        if (z) {
            readPersistedInstallationEntryValue = readPersistedInstallationEntryValue.withClearedAuthToken();
        }
        k(readPersistedInstallationEntryValue);
        this.i.execute(new Runnable(this, z) { // from class: a2.j.e.j.f
            public final FirebaseInstallations a;
            public final boolean b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.google.firebase.installations.FirebaseInstallations r0 = r4.a
                    boolean r1 = r4.b
                    java.lang.Object r2 = com.google.firebase.installations.FirebaseInstallations.l
                    com.google.firebase.installations.local.PersistedInstallationEntry r2 = r0.e()
                    boolean r3 = r2.isErrored()     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                    if (r3 != 0) goto L_0x0026
                    boolean r3 = r2.isUnregistered()     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                    if (r3 == 0) goto L_0x0017
                    goto L_0x0026
                L_0x0017:
                    if (r1 != 0) goto L_0x0021
                    a2.j.e.j.k r1 = r0.d     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                    boolean r1 = r1.b(r2)     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                    if (r1 == 0) goto L_0x0064
                L_0x0021:
                    com.google.firebase.installations.local.PersistedInstallationEntry r1 = r0.b(r2)     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                    goto L_0x002a
                L_0x0026:
                    com.google.firebase.installations.local.PersistedInstallationEntry r1 = r0.i(r2)     // Catch:{ FirebaseInstallationsException -> 0x0060 }
                L_0x002a:
                    r0.g(r1)
                    boolean r2 = r1.isRegistered()
                    if (r2 == 0) goto L_0x003a
                    java.lang.String r2 = r1.getFirebaseInstallationId()
                    r0.l(r2)
                L_0x003a:
                    boolean r2 = r1.isErrored()
                    if (r2 == 0) goto L_0x004b
                    com.google.firebase.installations.FirebaseInstallationsException r2 = new com.google.firebase.installations.FirebaseInstallationsException
                    com.google.firebase.installations.FirebaseInstallationsException$Status r3 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
                    r2.<init>(r3)
                    r0.j(r1, r2)
                    goto L_0x0064
                L_0x004b:
                    boolean r2 = r1.isNotGenerated()
                    if (r2 == 0) goto L_0x005c
                    java.io.IOException r2 = new java.io.IOException
                    java.lang.String r3 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
                    r2.<init>(r3)
                    r0.j(r1, r2)
                    goto L_0x0064
                L_0x005c:
                    r0.k(r1)
                    goto L_0x0064
                L_0x0060:
                    r1 = move-exception
                    r0.j(r2, r1)
                L_0x0064:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.j.e.j.f.run():void");
            }
        });
    }

    public final PersistedInstallationEntry b(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult generateAuthToken = this.b.generateAuthToken(c(), persistedInstallationEntry.getFirebaseInstallationId(), f(), persistedInstallationEntry.getRefreshToken());
        int ordinal = generateAuthToken.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.d.a());
        }
        if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        if (ordinal == 2) {
            l(null);
            return persistedInstallationEntry.withNoGeneratedFid();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    @Nullable
    public String c() {
        return this.a.getOptions().getApiKey();
    }

    @VisibleForTesting
    public String d() {
        return this.a.getOptions().getApplicationId();
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<Void> delete() {
        return Tasks.call(this.h, new Callable(this) { // from class: a2.j.e.j.e
            public final FirebaseInstallations a;

            {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                FirebaseInstallations firebaseInstallations = this.a;
                Object obj = FirebaseInstallations.l;
                firebaseInstallations.l(null);
                PersistedInstallationEntry e2 = firebaseInstallations.e();
                if (e2.isRegistered()) {
                    firebaseInstallations.b.deleteFirebaseInstallation(firebaseInstallations.c(), e2.getFirebaseInstallationId(), firebaseInstallations.f(), e2.getRefreshToken());
                }
                firebaseInstallations.g(e2.withNoGeneratedFid());
                return null;
            }
        });
    }

    public final PersistedInstallationEntry e() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (l) {
            b a3 = b.a(this.a.getApplicationContext(), "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.c.readPersistedInstallationEntryValue();
            } finally {
                if (a3 != null) {
                    a3.b();
                }
            }
        }
        return readPersistedInstallationEntryValue;
    }

    @Nullable
    public String f() {
        return this.a.getOptions().getProjectId();
    }

    public final void g(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (l) {
            b a3 = b.a(this.a.getApplicationContext(), "generatefid.lock");
            try {
                this.c.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
            } finally {
                if (a3 != null) {
                    a3.b();
                }
            }
        }
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<String> getId() {
        String str;
        h();
        synchronized (this) {
            str = this.j;
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        i iVar = new i(taskCompletionSource);
        synchronized (this.g) {
            this.k.add(iVar);
        }
        Task<String> task = taskCompletionSource.getTask();
        this.h.execute(new Runnable(this) { // from class: a2.j.e.j.c
            public final FirebaseInstallations a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                FirebaseInstallations firebaseInstallations = this.a;
                Object obj = FirebaseInstallations.l;
                firebaseInstallations.a(false);
            }
        });
        return task;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public Task<InstallationTokenResult> getToken(boolean z) {
        h();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h hVar = new h(this.d, taskCompletionSource);
        synchronized (this.g) {
            this.k.add(hVar);
        }
        Task<InstallationTokenResult> task = taskCompletionSource.getTask();
        this.h.execute(new Runnable(this, z) { // from class: a2.j.e.j.d
            public final FirebaseInstallations a;
            public final boolean b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FirebaseInstallations firebaseInstallations = this.a;
                boolean z2 = this.b;
                Object obj = FirebaseInstallations.l;
                firebaseInstallations.a(z2);
            }
        });
        return task;
    }

    public final void h() {
        Preconditions.checkNotEmpty(d(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(f(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(c(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String d2 = d();
        Pattern pattern = k.b;
        Preconditions.checkArgument(d2.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(k.b.matcher(c()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final PersistedInstallationEntry i(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        InstallationResponse createFirebaseInstallation = this.b.createFirebaseInstallation(c(), persistedInstallationEntry.getFirebaseInstallationId(), f(), d(), (persistedInstallationEntry.getFirebaseInstallationId() == null || persistedInstallationEntry.getFirebaseInstallationId().length() != 11) ? null : this.e.readToken());
        int ordinal = createFirebaseInstallation.getResponseCode().ordinal();
        if (ordinal == 0) {
            return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.d.a(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
        }
        if (ordinal == 1) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void j(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        synchronized (this.g) {
            Iterator<j> it = this.k.iterator();
            while (it.hasNext()) {
                if (it.next().b(persistedInstallationEntry, exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void k(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.g) {
            Iterator<j> it = this.k.iterator();
            while (it.hasNext()) {
                if (it.next().a(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    public final synchronized void l(String str) {
        this.j = str;
    }

    @NonNull
    public static FirebaseInstallations getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.get(FirebaseInstallationsApi.class);
    }
}
