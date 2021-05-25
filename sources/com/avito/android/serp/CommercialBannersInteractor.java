package com.avito.android.serp;

import com.avito.android.remote.model.CommercialBanner;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/CommercialBannersInteractor;", "", "Lcom/avito/android/remote/model/CommercialBanner;", "banner", "", "pageCdtm", "", "categoryId", "locationId", "Lio/reactivex/rxjava3/core/Observable;", "loadBanner", "(Lcom/avito/android/remote/model/CommercialBanner;JLjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getPageCdtm", "()J", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface CommercialBannersInteractor {
    long getPageCdtm();

    @NotNull
    Observable<CommercialBanner> loadBanner(@NotNull CommercialBanner commercialBanner, long j, @Nullable String str, @Nullable String str2);
}
