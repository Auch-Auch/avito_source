package com.avito.android.remote.model.change;

import a2.b.a.a.a;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/change/Tariff;", "", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "Lcom/avito/android/remote/model/change/BenefitInfo;", "benefits", "Ljava/util/List;", "getBenefits", "()Ljava/util/List;", "", "price", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "", "isSelected", "Z", "()Z", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/Action;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class Tariff {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("benefitsList")
    @NotNull
    private final List<BenefitInfo> benefits;
    @SerializedName("isSelected")
    private final boolean isSelected;
    @SerializedName("price")
    @NotNull
    private final String price;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Tariff(@NotNull String str, @NotNull String str2, boolean z, @Nullable Action action2, @NotNull List<BenefitInfo> list) {
        a.c1(str, "title", str2, "price", list, "benefits");
        this.title = str;
        this.price = str2;
        this.isSelected = z;
        this.action = action2;
        this.benefits = list;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final List<BenefitInfo> getBenefits() {
        return this.benefits;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
