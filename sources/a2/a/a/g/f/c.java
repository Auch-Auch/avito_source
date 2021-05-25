package a2.a.a.g.f;

import android.net.Uri;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d a;
    public final /* synthetic */ LoadingState b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, LoadingState loadingState) {
        super(0);
        this.a = dVar;
        this.b = loadingState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Uri uri = ((AdvertDeliverySwitchResponse) ((LoadingState.Loaded) this.b).getData()).getUri();
        if (uri != null) {
            this.a.a.e.followUri(uri);
        }
        return Unit.INSTANCE;
    }
}
