package com.avito.android.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.google.common.net.HttpHeaders;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/items/ItemWithState;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "State", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public interface ItemWithState extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ItemWithState itemWithState) {
            return Item.DefaultImpls.getId(itemWithState);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/items/ItemWithState$State;", "Landroid/os/Parcelable;", "<init>", "()V", "Error", "Normal", HttpHeaders.WARNING, "Lcom/avito/android/items/ItemWithState$State$Normal;", "Lcom/avito/android/items/ItemWithState$State$Warning;", "Lcom/avito/android/items/ItemWithState$State$Error;", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/items/ItemWithState$State$Error;", "Lcom/avito/android/items/ItemWithState$State;", "", "component1", "()Ljava/lang/CharSequence;", "", "", "component2", "()Ljava/util/Map;", "message", "textForInternalField", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;)Lcom/avito/android/items/ItemWithState$State$Error;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getTextForInternalField", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getMessage", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            public static final Parcelable.Creator<Error> CREATOR = new Creator();
            @NotNull
            public final CharSequence a;
            @NotNull
            public final Map<String, String> b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Error> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    }
                    return new Error(charSequence, linkedHashMap);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error[] newArray(int i) {
                    return new Error[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Error(CharSequence charSequence, Map map, int i, j jVar) {
                this(charSequence, (i & 2) != 0 ? r.emptyMap() : map);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.items.ItemWithState$State$Error */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Error copy$default(Error error, CharSequence charSequence, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = error.a;
                }
                if ((i & 2) != 0) {
                    map = error.b;
                }
                return error.copy(charSequence, map);
            }

            @NotNull
            public final CharSequence component1() {
                return this.a;
            }

            @NotNull
            public final Map<String, String> component2() {
                return this.b;
            }

            @NotNull
            public final Error copy(@NotNull CharSequence charSequence, @NotNull Map<String, String> map) {
                Intrinsics.checkNotNullParameter(charSequence, "message");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
                return new Error(charSequence, map);
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
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.a, error.a) && Intrinsics.areEqual(this.b, error.b);
            }

            @NotNull
            public final CharSequence getMessage() {
                return this.a;
            }

            @NotNull
            public final Map<String, String> getTextForInternalField() {
                return this.b;
            }

            @Override // java.lang.Object
            public int hashCode() {
                CharSequence charSequence = this.a;
                int i = 0;
                int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
                Map<String, String> map = this.b;
                if (map != null) {
                    i = map.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Error(message=");
                L.append(this.a);
                L.append(", textForInternalField=");
                return a.x(L, this.b, ")");
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // android.os.Parcelable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
                /*
                    r2 = this;
                    java.lang.String r4 = "parcel"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                    java.lang.CharSequence r4 = r2.a
                    r0 = 0
                    android.text.TextUtils.writeToParcel(r4, r3, r0)
                    java.util.Map<java.lang.String, java.lang.String> r4 = r2.b
                    java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
                L_0x0011:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x002e
                    java.lang.Object r0 = r4.next()
                    java.lang.Object r1 = r0.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    r3.writeString(r1)
                    java.lang.Object r0 = r0.getValue()
                    java.lang.String r0 = (java.lang.String) r0
                    r3.writeString(r0)
                    goto L_0x0011
                L_0x002e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.items.ItemWithState.State.Error.writeToParcel(android.os.Parcel, int):void");
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull CharSequence charSequence, @NotNull Map<String, String> map) {
                super(null);
                Intrinsics.checkNotNullParameter(charSequence, "message");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
                this.a = charSequence;
                this.b = map;
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/items/ItemWithState$State$Normal;", "Lcom/avito/android/items/ItemWithState$State;", "", "component1", "()Ljava/lang/CharSequence;", "message", "copy", "(Ljava/lang/CharSequence;)Lcom/avito/android/items/ItemWithState$State$Normal;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getMessage", "<init>", "(Ljava/lang/CharSequence;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
        public static final class Normal extends State {
            public static final Parcelable.Creator<Normal> CREATOR = new Creator();
            @Nullable
            public final CharSequence a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Normal> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Normal createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Normal((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Normal[] newArray(int i) {
                    return new Normal[i];
                }
            }

            public Normal() {
                this(null, 1, null);
            }

            public Normal(@Nullable CharSequence charSequence) {
                super(null);
                this.a = charSequence;
            }

            public static /* synthetic */ Normal copy$default(Normal normal, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = normal.a;
                }
                return normal.copy(charSequence);
            }

            @Nullable
            public final CharSequence component1() {
                return this.a;
            }

            @NotNull
            public final Normal copy(@Nullable CharSequence charSequence) {
                return new Normal(charSequence);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Normal) && Intrinsics.areEqual(this.a, ((Normal) obj).a);
                }
                return true;
            }

            @Nullable
            public final CharSequence getMessage() {
                return this.a;
            }

            @Override // java.lang.Object
            public int hashCode() {
                CharSequence charSequence = this.a;
                if (charSequence != null) {
                    return charSequence.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Normal(message=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                TextUtils.writeToParcel(this.a, parcel, 0);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Normal(CharSequence charSequence, int i, j jVar) {
                this((i & 1) != 0 ? null : charSequence);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/avito/android/items/ItemWithState$State$Warning;", "Lcom/avito/android/items/ItemWithState$State;", "", "component1", "()Ljava/lang/CharSequence;", "", "", "component2", "()Ljava/util/Map;", "message", "textForInternalField", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;)Lcom/avito/android/items/ItemWithState$State$Warning;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getMessage", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getTextForInternalField", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
        public static final class Warning extends State {
            public static final Parcelable.Creator<Warning> CREATOR = new Creator();
            @NotNull
            public final CharSequence a;
            @NotNull
            public final Map<String, String> b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Warning> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Warning createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    while (readInt != 0) {
                        readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    }
                    return new Warning(charSequence, linkedHashMap);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Warning[] newArray(int i) {
                    return new Warning[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Warning(CharSequence charSequence, Map map, int i, j jVar) {
                this(charSequence, (i & 2) != 0 ? r.emptyMap() : map);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.items.ItemWithState$State$Warning */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Warning copy$default(Warning warning, CharSequence charSequence, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    charSequence = warning.a;
                }
                if ((i & 2) != 0) {
                    map = warning.b;
                }
                return warning.copy(charSequence, map);
            }

            @NotNull
            public final CharSequence component1() {
                return this.a;
            }

            @NotNull
            public final Map<String, String> component2() {
                return this.b;
            }

            @NotNull
            public final Warning copy(@NotNull CharSequence charSequence, @NotNull Map<String, String> map) {
                Intrinsics.checkNotNullParameter(charSequence, "message");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
                return new Warning(charSequence, map);
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
                if (!(obj instanceof Warning)) {
                    return false;
                }
                Warning warning = (Warning) obj;
                return Intrinsics.areEqual(this.a, warning.a) && Intrinsics.areEqual(this.b, warning.b);
            }

            @NotNull
            public final CharSequence getMessage() {
                return this.a;
            }

            @NotNull
            public final Map<String, String> getTextForInternalField() {
                return this.b;
            }

            @Override // java.lang.Object
            public int hashCode() {
                CharSequence charSequence = this.a;
                int i = 0;
                int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
                Map<String, String> map = this.b;
                if (map != null) {
                    i = map.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Warning(message=");
                L.append(this.a);
                L.append(", textForInternalField=");
                return a.x(L, this.b, ")");
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // android.os.Parcelable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
                /*
                    r2 = this;
                    java.lang.String r4 = "parcel"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                    java.lang.CharSequence r4 = r2.a
                    r0 = 0
                    android.text.TextUtils.writeToParcel(r4, r3, r0)
                    java.util.Map<java.lang.String, java.lang.String> r4 = r2.b
                    java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
                L_0x0011:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x002e
                    java.lang.Object r0 = r4.next()
                    java.lang.Object r1 = r0.getKey()
                    java.lang.String r1 = (java.lang.String) r1
                    r3.writeString(r1)
                    java.lang.Object r0 = r0.getValue()
                    java.lang.String r0 = (java.lang.String) r0
                    r3.writeString(r0)
                    goto L_0x0011
                L_0x002e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.items.ItemWithState.State.Warning.writeToParcel(android.os.Parcel, int):void");
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Warning(@NotNull CharSequence charSequence, @NotNull Map<String, String> map) {
                super(null);
                Intrinsics.checkNotNullParameter(charSequence, "message");
                Intrinsics.checkNotNullParameter(map, "textForInternalField");
                this.a = charSequence;
                this.b = map;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    @NotNull
    State getState();

    void setState(@NotNull State state);
}
