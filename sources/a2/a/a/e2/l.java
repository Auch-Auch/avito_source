package a2.a.a.e2;

import com.avito.android.publish.PublishViewModel;
import io.reactivex.functions.Consumer;
public final class l<T> implements Consumer<String> {
    public final /* synthetic */ PublishViewModel a;

    public l(PublishViewModel publishViewModel) {
        this.a = publishViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        this.a.getState().setActiveFieldId(str);
    }
}
