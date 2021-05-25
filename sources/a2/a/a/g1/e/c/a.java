package a2.a.a.g1.e.c;

import android.os.Parcelable;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.y.l;
public final class a extends Lambda implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Parcelable c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(InlineFilterValue.InlineFilterNumericRangeValue inlineFilterNumericRangeValue, Filter filter, Function0 function0, Function1 function1, Parcelable parcelable) {
        super(1);
        this.a = function0;
        this.b = function1;
        this.c = parcelable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends String> list) {
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        this.b.invoke(new InlineFilterValue.InlineFilterNumericRangeValue(l.toLongOrNull((String) list2.get(0)), l.toLongOrNull((String) list2.get(1))));
        this.a.invoke();
        return Unit.INSTANCE;
    }
}
