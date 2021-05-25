package com.avito.android.vas_performance.repository;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\bJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000bJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\bJ9\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/vas_performance/repository/VasRepository;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "getPerformanceVas", "(Ljava/lang/String;)Lio/reactivex/Observable;", "checkoutContext", "getPerformanceVasV2", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/vas/visual/VasVisualResult;", "getVisualVas", "getVisualVasNew", "Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;", "getAppliedVas", "", "slugs", "Lcom/avito/android/remote/model/DeepLinkResponse;", "getVasContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Observable;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface VasRepository {
    @NotNull
    Observable<LoadingState<AppliedVasResult>> getAppliedVas(@NotNull String str);

    @NotNull
    Observable<LoadingState<VasPerformanceResult>> getPerformanceVas(@NotNull String str);

    @NotNull
    Observable<LoadingState<VasPerformanceResult>> getPerformanceVasV2(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<DeepLinkResponse>> getVasContext(@NotNull String str, @NotNull String str2, @NotNull Set<String> set);

    @NotNull
    Observable<LoadingState<VasVisualResult>> getVisualVas(@NotNull String str);

    @NotNull
    Observable<LoadingState<VasVisualResult>> getVisualVasNew(@NotNull String str, @NotNull String str2);
}
