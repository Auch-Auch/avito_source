package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;
public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";
    public final SimpleArrayMap<IBinder, IBinder.DeathRecipient> a = new SimpleArrayMap<>();
    public ICustomTabsService.Stub b = new a();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Result {
    }

    public class a extends ICustomTabsService.Stub {
        public a() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.extraCommand(str, bundle);
        }

        @Nullable
        public final PendingIntent f(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
            bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
            return pendingIntent;
        }

        public final boolean g(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable PendingIntent pendingIntent) {
            CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback, pendingIntent);
            try {
                l6.c.b.a aVar = new l6.c.b.a(this, customTabsSessionToken);
                synchronized (CustomTabsService.this.a) {
                    iCustomTabsCallback.asBinder().linkToDeath(aVar, 0);
                    CustomTabsService.this.a.put(iCustomTabsCallback.asBinder(), aVar);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(@Nullable ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list) {
            return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(@NonNull ICustomTabsCallback iCustomTabsCallback) {
            return g(iCustomTabsCallback, null);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return g(iCustomTabsCallback, f(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull String str, @Nullable Bundle bundle) {
            return CustomTabsService.this.postMessage(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, int i, @Nullable Bundle bundle) {
            return CustomTabsService.this.receiveFile(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), uri, i, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(iCustomTabsCallback, null), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull Uri uri, @NonNull Bundle bundle) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) {
            return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(@NonNull ICustomTabsCallback iCustomTabsCallback, int i, @NonNull Uri uri, @Nullable Bundle bundle) {
            return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(iCustomTabsCallback, f(bundle)), i, uri, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j) {
            return CustomTabsService.this.warmup(j);
        }
    }

    public boolean cleanUpSession(@NonNull CustomTabsSessionToken customTabsSessionToken) {
        IBinder iBinder;
        try {
            synchronized (this.a) {
                ICustomTabsCallback iCustomTabsCallback = customTabsSessionToken.a;
                if (iCustomTabsCallback == null) {
                    iBinder = null;
                } else {
                    iBinder = iCustomTabsCallback.asBinder();
                }
                if (iBinder == null) {
                    return false;
                }
                iBinder.unlinkToDeath(this.a.get(iBinder), 0);
                this.a.remove(iBinder);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    @Nullable
    public abstract Bundle extraCommand(@NonNull String str, @Nullable Bundle bundle);

    public abstract boolean mayLaunchUrl(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, @Nullable Bundle bundle, @Nullable List<Bundle> list);

    public abstract boolean newSession(@NonNull CustomTabsSessionToken customTabsSessionToken);

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.b;
    }

    public abstract int postMessage(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull String str, @Nullable Bundle bundle);

    public abstract boolean receiveFile(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri, int i, @Nullable Bundle bundle);

    public abstract boolean requestPostMessageChannel(@NonNull CustomTabsSessionToken customTabsSessionToken, @NonNull Uri uri);

    public abstract boolean updateVisuals(@NonNull CustomTabsSessionToken customTabsSessionToken, @Nullable Bundle bundle);

    public abstract boolean validateRelationship(@NonNull CustomTabsSessionToken customTabsSessionToken, int i, @NonNull Uri uri, @Nullable Bundle bundle);

    public abstract boolean warmup(long j);
}
