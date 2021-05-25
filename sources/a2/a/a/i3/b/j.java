package a2.a.a.i3.b;

import android.view.View;
import com.avito.android.user_adverts.items_search.SearchBarImpl;
public final class j implements View.OnFocusChangeListener {
    public final /* synthetic */ SearchBarImpl a;

    public j(SearchBarImpl searchBarImpl) {
        this.a = searchBarImpl;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            SearchBarImpl.access$openSearch(this.a);
        } else {
            this.a.a();
        }
    }
}
