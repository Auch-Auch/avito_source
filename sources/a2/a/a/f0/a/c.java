package a2.a.a.f0.a;

import android.net.Uri;
import com.avito.android.computer_vision.multiupload.MultiuploadComputerVisionInteractor;
import com.avito.android.remote.model.PublishSuggestsUploadPhotoResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public final class c<T, R> implements Function<PublishSuggestsUploadPhotoResponse, MultiuploadComputerVisionInteractor.a> {
    public final /* synthetic */ Uri a;

    public c(Uri uri) {
        this.a = uri;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultiuploadComputerVisionInteractor.a apply(PublishSuggestsUploadPhotoResponse publishSuggestsUploadPhotoResponse) {
        PublishSuggestsUploadPhotoResponse publishSuggestsUploadPhotoResponse2 = publishSuggestsUploadPhotoResponse;
        Intrinsics.checkNotNullParameter(publishSuggestsUploadPhotoResponse2, CommonKt.EXTRA_RESPONSE);
        Uri uri = this.a;
        Intrinsics.checkNotNullExpressionValue(uri, "uploadUri");
        return new MultiuploadComputerVisionInteractor.a(uri, null, publishSuggestsUploadPhotoResponse2.getId(), 2);
    }
}
