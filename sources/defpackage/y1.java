package defpackage;

import com.avito.android.remote.model.Action;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: y1  reason: default package */
public final class y1<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public y1(int i, Object obj, Object obj2, Object obj3) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            MyAdvertDetailsPresenterImpl.access$handleActionFromActivationInfo((MyAdvertDetailsPresenterImpl) this.c, ((Action) this.b).getDeepLink());
        } else if (i == 1) {
            MyAdvertDetailsPresenterImpl.access$handleActionFromActivationInfo((MyAdvertDetailsPresenterImpl) this.c, ((Action) this.b).getDeepLink());
        } else {
            throw null;
        }
    }
}
