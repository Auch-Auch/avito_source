package a2.s.a.a;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import com.vk.sdk.api.httpClient.VKModelOperation;
import org.json.JSONException;
import org.json.JSONObject;
public class b extends VKJsonOperation.VKJSONOperationCompleteListener {
    public final /* synthetic */ VKRequest a;

    public b(VKRequest vKRequest) {
        this.a = vKRequest;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, java.lang.Object] */
    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
    public void onComplete(VKJsonOperation vKJsonOperation, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2.has("error")) {
            try {
                VKError vKError = new VKError(jSONObject2.getJSONObject("error"));
                if (!VKRequest.a(this.a, vKError)) {
                    this.a.provideError(vKError);
                }
            } catch (JSONException unused) {
            }
        } else {
            VKRequest vKRequest = this.a;
            VKAbstractOperation vKAbstractOperation = vKRequest.e;
            VKRequest.b(vKRequest, jSONObject2, vKAbstractOperation instanceof VKModelOperation ? ((VKModelOperation) vKAbstractOperation).parsedModel : null);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, com.vk.sdk.api.VKError] */
    @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
    public void onError(VKJsonOperation vKJsonOperation, VKError vKError) {
        VKHttpClient.VKHttpResponse vKHttpResponse;
        VKJsonOperation vKJsonOperation2 = vKJsonOperation;
        int i = vKError.errorCode;
        if (i == -102 || i == -101 || vKJsonOperation2 == null || (vKHttpResponse = vKJsonOperation2.response) == null || vKHttpResponse.statusCode != 200) {
            VKRequest vKRequest = this.a;
            int i2 = vKRequest.attempts;
            if (i2 != 0) {
                int i3 = vKRequest.f + 1;
                vKRequest.f = i3;
                if (i3 >= i2) {
                    vKRequest.provideError(vKError);
                    return;
                }
            }
            VKRequest.VKRequestListener vKRequestListener = vKRequest.requestListener;
            if (vKRequestListener != null) {
                vKRequestListener.attemptFailed(vKRequest, vKRequest.f, i2);
            }
            this.a.c(new a(this), 300);
            return;
        }
        VKRequest.b(this.a, vKJsonOperation2.getResponseJson(), null);
    }
}
