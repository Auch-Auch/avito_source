package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
public class CustomTabsSessionToken {
    @Nullable
    public final ICustomTabsCallback a;
    @Nullable
    public final PendingIntent b;
    @Nullable
    public final CustomTabsCallback c;

    public class a extends CustomTabsCallback {
        public a() {
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
            try {
                CustomTabsSessionToken.this.a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
            try {
                return CustomTabsSessionToken.this.a.extraCallbackWithResult(str, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onMessageChannelReady(@Nullable Bundle bundle) {
            try {
                CustomTabsSessionToken.this.a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, @Nullable Bundle bundle) {
            try {
                CustomTabsSessionToken.this.a.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
            try {
                CustomTabsSessionToken.this.a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onRelationshipValidationResult(int i, @NonNull Uri uri, boolean z, @Nullable Bundle bundle) {
            try {
                CustomTabsSessionToken.this.a.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    public static class b extends ICustomTabsCallback.Stub {
        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }
    }

    public CustomTabsSessionToken(@Nullable ICustomTabsCallback iCustomTabsCallback, @Nullable PendingIntent pendingIntent) {
        a aVar;
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.a = iCustomTabsCallback;
        this.b = pendingIntent;
        if (iCustomTabsCallback == null) {
            aVar = null;
        } else {
            aVar = new a();
        }
        this.c = aVar;
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new b(), null);
    }

    @Nullable
    public static CustomTabsSessionToken getSessionTokenFromIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        ICustomTabsCallback iCustomTabsCallback = null;
        if (extras == null) {
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        if (binder != null) {
            iCustomTabsCallback = ICustomTabsCallback.Stub.asInterface(binder);
        }
        return new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
    }

    public final IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent pendingIntent = customTabsSessionToken.b;
        PendingIntent pendingIntent2 = this.b;
        boolean z = true;
        boolean z2 = pendingIntent2 == null;
        if (pendingIntent != null) {
            z = false;
        }
        if (z2 != z) {
            return false;
        }
        if (pendingIntent2 != null) {
            return pendingIntent2.equals(pendingIntent);
        }
        return a().equals(customTabsSessionToken.a());
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasCallback() {
        return this.a != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasId() {
        return this.b != null;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.b;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return a().hashCode();
    }

    public boolean isAssociatedWith(@NonNull CustomTabsSession customTabsSession) {
        return customTabsSession.b().equals(this.a);
    }
}
