package a2.a.a.e2.r;

import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class q<T, R> implements Function<PhotoParameter, ObservableSource<? extends PhotoUploadObserver.UploadStatus>> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public q(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PhotoUploadObserver.UploadStatus> apply(PhotoParameter photoParameter) {
        Intrinsics.checkNotNullParameter(photoParameter, "it");
        return PhotoUploadObserver.DefaultImpls.startObserve$default(this.a.F, this.a, false, 2, null);
    }
}
