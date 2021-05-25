package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.ConstantsKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "getDisabled", "()Ljava/lang/Boolean;", "disabled", "", "getTitle", "()Ljava/lang/String;", "title", "<init>", "()V", "Access", "Buy", "Cart", ConstantsKt.LOG_TAG, "Phone", "Lcom/avito/android/remote/model/AdvertAction$Cart;", "Lcom/avito/android/remote/model/AdvertAction$Buy;", "Lcom/avito/android/remote/model/AdvertAction$Access;", "Lcom/avito/android/remote/model/AdvertAction$Messenger;", "Lcom/avito/android/remote/model/AdvertAction$Phone;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertAction implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction$Access;", "Lcom/avito/android/remote/model/AdvertAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "disabled", "Ljava/lang/Boolean;", "getDisabled", "()Ljava/lang/Boolean;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Access extends AdvertAction {
        public static final Parcelable.Creator<Access> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("disabled")
        @Nullable
        private final Boolean disabled;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Access> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Access createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Access.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Access(readString, deepLink, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Access[] newArray(int i) {
                return new Access[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Access(String str, DeepLink deepLink2, Boolean bool, int i, j jVar) {
            this(str, deepLink2, (i & 4) != 0 ? null : bool);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public Boolean getDisabled() {
            return this.disabled;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.disabled;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Access(@NotNull String str, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.deepLink = deepLink2;
            this.disabled = bool;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction$Buy;", "Lcom/avito/android/remote/model/AdvertAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "disabled", "Ljava/lang/Boolean;", "getDisabled", "()Ljava/lang/Boolean;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Buy extends AdvertAction {
        public static final Parcelable.Creator<Buy> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("disabled")
        @Nullable
        private final Boolean disabled;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Buy> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Buy createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Buy.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Buy(readString, deepLink, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Buy[] newArray(int i) {
                return new Buy[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Buy(String str, DeepLink deepLink2, Boolean bool, int i, j jVar) {
            this(str, deepLink2, (i & 4) != 0 ? null : bool);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public Boolean getDisabled() {
            return this.disabled;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.disabled;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Buy(@NotNull String str, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.deepLink = deepLink2;
            this.disabled = bool;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction$Cart;", "Lcom/avito/android/remote/model/AdvertAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "disabled", "Ljava/lang/Boolean;", "getDisabled", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/ParametrizedEvent;", "logEvent", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getLogEvent", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cart extends AdvertAction {
        public static final Parcelable.Creator<Cart> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("disabled")
        @Nullable
        private final Boolean disabled;
        @SerializedName(MarketplacePresenterKt.KEY_CONTACT_EVENT)
        @Nullable
        private final ParametrizedEvent logEvent;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Cart> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cart createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Cart.class.getClassLoader());
                ParametrizedEvent parametrizedEvent = null;
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                if (parcel.readInt() != 0) {
                    parametrizedEvent = ParametrizedEvent.CREATOR.createFromParcel(parcel);
                }
                return new Cart(readString, deepLink, bool, parametrizedEvent);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cart[] newArray(int i) {
                return new Cart[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Cart(String str, DeepLink deepLink2, Boolean bool, ParametrizedEvent parametrizedEvent, int i, j jVar) {
            this(str, deepLink2, (i & 4) != 0 ? null : bool, parametrizedEvent);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public Boolean getDisabled() {
            return this.disabled;
        }

        @Nullable
        public final ParametrizedEvent getLogEvent() {
            return this.logEvent;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.disabled;
            if (bool != null) {
                a.G0(parcel, 1, bool);
            } else {
                parcel.writeInt(0);
            }
            ParametrizedEvent parametrizedEvent = this.logEvent;
            if (parametrizedEvent != null) {
                parcel.writeInt(1);
                parametrizedEvent.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cart(@NotNull String str, @Nullable DeepLink deepLink2, @Nullable Boolean bool, @Nullable ParametrizedEvent parametrizedEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.deepLink = deepLink2;
            this.disabled = bool;
            this.logEvent = parametrizedEvent;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction$Messenger;", "Lcom/avito/android/remote/model/AdvertAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "disabled", "Ljava/lang/Boolean;", "getDisabled", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Messenger extends AdvertAction {
        public static final Parcelable.Creator<Messenger> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("disabled")
        @Nullable
        private final Boolean disabled;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Messenger> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Messenger createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Messenger.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Messenger(readString, deepLink, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Messenger[] newArray(int i) {
                return new Messenger[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Messenger(String str, DeepLink deepLink2, Boolean bool, int i, j jVar) {
            this(str, deepLink2, (i & 4) != 0 ? null : bool);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public Boolean getDisabled() {
            return this.disabled;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.disabled;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Messenger(@NotNull String str, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.deepLink = deepLink2;
            this.disabled = bool;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/AdvertAction$Phone;", "Lcom/avito/android/remote/model/AdvertAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "disabled", "Ljava/lang/Boolean;", "getDisabled", "()Ljava/lang/Boolean;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Phone extends AdvertAction {
        public static final Parcelable.Creator<Phone> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName("disabled")
        @Nullable
        private final Boolean disabled;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Phone> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Phone createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Phone.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Phone(readString, deepLink, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Phone[] newArray(int i) {
                return new Phone[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Phone(String str, DeepLink deepLink2, Boolean bool, int i, j jVar) {
            this(str, deepLink2, (i & 4) != 0 ? null : bool);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @Nullable
        public Boolean getDisabled() {
            return this.disabled;
        }

        @Override // com.avito.android.remote.model.AdvertAction
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.deepLink, i);
            Boolean bool = this.disabled;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Phone(@NotNull String str, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.deepLink = deepLink2;
            this.disabled = bool;
        }
    }

    private AdvertAction() {
    }

    @Nullable
    public abstract DeepLink getDeepLink();

    @Nullable
    public abstract Boolean getDisabled();

    @NotNull
    public abstract String getTitle();

    public /* synthetic */ AdvertAction(j jVar) {
        this();
    }
}
