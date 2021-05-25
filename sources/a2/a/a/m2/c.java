package a2.a.a.m2;

import com.avito.android.select.SelectDialogPresenterImpl;
import com.avito.android.select.VariantItem;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<VariantItem> {
    public final /* synthetic */ SelectDialogPresenterImpl a;

    public c(SelectDialogPresenterImpl selectDialogPresenterImpl) {
        this.a = selectDialogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(VariantItem variantItem) {
        VariantItem variantItem2 = variantItem;
        SelectDialogPresenterImpl selectDialogPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(variantItem2, "item");
        selectDialogPresenterImpl.onItemClicked(variantItem2);
    }
}
