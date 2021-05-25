package a2.a.a.e2.c0;

import com.avito.android.publish.select.SelectViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<String> {
    public final /* synthetic */ SelectViewModel a;

    public e(SelectViewModel selectViewModel) {
        this.a = selectViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        SelectViewModel selectViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        SelectViewModel.access$onItemClick(selectViewModel, str2);
    }
}
