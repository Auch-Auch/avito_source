package l6.c.b;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
public class b extends ICustomTabsCallback.Stub {
    public Handler a = new Handler(Looper.getMainLooper());
    public final /* synthetic */ CustomTabsCallback b;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Bundle b;

        public a(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.onNavigationEvent(this.a, this.b);
        }
    }

    /* renamed from: l6.c.b.b$b  reason: collision with other inner class name */
    public class RunnableC0522b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Bundle b;

        public RunnableC0522b(String str, Bundle bundle) {
            this.a = str;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.extraCallback(this.a, this.b);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Bundle a;

        public c(Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.onMessageChannelReady(this.a);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Bundle b;

        public d(String str, Bundle bundle) {
            this.a = str;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.onPostMessage(this.a, this.b);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Bundle d;

        public e(int i, Uri uri, boolean z, Bundle bundle) {
            this.a = i;
            this.b = uri;
            this.c = z;
            this.d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b.onRelationshipValidationResult(this.a, this.b, this.c, this.d);
        }
    }

    public b(CustomTabsClient customTabsClient, CustomTabsCallback customTabsCallback) {
        this.b = customTabsCallback;
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void extraCallback(String str, Bundle bundle) throws RemoteException {
        if (this.b != null) {
            this.a.post(new RunnableC0522b(str, bundle));
        }
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) throws RemoteException {
        CustomTabsCallback customTabsCallback = this.b;
        if (customTabsCallback == null) {
            return null;
        }
        return customTabsCallback.extraCallbackWithResult(str, bundle);
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        if (this.b != null) {
            this.a.post(new c(bundle));
        }
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onNavigationEvent(int i, Bundle bundle) {
        if (this.b != null) {
            this.a.post(new a(i, bundle));
        }
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onPostMessage(String str, Bundle bundle) throws RemoteException {
        if (this.b != null) {
            this.a.post(new d(str, bundle));
        }
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onRelationshipValidationResult(int i, Uri uri, boolean z, @Nullable Bundle bundle) throws RemoteException {
        if (this.b != null) {
            this.a.post(new e(i, uri, z, bundle));
        }
    }
}
