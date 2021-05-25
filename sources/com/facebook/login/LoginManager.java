package com.facebook.login;

import a2.g.s.k;
import a2.g.s.l;
import a2.g.s.m;
import a2.g.s.o;
import a2.g.s.q;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public class LoginManager {
    public static final Set<String> e = Collections.unmodifiableSet(new l());
    public static volatile LoginManager f;
    public LoginBehavior a = LoginBehavior.NATIVE_WITH_FALLBACK;
    public DefaultAudience b = DefaultAudience.FRIENDS;
    public final SharedPreferences c;
    public String d = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;

    public class a implements CallbackManagerImpl.Callback {
        public final /* synthetic */ FacebookCallback a;

        public a(FacebookCallback facebookCallback) {
            this.a = facebookCallback;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            LoginManager.this.d(i, intent, this.a);
            return true;
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public b() {
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            LoginManager.this.d(i, intent, null);
            return true;
        }
    }

    public static class c implements q {
        public final Activity a;

        public c(Activity activity) {
            Validate.notNull(activity, "activity");
            this.a = activity;
        }

        @Override // a2.g.s.q
        public Activity a() {
            return this.a;
        }

        @Override // a2.g.s.q
        public void startActivityForResult(Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }
    }

    public static class d implements q {
        public final FragmentWrapper a;

        public d(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.a = fragmentWrapper;
        }

        @Override // a2.g.s.q
        public Activity a() {
            return this.a.getActivity();
        }

        @Override // a2.g.s.q
        public void startActivityForResult(Intent intent, int i) {
            this.a.startActivityForResult(intent, i);
        }
    }

    public LoginManager() {
        Validate.sdkInitialized();
        this.c = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
        if (FacebookSdk.hasCustomTabsPrefetching && CustomTabUtils.getChromePackage() != null) {
            CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
            CustomTabsClient.connectAndInitialize(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
        }
    }

    public static boolean b(String str) {
        return str != null && (str.startsWith(PhotoUploadKt.UPLOAD_TYPE_PUBLISH) || str.startsWith("manage") || e.contains(str));
    }

    public static LoginManager getInstance() {
        if (f == null) {
            synchronized (LoginManager.class) {
                if (f == null) {
                    f = new LoginManager();
                }
            }
        }
        return f;
    }

    public final LoginClient.Request a(GraphResponse graphResponse) {
        Validate.notNull(graphResponse, CommonKt.EXTRA_RESPONSE);
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
    }

    public final void c(Context context, LoginClient.Result.b bVar, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        k a3 = AppCompatDelegateImpl.i.a(context);
        if (a3 != null) {
            if (request == null) {
                a3.b("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", "");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("try_login_activity", z ? "1" : "0");
            Bundle c2 = k.c(request.e);
            if (bVar != null) {
                c2.putString("2_result", bVar.a);
            }
            if (!(exc == null || exc.getMessage() == null)) {
                c2.putString("5_error_message", exc.getMessage());
            }
            JSONObject jSONObject = null;
            if (!hashMap.isEmpty()) {
                jSONObject = new JSONObject(hashMap);
            }
            if (map != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONObject != null) {
                c2.putString("6_extras", jSONObject.toString());
            }
            a3.a.logEventImplicitly("fb_mobile_login_complete", c2);
        }
    }

    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        HashSet hashSet;
        LoginBehavior loginBehavior = this.a;
        if (collection == null) {
            hashSet = new HashSet();
        }
        LoginClient.Request request = new LoginClient.Request(loginBehavior, Collections.unmodifiableSet(hashSet), this.b, this.d, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.f = AccessToken.isCurrentAccessTokenActive();
        return request;
    }

    public LoginClient.Request createReauthorizeRequest() {
        return new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.b, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
    }

    public boolean d(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        FacebookException facebookException;
        AccessToken accessToken;
        Map<String, String> map;
        LoginClient.Result.b bVar;
        LoginClient.Request request;
        Map<String, String> map2;
        boolean z2;
        AccessToken accessToken2;
        LoginClient.Request request2;
        AccessToken accessToken3;
        LoginClient.Result.b bVar2 = LoginClient.Result.b.ERROR;
        LoginResult loginResult = null;
        if (intent != null) {
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.e;
                LoginClient.Result.b bVar3 = result.a;
                if (i == -1) {
                    if (bVar3 == LoginClient.Result.b.SUCCESS) {
                        accessToken3 = result.b;
                        facebookException = null;
                    } else {
                        facebookException = new FacebookAuthorizationException(result.c);
                        accessToken3 = null;
                    }
                } else if (i == 0) {
                    facebookException = null;
                    accessToken3 = null;
                    z2 = true;
                    map2 = result.loggingExtras;
                    request2 = request3;
                    bVar2 = bVar3;
                    accessToken2 = accessToken3;
                } else {
                    facebookException = null;
                    accessToken3 = null;
                }
                z2 = false;
                map2 = result.loggingExtras;
                request2 = request3;
                bVar2 = bVar3;
                accessToken2 = accessToken3;
            } else {
                facebookException = null;
                map2 = null;
                request2 = null;
                accessToken2 = null;
                z2 = false;
            }
            map = map2;
            accessToken = accessToken2;
            z = z2;
            bVar = bVar2;
            request = request2;
        } else if (i == 0) {
            bVar = LoginClient.Result.b.CANCEL;
            facebookException = null;
            request = null;
            map = null;
            accessToken = null;
            z = true;
        } else {
            bVar = bVar2;
            facebookException = null;
            request = null;
            map = null;
            accessToken = null;
            z = false;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        c(null, bVar, map, facebookException, true, request);
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            if (accessToken != null) {
                Set<String> set = request.b;
                HashSet hashSet = new HashSet(accessToken.getPermissions());
                if (request.f) {
                    hashSet.retainAll(set);
                }
                HashSet hashSet2 = new HashSet(set);
                hashSet2.removeAll(hashSet);
                loginResult = new LoginResult(accessToken, hashSet, hashSet2);
            }
            if (z || (loginResult != null && loginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null) {
                SharedPreferences.Editor edit = this.c.edit();
                edit.putBoolean("express_login_allowed", true);
                edit.apply();
                facebookCallback.onSuccess(loginResult);
            }
        }
        return true;
    }

    public final void e(q qVar, LoginClient.Request request) throws FacebookException {
        k a3 = AppCompatDelegateImpl.i.a(qVar.a());
        if (!(a3 == null || request == null)) {
            Bundle c2 = k.c(request.e);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ServerProtocol.DIALOG_PARAM_LOGIN_BEHAVIOR, request.a.toString());
                jSONObject.put("request_code", LoginClient.i());
                jSONObject.put("permissions", TextUtils.join(",", request.b));
                jSONObject.put(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, request.c.toString());
                jSONObject.put("isReauthorize", request.f);
                String str = a3.c;
                if (str != null) {
                    jSONObject.put("facebookVersion", str);
                }
                c2.putString("6_extras", jSONObject.toString());
            } catch (JSONException unused) {
            }
            a3.a.logEventImplicitly("fb_mobile_login_start", null, c2);
        }
        CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new b());
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        boolean z = false;
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(facebookActivityIntent, 0) != null) {
            try {
                qVar.startActivityForResult(facebookActivityIntent, LoginClient.i());
                z = true;
            } catch (ActivityNotFoundException unused2) {
            }
        }
        if (!z) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            c(qVar.a(), LoginClient.Result.b.ERROR, null, facebookException, false, request);
            throw facebookException;
        }
    }

    public final void f(Collection<String> collection) {
        if (collection != null) {
            for (String str : collection) {
                if (!b(str)) {
                    throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", str));
                }
            }
        }
    }

    public final void g(Collection<String> collection) {
        if (collection != null) {
            for (String str : collection) {
                if (b(str)) {
                    throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            }
        }
    }

    public String getAuthType() {
        return this.d;
    }

    public DefaultAudience getDefaultAudience() {
        return this.b;
    }

    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.a.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public LoginBehavior getLoginBehavior() {
        return this.a;
    }

    public void logIn(Fragment fragment, Collection<String> collection) {
        logIn(new FragmentWrapper(fragment), collection);
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
        f(collection);
        logIn(fragmentWrapper, collection);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
        g(collection);
        logIn(fragmentWrapper, collection);
    }

    public void logOut() {
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
        SharedPreferences.Editor edit = this.c.edit();
        edit.putBoolean("express_login_allowed", false);
        edit.apply();
    }

    public void reauthorizeDataAccess(Activity activity) {
        e(new c(activity), createReauthorizeRequest());
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new a(facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        e(new c(activity), a(graphResponse));
    }

    public void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    public LoginManager setAuthType(String str) {
        this.d = str;
        return this;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        this.b = defaultAudience;
        return this;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        this.a = loginBehavior;
        return this;
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public void logIn(android.app.Fragment fragment, Collection<String> collection) {
        logIn(new FragmentWrapper(fragment), collection);
    }

    public void retrieveLoginStatus(Context context, long j, LoginStatusCallback loginStatusCallback) {
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        k kVar = new k(context, applicationId);
        if (!this.c.getBoolean("express_login_allowed", true)) {
            kVar.a(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        o oVar = new o(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j);
        oVar.setCompletedListener(new m(this, uuid, kVar, loginStatusCallback, applicationId));
        kVar.a.logEventImplicitly("fb_mobile_login_status_start", k.c(uuid));
        if (!oVar.start()) {
            kVar.a(uuid);
            loginStatusCallback.onFailure();
        }
    }

    public void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        e(new d(fragmentWrapper), createLoginRequest(collection));
    }

    public void reauthorizeDataAccess(Fragment fragment) {
        FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
        e(new d(fragmentWrapper), createReauthorizeRequest());
    }

    public void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
        f(collection);
        logIn(fragmentWrapper, collection);
    }

    public void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
        g(collection);
        logIn(fragmentWrapper, collection);
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        e(new d(new FragmentWrapper(fragment)), a(graphResponse));
    }

    public void logIn(Activity activity, Collection<String> collection) {
        e(new c(activity), createLoginRequest(collection));
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        f(collection);
        logIn(activity, collection);
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        g(collection);
        logIn(activity, collection);
    }

    public void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        e(new d(new FragmentWrapper(fragment)), a(graphResponse));
    }
}
