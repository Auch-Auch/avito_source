package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import io.reactivex.rxjava3.functions.Predicate;
public final class p<T> implements Predicate<ExtraLoadingListItems> {
    public static final p a = new p();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(ExtraLoadingListItems extraLoadingListItems) {
        return !extraLoadingListItems.isLoaded();
    }
}
