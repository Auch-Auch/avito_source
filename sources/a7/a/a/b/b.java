package a7.a.a.b;

import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.collapsing_appbar.CollapsingAppBar;
public final class b<T, R> implements Function<ViewLayoutChangeEvent, Integer> {
    public final /* synthetic */ CollapsingAppBar a;

    public b(CollapsingAppBar collapsingAppBar) {
        this.a = collapsingAppBar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Integer apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
        Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
        return Integer.valueOf(CollapsingAppBar.access$newWidth(this.a, viewLayoutChangeEvent2));
    }
}
