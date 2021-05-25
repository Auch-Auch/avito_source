package a2.a.a.x1.q;

import com.avito.android.photo.BitmapConversionResult;
import com.avito.android.photo_picker.legacy.SingleCachePhotoInteractor;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<BitmapConversionResult> {
    public final /* synthetic */ SingleCachePhotoInteractor a;

    public j(SingleCachePhotoInteractor singleCachePhotoInteractor) {
        this.a = singleCachePhotoInteractor;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(BitmapConversionResult bitmapConversionResult) {
        BitmapConversionResult bitmapConversionResult2 = bitmapConversionResult;
        SingleCachePhotoInteractor.access$copyExifData(this.a, bitmapConversionResult2.getOriginalExifData(), bitmapConversionResult2.getFile());
    }
}
