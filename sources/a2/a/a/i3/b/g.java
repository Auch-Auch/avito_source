package a2.a.a.i3.b;

import android.view.KeyEvent;
import android.widget.TextView;
import com.avito.android.user_adverts.items_search.SearchBarImpl;
public final class g implements TextView.OnEditorActionListener {
    public final /* synthetic */ SearchBarImpl a;

    public g(SearchBarImpl searchBarImpl) {
        this.a = searchBarImpl;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        SearchBarImpl searchBarImpl = this.a;
        SearchBarImpl.access$initSearch(searchBarImpl, String.valueOf(searchBarImpl.a.m90getText()));
        return true;
    }
}
