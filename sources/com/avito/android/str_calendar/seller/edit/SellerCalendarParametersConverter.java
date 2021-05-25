package com.avito.android.str_calendar.seller.edit;

import com.avito.android.remote.model.category_parameters.GroupParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R4\u0010!\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001b0\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "", "", "Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "formFields", "", "convert", "(Ljava/util/List;)V", "", "paramId", "newValue", "onParameterValueChanged", "(Ljava/lang/String;Ljava/lang/String;)V", "", "convertToMap", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "setParametersTree", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "parametersTree", "getErrorsMap", "setErrorsMap", "(Ljava/util/Map;)V", "errorsMap", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/avito/conveyor_item/Item;", "", "", "getItemsObservable", "()Lio/reactivex/Observable;", "itemsObservable", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCalendarParametersConverter {
    void convert(@NotNull List<GroupParameter> list);

    @NotNull
    Map<String, String> convertToMap();

    @NotNull
    Map<String, String> getErrorsMap();

    @NotNull
    Observable<Pair<List<Item>, Set<Integer>>> getItemsObservable();

    @Nullable
    ParametersTree getParametersTree();

    void onParameterValueChanged(@NotNull String str, @NotNull String str2);

    void setErrorsMap(@NotNull Map<String, String> map);

    void setParametersTree(@Nullable ParametersTree parametersTree);
}
