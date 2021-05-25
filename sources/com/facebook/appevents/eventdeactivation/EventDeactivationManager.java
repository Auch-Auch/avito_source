package com.facebook.appevents.eventdeactivation;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class EventDeactivationManager {
    public static boolean a = false;
    public static final List<a> b = new ArrayList();
    public static final Set<String> c = new HashSet();

    public static class a {
        public String a;
        public List<String> b;

        public a(String str, List<String> list) {
            this.a = str;
            this.b = list;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void enable() {
        /*
            r0 = 1
            com.facebook.appevents.eventdeactivation.EventDeactivationManager.a = r0
            java.lang.Class<com.facebook.appevents.eventdeactivation.EventDeactivationManager> r0 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.class
            monitor-enter(r0)
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            r2 = 0
            com.facebook.internal.FetchedAppSettings r1 = com.facebook.internal.FetchedAppSettingsManager.queryAppSettings(r1, r2)     // Catch:{ Exception -> 0x006c, all -> 0x0069 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)
            goto L_0x006d
        L_0x0013:
            java.lang.String r1 = r1.getRestrictiveDataSetting()
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x006c
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r1)
            java.util.List<com.facebook.appevents.eventdeactivation.EventDeactivationManager$a> r1 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.b
            r1.clear()
            java.util.Iterator r1 = r2.keys()
        L_0x002b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            org.json.JSONObject r4 = r2.getJSONObject(r3)
            if (r4 == 0) goto L_0x002b
            java.lang.String r5 = "is_deprecated_event"
            boolean r5 = r4.optBoolean(r5)
            if (r5 == 0) goto L_0x004b
            java.util.Set<java.lang.String> r4 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.c
            r4.add(r3)
            goto L_0x002b
        L_0x004b:
            java.lang.String r5 = "deprecated_param"
            org.json.JSONArray r4 = r4.optJSONArray(r5)
            com.facebook.appevents.eventdeactivation.EventDeactivationManager$a r5 = new com.facebook.appevents.eventdeactivation.EventDeactivationManager$a
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r5.<init>(r3, r6)
            if (r4 == 0) goto L_0x0063
            java.util.List r3 = com.facebook.internal.Utility.convertJSONArrayToList(r4)
            r5.b = r3
        L_0x0063:
            java.util.List<com.facebook.appevents.eventdeactivation.EventDeactivationManager$a> r3 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.b
            r3.add(r5)
            goto L_0x002b
        L_0x0069:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x006c:
            monitor-exit(r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.eventdeactivation.EventDeactivationManager.enable():void");
    }

    public static void processDeprecatedParameters(Map<String, String> map, String str) {
        if (a) {
            ArrayList arrayList = new ArrayList(map.keySet());
            Iterator it = new ArrayList(b).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.a.equals(str)) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String str2 = (String) it2.next();
                        if (aVar.b.contains(str2)) {
                            map.remove(str2);
                        }
                    }
                }
            }
        }
    }

    public static void processEvents(List<AppEvent> list) {
        if (a) {
            Iterator<AppEvent> it = list.iterator();
            while (it.hasNext()) {
                if (c.contains(it.next().getName())) {
                    it.remove();
                }
            }
        }
    }
}
