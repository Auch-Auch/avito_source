package a2.a.a.e2.x;

import com.avito.android.items.InputItem;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<InputItem> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    public b(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        this.a = objectsEditPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(InputItem inputItem) {
        InputItem inputItem2 = inputItem;
        ObjectsEditPresenterImpl objectsEditPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(inputItem2, "element");
        String value = inputItem2.getValue();
        if (value == null) {
            value = "";
        }
        objectsEditPresenterImpl.onElementValueChanged(inputItem2, value, false);
    }
}
