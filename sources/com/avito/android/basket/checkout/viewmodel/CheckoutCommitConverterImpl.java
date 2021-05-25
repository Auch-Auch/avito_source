package com.avito.android.basket.checkout.viewmodel;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.BarInfo;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CheckoutCommitResult;
import com.avito.android.remote.model.CheckoutDialog;
import com.avito.android.remote.tariff.bar.BarDescription;
import com.avito.android.remote.tariff.bar.BarProgress;
import com.avito.android.remote.tariff.bar.BarProgressState;
import com.avito.android.remote.tariff.bar.TariffBar;
import com.avito.android.tariff.view.TariffBarConverter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverterImpl;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "Lcom/avito/android/remote/model/CheckoutCommitResult;", "commitResult", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutNextStepData;", "convertCommitResponse", "(Lcom/avito/android/remote/model/CheckoutCommitResult;)Lcom/avito/android/basket/checkout/viewmodel/CheckoutNextStepData;", "Lcom/avito/android/remote/model/CheckoutDialog;", "Lcom/avito/android/paid_services/routing/DialogInfo;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/CheckoutDialog;)Lcom/avito/android/paid_services/routing/DialogInfo;", "Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/tariff/view/TariffBarConverter;", "barConverter", "<init>", "(Lcom/avito/android/tariff/view/TariffBarConverter;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutCommitConverterImpl implements CheckoutCommitConverter {
    public final TariffBarConverter a;

    @Inject
    public CheckoutCommitConverterImpl(@NotNull TariffBarConverter tariffBarConverter) {
        Intrinsics.checkNotNullParameter(tariffBarConverter, "barConverter");
        this.a = tariffBarConverter;
    }

    public final DialogInfo a(CheckoutDialog checkoutDialog) {
        TariffBar bar = checkoutDialog.getBar();
        BarInfo barInfo = null;
        BarProgressState barProgressState = null;
        if (bar != null) {
            String title = bar.getTitle();
            BarDescription description = bar.getDescription();
            String title2 = description != null ? description.getTitle() : null;
            TariffBarConverter tariffBarConverter = this.a;
            BarDescription description2 = bar.getDescription();
            TariffCountStatus convertDescriptionStatus = tariffBarConverter.convertDescriptionStatus(description2 != null ? description2.getState() : null);
            BarProgress startProgress = bar.getStartProgress();
            Float valueOf = startProgress != null ? Float.valueOf(startProgress.getValue()) : null;
            TariffBarConverter tariffBarConverter2 = this.a;
            BarProgress startProgress2 = bar.getStartProgress();
            if (startProgress2 != null) {
                barProgressState = startProgress2.getState();
            }
            barInfo = new BarInfo(title, title2, convertDescriptionStatus, valueOf, tariffBarConverter2.convertProgressStatus(barProgressState), bar.getCurrentProgress().getValue(), this.a.convertProgressStatus(bar.getCurrentProgress().getState()));
        }
        return new DialogInfo(checkoutDialog.getTitle(), checkoutDialog.getDescription(), checkoutDialog.getActionTitle(), barInfo);
    }

    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverter
    @NotNull
    public CheckoutNextStepData convertCommitResponse(@NotNull CheckoutCommitResult checkoutCommitResult) {
        Intrinsics.checkNotNullParameter(checkoutCommitResult, "commitResult");
        DeepLink uri = checkoutCommitResult.getUri();
        CheckoutDialog successDialog = checkoutCommitResult.getSuccessDialog();
        DialogInfo dialogInfo = null;
        DialogInfo a3 = successDialog != null ? a(successDialog) : null;
        CheckoutDialog activeDialog = checkoutCommitResult.getActiveDialog();
        if (activeDialog != null) {
            dialogInfo = a(activeDialog);
        }
        return new CheckoutNextStepData(uri, a3, dialogInfo);
    }
}
