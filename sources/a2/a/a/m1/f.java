package a2.a.a.m1;

import com.avito.android.location_list.LocationListPresenterImpl;
import com.avito.android.remote.model.Location;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<LoadingState<? super Location>, Unit> {
    public final /* synthetic */ LocationListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(LocationListPresenterImpl locationListPresenterImpl) {
        super(1);
        this.a = locationListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super Location> loadingState) {
        LoadingState<? super Location> loadingState2 = loadingState;
        LocationListPresenterImpl locationListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        LocationListPresenterImpl.access$onTopLocationLoaded(locationListPresenterImpl, loadingState2);
        return Unit.INSTANCE;
    }
}
