package com.avito.android.advert_stats;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.advert_stats.item.PlotItem;
import com.avito.android.advert_stats.item.details.StatDetailItem;
import com.avito.android.advert_stats.item.hint.HintItem;
import com.avito.android.advert_stats.item.period.PeriodItem;
import com.avito.android.advert_stats.item.title.TitleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_stats/StatsCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "", "Lcom/avito/conveyor_item/Item;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "newList", AuthSource.SEND_ABUSE, "oldList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatsCallback extends DiffUtil.Callback {
    public final List<Item> a;
    public final List<Item> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public StatsCallback(@NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        Item item = this.a.get(i);
        Item item2 = this.b.get(i2);
        if ((item instanceof StatDetailItem) && (item2 instanceof StatDetailItem)) {
            StatDetailItem statDetailItem = (StatDetailItem) item;
            StatDetailItem statDetailItem2 = (StatDetailItem) item2;
            if (!Intrinsics.areEqual(statDetailItem.getText(), statDetailItem2.getText()) || statDetailItem.isHidden() != statDetailItem2.isHidden()) {
                return false;
            }
            return true;
        } else if ((item instanceof PeriodItem) && (item2 instanceof PeriodItem)) {
            PeriodItem periodItem = (PeriodItem) item;
            PeriodItem periodItem2 = (PeriodItem) item2;
            if (!Intrinsics.areEqual(periodItem.getPeriod(), periodItem2.getPeriod()) || periodItem.isHidden() != periodItem2.isHidden()) {
                return false;
            }
            return true;
        } else if ((item instanceof TitleItem) && (item2 instanceof TitleItem)) {
            return Intrinsics.areEqual(((TitleItem) item).getText(), ((TitleItem) item2).getText());
        } else {
            if (!(item instanceof HintItem) || !(item2 instanceof HintItem)) {
                return (item instanceof PlotItem) && (item2 instanceof PlotItem);
            }
            return Intrinsics.areEqual(((HintItem) item).getTitle(), ((HintItem) item2).getTitle());
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        Item item = this.a.get(i);
        Item item2 = this.b.get(i2);
        if ((item instanceof StatDetailItem) && (item2 instanceof StatDetailItem)) {
            return Intrinsics.areEqual(item.getStringId(), item2.getStringId());
        }
        if ((item instanceof PeriodItem) && (item2 instanceof PeriodItem)) {
            return Intrinsics.areEqual(item.getStringId(), item2.getStringId());
        }
        if ((item instanceof PlotItem) && (item2 instanceof PlotItem)) {
            return true;
        }
        if ((item instanceof TitleItem) && (item2 instanceof TitleItem)) {
            return true;
        }
        if ((!(item instanceof HintItem) || !(item2 instanceof HintItem)) && this.a.get(i).getId() != this.b.get(i2).getId()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
