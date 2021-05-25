package a2.a.a.x1.q;

import com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl;
import com.avito.android.photo_picker.legacy.PickerPhoto;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<List<? extends PickerPhoto>, Unit> {
    public final /* synthetic */ PhotoPickerPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        super(1);
        this.a = photoPickerPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends PickerPhoto> list) {
        List<? extends PickerPhoto> list2 = list;
        PhotoPickerPresenterImpl photoPickerPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "photos");
        PhotoPickerPresenterImpl.access$initialDataLoaded(photoPickerPresenterImpl, list2);
        PhotoPickerPresenterImpl.access$continuePhotoProcessing(this.a);
        return Unit.INSTANCE;
    }
}
