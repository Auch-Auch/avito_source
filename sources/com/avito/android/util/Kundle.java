package com.avito.android.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\"\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 l2\u00020\u0001:\u0001lB\t\b\u0016¢\u0006\u0004\bh\u0010iB\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020\u0000¢\u0006\u0004\bh\u0010jB\u0011\b\u0016\u0012\u0006\u0010e\u001a\u00020`¢\u0006\u0004\bh\u0010kJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u001aJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001eJ\u0017\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001f¢\u0006\u0004\b \u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b#\u0010%J\u0017\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b'\u0010(J\u001d\u0010'\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020&¢\u0006\u0004\b'\u0010)J!\u0010+\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010**\u00020-2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b.\u0010/J'\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000100\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b3\u00104J\u001d\u00103\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b3\u00105J\u0017\u00106\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b6\u00107J-\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0018\u000108\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b=\u0010>J\u001f\u0010?\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010&¢\u0006\u0004\bC\u0010DJ)\u0010E\u001a\u00020\u0000\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bE\u0010FJ)\u0010G\u001a\u00020\u0000\"\b\b\u0000\u0010**\u00020-2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bG\u0010HJ/\u0010I\u001a\u00020\u0000\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000100¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bK\u0010LJ'\u0010M\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000100¢\u0006\u0004\bM\u0010JJ-\u0010N\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u000108¢\u0006\u0004\bN\u0010OJ\u001d\u0010P\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0000¢\u0006\u0004\bS\u0010TJ5\u0010V\u001a\u00020\u0000\"\b\b\u0000\u0010**\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u0000\u0018\u000108¢\u0006\u0004\bV\u0010OJ\u001f\u0010W\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bW\u00102J%\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001082\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bX\u0010:J#\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001082\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bY\u0010:J\u0015\u0010Z\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\bZ\u00107J\u0013\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130[¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020\u0004¢\u0006\u0004\b^\u0010_J\r\u0010a\u001a\u00020`¢\u0006\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0013\u0010g\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bf\u0010\t¨\u0006m"}, d2 = {"Lcom/avito/android/util/Kundle;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "clear", "()Lcom/avito/android/util/Kundle;", "", "key", "contains", "(Ljava/lang/String;)Z", "getBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "value", "(Ljava/lang/String;Z)Z", "", "getDouble", "(Ljava/lang/String;)Ljava/lang/Double;", "(Ljava/lang/String;D)D", "", "getFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "(Ljava/lang/String;F)F", "getInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)I", "", "getLong", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;J)J", "T", "getParcelable", "(Ljava/lang/String;)Landroid/os/Parcelable;", "Ljava/io/Serializable;", "getSerializable", "(Ljava/lang/String;)Ljava/io/Serializable;", "", "getParcelableList", "(Ljava/lang/String;)Ljava/util/List;", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getKundle", "(Ljava/lang/String;)Lcom/avito/android/util/Kundle;", "", "getParcelableMap", "(Ljava/lang/String;)Ljava/util/Map;", "putBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/util/Kundle;", "putDouble", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/avito/android/util/Kundle;", "putFloat", "(Ljava/lang/String;Ljava/lang/Float;)Lcom/avito/android/util/Kundle;", "putInt", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/util/Kundle;", "putLong", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/avito/android/util/Kundle;", "putParcelable", "(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/avito/android/util/Kundle;", "putSerializable", "(Ljava/lang/String;Ljava/io/Serializable;)Lcom/avito/android/util/Kundle;", "putParcelableList", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/util/Kundle;", "putString", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/util/Kundle;", "putStringList", "putStringMap", "(Ljava/lang/String;Ljava/util/Map;)Lcom/avito/android/util/Kundle;", "putKundle", "(Ljava/lang/String;Lcom/avito/android/util/Kundle;)Lcom/avito/android/util/Kundle;", "kundle", "putAll", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/util/Kundle;", "map", "putParcelableMap", "getStringList", "getStringMap", "getNonNullStringMap", ProductAction.ACTION_REMOVE, "", "keySet", "()Ljava/util/Set;", "isEmpty", "()Z", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", AuthSource.SEND_ABUSE, "Landroid/os/Bundle;", "bundle", "getSize", "size", "<init>", "()V", "(Lcom/avito/android/util/Kundle;)V", "(Landroid/os/Bundle;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Kundle implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Kundle> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Kundle b;
    public final Bundle a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/util/Kundle$Companion;", "", "Lcom/avito/android/util/Kundle;", "EMPTY", "Lcom/avito/android/util/Kundle;", "getEMPTY", "()Lcom/avito/android/util/Kundle;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Kundle getEMPTY() {
            return Kundle.b;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, Kundle> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Kundle invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new Kundle(parcel2, null);
        }
    }

    static {
        Bundle bundle = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(bundle, "Bundle.EMPTY");
        b = new Kundle(bundle);
    }

    public Kundle() {
        this.a = new Bundle();
    }

    @NotNull
    public final Kundle clear() {
        this.a.clear();
        return this;
    }

    public final boolean contains(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Kundle) {
            return Bundles.isEqual(this.a, ((Kundle) obj).a);
        }
        return false;
    }

    public final boolean getBoolean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getBoolean(str, z);
    }

    public final double getDouble(@NotNull String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getDouble(str, d);
    }

    public final float getFloat(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getFloat(str, f);
    }

    public final int getInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getInt(str, i);
    }

    @Nullable
    public final Kundle getKundle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return (Kundle) obj;
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.avito.android.util.Kundle");
        }
    }

    public final long getLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getLong(str, j);
    }

    @Nullable
    public final Map<String, String> getNonNullStringMap(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return Bundles.getMapOfStrings(this.a, str);
    }

    @Nullable
    public final <T extends Parcelable> T getParcelable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return (T) ((Parcelable) obj);
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    @Nullable
    public final <T extends Parcelable> List<T> getParcelableList(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return (List) obj;
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<T>");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x001f A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> java.util.Map<java.lang.String, T> getParcelableMap(@org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.avito.android.util.Kundle r7 = r6.getKundle(r7)
            r0 = 0
            if (r7 == 0) goto L_0x0055
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L_0x0054
            java.util.Set r2 = r7.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0054
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = access$getBundle$p(r7)
            boolean r4 = r4.containsKey(r3)
            if (r4 == 0) goto L_0x004d
            android.os.Bundle r4 = access$getBundle$p(r7)
            java.lang.Object r4 = r4.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r5 = "bundle[key]!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r5 = r4 instanceof android.os.Parcelable     // Catch:{ ClassCastException -> 0x004d }
            if (r5 != 0) goto L_0x004a
            r4 = r0
        L_0x004a:
            android.os.Parcelable r4 = (android.os.Parcelable) r4     // Catch:{ ClassCastException -> 0x004d }
            goto L_0x004e
        L_0x004d:
            r4 = r0
        L_0x004e:
            if (r4 == 0) goto L_0x001f
            r1.put(r3, r4)
            goto L_0x001f
        L_0x0054:
            return r1
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Kundle.getParcelableMap(java.lang.String):java.util.Map");
    }

    @Nullable
    public final <T extends Serializable> T getSerializable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return (T) ((Serializable) obj);
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public final int getSize() {
        return this.a.size();
    }

    @NotNull
    public final String getString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        String string = this.a.getString(str, str2);
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(key, value)");
        return string;
    }

    @Nullable
    public final List<String> getStringList(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getStringArrayList(str);
    }

    @Nullable
    public final Map<String, String> getStringMap(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return Bundles.getMapOfStrings(this.a, str);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return super.hashCode();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @NotNull
    public final Set<String> keySet() {
        Set<String> keySet = this.a.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        return keySet;
    }

    @NotNull
    public final Kundle putAll(@NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(kundle, "kundle");
        this.a.putAll(kundle.a);
        return this;
    }

    @NotNull
    public final Kundle putBoolean(@NotNull String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (bool == null) {
            this.a.remove(str);
        } else {
            this.a.putBoolean(str, bool.booleanValue());
        }
        return this;
    }

    @NotNull
    public final Kundle putDouble(@NotNull String str, @Nullable Double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (d == null) {
            this.a.remove(str);
        } else {
            this.a.putDouble(str, d.doubleValue());
        }
        return this;
    }

    @NotNull
    public final Kundle putFloat(@NotNull String str, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (f == null) {
            this.a.remove(str);
        } else {
            this.a.putFloat(str, f.floatValue());
        }
        return this;
    }

    @NotNull
    public final Kundle putInt(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (num == null) {
            this.a.remove(str);
        } else {
            this.a.putInt(str, num.intValue());
        }
        return this;
    }

    @NotNull
    public final Kundle putKundle(@NotNull String str, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kundle, "value");
        this.a.putParcelable(str, kundle);
        return this;
    }

    @NotNull
    public final Kundle putLong(@NotNull String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (l == null) {
            this.a.remove(str);
        } else {
            this.a.putLong(str, l.longValue());
        }
        return this;
    }

    @NotNull
    public final <T extends Parcelable> Kundle putParcelable(@NotNull String str, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (t == null) {
            this.a.remove(str);
        } else {
            this.a.putParcelable(str, t);
        }
        return this;
    }

    @NotNull
    public final <T extends Parcelable> Kundle putParcelableList(@NotNull String str, @Nullable List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (list == null) {
            this.a.remove(str);
        } else {
            Bundles.putParcelableList(this.a, str, list);
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.Kundle */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T extends Parcelable> Kundle putParcelableMap(@NotNull String str, @Nullable Map<String, ? extends T> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (map == null) {
            this.a.remove(str);
        } else {
            Kundle kundle = new Kundle();
            for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
                kundle.putParcelable(entry.getKey(), (Parcelable) entry.getValue());
            }
            putKundle(str, kundle);
        }
        return this;
    }

    @NotNull
    public final <T extends Serializable> Kundle putSerializable(@NotNull String str, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (t == null) {
            this.a.remove(str);
        } else {
            this.a.putSerializable(str, t);
        }
        return this;
    }

    @NotNull
    public final Kundle putString(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (str2 == null) {
            this.a.remove(str);
        } else {
            this.a.putString(str, str2);
        }
        return this;
    }

    @NotNull
    public final Kundle putStringList(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (list == null) {
            this.a.remove(str);
        } else {
            this.a.putStringArrayList(str, Collections.asArrayList(list));
        }
        return this;
    }

    @NotNull
    public final Kundle putStringMap(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (map == null) {
            this.a.remove(str);
        } else {
            Bundles.putMapOfStrings(this.a, str, map);
        }
        return this;
    }

    @NotNull
    public final Kundle remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.a.remove(str);
        return this;
    }

    @NotNull
    public final Bundle toBundle() {
        return new Bundle(this.a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeBundle(this.a);
    }

    public Kundle(@NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(kundle, "kundle");
        Bundle bundle = new Bundle();
        this.a = bundle;
        bundle.putAll(kundle.a);
    }

    @Nullable
    public final Boolean getBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return Boolean.valueOf(((Boolean) obj).booleanValue());
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    @Nullable
    public final Double getDouble(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return Double.valueOf(((Double) obj).doubleValue());
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
        }
    }

    @Nullable
    public final Float getFloat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return Float.valueOf(((Float) obj).floatValue());
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @Nullable
    public final Integer getInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return Integer.valueOf(((Integer) obj).intValue());
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    @Nullable
    public final Long getLong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return Long.valueOf(((Long) obj).longValue());
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    @Nullable
    public final String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.a.containsKey(str)) {
            return null;
        }
        Object obj = this.a.get(str);
        Intrinsics.checkNotNull(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "bundle[key]!!");
        if (obj != null) {
            try {
                return (String) obj;
            } catch (ClassCastException unused) {
                return null;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public Kundle(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.a = new Bundle(bundle);
    }

    public Kundle(Parcel parcel, j jVar) {
        Bundle readBundle = parcel.readBundle(Kundle.class.getClassLoader());
        this.a = readBundle == null ? new Bundle(0) : readBundle;
    }
}
