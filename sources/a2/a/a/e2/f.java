package a2.a.a.e2;

import com.avito.android.publish.PublishParametersInteractorImpl;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<CategoryParameters, CategoryParameters> {
    public final /* synthetic */ PublishParametersInteractorImpl a;
    public final /* synthetic */ CategoryParameters b;

    public f(PublishParametersInteractorImpl publishParametersInteractorImpl, CategoryParameters categoryParameters) {
        this.a = publishParametersInteractorImpl;
        this.b = categoryParameters;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CategoryParameters apply(CategoryParameters categoryParameters) {
        CategoryParameters categoryParameters2 = categoryParameters;
        Intrinsics.checkNotNullParameter(categoryParameters2, "it");
        PublishParametersInteractorImpl publishParametersInteractorImpl = this.a;
        CategoryParameters categoryParameters3 = this.b;
        return PublishParametersInteractorImpl.access$patchPhotoParameter(publishParametersInteractorImpl, categoryParameters2, categoryParameters3 != null ? (PhotoParameter) ((CategoryParameter) categoryParameters3.getFirstParameterOfType(PhotoParameter.class)) : null);
    }
}
