package a2.a.a.k2.a;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.search.filter.FiltersInteractorImpl;
import java.util.Map;
import java.util.concurrent.Callable;
import t6.n.r;
public final class e<V> implements Callable<Map<String, ? extends String>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public e(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Map<String, ? extends String> call() {
        Map<String, ? extends String> plus;
        SearchParams searchParamsOrEmpty = this.a.getSearchParamsOrEmpty();
        searchParamsOrEmpty.setExpanded(this.a.f());
        searchParamsOrEmpty.setSellerId(this.a.b());
        searchParamsOrEmpty.setShopId(this.a.c());
        Map<String, ? extends String> convertToMap$default = SearchParamsConverter.DefaultImpls.convertToMap$default(this.a.u, searchParamsOrEmpty, null, false, false, 14, null);
        Area area = this.a.r;
        return (area == null || (plus = r.plus(convertToMap$default, AreaKt.toMap(area))) == null) ? convertToMap$default : plus;
    }
}
