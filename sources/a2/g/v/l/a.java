package a2.g.v.l;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.internal.DeviceShareDialogFragment;
import org.json.JSONException;
import org.json.JSONObject;
public class a implements GraphRequest.Callback {
    public final /* synthetic */ DeviceShareDialogFragment a;

    public a(DeviceShareDialogFragment deviceShareDialogFragment) {
        this.a = deviceShareDialogFragment;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            DeviceShareDialogFragment deviceShareDialogFragment = this.a;
            String str = DeviceShareDialogFragment.TAG;
            deviceShareDialogFragment.b(error);
            return;
        }
        JSONObject jSONObject = graphResponse.getJSONObject();
        DeviceShareDialogFragment.c cVar = new DeviceShareDialogFragment.c();
        try {
            cVar.a = jSONObject.getString("user_code");
            cVar.b = jSONObject.getLong("expires_in");
            DeviceShareDialogFragment deviceShareDialogFragment2 = this.a;
            String str2 = DeviceShareDialogFragment.TAG;
            deviceShareDialogFragment2.c(cVar);
        } catch (JSONException unused) {
            DeviceShareDialogFragment deviceShareDialogFragment3 = this.a;
            FacebookRequestError facebookRequestError = new FacebookRequestError(0, "", "Malformed server response");
            String str3 = DeviceShareDialogFragment.TAG;
            deviceShareDialogFragment3.b(facebookRequestError);
        }
    }
}
