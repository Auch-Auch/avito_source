package com.avito.android.autoteka_details.core;

import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "", "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "getResponse", "()Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "getAutotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaTeaserInteractor {
    @NotNull
    Observable<LoadingState<AutotekaTeaserResponse>> getAutotekaTeaser(@NotNull String str);

    @Nullable
    AutotekaTeaserResponse getResponse();

    @NotNull
    Kundle onSaveState();
}
