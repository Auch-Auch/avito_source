package com.avito.android.remote.model.vas.list;

import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB5\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Discount;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "", "amount", "I", "getAmount", "()I", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/vas/list/Discount$Limit;", "limit", "Lcom/avito/android/remote/model/vas/list/Discount$Limit;", "getLimit", "()Lcom/avito/android/remote/model/vas/list/Discount$Limit;", "<init>", "(ILcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/vas/list/Discount$Limit;)V", "Limit", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Discount implements VasElement {
    @SerializedName("amount")
    private final int amount;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("icon")
    @Nullable
    private final Image icon;
    @SerializedName("limit")
    @Nullable
    private final Limit limit;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Discount$Limit;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "dueDate", "J", "getDueDate", "()J", "<init>", "(Ljava/lang/String;J)V", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Limit {
        @SerializedName("dueDate")
        private final long dueDate;
        @SerializedName("title")
        @Nullable
        private final String title;

        public Limit(@Nullable String str, long j) {
            this.title = str;
            this.dueDate = j;
        }

        public final long getDueDate() {
            return this.dueDate;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    public Discount(int i, @Nullable Image image, @NotNull String str, @Nullable String str2, @Nullable Limit limit2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.amount = i;
        this.icon = image;
        this.title = str;
        this.description = str2;
        this.limit = limit2;
    }

    public final int getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getIcon() {
        return this.icon;
    }

    @Nullable
    public final Limit getLimit() {
        return this.limit;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
