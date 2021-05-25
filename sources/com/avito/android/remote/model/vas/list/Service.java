package com.avito.android.remote.model.vas.list;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Statistic;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u00020\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Service;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "Lcom/avito/android/remote/model/vas/list/Price;", "price", "Lcom/avito/android/remote/model/vas/list/Price;", "getPrice", "()Lcom/avito/android/remote/model/vas/list/Price;", "", "viewsMultiplier", "Ljava/lang/String;", "getViewsMultiplier", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "id", "getId", "Lcom/avito/android/remote/model/Statistic;", "statistic", "Lcom/avito/android/remote/model/Statistic;", "getStatistic", "()Lcom/avito/android/remote/model/Statistic;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "name", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/vas/list/Price;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/Statistic;Lcom/avito/android/remote/model/Action;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Service implements VasElement {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final AttributedText description;
    @SerializedName("icon")
    @NotNull
    private final Image icon;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("price")
    @NotNull
    private final Price price;
    @SerializedName("statistic")
    @Nullable
    private final Statistic statistic;
    @SerializedName("viewsMultiplier")
    @Nullable
    private final String viewsMultiplier;

    public Service(@NotNull String str, @NotNull String str2, @NotNull Image image, @NotNull Price price2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable Statistic statistic2, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(image, "icon");
        Intrinsics.checkNotNullParameter(price2, "price");
        this.id = str;
        this.name = str2;
        this.icon = image;
        this.price = price2;
        this.description = attributedText;
        this.viewsMultiplier = str3;
        this.statistic = statistic2;
        this.action = action2;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.description;
    }

    @NotNull
    public final Image getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Price getPrice() {
        return this.price;
    }

    @Nullable
    public final Statistic getStatistic() {
        return this.statistic;
    }

    @Nullable
    public final String getViewsMultiplier() {
        return this.viewsMultiplier;
    }
}
