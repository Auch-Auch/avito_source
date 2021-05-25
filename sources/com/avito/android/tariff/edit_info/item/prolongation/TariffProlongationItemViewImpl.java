package com.avito.android.tariff.edit_info.item.prolongation;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.R;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "currentText", "setCurrentText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "isEnabled", "setSwitherEnabled", "(Z)V", "isSwitchOn", "setSwitcherOn", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "s", "Lkotlin/jvm/functions/Function0;", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "t", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcher", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffProlongationItemViewImpl extends BaseViewHolder implements TariffProlongationItemView {
    public Function0<Unit> s;
    public final SwitcherListItem t;
    public final View u;
    public final AttributedTextFormatter v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TariffProlongationItemViewImpl a;

        public a(TariffProlongationItemViewImpl tariffProlongationItemViewImpl) {
            this.a = tariffProlongationItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.s;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TariffProlongationItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.u = view;
        this.v = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.prolongation_switcher);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.SwitcherListItem");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById;
        this.t = switcherListItem;
        switcherListItem.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setCurrentText(@Nullable AttributedText attributedText) {
        SwitcherListItem switcherListItem = this.t;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        switcherListItem.setMessage(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function0;
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setSwitcherOn(boolean z) {
        this.t.setChecked(z);
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setSwitherEnabled(boolean z) {
        this.t.setEnabled(z);
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemView
    public void setCurrentText(@Nullable String str) {
        this.t.setMessage(str);
    }
}
