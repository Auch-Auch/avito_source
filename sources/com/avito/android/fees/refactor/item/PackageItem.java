package com.avito.android.fees.refactor.item;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.conveyor_item.Item;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010(\u001a\u00020#¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\"\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/fees/refactor/item/PackageItem;", "Lcom/avito/conveyor_item/Item;", "", "canShowDetails", "()Z", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "e", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "getLocation", "()Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "f", "Ljava/util/List;", "getRestrictions", "()Ljava/util/List;", "restrictions", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "c", "I", "getCountPercentage", "()I", "countPercentage", AuthSource.BOOKING_ORDER, "getCountDetails", "countDetails", "d", "getDaysLeft", "daysLeft", "", g.a, "J", "getPackageId", "()J", "packageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;J)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public final String d;
    @NotNull
    public final AdvertFeesEntity e;
    @NotNull
    public final List<AdvertFeesEntity> f;
    public final long g;

    public PackageItem(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list, long j) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "countDetails");
        Intrinsics.checkNotNullParameter(str3, "daysLeft");
        Intrinsics.checkNotNullParameter(advertFeesEntity, "location");
        Intrinsics.checkNotNullParameter(list, "restrictions");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = advertFeesEntity;
        this.f = list;
        this.g = j;
    }

    public final boolean canShowDetails() {
        boolean z;
        if (this.f.size() <= 1 && !this.e.hasDetails()) {
            List<AdvertFeesEntity> list = this.f;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().hasDetails()) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String getCountDetails() {
        return this.b;
    }

    public final int getCountPercentage() {
        return this.c;
    }

    @NotNull
    public final String getDaysLeft() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final AdvertFeesEntity getLocation() {
        return this.e;
    }

    public final long getPackageId() {
        return this.g;
    }

    @NotNull
    public final List<AdvertFeesEntity> getRestrictions() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
