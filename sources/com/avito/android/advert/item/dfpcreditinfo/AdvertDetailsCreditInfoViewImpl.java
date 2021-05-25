package com.avito.android.advert.item.dfpcreditinfo;

import a2.a.a.f.x.t.a;
import a2.a.a.f.x.t.b;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert.item.dfpcreditinfo.calculator.Type;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJh\u0010(\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\"\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\r2\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0001¢\u0006\u0004\b,\u0010-J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020.H\u0001¢\u0006\u0004\b/\u00100J \u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0014H\u0001¢\u0006\u0004\b3\u00104J \u00107\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0014H\u0001¢\u0006\u0004\b7\u00104J \u00108\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010;\u001a\u00020\u00062\b\b\u0002\u0010:\u001a\u00020\u0014H\u0001¢\u0006\u0004\b;\u0010\u0017J(\u0010>\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0001¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0004H\u0001¢\u0006\u0004\b@\u0010\bJ\u0010\u0010A\u001a\u00020\u0006H\u0001¢\u0006\u0004\bA\u0010\u0013R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010LR\u0018\u0010R\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006Y"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditInfoView;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfoView;", "", "value", "", "showBrokerInfoSheetIfNeeded", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPhoneChooserListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;)V", "", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "items", "updatePhoneChooser", "(Ljava/util/List;)V", "clearFocus", "()V", "", "force", "dismissDialog", "(Z)V", "hideContent", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;", "type", "initializeCalculator", "(Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;)V", "isEditing", "()Z", "Lkotlin/Pair;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "terms", "inputHint", "loan", "monthlyPayment", "percent", "setCalculatorData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "setIcon", "(Landroid/net/Uri;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)V", "text", "isMedium", "setText", "(Ljava/lang/String;Z)V", "title", "isBig", "setTitle", "setTitleWithPrice", "(Ljava/lang/String;Ljava/lang/String;)V", "isShowTopDivider", "showAdContent", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showLegalInfoDialog", "showStubContent", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView;", "w", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView;", "phoneChooserView", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "brokerInfoDialog", "u", "phoneChooserDialog", "t", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "phoneChooserListener", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsCreditInfoViewImpl extends BaseViewHolder implements AdvertDetailsCreditInfoView, DfpCreditInfoView {
    public final Context s;
    public PhoneChooserView.Listener t;
    public BottomSheetDialog u;
    public BottomSheetDialog v;
    public PhoneChooserView w;
    public final /* synthetic */ DfpCreditButton x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsCreditInfoViewImpl(@NotNull View view, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
        this.x = new DfpCreditButton(view, creditInfoResourcesProvider);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s = context;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void clearFocus() {
        this.x.clearFocus();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void dismissDialog(boolean z) {
        this.x.dismissDialog(z);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void hideContent() {
        this.x.hideContent();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void initializeCalculator(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.x.initializeCalculator(type);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public boolean isEditing() {
        return this.x.isEditing();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setCalculatorData(@NotNull Pair<Integer, String> pair, int i, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(pair, "initialPayment");
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(pair2, "loan");
        Intrinsics.checkNotNullParameter(str2, "monthlyPayment");
        Intrinsics.checkNotNullParameter(str3, "percent");
        this.x.setCalculatorData(pair, i, list, str, pair2, str2, str3);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setIcon(@Nullable Uri uri) {
        this.x.setIcon(uri);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setListener(@NotNull DfpCreditButton.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setListener(listener);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoView
    public void setPhoneChooserListener(@NotNull PhoneChooserView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = listener;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setText(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.x.setText(str, z);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setTitle(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.x.setTitle(str, z);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setTitleWithPrice(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.x.setTitleWithPrice(str, str2);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showAdContent(boolean z) {
        this.x.showAdContent(z);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoView
    public void showBrokerInfoSheetIfNeeded(@Nullable String str) {
        if (str == null) {
            BottomSheetDialog bottomSheetDialog = this.v;
            if (bottomSheetDialog != null) {
                bottomSheetDialog.close();
            }
            this.v = null;
        } else if (this.v == null) {
            View inflate = LayoutInflater.from(this.s).inflate(R.layout.advert_detais_broker_info, (ViewGroup) null);
            BottomSheetDialog bottomSheetDialog2 = this.v;
            if (bottomSheetDialog2 != null) {
                bottomSheetDialog2.close();
            }
            BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(this.s, 0, 2, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            bottomSheetDialog3.setContentView(inflate, true);
            BottomSheetDialog.setHeaderParams$default(bottomSheetDialog3, null, null, false, true, 7, null);
            bottomSheetDialog3.setFitContentPeekHeight(true);
            bottomSheetDialog3.setOnDismissListener(new a(this, inflate));
            this.v = bottomSheetDialog3;
            bottomSheetDialog3.show();
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showButton(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "text", str2, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str3, "privacyLink");
        this.x.showButton(str, str2, str3);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showLegalInfoDialog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.x.showLegalInfoDialog(str);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showStubContent() {
        this.x.showStubContent();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoView
    public void updatePhoneChooser(@Nullable List<? extends PhoneChooserItem> list) {
        if (list == null) {
            BottomSheetDialog bottomSheetDialog = this.u;
            if (bottomSheetDialog != null) {
                bottomSheetDialog.close();
                return;
            }
            return;
        }
        if (this.u == null) {
            View inflate = LayoutInflater.from(this.s).inflate(R.layout.advert_detais_credit_phone_chooser, (ViewGroup) null);
            BottomSheetDialog bottomSheetDialog2 = this.u;
            if (bottomSheetDialog2 != null) {
                bottomSheetDialog2.close();
            }
            BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(this.s, 0, 2, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            bottomSheetDialog3.setContentView(inflate, true);
            BottomSheetDialog.setHeaderParams$default(bottomSheetDialog3, null, null, false, true, 7, null);
            bottomSheetDialog3.setFitContentPeekHeight(true);
            bottomSheetDialog3.setOnDismissListener(new b(this, inflate));
            this.u = bottomSheetDialog3;
            PhoneChooserViewImpl phoneChooserViewImpl = new PhoneChooserViewImpl(inflate);
            phoneChooserViewImpl.setListener(this.t);
            this.w = phoneChooserViewImpl;
            BottomSheetDialog bottomSheetDialog4 = this.u;
            if (bottomSheetDialog4 != null) {
                bottomSheetDialog4.show();
            }
        }
        PhoneChooserView phoneChooserView = this.w;
        if (phoneChooserView != null) {
            phoneChooserView.showItems(list);
        }
    }
}
