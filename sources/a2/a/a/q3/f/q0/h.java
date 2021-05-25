package a2.a.a.q3.f.q0;

import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<AppliedVasResult, List<? extends Item>> {
    public final /* synthetic */ AppliedServicesViewModelImpl a;

    public h(AppliedServicesViewModelImpl appliedServicesViewModelImpl) {
        this.a = appliedServicesViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(AppliedVasResult appliedVasResult) {
        AppliedVasResult appliedVasResult2 = appliedVasResult;
        Intrinsics.checkNotNullParameter(appliedVasResult2, "it");
        return this.a.k.convert(appliedVasResult2);
    }
}
