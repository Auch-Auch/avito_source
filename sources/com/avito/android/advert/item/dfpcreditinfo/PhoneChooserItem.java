package com.avito.android.advert.item.dfpcreditinfo;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "", "<init>", "()V", "Error", "Loading", "Phone", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Loading;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Error;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneChooserItem {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Error;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends PhoneChooserItem {
        @NotNull
        public static final Error INSTANCE = new Error();

        public Error() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Loading;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends PhoneChooserItem {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem;", "", "component1", "()Ljava/lang/String;", "phone", "copy", "(Ljava/lang/String;)Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Phone extends PhoneChooserItem {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Phone(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
        }

        public static /* synthetic */ Phone copy$default(Phone phone, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = phone.a;
            }
            return phone.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Phone copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "phone");
            return new Phone(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Phone) && Intrinsics.areEqual(this.a, ((Phone) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getPhone() {
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
            return a.t(a.L("Phone(phone="), this.a, ")");
        }
    }

    public PhoneChooserItem() {
    }

    public PhoneChooserItem(j jVar) {
    }
}
