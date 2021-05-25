package a2.a.a.f0.a;

import com.avito.android.photo.BitmapConversionResult;
import com.avito.http.FileUtils;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
public final class a<T, R> implements Function<BitmapConversionResult, MultipartBody.Part> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultipartBody.Part apply(BitmapConversionResult bitmapConversionResult) {
        BitmapConversionResult bitmapConversionResult2 = bitmapConversionResult;
        Intrinsics.checkNotNullParameter(bitmapConversionResult2, "it");
        return FileUtils.convertToImageMultipart$default(bitmapConversionResult2.getFile(), null, null, 3, null);
    }
}
