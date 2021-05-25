package com.avito.android.remote.model.modification;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/modification/TextModification;", "Lcom/avito/android/remote/model/modification/Modification;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/modification/TextModification$AddOperation;", "component2", "()Ljava/util/List;", "name", "operations", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/modification/TextModification;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOperations", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "AddOperation", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class TextModification implements Modification {
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<AddOperation> operations;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/modification/TextModification$AddOperation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "valueId", "operationType", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/modification/TextModification$AddOperation;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getValueId", "getOperationType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class AddOperation {
        @SerializedName("operation")
        @NotNull
        private final String operationType;
        @SerializedName("value")
        @NotNull
        private final String text;
        @SerializedName("valueId")
        @NotNull
        private final String valueId;

        public AddOperation(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "valueId", str2, "operationType", str3, "text");
            this.valueId = str;
            this.operationType = str2;
            this.text = str3;
        }

        public static /* synthetic */ AddOperation copy$default(AddOperation addOperation, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = addOperation.valueId;
            }
            if ((i & 2) != 0) {
                str2 = addOperation.operationType;
            }
            if ((i & 4) != 0) {
                str3 = addOperation.text;
            }
            return addOperation.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.valueId;
        }

        @NotNull
        public final String component2() {
            return this.operationType;
        }

        @NotNull
        public final String component3() {
            return this.text;
        }

        @NotNull
        public final AddOperation copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "valueId");
            Intrinsics.checkNotNullParameter(str2, "operationType");
            Intrinsics.checkNotNullParameter(str3, "text");
            return new AddOperation(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddOperation)) {
                return false;
            }
            AddOperation addOperation = (AddOperation) obj;
            return Intrinsics.areEqual(this.valueId, addOperation.valueId) && Intrinsics.areEqual(this.operationType, addOperation.operationType) && Intrinsics.areEqual(this.text, addOperation.text);
        }

        @NotNull
        public final String getOperationType() {
            return this.operationType;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final String getValueId() {
            return this.valueId;
        }

        public int hashCode() {
            String str = this.valueId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.operationType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.text;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AddOperation(valueId=");
            L.append(this.valueId);
            L.append(", operationType=");
            L.append(this.operationType);
            L.append(", text=");
            return a.t(L, this.text, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AddOperation(String str, String str2, String str3, int i, j jVar) {
            this(str, (i & 2) != 0 ? ProductAction.ACTION_ADD : str2, str3);
        }
    }

    public TextModification(@NotNull String str, @NotNull List<AddOperation> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "operations");
        this.name = str;
        this.operations = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.modification.TextModification */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextModification copy$default(TextModification textModification, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textModification.name;
        }
        if ((i & 2) != 0) {
            list = textModification.operations;
        }
        return textModification.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final List<AddOperation> component2() {
        return this.operations;
    }

    @NotNull
    public final TextModification copy(@NotNull String str, @NotNull List<AddOperation> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "operations");
        return new TextModification(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextModification)) {
            return false;
        }
        TextModification textModification = (TextModification) obj;
        return Intrinsics.areEqual(this.name, textModification.name) && Intrinsics.areEqual(this.operations, textModification.operations);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<AddOperation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<AddOperation> list = this.operations;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextModification(name=");
        L.append(this.name);
        L.append(", operations=");
        return a.w(L, this.operations, ")");
    }
}
