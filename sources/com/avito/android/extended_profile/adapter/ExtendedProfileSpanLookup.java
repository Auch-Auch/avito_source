package com.avito.android.extended_profile.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", VKApiConst.POSITION, "getSpanSize", "(I)I", "", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "e", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items", "f", "I", "columnCount", "<init>", "(I)V", "GridItemType", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSpanLookup extends GridLayoutManager.SpanSizeLookup {
    @NotNull
    public List<? extends ExtendedProfileListItem> e = CollectionsKt__CollectionsKt.emptyList();
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_WIDTH", "SINGLE_SPAN", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public enum GridItemType {
        FULL_WIDTH,
        SINGLE_SPAN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GridItemType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    @Inject
    public ExtendedProfileSpanLookup(int i) {
        this.f = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.extended_profile.adapter.ExtendedProfileListItem>, java.util.List<com.avito.android.extended_profile.adapter.ExtendedProfileListItem> */
    @NotNull
    public final List<ExtendedProfileListItem> getItems() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        if (i >= this.e.size()) {
            return this.f;
        }
        int ordinal = ((ExtendedProfileListItem) this.e.get(i)).getGridItemType().ordinal();
        if (ordinal == 0) {
            return this.f;
        }
        if (ordinal == 1) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(@NotNull List<? extends ExtendedProfileListItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.e = list;
    }
}
