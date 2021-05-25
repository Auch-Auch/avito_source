package ru.ok.android.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Odnoklassniki;
import ru.ok.android.sdk.OkRequestMode;
public class OkPayment {
    public static final String METHOD = "sdk.reportPayment";
    public final Queue<b> a = new ConcurrentLinkedQueue();
    public final SharedPreferences b;

    public class b {
        public String a;
        public String b;
        public String c;
        public int d;

        public b(OkPayment okPayment) {
        }

        public b(OkPayment okPayment, String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public class c extends AsyncTask<Void, Void, Void> {
        public c(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void[] voidArr) {
            HashMap hashMap = new HashMap();
            while (true) {
                b peek = OkPayment.this.a.peek();
                if (peek == null) {
                    return null;
                }
                hashMap.clear();
                hashMap.put("trx_id", peek.a);
                hashMap.put("amount", peek.b);
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, peek.c);
                try {
                    JSONObject jSONObject = new JSONObject(Odnoklassniki.getInstance().request(OkPayment.METHOD, hashMap, EnumSet.of(OkRequestMode.SIGNED)));
                    if (jSONObject.optBoolean("result")) {
                        OkPayment.this.a.remove();
                        OkPayment.this.a();
                    } else {
                        jSONObject.toString();
                        jSONObject.optInt("error_code", 0);
                        int i = peek.d + 1;
                        peek.d = i;
                        if (i > 20) {
                            String str = "Reporting TRX " + hashMap + " failed " + peek.d + " times, cancelling";
                            OkPayment.this.a.remove();
                            OkPayment.this.a();
                        } else {
                            OkPayment.this.a();
                            return null;
                        }
                    }
                } catch (IOException | JSONException e) {
                    String str2 = "Failed to report TRX " + hashMap + ", retry queued: " + e.getMessage();
                }
            }
        }
    }

    public OkPayment(Context context) {
        this.b = context.getSharedPreferences("ok.payment", 0);
    }

    public final void a() {
        SharedPreferences.Editor edit = this.b.edit();
        JSONArray jSONArray = new JSONArray();
        try {
            for (b bVar : this.a) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", bVar.a);
                jSONObject.put("amount", bVar.b);
                jSONObject.put(FirebaseAnalytics.Param.CURRENCY, bVar.c);
                int i = bVar.d;
                if (i > 0) {
                    jSONObject.put("tries", i);
                }
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        edit.putString("queue", jSONArray.toString());
        edit.apply();
    }

    public final void b() {
        if (!this.a.isEmpty()) {
            new c(null).execute(new Void[0]);
        }
    }

    public void init() {
        this.a.clear();
        Queue<b> queue = this.a;
        String string = this.b.getString("queue", null);
        ArrayList arrayList = new ArrayList();
        if (string != null && !string.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    b bVar = new b(this);
                    bVar.a = jSONObject.getString("id");
                    bVar.b = jSONObject.getString("amount");
                    bVar.c = jSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                    bVar.d = jSONObject.optInt("tries");
                    arrayList.add(bVar);
                }
            } catch (JSONException e) {
                e.getMessage();
            }
        }
        queue.addAll(arrayList);
        b();
    }

    public void report(String str, String str2, Currency currency) {
        this.a.offer(new b(this, str, str2, currency.getCurrencyCode()));
        a();
        b();
    }
}
