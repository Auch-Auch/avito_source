package com.avito.android.remote.model.publish;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/publish/NextStagePayload;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "title", "getTitle", "", "Lcom/avito/android/remote/model/publish/Option;", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "paramName", "getParamName", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class NextStagePayload implements Parcelable {
    public static final Parcelable.Creator<NextStagePayload> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("options")
    @Nullable
    private final List<Option> options;
    @SerializedName("paramName")
    @Nullable
    private final String paramName;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NextStagePayload> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NextStagePayload createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Option.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new NextStagePayload(readString, readString2, arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NextStagePayload[] newArray(int i) {
            return new NextStagePayload[i];
        }
    }

    public NextStagePayload(@NotNull String str, @Nullable String str2, @Nullable List<Option> list, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.paramName = str2;
        this.options = list;
        this.description = str3;
        this.placeholder = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final List<Option> getOptions() {
        return this.options;
    }

    @Nullable
    public final String getParamName() {
        return this.paramName;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.paramName);
        List<Option> list = this.options;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Option) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.description);
        parcel.writeString(this.placeholder);
    }
}
