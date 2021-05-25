package com.facebook;

import com.facebook.internal.Utility;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
public class GraphResponse {
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    public static final String SUCCESS_KEY = "success";
    public final HttpURLConnection a;
    public final JSONObject b;
    public final JSONArray c;
    public final FacebookRequestError d;
    public final String e;
    public final GraphRequest f;

    public enum PagingDirection {
        NEXT,
        PREVIOUS
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    public static List<GraphResponse> a(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new GraphResponse(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.facebook.AccessToken */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.facebook.AccessToken */
    /* JADX DEBUG: Multi-variable search result rejected for r3v32, resolved type: com.facebook.AccessToken */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0120 A[SYNTHETIC, Splitter:B:64:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.GraphResponse b(com.facebook.GraphRequest r22, java.net.HttpURLConnection r23, java.lang.Object r24, java.lang.Object r25) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 552
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.b(com.facebook.GraphRequest, java.net.HttpURLConnection, java.lang.Object, java.lang.Object):com.facebook.GraphResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.facebook.GraphResponse> c(java.io.InputStream r12, java.net.HttpURLConnection r13, com.facebook.GraphRequestBatch r14) throws com.facebook.FacebookException, org.json.JSONException, java.io.IOException {
        /*
            java.lang.String r12 = com.facebook.internal.Utility.readStreamToString(r12)
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.INCLUDE_RAW_RESPONSES
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            int r3 = r12.length()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r12
            java.lang.String r5 = "Response"
            java.lang.String r6 = "Response (raw)\n  Size: %d\n  Response:\n%s\n"
            com.facebook.internal.Logger.log(r0, r5, r6, r2)
            org.json.JSONTokener r0 = new org.json.JSONTokener
            r0.<init>(r12)
            java.lang.Object r0 = r0.nextValue()
            int r2 = r14.size()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r2)
            if (r2 != r3) goto L_0x0071
            java.lang.Object r7 = r14.get(r4)
            com.facebook.GraphRequest r7 = (com.facebook.GraphRequest) r7
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            r8.<init>()     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            java.lang.String r9 = "body"
            r8.put(r9, r0)     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            int r9 = r13.getResponseCode()     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            java.lang.String r10 = "code"
            r8.put(r10, r9)     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            r9.<init>()     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            r9.put(r8)     // Catch:{ JSONException -> 0x0063, IOException -> 0x0054 }
            goto L_0x0072
        L_0x0054:
            r8 = move-exception
            com.facebook.GraphResponse r9 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r10 = new com.facebook.FacebookRequestError
            r10.<init>(r13, r8)
            r9.<init>(r7, r13, r10)
            r6.add(r9)
            goto L_0x0071
        L_0x0063:
            r8 = move-exception
            com.facebook.GraphResponse r9 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r10 = new com.facebook.FacebookRequestError
            r10.<init>(r13, r8)
            r9.<init>(r7, r13, r10)
            r6.add(r9)
        L_0x0071:
            r9 = r0
        L_0x0072:
            boolean r7 = r9 instanceof org.json.JSONArray
            if (r7 == 0) goto L_0x00d2
            org.json.JSONArray r9 = (org.json.JSONArray) r9
            int r7 = r9.length()
            if (r7 != r2) goto L_0x00d2
            r2 = 0
        L_0x007f:
            int r7 = r9.length()
            if (r2 >= r7) goto L_0x00b7
            java.lang.Object r7 = r14.get(r2)
            com.facebook.GraphRequest r7 = (com.facebook.GraphRequest) r7
            java.lang.Object r8 = r9.get(r2)     // Catch:{ JSONException -> 0x00a6, FacebookException -> 0x0097 }
            com.facebook.GraphResponse r8 = b(r7, r13, r8, r0)     // Catch:{ JSONException -> 0x00a6, FacebookException -> 0x0097 }
            r6.add(r8)     // Catch:{ JSONException -> 0x00a6, FacebookException -> 0x0097 }
            goto L_0x00b4
        L_0x0097:
            r8 = move-exception
            com.facebook.GraphResponse r10 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r11 = new com.facebook.FacebookRequestError
            r11.<init>(r13, r8)
            r10.<init>(r7, r13, r11)
            r6.add(r10)
            goto L_0x00b4
        L_0x00a6:
            r8 = move-exception
            com.facebook.GraphResponse r10 = new com.facebook.GraphResponse
            com.facebook.FacebookRequestError r11 = new com.facebook.FacebookRequestError
            r11.<init>(r13, r8)
            r10.<init>(r7, r13, r11)
            r6.add(r10)
        L_0x00b4:
            int r2 = r2 + 1
            goto L_0x007f
        L_0x00b7:
            com.facebook.LoggingBehavior r13 = com.facebook.LoggingBehavior.REQUESTS
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r14 = r14.d
            r0[r4] = r14
            int r12 = r12.length()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r0[r3] = r12
            r0[r1] = r6
            java.lang.String r12 = "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n"
            com.facebook.internal.Logger.log(r13, r5, r12, r0)
            return r6
        L_0x00d2:
            com.facebook.FacebookException r12 = new com.facebook.FacebookException
            java.lang.String r13 = "Unexpected number of results"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphResponse.c(java.io.InputStream, java.net.HttpURLConnection, com.facebook.GraphRequestBatch):java.util.List");
    }

    public final HttpURLConnection getConnection() {
        return this.a;
    }

    public final FacebookRequestError getError() {
        return this.d;
    }

    public final JSONArray getJSONArray() {
        return this.c;
    }

    public final JSONObject getJSONObject() {
        return this.b;
    }

    public String getRawResponse() {
        return this.e;
    }

    public GraphRequest getRequest() {
        return this.f;
    }

    public GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        JSONObject optJSONObject;
        JSONObject jSONObject = this.b;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("paging")) == null) {
            str = null;
        } else {
            str = pagingDirection == PagingDirection.NEXT ? optJSONObject.optString("next") : optJSONObject.optString("previous");
        }
        if (Utility.isNullOrEmpty(str)) {
            return null;
        }
        if (str != null && str.equals(this.f.e())) {
            return null;
        }
        try {
            return new GraphRequest(this.f.getAccessToken(), new URL(str));
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0017: APUT  
      (r2v3 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0013: INVOKE  (r4v2 java.lang.Integer) = (r4v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    public String toString() {
        String str;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            HttpURLConnection httpURLConnection = this.a;
            objArr[0] = Integer.valueOf(httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
            str = String.format(locale, "%d", objArr);
        } catch (IOException unused) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.b + ", error: " + this.d + "}";
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    public GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f = graphRequest;
        this.a = httpURLConnection;
        this.e = str;
        this.b = jSONObject;
        this.c = jSONArray;
        this.d = facebookRequestError;
    }
}
