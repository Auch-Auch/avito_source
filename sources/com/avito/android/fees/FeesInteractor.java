package com.avito.android.fees;

import android.os.Bundle;
import com.avito.android.remote.model.AdvertFeesResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/fees/FeesInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/AdvertFeesResponse;", "getFees", "()Lio/reactivex/Observable;", "getItemFeesResponse", "()Lcom/avito/android/remote/model/AdvertFeesResponse;", "Landroid/os/Bundle;", "state", "", "onSaveState", "(Landroid/os/Bundle;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface FeesInteractor {
    @NotNull
    Observable<AdvertFeesResponse> getFees();

    @Nullable
    AdvertFeesResponse getItemFeesResponse();

    void onSaveState(@NotNull Bundle bundle);
}
