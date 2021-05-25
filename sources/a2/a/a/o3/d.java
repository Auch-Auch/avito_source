package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d implements Action {
    public final /* synthetic */ ParametersListPresenterImpl a;
    public final /* synthetic */ Item b;

    public static final class a extends Lambda implements Function1<List<? extends Item>, Unit> {
        public final /* synthetic */ d a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(1);
            this.a = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(List<? extends Item> list) {
            Intrinsics.checkNotNullParameter(list, "$receiver");
            d dVar = this.a;
            ParametersListPresenterImpl parametersListPresenterImpl = dVar.a;
            ParametersListPresenterImpl.access$replaceItem(parametersListPresenterImpl, parametersListPresenterImpl.c(dVar.b.getStringId()), this.a.b);
            return Unit.INSTANCE;
        }
    }

    public d(ParametersListPresenterImpl parametersListPresenterImpl, Item item) {
        this.a = parametersListPresenterImpl;
        this.b = item;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ParametersListPresenterImpl.access$commitDataChange(this.a, new a(this));
    }
}
