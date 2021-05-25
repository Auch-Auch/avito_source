package a2.g.v.l;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import org.json.JSONException;
public class o implements Runnable {
    public final /* synthetic */ FacebookException a;
    public final /* synthetic */ String b;
    public final /* synthetic */ VideoUploader.e c;

    public o(VideoUploader.e eVar, FacebookException facebookException, String str) {
        this.c = eVar;
        this.a = facebookException;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoUploader.e eVar = this.c;
        VideoUploader.d dVar = eVar.a;
        FacebookException facebookException = this.a;
        GraphResponse graphResponse = eVar.c;
        String str = this.b;
        boolean z = VideoUploader.a;
        synchronized (VideoUploader.class) {
            VideoUploader.d.remove(dVar);
        }
        Utility.closeQuietly(dVar.k);
        FacebookCallback<Sharer.Result> facebookCallback = dVar.g;
        if (facebookCallback != null) {
            if (facebookException != null) {
                ShareInternalUtility.e("error", facebookException.getMessage());
                facebookCallback.onError(facebookException);
            } else if (dVar.n) {
                ShareInternalUtility.b(facebookCallback);
            } else {
                ShareInternalUtility.d(facebookCallback, str);
            }
        }
        if (dVar.h != null) {
            if (graphResponse != null) {
                try {
                    if (graphResponse.getJSONObject() != null) {
                        graphResponse.getJSONObject().put("video_id", str);
                    }
                } catch (JSONException unused) {
                }
            }
            dVar.h.onCompleted(graphResponse);
        }
    }
}
