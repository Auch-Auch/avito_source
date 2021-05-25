package a2.a.a.e2.t;

import com.avito.android.publish.drafts.PublishDraftRepositoryImpl;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<PhotoParameter, Completable> {
    public final /* synthetic */ PublishDraftRepositoryImpl.g a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(PublishDraftRepositoryImpl.g gVar) {
        super(1);
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Completable invoke(PhotoParameter photoParameter) {
        PhotoParameter photoParameter2 = photoParameter;
        Intrinsics.checkNotNullParameter(photoParameter2, "photoParameter");
        Completable flatMapCompletable = Single.just(photoParameter2).observeOn(this.a.a.a).flatMapCompletable(new b(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.just(photoParamet… syncPhotoParameter(it) }");
        return flatMapCompletable;
    }
}
