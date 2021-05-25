package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmDispatcher implements ExecutionListener {
    public static final String k = Logger.tagWithPrefix("SystemAlarmDispatcher");
    public final Context a;
    public final TaskExecutor b;
    public final WorkTimer c = new WorkTimer();
    public final Processor d;
    public final WorkManagerImpl e;
    public final CommandHandler f;
    public final Handler g;
    public final List<Intent> h;
    public Intent i;
    @Nullable
    public c j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemAlarmDispatcher systemAlarmDispatcher;
            d dVar;
            synchronized (SystemAlarmDispatcher.this.h) {
                SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                systemAlarmDispatcher2.i = systemAlarmDispatcher2.h.get(0);
            }
            Intent intent = SystemAlarmDispatcher.this.i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = SystemAlarmDispatcher.this.i.getIntExtra("KEY_START_ID", 0);
                Logger logger = Logger.get();
                String str = SystemAlarmDispatcher.k;
                logger.debug(str, String.format("Processing command %s, %s", SystemAlarmDispatcher.this.i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", action, newWakeLock), new Throwable[0]);
                    newWakeLock.acquire();
                    SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher3.f.d(systemAlarmDispatcher3.i, intExtra, systemAlarmDispatcher3);
                    Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock), new Throwable[0]);
                    newWakeLock.release();
                    systemAlarmDispatcher = SystemAlarmDispatcher.this;
                    dVar = new d(systemAlarmDispatcher);
                } catch (Throwable th) {
                    Logger.get().debug(SystemAlarmDispatcher.k, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock), new Throwable[0]);
                    newWakeLock.release();
                    SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                    systemAlarmDispatcher4.g.post(new d(systemAlarmDispatcher4));
                    throw th;
                }
                systemAlarmDispatcher.g.post(dVar);
            }
        }
    }

    public static class b implements Runnable {
        public final SystemAlarmDispatcher a;
        public final Intent b;
        public final int c;

        public b(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i) {
            this.a = systemAlarmDispatcher;
            this.b = intent;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.add(this.b, this.c);
        }
    }

    public interface c {
        void onAllCommandsCompleted();
    }

    public static class d implements Runnable {
        public final SystemAlarmDispatcher a;

        public d(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
            this.a = systemAlarmDispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemAlarmDispatcher systemAlarmDispatcher = this.a;
            Objects.requireNonNull(systemAlarmDispatcher);
            Logger logger = Logger.get();
            String str = SystemAlarmDispatcher.k;
            logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
            systemAlarmDispatcher.a();
            synchronized (systemAlarmDispatcher.h) {
                boolean z = true;
                if (systemAlarmDispatcher.i != null) {
                    Logger.get().debug(str, String.format("Removing command %s", systemAlarmDispatcher.i), new Throwable[0]);
                    if (systemAlarmDispatcher.h.remove(0).equals(systemAlarmDispatcher.i)) {
                        systemAlarmDispatcher.i = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                SerialExecutor backgroundExecutor = systemAlarmDispatcher.b.getBackgroundExecutor();
                CommandHandler commandHandler = systemAlarmDispatcher.f;
                synchronized (commandHandler.c) {
                    if (commandHandler.b.isEmpty()) {
                        z = false;
                    }
                }
                if (!z && systemAlarmDispatcher.h.isEmpty() && !backgroundExecutor.hasPendingTasks()) {
                    Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                    c cVar = systemAlarmDispatcher.j;
                    if (cVar != null) {
                        cVar.onAllCommandsCompleted();
                    }
                } else if (!systemAlarmDispatcher.h.isEmpty()) {
                    systemAlarmDispatcher.c();
                }
            }
        }
    }

    public SystemAlarmDispatcher(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f = new CommandHandler(applicationContext);
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        this.e = instance;
        Processor processor = instance.getProcessor();
        this.d = processor;
        this.b = instance.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.h = new ArrayList();
        this.i = null;
        this.g = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        if (this.g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @MainThread
    public boolean add(@NonNull Intent intent, int i2) {
        boolean z;
        Logger logger = Logger.get();
        String str = k;
        boolean z2 = false;
        logger.debug(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i2)), new Throwable[0]);
        a();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            a();
            synchronized (this.h) {
                Iterator<Intent> it = this.h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(it.next().getAction())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                return false;
            }
        }
        intent.putExtra("KEY_START_ID", i2);
        synchronized (this.h) {
            if (!this.h.isEmpty()) {
                z2 = true;
            }
            this.h.add(intent);
            if (!z2) {
                c();
            }
        }
        return true;
    }

    public void b() {
        Logger.get().debug(k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.d.removeExecutionListener(this);
        this.c.onDestroy();
        this.j = null;
    }

    @MainThread
    public final void c() {
        a();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.a, "ProcessCommand");
        try {
            newWakeLock.acquire();
            this.e.getWorkTaskExecutor().executeOnBackgroundThread(new a());
        } finally {
            newWakeLock.release();
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull String str, boolean z) {
        Context context = this.a;
        String str2 = CommandHandler.d;
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        this.g.post(new b(this, intent, 0));
    }
}
