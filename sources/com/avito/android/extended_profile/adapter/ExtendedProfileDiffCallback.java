package com.avito.android.extended_profile.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItem;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/extended_profile/adapter/ExtendedProfileDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "areContentsTheSame", "", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "newList", AuthSource.SEND_ABUSE, "oldList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileDiffCallback extends DiffUtil.Callback {
    public final List<ExtendedProfileListItem> a;
    public final List<ExtendedProfileListItem> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.extended_profile.adapter.ExtendedProfileListItem> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.extended_profile.adapter.ExtendedProfileListItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedProfileDiffCallback(@NotNull List<? extends ExtendedProfileListItem> list, @NotNull List<? extends ExtendedProfileListItem> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        ExtendedProfileListItem extendedProfileListItem = this.a.get(i);
        ExtendedProfileListItem extendedProfileListItem2 = this.b.get(i2);
        if ((extendedProfileListItem instanceof CategoryAdvertItem) && (extendedProfileListItem2 instanceof CategoryAdvertItem)) {
            CategoryAdvertItem categoryAdvertItem = (CategoryAdvertItem) extendedProfileListItem;
            CategoryAdvertItem categoryAdvertItem2 = (CategoryAdvertItem) extendedProfileListItem2;
            if (Intrinsics.areEqual(categoryAdvertItem.getAdvert().getStringId(), categoryAdvertItem2.getAdvert().getStringId()) && categoryAdvertItem.getAdvert().isFavorite() == categoryAdvertItem2.getAdvert().isFavorite() && categoryAdvertItem.getAdvert().isViewed() == categoryAdvertItem2.getAdvert().isViewed()) {
                return true;
            }
        } else if (!(extendedProfileListItem instanceof BadgeBarItem) || !(extendedProfileListItem2 instanceof BadgeBarItem)) {
            return Intrinsics.areEqual(extendedProfileListItem, extendedProfileListItem2);
        } else {
            BadgeBarItem badgeBarItem = (BadgeBarItem) extendedProfileListItem;
            BadgeBarItem badgeBarItem2 = (BadgeBarItem) extendedProfileListItem2;
            if (badgeBarItem.getBadges().size() == badgeBarItem2.getBadges().size()) {
                List<BadgeItem> badges = badgeBarItem.getBadges();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(badges, 10));
                Iterator<T> it = badges.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(it.next().getBadgeId()));
                }
                List<BadgeItem> badges2 = badgeBarItem2.getBadges();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(badges2, 10));
                Iterator<T> it2 = badges2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(it2.next().getBadgeId()));
                }
                if (arrayList.containsAll(arrayList2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.a.get(i) == this.b.get(i2);
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
