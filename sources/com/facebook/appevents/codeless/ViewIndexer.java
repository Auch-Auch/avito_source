package com.facebook.appevents.codeless;

import a2.g.k.x.e;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.avito.android.util.preferences.Preference;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Shared;
@AutoHandleExceptions
public class ViewIndexer {
    public static ViewIndexer e;
    public final Handler a = new Handler(Looper.getMainLooper());
    public WeakReference<Activity> b;
    public Timer c;
    public String d = null;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                Activity activity = ViewIndexer.this.b.get();
                View rootView = AppEventUtility.getRootView(activity);
                if (activity == null) {
                    return;
                }
                if (rootView != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    if (CodelessManager.f.booleanValue()) {
                        if (InternalSettings.isUnityApp()) {
                            UnityReflection.captureViewHierarchy();
                            return;
                        }
                        FutureTask futureTask = new FutureTask(new d(rootView));
                        ViewIndexer.this.a.post(futureTask);
                        String str = "";
                        try {
                            str = (String) futureTask.get(1, TimeUnit.SECONDS);
                        } catch (Exception unused) {
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(ViewHierarchy.getDictionaryOfView(rootView));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException unused2) {
                        }
                        String jSONObject2 = jSONObject.toString();
                        ViewIndexer viewIndexer = ViewIndexer.this;
                        Objects.requireNonNull(viewIndexer);
                        FacebookSdk.getExecutor().execute(new e(viewIndexer, jSONObject2));
                    }
                }
            } catch (Exception unused3) {
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ TimerTask a;

        public b(TimerTask timerTask) {
            this.a = timerTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Timer timer = ViewIndexer.this.c;
                if (timer != null) {
                    timer.cancel();
                }
                ViewIndexer viewIndexer = ViewIndexer.this;
                viewIndexer.d = null;
                viewIndexer.c = new Timer();
                ViewIndexer.this.c.scheduleAtFixedRate(this.a, 0, 1000);
            } catch (Exception unused) {
            }
        }
    }

    public static class c implements GraphRequest.Callback {
        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            Logger.log(LoggingBehavior.APP_EVENTS, "com.facebook.appevents.codeless.ViewIndexer", "App index sent to FB!");
        }
    }

    public static class d implements Callable<String> {
        public WeakReference<View> a;

        public d(View view) {
            this.a = new WeakReference<>(view);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            View view = this.a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }

    public ViewIndexer(Activity activity) {
        this.b = new WeakReference<>(activity);
        e = this;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static GraphRequest buildAppIndexingRequest(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest newPostRequest = GraphRequest.newPostRequest(accessToken, String.format(Locale.US, "%s/app_indexing", str2), null, null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("tree", str);
        parameters.putString(Preference.APP_VERSION, AppEventUtility.getAppVersion());
        parameters.putString(Shared.PARAM_PLATFORM, "android");
        parameters.putString("request_type", str3);
        if (str3.equals(Constants.APP_INDEXING)) {
            if (CodelessManager.d == null) {
                CodelessManager.d = UUID.randomUUID().toString();
            }
            parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.d);
        }
        newPostRequest.setParameters(parameters);
        newPostRequest.setCallback(new c());
        return newPostRequest;
    }

    public static void sendToServerUnityInstance(String str) {
        ViewIndexer viewIndexer = e;
        if (viewIndexer != null) {
            viewIndexer.sendToServerUnity(str);
        }
    }

    public void schedule() {
        try {
            FacebookSdk.getExecutor().execute(new b(new a()));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Deprecated
    public void sendToServerUnity(String str) {
        ViewIndexer viewIndexer = e;
        Objects.requireNonNull(viewIndexer);
        FacebookSdk.getExecutor().execute(new e(viewIndexer, str));
    }

    public void unschedule() {
        Timer timer;
        if (this.b.get() != null && (timer = this.c) != null) {
            try {
                timer.cancel();
                this.c = null;
            } catch (Exception unused) {
            }
        }
    }
}
