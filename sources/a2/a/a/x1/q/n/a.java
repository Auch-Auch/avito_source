package a2.a.a.x1.q.n;

import com.avito.android.photo_picker.legacy.service.ImageUploadService;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<ImageUploadServiceDelegate.UploadingEvent> {
    public final /* synthetic */ ImageUploadService a;

    public a(ImageUploadService imageUploadService) {
        this.a = imageUploadService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ImageUploadServiceDelegate.UploadingEvent uploadingEvent) {
        ImageUploadService.access$processEvent(this.a, uploadingEvent);
    }
}
