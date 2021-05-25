package a2.a.a.h3.b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.user_advert.soa_with_price.RoutingEventInfo;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResultHandler;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import com.avito.android.util.Keyboards;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<RoutingEventInfo> {
    public final /* synthetic */ SoaWithPriceSheetDialogFragment a;
    public final /* synthetic */ BottomSheetDialog b;

    public e(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, BottomSheetDialog bottomSheetDialog) {
        this.a = soaWithPriceSheetDialogFragment;
        this.b = bottomSheetDialog;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(RoutingEventInfo routingEventInfo) {
        RoutingEventInfo routingEventInfo2 = routingEventInfo;
        if (routingEventInfo2 instanceof RoutingEventInfo.ChooseReasonRoutingInfo) {
            RoutingEventInfo.ChooseReasonRoutingInfo chooseReasonRoutingInfo = (RoutingEventInfo.ChooseReasonRoutingInfo) routingEventInfo2;
            SoaWithPriceSheetDialogFragment.access$setNavigationButton(this.a, this.b, chooseReasonRoutingInfo.getNavigationButtonType());
            SoaWithPriceSheetDialogFragment.access$initChooseReasonDialog(this.a, this.b, chooseReasonRoutingInfo.getTitle());
        } else if (routingEventInfo2 instanceof RoutingEventInfo.EnterPriceRoutingInfo) {
            RoutingEventInfo.EnterPriceRoutingInfo enterPriceRoutingInfo = (RoutingEventInfo.EnterPriceRoutingInfo) routingEventInfo2;
            SoaWithPriceSheetDialogFragment.access$setNavigationButton(this.a, this.b, enterPriceRoutingInfo.getNavigationButtonType());
            SoaWithPriceSheetDialogFragment.access$initEnterPriceDialog(this.a, this.b, enterPriceRoutingInfo.getTitle());
        } else {
            SoaWithPriceResultHandler soaWithPriceResultHandler = null;
            if (Intrinsics.areEqual(routingEventInfo2, RoutingEventInfo.CancelDialog.INSTANCE)) {
                View currentFocus = this.b.getCurrentFocus();
                if (currentFocus != null) {
                    Keyboards.hideKeyboard$default(currentFocus, false, 1, null);
                }
                this.a.dismiss();
            } else if (routingEventInfo2 instanceof RoutingEventInfo.ExitWithSuccess) {
                View currentFocus2 = this.b.getCurrentFocus();
                if (currentFocus2 != null) {
                    Keyboards.hideKeyboard$default(currentFocus2, false, 1, null);
                }
                this.a.dismiss();
                FragmentActivity activity = this.a.getActivity();
                if (activity instanceof SoaWithPriceResultHandler) {
                    soaWithPriceResultHandler = activity;
                }
                SoaWithPriceResultHandler soaWithPriceResultHandler2 = soaWithPriceResultHandler;
                if (soaWithPriceResultHandler2 != null) {
                    RoutingEventInfo.ExitWithSuccess exitWithSuccess = (RoutingEventInfo.ExitWithSuccess) routingEventInfo2;
                    soaWithPriceResultHandler2.handleSoaWithPriceResult(exitWithSuccess.getReason(), exitWithSuccess.getPrice());
                }
            }
        }
    }
}
