package com.avito.android.vas.list_legacy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.vas.Package;
import com.avito.android.remote.model.vas.Service;
import com.avito.android.remote.model.vas.ServiceDiscount;
import com.avito.android.util.ParcelsKt;
public class VasInfo implements Parcelable {
    public static final Parcelable.Creator<VasInfo> CREATOR = new a();
    @Nullable
    public final Package a;
    @Nullable
    public final Service b;
    public final String c;
    public final boolean d;

    public class a implements Parcelable.Creator<VasInfo> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VasInfo createFromParcel(Parcel parcel) {
            return new VasInfo(parcel, (a) null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VasInfo[] newArray(int i) {
            return new VasInfo[i];
        }
    }

    public VasInfo(@NonNull String str, @NonNull Package r2) {
        this.c = str;
        this.a = r2;
        this.b = null;
        this.d = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof VasInfo)) {
            return false;
        }
        VasInfo vasInfo = (VasInfo) obj;
        boolean z = (this.b == null && vasInfo.getService() == null) || !(this.b == null || vasInfo.getService() == null || !vasInfo.getService().equals(this.b));
        boolean z2 = (this.a == null && vasInfo.getPackage() == null) || !(this.a == null || vasInfo.getPackage() == null || !vasInfo.getPackage().equals(this.a));
        if (!z || !z2 || !this.c.equals(vasInfo.getItemId()) || this.d != vasInfo.isPaidView()) {
            return false;
        }
        return true;
    }

    public ServiceDiscount getDiscount() {
        if (isPackage()) {
            return this.a.getDiscount();
        }
        return this.b.getDiscount();
    }

    public String getFullName() {
        if (isPackage()) {
            return this.a.getName();
        }
        return this.b.getFullName();
    }

    public Integer getFullPrice() {
        if (isPackage()) {
            return Integer.valueOf(this.a.getFullPrice());
        }
        return this.b.getFullPrice();
    }

    @NonNull
    public String getItemId() {
        return this.c;
    }

    @Nullable
    public Package getPackage() {
        return this.a;
    }

    public int getPrice() {
        if (isPackage()) {
            return this.a.getPrice();
        }
        return this.b.getPrice();
    }

    @Nullable
    public Service getService() {
        return this.b;
    }

    public String getShortName() {
        if (isPackage()) {
            return this.a.getName();
        }
        return this.b.getShortName();
    }

    @Override // java.lang.Object
    public int hashCode() {
        Package r0 = this.a;
        int i = 0;
        if (r0 != null) {
            i = 0 + r0.hashCode();
        }
        Service service = this.b;
        if (service != null) {
            i = (i * 31) + service.hashCode();
        }
        return Boolean.valueOf(this.d).hashCode() + a2.b.a.a.a.B0(this.c, i * 31, 31);
    }

    public boolean isPackage() {
        return this.a != null;
    }

    public boolean isPaidView() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
        ParcelsKt.writeBool(parcel, this.d);
    }

    public VasInfo(@NonNull String str, @NonNull Service service) {
        this.c = str;
        this.b = service;
        this.a = null;
        this.d = false;
    }

    public VasInfo(@NonNull String str, @NonNull Service service, boolean z) {
        this.c = str;
        this.b = service;
        this.a = null;
        this.d = z;
    }

    public VasInfo(Parcel parcel, a aVar) {
        this.a = (Package) parcel.readParcelable(Package.class.getClassLoader());
        this.b = (Service) parcel.readParcelable(Service.class.getClassLoader());
        this.c = parcel.readString();
        this.d = ParcelsKt.readBool(parcel);
    }
}
