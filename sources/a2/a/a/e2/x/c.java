package a2.a.a.e2.x;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<ParameterElement.Select> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    public c(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        this.a = objectsEditPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ParameterElement.Select select) {
        ParameterElement.Select select2 = select;
        ObjectsEditPresenterImpl objectsEditPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(select2, "select");
        objectsEditPresenterImpl.onElementClicked(select2);
    }
}
