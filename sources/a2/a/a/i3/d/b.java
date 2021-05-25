package a2.a.a.i3.d;

import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenterImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadMoreAction;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<UserAdvertItemAction> {
    public final /* synthetic */ UserAdvertsListPresenterImpl a;

    public b(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
        this.a = userAdvertsListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(UserAdvertItemAction userAdvertItemAction) {
        if ((userAdvertItemAction instanceof LoadMoreAction) && !(this.a.c)) {
            this.a.a(false);
        }
    }
}
