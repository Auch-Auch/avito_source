package a2.a.a.e2.b0;

import androidx.lifecycle.Observer;
import com.avito.android.publish.R;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonItem;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Observer<ResidentialComplexButtonItem> {
    public final /* synthetic */ ResidentialComplexActivity a;

    public b(ResidentialComplexActivity residentialComplexActivity) {
        this.a = residentialComplexActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(ResidentialComplexButtonItem residentialComplexButtonItem) {
        ResidentialComplexActivity residentialComplexActivity = this.a;
        String string = residentialComplexActivity.getResources().getString(R.string.not_in_list);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.not_in_list)");
        ResidentialComplexActivity.access$setResultAndFinish(residentialComplexActivity, 0, string);
    }
}
