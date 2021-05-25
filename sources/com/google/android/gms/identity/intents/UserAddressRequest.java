package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@SafeParcelable.Class(creator = "UserAddressRequestCreator")
@SafeParcelable.Reserved({1})
public final class UserAddressRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zzd();
    @SafeParcelable.Field(id = 2)
    public List<CountrySpecification> zzf;

    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            if (userAddressRequest.zzf == null) {
                userAddressRequest.zzf = new ArrayList();
            }
            UserAddressRequest.this.zzf.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecifications(Collection<CountrySpecification> collection) {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            if (userAddressRequest.zzf == null) {
                userAddressRequest.zzf = new ArrayList();
            }
            UserAddressRequest.this.zzf.addAll(collection);
            return this;
        }

        public final UserAddressRequest build() {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            List<CountrySpecification> list = userAddressRequest.zzf;
            if (list != null) {
                userAddressRequest.zzf = Collections.unmodifiableList(list);
            }
            return UserAddressRequest.this;
        }
    }

    public UserAddressRequest() {
    }

    @SafeParcelable.Constructor
    public UserAddressRequest(@SafeParcelable.Param(id = 2) List<CountrySpecification> list) {
        this.zzf = list;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
