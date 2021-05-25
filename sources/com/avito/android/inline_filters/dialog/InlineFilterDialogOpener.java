package com.avito.android.inline_filters.dialog;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001Jp\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "", "Lcom/avito/android/remote/model/search/Filter;", "filter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "filterSetListener", "Lkotlin/Function0;", "filterCloseListener", "closeButtonListener", "show", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onSaveState", "()Landroid/os/Parcelable;", "dismiss", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFilterDialogOpener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void show$default(InlineFilterDialogOpener inlineFilterDialogOpener, Filter filter, List list, Parcelable parcelable, Function1 function1, Function0 function0, Function0 function02, int i, Object obj) {
            if (obj == null) {
                inlineFilterDialogOpener.show(filter, list, parcelable, function1, function0, (i & 32) != 0 ? function0 : function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }

    void dismiss();

    @Nullable
    Parcelable onSaveState();

    void show(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
