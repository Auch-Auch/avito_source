package com.avito.android.user_adverts.items_search.advert_list;

import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SpannedItem;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "", "", "totalCount", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "Lio/reactivex/Observable;", "Lcom/avito/android/serp/adapter/SpannedItem;", "convert", "(ILjava/util/List;)Lio/reactivex/Observable;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface UserSearchItemConverter {
    @NotNull
    Observable<List<SpannedItem>> convert(int i, @NotNull List<? extends SerpElement> list);
}
