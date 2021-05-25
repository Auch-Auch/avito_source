package a2.a.a.g1.e.d;

import android.os.Parcelable;
import android.view.View;
import com.avito.android.inline_filters.dialog.select.SelectFilterDialog;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.util.Keyboards;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import t6.y.a;
public final class l<T> implements Consumer<InlineFiltersDialogItem> {
    public final /* synthetic */ SelectFilterDialog a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ List f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ Parcelable h;

    public l(SelectFilterDialog selectFilterDialog, Filter filter, Function0 function0, View view, Function1 function1, Function0 function02, List list, Function0 function03, Parcelable parcelable) {
        this.a = selectFilterDialog;
        this.b = function0;
        this.c = view;
        this.d = function1;
        this.e = function02;
        this.f = list;
        this.g = function03;
        this.h = parcelable;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(InlineFiltersDialogItem inlineFiltersDialogItem) {
        InlineFiltersDialogItem inlineFiltersDialogItem2 = inlineFiltersDialogItem;
        this.d.invoke(inlineFiltersDialogItem2.isIntValue() ? new InlineFilterValue.InlineFilterSelectIntValue(Integer.parseInt(inlineFiltersDialogItem2.getFilterId().toString(), a.checkRadix(10))) : new InlineFilterValue.InlineFilterSelectValue(inlineFiltersDialogItem2.getFilterId()));
        View view = this.c;
        if (view != null) {
            Keyboards.hideKeyboard$default(view, false, 1, null);
        }
        this.a.performDismiss();
    }
}
