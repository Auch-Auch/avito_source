package a2.a.a.x1.q;

import android.net.Uri;
import com.avito.android.photo_picker.legacy.PickerPhoto;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class l<T, R> implements Function<Uri, PickerPhoto> {
    public final /* synthetic */ PickerPhoto a;

    public l(PickerPhoto pickerPhoto) {
        this.a = pickerPhoto;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PickerPhoto apply(Uri uri) {
        Uri uri2 = uri;
        Intrinsics.checkNotNullParameter(uri2, "it");
        return PickerPhoto.copy$default(this.a, null, null, 0, 0, uri2, null, null, 111, null);
    }
}
