package a2.a.a.i3.b;

import androidx.lifecycle.Observer;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.util.Views;
public final class a<T> implements Observer<ProfileItemsSearchViewModel.ItemsState> {
    public final /* synthetic */ ProfileItemsSearchFragment a;

    public a(ProfileItemsSearchFragment profileItemsSearchFragment) {
        this.a = profileItemsSearchFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ProfileItemsSearchViewModel.ItemsState itemsState) {
        ProfileItemsSearchViewModel.ItemsState itemsState2 = itemsState;
        if (itemsState2 instanceof ProfileItemsSearchViewModel.ItemsState.Loaded) {
            ProfileItemsSearchViewModel.ItemsState.Loaded loaded = (ProfileItemsSearchViewModel.ItemsState.Loaded) itemsState2;
            ProfileItemsSearchFragment.access$updateAdvertItems(this.a, loaded.getDataSource(), loaded.getSpaceIndices());
        } else if (itemsState2 instanceof ProfileItemsSearchViewModel.ItemsState.Loading) {
            Views.hide(ProfileItemsSearchFragment.access$getEmptyQuery$p(this.a));
            ProfileItemsSearchFragment.access$getAdvertsView$p(this.a).showProgress();
        } else if (itemsState2 instanceof ProfileItemsSearchViewModel.ItemsState.Error) {
            ProfileItemsSearchFragment.access$getAdvertsView$p(this.a).showError();
        } else if (itemsState2 instanceof ProfileItemsSearchViewModel.ItemsState.LoadedEmpty) {
            ProfileItemsSearchFragment.access$renderEmptyResult(this.a, ((ProfileItemsSearchViewModel.ItemsState.LoadedEmpty) itemsState2).getQuery());
        }
    }
}
