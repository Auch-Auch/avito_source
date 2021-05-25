package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BS\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b\"\u0010\u0007R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u000fR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b'\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Element;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "component4", "()Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "component5", "Lru/sravni/android/bankproduct/network/chat/response/Validation;", "component6", "()Lru/sravni/android/bankproduct/network/chat/response/Validation;", MessengerShareContentUtility.ELEMENTS, "name", "type", "params", "text", "validation", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/ElementParams;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/Validation;)Lru/sravni/android/bankproduct/network/chat/response/Element;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getText", "Lru/sravni/android/bankproduct/network/chat/response/Validation;", "getValidation", "Ljava/util/List;", "getElements", "getType", "Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "getParams", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/ElementParams;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/response/Validation;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Element {
    @SerializedName(MessengerShareContentUtility.ELEMENTS)
    @Nullable
    private final List<Element> elements;
    @SerializedName("name")
    @Nullable
    private final String name;
    @SerializedName("params")
    @NotNull
    private final ElementParams params;
    @SerializedName("text")
    @Nullable
    private final String text;
    @SerializedName("type")
    @Nullable
    private final String type;
    @SerializedName("validation")
    @Nullable
    private final Validation validation;

    public Element() {
        this(null, null, null, null, null, null, 63, null);
    }

    public Element(@Nullable List<Element> list, @Nullable String str, @Nullable String str2, @NotNull ElementParams elementParams, @Nullable String str3, @Nullable Validation validation2) {
        Intrinsics.checkParameterIsNotNull(elementParams, "params");
        this.elements = list;
        this.name = str;
        this.type = str2;
        this.params = elementParams;
        this.text = str3;
        this.validation = validation2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.Element */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Element copy$default(Element element, List list, String str, String str2, ElementParams elementParams, String str3, Validation validation2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = element.elements;
        }
        if ((i & 2) != 0) {
            str = element.name;
        }
        if ((i & 4) != 0) {
            str2 = element.type;
        }
        if ((i & 8) != 0) {
            elementParams = element.params;
        }
        if ((i & 16) != 0) {
            str3 = element.text;
        }
        if ((i & 32) != 0) {
            validation2 = element.validation;
        }
        return element.copy(list, str, str2, elementParams, str3, validation2);
    }

    @Nullable
    public final List<Element> component1() {
        return this.elements;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.type;
    }

    @NotNull
    public final ElementParams component4() {
        return this.params;
    }

    @Nullable
    public final String component5() {
        return this.text;
    }

    @Nullable
    public final Validation component6() {
        return this.validation;
    }

    @NotNull
    public final Element copy(@Nullable List<Element> list, @Nullable String str, @Nullable String str2, @NotNull ElementParams elementParams, @Nullable String str3, @Nullable Validation validation2) {
        Intrinsics.checkParameterIsNotNull(elementParams, "params");
        return new Element(list, str, str2, elementParams, str3, validation2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Element)) {
            return false;
        }
        Element element = (Element) obj;
        return Intrinsics.areEqual(this.elements, element.elements) && Intrinsics.areEqual(this.name, element.name) && Intrinsics.areEqual(this.type, element.type) && Intrinsics.areEqual(this.params, element.params) && Intrinsics.areEqual(this.text, element.text) && Intrinsics.areEqual(this.validation, element.validation);
    }

    @Nullable
    public final List<Element> getElements() {
        return this.elements;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ElementParams getParams() {
        return this.params;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Validation getValidation() {
        return this.validation;
    }

    public int hashCode() {
        List<Element> list = this.elements;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ElementParams elementParams = this.params;
        int hashCode4 = (hashCode3 + (elementParams != null ? elementParams.hashCode() : 0)) * 31;
        String str3 = this.text;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Validation validation2 = this.validation;
        if (validation2 != null) {
            i = validation2.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Element(elements=");
        L.append(this.elements);
        L.append(", name=");
        L.append(this.name);
        L.append(", type=");
        L.append(this.type);
        L.append(", params=");
        L.append(this.params);
        L.append(", text=");
        L.append(this.text);
        L.append(", validation=");
        L.append(this.validation);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Element(List list, String str, String str2, ElementParams elementParams, String str3, Validation validation2, int i, j jVar) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? new ElementParams(null, null, null, null, null, null, 63, null) : elementParams, (i & 16) != 0 ? null : str3, (i & 32) == 0 ? validation2 : null);
    }
}
