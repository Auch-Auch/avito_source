package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;
public class DaemonRequest {
    public Context a;
    public JSONObject b;
    public Callback c;
    public ConcurrentHashMap<String, CompletableFuture<GraphResponse>> d;
    public SDKLogger e;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public class a implements Supplier<GraphResponse> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.function.Supplier
        public GraphResponse get() {
            String uuid = UUID.randomUUID().toString();
            try {
                DaemonRequest.this.b.put(SDKConstants.REQUEST_ID, uuid);
                Intent intent = new Intent();
                String string = DaemonRequest.this.b.getString("type");
                DaemonRequest daemonRequest = DaemonRequest.this;
                daemonRequest.e.logPreparingRequest(string, uuid, daemonRequest.b);
                if (!string.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                    String string2 = DaemonRequest.this.a.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, null);
                    if (string2 == null) {
                        return DaemonReceiver.c(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), uuid);
                    }
                    intent.setPackage(string2);
                }
                intent.setAction(SDKConstants.REQUEST_ACTION);
                Iterator<String> keys = DaemonRequest.this.b.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    intent.putExtra(next, DaemonRequest.this.b.getString(next));
                }
                DaemonRequest.this.a.sendBroadcast(intent);
                DaemonRequest daemonRequest2 = DaemonRequest.this;
                daemonRequest2.e.logSentRequest(string, uuid, daemonRequest2.b);
                CompletableFuture<GraphResponse> completableFuture = new CompletableFuture<>();
                DaemonRequest.this.d.put(uuid, completableFuture);
                return completableFuture.get();
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                return DaemonReceiver.c(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), uuid);
            }
        }
    }

    public DaemonRequest(Context context, JSONObject jSONObject, Callback callback) {
        DaemonReceiver daemonReceiver;
        ConcurrentHashMap<String, CompletableFuture<GraphResponse>> concurrentHashMap;
        this.a = context;
        this.b = jSONObject;
        this.c = callback;
        synchronized (DaemonReceiver.class) {
            if (DaemonReceiver.a == null) {
                DaemonReceiver.a = new DaemonReceiver(context);
            }
            daemonReceiver = DaemonReceiver.a;
        }
        synchronized (daemonReceiver) {
            concurrentHashMap = DaemonReceiver.b;
        }
        this.d = concurrentHashMap;
        this.e = SDKLogger.getInstance(context);
    }

    public static GraphResponse executeAndWait(Context context, @Nullable JSONObject jSONObject, SDKMessageEnum sDKMessageEnum) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject().put("type", sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                return DaemonReceiver.c(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null);
            }
        } else {
            jSONObject2 = jSONObject.put("type", sDKMessageEnum.toString());
        }
        return new DaemonRequest(context, jSONObject2, null).a().get();
    }

    public static void executeAsync(Context context, @Nullable JSONObject jSONObject, Callback callback, SDKMessageEnum sDKMessageEnum) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject().put("type", sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | JSONException unused) {
                if (callback != null) {
                    callback.onCompleted(DaemonReceiver.c(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null));
                    return;
                }
                return;
            }
        } else {
            jSONObject2 = jSONObject.put("type", sDKMessageEnum.toString());
        }
        DaemonRequest daemonRequest = new DaemonRequest(context, jSONObject2, callback);
        daemonRequest.a().thenAccept((Consumer<? super GraphResponse>) new a2.g.o.a.a(daemonRequest));
    }

    public final CompletableFuture<GraphResponse> a() {
        return CompletableFuture.supplyAsync(new a());
    }

    public final GraphResponse b(int i) throws ExecutionException, InterruptedException, TimeoutException {
        return a().get((long) i, TimeUnit.SECONDS);
    }

    public static GraphResponse executeAndWait(Context context, @Nullable JSONObject jSONObject, SDKMessageEnum sDKMessageEnum, int i) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject().put("type", sDKMessageEnum.toString());
            } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
                return DaemonReceiver.c(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), null);
            }
        } else {
            jSONObject2 = jSONObject.put("type", sDKMessageEnum.toString());
        }
        return new DaemonRequest(context, jSONObject2, null).b(i);
    }
}
