package com.avito.android.search.filter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0011H&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(H&¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020(H&¢\u0006\u0004\b,\u0010-J\u0011\u0010/\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00112\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00112\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b5\u00104J\u0019\u00108\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u000106H&¢\u0006\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/avito/android/search/filter/FiltersInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "parametersTreeStream", "()Lio/reactivex/rxjava3/core/Observable;", "", "skipCurrentState", "Lcom/avito/android/remote/model/counter/CounterButton;", "counterButtonStream", "(Z)Lio/reactivex/rxjava3/core/Observable;", "T", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "value", "ignoreUpdatesForm", "", "applyParameterValue", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/lang/Object;Z)V", "Landroid/app/Activity;", "activity", "findCoordinates", "(Landroid/app/Activity;)V", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "hasSearchArea", "()Z", "isRenamedSearchLocation", "()Ljava/lang/Boolean;", "sendScreenExitAfterCoordinatesResolve", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "updateStateBySearchParams", "(Lcom/avito/android/remote/model/SearchParams;)V", "getSearchParamsOrEmpty", "()Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getMetroWithLines", "()Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "Landroid/content/Context;", "context", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "Landroid/view/View;", "view", "subscribeOnNotPermissionGranted", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface FiltersInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void applyParameterValue$default(FiltersInteractor filtersInteractor, EditableParameter editableParameter, Object obj, boolean z, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                filtersInteractor.applyParameterValue(editableParameter, obj, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyParameterValue");
        }

        public static /* synthetic */ void onLocationNotFound$default(FiltersInteractor filtersInteractor, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                filtersInteractor.onLocationNotFound(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLocationNotFound");
        }
    }

    <T> void applyParameterValue(@NotNull EditableParameter<T> editableParameter, @Nullable T t, boolean z);

    @NotNull
    Observable<LoadingState<CounterButton>> counterButtonStream(boolean z);

    void findCoordinates(@NotNull Activity activity);

    @NotNull
    DeepLink getDeepLink();

    @Nullable
    MetroResponseBody getMetroWithLines();

    @NotNull
    SearchParams getSearchParamsOrEmpty();

    boolean hasSearchArea();

    @Nullable
    Boolean isRenamedSearchLocation();

    void onLocationNotFound(@Nullable String str);

    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<LoadingState<ParametersTreeWithAdditional>> parametersTreeStream();

    void registerLocationReceiver(@NotNull Context context);

    void sendScreenExitAfterCoordinatesResolve();

    void subscribeOnNotPermissionGranted(@Nullable View view);

    void unregisterLocationReceiver(@NotNull Context context);

    void updateStateBySearchParams(@Nullable SearchParams searchParams);
}
