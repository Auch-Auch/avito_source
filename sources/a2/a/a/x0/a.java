package a2.a.a.x0;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ GroupingAdvertsPresenterImpl a;
    public final /* synthetic */ AsyncPhoneItem b;
    public final /* synthetic */ ContactSource c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl, AsyncPhoneItem asyncPhoneItem, ContactSource contactSource) {
        super(1);
        this.a = groupingAdvertsPresenterImpl;
        this.b = asyncPhoneItem;
        this.c = contactSource;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "loadedLink");
        this.a.h(this.b.getStringId(), deepLink2, this.c);
        return Unit.INSTANCE;
    }
}
