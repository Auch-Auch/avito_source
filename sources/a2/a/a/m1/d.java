package a2.a.a.m1;

import com.avito.android.location_list.LocationListPresenterImpl;
import com.avito.android.remote.model.Location;
import com.avito.android.util.LoadingState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<LoadingState<? super List<? extends Location>>, Unit> {
    public final /* synthetic */ LocationListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(LocationListPresenterImpl locationListPresenterImpl) {
        super(1);
        this.a = locationListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super List<? extends Location>> loadingState) {
        LoadingState<? super List<? extends Location>> loadingState2 = loadingState;
        LocationListPresenterImpl locationListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        LocationListPresenterImpl.access$onLocationsChanged(locationListPresenterImpl, loadingState2, this.a.b());
        return Unit.INSTANCE;
    }
}
