package a2.a.a.h3.a;

import com.avito.android.user_advert.event.OrderStatusClickEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(g gVar) {
        super(1);
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "it");
        this.a.a.C.track(new OrderStatusClickEvent(str2));
        return Unit.INSTANCE;
    }
}
