package defpackage;

import com.avito.android.payment.webview.DialogState;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: q  reason: default package */
public final class q<T, R> implements Function<Unit, DialogState> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public q(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final DialogState apply(Unit unit) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return ((WebPaymentPresenterImpl) this.b).n.onCloseClicked((DialogState) this.c);
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return ((WebPaymentPresenterImpl) this.b).n.onCloseClicked((DialogState) this.c);
        } else {
            throw null;
        }
    }
}
