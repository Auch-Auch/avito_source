package a2.g.r.l;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentData;
import org.json.JSONException;
public final class a implements GraphRequest.Callback {
    public final /* synthetic */ InstrumentData a;

    public a(InstrumentData instrumentData) {
        this.a = instrumentData;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        try {
            if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                this.a.clear();
            }
        } catch (JSONException unused) {
        }
    }
}
