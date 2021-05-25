package com.avito.android.extended_profile.data;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItem;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010$\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/extended_profile/data/CategoryData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;", "c", "Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;", "getButtonItem", "()Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;", "setButtonItem", "(Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;)V", "buttonItem", "", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getAdvertItems", "()Ljava/util/List;", "setAdvertItems", "(Ljava/util/List;)V", "advertItems", "", "d", "Ljava/lang/String;", "getLoadMoreUri", "()Ljava/lang/String;", "setLoadMoreUri", "(Ljava/lang/String;)V", "loadMoreUri", "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", "getHeaderItem", "()Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;", "setHeaderItem", "(Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;)V", "headerItem", "<init>", "(Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItem;Ljava/util/List;Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItem;Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryData implements Parcelable {
    public static final Parcelable.Creator<CategoryData> CREATOR = new Creator();
    @Nullable
    public CategoryHeaderItem a;
    @NotNull
    public List<CategoryAdvertItem> b;
    @Nullable
    public CategoryButtonItem c;
    @Nullable
    public String d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            CategoryButtonItem categoryButtonItem = null;
            CategoryHeaderItem createFromParcel = parcel.readInt() != 0 ? CategoryHeaderItem.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(CategoryAdvertItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                categoryButtonItem = CategoryButtonItem.CREATOR.createFromParcel(parcel);
            }
            return new CategoryData(createFromParcel, arrayList, categoryButtonItem, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryData[] newArray(int i) {
            return new CategoryData[i];
        }
    }

    public CategoryData() {
        this(null, null, null, null, 15, null);
    }

    public CategoryData(@Nullable CategoryHeaderItem categoryHeaderItem, @NotNull List<CategoryAdvertItem> list, @Nullable CategoryButtonItem categoryButtonItem, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "advertItems");
        this.a = categoryHeaderItem;
        this.b = list;
        this.c = categoryButtonItem;
        this.d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<CategoryAdvertItem> getAdvertItems() {
        return this.b;
    }

    @Nullable
    public final CategoryButtonItem getButtonItem() {
        return this.c;
    }

    @Nullable
    public final CategoryHeaderItem getHeaderItem() {
        return this.a;
    }

    @Nullable
    public final String getLoadMoreUri() {
        return this.d;
    }

    public final void setAdvertItems(@NotNull List<CategoryAdvertItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    public final void setButtonItem(@Nullable CategoryButtonItem categoryButtonItem) {
        this.c = categoryButtonItem;
    }

    public final void setHeaderItem(@Nullable CategoryHeaderItem categoryHeaderItem) {
        this.a = categoryHeaderItem;
    }

    public final void setLoadMoreUri(@Nullable String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CategoryHeaderItem categoryHeaderItem = this.a;
        if (categoryHeaderItem != null) {
            parcel.writeInt(1);
            categoryHeaderItem.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            ((CategoryAdvertItem) n0.next()).writeToParcel(parcel, 0);
        }
        CategoryButtonItem categoryButtonItem = this.c;
        if (categoryButtonItem != null) {
            parcel.writeInt(1);
            categoryButtonItem.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryData(CategoryHeaderItem categoryHeaderItem, List list, CategoryButtonItem categoryButtonItem, String str, int i, j jVar) {
        this((i & 1) != 0 ? null : categoryHeaderItem, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? null : categoryButtonItem, (i & 8) != 0 ? null : str);
    }
}
