package a2.g.r;

import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.WebDialog;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
public class j implements GraphRequest.Callback {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CountDownLatch c;
    public final /* synthetic */ WebDialog.e d;

    public j(WebDialog.e eVar, String[] strArr, int i, CountDownLatch countDownLatch) {
        this.d = eVar;
        this.a = strArr;
        this.b = i;
        this.c = countDownLatch;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        try {
            FacebookRequestError error = graphResponse.getError();
            String str = "Error staging photo.";
            if (error != null) {
                String errorMessage = error.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                throw new FacebookGraphResponseException(graphResponse, str);
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject != null) {
                String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
                if (optString != null) {
                    this.a[this.b] = optString;
                    this.c.countDown();
                    return;
                }
                throw new FacebookException(str);
            }
            throw new FacebookException(str);
        } catch (Exception e) {
            this.d.c[this.b] = e;
        }
    }
}
