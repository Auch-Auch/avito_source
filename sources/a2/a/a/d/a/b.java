package a2.a.a.d.a;

import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import com.avito.android.abuse.details.AbuseDetailsView;
import com.avito.android.abuse.details.adapter.AbuseField;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<List<? extends AbuseField>> {
    public final /* synthetic */ AbuseDetailsPresenterImpl a;

    public b(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        this.a = abuseDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends AbuseField> list) {
        List<? extends AbuseField> list2 = list;
        AbuseDetailsPresenterImpl abuseDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        AbuseDetailsPresenterImpl.access$showFields(abuseDetailsPresenterImpl, list2);
        this.a.f = true;
        AbuseDetailsView abuseDetailsView = this.a.b;
        if (abuseDetailsView != null) {
            this.a.b(abuseDetailsView);
        }
    }
}
