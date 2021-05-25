package a2.a.a.k2.b.g;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.search.map.middleware.NavigationMiddlewareImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class s extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ NavigationMiddlewareImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ContactSource c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(NavigationMiddlewareImpl navigationMiddlewareImpl, String str, ContactSource contactSource) {
        super(1);
        this.a = navigationMiddlewareImpl;
        this.b = str;
        this.c = contactSource;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "link");
        NavigationMiddlewareImpl.access$onContactActionClicked(this.a, this.b, deepLink2, this.c);
        return Unit.INSTANCE;
    }
}
