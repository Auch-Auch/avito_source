package com.avito.android.inline_filters.dialog;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jt\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "closeButtonListener", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "provideInlineFilterDialog", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFilterDialogFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.avito.android.inline_filters.dialog.InlineFilterDialogFactory */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InlineFilterDialog provideInlineFilterDialog$default(InlineFilterDialogFactory inlineFilterDialogFactory, Filter filter, List list, Parcelable parcelable, Function1 function1, Function0 function0, Function0 function02, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return inlineFilterDialogFactory.provideInlineFilterDialog(filter, list, parcelable, function1, function0, (i & 32) != 0 ? function0 : function02);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideInlineFilterDialog");
        }
    }

    @Nullable
    InlineFilterDialog provideInlineFilterDialog(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
