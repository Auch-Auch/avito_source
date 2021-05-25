package com.avito.android.inline_filters.dialog.select.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B8\u0012!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR1\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;I)V", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "itemExposureListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "clickListener", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogItemPresenter implements ItemPresenter<InlineFiltersDialogItemView, InlineFiltersDialogItem> {
    public final Function1<Integer, Unit> a;
    public final Function0<Unit> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InlineFiltersDialogItemPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InlineFiltersDialogItemPresenter inlineFiltersDialogItemPresenter) {
            super(0);
            this.a = inlineFiltersDialogItemPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InlineFiltersDialogItemPresenter a;
        public final /* synthetic */ InlineFiltersDialogItem b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InlineFiltersDialogItemPresenter inlineFiltersDialogItemPresenter, InlineFiltersDialogItem inlineFiltersDialogItem, int i) {
            super(0);
            this.a = inlineFiltersDialogItemPresenter;
            this.b = inlineFiltersDialogItem;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!this.b.isHeading()) {
                InlineFiltersDialogItem inlineFiltersDialogItem = this.b;
                inlineFiltersDialogItem.setChecked(!inlineFiltersDialogItem.getChecked());
            }
            this.a.a.invoke(Integer.valueOf(this.c));
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public InlineFiltersDialogItemPresenter(@NotNull Function1<? super Integer, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        Intrinsics.checkNotNullParameter(function0, "itemExposureListener");
        this.a = function1;
        this.b = function0;
    }

    public void bindView(@NotNull InlineFiltersDialogItemView inlineFiltersDialogItemView, @NotNull InlineFiltersDialogItem inlineFiltersDialogItem, int i) {
        Intrinsics.checkNotNullParameter(inlineFiltersDialogItemView, "view");
        Intrinsics.checkNotNullParameter(inlineFiltersDialogItem, "item");
        inlineFiltersDialogItemView.setText(inlineFiltersDialogItem.getText());
        if (!inlineFiltersDialogItem.isHeading()) {
            if (inlineFiltersDialogItem.getShouldExposeImageGroup()) {
                inlineFiltersDialogItemView.setOnLayoutFinishedListener(new a(this));
            }
            inlineFiltersDialogItemView.setSecondaryText(inlineFiltersDialogItem.getSecondaryText());
            inlineFiltersDialogItemView.setOnClickListener(new b(this, inlineFiltersDialogItem, i));
            inlineFiltersDialogItemView.setChecked(inlineFiltersDialogItem.getChecked());
            inlineFiltersDialogItemView.enableMultiselect(inlineFiltersDialogItem.isMultiselect());
            inlineFiltersDialogItemView.setImage(inlineFiltersDialogItem.getImage());
        }
    }
}
