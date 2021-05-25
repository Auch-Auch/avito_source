package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
public abstract class PostMessageServiceConnection implements PostMessageBackend, ServiceConnection {
    public final Object a = new Object();
    public final ICustomTabsCallback b;
    @Nullable
    public IPostMessageService c;
    @Nullable
    public String d;
    public boolean e;

    public PostMessageServiceConnection(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        IBinder iBinder;
        ICustomTabsCallback iCustomTabsCallback = customTabsSessionToken.a;
        if (iCustomTabsCallback == null) {
            iBinder = null;
        } else {
            iBinder = iCustomTabsCallback.asBinder();
        }
        if (iBinder != null) {
            this.b = ICustomTabsCallback.Stub.asInterface(iBinder);
            return;
        }
        throw new IllegalArgumentException("Provided session must have binder.");
    }

    public final boolean a(@Nullable Bundle bundle) {
        if (this.c == null) {
            return false;
        }
        synchronized (this.a) {
            try {
                this.c.onMessageChannelReady(this.b, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public boolean bindSessionToPostMessageService(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        return context.bindService(intent, this, 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void cleanup(@NonNull Context context) {
        if (this.c != null) {
            unbindFromContext(context);
        }
    }

    public final boolean notifyMessageChannelReady(@Nullable Bundle bundle) {
        this.e = true;
        return a(bundle);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onDisconnectChannel(@NonNull Context context) {
        unbindFromContext(context);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onNotifyMessageChannelReady(@Nullable Bundle bundle) {
        return notifyMessageChannelReady(bundle);
    }

    @Override // androidx.browser.customtabs.PostMessageBackend
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
        return postMessage(str, bundle);
    }

    public void onPostMessageServiceConnected() {
        if (this.e) {
            a(null);
        }
    }

    public void onPostMessageServiceDisconnected() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.c = IPostMessageService.Stub.asInterface(iBinder);
        onPostMessageServiceConnected();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.c = null;
        onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(@NonNull String str, @Nullable Bundle bundle) {
        if (this.c == null) {
            return false;
        }
        synchronized (this.a) {
            try {
                this.c.onPostMessage(this.b, str, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPackageName(@NonNull String str) {
        this.d = str;
    }

    public void unbindFromContext(@NonNull Context context) {
        if (this.c != null) {
            context.unbindService(this);
            this.c = null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean bindSessionToPostMessageService(@NonNull Context context) {
        String str = this.d;
        if (str != null) {
            return bindSessionToPostMessageService(context, str);
        }
        throw new IllegalStateException("setPackageName must be called before bindSessionToPostMessageService.");
    }
}
