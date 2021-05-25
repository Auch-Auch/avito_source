package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final Object c = new Object();
    @GuardedBy("sEnabledNotificationListenersLock")
    public static String d;
    @GuardedBy("sEnabledNotificationListenersLock")
    public static Set<String> e = new HashSet();
    public static final Object f = new Object();
    @GuardedBy("sLock")
    public static c g;
    public final Context a;
    public final NotificationManager b;

    public static class a implements d {
        public final String a;
        public final int b;
        public final String c;
        public final Notification d;

        public a(String str, int i, String str2, Notification notification) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.d
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.a, this.b, this.c, this.d);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.a);
            sb.append(", id:");
            sb.append(this.b);
            sb.append(", tag:");
            return a2.b.a.a.a.t(sb, this.c, "]");
        }
    }

    public static class b {
        public final ComponentName a;
        public final IBinder b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.a = componentName;
            this.b = iBinder;
        }
    }

    public static class c implements Handler.Callback, ServiceConnection {
        public final Context a;
        public final HandlerThread b;
        public final Handler c;
        public final Map<ComponentName, a> d = new HashMap();
        public Set<String> e = new HashSet();

        public static class a {
            public final ComponentName a;
            public boolean b = false;
            public INotificationSideChannel c;
            public ArrayDeque<d> d = new ArrayDeque<>();
            public int e = 0;

            public a(ComponentName componentName) {
                this.a = componentName;
            }
        }

        public c(Context context) {
            this.a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper(), this);
        }

        public final void a(a aVar) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder L = a2.b.a.a.a.L("Processing component ");
                L.append(aVar.a);
                L.append(", ");
                L.append(aVar.d.size());
                L.append(" queued tasks");
                L.toString();
            }
            if (!aVar.d.isEmpty()) {
                if (aVar.b) {
                    z = true;
                } else {
                    boolean bindService = this.a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(aVar.a), this, 33);
                    aVar.b = bindService;
                    if (bindService) {
                        aVar.e = 0;
                    } else {
                        StringBuilder L2 = a2.b.a.a.a.L("Unable to bind to listener ");
                        L2.append(aVar.a);
                        L2.toString();
                        this.a.unbindService(this);
                    }
                    z = aVar.b;
                }
                if (!z || aVar.c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    d peek = aVar.d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str = "Sending task " + peek;
                        }
                        peek.a(aVar.c);
                        aVar.d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            StringBuilder L3 = a2.b.a.a.a.L("Remote service has died: ");
                            L3.append(aVar.a);
                            L3.toString();
                        }
                    } catch (RemoteException unused2) {
                        StringBuilder L4 = a2.b.a.a.a.L("RemoteException communicating with ");
                        L4.append(aVar.a);
                        L4.toString();
                    }
                }
                if (!aVar.d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        public final void b(a aVar) {
            if (!this.c.hasMessages(3, aVar.a)) {
                int i = aVar.e + 1;
                aVar.e = i;
                if (i > 6) {
                    StringBuilder L = a2.b.a.a.a.L("Giving up on delivering ");
                    L.append(aVar.d.size());
                    L.append(" tasks to ");
                    L.append(aVar.a);
                    L.append(" after ");
                    L.append(aVar.e);
                    L.append(" retries");
                    L.toString();
                    aVar.d.clear();
                    return;
                }
                Log.isLoggable("NotifManCompat", 3);
                this.c.sendMessageDelayed(this.c.obtainMessage(3, aVar.a), (long) ((1 << (i - 1)) * 1000));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                d dVar = (d) message.obj;
                Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.a);
                if (!enabledListenerPackages.equals(this.e)) {
                    this.e = enabledListenerPackages;
                    List<ResolveInfo> queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
                    HashSet hashSet = new HashSet();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                String str = "Permission present on component " + componentName + ", not adding listener record.";
                            } else {
                                hashSet.add(componentName);
                            }
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName2 = (ComponentName) it.next();
                        if (!this.d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str2 = "Adding listener record for " + componentName2;
                            }
                            this.d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, a> next = it2.next();
                        if (!hashSet.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder L = a2.b.a.a.a.L("Removing listener record for ");
                                L.append(next.getKey());
                                L.toString();
                            }
                            a value = next.getValue();
                            if (value.b) {
                                this.a.unbindService(this);
                                value.b = false;
                            }
                            value.c = null;
                            it2.remove();
                        }
                    }
                }
                for (a aVar : this.d.values()) {
                    aVar.d.add(dVar);
                    a(aVar);
                }
                return true;
            } else if (i == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.a;
                IBinder iBinder = bVar.b;
                a aVar2 = this.d.get(componentName3);
                if (aVar2 != null) {
                    aVar2.c = INotificationSideChannel.Stub.asInterface(iBinder);
                    aVar2.e = 0;
                    a(aVar2);
                }
                return true;
            } else if (i == 2) {
                a aVar3 = this.d.get((ComponentName) message.obj);
                if (aVar3 != null) {
                    if (aVar3.b) {
                        this.a.unbindService(this);
                        aVar3.b = false;
                    }
                    aVar3.c = null;
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                a aVar4 = this.d.get((ComponentName) message.obj);
                if (aVar4 != null) {
                    a(aVar4);
                }
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Connected to service " + componentName;
            }
            this.c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface d {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public NotificationManagerCompat(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (c) {
            if (string != null) {
                if (!string.equals(d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    e = hashSet;
                    d = string;
                }
            }
            set = e;
        }
        return set;
    }

    public final void a(d dVar) {
        synchronized (f) {
            if (g == null) {
                g = new c(this.a.getApplicationContext());
            }
            g.c.obtainMessage(0, dVar).sendToTarget();
        }
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.a.getApplicationInfo();
        String packageName = this.a.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancelAll() {
        this.b.cancelAll();
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.createNotificationChannels(list);
        }
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.deleteNotificationChannelGroup(str);
        }
    }

    public int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.b.getImportance();
        }
        return -1000;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.getNotificationChannel(str);
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return this.b.getNotificationChannelGroup(str);
        }
        if (i >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
                if (notificationChannelGroup.getId().equals(str)) {
                    return notificationChannelGroup;
                }
            }
        }
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.getNotificationChannelGroups();
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.getNotificationChannels();
        }
        return Collections.emptyList();
    }

    public void notify(int i, @NonNull Notification notification) {
        notify(null, i, notification);
    }

    public void cancel(@Nullable String str, int i) {
        this.b.cancel(str, i);
    }

    public void notify(@Nullable String str, int i, @NonNull Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL)) {
            a(new a(this.a.getPackageName(), i, str, notification));
            this.b.cancel(str, i);
            return;
        }
        this.b.notify(str, i, notification);
    }
}
