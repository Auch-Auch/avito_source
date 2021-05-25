package com.avito.android.profile.edit.refactoring.adapter;

import com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay;
import com.avito.android.profile.edit.refactoring.adapter.item.ErrorLabelItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00000\b2\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00000\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00000\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00000\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002*\b\u0012\u0004\u0012\u00020\u00000\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "T", "", "", "itemId", "getItem", "(Ljava/util/List;J)Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "findItem", "", "targetItem", "", "replaceItem", "(Ljava/util/List;Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;)I", "item", "", "message", "", "showError", "(Ljava/util/List;Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;Ljava/lang/String;)V", "hideError", "(Ljava/util/List;Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;)V", "removeErrorForItem", "", "errors", "relateErrors", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "calculateErrorId", "(J)J", "", "hasError", AuthSource.SEND_ABUSE, "(Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;Z)Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class EditProfileItemsKt {
    public static final EditProfileItem a(EditProfileItem editProfileItem, boolean z) {
        ErrorDisplay errorDisplay = (ErrorDisplay) (!(editProfileItem instanceof ErrorDisplay) ? null : editProfileItem);
        return (errorDisplay == null || errorDisplay.getHasError() == z) ? editProfileItem : errorDisplay.changeHasError(z);
    }

    public static final long calculateErrorId(long j) {
        return Long.MAX_VALUE - j;
    }

    @Nullable
    public static final <T extends EditProfileItem> T findItem(@Nullable List<? extends EditProfileItem> list, long j) {
        T t;
        T t2;
        boolean z;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2.getId() == j) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            t = t2;
        } else {
            t = (T) null;
        }
        if (!(t instanceof EditProfileItem)) {
            return null;
        }
        return (T) t;
    }

    @NotNull
    public static final <T extends EditProfileItem> T getItem(@Nullable List<? extends EditProfileItem> list, long j) {
        T t = (T) findItem(list, j);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException();
    }

    public static final void hideError(@NotNull List<EditProfileItem> list, @Nullable EditProfileItem editProfileItem) {
        Intrinsics.checkNotNullParameter(list, "$this$hideError");
        if (editProfileItem != null && (editProfileItem instanceof ErrorDisplay)) {
            replaceItem(list, a(editProfileItem, false));
            removeErrorForItem(list, editProfileItem);
        }
    }

    @NotNull
    public static final List<EditProfileItem> relateErrors(@NotNull List<? extends EditProfileItem> list, @NotNull Map<Long, String> map) {
        Intrinsics.checkNotNullParameter(list, "$this$relateErrors");
        Intrinsics.checkNotNullParameter(map, "errors");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!(t instanceof ErrorLabelItem)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(a((EditProfileItem) it.next(), false));
        }
        List<EditProfileItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            showError(mutableList, findItem(mutableList, entry.getKey().longValue()), entry.getValue());
        }
        return mutableList;
    }

    public static final void removeErrorForItem(@NotNull List<EditProfileItem> list, @Nullable EditProfileItem editProfileItem) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "$this$removeErrorForItem");
        if (editProfileItem != null) {
            long calculateErrorId = calculateErrorId(editProfileItem.getId());
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.getId() == calculateErrorId) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                list.remove(t2);
            }
        }
    }

    public static final int replaceItem(@NotNull List<EditProfileItem> list, @NotNull EditProfileItem editProfileItem) {
        Intrinsics.checkNotNullParameter(list, "$this$replaceItem");
        Intrinsics.checkNotNullParameter(editProfileItem, "targetItem");
        Iterator<EditProfileItem> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getId() == editProfileItem.getId()) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            list.set(i, editProfileItem);
        }
        return i;
    }

    public static final void showError(@NotNull List<EditProfileItem> list, @Nullable EditProfileItem editProfileItem, @NotNull String str) {
        int indexOf;
        Intrinsics.checkNotNullParameter(list, "$this$showError");
        Intrinsics.checkNotNullParameter(str, "message");
        if (editProfileItem != null && (indexOf = list.indexOf(editProfileItem)) >= 0) {
            replaceItem(list, a(editProfileItem, true));
            long calculateErrorId = calculateErrorId(editProfileItem.getId());
            if (findItem(list, calculateErrorId) == null) {
                list.add(indexOf + 1, new ErrorLabelItem(calculateErrorId, str));
            }
        }
    }
}
