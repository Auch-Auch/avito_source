package defpackage;

import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogRouter;
import com.avito.android.select.SelectDialogView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
/* compiled from: java-style lambda group */
/* renamed from: d0  reason: default package */
public final class d0<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public d0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((SelectDialogPresenterImpl) this.b).e.clear();
            ((SelectDialogPresenterImpl) this.b).b();
            SelectDialogPresenterImpl.access$showVariants((SelectDialogPresenterImpl) this.b);
        } else if (i == 1) {
            ((SelectDialogView) this.b).clearSearchTextAndHideKeyboard();
        } else if (i == 2) {
            SelectDialogRouter selectDialogRouter = ((SelectDialogPresenterImpl) this.b).b;
            if (selectDialogRouter != null) {
                SelectDialogRouter.DefaultImpls.onSelected$default(selectDialogRouter, CollectionsKt___CollectionsKt.toList(((SelectDialogPresenterImpl) this.b).e), null, 2, null);
            }
        } else {
            throw null;
        }
    }
}
