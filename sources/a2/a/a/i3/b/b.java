package a2.a.a.i3.b;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.SearchBar;
public final class b<T> implements Observer<ProfileItemsSearchViewModel.Suggests> {
    public final /* synthetic */ ProfileItemsSearchFragment a;

    public b(ProfileItemsSearchFragment profileItemsSearchFragment) {
        this.a = profileItemsSearchFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ProfileItemsSearchViewModel.Suggests suggests) {
        ProfileItemsSearchViewModel.Suggests suggests2 = suggests;
        SearchBar searchBar = this.a.k;
        if (searchBar != null) {
            searchBar.showSuggests(suggests2.getSuggests());
        }
    }
}
