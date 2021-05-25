package com.avito.android.remote.model.vas.list;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Statistic;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001,B_\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u001e\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010!\u001a\u00020 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Package;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Statistic;", "statistics", "Lcom/avito/android/remote/model/Statistic;", "getStatistics", "()Lcom/avito/android/remote/model/Statistic;", "", "Lcom/avito/android/remote/model/vas/list/Package$Service;", VKApiConst.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "viewsMultiplier", "getViewsMultiplier", "name", "getName", "Lcom/avito/android/remote/model/vas/list/Price;", "price", "Lcom/avito/android/remote/model/vas/list/Price;", "getPrice", "()Lcom/avito/android/remote/model/vas/list/Price;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/vas/list/Price;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Statistic;Lcom/avito/android/remote/model/Action;)V", "Service", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Package implements VasElement {
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
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final List<Service> services;
    @SerializedName("statistic")
    @Nullable
    private final Statistic statistics;
    @SerializedName("viewsMultiplier")
    @Nullable
    private final String viewsMultiplier;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Package$Service;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Service {
        @SerializedName("icon")
        @NotNull
        private final Image icon;
        @SerializedName("id")
        @NotNull
        private final String id;

        public Service(@NotNull String str, @NotNull Image image) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(image, "icon");
            this.id = str;
            this.icon = image;
        }

        @NotNull
        public final Image getIcon() {
            return this.icon;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    public Package(@NotNull String str, @NotNull String str2, @NotNull Image image, @NotNull Price price2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable List<Service> list, @Nullable Statistic statistic, @Nullable Action action2) {
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
        this.services = list;
        this.statistics = statistic;
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
    public final List<Service> getServices() {
        return this.services;
    }

    @Nullable
    public final Statistic getStatistics() {
        return this.statistics;
    }

    @Nullable
    public final String getViewsMultiplier() {
        return this.viewsMultiplier;
    }
}
