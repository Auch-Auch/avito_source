package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.api.model.VKList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
public class VKPhotoSizes extends VKList<VKApiPhotoSize> implements Parcelable {
    public static Parcelable.Creator<VKPhotoSizes> CREATOR = new b();
    public static float l = 1.0f;
    public int e = 1;
    public int f = 1;
    public String g;
    public String h;
    public int i;
    public int j;
    public final VKList.Parser<VKApiPhotoSize> k = new a();

    public class a implements VKList.Parser<VKApiPhotoSize> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.vk.sdk.api.model.VKList.Parser
        public VKApiPhotoSize parseObject(JSONObject jSONObject) throws Exception {
            VKPhotoSizes vKPhotoSizes = VKPhotoSizes.this;
            return VKApiPhotoSize.parse(jSONObject, vKPhotoSizes.e, vKPhotoSizes.f);
        }
    }

    public static class b implements Parcelable.Creator<VKPhotoSizes> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPhotoSizes createFromParcel(Parcel parcel) {
            return new VKPhotoSizes(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKPhotoSizes[] newArray(int i) {
            return new VKPhotoSizes[i];
        }
    }

    public VKPhotoSizes() {
    }

    public static void setQuality(float f2) {
        l = f2;
    }

    @Override // com.vk.sdk.api.model.VKList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void fill(JSONArray jSONArray, int i2, int i3) {
        setOriginalDimension(i2, i3);
        fill(jSONArray);
    }

    public String getByType(char c) {
        Iterator it = iterator();
        while (it.hasNext()) {
            VKApiPhotoSize vKApiPhotoSize = (VKApiPhotoSize) it.next();
            if (vKApiPhotoSize.type == c) {
                return vKApiPhotoSize.src;
            }
        }
        return null;
    }

    public String getImageForDimension(int i2, int i3) {
        if (i2 >= i3) {
            if ((this.g != null && this.i != i2) || isEmpty()) {
                return this.g;
            }
            this.i = i2;
            this.g = null;
            int i4 = (int) (((float) i2) * l);
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VKApiPhotoSize vKApiPhotoSize = (VKApiPhotoSize) it.next();
                if (vKApiPhotoSize.width >= i4) {
                    this.g = vKApiPhotoSize.src;
                    break;
                }
            }
            return this.g;
        } else if ((this.h != null && this.j != i3) || isEmpty()) {
            return this.h;
        } else {
            this.j = i3;
            this.h = null;
            int i5 = (int) (((float) i3) * l);
            Iterator it2 = iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                VKApiPhotoSize vKApiPhotoSize2 = (VKApiPhotoSize) it2.next();
                if (vKApiPhotoSize2.height >= i5) {
                    this.h = vKApiPhotoSize2.src;
                    break;
                }
            }
            return this.h;
        }
    }

    public void setOriginalDimension(int i2, int i3) {
        if (i2 != 0) {
            this.e = i2;
        }
        if (i3 != 0) {
            this.f = i3;
        }
    }

    public void sort() {
        Collections.sort(this);
    }

    @Override // com.vk.sdk.api.model.VKList, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.i);
    }

    public void fill(JSONArray jSONArray) {
        fill(jSONArray, this.k);
        sort();
    }

    public VKPhotoSizes(JSONArray jSONArray) {
        fill(jSONArray);
    }

    public VKPhotoSizes(Parcel parcel, a aVar) {
        super(parcel);
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.i = parcel.readInt();
    }
}
