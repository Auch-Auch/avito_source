package a2.g.p.e;

import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.PriorityNetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
public class h implements NetworkFetcher.Callback {
    public final /* synthetic */ PriorityNetworkFetcher.PriorityFetchState a;
    public final /* synthetic */ PriorityNetworkFetcher b;

    public h(PriorityNetworkFetcher priorityNetworkFetcher, PriorityNetworkFetcher.PriorityFetchState priorityFetchState) {
        this.b = priorityNetworkFetcher;
        this.a = priorityFetchState;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
    public void onCancellation() {
        this.b.c(this.a, "CANCEL");
        this.a.i.onCancellation();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
    public void onFailure(Throwable th) {
        this.b.c(this.a, "FAIL");
        this.a.i.onFailure(th);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
    public void onResponse(InputStream inputStream, int i) throws IOException {
        this.a.i.onResponse(inputStream, i);
    }
}
