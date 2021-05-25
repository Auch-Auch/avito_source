package a2.a.a.e2.r;

import com.avito.android.items.ItemWithState;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.PublishDetailsPresenterKt;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.util.DataSources;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class t extends Lambda implements Function1<DataSource<? extends Item>, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(1);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DataSource<? extends Item> dataSource) {
        DataSource<? extends Item> dataSource2 = dataSource;
        Intrinsics.checkNotNullExpressionValue(dataSource2, "dataSource");
        Iterator it = DataSources.toIterableDataSource(dataSource2).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Item item = (Item) next;
            if ((item instanceof ItemWithState) && !(((ItemWithState) item).getState() instanceof ItemWithState.State.Normal)) {
                break;
            }
            i++;
        }
        if (!(this.a.l) || i == -1) {
            this.a.l = false;
            this.a.j = i;
        } else {
            this.a.l = false;
            ItemDetailsView itemDetailsView = this.a.c;
            if (itemDetailsView != null) {
                itemDetailsView.scrollToItem(i, PublishDetailsPresenterKt.access$hasDeferredSizeChange((Item) dataSource2.getItem(i)));
            }
        }
        return Unit.INSTANCE;
    }
}
