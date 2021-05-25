package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.internal.ServerProtocol;
import java.io.Serializable;
import okhttp3.HttpUrl;
public abstract class NavType<T> {
    @NonNull
    public static final NavType<boolean[]> BoolArrayType = new k(true);
    @NonNull
    public static final NavType<Boolean> BoolType = new j(false);
    @NonNull
    public static final NavType<float[]> FloatArrayType = new i(true);
    @NonNull
    public static final NavType<Float> FloatType = new h(false);
    @NonNull
    public static final NavType<int[]> IntArrayType = new e(true);
    @NonNull
    public static final NavType<Integer> IntType = new c(false);
    @NonNull
    public static final NavType<long[]> LongArrayType = new g(true);
    @NonNull
    public static final NavType<Long> LongType = new f(false);
    @NonNull
    public static final NavType<Integer> ReferenceType = new d(false);
    @NonNull
    public static final NavType<String[]> StringArrayType = new b(true);
    @NonNull
    public static final NavType<String> StringType = new a(true);
    public final boolean a;

    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        @NonNull
        public final Class<D[]> b;

        public ParcelableArrayType(@NonNull Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.b = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ParcelableArrayType.class != obj.getClass()) {
                return false;
            }
            return this.b.equals(((ParcelableArrayType) obj).b);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.b.getName();
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.b.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    public static final class ParcelableType<D> extends NavType<D> {
        @NonNull
        public final Class<D> b;

        public ParcelableType(@NonNull Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.b = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ParcelableType.class != obj.getClass()) {
                return false;
            }
            return this.b.equals(((ParcelableType) obj).b);
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D get(@NonNull Bundle bundle, @NonNull String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.b.getName();
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D d) {
            this.b.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, d);
            }
        }
    }

    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        @NonNull
        public final Class<D[]> b;

        public SerializableArrayType(@NonNull Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.b = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SerializableArrayType.class != obj.getClass()) {
                return false;
            }
            return this.b.equals(((SerializableArrayType) obj).b);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.b.getName();
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: D extends java.io.Serializable[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.b.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    public static class SerializableType<D extends Serializable> extends NavType<D> {
        @NonNull
        public final Class<D> b;

        public SerializableType(@NonNull Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.b = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return this.b.equals(((SerializableType) obj).b);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.b.getName();
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: androidx.navigation.NavType$SerializableType<D extends java.io.Serializable> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(@NonNull Bundle bundle, @NonNull String str, @Nullable Object obj) {
            put(bundle, str, (String) ((Serializable) obj));
        }

        @Override // androidx.navigation.NavType
        @Nullable
        public D get(@NonNull Bundle bundle, @NonNull String str) {
            return (D) ((Serializable) bundle.get(str));
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable D d) {
            this.b.cast(d);
            bundle.putSerializable(str, d);
        }

        public SerializableType(boolean z, @NonNull Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.b = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    public static class a extends NavType<String> {
        public a(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public String get(@NonNull Bundle bundle, @NonNull String str) {
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return Types.STRING;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public String parseValue(@NonNull String str) {
            return str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable String str2) {
            bundle.putString(str, str2);
        }
    }

    public static class b extends NavType<String[]> {
        public b(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public String[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "string[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public String[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    public static class c extends NavType<Integer> {
        public c(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public Integer get(@NonNull Bundle bundle, @NonNull String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "integer";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public Integer parseValue(@NonNull String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public static class d extends NavType<Integer> {
        public d(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @AnyRes
        public Integer get(@NonNull Bundle bundle, @NonNull String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "reference";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public Integer parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull @AnyRes Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    public static class e extends NavType<int[]> {
        public e(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public int[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "integer[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public int[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    public static class f extends NavType<Long> {
        public f(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public Long get(@NonNull Bundle bundle, @NonNull String str) {
            return (Long) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "long";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public Long parseValue(@NonNull String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    public static class g extends NavType<long[]> {
        public g(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public long[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "long[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public long[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    public static class h extends NavType<Float> {
        public h(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public Float get(@NonNull Bundle bundle, @NonNull String str) {
            return (Float) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return Types.FLOAT;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public Float parseValue(@NonNull String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    public static class i extends NavType<float[]> {
        public i(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public float[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "float[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public float[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public static class j extends NavType<Boolean> {
        public j(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public Boolean get(@NonNull Bundle bundle, @NonNull String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return Types.BOOLEAN;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public Boolean parseValue(@NonNull String str) {
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @NonNull Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    public static class k extends NavType<boolean[]> {
        public k(boolean z) {
            super(z);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        public boolean[] get(@NonNull Bundle bundle, @NonNull String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        @NonNull
        public String getName() {
            return "boolean[]";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.navigation.NavType
        @NonNull
        public boolean[] parseValue(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Bundle, java.lang.String, java.lang.Object] */
        @Override // androidx.navigation.NavType
        public void put(@NonNull Bundle bundle, @NonNull String str, @Nullable boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public NavType(boolean z) {
        this.a = z;
    }

    @NonNull
    public static NavType<?> fromArgType(@Nullable String str, @Nullable String str2) {
        String str3;
        NavType<Integer> navType = IntType;
        if (navType.getName().equals(str)) {
            return navType;
        }
        NavType navType2 = IntArrayType;
        if (navType2.getName().equals(str)) {
            return navType2;
        }
        NavType<Long> navType3 = LongType;
        if (navType3.getName().equals(str)) {
            return navType3;
        }
        NavType navType4 = LongArrayType;
        if (navType4.getName().equals(str)) {
            return navType4;
        }
        NavType<Boolean> navType5 = BoolType;
        if (navType5.getName().equals(str)) {
            return navType5;
        }
        NavType navType6 = BoolArrayType;
        if (navType6.getName().equals(str)) {
            return navType6;
        }
        NavType<String> navType7 = StringType;
        if (navType7.getName().equals(str)) {
            return navType7;
        }
        NavType navType8 = StringArrayType;
        if (navType8.getName().equals(str)) {
            return navType8;
        }
        NavType<Float> navType9 = FloatType;
        if (navType9.getName().equals(str)) {
            return navType9;
        }
        NavType navType10 = FloatArrayType;
        if (navType10.getName().equals(str)) {
            return navType10;
        }
        NavType<Integer> navType11 = ReferenceType;
        if (navType11.getName().equals(str)) {
            return navType11;
        }
        if (str == null || str.isEmpty()) {
            return navType7;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new ParcelableArrayType(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new SerializableArrayType(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new ParcelableType(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new EnumType(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new SerializableType(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Nullable
    public abstract T get(@NonNull Bundle bundle, @NonNull String str);

    @NonNull
    public abstract String getName();

    public boolean isNullableAllowed() {
        return this.a;
    }

    @NonNull
    public abstract T parseValue(@NonNull String str);

    public abstract void put(@NonNull Bundle bundle, @NonNull String str, @Nullable T t);

    @NonNull
    public String toString() {
        return getName();
    }

    public static final class EnumType<D extends Enum> extends SerializableType<D> {
        @NonNull
        public final Class<D> c;

        public EnumType(@NonNull Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.c = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @NonNull
        public String getName() {
            return this.c.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        @NonNull
        public D parseValue(@NonNull String str) {
            D[] enumConstants = this.c.getEnumConstants();
            for (D d : enumConstants) {
                if (d.name().equals(str)) {
                    return d;
                }
            }
            throw new IllegalArgumentException(a2.b.a.a.a.D2(this.c, a2.b.a.a.a.R("Enum value ", str, " not found for type "), "."));
        }
    }
}
