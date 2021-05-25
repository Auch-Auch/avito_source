package com.avito.android.suggest_locations.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationsDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "()I", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areContentsTheSame", "(II)Z", "areItemsTheSame", "", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getNew", "()Ljava/util/List;", AppSettingsData.STATUS_NEW, AuthSource.SEND_ABUSE, "getOld", "old", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsDiffCallback extends DiffUtil.Callback {
    @NotNull
    public final List<SuggestLocationItem> a;
    @NotNull
    public final List<SuggestLocationItem> b;

    public SuggestLocationsDiffCallback(@NotNull List<SuggestLocationItem> list, @NotNull List<SuggestLocationItem> list2) {
        Intrinsics.checkNotNullParameter(list, "old");
        Intrinsics.checkNotNullParameter(list2, AppSettingsData.STATUS_NEW);
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.a.get(i), this.b.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.a.get(i).getId(), this.b.get(i2).getId());
    }

    @NotNull
    public final List<SuggestLocationItem> getNew() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.b.size();
    }

    @NotNull
    public final List<SuggestLocationItem> getOld() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
