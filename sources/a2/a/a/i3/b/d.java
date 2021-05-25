package a2.a.a.i3.b;

import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelImpl;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<List<? extends SpannedItem>, Pair<? extends List<? extends SpannedItem>, ? extends List<? extends Integer>>> {
    public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

    public d(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
        this.a = profileItemsSearchViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends List<? extends SpannedItem>, ? extends List<? extends Integer>> apply(List<? extends SpannedItem> list) {
        List<? extends SpannedItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return ProfileItemsSearchViewModelImpl.access$separateSpaceIndices(this.a, list2);
    }
}
