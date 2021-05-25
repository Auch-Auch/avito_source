package a2.a.a.h3.a;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.util.rx3.Disposables;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h0 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        super(1);
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        CompositeDisposable compositeDisposable = this.a.e;
        Disposable subscribe = this.a.i(str2).subscribe(f0.a, g0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "restoreAdvert(advertId)\n…e({}, { Logs.error(it) })");
        Disposables.plusAssign(compositeDisposable, subscribe);
        return Unit.INSTANCE;
    }
}
