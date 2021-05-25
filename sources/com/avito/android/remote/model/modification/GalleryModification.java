package com.avito.android.remote.model.modification;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/modification/GalleryModification;", "Lcom/avito/android/remote/model/modification/Modification;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/modification/GalleryModification$Operation;", "component2", "()Ljava/util/List;", "name", "operations", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/modification/GalleryModification;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getOperations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Operation", "OperationType", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryModification implements Modification {
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<Operation> operations;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/modification/GalleryModification$Operation;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;", "component2", "()Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;", "Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;", "component3", "()Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;", "valueId", "operationType", "value", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;)Lcom/avito/android/remote/model/modification/GalleryModification$Operation;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValueId", "Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;", "getValue", "Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;", "getOperationType", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;)V", "Value", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Operation {
        @SerializedName("operation")
        @NotNull
        private final OperationType operationType;
        @SerializedName("value")
        @Nullable
        private final Value value;
        @SerializedName("valueId")
        @NotNull
        private final String valueId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;", "", "", "component1", "()Ljava/lang/String;", "imageId", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/modification/GalleryModification$Operation$Value;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageId", "<init>", "(Ljava/lang/String;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
        public static final class Value {
            @SerializedName("imageId")
            @NotNull
            private final String imageId;

            public Value(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "imageId");
                this.imageId = str;
            }

            public static /* synthetic */ Value copy$default(Value value, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = value.imageId;
                }
                return value.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.imageId;
            }

            @NotNull
            public final Value copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "imageId");
                return new Value(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Value) && Intrinsics.areEqual(this.imageId, ((Value) obj).imageId);
                }
                return true;
            }

            @NotNull
            public final String getImageId() {
                return this.imageId;
            }

            public int hashCode() {
                String str = this.imageId;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Value(imageId="), this.imageId, ")");
            }
        }

        public Operation(@NotNull String str, @NotNull OperationType operationType2, @Nullable Value value2) {
            Intrinsics.checkNotNullParameter(str, "valueId");
            Intrinsics.checkNotNullParameter(operationType2, "operationType");
            this.valueId = str;
            this.operationType = operationType2;
            this.value = value2;
        }

        public static /* synthetic */ Operation copy$default(Operation operation, String str, OperationType operationType2, Value value2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = operation.valueId;
            }
            if ((i & 2) != 0) {
                operationType2 = operation.operationType;
            }
            if ((i & 4) != 0) {
                value2 = operation.value;
            }
            return operation.copy(str, operationType2, value2);
        }

        @NotNull
        public final String component1() {
            return this.valueId;
        }

        @NotNull
        public final OperationType component2() {
            return this.operationType;
        }

        @Nullable
        public final Value component3() {
            return this.value;
        }

        @NotNull
        public final Operation copy(@NotNull String str, @NotNull OperationType operationType2, @Nullable Value value2) {
            Intrinsics.checkNotNullParameter(str, "valueId");
            Intrinsics.checkNotNullParameter(operationType2, "operationType");
            return new Operation(str, operationType2, value2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Operation)) {
                return false;
            }
            Operation operation = (Operation) obj;
            return Intrinsics.areEqual(this.valueId, operation.valueId) && Intrinsics.areEqual(this.operationType, operation.operationType) && Intrinsics.areEqual(this.value, operation.value);
        }

        @NotNull
        public final OperationType getOperationType() {
            return this.operationType;
        }

        @Nullable
        public final Value getValue() {
            return this.value;
        }

        @NotNull
        public final String getValueId() {
            return this.valueId;
        }

        public int hashCode() {
            String str = this.valueId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            OperationType operationType2 = this.operationType;
            int hashCode2 = (hashCode + (operationType2 != null ? operationType2.hashCode() : 0)) * 31;
            Value value2 = this.value;
            if (value2 != null) {
                i = value2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Operation(valueId=");
            L.append(this.valueId);
            L.append(", operationType=");
            L.append(this.operationType);
            L.append(", value=");
            L.append(this.value);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/modification/GalleryModification$OperationType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public enum OperationType {
        ADD,
        REMOVE
    }

    public GalleryModification(@NotNull String str, @NotNull List<Operation> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "operations");
        this.name = str;
        this.operations = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.modification.GalleryModification */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GalleryModification copy$default(GalleryModification galleryModification, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = galleryModification.name;
        }
        if ((i & 2) != 0) {
            list = galleryModification.operations;
        }
        return galleryModification.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final List<Operation> component2() {
        return this.operations;
    }

    @NotNull
    public final GalleryModification copy(@NotNull String str, @NotNull List<Operation> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "operations");
        return new GalleryModification(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GalleryModification)) {
            return false;
        }
        GalleryModification galleryModification = (GalleryModification) obj;
        return Intrinsics.areEqual(this.name, galleryModification.name) && Intrinsics.areEqual(this.operations, galleryModification.operations);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<Operation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Operation> list = this.operations;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GalleryModification(name=");
        L.append(this.name);
        L.append(", operations=");
        return a.w(L, this.operations, ")");
    }
}
