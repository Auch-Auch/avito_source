package com.avito.android.tariff.edit_info.item.alert_dialog;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.remote.model.edit.TariffAlertAction;
import com.avito.android.remote.model.edit.TariffBanner;
import com.avito.android.tariff.R;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItemView;", "Lkotlin/Function1;", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/TariffAlertActionItem;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnButtonClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;", "item", "bindAlert", "(Lcom/avito/android/tariff/edit_info/item/alert_dialog/AlertDialogItem;)V", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "s", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "alertBanner", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "t", "Lkotlin/jvm/functions/Function1;", "buttonClickListener", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class AlertDialogItemViewImpl extends BaseViewHolder implements AlertDialogItemView {
    public final AlertBanner s;
    public Function1<? super TariffAlertActionItem, Unit> t;
    public final View u;
    public final AttributedTextFormatter v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TariffBanner.State.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            TariffBanner.State state = TariffBanner.State.SUCCESS;
            iArr[0] = 1;
            TariffBanner.State state2 = TariffBanner.State.NORMAL;
            iArr[1] = 2;
            TariffBanner.State state3 = TariffBanner.State.WARNING;
            iArr[2] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.u = view;
        this.v = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.alert_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.alert_banner)");
        this.s = (AlertBanner) findViewById;
    }

    @Override // com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItemView
    public void bindAlert(@NotNull AlertDialogItem alertDialogItem) {
        int i;
        boolean z;
        T t2;
        boolean z2;
        Intrinsics.checkNotNullParameter(alertDialogItem, "item");
        AlertBannerContent content = this.s.getContent();
        content.setTitle(alertDialogItem.getInfo().getTitle());
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        content.setBody(attributedTextFormatter.format(context, alertDialogItem.getInfo().getDescription()));
        T t3 = null;
        if (Intrinsics.areEqual(alertDialogItem.getInfo().isExclaimed(), Boolean.TRUE)) {
            content.setImageDrawable(this.u.getContext().getDrawable(R.drawable.ic_status_24));
        } else {
            content.setImageDrawable(null);
        }
        int ordinal = alertDialogItem.getInfo().getState().ordinal();
        if (ordinal == 0) {
            i = com.avito.android.lib.design.R.attr.alertBannerSuccess;
        } else if (ordinal == 1) {
            i = com.avito.android.lib.design.R.attr.alertBanner;
        } else if (ordinal == 2) {
            i = com.avito.android.lib.design.R.attr.alertBannerDanger;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        AlertBanner.setContentByAttr$default(this.s, 0, i, 1, null);
        List<TariffAlertActionItem> actions = alertDialogItem.getInfo().getActions();
        if (actions != null) {
            Iterator<T> it = actions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2.getButtonStyle() == TariffAlertAction.ButtonStyle.OUTLINE) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            T t4 = t2;
            if (t4 != null) {
                this.s.getContent().setButton(t4.getTitle(), new m1(0, t4, this));
            }
        }
        List<TariffAlertActionItem> actions2 = alertDialogItem.getInfo().getActions();
        if (actions2 != null) {
            Iterator<T> it2 = actions2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (next.getButtonStyle() == TariffAlertAction.ButtonStyle.LINK_INCREASED) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t3 = next;
                    break;
                }
            }
            T t5 = t3;
            if (t5 != null) {
                this.s.getContent().setLink(t5.getTitle(), new m1(1, t5, this));
            }
        }
    }

    @Override // com.avito.android.tariff.edit_info.item.alert_dialog.AlertDialogItemView
    public void setOnButtonClickListener(@NotNull Function1<? super TariffAlertActionItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = function1;
    }
}
