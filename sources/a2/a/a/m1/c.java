package a2.a.a.m1;

import com.avito.android.location_list.LocationListPresenterImpl;
import com.avito.android.remote.model.Location;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<LoadingState<? super Location>> {
    public final /* synthetic */ LocationListPresenterImpl a;

    public c(LocationListPresenterImpl locationListPresenterImpl) {
        this.a = locationListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Location> loadingState) {
        LoadingState<? super Location> loadingState2 = loadingState;
        LocationListPresenterImpl locationListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        LocationListPresenterImpl.access$onNearestChanged(locationListPresenterImpl, loadingState2);
    }
}
