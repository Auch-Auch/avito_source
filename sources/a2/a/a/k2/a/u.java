package a2.a.a.k2.a;

import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.util.LoadingState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class u extends Lambda implements Function1<LoadingState<? super ParametersTreeWithAdditional>, Unit> {
    public final /* synthetic */ FiltersPresenterImpl a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(FiltersPresenterImpl filtersPresenterImpl, Ref.BooleanRef booleanRef, String str, List list, String str2) {
        super(1);
        this.a = filtersPresenterImpl;
        this.b = booleanRef;
        this.c = str;
        this.d = list;
        this.e = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
        LoadingState<? super ParametersTreeWithAdditional> loadingState2 = loadingState;
        Intrinsics.checkNotNullParameter(loadingState2, "it");
        Ref.BooleanRef booleanRef = this.b;
        if (!booleanRef.element && (loadingState2 instanceof LoadingState.Loaded)) {
            booleanRef.element = true;
            this.a.b(this.c, this.d, this.e);
        }
        return Unit.INSTANCE;
    }
}
