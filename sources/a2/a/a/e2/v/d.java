package a2.a.a.e2.v;

import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<PublishParametersInteractor.Data, a> {
    public final /* synthetic */ InfomodelRequestViewModel a;

    public d(InfomodelRequestViewModel infomodelRequestViewModel) {
        this.a = infomodelRequestViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public a apply(PublishParametersInteractor.Data data) {
        PublishParametersInteractor.Data data2 = data;
        Intrinsics.checkNotNullParameter(data2, "it");
        return InfomodelRequestViewModel.access$toParametersWithState(this.a, data2);
    }
}
