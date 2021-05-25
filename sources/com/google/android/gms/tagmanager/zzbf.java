package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
public final class zzbf {
    private static volatile DynamiteModule zzagl;
    private static volatile zzcp zzagm;
    private static final Map<String, CustomTagProvider> zzagn = new HashMap();
    private static final Map<String, CustomVariableProvider> zzago = new HashMap();

    private zzbf() {
    }

    public static void zza(Intent intent, Context context) {
        zzcp zzj = zzj(context);
        synchronized (zzbf.class) {
            try {
                zzj.previewIntent(intent, ObjectWrapper.wrap(context), ObjectWrapper.wrap(zzagl.getModuleContext()), zzl(context), new zzbj());
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static IBinder zzh(Context context) {
        try {
            try {
                return zzct.asInterface(zzk(context).instantiate("com.google.android.gms.tagmanager.TagManagerServiceProviderImpl")).getService(ObjectWrapper.wrap(context), zzl(context), new zzbj()).asBinder();
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void zzi(Context context) {
        zzcp zzj = zzj(context);
        synchronized (zzbf.class) {
            try {
                zzj.initialize(ObjectWrapper.wrap(context), zzl(context), new zzbj());
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzcp zzj(Context context) {
        zzcp zzcp = zzagm;
        if (zzcp == null) {
            synchronized (zzbf.class) {
                zzcp = zzagm;
                if (zzcp == null) {
                    try {
                        zzcp asInterface = zzcq.asInterface(zzk(context).instantiate("com.google.android.gms.tagmanager.TagManagerApiImpl"));
                        zzagm = asInterface;
                        zzcp = asInterface;
                    } catch (DynamiteModule.LoadingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return zzcp;
    }

    private static DynamiteModule zzk(Context context) throws DynamiteModule.LoadingException {
        DynamiteModule dynamiteModule = zzagl;
        if (dynamiteModule == null) {
            synchronized (zzbf.class) {
                dynamiteModule = zzagl;
                if (zzagl == null) {
                    DynamiteModule load = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, ModuleDescriptor.MODULE_ID);
                    zzagl = load;
                    dynamiteModule = load;
                }
            }
        }
        return dynamiteModule;
    }

    private static zzcm zzl(Context context) {
        return new zzbg(AppMeasurement.getInstance(context));
    }

    /* access modifiers changed from: private */
    public static Object zza(String str, Class<?> cls) {
        boolean z;
        try {
            Class<?> cls2 = Class.forName(str);
            Class<?>[] interfaces = cls2.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (interfaces[i].equals(cls)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                String canonicalName = cls.getCanonicalName();
                String.valueOf(str).length();
                String.valueOf(canonicalName).length();
                return null;
            }
            try {
                return cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (NoSuchMethodException unused) {
                String.valueOf(str).concat(" doesn't have a valid no-arg constructor");
            } catch (SecurityException unused2) {
                String.valueOf(str).concat(" doesn't have an accessible no-arg constructor");
            } catch (InvocationTargetException unused3) {
                String.valueOf(str).concat(" construction threw an exception.");
            } catch (InstantiationException unused4) {
                String.valueOf(str).concat(" is an abstract class.");
            } catch (IllegalAccessException unused5) {
                String.valueOf(str).concat(" doesn't have an accessible no-arg constructor");
            }
        } catch (ClassNotFoundException unused6) {
            String.valueOf(str).concat(" can't be found in the application.");
        }
    }
}
