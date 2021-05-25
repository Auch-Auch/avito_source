package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002*+BI\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\"\u0010\"\u001a\u00020!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/WitcherElement;", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "titleText", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "selectionType", "Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "getSelectionType", "()Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "buttonText", "getButtonText", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "<init>", "(Lcom/avito/android/remote/model/WitcherElement$SelectionType;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "SelectionType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherElement implements SerpElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<WitcherElement> CREATOR = Parcels.creator(WitcherElement$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("button_text")
    @Nullable
    private final String buttonText;
    @SerializedName("deeplink")
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("items")
    @Nullable
    private final List<SerpElement> items;
    @SerializedName("selection_type")
    @Nullable
    private final SelectionType selectionType;
    @SerializedName("title_text")
    @Nullable
    private final String titleText;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/WitcherElement$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/WitcherElement;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "SELECTED", "SCROLLABLE", "SCROLLABLE_CLICKABLE_HEADER", "MARKETPLACE", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum SelectionType {
        REGULAR,
        SELECTED,
        SCROLLABLE,
        SCROLLABLE_CLICKABLE_HEADER,
        MARKETPLACE
    }

    public WitcherElement() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public WitcherElement(@Nullable SelectionType selectionType2, @Nullable DeepLink deepLink2, @Nullable List<? extends SerpElement> list, @Nullable String str, @Nullable String str2) {
        this.selectionType = selectionType2;
        this.deepLink = deepLink2;
        this.items = list;
        this.buttonText = str;
        this.titleText = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final List<SerpElement> getItems() {
        return this.items;
    }

    @Nullable
    public final SelectionType getSelectionType() {
        return this.selectionType;
    }

    @Nullable
    public final String getTitleText() {
        return this.titleText;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptEnum(parcel, this.selectionType);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeList(this.items);
        parcel.writeString(this.buttonText);
        parcel.writeString(this.titleText);
        parcel.writeLong(getUniqueId());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WitcherElement(SelectionType selectionType2, DeepLink deepLink2, List list, String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? null : selectionType2, (i & 2) == 0 ? deepLink2 : null, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2);
    }
}
