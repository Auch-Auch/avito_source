package a2.g.k.a0;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.Utility;
import org.json.JSONObject;
public class f implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ViewOnClickListener d;

    public f(ViewOnClickListener viewOnClickListener, JSONObject jSONObject, String str, String str2) {
        this.d = viewOnClickListener;
        this.a = jSONObject;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] predict;
        try {
            String lowerCase = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
            float[] a3 = a.a(this.a, lowerCase);
            String str = this.b;
            String str2 = this.d.d;
            String lowerCase2 = (lowerCase + " | " + str2 + ", " + str).toLowerCase();
            if (a3 != null && (predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{a3}, new String[]{lowerCase2})) != null) {
                String str3 = predict[0];
                b.a(this.c, str3);
                if (!str3.equals("other")) {
                    ViewOnClickListener.a(str3, this.b, a3);
                }
            }
        } catch (Exception unused) {
        }
    }
}
