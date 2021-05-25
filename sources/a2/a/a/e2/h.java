package a2.a.a.e2;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishParametersInteractorImpl;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.remote.model.Draft;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<Option<? extends LocalDraft>, SingleSource<? extends PublishParametersInteractor.Data>> {
    public final /* synthetic */ Draft a;
    public final /* synthetic */ PublishParametersInteractorImpl.j b;
    public final /* synthetic */ PublishParametersInteractor.Data c;

    public h(Draft draft, PublishParametersInteractorImpl.j jVar, PublishParametersInteractor.Data data) {
        this.a = draft;
        this.b = jVar;
        this.c = data;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: io.reactivex.Completable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends PublishParametersInteractor.Data> apply(Option<? extends LocalDraft> option) {
        Option<? extends LocalDraft> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "optionalLocalDraft");
        return PublishParametersInteractorImpl.access$mergeRemoteDraft(this.b.a, this.a, (LocalDraft) OptionKt.getOrElse(option2, i.a), this.c.getCategoryParameters()).toSingleDefault(this.c);
    }
}
