package a2.a.a.e2.v;

import com.avito.android.publish.infomodel_request.InfomodelRequestViewModel;
import com.avito.android.remote.model.ItemBrief;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<ItemBrief> {
    public final /* synthetic */ InfomodelRequestViewModel a;

    public h(InfomodelRequestViewModel infomodelRequestViewModel) {
        this.a = infomodelRequestViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ItemBrief itemBrief) {
        InfomodelRequestViewModel.access$getPublishViewModel$p(this.a).setItem(itemBrief);
    }
}
