package com.facebook.internal.logging.monitor;

import android.os.Build;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingCache;
import com.facebook.internal.logging.LoggingManager;
import com.facebook.internal.logging.LoggingStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MonitorLoggingManager implements LoggingManager {
    public static final Integer f = 100;
    public static MonitorLoggingManager g;
    public static String h = Build.VERSION.RELEASE;
    public static String i = Build.MODEL;
    public final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
    public LoggingCache b;
    public LoggingStore c;
    public ScheduledFuture d;
    public final Runnable e = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MonitorLoggingManager.this.flushAndWait();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ExternalLog a;

        public b(ExternalLog externalLog) {
            this.a = externalLog;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MonitorLoggingManager.this.b.addLog(this.a)) {
                MonitorLoggingManager.this.flushAndWait();
                return;
            }
            MonitorLoggingManager monitorLoggingManager = MonitorLoggingManager.this;
            if (monitorLoggingManager.d == null) {
                monitorLoggingManager.d = monitorLoggingManager.a.schedule(monitorLoggingManager.e, 5, TimeUnit.MINUTES);
            }
        }
    }

    public MonitorLoggingManager(LoggingCache loggingCache, LoggingStore loggingStore) {
        if (this.b == null) {
            this.b = loggingCache;
        }
        if (this.c == null) {
            this.c = loggingStore;
        }
    }

    public static synchronized MonitorLoggingManager getInstance(LoggingCache loggingCache, LoggingStore loggingStore) {
        MonitorLoggingManager monitorLoggingManager;
        synchronized (MonitorLoggingManager.class) {
            if (g == null) {
                g = new MonitorLoggingManager(loggingCache, loggingStore);
            }
            monitorLoggingManager = g;
        }
        return monitorLoggingManager;
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void addLog(ExternalLog externalLog) {
        this.a.execute(new b(externalLog));
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void flushAndWait() {
        ScheduledFuture scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        LoggingCache loggingCache = this.b;
        ArrayList arrayList = new ArrayList();
        if (!Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
            while (!loggingCache.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < f.intValue() && !loggingCache.isEmpty(); i2++) {
                    arrayList2.add(loggingCache.fetchLog());
                }
                String packageName = FacebookSdk.getApplicationContext().getPackageName();
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((ExternalLog) it.next()).convertToJSONObject());
                }
                GraphRequest graphRequest = null;
                if (jSONArray.length() != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_OS_VERSION, h);
                        jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_MODEL, i);
                        jSONObject.put(MonitorLogServerProtocol.PARAM_UNIQUE_APPLICATION_ID, packageName);
                        jSONObject.put("entries", jSONArray.toString());
                        graphRequest = GraphRequest.newPostRequest(null, String.format("%s/monitorings", FacebookSdk.getApplicationId()), jSONObject, null);
                    } catch (JSONException unused) {
                    }
                }
                if (graphRequest != null) {
                    arrayList.add(graphRequest);
                }
            }
        }
        try {
            new GraphRequestBatch(arrayList).executeAsync();
        } catch (Exception unused2) {
        }
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void flushLoggingStore() {
        this.b.addLogs(this.c.readAndClearStore());
        flushAndWait();
    }
}
