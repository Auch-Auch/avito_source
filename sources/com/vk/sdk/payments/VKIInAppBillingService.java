package com.vk.sdk.payments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.VKUIHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
public final class VKIInAppBillingService {
    public static final Method b;
    public static final Method c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public final Object a;

    public static class a extends d {
        public final /* synthetic */ b c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ String f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i, Context context, String str) {
            super(null);
            this.c = bVar;
            this.d = i;
            this.e = context;
            this.f = str;
        }

        @Override // com.vk.sdk.payments.VKIInAppBillingService.d
        public void a(ComponentName componentName, IBinder iBinder) {
            try {
                Class<?> cls = Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                try {
                    this.c.a = VKIInAppBillingService.a(cls.getMethod("asInterface", IBinder.class).invoke(cls, iBinder), this.d, this.e.getPackageName(), this.f);
                } catch (Exception unused) {
                    this.c.b = true;
                }
            } catch (ClassNotFoundException unused2) {
                throw new RuntimeException("params of constructor don't implement com.android.vending.billing.IInAppBillingService");
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static class b {
        public String a = null;
        public boolean b = false;

        public b(a aVar) {
        }
    }

    public static class c {
        public String a;
        public float b;
        public String c;
        public int d;

        public c(a aVar) {
        }

        public String a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("receipt_data", this.a);
            }
            jSONObject.put("price_value", (double) this.b);
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put(FirebaseAnalytics.Param.CURRENCY, this.c);
            }
            jSONObject.put(FirebaseAnalytics.Param.QUANTITY, this.d);
            return jSONObject.toString();
        }
    }

    public static class d implements ServiceConnection {
        public final Object a = new Object();
        public volatile boolean b = false;

        public d(a aVar) {
        }

        public void a(ComponentName componentName, IBinder iBinder) {
            throw null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.a) {
                try {
                    a(componentName, iBinder);
                } catch (Exception unused) {
                }
                this.b = true;
                this.a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.a) {
                this.b = true;
                this.a.notifyAll();
            }
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.vending.billing.IInAppBillingService");
            Class<?> cls2 = Integer.TYPE;
            b = cls.getMethod("isBillingSupported", cls2, String.class, String.class);
            c = cls.getMethod("getSkuDetails", cls2, String.class, String.class, Bundle.class);
            d = cls.getMethod("getBuyIntent", cls2, String.class, String.class, String.class, String.class);
            e = cls.getMethod("getPurchases", cls2, String.class, String.class, String.class);
            f = cls.getMethod("consumePurchase", cls2, String.class, String.class);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("params of constructor don't implement com.android.vending.billing.IInAppBillingService");
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public VKIInAppBillingService(@NonNull Object obj) {
        this.a = obj;
        try {
            Class.forName("com.android.vending.billing.IInAppBillingService").cast(obj);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("params of constructor don't implement com.android.vending.billing.IInAppBillingService");
        }
    }

    public static String a(@NonNull Object obj, int i, @NonNull String str, @NonNull String str2) throws RemoteException {
        ArrayList<String> stringArrayList = b(obj, i, str, "inapp", str2).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        if (stringArrayList == null) {
            return null;
        }
        for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
            String str3 = stringArrayList.get(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (TextUtils.equals(str2, jSONObject.optString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, jSONObject.optString("purchaseToken")))) {
                    return c(obj, i, str, str3).a();
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static Bundle b(@NonNull Object obj, int i, @NonNull String str, @NonNull String str2, @NonNull String str3) throws RemoteException {
        try {
            return (Bundle) e.invoke(obj, Integer.valueOf(i), str, str2, str3);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static c c(@NonNull Object obj, int i, @NonNull String str, @NonNull String str2) throws JSONException, RemoteException {
        JSONObject jSONObject = new JSONObject(str2);
        c cVar = new c(null);
        cVar.a = str2;
        cVar.d = 1;
        String string = jSONObject.getString("productId");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(string);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        ArrayList<String> stringArrayList = d(obj, i, str, "inapp", bundle).getStringArrayList("DETAILS_LIST");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            try {
                JSONObject jSONObject2 = new JSONObject(stringArrayList.get(0));
                cVar.b = Float.parseFloat(jSONObject2.optString("price_amount_micros")) / 1000000.0f;
                cVar.c = jSONObject2.optString("price_currency_code");
            } catch (JSONException unused) {
            }
        }
        return cVar;
    }

    public static boolean consumePurchaseToVk(int i, @NonNull String str) throws RemoteException {
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            Context applicationContext = VKUIHelper.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            b bVar = new b(null);
            if (a2.s.a.c.b.d()) {
                return true;
            }
            a aVar = new a(bVar, i, applicationContext, str);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            if (applicationContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                return false;
            }
            applicationContext.bindService(intent, aVar, 1);
            synchronized (aVar.a) {
                while (!aVar.b) {
                    try {
                        aVar.a.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            applicationContext.unbindService(aVar);
            if (bVar.b) {
                return false;
            }
            if (!TextUtils.isEmpty(bVar.a)) {
                a2.s.a.c.b.c(applicationContext).h(bVar.a);
            }
            return true;
        }
        throw new RuntimeException("Network on main thread");
    }

    public static Bundle d(@NonNull Object obj, int i, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        try {
            return (Bundle) c.invoke(obj, Integer.valueOf(i), str, str2, bundle);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public int consumePurchase(int i, @NonNull String str, @NonNull String str2) throws RemoteException {
        String a3 = !a2.s.a.c.b.d() ? a(this.a, i, str, str2) : null;
        try {
            int intValue = ((Integer) f.invoke(this.a, Integer.valueOf(i), str, str2)).intValue();
            Context applicationContext = VKUIHelper.getApplicationContext();
            if (!TextUtils.isEmpty(a3) && applicationContext != null) {
                a2.s.a.c.b.c(applicationContext).h(a3);
            }
            return intValue;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public Bundle getBuyIntent(int i, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws RemoteException {
        try {
            return (Bundle) d.invoke(this.a, Integer.valueOf(i), str, str2, str3, str4);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public Bundle getPurchases(int i, @NonNull String str, @NonNull String str2, @NonNull String str3) throws RemoteException {
        return b(this.a, i, str, str2, str3);
    }

    public Bundle getSkuDetails(int i, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        return d(this.a, i, str, str2, bundle);
    }

    public int isBillingSupported(int i, @NonNull String str, @NonNull String str2) throws RemoteException {
        try {
            return ((Integer) b.invoke(this.a, Integer.valueOf(i), str, str2)).intValue();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
