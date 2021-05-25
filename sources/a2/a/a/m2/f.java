package a2.a.a.m2;

import com.avito.android.select.SelectDialogView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Boolean> {
    public final /* synthetic */ SelectDialogView a;

    public f(SelectDialogView selectDialogView) {
        this.a = selectDialogView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        SelectDialogView selectDialogView = this.a;
        Intrinsics.checkNotNullExpressionValue(bool2, "isSearchActive");
        selectDialogView.setExitSearchButtonVisibility(bool2.booleanValue());
    }
}
