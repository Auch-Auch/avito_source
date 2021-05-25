package com.avito.android.messenger.map.search.adapter;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0017\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010&\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010)\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u0012\b\u0010#\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010,\u001a\u00020\n¢\u0006\u0004\b-\u0010.J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0013\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\fR\u001b\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\fR\u0019\u0010&\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u0019\u0010)\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\fR\u0019\u0010,\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\f¨\u0006/"}, d2 = {"Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "Lcom/avito/conveyor_item/Item;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "e", "Ljava/lang/String;", "getKind", MessageBody.Location.KIND, AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "Z", "isSendable", "()Z", "", "d", "D", "getLongitude", "()D", GeoContract.LONGITUDE, g.a, "getName", "name", "h", "getDescription", "description", "c", "getLatitude", GeoContract.LATITUDE, "f", "getTitle", "title", "i", "getAddressType", "addressType", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchSuggestItem implements Item {
    @NotNull
    public final String a = String.valueOf(hashCode());
    public final boolean b;
    public final double c;
    public final double d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @Nullable
    public final String h;
    @NotNull
    public final String i;

    public GeoSearchSuggestItem(double d2, double d3, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5) {
        a.b1(str, MessageBody.Location.KIND, str2, "title", str3, "name", str5, "addressType");
        this.c = d2;
        this.d = d3;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        int hashCode = str.hashCode();
        this.b = hashCode == -891990013 ? !str.equals("street") : hashCode != 957831062 || !str.equals("country");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoSearchSuggestItem)) {
            return false;
        }
        GeoSearchSuggestItem geoSearchSuggestItem = (GeoSearchSuggestItem) obj;
        return this.c == geoSearchSuggestItem.c && this.d == geoSearchSuggestItem.d && !(Intrinsics.areEqual(this.e, geoSearchSuggestItem.e) ^ true) && !(Intrinsics.areEqual(this.f, geoSearchSuggestItem.f) ^ true) && !(Intrinsics.areEqual(this.h, geoSearchSuggestItem.h) ^ true);
    }

    @NotNull
    public final String getAddressType() {
        return this.i;
    }

    @Nullable
    public final String getDescription() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getKind() {
        return this.e;
    }

    public final double getLatitude() {
        return this.c;
    }

    public final double getLongitude() {
        return this.d;
    }

    @NotNull
    public final String getName() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.f;
    }

    public int hashCode() {
        int B0 = a.B0(this.f, a.B0(this.e, (Double.doubleToLongBits(this.d) + (Double.doubleToLongBits(this.c) * 31)) * 31, 31), 31);
        String str = this.h;
        return B0 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isSendable() {
        return this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GeoSearchSuggestItem(\n            |   latitude=");
        L.append(this.c);
        L.append(",\n            |   longitude=");
        L.append(this.d);
        L.append(",\n            |   kind='");
        L.append(this.e);
        L.append("',\n            |   title='");
        L.append(this.f);
        L.append("',\n            |   name='");
        L.append(this.g);
        L.append("',\n            |   description=");
        L.append(this.h);
        L.append(",\n            |   addressType=");
        L.append(this.i);
        L.append(",\n            |   stringId='");
        L.append(getStringId());
        L.append("',\n            |   isSendable=");
        return f.trimMargin$default(a.B(L, this.b, "\n            |)"), null, 1, null);
    }
}
