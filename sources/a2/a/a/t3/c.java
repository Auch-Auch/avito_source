package a2.a.a.t3;

import com.avito.android.viewed_items.ViewedItemsCountInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Integer> {
    public final /* synthetic */ ViewedItemsCountInteractorImpl a;

    public c(ViewedItemsCountInteractorImpl viewedItemsCountInteractorImpl) {
        this.a = viewedItemsCountInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay3.BehaviorRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        this.a.a.accept(num);
    }
}
