package com.avito.android.safedeal.delivery_courier.time_interval_select.model;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "", "<init>", "()V", "Error", "Loading", "Normal", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Normal;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Loading;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Error;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public abstract class DialogData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Error;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends DialogData {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.a;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Error(title="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Loading;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends DialogData {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Normal;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/Integer;", "title", "items", "iconRes", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/model/DialogData$Normal;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Integer;", "getIconRes", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    public static final class Normal extends DialogData {
        @NotNull
        public final String a;
        @NotNull
        public final List<Item> b;
        @Nullable
        public final Integer c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Normal(String str, List list, Integer num, int i, j jVar) {
            this(str, list, (i & 4) != 0 ? null : num);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData$Normal */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Normal copy$default(Normal normal, String str, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = normal.a;
            }
            if ((i & 2) != 0) {
                list = normal.b;
            }
            if ((i & 4) != 0) {
                num = normal.c;
            }
            return normal.copy(str, list, num);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final List<Item> component2() {
            return this.b;
        }

        @Nullable
        public final Integer component3() {
            return this.c;
        }

        @NotNull
        public final Normal copy(@NotNull String str, @NotNull List<? extends Item> list, @DrawableRes @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            return new Normal(str, list, num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Normal)) {
                return false;
            }
            Normal normal = (Normal) obj;
            return Intrinsics.areEqual(this.a, normal.a) && Intrinsics.areEqual(this.b, normal.b) && Intrinsics.areEqual(this.c, normal.c);
        }

        @Nullable
        public final Integer getIconRes() {
            return this.c;
        }

        @NotNull
        public final List<Item> getItems() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Item> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            Integer num = this.c;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Normal(title=");
            L.append(this.a);
            L.append(", items=");
            L.append(this.b);
            L.append(", iconRes=");
            return a.p(L, this.c, ")");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Normal(@NotNull String str, @NotNull List<? extends Item> list, @DrawableRes @Nullable Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            this.a = str;
            this.b = list;
            this.c = num;
        }
    }

    public DialogData() {
    }

    public DialogData(j jVar) {
    }
}
