package a2.a.a.f0.a;

import com.avito.android.computer_vision.multiupload.MultiuploadComputerVisionInteractor;
import com.avito.android.remote.model.PublishSuggestsUploadPhotoResponse;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
public final class b<T, R> implements Function<MultipartBody.Part, ObservableSource<? extends PublishSuggestsUploadPhotoResponse>> {
    public final /* synthetic */ MultiuploadComputerVisionInteractor.f a;

    public b(MultiuploadComputerVisionInteractor.f fVar) {
        this.a = fVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PublishSuggestsUploadPhotoResponse> apply(MultipartBody.Part part) {
        MultipartBody.Part part2 = part;
        Intrinsics.checkNotNullParameter(part2, "imageMultipart");
        return TypedObservablesKt.toTyped(InteropKt.toV2(this.a.a.i.uploadPublishSuggestsPhoto(part2, this.a.b)));
    }
}
