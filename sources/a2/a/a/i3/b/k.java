package a2.a.a.i3.b;

import com.avito.android.user_adverts.items_search.SearchBarImpl;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Predicate<CharSequence> {
    public final /* synthetic */ SearchBarImpl a;

    public k(SearchBarImpl searchBarImpl) {
        this.a = searchBarImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "it");
        return this.a.a.isEditTextFocused();
    }
}
