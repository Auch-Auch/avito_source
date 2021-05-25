package ru.sravni.android.bankproduct.repository.dashboard.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/entity/HelloMessageInfoRepo;", "", "", "component1", "()I", "component2", "component3", "before", "after", "messageID", "copy", "(III)Lru/sravni/android/bankproduct/repository/dashboard/entity/HelloMessageInfoRepo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getMessageID", AuthSource.BOOKING_ORDER, "getAfter", AuthSource.SEND_ABUSE, "getBefore", "<init>", "(III)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class HelloMessageInfoRepo {
    public final int a;
    public final int b;
    public final int c;

    public HelloMessageInfoRepo(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static /* synthetic */ HelloMessageInfoRepo copy$default(HelloMessageInfoRepo helloMessageInfoRepo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = helloMessageInfoRepo.a;
        }
        if ((i4 & 2) != 0) {
            i2 = helloMessageInfoRepo.b;
        }
        if ((i4 & 4) != 0) {
            i3 = helloMessageInfoRepo.c;
        }
        return helloMessageInfoRepo.copy(i, i2, i3);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final HelloMessageInfoRepo copy(int i, int i2, int i3) {
        return new HelloMessageInfoRepo(i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelloMessageInfoRepo)) {
            return false;
        }
        HelloMessageInfoRepo helloMessageInfoRepo = (HelloMessageInfoRepo) obj;
        return this.a == helloMessageInfoRepo.a && this.b == helloMessageInfoRepo.b && this.c == helloMessageInfoRepo.c;
    }

    public final int getAfter() {
        return this.b;
    }

    public final int getBefore() {
        return this.a;
    }

    public final int getMessageID() {
        return this.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("HelloMessageInfoRepo(before=");
        L.append(this.a);
        L.append(", after=");
        L.append(this.b);
        L.append(", messageID=");
        return a.j(L, this.c, ")");
    }
}
