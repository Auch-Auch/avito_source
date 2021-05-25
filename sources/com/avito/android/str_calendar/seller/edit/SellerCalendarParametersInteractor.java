package com.avito.android.str_calendar.seller.edit;

import com.avito.android.remote.model.StrSellerCalendarParameters;
import com.avito.android.remote.model.StrSellerCalendarParametersUpdateResponse;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrSellerCalendarParameters;", "getSellerCalendarBaseParameters", "(Ljava/lang/String;)Lio/reactivex/Observable;", "startDate", "endDate", "getSellerCalendarRangeParameters", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "paramsMap", "Lcom/avito/android/remote/model/StrSellerCalendarParametersUpdateResponse;", "submitParameters", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCalendarParametersInteractor {
    @NotNull
    Observable<LoadingState<StrSellerCalendarParameters>> getSellerCalendarBaseParameters(@NotNull String str);

    @NotNull
    Observable<LoadingState<StrSellerCalendarParameters>> getSellerCalendarRangeParameters(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @NotNull
    Observable<LoadingState<StrSellerCalendarParametersUpdateResponse>> submitParameters(@NotNull String str, @NotNull Map<String, String> map, @Nullable String str2, @Nullable String str3);

    @NotNull
    Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree);
}
