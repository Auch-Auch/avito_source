package a2.a.a.g1.e.d;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.model.search.Filter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ InlineFiltersView a;
    public final /* synthetic */ MultiselectFilterDialog b;
    public final /* synthetic */ Filter c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ List e;
    public final /* synthetic */ Function1 f;
    public final /* synthetic */ List g;
    public final /* synthetic */ Parcelable h;
    public final /* synthetic */ Function0 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(InlineFiltersView inlineFiltersView, MultiselectFilterDialog multiselectFilterDialog, Filter filter, Function0 function0, List list, Function1 function1, List list2, Parcelable parcelable, Function0 function02) {
        super(0);
        this.a = inlineFiltersView;
        this.b = multiselectFilterDialog;
        this.c = filter;
        this.d = function0;
        this.e = list;
        this.f = function1;
        this.g = list2;
        this.h = parcelable;
        this.i = function02;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.e.clear();
        for (InlineFiltersDialogItem inlineFiltersDialogItem : this.e) {
            inlineFiltersDialogItem.setChecked(false);
        }
        this.a.setItemsView(this.e);
        this.b.a(this.a, this.c);
        return Unit.INSTANCE;
    }
}
