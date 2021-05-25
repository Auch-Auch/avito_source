package a2.g.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.adjust.sdk.Constants;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class f {
    public static final String a = "a2.g.k.f";
    public static volatile e b = new e();
    public static final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    public static ScheduledFuture d;
    public static final Runnable e = new a();

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            f.d = null;
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                f.a(q.TIMER);
            }
        }
    }

    public static void a(q qVar) {
        s a3 = l.a();
        e eVar = b;
        synchronized (eVar) {
            for (a aVar : a3.a.keySet()) {
                t a4 = eVar.a(aVar);
                for (AppEvent appEvent : a3.a.get(aVar)) {
                    a4.a(appEvent);
                }
            }
        }
        try {
            r b2 = b(qVar, b);
            if (b2 != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, b2.a);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, b2.b);
                LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
            }
        } catch (Exception unused) {
        }
    }

    public static r b(q qVar, e eVar) {
        t tVar;
        String str;
        GraphRequest graphRequest;
        JSONObject jSONObject;
        r rVar = new r();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = eVar.b().iterator();
        while (true) {
            int i = 0;
            if (it.hasNext()) {
                a next = it.next();
                synchronized (eVar) {
                    tVar = eVar.a.get(next);
                }
                String str2 = next.b;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(str2, false);
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", str2), null, null);
                Bundle parameters = newPostRequest.getParameters();
                if (parameters == null) {
                    parameters = new Bundle();
                }
                parameters.putString("access_token", next.a);
                synchronized (o.f) {
                    str = o.i;
                }
                if (str != null) {
                    parameters.putString("device_token", str);
                }
                InstallReferrerUtil.tryUpdateReferrerInfo(new n());
                String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getString(Constants.INSTALL_REFERRER, null);
                if (string != null) {
                    parameters.putString(Constants.INSTALL_REFERRER, string);
                }
                newPostRequest.setParameters(parameters);
                boolean supportsImplicitLogging = queryAppSettings != null ? queryAppSettings.supportsImplicitLogging() : false;
                Context applicationContext = FacebookSdk.getApplicationContext();
                synchronized (tVar) {
                    int i2 = tVar.c;
                    EventDeactivationManager.processEvents(tVar.a);
                    tVar.b.addAll(tVar.a);
                    tVar.a.clear();
                    JSONArray jSONArray = new JSONArray();
                    for (AppEvent appEvent : tVar.b) {
                        if (!appEvent.isChecksumValid()) {
                            Utility.logd("Event with invalid checksum: %s", appEvent.toString());
                        } else if (supportsImplicitLogging || !appEvent.getIsImplicit()) {
                            jSONArray.put(appEvent.getJSONObject());
                        }
                    }
                    if (jSONArray.length() != 0) {
                        try {
                            jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, tVar.d, tVar.e, limitEventAndDataUsage, applicationContext);
                            if (tVar.c > 0) {
                                jSONObject.put("num_skipped_events", i2);
                            }
                        } catch (JSONException unused) {
                            jSONObject = new JSONObject();
                        }
                        newPostRequest.setGraphObject(jSONObject);
                        Bundle parameters2 = newPostRequest.getParameters();
                        if (parameters2 == null) {
                            parameters2 = new Bundle();
                        }
                        String jSONArray2 = jSONArray.toString();
                        if (jSONArray2 != null) {
                            parameters2.putString("custom_events", jSONArray2);
                            newPostRequest.setTag(jSONArray2);
                        }
                        newPostRequest.setParameters(parameters2);
                        i = jSONArray.length();
                    }
                }
                if (i == 0) {
                    graphRequest = null;
                } else {
                    rVar.a += i;
                    newPostRequest.setCallback(new j(next, newPostRequest, tVar, rVar));
                    graphRequest = newPostRequest;
                }
                if (graphRequest != null) {
                    arrayList.add(graphRequest);
                }
            } else if (arrayList.size() <= 0) {
                return null;
            } else {
                Logger.log(LoggingBehavior.APP_EVENTS, a, "Flushing %d events due to %s.", Integer.valueOf(rVar.a), qVar.toString());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((GraphRequest) it2.next()).executeAndWait();
                }
                return rVar;
            }
        }
    }
}
