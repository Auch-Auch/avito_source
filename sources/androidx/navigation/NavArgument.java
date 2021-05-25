package androidx.navigation;

import a2.b.a.a.a;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavType;
import java.io.Serializable;
public final class NavArgument {
    @NonNull
    public final NavType a;
    public final boolean b;
    public final boolean c;
    @Nullable
    public final Object d;

    public static final class Builder {
        @Nullable
        public NavType<?> a;
        public boolean b = false;
        @Nullable
        public Object c;
        public boolean d = false;

        @NonNull
        public NavArgument build() {
            NavType navType;
            NavType serializableType;
            if (this.a == null) {
                Object obj = this.c;
                if (obj instanceof Integer) {
                    navType = NavType.IntType;
                } else if (obj instanceof int[]) {
                    navType = NavType.IntArrayType;
                } else if (obj instanceof Long) {
                    navType = NavType.LongType;
                } else if (obj instanceof long[]) {
                    navType = NavType.LongArrayType;
                } else if (obj instanceof Float) {
                    navType = NavType.FloatType;
                } else if (obj instanceof float[]) {
                    navType = NavType.FloatArrayType;
                } else if (obj instanceof Boolean) {
                    navType = NavType.BoolType;
                } else if (obj instanceof boolean[]) {
                    navType = NavType.BoolArrayType;
                } else if ((obj instanceof String) || obj == null) {
                    navType = NavType.StringType;
                } else if (obj instanceof String[]) {
                    navType = NavType.StringArrayType;
                } else {
                    if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                        serializableType = new NavType.ParcelableArrayType(obj.getClass().getComponentType());
                    } else if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                        serializableType = new NavType.SerializableArrayType(obj.getClass().getComponentType());
                    } else if (obj instanceof Parcelable) {
                        serializableType = new NavType.ParcelableType(obj.getClass());
                    } else if (obj instanceof Enum) {
                        serializableType = new NavType.EnumType(obj.getClass());
                    } else if (obj instanceof Serializable) {
                        serializableType = new NavType.SerializableType(obj.getClass());
                    } else {
                        StringBuilder L = a.L("Object of type ");
                        L.append(obj.getClass().getName());
                        L.append(" is not supported for navigation arguments.");
                        throw new IllegalArgumentException(L.toString());
                    }
                    navType = serializableType;
                }
                this.a = navType;
            }
            return new NavArgument(this.a, this.b, this.c, this.d);
        }

        @NonNull
        public Builder setDefaultValue(@Nullable Object obj) {
            this.c = obj;
            this.d = true;
            return this;
        }

        @NonNull
        public Builder setIsNullable(boolean z) {
            this.b = z;
            return this;
        }

        @NonNull
        public Builder setType(@NonNull NavType<?> navType) {
            this.a = navType;
            return this;
        }
    }

    public NavArgument(@NonNull NavType<?> navType, boolean z, @Nullable Object obj, boolean z2) {
        if (!navType.isNullableAllowed() && z) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.a = navType;
            this.b = z;
            this.d = obj;
            this.c = z2;
        } else {
            StringBuilder L = a.L("Argument with type ");
            L.append(navType.getName());
            L.append(" has null value but is not nullable.");
            throw new IllegalArgumentException(L.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.b != navArgument.b || this.c != navArgument.c || !this.a.equals(navArgument.a)) {
            return false;
        }
        Object obj2 = this.d;
        Object obj3 = navArgument.d;
        if (obj2 != null) {
            return obj2.equals(obj3);
        }
        if (obj3 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Object getDefaultValue() {
        return this.d;
    }

    @NonNull
    public NavType<?> getType() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public boolean isDefaultValuePresent() {
        return this.c;
    }

    public boolean isNullable() {
        return this.b;
    }
}
