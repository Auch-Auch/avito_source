package a2.a.a.o1.e.c;

import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.rxjava3.functions.Function;
public final class b<T, R> implements Function<MessageBody.Location, SharingMapView.State> {
    public final /* synthetic */ SharingMapPresenterImpl.d a;
    public final /* synthetic */ SharingMapView.State b;

    public b(SharingMapPresenterImpl.d dVar, SharingMapView.State state) {
        this.a = dVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SharingMapView.State apply(MessageBody.Location location) {
        MessageBody.Location location2 = location;
        return new SharingMapView.State.Static.Loaded(new MessageBody.Location(this.a.c.getMapPoint().getLatitude(), this.a.c.getMapPoint().getLongitude(), location2.getTitle(), location2.getKind(), null, 16, null), new SharingMapView.CameraState(this.a.c.getMapPoint().getLatitude(), this.a.c.getMapPoint().getLongitude(), this.a.c.getZoomLevel()), this.b.getUserPoint(), location2.getTitle(), false, this.a.b);
    }
}
