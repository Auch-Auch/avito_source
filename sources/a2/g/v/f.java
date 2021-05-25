package a2.g.v;

import com.facebook.FacebookCallback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Mutable;
import com.facebook.share.ShareApi;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import org.json.JSONObject;
public class f implements GraphRequest.Callback {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Mutable c;
    public final /* synthetic */ FacebookCallback d;

    public f(ShareApi shareApi, ArrayList arrayList, ArrayList arrayList2, Mutable mutable, FacebookCallback facebookCallback) {
        this.a = arrayList;
        this.b = arrayList2;
        this.c = mutable;
        this.d = facebookCallback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        JSONObject jSONObject = graphResponse.getJSONObject();
        if (jSONObject != null) {
            this.a.add(jSONObject);
        }
        if (graphResponse.getError() != null) {
            this.b.add(graphResponse);
        }
        Mutable mutable = this.c;
        mutable.value = (T) Integer.valueOf(mutable.value.intValue() - 1);
        if (this.c.value.intValue() != 0) {
            return;
        }
        if (!this.b.isEmpty()) {
            ShareInternalUtility.invokeCallbackWithResults(this.d, null, (GraphResponse) this.b.get(0));
        } else if (!this.a.isEmpty()) {
            ShareInternalUtility.invokeCallbackWithResults(this.d, ((JSONObject) this.a.get(0)).optString("id"), graphResponse);
        }
    }
}
