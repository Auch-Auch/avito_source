package com.avito.android.bottom_navigation;

import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTabSet;", "Ljava/util/LinkedHashSet;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "Lkotlin/collections/LinkedHashSet;", "", "tabs", "<init>", "([Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationTabSet extends LinkedHashSet<NavigationTabSetItem> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationTabSet(@NotNull NavigationTabSetItem... navigationTabSetItemArr) {
        super(ArraysKt___ArraysKt.toList(navigationTabSetItemArr));
        Intrinsics.checkNotNullParameter(navigationTabSetItemArr, "tabs");
    }

    public /* bridge */ boolean contains(NavigationTabSetItem navigationTabSetItem) {
        return super.contains((Object) navigationTabSetItem);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ boolean remove(NavigationTabSetItem navigationTabSetItem) {
        return super.remove((Object) navigationTabSetItem);
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof NavigationTabSetItem) {
            return contains((NavigationTabSetItem) obj);
        }
        return false;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof NavigationTabSetItem) {
            return remove((NavigationTabSetItem) obj);
        }
        return false;
    }
}
