package a2.a.a.x1;

import com.avito.android.photo_picker.SelectedPhoto;
import com.avito.android.photo_picker.legacy.PhotoSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<SelectedPhoto, Boolean> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(SelectedPhoto selectedPhoto) {
        SelectedPhoto selectedPhoto2 = selectedPhoto;
        Intrinsics.checkNotNullParameter(selectedPhoto2, "it");
        return Boolean.valueOf(selectedPhoto2.getSource() == PhotoSource.CAMERA_TEMP);
    }
}
