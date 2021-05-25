package a2.a.a.g1.e.d;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ MultiselectFilterDialog a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ List c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ List e;
    public final /* synthetic */ Parcelable f;
    public final /* synthetic */ Function0 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(MultiselectFilterDialog multiselectFilterDialog, Filter filter, Function0 function0, List list, Function1 function1, List list2, Parcelable parcelable, Function0 function02) {
        super(1);
        this.a = multiselectFilterDialog;
        this.b = function0;
        this.c = list;
        this.d = function1;
        this.e = list2;
        this.f = parcelable;
        this.g = function02;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        this.d.invoke(new InlineFilterValue.InlineFilterMultiSelectValue(this.a.e));
        MultiselectFilterDialog.access$updateSelection(this.a, this.e, this.c);
        this.a.performDismiss();
        return Unit.INSTANCE;
    }
}
