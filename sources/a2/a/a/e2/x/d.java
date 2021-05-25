package a2.a.a.e2.x;

import com.avito.android.publish.objects.DeleteObjectElement;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<DeleteObjectElement> {
    public final /* synthetic */ ObjectsEditPresenterImpl a;

    public d(ObjectsEditPresenterImpl objectsEditPresenterImpl) {
        this.a = objectsEditPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeleteObjectElement deleteObjectElement) {
        ObjectsEditPresenterImpl.access$onDeleteObjectClicked(this.a);
    }
}
