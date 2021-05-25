package net.gotev.uploadservice.persistence;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0000¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000/¢\u0006\u0004\b0\u00101J\u001b\u00102\u001a\b\u0012\u0004\u0012\u00020\u00000/2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0011¢\u0006\u0004\b7\u00108J\u001d\u0010:\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u00109\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;R8\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020<j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0002`=8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b:\u0010>\u001a\u0004\b-\u0010?¨\u0006C"}, d2 = {"Lnet/gotev/uploadservice/persistence/PersistableData;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "key", "value", "putBoolean", "(Ljava/lang/String;Z)V", "getBoolean", "(Ljava/lang/String;)Z", "", "putDouble", "(Ljava/lang/String;D)V", "getDouble", "(Ljava/lang/String;)D", "putInt", "(Ljava/lang/String;I)V", "getInt", "(Ljava/lang/String;)I", "", "putLong", "(Ljava/lang/String;J)V", "getLong", "(Ljava/lang/String;)J", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "data", "putData", "(Ljava/lang/String;Lnet/gotev/uploadservice/persistence/PersistableData;)V", "getData", "(Ljava/lang/String;)Lnet/gotev/uploadservice/persistence/PersistableData;", "", "putArrayData", "(Ljava/lang/String;Ljava/util/List;)V", "getArrayData", "(Ljava/lang/String;)Ljava/util/List;", "Landroid/os/Bundle;", "toBundle", "()Landroid/os/Bundle;", "toJson", "()Ljava/lang/String;", "checkExists", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Z)Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "<init>", "()V", "CREATOR", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public class PersistableData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    @NotNull
    public final HashMap<String, Object> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lnet/gotev/uploadservice/persistence/PersistableData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lnet/gotev/uploadservice/persistence/PersistableData;", "", "size", "", "newArray", "(I)[Lnet/gotev/uploadservice/persistence/PersistableData;", "", "rawJsonString", "fromJson", "(Ljava/lang/String;)Lnet/gotev/uploadservice/persistence/PersistableData;", "separator", "Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class CREATOR implements Parcelable.Creator<PersistableData> {
        public CREATOR() {
        }

        @JvmStatic
        @NotNull
        public final PersistableData fromJson(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "rawJsonString");
            JSONObject jSONObject = new JSONObject(str);
            PersistableData persistableData = new PersistableData();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if ((obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
                    HashMap<String, Object> data = persistableData.getData();
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    data.put(next, obj);
                }
            }
            return persistableData;
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public PersistableData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PersistableData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public PersistableData[] newArray(int i) {
            return new PersistableData[i];
        }
    }

    public PersistableData() {
        this.a = new HashMap<>();
    }

    public static /* synthetic */ String b(PersistableData persistableData, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        persistableData.a(str, z);
        return str;
    }

    @JvmStatic
    @NotNull
    public static final PersistableData fromJson(@NotNull String str) {
        return CREATOR.fromJson(str);
    }

    public final String a(String str, boolean z) {
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "$", false, 2, (Object) null)) {
            throw new IllegalArgumentException("key cannot contain $ as it's a reserved character, used for nested data");
        } else if (!z || this.a.containsKey(str)) {
            return str;
        } else {
            throw new IllegalArgumentException(a.d3("no data found for key \"", str, Typography.quote));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof PersistableData)) {
            return false;
        }
        return Intrinsics.areEqual(this.a, ((PersistableData) obj).a);
    }

    @NotNull
    public final List<PersistableData> getArrayData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Set<Map.Entry<String, Object>> entrySet = this.a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "data.entries");
        ArrayList arrayList = new ArrayList();
        for (T t : entrySet) {
            Object key = t.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            if (m.startsWith$default((String) key, a.K2(str, Typography.dollar), false, 2, null)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (arrayList2.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<Map.Entry> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            Object key2 = ((Map.Entry) obj).getKey();
            Intrinsics.checkNotNullExpressionValue(key2, "it.key");
            if (m.startsWith$default((String) key2, str + Typography.dollar + 0 + Typography.dollar, false, 2, null)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (!arrayList3.isEmpty()) {
            PersistableData persistableData = new PersistableData();
            for (Map.Entry entry : arrayList3) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                HashMap<String, Object> hashMap = persistableData.a;
                Intrinsics.checkNotNullExpressionValue(str2, "entryKey");
                String removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) (str + Typography.dollar + i + Typography.dollar));
                Intrinsics.checkNotNullExpressionValue(value, "entryValue");
                hashMap.put(removePrefix, value);
            }
            arrayList2.removeAll(arrayList3);
            arrayList4.add(persistableData);
            i++;
            arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                Object key3 = ((Map.Entry) obj2).getKey();
                Intrinsics.checkNotNullExpressionValue(key3, "it.key");
                if (m.startsWith$default((String) key3, str + Typography.dollar + i + Typography.dollar, false, 2, null)) {
                    arrayList3.add(obj2);
                }
            }
        }
        return arrayList4;
    }

    public final boolean getBoolean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        a(str, true);
        Object obj = hashMap.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @NotNull
    public final HashMap<String, Object> getData() {
        return this.a;
    }

    public final double getDouble(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        a(str, true);
        Object obj = hashMap.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
    }

    public final int getInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        a(str, true);
        Object obj = hashMap.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj).intValue();
    }

    public final long getLong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        a(str, true);
        Object obj = hashMap.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    @NotNull
    public final String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        a(str, true);
        Object obj = hashMap.get(str);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    public final void putArrayData(@NotNull String str, @NotNull List<? extends PersistableData> list) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(list, "data");
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            for (Map.Entry<String, Object> entry : t.a.entrySet()) {
                Object value = entry.getValue();
                HashMap<String, Object> hashMap = this.a;
                hashMap.put(str + Typography.dollar + i + Typography.dollar + entry.getKey(), value);
            }
            i = i2;
        }
    }

    public final void putBoolean(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        b(this, str, false, 1, null);
        hashMap.put(str, Boolean.valueOf(z));
    }

    public final void putData(@NotNull String str, @NotNull PersistableData persistableData) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(persistableData, "data");
        for (Map.Entry<String, Object> entry : persistableData.a.entrySet()) {
            Object value = entry.getValue();
            HashMap<String, Object> hashMap = this.a;
            hashMap.put(str + Typography.dollar + entry.getKey(), value);
        }
    }

    public final void putDouble(@NotNull String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        b(this, str, false, 1, null);
        hashMap.put(str, Double.valueOf(d));
    }

    public final void putInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        b(this, str, false, 1, null);
        hashMap.put(str, Integer.valueOf(i));
    }

    public final void putLong(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        HashMap<String, Object> hashMap = this.a;
        b(this, str, false, 1, null);
        hashMap.put(str, Long.valueOf(j));
    }

    public final void putString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        HashMap<String, Object> hashMap = this.a;
        b(this, str, false, 1, null);
        hashMap.put(str, str2);
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Set<String> keySet = this.a.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "data.keys");
        for (T t : keySet) {
            Object obj = this.a.get(t);
            if (obj instanceof Boolean) {
                bundle.putBoolean(t, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(t, ((Number) obj).doubleValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(t, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(t, ((Number) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(t, (String) obj);
            }
        }
        return bundle;
    }

    @NotNull
    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        Set<String> keySet = this.a.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "data.keys");
        for (T t : keySet) {
            Object obj = this.a.get(t);
            if ((obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
                jSONObject.put(t, obj);
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().also { json…       }\n    }.toString()");
        return jSONObject2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        toBundle().writeToParcel(parcel, i);
    }

    @NotNull
    public final PersistableData getData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Set<Map.Entry<String, Object>> entrySet = this.a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "data.entries");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (T t : entrySet) {
            Object key = t.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            if (m.startsWith$default((String) key, a.K2(str, Typography.dollar), false, 2, null)) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            return new PersistableData();
        }
        PersistableData persistableData = new PersistableData();
        for (Map.Entry entry : arrayList) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap<String, Object> hashMap = persistableData.a;
            Intrinsics.checkNotNullExpressionValue(str2, "entryKey");
            String removePrefix = StringsKt__StringsKt.removePrefix(str2, (CharSequence) (str + Typography.dollar));
            Intrinsics.checkNotNullExpressionValue(value, "entryValue");
            hashMap.put(removePrefix, value);
        }
        return persistableData;
    }

    public PersistableData(Parcel parcel, j jVar) {
        this();
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            Set<String> keySet = readBundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
            for (T t : keySet) {
                Object obj = readBundle.get(t);
                if ((obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
                    HashMap<String, Object> hashMap = this.a;
                    Intrinsics.checkNotNullExpressionValue(t, "key");
                    hashMap.put(t, obj);
                }
            }
        }
    }
}
