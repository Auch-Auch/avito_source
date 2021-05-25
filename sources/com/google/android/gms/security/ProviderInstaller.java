package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
public class ProviderInstaller {
    @RecentlyNonNull
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(@RecentlyNonNull int i, @RecentlyNonNull Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(@RecentlyNonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context, "Context must not be null");
        zza.verifyGooglePlayServicesIsAvailable(context, 11925000);
        Context zza2 = zza(context);
        if (zza2 == null) {
            zza2 = zzb(context);
        }
        if (zza2 != null) {
            synchronized (zzb) {
                try {
                    if (zzc == null) {
                        zzc = zza2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    zzc.invoke(null, zza2);
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        String valueOf = String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to install provider: ".concat(valueOf);
                        } else {
                            new String("Failed to install provider: ");
                        }
                    }
                    throw new GooglePlayServicesNotAvailableException(8);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(@RecentlyNonNull Context context, @RecentlyNonNull ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    @Nullable
    private static Context zza(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller").getModuleContext();
        } catch (DynamiteModule.LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load providerinstaller module: ".concat(valueOf);
                return null;
            }
            new String("Failed to load providerinstaller module: ");
            return null;
        }
    }

    @Nullable
    private static Context zzb(Context context) {
        try {
            return GooglePlayServicesUtilLight.getRemoteContext(context);
        } catch (Resources.NotFoundException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load GMS Core context for providerinstaller: ".concat(valueOf);
            } else {
                new String("Failed to load GMS Core context for providerinstaller: ");
            }
            CrashUtils.addDynamiteErrorToDropBox(context, e);
            return null;
        }
    }
}
