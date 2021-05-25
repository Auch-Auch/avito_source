package a2.a.a.e2;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.OptionKt;
import arrow.core.Some;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Option<? extends LocalDraft>, PublishParametersInteractor.Data> {
    public final /* synthetic */ CategoryParameters a;

    public d(CategoryParameters categoryParameters) {
        this.a = categoryParameters;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PublishParametersInteractor.Data apply(Option<? extends LocalDraft> option) {
        Option option2;
        Option<? extends LocalDraft> option3 = option;
        Intrinsics.checkNotNullParameter(option3, "it");
        if (option3 instanceof None) {
            option2 = None.INSTANCE;
        } else if (option3 instanceof Some) {
            option2 = new Some(new PublishParametersInteractor.Data(this.a, ((LocalDraft) ((Some) option3).getT()).getState()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (PublishParametersInteractor.Data) OptionKt.getOrElse(option2, new c(this));
    }
}
