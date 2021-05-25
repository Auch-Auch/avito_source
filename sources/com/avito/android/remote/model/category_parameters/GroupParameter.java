package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B'\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016XD¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "optionalTitle", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "getTitle", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "immutable", "Z", "getImmutable", "()Z", "required", "getRequired", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GroupParameter extends CategoryParameter {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    @SerializedName("title")
    private final String optionalTitle;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @NotNull
    private final List<ParameterSlot> parameters;
    private final boolean required;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/GroupParameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/category_parameters/GroupParameter;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<GroupParameter> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public GroupParameter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupParameter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public GroupParameter[] newArray(int i) {
            return new GroupParameter[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupParameter(@NotNull String str, @Nullable String str2, @NotNull List<? extends ParameterSlot> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.id = str;
        this.optionalTitle = str2;
        this.parameters = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ParameterSlot
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getImmutable() {
        return this.immutable;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @Nullable
    public AttributedText getMotivation() {
        return this.motivation;
    }

    @NotNull
    public final List<ParameterSlot> getParameters() {
        return this.parameters;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        String str = this.optionalTitle;
        return str != null ? str : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getId());
        parcel.writeString(this.optionalTitle);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.parameters, 0, 2, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GroupParameter(@org.jetbrains.annotations.NotNull android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = r4.readString()
            java.lang.Class<com.avito.android.remote.model.category_parameters.base.ParameterSlot> r2 = com.avito.android.remote.model.category_parameters.base.ParameterSlot.class
            java.util.List r4 = com.avito.android.util.ParcelsKt.createParcelableList(r4, r2)
            if (r4 == 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0022:
            r3.<init>(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.GroupParameter.<init>(android.os.Parcel):void");
    }
}
