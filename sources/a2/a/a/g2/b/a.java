package a2.a.a.g2.b;

import com.avito.android.photo_picker.PhotoUpload;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<PhotoUpload, CharSequence> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(PhotoUpload photoUpload) {
        PhotoUpload photoUpload2 = photoUpload;
        Intrinsics.checkNotNullParameter(photoUpload2, "elem");
        return String.valueOf(photoUpload2.getUploadId());
    }
}
