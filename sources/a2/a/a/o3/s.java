package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.android.validation.ValidationResult;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class s extends Lambda implements Function1<List<? extends Item>, Unit> {
    public final /* synthetic */ t a;
    public final /* synthetic */ List b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar, List list) {
        super(1);
        this.a = tVar;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "$receiver");
        List<ValidationResult> list2 = this.b;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        for (ValidationResult validationResult : list2) {
            t tVar = this.a;
            ParametersListPresenterImpl.access$applyDeepValidationResult(tVar.a, tVar.b, validationResult);
        }
        return Unit.INSTANCE;
    }
}
