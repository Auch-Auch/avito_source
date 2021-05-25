package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ^\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\"\u0010\u0004R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\tR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/network/chat/response/SnapPoint;", "component3", "()Ljava/util/List;", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "keyboard", InternalConstsKt.PLACEHOLDER, "snapPoints", "suggestMode", "savedSearchID", "showSuggestImmediately", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyboard", "getSavedSearchID", "getSuggestMode", "getPlaceholder", "Ljava/util/List;", "getSnapPoints", "Ljava/lang/Boolean;", "getShowSuggestImmediately", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ElementParams {
    @SerializedName("keyboard")
    @Nullable
    private final String keyboard;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("savedSearch")
    @Nullable
    private final String savedSearchID;
    @SerializedName("showSuggestImmediately")
    @Nullable
    private final Boolean showSuggestImmediately;
    @SerializedName("snapPoints")
    @Nullable
    private final List<SnapPoint> snapPoints;
    @SerializedName("suggestMode")
    @Nullable
    private final String suggestMode;

    public ElementParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ElementParams(@Nullable String str, @Nullable String str2, @Nullable List<SnapPoint> list, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool) {
        this.keyboard = str;
        this.placeholder = str2;
        this.snapPoints = list;
        this.suggestMode = str3;
        this.savedSearchID = str4;
        this.showSuggestImmediately = bool;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.ElementParams */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElementParams copy$default(ElementParams elementParams, String str, String str2, List list, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = elementParams.keyboard;
        }
        if ((i & 2) != 0) {
            str2 = elementParams.placeholder;
        }
        if ((i & 4) != 0) {
            list = elementParams.snapPoints;
        }
        if ((i & 8) != 0) {
            str3 = elementParams.suggestMode;
        }
        if ((i & 16) != 0) {
            str4 = elementParams.savedSearchID;
        }
        if ((i & 32) != 0) {
            bool = elementParams.showSuggestImmediately;
        }
        return elementParams.copy(str, str2, list, str3, str4, bool);
    }

    @Nullable
    public final String component1() {
        return this.keyboard;
    }

    @Nullable
    public final String component2() {
        return this.placeholder;
    }

    @Nullable
    public final List<SnapPoint> component3() {
        return this.snapPoints;
    }

    @Nullable
    public final String component4() {
        return this.suggestMode;
    }

    @Nullable
    public final String component5() {
        return this.savedSearchID;
    }

    @Nullable
    public final Boolean component6() {
        return this.showSuggestImmediately;
    }

    @NotNull
    public final ElementParams copy(@Nullable String str, @Nullable String str2, @Nullable List<SnapPoint> list, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool) {
        return new ElementParams(str, str2, list, str3, str4, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementParams)) {
            return false;
        }
        ElementParams elementParams = (ElementParams) obj;
        return Intrinsics.areEqual(this.keyboard, elementParams.keyboard) && Intrinsics.areEqual(this.placeholder, elementParams.placeholder) && Intrinsics.areEqual(this.snapPoints, elementParams.snapPoints) && Intrinsics.areEqual(this.suggestMode, elementParams.suggestMode) && Intrinsics.areEqual(this.savedSearchID, elementParams.savedSearchID) && Intrinsics.areEqual(this.showSuggestImmediately, elementParams.showSuggestImmediately);
    }

    @Nullable
    public final String getKeyboard() {
        return this.keyboard;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    public final String getSavedSearchID() {
        return this.savedSearchID;
    }

    @Nullable
    public final Boolean getShowSuggestImmediately() {
        return this.showSuggestImmediately;
    }

    @Nullable
    public final List<SnapPoint> getSnapPoints() {
        return this.snapPoints;
    }

    @Nullable
    public final String getSuggestMode() {
        return this.suggestMode;
    }

    public int hashCode() {
        String str = this.keyboard;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.placeholder;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<SnapPoint> list = this.snapPoints;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.suggestMode;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.savedSearchID;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.showSuggestImmediately;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ElementParams(keyboard=");
        L.append(this.keyboard);
        L.append(", placeholder=");
        L.append(this.placeholder);
        L.append(", snapPoints=");
        L.append(this.snapPoints);
        L.append(", suggestMode=");
        L.append(this.suggestMode);
        L.append(", savedSearchID=");
        L.append(this.savedSearchID);
        L.append(", showSuggestImmediately=");
        return a.o(L, this.showSuggestImmediately, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ElementParams(String str, String str2, List list, String str3, String str4, Boolean bool, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool);
    }
}
