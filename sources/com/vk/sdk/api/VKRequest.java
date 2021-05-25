package com.vk.sdk.api;

import a2.s.a.a.b;
import a2.s.a.a.c;
import a2.s.a.a.d;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKObject;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKHttpOperation;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import com.vk.sdk.api.httpClient.VKModelOperation;
import com.vk.sdk.api.model.VKApiModel;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONObject;
public class VKRequest extends VKObject {
    public int attempts;
    public final VKParameters c;
    public final Context context;
    public VKParameters d;
    public VKAbstractOperation e;
    public int f;
    public ArrayList<VKRequest> g;
    public Class<? extends VKApiModel> h;
    public VKParser i;
    public String j;
    public boolean k;
    public Looper l;
    public final String methodName;
    public boolean parseModel;
    @Nullable
    public VKRequestListener requestListener;
    public WeakReference<VKResponse> response;
    public boolean secure;
    public boolean shouldInterruptUI;
    public boolean useSystemLanguage;

    @Deprecated
    public enum HttpMethod {
        GET,
        POST
    }

    public enum VKProgressType {
        Download,
        Upload
    }

    public static abstract class VKRequestListener {
        public void attemptFailed(VKRequest vKRequest, int i, int i2) {
        }

        public void onComplete(VKResponse vKResponse) {
        }

        public void onError(VKError vKError) {
        }

        public void onProgress(VKProgressType vKProgressType, long j, long j2) {
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ VKError b;

        public a(boolean z, VKError vKError) {
            this.a = z;
            this.b = vKError;
        }

        @Override // java.lang.Runnable
        public void run() {
            VKRequestListener vKRequestListener;
            if (this.a && (vKRequestListener = VKRequest.this.requestListener) != null) {
                vKRequestListener.onError(this.b);
            }
            ArrayList<VKRequest> arrayList = VKRequest.this.g;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<VKRequest> it = VKRequest.this.g.iterator();
                while (it.hasNext()) {
                    VKRequestListener vKRequestListener2 = it.next().requestListener;
                    if (vKRequestListener2 != null) {
                        vKRequestListener2.onError(this.b);
                    }
                }
            }
        }
    }

    public VKRequest(String str) {
        this(str, null);
    }

    public static boolean a(VKRequest vKRequest, VKError vKError) {
        Objects.requireNonNull(vKRequest);
        if (vKError.errorCode == -101) {
            VKError vKError2 = vKError.apiError;
            VKSdk.notifySdkAboutApiError(vKError2);
            int i2 = vKError2.errorCode;
            if (i2 == 16) {
                VKAccessToken currentToken = VKAccessToken.currentToken();
                if (currentToken != null) {
                    currentToken.httpsRequired = true;
                    currentToken.save();
                }
                vKRequest.repeat();
                return true;
            } else if (vKRequest.shouldInterruptUI) {
                vKError2.request = vKRequest;
                if (vKError.apiError.errorCode == 14) {
                    vKRequest.e = null;
                    VKServiceActivity.interruptWithError(vKRequest.context, vKError2, VKServiceActivity.VKServiceType.Captcha);
                    return true;
                } else if (i2 == 17) {
                    VKServiceActivity.interruptWithError(vKRequest.context, vKError2, VKServiceActivity.VKServiceType.Validation);
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(VKRequest vKRequest, JSONObject jSONObject, Object obj) {
        VKRequestListener vKRequestListener;
        Objects.requireNonNull(vKRequest);
        VKResponse vKResponse = new VKResponse();
        vKResponse.request = vKRequest;
        vKResponse.json = jSONObject;
        vKResponse.parsedModel = obj;
        vKRequest.response = new WeakReference<>(vKResponse);
        VKAbstractOperation vKAbstractOperation = vKRequest.e;
        if (vKAbstractOperation instanceof VKHttpOperation) {
            vKResponse.responseString = ((VKHttpOperation) vKAbstractOperation).getResponseString();
        }
        boolean z = vKRequest.k;
        vKRequest.c(new c(vKRequest, z, vKResponse), 0);
        if (!z && (vKRequestListener = vKRequest.requestListener) != null) {
            vKRequestListener.onComplete(vKResponse);
        }
    }

    public static VKRequest getRegisteredRequest(long j2) {
        return (VKRequest) VKObject.getRegisteredObject(j2);
    }

    public void addExtraParameter(String str, Object obj) {
        this.c.put(str, obj);
    }

    public void addExtraParameters(VKParameters vKParameters) {
        this.c.putAll(vKParameters);
    }

    public final void c(Runnable runnable, int i2) {
        if (this.l == null) {
            this.l = Looper.getMainLooper();
        }
        if (i2 > 0) {
            new Handler(this.l).postDelayed(runnable, (long) i2);
        } else {
            new Handler(this.l).post(runnable);
        }
    }

    public void cancel() {
        VKAbstractOperation vKAbstractOperation = this.e;
        if (vKAbstractOperation != null) {
            vKAbstractOperation.cancel();
        } else {
            provideError(new VKError((int) VKError.VK_CANCELED));
        }
    }

    public void executeAfterRequest(VKRequest vKRequest, VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
        if (vKRequest.g == null) {
            vKRequest.g = new ArrayList<>();
        }
        vKRequest.g.add(this);
    }

    public void executeSyncWithListener(VKRequestListener vKRequestListener) {
        d dVar = new d(vKRequestListener);
        setUseLooperForCallListener(false);
        executeWithListener(dVar);
        synchronized (dVar.a) {
            while (!dVar.c) {
                try {
                    dVar.a.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void executeWithListener(VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
        start();
    }

    public VKParameters getMethodParameters() {
        return this.c;
    }

    public VKAbstractOperation getOperation() {
        if (this.parseModel) {
            if (this.h != null) {
                this.e = new VKModelOperation(getPreparedRequest(), this.h);
            } else if (this.i != null) {
                this.e = new VKModelOperation(getPreparedRequest(), this.i);
            }
        }
        if (this.e == null) {
            this.e = new VKJsonOperation(getPreparedRequest());
        }
        VKAbstractOperation vKAbstractOperation = this.e;
        if (vKAbstractOperation instanceof VKHttpOperation) {
            ((VKHttpOperation) vKAbstractOperation).setHttpOperationListener(new b(this));
        }
        return this.e;
    }

    public VKParameters getPreparedParameters() {
        if (this.d == null) {
            this.d = new VKParameters(this.c);
            VKAccessToken currentToken = VKAccessToken.currentToken();
            if (currentToken != null) {
                this.d.put("access_token", currentToken.accessToken);
                if (currentToken.httpsRequired) {
                    this.secure = true;
                }
            }
            this.d.put(VKApiConst.VERSION, VKSdk.getApiVersion());
            VKParameters vKParameters = this.d;
            String str = this.j;
            Resources system = Resources.getSystem();
            if (this.useSystemLanguage && system != null) {
                str = system.getConfiguration().locale.getLanguage();
                if (str.equals("uk")) {
                    str = AuthSource.OPEN_USER_ADVERT;
                }
                if (!Arrays.asList("ru", "en", AuthSource.OPEN_USER_ADVERT, "es", "fi", "de", "it").contains(str)) {
                    str = this.j;
                }
            }
            vKParameters.put(VKApiConst.LANG, str);
            if (this.secure) {
                this.d.put("https", "1");
            }
            if (!(currentToken == null || currentToken.secret == null)) {
                StringBuilder L = a2.b.a.a.a.L(String.format(Locale.US, "/method/%s?%s", this.methodName, VKStringJoiner.joinParams(this.d)));
                L.append(currentToken.secret);
                this.d.put("sig", VKUtil.md5(L.toString()));
            }
        }
        return this.d;
    }

    public VKHttpClient.VKHTTPRequest getPreparedRequest() {
        VKHttpClient.VKHTTPRequest requestWithVkRequest = VKHttpClient.requestWithVkRequest(this);
        if (requestWithVkRequest != null) {
            return requestWithVkRequest;
        }
        provideError(new VKError((int) VKError.VK_REQUEST_NOT_PREPARED));
        return null;
    }

    public final void provideError(VKError vKError) {
        VKRequestListener vKRequestListener;
        vKError.request = this;
        boolean z = this.k;
        if (!z && (vKRequestListener = this.requestListener) != null) {
            vKRequestListener.onError(vKError);
        }
        c(new a(z, vKError), 0);
    }

    public void repeat() {
        this.f = 0;
        this.d = null;
        this.e = null;
        start();
    }

    public void setModelClass(Class<? extends VKApiModel> cls) {
        this.h = cls;
        if (cls != null) {
            this.parseModel = true;
        }
    }

    public void setPreferredLang(String str) {
        this.useSystemLanguage = false;
        this.j = str;
    }

    public void setRequestListener(@Nullable VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
    }

    public void setResponseParser(VKParser vKParser) {
        this.i = vKParser;
        if (vKParser != null) {
            this.parseModel = true;
        }
    }

    public void setUseLooperForCallListener(boolean z) {
        this.k = z;
    }

    public void start() {
        VKAbstractOperation operation = getOperation();
        this.e = operation;
        if (operation != null) {
            if (this.l == null) {
                this.l = Looper.myLooper();
            }
            VKHttpClient.enqueueOperation(this.e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("{");
        sb.append(this.methodName);
        sb.append(" ");
        VKParameters methodParameters = getMethodParameters();
        for (String str : methodParameters.keySet()) {
            sb.append(str);
            sb.append("=");
            sb.append(methodParameters.get(str));
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    public VKRequest(String str, VKParameters vKParameters) {
        this(str, vKParameters, null);
    }

    @Deprecated
    public VKRequest(String str, VKParameters vKParameters, HttpMethod httpMethod, Class<? extends VKApiModel> cls) {
        this(str, vKParameters, cls);
    }

    public VKRequest(String str, VKParameters vKParameters, Class<? extends VKApiModel> cls) {
        this.k = true;
        this.context = VKUIHelper.getApplicationContext();
        this.methodName = str;
        this.c = new VKParameters(vKParameters == null ? new VKParameters() : vKParameters);
        this.f = 0;
        this.secure = true;
        this.attempts = 1;
        this.j = "en";
        this.useSystemLanguage = true;
        this.shouldInterruptUI = true;
        setModelClass(cls);
    }
}
