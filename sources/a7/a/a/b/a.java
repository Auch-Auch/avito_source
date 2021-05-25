package a7.a.a.b;

import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.collapsing_appbar.CollapsingAppBar;
public final class a<T> implements Predicate<ViewLayoutChangeEvent> {
    public final /* synthetic */ CollapsingAppBar a;

    public a(CollapsingAppBar collapsingAppBar) {
        this.a = collapsingAppBar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
        Intrinsics.checkNotNullParameter(viewLayoutChangeEvent2, "it");
        return CollapsingAppBar.access$oldWidth(this.a, viewLayoutChangeEvent2) != CollapsingAppBar.access$newWidth(this.a, viewLayoutChangeEvent2);
    }
}
