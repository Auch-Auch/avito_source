package a2.g.s;

import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;
public class a implements GraphRequest.Callback {
    public final /* synthetic */ DeviceAuthDialog a;

    public a(DeviceAuthDialog deviceAuthDialog) {
        this.a = deviceAuthDialog;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (!this.a.e.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                int subErrorCode = error.getSubErrorCode();
                if (subErrorCode != 1349152) {
                    switch (subErrorCode) {
                        case 1349172:
                        case 1349174:
                            this.a.d();
                            return;
                        case 1349173:
                            this.a.onCancel();
                            return;
                        default:
                            this.a.onError(graphResponse.getError().getException());
                            return;
                    }
                } else {
                    if (this.a.h != null) {
                        DeviceRequestsHelper.cleanUpAdvertisementService(this.a.h.b);
                    }
                    DeviceAuthDialog deviceAuthDialog = this.a;
                    LoginClient.Request request = deviceAuthDialog.l;
                    if (request != null) {
                        deviceAuthDialog.startLogin(request);
                    } else {
                        deviceAuthDialog.onCancel();
                    }
                }
            } else {
                try {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    DeviceAuthDialog.a(this.a, jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong("expires_in")), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                } catch (JSONException e) {
                    this.a.onError(new FacebookException(e));
                }
            }
        }
    }
}
