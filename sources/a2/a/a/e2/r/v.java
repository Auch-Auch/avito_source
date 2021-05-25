package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.IterableDataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class v extends Lambda implements Function1<IterableDataSource<? extends Item>, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(1);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(IterableDataSource<? extends Item> iterableDataSource) {
        for (Item item : iterableDataSource) {
            this.a.I.update(item);
        }
        return Unit.INSTANCE;
    }
}
