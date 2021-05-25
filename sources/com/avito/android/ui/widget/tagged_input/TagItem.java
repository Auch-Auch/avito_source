package com.avito.android.ui.widget.tagged_input;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001:\u000223B-\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\n¨\u00064"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagItem;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;", "component2", "()Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;", "Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;", "component3", "()Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "component4", "()Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "label", "value", "type", "clickEvent", "copy", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)Lcom/avito/android/ui/widget/tagged_input/TagItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "getClickEvent", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLabel", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;", "getValue", "c", "Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;", "getType", "<init>", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "Type", "Value", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class TagItem implements Parcelable {
    public static final Parcelable.Creator<TagItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final Value b;
    @NotNull
    public final Type c;
    @Nullable
    public final SuggestAnalyticsEvent d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TagItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TagItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TagItem(parcel.readString(), Value.CREATOR.createFromParcel(parcel), (Type) Enum.valueOf(Type.class, parcel.readString()), (SuggestAnalyticsEvent) parcel.readParcelable(TagItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TagItem[] newArray(int i) {
            return new TagItem[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagItem$Type;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "ALTERNATIVE", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        REGULAR,
        ALTERNATIVE
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "text", "isFullReplace", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/ui/widget/tagged_input/TagItem$Value;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value implements Parcelable {
        public static final Parcelable.Creator<Value> CREATOR = new Creator();
        @NotNull
        public final String a;
        public final boolean b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Value> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Value(parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value[] newArray(int i) {
                return new Value[i];
            }
        }

        public Value(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = str;
            this.b = z;
        }

        public static /* synthetic */ Value copy$default(Value value, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = value.a;
            }
            if ((i & 2) != 0) {
                z = value.b;
            }
            return value.copy(str, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final Value copy(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Value(str, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Intrinsics.areEqual(this.a, value.a) && this.b == value.b;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        public final boolean isFullReplace() {
            return this.b;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Value(text=");
            L.append(this.a);
            L.append(", isFullReplace=");
            return a.B(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(String str, boolean z, int i, j jVar) {
            this(str, (i & 2) != 0 ? true : z);
        }
    }

    public TagItem(@NotNull String str, @NotNull Value value, @NotNull Type type, @Nullable SuggestAnalyticsEvent suggestAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = str;
        this.b = value;
        this.c = type;
        this.d = suggestAnalyticsEvent;
    }

    public static /* synthetic */ TagItem copy$default(TagItem tagItem, String str, Value value, Type type, SuggestAnalyticsEvent suggestAnalyticsEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagItem.a;
        }
        if ((i & 2) != 0) {
            value = tagItem.b;
        }
        if ((i & 4) != 0) {
            type = tagItem.c;
        }
        if ((i & 8) != 0) {
            suggestAnalyticsEvent = tagItem.d;
        }
        return tagItem.copy(str, value, type, suggestAnalyticsEvent);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final Value component2() {
        return this.b;
    }

    @NotNull
    public final Type component3() {
        return this.c;
    }

    @Nullable
    public final SuggestAnalyticsEvent component4() {
        return this.d;
    }

    @NotNull
    public final TagItem copy(@NotNull String str, @NotNull Value value, @NotNull Type type, @Nullable SuggestAnalyticsEvent suggestAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TagItem(str, value, type, suggestAnalyticsEvent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagItem)) {
            return false;
        }
        TagItem tagItem = (TagItem) obj;
        return Intrinsics.areEqual(this.a, tagItem.a) && Intrinsics.areEqual(this.b, tagItem.b) && Intrinsics.areEqual(this.c, tagItem.c) && Intrinsics.areEqual(this.d, tagItem.d);
    }

    @Nullable
    public final SuggestAnalyticsEvent getClickEvent() {
        return this.d;
    }

    @NotNull
    public final String getLabel() {
        return this.a;
    }

    @NotNull
    public final Type getType() {
        return this.c;
    }

    @NotNull
    public final Value getValue() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Value value = this.b;
        int hashCode2 = (hashCode + (value != null ? value.hashCode() : 0)) * 31;
        Type type = this.c;
        int hashCode3 = (hashCode2 + (type != null ? type.hashCode() : 0)) * 31;
        SuggestAnalyticsEvent suggestAnalyticsEvent = this.d;
        if (suggestAnalyticsEvent != null) {
            i = suggestAnalyticsEvent.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TagItem(label=");
        L.append(this.a);
        L.append(", value=");
        L.append(this.b);
        L.append(", type=");
        L.append(this.c);
        L.append(", clickEvent=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        this.b.writeToParcel(parcel, 0);
        parcel.writeString(this.c.name());
        parcel.writeParcelable(this.d, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TagItem(String str, Value value, Type type, SuggestAnalyticsEvent suggestAnalyticsEvent, int i, j jVar) {
        this(str, value, (i & 4) != 0 ? Type.REGULAR : type, (i & 8) != 0 ? null : suggestAnalyticsEvent);
    }
}
