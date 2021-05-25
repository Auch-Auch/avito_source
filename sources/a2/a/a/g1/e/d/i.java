package a2.a.a.g1.e.d;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.remote.model.search.Filter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ List d;
    public final /* synthetic */ Parcelable e;
    public final /* synthetic */ Function0 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(MultiselectFilterDialog multiselectFilterDialog, Filter filter, Function0 function0, List list, Function1 function1, List list2, Parcelable parcelable, Function0 function02) {
        super(0);
        this.a = function0;
        this.b = list;
        this.c = function1;
        this.d = list2;
        this.e = parcelable;
        this.f = function02;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.f.invoke();
        return Unit.INSTANCE;
    }
}
