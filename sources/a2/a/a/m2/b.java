package a2.a.a.m2;

import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.SelectDialogView;
import com.avito.android.select.bottom_sheet.HeightFixableView;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class b<T> implements Consumer<List<? extends ParcelableEntity<String>>> {
    public final /* synthetic */ SelectDialogPresenterImpl a;

    public b(SelectDialogPresenterImpl selectDialogPresenterImpl) {
        this.a = selectDialogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends ParcelableEntity<String>> list) {
        this.a.d = list;
        SelectDialogPresenterImpl.access$showVariants(this.a);
        SelectDialogView selectDialogView = this.a.a;
        if (!(selectDialogView instanceof HeightFixableView)) {
            selectDialogView = null;
        }
        HeightFixableView heightFixableView = (HeightFixableView) selectDialogView;
        if (heightFixableView != null) {
            heightFixableView.fixViewHeight();
        }
        if (this.a.c.length() > 0) {
            this.a.a();
        }
    }
}
