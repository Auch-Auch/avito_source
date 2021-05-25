package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.ArrayList;
import java.util.List;
import l6.c.b.b;
public class CustomTabsClient {
    public final ICustomTabsService a;
    public final ComponentName b;
    public final Context c;

    public static class a extends CustomTabsServiceConnection {
        public final /* synthetic */ Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public final void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
            customTabsClient.warmup(0);
            this.b.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.a = iCustomTabsService;
        this.b = componentName;
        this.c = context;
    }

    public static boolean bindCustomTabsService(@NonNull Context context, @Nullable String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.a = context.getApplicationContext();
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean connectAndInitialize(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list) {
        return getPackageName(context, list, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static CustomTabsSession.PendingSession newPendingSession(@NonNull Context context, @Nullable CustomTabsCallback customTabsCallback, int i) {
        return new CustomTabsSession.PendingSession(customTabsCallback, PendingIntent.getActivity(context, i, new Intent(), 0));
    }

    @Nullable
    public final CustomTabsSession a(@Nullable CustomTabsCallback customTabsCallback, @Nullable PendingIntent pendingIntent) {
        boolean z;
        b bVar = new b(this, customTabsCallback);
        if (pendingIntent != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
                z = this.a.newSessionWithExtras(bVar, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            z = this.a.newSession(bVar);
        }
        if (!z) {
            return null;
        }
        return new CustomTabsSession(this.a, bVar, this.b, pendingIntent);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CustomTabsSession attachSession(@NonNull CustomTabsSession.PendingSession pendingSession) {
        return a(pendingSession.a, pendingSession.b);
    }

    @Nullable
    public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
        try {
            return this.a.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback) {
        return a(customTabsCallback, null);
    }

    public boolean warmup(long j) {
        try {
            return this.a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Nullable
    public static String getPackageName(@NonNull Context context, @Nullable List<String> list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        return null;
    }

    @Nullable
    public CustomTabsSession newSession(@Nullable CustomTabsCallback customTabsCallback, int i) {
        return a(customTabsCallback, PendingIntent.getActivity(this.c, i, new Intent(), 0));
    }
}
