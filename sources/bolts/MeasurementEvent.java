package bolts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
public class MeasurementEvent {
    public static final String APP_LINK_NAVIGATE_IN_EVENT_NAME = "al_nav_in";
    public static final String APP_LINK_NAVIGATE_OUT_EVENT_NAME = "al_nav_out";
    public static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    public static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    public static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    public Context a;
    public String b;
    public Bundle c;

    public MeasurementEvent(Context context, String str, Bundle bundle) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.c = bundle;
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString();
            }
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b(Context context, String str, Intent intent, Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle appLinkData = AppLinks.getAppLinkData(intent);
            if (appLinkData != null) {
                bundle = new Bundle();
                ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
                if (resolveActivity != null) {
                    bundle.putString("class", resolveActivity.getShortClassName());
                }
                if (APP_LINK_NAVIGATE_OUT_EVENT_NAME.equals(str)) {
                    if (resolveActivity != null) {
                        bundle.putString("package", resolveActivity.getPackageName());
                    }
                    if (intent.getData() != null) {
                        bundle.putString("outputURL", intent.getData().toString());
                    }
                    if (intent.getScheme() != null) {
                        bundle.putString("outputURLScheme", intent.getScheme());
                    }
                } else if (APP_LINK_NAVIGATE_IN_EVENT_NAME.equals(str)) {
                    if (intent.getData() != null) {
                        bundle.putString("inputURL", intent.getData().toString());
                    }
                    if (intent.getScheme() != null) {
                        bundle.putString("inputURLScheme", intent.getScheme());
                    }
                }
                for (String str2 : appLinkData.keySet()) {
                    Object obj = appLinkData.get(str2);
                    if (obj instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj;
                        for (String str3 : bundle2.keySet()) {
                            String a3 = a(bundle2.get(str3));
                            if (str2.equals("referer_app_link")) {
                                if (str3.equalsIgnoreCase("url")) {
                                    bundle.putString("refererURL", a3);
                                } else if (str3.equalsIgnoreCase(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)) {
                                    bundle.putString("refererAppName", a3);
                                } else if (str3.equalsIgnoreCase("package")) {
                                    bundle.putString("sourceApplication", a3);
                                }
                            }
                            bundle.putString(str2 + "/" + str3, a3);
                        }
                    } else {
                        String a4 = a(obj);
                        if (str2.equals("target_url")) {
                            Uri parse = Uri.parse(a4);
                            bundle.putString("targetURL", parse.toString());
                            bundle.putString("targetURLHost", parse.getHost());
                        } else {
                            bundle.putString(str2, a4);
                        }
                    }
                }
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString("intentData", data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str4 : extras.keySet()) {
                        bundle.putString(str4, a(extras.get(str4)));
                    }
                }
            }
        }
        if (map != null) {
            for (String str5 : map.keySet()) {
                bundle.putString(str5, map.get(str5));
            }
        }
        MeasurementEvent measurementEvent = new MeasurementEvent(context, str, bundle);
        try {
            Class<?> cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            Method method = cls.getMethod("getInstance", Context.class);
            Method method2 = cls.getMethod("sendBroadcast", Intent.class);
            Object invoke = method.invoke(null, measurementEvent.a);
            Intent intent2 = new Intent(MEASUREMENT_EVENT_NOTIFICATION_NAME);
            intent2.putExtra("event_name", measurementEvent.b);
            intent2.putExtra(MEASUREMENT_EVENT_ARGS_KEY, measurementEvent.c);
            method2.invoke(invoke, intent2);
        } catch (Exception unused) {
        }
    }
}
