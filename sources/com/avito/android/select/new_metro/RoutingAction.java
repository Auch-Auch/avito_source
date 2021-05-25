package com.avito.android.select.new_metro;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/select/new_metro/RoutingAction;", "", "<init>", "()V", "CancelAction", "ConfirmAction", "Lcom/avito/android/select/new_metro/RoutingAction$CancelAction;", "Lcom/avito/android/select/new_metro/RoutingAction$ConfirmAction;", "select_release"}, k = 1, mv = {1, 4, 2})
public abstract class RoutingAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/select/new_metro/RoutingAction$CancelAction;", "Lcom/avito/android/select/new_metro/RoutingAction;", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelAction extends RoutingAction {
        @NotNull
        public static final CancelAction INSTANCE = new CancelAction();

        public CancelAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/select/new_metro/RoutingAction$ConfirmAction;", "Lcom/avito/android/select/new_metro/RoutingAction;", "", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getSelected", "()Ljava/util/List;", "selected", "<init>", "(Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
    public static final class ConfirmAction extends RoutingAction {
        @NotNull
        public final List<MetroStationItem> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConfirmAction(@NotNull List<MetroStationItem> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "selected");
            this.a = list;
        }

        @NotNull
        public final List<MetroStationItem> getSelected() {
            return this.a;
        }
    }

    public RoutingAction() {
    }

    public RoutingAction(j jVar) {
    }
}
