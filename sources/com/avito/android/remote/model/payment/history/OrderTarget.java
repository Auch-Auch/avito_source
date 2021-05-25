package com.avito.android.remote.model.payment.history;

import a2.b.a.a.a;
import com.avito.android.remote.model.Image;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/history/OrderTarget;", "", "<init>", "()V", "Advert", "Base", "Lcom/avito/android/remote/model/payment/history/OrderTarget$Advert;", "Lcom/avito/android/remote/model/payment/history/OrderTarget$Base;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class OrderTarget {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJT\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\nR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\r¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/payment/history/OrderTarget$Advert;", "Lcom/avito/android/remote/model/payment/history/OrderTarget;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "", "component6", "()Ljava/util/List;", "id", "title", "description", "amount", "image", VKApiConst.SERVICES, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;)Lcom/avito/android/remote/model/payment/history/OrderTarget$Advert;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAmount", "getDescription", "getId", "getTitle", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/util/List;", "getServices", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Advert extends OrderTarget {
        @SerializedName("price")
        @Nullable
        private final String amount;
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL)
        @NotNull
        private final Image image;
        @SerializedName(VKApiConst.SERVICES)
        @NotNull
        private final List<String> services;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Advert(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Image image2, @NotNull List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
            this.id = str;
            this.title = str2;
            this.description = str3;
            this.amount = str4;
            this.image = image2;
            this.services = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.payment.history.OrderTarget$Advert */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Advert copy$default(Advert advert, String str, String str2, String str3, String str4, Image image2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = advert.id;
            }
            if ((i & 2) != 0) {
                str2 = advert.title;
            }
            if ((i & 4) != 0) {
                str3 = advert.description;
            }
            if ((i & 8) != 0) {
                str4 = advert.amount;
            }
            if ((i & 16) != 0) {
                image2 = advert.image;
            }
            if ((i & 32) != 0) {
                list = advert.services;
            }
            return advert.copy(str, str2, str3, str4, image2, list);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.description;
        }

        @Nullable
        public final String component4() {
            return this.amount;
        }

        @NotNull
        public final Image component5() {
            return this.image;
        }

        @NotNull
        public final List<String> component6() {
            return this.services;
        }

        @NotNull
        public final Advert copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Image image2, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
            return new Advert(str, str2, str3, str4, image2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Advert)) {
                return false;
            }
            Advert advert = (Advert) obj;
            return Intrinsics.areEqual(this.id, advert.id) && Intrinsics.areEqual(this.title, advert.title) && Intrinsics.areEqual(this.description, advert.description) && Intrinsics.areEqual(this.amount, advert.amount) && Intrinsics.areEqual(this.image, advert.image) && Intrinsics.areEqual(this.services, advert.services);
        }

        @Nullable
        public final String getAmount() {
            return this.amount;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @NotNull
        public final List<String> getServices() {
            return this.services;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.amount;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode5 = (hashCode4 + (image2 != null ? image2.hashCode() : 0)) * 31;
            List<String> list = this.services;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Advert(id=");
            L.append(this.id);
            L.append(", title=");
            L.append(this.title);
            L.append(", description=");
            L.append(this.description);
            L.append(", amount=");
            L.append(this.amount);
            L.append(", image=");
            L.append(this.image);
            L.append(", services=");
            return a.w(L, this.services, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/payment/history/OrderTarget$Base;", "Lcom/avito/android/remote/model/payment/history/OrderTarget;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/payment/history/OrderTarget$Base;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Base extends OrderTarget {
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Base(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        public static /* synthetic */ Base copy$default(Base base, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = base.title;
            }
            return base.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final Base copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Base(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Base) && Intrinsics.areEqual(this.title, ((Base) obj).title);
            }
            return true;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Base(title="), this.title, ")");
        }
    }

    private OrderTarget() {
    }

    public /* synthetic */ OrderTarget(j jVar) {
        this();
    }
}
