package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import bolts.AppLink;
import bolts.AppLinkResolver;
import bolts.Continuation;
import bolts.Task;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class FacebookAppLinkResolver implements AppLinkResolver {
    public final HashMap<Uri, AppLink> a = new HashMap<>();

    public class a implements Continuation<Map<Uri, AppLink>, AppLink> {
        public final /* synthetic */ Uri a;

        public a(FacebookAppLinkResolver facebookAppLinkResolver, Uri uri) {
            this.a = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public AppLink then(Task<Map<Uri, AppLink>> task) throws Exception {
            return task.getResult().get(this.a);
        }
    }

    public class b implements GraphRequest.Callback {
        public final /* synthetic */ Task.TaskCompletionSource a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ HashSet c;

        public b(Task.TaskCompletionSource taskCompletionSource, Map map, HashSet hashSet) {
            this.a = taskCompletionSource;
            this.b = map;
            this.c = hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v2, types: [bolts.AppLink$Target] */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ad, code lost:
            if (r7 != null) goto L_0x00b1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0 A[SYNTHETIC] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.facebook.GraphRequest.Callback
        @com.facebook.internal.instrument.crashshield.AutoHandleExceptions
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted(com.facebook.GraphResponse r14) {
            /*
                r13 = this;
                com.facebook.FacebookRequestError r0 = r14.getError()
                if (r0 == 0) goto L_0x0010
                bolts.Task$TaskCompletionSource r14 = r13.a
                com.facebook.FacebookException r0 = r0.getException()
                r14.setError(r0)
                return
            L_0x0010:
                org.json.JSONObject r14 = r14.getJSONObject()
                if (r14 != 0) goto L_0x001e
                bolts.Task$TaskCompletionSource r14 = r13.a
                java.util.Map r0 = r13.b
                r14.setResult(r0)
                return
            L_0x001e:
                java.util.HashSet r0 = r13.c
                java.util.Iterator r0 = r0.iterator()
            L_0x0024:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x00d0
                java.lang.Object r1 = r0.next()
                android.net.Uri r1 = (android.net.Uri) r1
                java.lang.String r2 = r1.toString()
                boolean r2 = r14.has(r2)
                if (r2 != 0) goto L_0x003b
                goto L_0x0024
            L_0x003b:
                java.lang.String r2 = r1.toString()     // Catch:{ JSONException -> 0x00cd }
                org.json.JSONObject r2 = r14.getJSONObject(r2)     // Catch:{ JSONException -> 0x00cd }
                java.lang.String r3 = "app_links"
                org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x00cd }
                java.lang.String r3 = "android"
                org.json.JSONArray r3 = r2.getJSONArray(r3)     // Catch:{ JSONException -> 0x00cd }
                int r4 = r3.length()     // Catch:{ JSONException -> 0x00cd }
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x00cd }
                r5.<init>(r4)     // Catch:{ JSONException -> 0x00cd }
                r6 = 0
            L_0x0059:
                r7 = 0
                if (r6 >= r4) goto L_0x008f
                org.json.JSONObject r8 = r3.getJSONObject(r6)     // Catch:{ JSONException -> 0x00cd }
                java.lang.String r9 = "package"
                java.lang.String r9 = com.facebook.applinks.FacebookAppLinkResolver.a(r8, r9, r7)     // Catch:{ JSONException -> 0x00cd }
                if (r9 != 0) goto L_0x0069
                goto L_0x0087
            L_0x0069:
                java.lang.String r10 = "class"
                java.lang.String r10 = com.facebook.applinks.FacebookAppLinkResolver.a(r8, r10, r7)     // Catch:{ JSONException -> 0x00cd }
                java.lang.String r11 = "app_name"
                java.lang.String r11 = com.facebook.applinks.FacebookAppLinkResolver.a(r8, r11, r7)     // Catch:{ JSONException -> 0x00cd }
                java.lang.String r12 = "url"
                java.lang.String r8 = com.facebook.applinks.FacebookAppLinkResolver.a(r8, r12, r7)     // Catch:{ JSONException -> 0x00cd }
                if (r8 == 0) goto L_0x0081
                android.net.Uri r7 = android.net.Uri.parse(r8)     // Catch:{ JSONException -> 0x00cd }
            L_0x0081:
                bolts.AppLink$Target r8 = new bolts.AppLink$Target     // Catch:{ JSONException -> 0x00cd }
                r8.<init>(r9, r10, r7, r11)     // Catch:{ JSONException -> 0x00cd }
                r7 = r8
            L_0x0087:
                if (r7 == 0) goto L_0x008c
                r5.add(r7)     // Catch:{ JSONException -> 0x00cd }
            L_0x008c:
                int r6 = r6 + 1
                goto L_0x0059
            L_0x008f:
                java.lang.String r3 = "web"
                org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x00b0 }
                java.lang.String r3 = "should_fallback"
                boolean r3 = r2.getBoolean(r3)     // Catch:{ JSONException -> 0x009c }
                goto L_0x009d
            L_0x009c:
                r3 = 1
            L_0x009d:
                if (r3 != 0) goto L_0x00a0
                goto L_0x00b1
            L_0x00a0:
                java.lang.String r3 = "url"
                java.lang.String r2 = com.facebook.applinks.FacebookAppLinkResolver.a(r2, r3, r7)
                if (r2 == 0) goto L_0x00ad
                android.net.Uri r2 = android.net.Uri.parse(r2)
                r7 = r2
            L_0x00ad:
                if (r7 == 0) goto L_0x00b0
                goto L_0x00b1
            L_0x00b0:
                r7 = r1
            L_0x00b1:
                bolts.AppLink r2 = new bolts.AppLink
                r2.<init>(r1, r5, r7)
                java.util.Map r3 = r13.b
                r3.put(r1, r2)
                com.facebook.applinks.FacebookAppLinkResolver r3 = com.facebook.applinks.FacebookAppLinkResolver.this
                java.util.HashMap<android.net.Uri, bolts.AppLink> r3 = r3.a
                monitor-enter(r3)
                com.facebook.applinks.FacebookAppLinkResolver r4 = com.facebook.applinks.FacebookAppLinkResolver.this     // Catch:{ all -> 0x00ca }
                java.util.HashMap<android.net.Uri, bolts.AppLink> r4 = r4.a     // Catch:{ all -> 0x00ca }
                r4.put(r1, r2)     // Catch:{ all -> 0x00ca }
                monitor-exit(r3)     // Catch:{ all -> 0x00ca }
                goto L_0x0024
            L_0x00ca:
                r1 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00ca }
                throw r1
            L_0x00cd:
                goto L_0x0024
            L_0x00d0:
                bolts.Task$TaskCompletionSource r14 = r13.a
                java.util.Map r0 = r13.b
                r14.setResult(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.applinks.FacebookAppLinkResolver.b.onCompleted(com.facebook.GraphResponse):void");
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // bolts.AppLinkResolver
    public Task<AppLink> getAppLinkFromUrlInBackground(Uri uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).onSuccess(new a(this, uri));
    }

    public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        AppLink appLink;
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Uri uri : list) {
            synchronized (this.a) {
                appLink = this.a.get(uri);
            }
            if (appLink != null) {
                hashMap.put(uri, appLink);
            } else {
                if (!hashSet.isEmpty()) {
                    sb.append(',');
                }
                sb.append(uri.toString());
                hashSet.add(uri);
            }
        }
        if (hashSet.isEmpty()) {
            return Task.forResult(hashMap);
        }
        Task<TResult>.TaskCompletionSource create = Task.create();
        Bundle bundle = new Bundle();
        bundle.putString("ids", sb.toString());
        bundle.putString("fields", String.format("%s.fields(%s,%s)", "app_links", "android", "web"));
        new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new b(create, hashMap, hashSet)).executeAsync();
        return create.getTask();
    }
}
