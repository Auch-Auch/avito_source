package com.avito.android.tariff.fees_methods.items.high_demand;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.remote.model.HighDemandIcon;
import com.avito.android.remote.model.HighDemandIconName;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItemView;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItemViewImpl;", "Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "actionText", "setActionText", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/remote/model/HighDemandIcon;", "icon", "setIcon", "(Lcom/avito/android/remote/model/HighDemandIcon;)V", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "t", "Lkotlin/jvm/functions/Function1;", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class HighDemandItemViewImpl extends BaseViewHolder implements HighDemandItemView {
    public final ListItem s;
    public Function1<Object, Unit> t;
    public final View u;
    public final AttributedTextFormatter v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HighDemandItemViewImpl a;

        public a(HighDemandItemViewImpl highDemandItemViewImpl) {
            this.a = highDemandItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.a.t;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(new Object());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HighDemandItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.u = view;
        this.v = attributedTextFormatter;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.ListItem");
        this.s = (ListItem) view;
        view.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        HighDemandItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItemView
    public void setActionText(@Nullable String str) {
        this.s.setLink(str);
    }

    @Override // com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItemView
    public void setIcon(@Nullable HighDemandIcon highDemandIcon) {
        HighDemandIconName icon = highDemandIcon != null ? highDemandIcon.getIcon() : null;
        if (highDemandIcon == null || icon == null) {
            ListItem.setImageResource$default(this.s, 0, 0, 3, null);
            return;
        }
        ListItem.setImageResource$default(this.s, icon.getIconResId(), 0, 2, null);
        ListItem listItem = this.s;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        listItem.setLeftIconColor(ContextsKt.getColorFrom(context, highDemandIcon.getColor()));
    }

    @Override // com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItemView
    public void setOnClickListener(@NotNull Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = function1;
    }

    @Override // com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItemView
    public void setTitle(@Nullable AttributedText attributedText) {
        ListItem listItem = this.s;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        listItem.setTitle(attributedTextFormatter.format(context, attributedText));
    }
}
