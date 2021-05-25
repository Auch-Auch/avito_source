package a2.a.a.o1.d.a0.k.a.f;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ ItemsListPresenterImpl.CloseComposite.CallCloseHandlerAction.a a;

    public b(ItemsListPresenterImpl.CloseComposite.CallCloseHandlerAction.a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.debug(ItemsListPresenterImpl.this.getTAG(), "Failed to close", th);
    }
}
