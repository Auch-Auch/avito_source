package a2.g.o.a;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
public class b implements GraphRequest.Callback {
    public String a;
    public String b;
    public int c;
    @Nullable
    public String d;
    public GraphRequest.Callback e;

    public b(String str, String str2, int i, @Nullable String str3, GraphRequest.Callback callback) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (graphResponse.getError() == null) {
            String optString = graphResponse.getJSONObject().optString("id");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString("title", this.a);
            bundle.putString(SDKConstants.PARAM_A2U_BODY, this.b);
            bundle.putInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, this.c);
            String str = this.d;
            if (str != null) {
                bundle.putString(SDKConstants.PARAM_A2U_PAYLOAD, str);
            }
            bundle.putString(SDKConstants.PARAM_A2U_MEDIA_ID, optString);
            new GraphRequest(currentAccessToken, SDKConstants.PARAM_A2U_GRAPH_PATH, bundle, HttpMethod.POST, this.e).executeAsync();
            return;
        }
        throw new FacebookException(graphResponse.getError().getErrorMessage());
    }
}
