package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u00020\u0001:\u0001#B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0010¢\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u001e\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/GroupMarkerParameter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "required", "Z", "getRequired", "()Z", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "getTitle", "immutable", "getImmutable", Tracker.Events.CREATIVE_START, "getStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GroupMarkerParameter extends CategoryParameter {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    private final boolean required;
    private final boolean start;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/GroupMarkerParameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/GroupMarkerParameter;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/category_parameters/GroupMarkerParameter;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/category_parameters/GroupMarkerParameter;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<GroupMarkerParameter> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public GroupMarkerParameter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupMarkerParameter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public GroupMarkerParameter[] newArray(int i) {
            return new GroupMarkerParameter[i];
        }
    }

    public GroupMarkerParameter(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.start = z;
        this.title = str2 == null ? "" : str2;
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

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    public final boolean getStart() {
        return this.start;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getId());
        parcel.writeString(getTitle());
        parcel.writeByte(this.start ? (byte) 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GroupMarkerParameter(@org.jetbrains.annotations.NotNull android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = r5.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = r5.readString()
            byte r5 = r5.readByte()
            r2 = 0
            byte r3 = (byte) r2
            if (r5 == r3) goto L_0x001e
            r2 = 1
        L_0x001e:
            r4.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.GroupMarkerParameter.<init>(android.os.Parcel):void");
    }
}
