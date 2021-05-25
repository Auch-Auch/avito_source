package a2.a.a.e2.v;

import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.infomodel_request.InfomodelRequestViewModel;
import com.avito.android.remote.model.Navigation;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Navigation, SingleSource<? extends PublishParametersInteractor.Data>> {
    public final /* synthetic */ InfomodelRequestViewModel a;
    public final /* synthetic */ String b;

    public g(InfomodelRequestViewModel infomodelRequestViewModel, String str) {
        this.a = infomodelRequestViewModel;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends PublishParametersInteractor.Data> apply(Navigation navigation) {
        Navigation navigation2 = navigation;
        Intrinsics.checkNotNullParameter(navigation2, "navigation");
        return this.a.h.loadSubmissionDataForEdit(navigation2, this.b, InfomodelRequestViewModel.access$getPublishViewModel$p(this.a).getStepId());
    }
}
