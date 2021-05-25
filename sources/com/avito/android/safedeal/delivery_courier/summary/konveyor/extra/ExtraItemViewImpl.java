package com.avito.android.safedeal.delivery_courier.summary.konveyor.extra;

import a2.a.a.i2.a.b.n.a.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemViewImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/ExtraItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "showDialog", "()V", "Lkotlin/Function1;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/extra/DialogState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDialogStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "extraInfoTitle", "", "extraInfo", "setExtraInfo", "(Ljava/lang/String;Ljava/util/List;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "view", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "s", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "t", "Lkotlin/jvm/functions/Function1;", "dialogStateListener", "<init>", "(Landroid/widget/TextView;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraItemViewImpl extends BaseViewHolder implements ExtraItemView {
    public final BottomSheetDialog s;
    public Function1<? super DialogState, Unit> t;
    public final TextView u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ExtraItemViewImpl a;

        public a(ExtraItemViewImpl extraItemViewImpl) {
            this.a = extraItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.showDialog();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExtraItemViewImpl(@NotNull TextView textView) {
        super(textView);
        Intrinsics.checkNotNullParameter(textView, "view");
        this.u = textView;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s = new BottomSheetDialog(context, 0, 2, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ExtraItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemView
    public void setDialogStateChangeListener(@Nullable Function1<? super DialogState, Unit> function1) {
        this.t = function1;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemView
    public void setExtraInfo(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "extraInfoTitle");
        Intrinsics.checkNotNullParameter(list, "extraInfo");
        View inflate = LayoutInflater.from(this.u.getContext()).inflate(R.layout.delivery_courier_extra_item_dialog, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.delivery_extra_item_dialog_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy…_extra_item_dialog_title)");
        ((TextView) findViewById).setText(str);
        View findViewById2 = inflate.findViewById(R.id.delivery_extra_item_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy…delivery_extra_item_info)");
        ((TextView) findViewById2).setText(CollectionsKt___CollectionsKt.joinToString$default(list, "\n\n", null, null, 0, null, null, 62, null));
        View findViewById3 = inflate.findViewById(R.id.delivery_extra_item_dialog_title_close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy…ialog_title_close_button)");
        findViewById3.setOnClickListener(new a2.a.a.i2.a.b.n.a.a(this));
        this.s.setOnCloseListener(new b(this));
        BottomSheetDialog bottomSheetDialog = this.s;
        Intrinsics.checkNotNullExpressionValue(inflate, "containerView");
        bottomSheetDialog.setContentView(inflate);
        this.u.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.u.setText(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemView
    public void showDialog() {
        this.s.show();
        this.s.expand();
        Function1<? super DialogState, Unit> function1 = this.t;
        if (function1 != null) {
            function1.invoke(DialogState.SHOWN);
        }
    }
}
