package a2.a.a.t1.b;

import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;
public final class c<T1, T2> implements BiPredicate<PhoneInputItem, PhoneInputItem> {
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiPredicate
    public boolean test(PhoneInputItem phoneInputItem, PhoneInputItem phoneInputItem2) {
        PhoneInputItem phoneInputItem3 = phoneInputItem;
        PhoneInputItem phoneInputItem4 = phoneInputItem2;
        Intrinsics.checkNotNullParameter(phoneInputItem3, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(phoneInputItem4, AuthSource.BOOKING_ORDER);
        return Intrinsics.areEqual(phoneInputItem3.getValue(), phoneInputItem4.getValue());
    }
}
