package a2.a.a.i3.b;

import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelImpl;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
public final class e<T> implements Consumer<Pair<? extends List<? extends SpannedItem>, ? extends List<? extends Integer>>> {
    public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

    public e(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
        this.a = profileItemsSearchViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Pair<? extends List<? extends SpannedItem>, ? extends List<? extends Integer>> pair) {
        Pair<? extends List<? extends SpannedItem>, ? extends List<? extends Integer>> pair2 = pair;
        this.a.c.setValue(new ProfileItemsSearchViewModel.ItemsState.Loaded(new ListDataSource((List) pair2.getFirst()), (List) pair2.getSecond()));
    }
}
