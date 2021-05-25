package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import com.avito.android.str_calendar.seller.calendar.data.Status;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProviderImpl;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "Lcom/avito/android/str_calendar/seller/calendar/data/Status;", "primaryStatus", "secondaryStatus", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "primaryPosition", "secondaryPosition", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/Background;", "getBackground", "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/Background;", VKApiConst.POSITION, "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;)Ljava/lang/Integer;", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "selectedBackgrounds", "bookedBackgrounds", "c", "unavailableBackgrounds", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItemBackgroundsProviderImpl implements SellerDayItemBackgroundsProvider {
    public final Map<Position, Integer> a;
    public final Map<Position, Integer> b;
    public final Map<Position, Integer> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Status.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            Status.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
        }
    }

    public SellerDayItemBackgroundsProviderImpl() {
        Position position = Position.LEFT;
        Position position2 = Position.RIGHT;
        Position position3 = Position.MIDDLE;
        Position position4 = Position.SINGLE;
        this.a = r.mapOf(TuplesKt.to(position, Integer.valueOf(R.drawable.str_calendar_seller_booked_day_left_background)), TuplesKt.to(position2, Integer.valueOf(R.drawable.str_calendar_seller_booked_day_right_background)), TuplesKt.to(position3, Integer.valueOf(R.drawable.str_calendar_seller_booked_day_background)), TuplesKt.to(position4, Integer.valueOf(R.drawable.str_calendar_seller_booked_day_single_background)));
        this.b = r.mapOf(TuplesKt.to(position, Integer.valueOf(R.drawable.str_calendar_seller_selected_day_left_background)), TuplesKt.to(position2, Integer.valueOf(R.drawable.str_calendar_seller_selected_day_right_background)), TuplesKt.to(position3, Integer.valueOf(R.drawable.str_calendar_seller_selected_day_background)), TuplesKt.to(position4, Integer.valueOf(R.drawable.str_calendar_seller_selected_single_day_background)));
        this.c = r.mapOf(TuplesKt.to(position, Integer.valueOf(R.drawable.str_calendar_seller_unavailable_day_left_background)), TuplesKt.to(position2, Integer.valueOf(R.drawable.str_calendar_seller_unavailable_day_right_background)), TuplesKt.to(position3, Integer.valueOf(R.drawable.str_calendar_seller_unavailable_day_background)), TuplesKt.to(position4, Integer.valueOf(R.drawable.str_calendar_seller_unavailable_day_single_background)));
    }

    @DrawableRes
    public final Integer a(Status status, Position position) {
        int ordinal = status.ordinal();
        if (ordinal == 0) {
            return this.b.get(position);
        }
        if (ordinal != 1) {
            return Integer.valueOf(R.drawable.str_calendar_seller_day_selectable_background);
        }
        return Integer.valueOf(R.drawable.str_calendar_seller_current_day_background);
    }

    @Override // com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBackgroundsProvider
    @NotNull
    public Background getBackground(@NotNull Status status, @NotNull Status status2, @NotNull Position position, @NotNull Position position2) {
        Intrinsics.checkNotNullParameter(status, "primaryStatus");
        Intrinsics.checkNotNullParameter(status2, "secondaryStatus");
        Intrinsics.checkNotNullParameter(position, "primaryPosition");
        Intrinsics.checkNotNullParameter(position2, "secondaryPosition");
        int ordinal = status.ordinal();
        if (ordinal == 2) {
            return new Background(this.a.get(position), a(status2, position2));
        }
        if (ordinal == 3) {
            return new Background(this.c.get(position), a(status2, position2));
        }
        if (ordinal != 5) {
            return new Background(null, null, 3, null);
        }
        return new Background(null, a(status2, position2), 1, null);
    }
}
