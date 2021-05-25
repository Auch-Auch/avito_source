package a2.a.a.e2;

import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishParametersInteractorImpl;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<CategoryParameters, SingleSource<? extends PublishParametersInteractor.Data>> {
    public final /* synthetic */ PublishParametersInteractorImpl a;
    public final /* synthetic */ boolean b;

    public g(PublishParametersInteractorImpl publishParametersInteractorImpl, boolean z) {
        this.a = publishParametersInteractorImpl;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends PublishParametersInteractor.Data> apply(CategoryParameters categoryParameters) {
        CategoryParameters categoryParameters2 = categoryParameters;
        Intrinsics.checkNotNullParameter(categoryParameters2, "it");
        return this.b ? PublishParametersInteractorImpl.access$applyDraftValues(this.a, categoryParameters2) : PublishParametersInteractorImpl.access$toDataWithoutDraft(this.a, categoryParameters2);
    }
}
