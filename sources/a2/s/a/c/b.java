package a2.s.a.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.sumsub.sns.core.common.SNSConstants;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.payments.VKPaymentsCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.ok.android.sdk.Shared;
public class b {
    public static b f;
    @NonNull
    public final Handler a;
    @NonNull
    public final Context b;
    public volatile int c = -1;
    public final List<VKPaymentsCallback> d = new CopyOnWriteArrayList();
    public Runnable e = new RunnableC0104b();

    public class a implements Runnable {
        public a(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a2.s.a.c.b$b  reason: collision with other inner class name */
    public class RunnableC0104b implements Runnable {

        /* renamed from: a2.s.a.c.b$b$a */
        public class a extends VKRequest.VKRequestListener {
            public a() {
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                try {
                    b.this.e(vKResponse.json.getInt(CommonKt.EXTRA_RESPONSE));
                    String str = "apps.checkUserInstall successful response=" + vKResponse.json;
                } catch (JSONException unused) {
                }
            }
        }

        public RunnableC0104b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!VKSdk.isIsPaymentsEnable()) {
                return;
            }
            if (b.this.c == -1 || b.this.c == 2) {
                int intValue = b.a(b.this.b, VKSdk.SDK_APP_ID).intValue();
                String b = b.b(b.this.b);
                VKRequest vKRequest = new VKRequest("apps.checkUserInstall");
                vKRequest.addExtraParameter(Shared.PARAM_PLATFORM, "android");
                vKRequest.addExtraParameter("app_id", Integer.valueOf(intValue));
                if (b.this.c == 2) {
                    vKRequest.addExtraParameter("force", 1);
                }
                if (!TextUtils.isEmpty(b)) {
                    vKRequest.addExtraParameter(SNSConstants.Preference.KEY_DEVICE_ID, b);
                }
                vKRequest.executeSyncWithListener(new a());
            }
        }
    }

    public class c implements Runnable {
        public final HashSet<String> a;

        public class a extends VKRequest.VKRequestListener {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                a.a(b.this.b).getWritableDatabase().delete("vk_sdk_table_purchase_info", "purchase=?", new String[]{this.a});
                StringBuilder L = a2.b.a.a.a.L("apps.saveTransaction successful response=");
                L.append(vKResponse.json);
                L.toString();
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                VKError vKError2 = vKError.apiError;
                if (vKError2 != null) {
                    String str = vKError2.errorMessage;
                }
            }
        }

        public c(HashSet hashSet, a aVar) {
            this.a = hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.c == 1 || b.this.c == 2) {
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    int intValue = b.a(b.this.b, VKSdk.SDK_APP_ID).intValue();
                    String b2 = b.b(b.this.b);
                    VKRequest vKRequest = new VKRequest("apps.saveTransaction");
                    vKRequest.addExtraParameter(Shared.PARAM_PLATFORM, "android");
                    vKRequest.addExtraParameter("app_id", Integer.valueOf(intValue));
                    if (!TextUtils.isEmpty(b2)) {
                        vKRequest.addExtraParameter(SNSConstants.Preference.KEY_DEVICE_ID, b2);
                    }
                    vKRequest.addExtraParameter("receipt", next);
                    vKRequest.executeSyncWithListener(new a(next));
                }
            }
        }
    }

    public b(@NonNull Context context) {
        int i;
        this.b = context;
        synchronized (b.class) {
            i = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getInt("VK_SDK_CHECK_USER_INSTALL", -1);
        }
        this.c = i;
        HandlerThread handlerThread = new HandlerThread(b.class.getName());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.a = handler;
        handler.post(new a(this));
    }

    public static Integer a(Context context, String str) {
        try {
            return Integer.valueOf(context.getResources().getInteger(context.getResources().getIdentifier(str, "integer", context.getPackageName())));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(cls.getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(cls, context), new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static b c(@NonNull Context context) {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b(context.getApplicationContext());
                }
            }
        }
        return f;
    }

    public static boolean d() {
        if (!VKSdk.isIsPaymentsEnable()) {
            return true;
        }
        Context applicationContext = VKUIHelper.getApplicationContext();
        if (applicationContext == null || c(applicationContext).c != 0) {
            return false;
        }
        return true;
    }

    public final void e(int i) {
        Context context = this.b;
        synchronized (b.class) {
            PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit().putInt("VK_SDK_CHECK_USER_INSTALL", i).apply();
            this.c = i;
        }
        synchronized (b.class) {
            for (VKPaymentsCallback vKPaymentsCallback : this.d) {
                int i2 = this.c;
                if (i2 == 0) {
                    vKPaymentsCallback.onUserState(false);
                } else if (i2 == 1 || i2 == 2) {
                    vKPaymentsCallback.onUserState(true);
                }
            }
            this.d.clear();
        }
    }

    public final void f(boolean z) {
        if (z) {
            e(2);
        }
        if (this.c == -1 || this.c == 2) {
            this.a.post(this.e);
            g();
        } else if (this.c == 1) {
            g();
        }
    }

    public final void g() {
        Cursor query = a.a(this.b).getReadableDatabase().query("vk_sdk_table_purchase_info", new String[]{"purchase"}, null, null, null, null, null);
        HashSet hashSet = new HashSet();
        if (query.moveToFirst()) {
            do {
                hashSet.add(query.getString(0));
            } while (query.moveToNext());
        }
        query.close();
        c cVar = null;
        if (hashSet.size() > 0) {
            cVar = new c(hashSet, null);
        }
        if (cVar != null) {
            this.a.post(cVar);
        }
    }

    public void h(String str) {
        SQLiteDatabase writableDatabase = a.a(this.b).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("purchase", str);
        writableDatabase.insert("vk_sdk_table_purchase_info", "purchase", contentValues);
        f(false);
    }
}
