package a2.g.k;

import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.FlushResult;
import com.facebook.internal.Logger;
import org.json.JSONArray;
import org.json.JSONException;
public final class j implements GraphRequest.Callback {
    public final /* synthetic */ a a;
    public final /* synthetic */ GraphRequest b;
    public final /* synthetic */ t c;
    public final /* synthetic */ r d;

    public j(a aVar, GraphRequest graphRequest, t tVar, r rVar) {
        this.a = aVar;
        this.b = graphRequest;
        this.c = tVar;
        this.d = rVar;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        String str;
        a aVar = this.a;
        GraphRequest graphRequest = this.b;
        t tVar = this.c;
        r rVar = this.d;
        FacebookRequestError error = graphResponse.getError();
        String str2 = "Success";
        FlushResult flushResult = FlushResult.SUCCESS;
        boolean z = true;
        if (error != null) {
            if (error.getErrorCode() == -1) {
                str2 = "Failed: No Connectivity";
                flushResult = FlushResult.NO_CONNECTIVITY;
            } else {
                str2 = String.format("Failed:\n  Response: %s\n  Error %s", graphResponse.toString(), error.toString());
                flushResult = FlushResult.SERVER_ERROR;
            }
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException unused) {
                str = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, f.a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str2, str);
        }
        if (error == null) {
            z = false;
        }
        synchronized (tVar) {
            if (z) {
                tVar.a.addAll(tVar.b);
            }
            tVar.b.clear();
            tVar.c = 0;
        }
        FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
        if (flushResult == flushResult2) {
            FacebookSdk.getExecutor().execute(new k(aVar, tVar));
        }
        if (flushResult != FlushResult.SUCCESS && rVar.b != flushResult2) {
            rVar.b = flushResult;
        }
    }
}
