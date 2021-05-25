package a2.a.a.g1.e.d;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.model.search.Filter;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
public final class g<T> implements Consumer<InlineFiltersDialogItem> {
    public final /* synthetic */ InlineFiltersView a;
    public final /* synthetic */ MultiselectFilterDialog b;
    public final /* synthetic */ Filter c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ List e;
    public final /* synthetic */ Function1 f;
    public final /* synthetic */ List g;
    public final /* synthetic */ Parcelable h;
    public final /* synthetic */ Function0 i;

    public g(InlineFiltersView inlineFiltersView, MultiselectFilterDialog multiselectFilterDialog, Filter filter, Function0 function0, List list, Function1 function1, List list2, Parcelable parcelable, Function0 function02) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(InlineFiltersDialogItem inlineFiltersDialogItem) {
        InlineFiltersDialogItem inlineFiltersDialogItem2 = inlineFiltersDialogItem;
        if (inlineFiltersDialogItem2.getChecked()) {
            this.b.e.add(inlineFiltersDialogItem2.getFilterId());
        } else {
            this.b.e.remove(inlineFiltersDialogItem2.getFilterId());
        }
        this.b.a(this.a, this.c);
    }
}
