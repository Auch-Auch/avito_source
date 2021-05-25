package a2.a.a.e2.t;

import com.avito.android.publish.drafts.PublishDraftRepositoryImpl;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<PhotoParameter, CompletableSource> {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(PhotoParameter photoParameter) {
        PhotoParameter photoParameter2 = photoParameter;
        Intrinsics.checkNotNullParameter(photoParameter2, "it");
        return PublishDraftRepositoryImpl.access$syncPhotoParameter(this.a.a.a, photoParameter2);
    }
}
