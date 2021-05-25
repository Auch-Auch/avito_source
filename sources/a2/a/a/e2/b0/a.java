package a2.a.a.e2.b0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestItem;
public final class a<T> implements Observer<ResidentialComplexSuggestItem> {
    public final /* synthetic */ ResidentialComplexActivity a;

    public a(ResidentialComplexActivity residentialComplexActivity) {
        this.a = residentialComplexActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ResidentialComplexSuggestItem residentialComplexSuggestItem) {
        ResidentialComplexSuggestItem residentialComplexSuggestItem2 = residentialComplexSuggestItem;
        ResidentialComplexActivity.access$setResultAndFinish(this.a, residentialComplexSuggestItem2.getResidentialComplexSuggest().getId(), residentialComplexSuggestItem2.getResidentialComplexSuggest().getName());
    }
}
