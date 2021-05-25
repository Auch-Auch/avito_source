package a2.a.a.x1.q.m;

import android.graphics.Bitmap;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.util.Dimension;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<byte[], ObservableSource<? extends Bitmap>> {
    public final /* synthetic */ CameraItemPresenterImpl a;
    public final /* synthetic */ Dimension b;

    public g(CameraItemPresenterImpl cameraItemPresenterImpl, Dimension dimension) {
        this.a = cameraItemPresenterImpl;
        this.b = dimension;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Bitmap> apply(byte[] bArr) {
        byte[] bArr2 = bArr;
        Intrinsics.checkNotNullParameter(bArr2, "it");
        return PhotoResizer.DefaultImpls.resize$default(this.a.C, bArr2, this.b, 0.0f, 4, null);
    }
}
