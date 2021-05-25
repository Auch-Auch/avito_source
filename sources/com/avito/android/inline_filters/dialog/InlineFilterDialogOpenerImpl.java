package com.avito.android.inline_filters.dialog;

import android.os.Parcelable;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"Jn\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpenerImpl;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "filterSetListener", "Lkotlin/Function0;", "filterCloseListener", "closeButtonListener", "show", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dismiss", "()V", "onSaveState", "()Landroid/os/Parcelable;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "openedDialog", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "dialogFactory", "<init>", "(Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterDialogOpenerImpl implements InlineFilterDialogOpener {
    public InlineFilterDialog a;
    public final InlineFilterDialogFactory b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.c).invoke();
                ((InlineFilterDialogOpenerImpl) this.b).a = null;
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((Function0) this.c).invoke();
                ((InlineFilterDialogOpenerImpl) this.b).a = null;
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public InlineFilterDialogOpenerImpl(@NotNull InlineFilterDialogFactory inlineFilterDialogFactory) {
        Intrinsics.checkNotNullParameter(inlineFilterDialogFactory, "dialogFactory");
        this.b = inlineFilterDialogFactory;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void dismiss() {
        InlineFilterDialog inlineFilterDialog = this.a;
        if (inlineFilterDialog != null) {
            inlineFilterDialog.dismiss();
        }
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    @Nullable
    public Parcelable onSaveState() {
        InlineFilterDialog inlineFilterDialog = this.a;
        if (inlineFilterDialog != null) {
            return inlineFilterDialog.onSaveState();
        }
        return null;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void show(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "filterSetListener");
        Intrinsics.checkNotNullParameter(function0, "filterCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        InlineFilterDialog provideInlineFilterDialog = this.b.provideInlineFilterDialog(filter, list, parcelable, function1, new a(0, this, function0), new a(1, this, function02));
        this.a = provideInlineFilterDialog;
        if (provideInlineFilterDialog != null) {
            provideInlineFilterDialog.show();
        }
    }
}
