package a2.a.a.x1.q;

import com.avito.android.photo_picker.legacy.PhotoPickerPresenterImpl;
import com.avito.android.util.Rotation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<Rotation, Unit> {
    public final /* synthetic */ PhotoPickerPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(PhotoPickerPresenterImpl photoPickerPresenterImpl) {
        super(1);
        this.a = photoPickerPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Rotation rotation) {
        Rotation rotation2 = rotation;
        PhotoPickerPresenterImpl photoPickerPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(rotation2, "rotation");
        PhotoPickerPresenterImpl.access$handleRotation(photoPickerPresenterImpl, rotation2);
        return Unit.INSTANCE;
    }
}
