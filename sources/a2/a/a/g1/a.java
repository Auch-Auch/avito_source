package a2.a.a.g1;

import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.Header;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.Result;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class a<T> implements Consumer<InlineFilters> {
    public final /* synthetic */ InlineFiltersPresenterImpl a;

    public a(InlineFiltersPresenterImpl inlineFiltersPresenterImpl) {
        this.a = inlineFiltersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(InlineFilters inlineFilters) {
        Header header;
        InlineFilters inlineFilters2 = inlineFilters;
        boolean z = false;
        this.a.c = false;
        this.a.t.trackShortcutsLoaded();
        this.a.setInlineFilters(inlineFilters2);
        Result result = inlineFilters2.getResult();
        List<Filter> list = null;
        String title = (result == null || (header = result.getHeader()) == null) ? null : header.getTitle();
        if (title == null || title.length() == 0) {
            Result result2 = inlineFilters2.getResult();
            if (result2 != null) {
                list = result2.getFilters();
            }
            if (list == null || list.isEmpty()) {
                z = true;
            }
        }
        this.a.i.accept(Boolean.valueOf(!z));
    }
}
