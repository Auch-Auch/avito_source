package com.avito.android.remote.model.adverts;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.remote.model.CategoryModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "", "<init>", "()V", "Duplicate", "Ok", "WrongCategory", "WrongCategorySuggest", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Ok;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Duplicate;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategory;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertProactiveModerationResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Duplicate;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "duplicateBody", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "getDuplicateBody", "()Lcom/avito/android/remote/model/AdvertDuplicateResult;", "<init>", "(Lcom/avito/android/remote/model/AdvertDuplicateResult;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Duplicate extends AdvertProactiveModerationResult {
        @SerializedName("result")
        @NotNull
        private final AdvertDuplicateResult duplicateBody;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Duplicate(@NotNull AdvertDuplicateResult advertDuplicateResult) {
            super(null);
            Intrinsics.checkNotNullParameter(advertDuplicateResult, "duplicateBody");
            this.duplicateBody = advertDuplicateResult;
        }

        @NotNull
        public final AdvertDuplicateResult getDuplicateBody() {
            return this.duplicateBody;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$Ok;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends AdvertProactiveModerationResult {
        public Ok() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategory;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult;", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "wrongCategorySuggest", "Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "getWrongCategorySuggest", "()Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "<init>", "(Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class WrongCategory extends AdvertProactiveModerationResult {
        @SerializedName("result")
        @NotNull
        private final WrongCategorySuggest wrongCategorySuggest;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WrongCategory(@NotNull WrongCategorySuggest wrongCategorySuggest2) {
            super(null);
            Intrinsics.checkNotNullParameter(wrongCategorySuggest2, "wrongCategorySuggest");
            this.wrongCategorySuggest = wrongCategorySuggest2;
        }

        @NotNull
        public final WrongCategorySuggest getWrongCategorySuggest() {
            return this.wrongCategorySuggest;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/adverts/AdvertProactiveModerationResult$WrongCategorySuggest;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/CategoryModel;", "selectedCategory", "Lcom/avito/android/remote/model/CategoryModel;", "getSelectedCategory", "()Lcom/avito/android/remote/model/CategoryModel;", "", "categories", "Ljava/util/List;", "getCategories", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/CategoryModel;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class WrongCategorySuggest implements Parcelable {
        public static final Parcelable.Creator<WrongCategorySuggest> CREATOR = new Creator();
        @SerializedName("list")
        @NotNull
        private final List<CategoryModel> categories;
        @SerializedName("selectedCategory")
        @NotNull
        private final CategoryModel selectedCategory;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<WrongCategorySuggest> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final WrongCategorySuggest createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CategoryModel) parcel.readParcelable(WrongCategorySuggest.class.getClassLoader()));
                    readInt--;
                }
                return new WrongCategorySuggest(arrayList, (CategoryModel) parcel.readParcelable(WrongCategorySuggest.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final WrongCategorySuggest[] newArray(int i) {
                return new WrongCategorySuggest[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.CategoryModel> */
        /* JADX WARN: Multi-variable type inference failed */
        public WrongCategorySuggest(@NotNull List<? extends CategoryModel> list, @NotNull CategoryModel categoryModel) {
            Intrinsics.checkNotNullParameter(list, "categories");
            Intrinsics.checkNotNullParameter(categoryModel, "selectedCategory");
            this.categories = list;
            this.selectedCategory = categoryModel;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<CategoryModel> getCategories() {
            return this.categories;
        }

        @NotNull
        public final CategoryModel getSelectedCategory() {
            return this.selectedCategory;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Iterator n0 = a.n0(this.categories, parcel);
            while (n0.hasNext()) {
                parcel.writeParcelable((CategoryModel) n0.next(), i);
            }
            parcel.writeParcelable(this.selectedCategory, i);
        }
    }

    private AdvertProactiveModerationResult() {
    }

    public /* synthetic */ AdvertProactiveModerationResult(j jVar) {
        this();
    }
}
