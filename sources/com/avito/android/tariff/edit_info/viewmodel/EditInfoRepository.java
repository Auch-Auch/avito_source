package com.avito.android.tariff.edit_info.viewmodel;

import com.avito.android.remote.model.change.TariffAutoProlongResult;
import com.avito.android.remote.model.edit.TariffEditInfoResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tariff/edit_info/viewmodel/EditInfoRepository;", "", "", "checkoutContext", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/edit/TariffEditInfoResult;", "getTariffInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "autoProlong", "Lcom/avito/android/remote/model/change/TariffAutoProlongResult;", "postTariffAutoprolong", "(Z)Lio/reactivex/Observable;", "getApplyChange", "()Lio/reactivex/Observable;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface EditInfoRepository {
    @NotNull
    Observable<LoadingState<Object>> getApplyChange();

    @NotNull
    Observable<LoadingState<TariffEditInfoResult>> getTariffInfo(@NotNull String str);

    @NotNull
    Observable<LoadingState<TariffAutoProlongResult>> postTariffAutoprolong(boolean z);
}
