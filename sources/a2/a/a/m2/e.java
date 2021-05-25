package a2.a.a.m2;

import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogRouter;
import com.avito.android.select.SelectDialogView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ SelectDialogPresenterImpl a;
    public final /* synthetic */ SelectDialogView b;

    public e(SelectDialogPresenterImpl selectDialogPresenterImpl, SelectDialogView selectDialogView) {
        this.a = selectDialogPresenterImpl;
        this.b = selectDialogView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        this.b.hideKeyboard();
        SelectDialogRouter selectDialogRouter = this.a.b;
        if (selectDialogRouter != null) {
            selectDialogRouter.onCancel();
        }
    }
}
