package a2.g.o.a;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import java.util.function.Consumer;
public class a implements Consumer<GraphResponse> {
    public final /* synthetic */ DaemonRequest a;

    public a(DaemonRequest daemonRequest) {
        this.a = daemonRequest;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.function.Consumer
    public void accept(GraphResponse graphResponse) {
        GraphResponse graphResponse2 = graphResponse;
        DaemonRequest.Callback callback = this.a.c;
        if (callback != null) {
            callback.onCompleted(graphResponse2);
        }
    }
}
