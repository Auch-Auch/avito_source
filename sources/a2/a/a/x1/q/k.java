package a2.a.a.x1.q;

import android.net.Uri;
import com.avito.android.photo.BitmapConversionResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<BitmapConversionResult, Uri> {
    public static final k a = new k();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Uri apply(BitmapConversionResult bitmapConversionResult) {
        BitmapConversionResult bitmapConversionResult2 = bitmapConversionResult;
        Intrinsics.checkNotNullParameter(bitmapConversionResult2, "it");
        return Uri.fromFile(bitmapConversionResult2.getFile());
    }
}
