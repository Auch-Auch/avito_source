package a2.a.a.o1.e.c;

import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, SharingMapView.State> {
    public final /* synthetic */ SharingMapPresenterImpl.d a;
    public final /* synthetic */ SharingMapView.State b;

    public d(SharingMapPresenterImpl.d dVar, SharingMapView.State state) {
        this.a = dVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SharingMapView.State apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return new SharingMapView.State.Static.Error(new MessageBody.Location(this.a.c.getMapPoint().getLatitude(), this.a.c.getMapPoint().getLongitude(), this.a.a.s, null, null, 24, null), new SharingMapView.CameraState(this.a.c.getMapPoint().getLatitude(), this.a.c.getMapPoint().getLongitude(), this.a.c.getZoomLevel()), this.b.getUserPoint(), new ConnectionErrorIndicatorView.State.Shown.Error(this.a.a.t, this.a.a.u, new c(this)), this.b.getBottomSheetTitle(), false, this.a.b);
    }
}
