package a2.a.a.m2;

import com.avito.android.select.SelectDialogPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<String> {
    public final /* synthetic */ SelectDialogPresenterImpl a;

    public g(SelectDialogPresenterImpl selectDialogPresenterImpl) {
        this.a = selectDialogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        SelectDialogPresenterImpl selectDialogPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "text");
        selectDialogPresenterImpl.c = str2;
        this.a.a();
    }
}
