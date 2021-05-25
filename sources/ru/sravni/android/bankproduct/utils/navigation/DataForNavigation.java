package ru.sravni.android.bankproduct.utils.navigation;

import a2.b.a.a.a;
import androidx.navigation.NavOptions;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/utils/navigation/DataForNavigation;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "Landroidx/navigation/NavOptions$Builder;", "component3", "()Landroidx/navigation/NavOptions$Builder;", "screenID", "argumentJson", "navOptions", "copy", "(ILjava/lang/String;Landroidx/navigation/NavOptions$Builder;)Lru/sravni/android/bankproduct/utils/navigation/DataForNavigation;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getArgumentJson", AuthSource.SEND_ABUSE, "I", "getScreenID", "c", "Landroidx/navigation/NavOptions$Builder;", "getNavOptions", "<init>", "(ILjava/lang/String;Landroidx/navigation/NavOptions$Builder;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DataForNavigation {
    public final int a;
    @Nullable
    public final String b;
    @Nullable
    public final NavOptions.Builder c;

    public DataForNavigation(int i, @Nullable String str, @Nullable NavOptions.Builder builder) {
        this.a = i;
        this.b = str;
        this.c = builder;
    }

    public static /* synthetic */ DataForNavigation copy$default(DataForNavigation dataForNavigation, int i, String str, NavOptions.Builder builder, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dataForNavigation.a;
        }
        if ((i2 & 2) != 0) {
            str = dataForNavigation.b;
        }
        if ((i2 & 4) != 0) {
            builder = dataForNavigation.c;
        }
        return dataForNavigation.copy(i, str, builder);
    }

    public final int component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final NavOptions.Builder component3() {
        return this.c;
    }

    @NotNull
    public final DataForNavigation copy(int i, @Nullable String str, @Nullable NavOptions.Builder builder) {
        return new DataForNavigation(i, str, builder);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataForNavigation)) {
            return false;
        }
        DataForNavigation dataForNavigation = (DataForNavigation) obj;
        return this.a == dataForNavigation.a && Intrinsics.areEqual(this.b, dataForNavigation.b) && Intrinsics.areEqual(this.c, dataForNavigation.c);
    }

    @Nullable
    public final String getArgumentJson() {
        return this.b;
    }

    @Nullable
    public final NavOptions.Builder getNavOptions() {
        return this.c;
    }

    public final int getScreenID() {
        return this.a;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        NavOptions.Builder builder = this.c;
        if (builder != null) {
            i2 = builder.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DataForNavigation(screenID=");
        L.append(this.a);
        L.append(", argumentJson=");
        L.append(this.b);
        L.append(", navOptions=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
