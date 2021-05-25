package com.avito.android.select.new_metro.adapter.selected_stations;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000e\u001a\u00020\u00052!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00138&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "items", "", "showStations", "(Ljava/util/List;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSelectedStationClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setOnExpandedClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "getMinLines", "()I", "setMinLines", "(I)V", "minLines", "", "getShowAll", "()Z", "setShowAll", "(Z)V", "showAll", "select_release"}, k = 1, mv = {1, 4, 2})
public interface MetroSelectedStationsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MetroSelectedStationsItemView metroSelectedStationsItemView) {
            ItemView.DefaultImpls.onUnbind(metroSelectedStationsItemView);
        }
    }

    int getMinLines();

    boolean getShowAll();

    void setMinLines(int i);

    void setOnExpandedClickListener(@NotNull Function0<Unit> function0);

    void setOnSelectedStationClickListener(@NotNull Function1<? super String, Unit> function1);

    void setShowAll(boolean z);

    void showStations(@NotNull List<SelectedStationInfo> list);
}
