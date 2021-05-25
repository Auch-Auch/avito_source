package a2.a.a.x1.q.m;

import com.avito.android.photo_picker.legacy.details_list.EditorItemPresenterImpl;
import com.avito.android.util.Rotation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function1<Rotation, Unit> {
    public final /* synthetic */ EditorItemPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(EditorItemPresenterImpl editorItemPresenterImpl) {
        super(1);
        this.a = editorItemPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Rotation rotation) {
        Rotation rotation2 = rotation;
        EditorItemPresenterImpl editorItemPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(rotation2, "it");
        EditorItemPresenterImpl.access$handleRotation(editorItemPresenterImpl, rotation2);
        return Unit.INSTANCE;
    }
}
