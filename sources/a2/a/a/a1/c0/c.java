package a2.a.a.a1.c0;

import android.location.Location;
import com.avito.android.home.default_search_location.DefaultSearchLocationAnalyticsInteractor;
import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import com.avito.android.location.analytics.FindLocationPage;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Location> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public c(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Location location) {
        Location location2 = location;
        DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl = this.a;
        defaultSearchLocationPresenterImpl.i = defaultSearchLocationPresenterImpl.p.now() - this.a.i;
        boolean z = true;
        this.a.setSendingUserCoordinates(true);
        this.a.l.sendResolveCoordinates(location2, null);
        DefaultSearchLocationAnalyticsInteractor defaultSearchLocationAnalyticsInteractor = this.a.l;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        defaultSearchLocationAnalyticsInteractor.sendUserCoordinates(location2, Integer.valueOf((int) this.a.i), FindLocationPage.FIRST_LAUNCH.getValue());
        DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl2 = this.a;
        if (defaultSearchLocationPresenterImpl2.i >= ((long) 1000)) {
            z = false;
        }
        defaultSearchLocationPresenterImpl2.e = z;
    }
}
