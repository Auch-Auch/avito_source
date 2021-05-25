package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.legacy.service.ImageUploadService;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ ImageUploadService a;

    public b(ImageUploadService imageUploadService) {
        this.a = imageUploadService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        ImageUploadService.access$onError(this.a, th);
    }
}
