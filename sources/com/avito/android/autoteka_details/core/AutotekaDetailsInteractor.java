package com.avito.android.autoteka_details.core;

import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "getAutotekaItem", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "getAutotekaDetails", "()Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "setAutotekaDetails", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "autotekaDetails", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaDetailsInteractor {
    @Nullable
    AutotekaDetailsResponse getAutotekaDetails();

    @NotNull
    Observable<LoadingState<AutotekaDetailsResponse>> getAutotekaItem();

    @NotNull
    Kundle onSaveState();

    void setAutotekaDetails(@Nullable AutotekaDetailsResponse autotekaDetailsResponse);
}
