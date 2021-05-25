package com.google.firebase.iid;

import a2.b.a.a.a;
import a2.j.e.i.c0;
import a2.j.e.i.f;
import a2.j.e.i.g;
import a2.j.e.i.h0;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
@KeepForSdk
public class GmsRpc {
    @KeepForSdk
    public static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    @KeepForSdk
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public final FirebaseApp a;
    public final Metadata b;
    public final h0 c;
    public final UserAgentPublisher d;
    public final HeartBeatInfo e;
    public final FirebaseInstallationsApi f;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        h0 h0Var = new h0(firebaseApp.getApplicationContext(), metadata);
        this.a = firebaseApp;
        this.b = metadata;
        this.c = h0Var;
        this.d = userAgentPublisher;
        this.e = heartBeatInfo;
        this.f = firebaseInstallationsApi;
    }

    public final Task<String> a(Task<Bundle> task) {
        Executor executor = g.a;
        return task.continueWith(f.a, new Continuation(this) { // from class: a2.j.e.i.o
            public final GmsRpc a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Objects.requireNonNull(this.a);
                Bundle bundle = (Bundle) task2.getResult(IOException.class);
                if (bundle != null) {
                    String string = bundle.getString("registration_id");
                    if (string != null || (string = bundle.getString("unregistered")) != null) {
                        return string;
                    }
                    String string2 = bundle.getString("error");
                    if ("RST".equals(string2)) {
                        throw new IOException("INSTANCE_ID_RESET");
                    } else if (string2 != null) {
                        throw new IOException(string2);
                    } else {
                        String.valueOf(bundle).length();
                        new Throwable();
                        throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
                    }
                } else {
                    throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
                }
            }
        });
    }

    public final Task<Bundle> b(String str, String str2, String str3, Bundle bundle) {
        String str4;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.b.getGmsVersionCode()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.b.getAppVersionCode());
        bundle.putString("app_ver_name", this.b.getAppVersionName());
        try {
            str4 = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.a.getName().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            str4 = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", str4);
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.f.getToken(false))).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            }
        } catch (InterruptedException | ExecutionException unused2) {
        }
        bundle.putString("cliv", "fiid-".concat("20.2.4"));
        HeartBeatInfo.HeartBeat heartBeatCode = this.e.getHeartBeatCode("fire-iid");
        if (heartBeatCode != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", this.d.getUserAgent());
        }
        h0 h0Var = this.c;
        if (h0Var.c.getGmsVersionCode() >= 12000000) {
            Task<Bundle> sendRequestForResponse = MessengerIpcClient.getInstance(h0Var.b).sendRequestForResponse(1, bundle);
            Executor executor = g.a;
            return sendRequestForResponse.continueWith(f.a, c0.a);
        } else if (!h0Var.c.isGmscorePresent()) {
            return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
        } else {
            Task<Bundle> a3 = h0Var.a(bundle);
            Executor executor2 = g.a;
            return a3.continueWithTask(f.a, new Continuation(h0Var, bundle) { // from class: a2.j.e.i.d0
                public final h0 a;
                public final Bundle b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    h0 h0Var2 = this.a;
                    Bundle bundle2 = this.b;
                    Objects.requireNonNull(h0Var2);
                    if (!task.isSuccessful()) {
                        return task;
                    }
                    Bundle bundle3 = (Bundle) task.getResult();
                    if (!(bundle3 != null && bundle3.containsKey("google.messenger"))) {
                        return task;
                    }
                    Task<Bundle> a4 = h0Var2.a(bundle2);
                    Executor executor3 = g.a;
                    return a4.onSuccessTask(f.a, g0.a);
                }
            });
        }
    }

    public Task<?> deleteInstanceId(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("iid-operation", PhoneActionStrings.REMOVE);
        bundle.putString(PhoneActionStrings.REMOVE, "1");
        return a(b(str, "*", "*", bundle));
    }

    public Task<?> deleteToken(String str, String str2, String str3) {
        return a(b(str, str2, str3, a.y1(PhoneActionStrings.REMOVE, "1")));
    }

    public Task<String> getToken(String str, String str2, String str3) {
        return a(b(str, str2, str3, new Bundle()));
    }

    @KeepForSdk
    public Task<?> subscribeToTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(b(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }

    @KeepForSdk
    public Task<?> unsubscribeFromTopic(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString(PhoneActionStrings.REMOVE, "1");
        String valueOf2 = String.valueOf(str3);
        return a(b(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle));
    }
}
