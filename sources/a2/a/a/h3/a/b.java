package a2.a.a.h3.a;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(1);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        c cVar = this.a;
        MyAdvertDetailsPresenterImpl.access$handleVasAction(cVar.a, cVar.b.getDeepLink(), str2);
        return Unit.INSTANCE;
    }
}
