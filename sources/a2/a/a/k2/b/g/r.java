package a2.a.a.k2.b.g;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.middleware.NavigationMiddlewareImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class r extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ AsyncPhoneItem a;
    public final /* synthetic */ ContactSource b;
    public final /* synthetic */ NavigationMiddlewareImpl.a c;
    public final /* synthetic */ MapAction d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(AsyncPhoneItem asyncPhoneItem, ContactSource contactSource, NavigationMiddlewareImpl.a aVar, MapAction mapAction, SearchMapState searchMapState) {
        super(1);
        this.a = asyncPhoneItem;
        this.b = contactSource;
        this.c = aVar;
        this.d = mapAction;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "loadedLink");
        NavigationMiddlewareImpl.access$onContactActionClicked(this.c.a, this.a.getStringId(), deepLink2, this.b);
        return Unit.INSTANCE;
    }
}
