package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;
public final class f<T1, T2> implements BiPredicate<TopUpInputItem, TopUpInputItem> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiPredicate
    public boolean test(TopUpInputItem topUpInputItem, TopUpInputItem topUpInputItem2) {
        TopUpInputItem topUpInputItem3 = topUpInputItem;
        TopUpInputItem topUpInputItem4 = topUpInputItem2;
        Intrinsics.checkNotNullParameter(topUpInputItem3, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(topUpInputItem4, AuthSource.BOOKING_ORDER);
        return Intrinsics.areEqual(topUpInputItem3.getValue(), topUpInputItem4.getValue());
    }
}
