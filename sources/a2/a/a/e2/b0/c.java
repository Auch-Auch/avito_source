package a2.a.a.e2.b0;

import com.avito.android.publish.residential_complex_search.ResidentialComplexActivity;
import com.avito.android.util.Views;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ ResidentialComplexActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ResidentialComplexActivity residentialComplexActivity) {
        super(1);
        this.a = residentialComplexActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "searchValue");
        this.a.getViewModel().searchValueChanged(str2);
        Views.setVisible(ResidentialComplexActivity.access$getClear$p(this.a), str2.length() > 0);
        return Unit.INSTANCE;
    }
}
