package a2.a.a.k0.e;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class b0<T> implements Consumer<Throwable> {
    public static final b0 a = new b0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(ScreenPublicConstsKt.DELIVERY_RDS_SUMMARY_NAME, th);
    }
}
