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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Content;", "", "", "Lru/sravni/android/bankproduct/network/chat/response/Element;", "component1", "()Ljava/util/List;", "", "component2", MessengerShareContentUtility.ELEMENTS, "modifiers", "copy", "(Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/network/chat/response/Content;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getModifiers", "getElements", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Content {
    @SerializedName(MessengerShareContentUtility.ELEMENTS)
    @Nullable
    private final List<Element> elements;
    @SerializedName("modifiers")
    @Nullable
    private final List<String> modifiers;

    public Content() {
        this(null, null, 3, null);
    }

    public Content(@Nullable List<Element> list, @Nullable List<String> list2) {
        this.elements = list;
        this.modifiers = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.Content */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Content copy$default(Content content, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = content.elements;
        }
        if ((i & 2) != 0) {
            list2 = content.modifiers;
        }
        return content.copy(list, list2);
    }

    @Nullable
    public final List<Element> component1() {
        return this.elements;
    }

    @Nullable
    public final List<String> component2() {
        return this.modifiers;
    }

    @NotNull
    public final Content copy(@Nullable List<Element> list, @Nullable List<String> list2) {
        return new Content(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        return Intrinsics.areEqual(this.elements, content.elements) && Intrinsics.areEqual(this.modifiers, content.modifiers);
    }

    @Nullable
    public final List<Element> getElements() {
        return this.elements;
    }

    @Nullable
    public final List<String> getModifiers() {
        return this.modifiers;
    }

    public int hashCode() {
        List<Element> list = this.elements;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.modifiers;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Content(elements=");
        L.append(this.elements);
        L.append(", modifiers=");
        return a.w(L, this.modifiers, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Content(List list, List list2, int i, j jVar) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }
}
