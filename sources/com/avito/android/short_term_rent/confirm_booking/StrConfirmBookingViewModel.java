package com.avito.android.short_term_rent.confirm_booking;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\"\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0019R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0019R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0019¨\u0006,"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "Lcom/avito/android/blueprints/InputItemPresenter$Listener;", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "getBookingCalculationReview", "()V", "", "success", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onCompletePaymentResult", "(ZLcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "Landroidx/lifecycle/LiveData;", "Ljava/lang/Runnable;", "getErrorChanges", "()Landroidx/lifecycle/LiveData;", "errorChanges", "", "getErrorMessageChanges", "errorMessageChanges", "getUrlClickChanges", "urlClickChanges", "", "", "getDividersChanges", "dividersChanges", "getDeepLinkChanges", "deepLinkChanges", "getShowContentChanges", "showContentChanges", "getProgressChanges", "progressChanges", "getPayUrlChanges", "payUrlChanges", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface StrConfirmBookingViewModel extends ButtonItemPresenter.Listener, InputItemPresenter.Listener, OnUrlClickListener {
    void getBookingCalculationReview();

    @NotNull
    LiveData<DeepLink> getDeepLinkChanges();

    @NotNull
    LiveData<List<Integer>> getDividersChanges();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<String> getErrorMessageChanges();

    @NotNull
    LiveData<String> getPayUrlChanges();

    @NotNull
    LiveData<Unit> getProgressChanges();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<String> getUrlClickChanges();

    void onCompletePaymentResult(boolean z, @Nullable DeepLink deepLink);

    void onRestoreInstanceState(@NotNull Bundle bundle);

    void onSaveInstanceState(@NotNull Bundle bundle);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
