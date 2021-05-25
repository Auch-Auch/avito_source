package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.voximplant.sdk.call.IAudioStream;
import com.voximplant.sdk.call.IEndpoint;
import com.voximplant.sdk.call.IEndpointListener;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.EndpointCallbackController;
import com.voximplant.sdk.internal.callbacks.OnEndpointInfoUpdated;
import com.voximplant.sdk.internal.callbacks.OnEndpointRemoved;
import com.voximplant.sdk.internal.callbacks.OnRemoteVideoStreamRemoved;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class a2 implements IEndpoint {
    public String a;
    public b2 b = new b2();
    public int c = 0;
    public boolean d = false;
    public EndpointCallbackController e = new EndpointCallbackController();
    public ConcurrentHashMap<String, h2> f = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, r1> g = new ConcurrentHashMap<>();

    public a2(String str, int i) {
        this.a = str;
        this.c = i;
    }

    public final String a() {
        return a.t(a.L("Endpoint ["), this.a, "] ");
    }

    public void b(boolean z) {
        Logger.i(a() + ProductAction.ACTION_REMOVE);
        for (Map.Entry<String, h2> entry : this.f.entrySet()) {
            h2 remove = this.f.remove(entry.getKey());
            if (remove != null) {
                remove.b();
                if (z) {
                    this.e.addEndpointCallbackToQueue(new OnRemoteVideoStreamRemoved(this, remove));
                }
            }
        }
        this.g.clear();
        if (z) {
            this.e.addEndpointCallbackToQueue(new OnEndpointRemoved(this));
        }
    }

    public void c(String str, String str2) {
        Logger.i(a() + "setUserInfo: mDisplayName: " + str + ", sip uri: " + str2);
        this.b.f(str);
        this.b.g(str2);
        if (this.d) {
            this.e.addEndpointCallbackToQueue(new OnEndpointInfoUpdated(this));
        }
    }

    public void d(b2 b2Var) {
        Logger.i(a() + "updateUserInfo: " + b2Var);
        this.b = b2Var;
        this.e.addEndpointCallbackToQueue(new OnEndpointInfoUpdated(this));
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public List<IAudioStream> getAudioStreams() {
        return new ArrayList(this.g.values());
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public String getEndpointId() {
        return this.a;
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public int getPlace() {
        b2 b2Var = this.b;
        if (b2Var != null) {
            return b2Var.c();
        }
        return 0;
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public String getSipUri() {
        b2 b2Var = this.b;
        if (b2Var != null) {
            return b2Var.d();
        }
        return null;
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public String getUserDisplayName() {
        b2 b2Var = this.b;
        if (b2Var != null) {
            return b2Var.a();
        }
        return null;
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public String getUserName() {
        b2 b2Var = this.b;
        if (b2Var != null) {
            return b2Var.e();
        }
        return null;
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public List<IVideoStream> getVideoStreams() {
        return new ArrayList(this.f.values());
    }

    @Override // com.voximplant.sdk.call.IEndpoint
    public void setEndpointListener(IEndpointListener iEndpointListener) {
        Logger.i(a() + "setEndpointListener: " + iEndpointListener);
        this.e.setEndpointListener(iEndpointListener);
    }

    public String toString() {
        return a.t(a.L("Endpoint["), this.a, "]");
    }

    public a2(b2 b2Var, int i) {
        this.a = b2Var.b();
        this.b = b2Var;
        this.c = i;
    }
}
