package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b0 extends Lambda implements Function1<DataSource<? extends Item>, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;
    public final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(PublishDetailsPresenterImpl publishDetailsPresenterImpl, int i) {
        super(1);
        this.a = publishDetailsPresenterImpl;
        this.b = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DataSource<? extends Item> dataSource) {
        ItemDetailsView itemDetailsView = this.a.c;
        if (itemDetailsView != null) {
            ItemDetailsView.DefaultImpls.scrollToItem$default(itemDetailsView, this.b, false, 2, null);
        }
        return Unit.INSTANCE;
    }
}
