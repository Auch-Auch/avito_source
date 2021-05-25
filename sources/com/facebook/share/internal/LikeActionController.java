package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
public class LikeActionController {
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    @Deprecated
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    @Deprecated
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    @Deprecated
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    public static FileLruCache o;
    public static final ConcurrentHashMap<String, LikeActionController> p = new ConcurrentHashMap<>();
    public static WorkQueue q = new WorkQueue(1);
    public static WorkQueue r = new WorkQueue(1);
    public static Handler s;
    public static String t;
    public static boolean u;
    public static volatile int v;
    public String a;
    public LikeView.ObjectType b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;
    public Bundle m;
    public InternalAppEventsLogger n;

    @Deprecated
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    public class a implements GraphRequestBatch.Callback {
        public final /* synthetic */ f a;
        public final /* synthetic */ h b;
        public final /* synthetic */ n c;

        public a(f fVar, h hVar, n nVar) {
            this.a = fVar;
            this.b = hVar;
            this.c = nVar;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            LikeActionController likeActionController = LikeActionController.this;
            String str = this.a.e;
            likeActionController.i = str;
            if (Utility.isNullOrEmpty(str)) {
                LikeActionController likeActionController2 = LikeActionController.this;
                h hVar = this.b;
                likeActionController2.i = hVar.e;
                likeActionController2.j = hVar.f;
            }
            if (Utility.isNullOrEmpty(LikeActionController.this.i)) {
                LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                String str2 = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
                Logger.log(loggingBehavior, "LikeActionController", "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.a);
                LikeActionController likeActionController3 = LikeActionController.this;
                FacebookRequestError facebookRequestError = this.b.d;
                if (facebookRequestError == null) {
                    facebookRequestError = this.a.d;
                }
                LikeActionController.b(likeActionController3, "get_verified_id", facebookRequestError);
            }
            n nVar = this.c;
            if (nVar != null) {
                nVar.onComplete();
            }
        }
    }

    public static class b implements CreationCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Intent c;

        public b(int i, int i2, Intent intent) {
            this.a = i;
            this.b = i2;
            this.c = intent;
        }

        @Override // com.facebook.share.internal.LikeActionController.CreationCallback
        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            if (facebookException == null) {
                ShareInternalUtility.handleActivityResult(this.a, this.b, this.c, new a2.g.v.l.g(likeActionController, null, likeActionController.m));
                likeActionController.m = null;
                LikeActionController.n(null);
                return;
            }
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Utility.logd("LikeActionController", facebookException);
        }
    }

    public abstract class c {
        public GraphRequest a;
        public String b;
        public LikeView.ObjectType c;
        public FacebookRequestError d;

        public class a implements GraphRequest.Callback {
            public a() {
            }

            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                c.this.d = graphResponse.getError();
                c cVar = c.this;
                FacebookRequestError facebookRequestError = cVar.d;
                if (facebookRequestError != null) {
                    cVar.c(facebookRequestError);
                } else {
                    cVar.d(graphResponse);
                }
            }
        }

        public c(LikeActionController likeActionController, String str, LikeView.ObjectType objectType) {
            this.b = str;
            this.c = objectType;
        }

        public abstract void c(FacebookRequestError facebookRequestError);

        public abstract void d(GraphResponse graphResponse);

        public void e(GraphRequest graphRequest) {
            this.a = graphRequest;
            graphRequest.setVersion(FacebookSdk.getGraphApiVersion());
            graphRequest.setCallback(new a());
        }
    }

    public static class d implements Runnable {
        public String a;
        public LikeView.ObjectType b;
        public CreationCallback c;

        public d(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
            this.a = str;
            this.b = objectType;
            this.c = creationCallback;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
            if (r4 == null) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
            if (r4 != null) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
            com.facebook.internal.Utility.closeQuietly(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
            if (r5 != null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
            r5 = new com.facebook.share.internal.LikeActionController(r0, r1);
            com.facebook.share.internal.LikeActionController.m(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
            r0 = com.facebook.share.internal.LikeActionController.h(r0);
            com.facebook.share.internal.LikeActionController.q.addActiveWorkItem(new com.facebook.share.internal.LikeActionController.k(r0, true));
            com.facebook.share.internal.LikeActionController.p.put(r0, r5);
            com.facebook.share.internal.LikeActionController.s.post(new a2.g.v.l.c(r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
            if (r2 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
            com.facebook.share.internal.LikeActionController.s.post(new a2.g.v.l.e(r2, r5, null));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = r7.a
                com.facebook.share.widget.LikeView$ObjectType r1 = r7.b
                com.facebook.share.internal.LikeActionController$CreationCallback r2 = r7.c
                com.facebook.share.internal.LikeActionController r3 = com.facebook.share.internal.LikeActionController.i(r0)
                if (r3 == 0) goto L_0x0011
                com.facebook.share.internal.LikeActionController.q(r3, r1, r2)
                goto L_0x0079
            L_0x0011:
                r3 = 0
                java.lang.String r4 = com.facebook.share.internal.LikeActionController.h(r0)     // Catch:{ IOException -> 0x003d, all -> 0x0036 }
                com.facebook.internal.FileLruCache r5 = com.facebook.share.internal.LikeActionController.o     // Catch:{ IOException -> 0x003d, all -> 0x0036 }
                java.io.InputStream r4 = r5.get(r4)     // Catch:{ IOException -> 0x003d, all -> 0x0036 }
                if (r4 == 0) goto L_0x0032
                java.lang.String r5 = com.facebook.internal.Utility.readStreamToString(r4)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
                boolean r6 = com.facebook.internal.Utility.isNullOrEmpty(r5)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
                if (r6 != 0) goto L_0x0032
                com.facebook.share.internal.LikeActionController r5 = com.facebook.share.internal.LikeActionController.e(r5)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
                goto L_0x0033
            L_0x002d:
                r0 = move-exception
                r3 = r4
                goto L_0x0037
            L_0x0030:
                goto L_0x003e
            L_0x0032:
                r5 = r3
            L_0x0033:
                if (r4 == 0) goto L_0x0044
                goto L_0x0041
            L_0x0036:
                r0 = move-exception
            L_0x0037:
                if (r3 == 0) goto L_0x003c
                com.facebook.internal.Utility.closeQuietly(r3)
            L_0x003c:
                throw r0
            L_0x003d:
                r4 = r3
            L_0x003e:
                r5 = r3
                if (r4 == 0) goto L_0x0044
            L_0x0041:
                com.facebook.internal.Utility.closeQuietly(r4)
            L_0x0044:
                if (r5 != 0) goto L_0x004e
                com.facebook.share.internal.LikeActionController r5 = new com.facebook.share.internal.LikeActionController
                r5.<init>(r0, r1)
                com.facebook.share.internal.LikeActionController.m(r5)
            L_0x004e:
                java.lang.String r0 = com.facebook.share.internal.LikeActionController.h(r0)
                com.facebook.internal.WorkQueue r1 = com.facebook.share.internal.LikeActionController.q
                com.facebook.share.internal.LikeActionController$k r4 = new com.facebook.share.internal.LikeActionController$k
                r6 = 1
                r4.<init>(r0, r6)
                r1.addActiveWorkItem(r4)
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.facebook.share.internal.LikeActionController> r1 = com.facebook.share.internal.LikeActionController.p
                r1.put(r0, r5)
                android.os.Handler r0 = com.facebook.share.internal.LikeActionController.s
                a2.g.v.l.c r1 = new a2.g.v.l.c
                r1.<init>(r5)
                r0.post(r1)
                if (r2 != 0) goto L_0x006f
                goto L_0x0079
            L_0x006f:
                android.os.Handler r0 = com.facebook.share.internal.LikeActionController.s
                a2.g.v.l.e r1 = new a2.g.v.l.e
                r1.<init>(r2, r5, r3)
                r0.post(r1)
            L_0x0079:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeActionController.d.run():void");
        }
    }

    public class e extends c {
        public String e;
        public String f;
        public String g;
        public String h;

        public e(String str, LikeView.ObjectType objectType) {
            super(LikeActionController.this, str, objectType);
            this.e = LikeActionController.this.d;
            this.f = LikeActionController.this.e;
            this.g = LikeActionController.this.f;
            this.h = LikeActionController.this.g;
            Bundle y1 = a2.b.a.a.a.y1("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            y1.putString("locale", Locale.getDefault().toString());
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), str, y1, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error fetching engagement for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
            LikeActionController.b(LikeActionController.this, "get_engagement", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.e = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.e);
                this.f = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.f);
                this.g = tryGetJSONObjectFromResponse.optString("social_sentence_with_like", this.g);
                this.h = tryGetJSONObjectFromResponse.optString("social_sentence_without_like", this.h);
            }
        }
    }

    public class f extends c {
        public String e;

        public f(LikeActionController likeActionController, String str, LikeView.ObjectType objectType) {
            super(likeActionController, str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.d = null;
                return;
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error getting the FB id for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.b);
            if (tryGetJSONObjectFromResponse != null && (optJSONObject = tryGetJSONObjectFromResponse.optJSONObject("og_object")) != null) {
                this.e = optJSONObject.optString("id");
            }
        }
    }

    public class g extends c implements j {
        public boolean e;
        public String f;
        public final String g;
        public final LikeView.ObjectType h;

        public g(String str, LikeView.ObjectType objectType) {
            super(LikeActionController.this, str, objectType);
            this.e = LikeActionController.this.c;
            this.g = str;
            this.h = objectType;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", str);
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.j
        public String a() {
            return this.f;
        }

        @Override // com.facebook.share.internal.LikeActionController.j
        public boolean b() {
            return this.e;
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error fetching like status for object '%s' with type '%s' : %s", this.g, this.h, facebookRequestError);
            LikeActionController.b(LikeActionController.this, "get_og_object_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null) {
                for (int i2 = 0; i2 < tryGetJSONArrayFromResponse.length(); i2++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.e = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && AccessToken.isCurrentAccessTokenActive() && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.f = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }
    }

    public class h extends c {
        public String e;
        public boolean f;

        public h(LikeActionController likeActionController, String str, LikeView.ObjectType objectType) {
            super(likeActionController, str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error getting the FB id for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.b);
            if (tryGetJSONObjectFromResponse != null) {
                String optString = tryGetJSONObjectFromResponse.optString("id");
                this.e = optString;
                this.f = !Utility.isNullOrEmpty(optString);
            }
        }
    }

    public class i extends c implements j {
        public boolean e;
        public String f;

        public i(String str) {
            super(LikeActionController.this, str, LikeView.ObjectType.PAGE);
            this.e = LikeActionController.this.c;
            this.f = str;
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), a2.b.a.a.a.c3("me/likes/", str), a2.b.a.a.a.y1("fields", "id"), HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.j
        public String a() {
            return null;
        }

        @Override // com.facebook.share.internal.LikeActionController.j
        public boolean b() {
            return this.e;
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error fetching like status for page id '%s': %s", this.f, facebookRequestError);
            LikeActionController.b(LikeActionController.this, "get_page_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.e = true;
            }
        }
    }

    public interface j {
        String a();

        boolean b();
    }

    public static class k implements Runnable {
        public static ArrayList<String> c = new ArrayList<>();
        public String a;
        public boolean b;

        public k(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            if (str != null) {
                c.remove(str);
                c.add(0, this.a);
            }
            if (this.b && c.size() >= 128) {
                while (64 < c.size()) {
                    ArrayList<String> arrayList = c;
                    LikeActionController.p.remove(arrayList.remove(arrayList.size() - 1));
                }
            }
        }
    }

    public class l extends c {
        public String e;

        public l(String str, LikeView.ObjectType objectType) {
            super(LikeActionController.this, str, objectType);
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", a2.b.a.a.a.y1("object", str), HttpMethod.POST));
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == 3501) {
                this.d = null;
                return;
            }
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error liking object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
            LikeActionController.b(LikeActionController.this, "publish_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
            this.e = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), "id");
        }
    }

    public class m extends c {
        public String e;

        public m(String str) {
            super(LikeActionController.this, null, null);
            this.e = str;
            e(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void c(FacebookRequestError facebookRequestError) {
            LoggingBehavior loggingBehavior = LoggingBehavior.REQUESTS;
            String str = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            Logger.log(loggingBehavior, "LikeActionController", "Error unliking object with unlike token '%s' : %s", this.e, facebookRequestError);
            LikeActionController.b(LikeActionController.this, "publish_unlike", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.c
        public void d(GraphResponse graphResponse) {
        }
    }

    public interface n {
        void onComplete();
    }

    public static class o implements Runnable {
        public String a;
        public String b;

        public o(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            String str2 = this.b;
            String str3 = LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED;
            OutputStream outputStream = null;
            try {
                outputStream = LikeActionController.o.openPutStream(str);
                outputStream.write(str2.getBytes());
            } catch (IOException unused) {
                if (outputStream == null) {
                    return;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    Utility.closeQuietly(outputStream);
                }
                throw th;
            }
            Utility.closeQuietly(outputStream);
        }
    }

    public LikeActionController(String str, LikeView.ObjectType objectType) {
        this.a = str;
        this.b = objectType;
    }

    public static void a(LikeActionController likeActionController, Bundle bundle) {
        boolean z = likeActionController.c;
        if (z != likeActionController.k && !likeActionController.l(z, bundle)) {
            likeActionController.o(!likeActionController.c);
            Bundle bundle2 = new Bundle();
            bundle2.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
            c(likeActionController, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle2);
        }
    }

    public static void b(LikeActionController likeActionController, String str, FacebookRequestError facebookRequestError) {
        JSONObject requestResult;
        Objects.requireNonNull(likeActionController);
        Bundle bundle = new Bundle();
        if (!(facebookRequestError == null || (requestResult = facebookRequestError.getRequestResult()) == null)) {
            bundle.putString("error", requestResult.toString());
        }
        likeActionController.j(str, bundle);
    }

    public static void c(LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
    }

    public static LikeActionController e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            LikeActionController likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
            likeActionController.d = jSONObject.optString("like_count_string_with_like", null);
            likeActionController.e = jSONObject.optString("like_count_string_without_like", null);
            likeActionController.f = jSONObject.optString("social_sentence_with_like", null);
            likeActionController.g = jSONObject.optString("social_sentence_without_like", null);
            likeActionController.c = jSONObject.optBoolean("is_object_liked");
            likeActionController.h = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                likeActionController.m = BundleJSONConverter.convertToBundle(optJSONObject);
            }
            return likeActionController;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Deprecated
    public static void getControllerForObjectId(String str, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        if (!u) {
            synchronized (LikeActionController.class) {
                if (!u) {
                    s = new Handler(Looper.getMainLooper());
                    v = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                    o = new FileLruCache("LikeActionController", new FileLruCache.Limits());
                    new a2.g.v.l.f();
                    CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new a2.g.v.l.d());
                    u = true;
                }
            }
        }
        LikeActionController i2 = i(str);
        if (i2 != null) {
            q(i2, objectType, creationCallback);
        } else {
            r.addActiveWorkItem(new d(str, objectType, creationCallback));
        }
    }

    public static String h(String str) {
        String token = AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : null;
        if (token != null) {
            token = Utility.md5hash(token);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.coerceValueIfNullOrEmpty(token, ""), Integer.valueOf(v));
    }

    @Deprecated
    public static boolean handleOnActivityResult(int i2, int i3, Intent intent) {
        if (Utility.isNullOrEmpty(t)) {
            t = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (Utility.isNullOrEmpty(t)) {
            return false;
        }
        getControllerForObjectId(t, LikeView.ObjectType.UNKNOWN, new b(i2, i3, intent));
        return true;
    }

    public static LikeActionController i(String str) {
        String h2 = h(str);
        LikeActionController likeActionController = p.get(h2);
        if (likeActionController != null) {
            q.addActiveWorkItem(new k(h2, false));
        }
        return likeActionController;
    }

    public static void m(LikeActionController likeActionController) {
        String str;
        JSONObject convertToJSON;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", likeActionController.a);
            jSONObject.put("object_type", likeActionController.b.getValue());
            jSONObject.put("like_count_string_with_like", likeActionController.d);
            jSONObject.put("like_count_string_without_like", likeActionController.e);
            jSONObject.put("social_sentence_with_like", likeActionController.f);
            jSONObject.put("social_sentence_without_like", likeActionController.g);
            jSONObject.put("is_object_liked", likeActionController.c);
            jSONObject.put("unlike_token", likeActionController.h);
            Bundle bundle = likeActionController.m;
            if (!(bundle == null || (convertToJSON = BundleJSONConverter.convertToJSON(bundle)) == null)) {
                jSONObject.put("facebook_dialog_analytics_bundle", convertToJSON);
            }
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        String h2 = h(likeActionController.a);
        if (!Utility.isNullOrEmpty(str) && !Utility.isNullOrEmpty(h2)) {
            r.addActiveWorkItem(new o(h2, str));
        }
    }

    public static void n(String str) {
        t = str;
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", t).apply();
    }

    public static void q(LikeActionController likeActionController, LikeView.ObjectType objectType, CreationCallback creationCallback) {
        LikeView.ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.b);
        FacebookException facebookException = null;
        if (mostSpecificObjectType == null) {
            Object[] objArr = {likeActionController.a, likeActionController.b.toString(), objectType.toString()};
            likeActionController = null;
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", objArr);
        } else {
            likeActionController.b = mostSpecificObjectType;
        }
        if (creationCallback != null) {
            s.post(new a2.g.v.l.e(creationCallback, likeActionController, facebookException));
        }
    }

    public final boolean d() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return !this.j && this.i != null && AccessToken.isCurrentAccessTokenActive() && currentAccessToken.getPermissions() != null && currentAccessToken.getPermissions().contains("publish_actions");
    }

    public final void f(n nVar) {
        if (!Utility.isNullOrEmpty(this.i)) {
            nVar.onComplete();
            return;
        }
        f fVar = new f(this, this.a, this.b);
        h hVar = new h(this, this.a, this.b);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        graphRequestBatch.add(fVar.a);
        graphRequestBatch.add(hVar.a);
        graphRequestBatch.addCallback(new a(fVar, hVar, nVar));
        graphRequestBatch.executeAsync();
    }

    public final InternalAppEventsLogger g() {
        if (this.n == null) {
            this.n = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        }
        return this.n;
    }

    @Deprecated
    public String getLikeCountString() {
        return this.c ? this.d : this.e;
    }

    @Deprecated
    public String getObjectId() {
        return this.a;
    }

    @Deprecated
    public String getSocialSentence() {
        return this.c ? this.f : this.g;
    }

    @Deprecated
    public boolean isObjectLiked() {
        return this.c;
    }

    public final void j(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.a);
        bundle2.putString("object_type", this.b.toString());
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
    }

    public final void k(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        String str;
        String str2 = null;
        if (LikeDialog.canShowNativeDialog()) {
            str2 = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG;
        } else if (LikeDialog.canShowWebFallback()) {
            str2 = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK;
        } else {
            j("present_dialog", bundle);
            Utility.logd("LikeActionController", "Cannot show the Like Dialog on this device.");
            c(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED, null);
        }
        if (str2 != null) {
            LikeView.ObjectType objectType = this.b;
            if (objectType != null) {
                str = objectType.toString();
            } else {
                str = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new LikeContent.Builder().setObjectId(this.a).setObjectType(str).build();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            n(this.a);
            this.m = bundle;
            m(this);
            g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, bundle);
        }
    }

    public final boolean l(boolean z, Bundle bundle) {
        if (d()) {
            if (z) {
                this.l = true;
                f(new a2.g.v.l.h(this, bundle));
                return true;
            } else if (!Utility.isNullOrEmpty(this.h)) {
                this.l = true;
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                m mVar = new m(this.h);
                graphRequestBatch.add(mVar.a);
                graphRequestBatch.addCallback(new a2.g.v.l.i(this, mVar, bundle));
                graphRequestBatch.executeAsync();
                return true;
            }
        }
        return false;
    }

    public final void o(boolean z) {
        p(z, this.d, this.e, this.f, this.g, this.h);
    }

    public final void p(boolean z, String str, String str2, String str3, String str4, String str5) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        if (z != this.c || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.d) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.e) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.f) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.g) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.h)) {
            this.c = z;
            this.d = coerceValueIfNullOrEmpty;
            this.e = coerceValueIfNullOrEmpty2;
            this.f = coerceValueIfNullOrEmpty3;
            this.g = coerceValueIfNullOrEmpty4;
            this.h = coerceValueIfNullOrEmpty5;
            m(this);
            c(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED, null);
        }
    }

    @Deprecated
    public boolean shouldEnableView() {
        return false;
    }

    @Deprecated
    public void toggleLike(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = !this.c;
        if (d()) {
            o(z);
            if (this.l) {
                g().logEventImplicitly(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, bundle);
            } else if (!l(z, bundle)) {
                o(!z);
                k(activity, fragmentWrapper, bundle);
            }
        } else {
            k(activity, fragmentWrapper, bundle);
        }
    }
}
