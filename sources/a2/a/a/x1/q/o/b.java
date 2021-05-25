package a2.a.a.x1.q.o;

import com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemPresenterImpl;
import com.avito.android.util.Rotation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<Rotation, Unit> {
    public final /* synthetic */ ThumbnailItemPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ThumbnailItemPresenterImpl thumbnailItemPresenterImpl) {
        super(1);
        this.a = thumbnailItemPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Rotation rotation) {
        Rotation rotation2 = rotation;
        ThumbnailItemPresenterImpl thumbnailItemPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(rotation2, "it");
        ThumbnailItemPresenterImpl.access$handleRotation(thumbnailItemPresenterImpl, rotation2);
        return Unit.INSTANCE;
    }
}
