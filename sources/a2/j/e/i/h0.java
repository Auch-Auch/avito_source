package a2.j.e.i;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.p002firebaseiid.zze;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.FirebaseIidMessengerCompat;
import com.google.firebase.iid.Metadata;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
public class h0 {
    public static int h;
    public static PendingIntent i;
    @GuardedBy("responseCallbacks")
    public final SimpleArrayMap<String, TaskCompletionSource<Bundle>> a = new SimpleArrayMap<>();
    public final Context b;
    public final Metadata c;
    public final ScheduledExecutorService d;
    public Messenger e;
    public Messenger f;
    public FirebaseIidMessengerCompat g;

    public class a extends zze {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h0 h0Var = h0.this;
            Objects.requireNonNull(h0Var);
            if (message != null) {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    intent.setExtrasClassLoader(new FirebaseIidMessengerCompat.HandleOldParcelNameClassLoader());
                    if (intent.hasExtra("google.messenger")) {
                        Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                        if (parcelableExtra instanceof FirebaseIidMessengerCompat) {
                            h0Var.g = (FirebaseIidMessengerCompat) parcelableExtra;
                        }
                        if (parcelableExtra instanceof Messenger) {
                            h0Var.f = (Messenger) parcelableExtra;
                        }
                    }
                    Intent intent2 = (Intent) message.obj;
                    String action = intent2.getAction();
                    if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                        String stringExtra = intent2.getStringExtra("registration_id");
                        if (stringExtra == null) {
                            stringExtra = intent2.getStringExtra("unregistered");
                        }
                        if (stringExtra == null) {
                            String stringExtra2 = intent2.getStringExtra("error");
                            if (stringExtra2 == null) {
                                String.valueOf(intent2.getExtras()).length();
                                return;
                            }
                            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                                if (stringExtra2.length() != 0) {
                                    "Received InstanceID error ".concat(stringExtra2);
                                } else {
                                    new String("Received InstanceID error ");
                                }
                            }
                            if (stringExtra2.startsWith("|")) {
                                String[] split = stringExtra2.split("\\|");
                                if (split.length > 2 && "ID".equals(split[1])) {
                                    String str = split[2];
                                    String str2 = split[3];
                                    if (str2.startsWith(":")) {
                                        str2 = str2.substring(1);
                                    }
                                    h0Var.b(str, intent2.putExtra("error", str2).getExtras());
                                } else if (stringExtra2.length() != 0) {
                                    "Unexpected structured response ".concat(stringExtra2);
                                } else {
                                    new String("Unexpected structured response ");
                                }
                            } else {
                                synchronized (h0Var.a) {
                                    for (int i = 0; i < h0Var.a.size(); i++) {
                                        h0Var.b(h0Var.a.keyAt(i), intent2.getExtras());
                                    }
                                }
                            }
                        } else {
                            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                            if (matcher.matches()) {
                                String group = matcher.group(1);
                                String group2 = matcher.group(2);
                                Bundle extras = intent2.getExtras();
                                extras.putString("registration_id", group2);
                                h0Var.b(group, extras);
                            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                                if (stringExtra.length() != 0) {
                                    "Unexpected response string: ".concat(stringExtra);
                                } else {
                                    new String("Unexpected response string: ");
                                }
                            }
                        }
                    } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(action);
                        if (valueOf.length() != 0) {
                            "Unexpected response action: ".concat(valueOf);
                        } else {
                            new String("Unexpected response action: ");
                        }
                    }
                }
            }
        }
    }

    public h0(Context context, Metadata metadata) {
        this.b = context;
        this.c = metadata;
        this.e = new Messenger(new a(Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = scheduledThreadPoolExecutor;
    }

    @AnyThread
    public final Task<Bundle> a(Bundle bundle) {
        String num;
        synchronized (h0.class) {
            int i2 = h;
            h = i2 + 1;
            num = Integer.toString(i2);
        }
        TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.a) {
            this.a.put(num, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.c.getIidImplementation() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.b;
        synchronized (h0.class) {
            if (i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                i = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", i);
        }
        intent.putExtra("kid", a2.b.a.a.a.s2(a2.b.a.a.a.q0(num, 5), "|ID|", num, "|"));
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String.valueOf(intent.getExtras()).length();
        }
        intent.putExtra("google.messenger", this.e);
        if (!(this.f == null && this.g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.g.send(obtain);
                }
            } catch (RemoteException unused) {
                Log.isLoggable("FirebaseInstanceId", 3);
            }
            ScheduledFuture<?> schedule = this.d.schedule(new Runnable(taskCompletionSource) { // from class: a2.j.e.i.e0
                public final TaskCompletionSource a;

                {
                    this.a = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.trySetException(new IOException("TIMEOUT"));
                }
            }, 30, TimeUnit.SECONDS);
            Task<Bundle> task = taskCompletionSource.getTask();
            Executor executor = g.a;
            task.addOnCompleteListener(f.a, new OnCompleteListener(this, num, schedule) { // from class: a2.j.e.i.f0
                public final h0 a;
                public final String b;
                public final ScheduledFuture c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    h0 h0Var = this.a;
                    String str = this.b;
                    ScheduledFuture scheduledFuture = this.c;
                    synchronized (h0Var.a) {
                        h0Var.a.remove(str);
                    }
                    scheduledFuture.cancel(false);
                }
            });
            return taskCompletionSource.getTask();
        }
        if (this.c.getIidImplementation() == 2) {
            this.b.sendBroadcast(intent);
        } else {
            this.b.startService(intent);
        }
        ScheduledFuture<?> schedule = this.d.schedule(new Runnable(taskCompletionSource) { // from class: a2.j.e.i.e0
            public final TaskCompletionSource a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.trySetException(new IOException("TIMEOUT"));
            }
        }, 30, TimeUnit.SECONDS);
        Task<Bundle> task = taskCompletionSource.getTask();
        Executor executor = g.a;
        task.addOnCompleteListener(f.a, new OnCompleteListener(this, num, schedule) { // from class: a2.j.e.i.f0
            public final h0 a;
            public final String b;
            public final ScheduledFuture c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                h0 h0Var = this.a;
                String str = this.b;
                ScheduledFuture scheduledFuture = this.c;
                synchronized (h0Var.a) {
                    h0Var.a.remove(str);
                }
                scheduledFuture.cancel(false);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void b(String str, Bundle bundle) {
        synchronized (this.a) {
            TaskCompletionSource<Bundle> remove = this.a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Missing callback for ".concat(valueOf);
                } else {
                    new String("Missing callback for ");
                }
                return;
            }
            remove.setResult(bundle);
        }
    }
}
