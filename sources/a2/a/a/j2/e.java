package a2.a.a.j2;

import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SavedSearchesPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(SavedSearchesPresenterImpl savedSearchesPresenterImpl) {
        super(0);
        this.a = savedSearchesPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        SavedSearchView savedSearchView = this.a.a;
        if (savedSearchView != null) {
            savedSearchView.showSubscriptionMessage();
        }
        return Unit.INSTANCE;
    }
}
