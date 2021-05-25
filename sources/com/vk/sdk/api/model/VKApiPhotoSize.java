package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiPhotoSize extends VKApiModel implements Comparable<VKApiPhotoSize>, Parcelable, Identifiable {
    public static Parcelable.Creator<VKApiPhotoSize> CREATOR = new a();
    public static final char M = 'm';
    public static final char O = 'o';
    public static final char P = 'p';
    public static final char Q = 'q';
    public static final char S = 's';
    public static final char W = 'w';
    public static final char X = 'x';
    public static final char Y = 'y';
    public static final char Z = 'z';
    public int height;
    public String src;
    public char type;
    public int width;

    public static class a implements Parcelable.Creator<VKApiPhotoSize> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhotoSize createFromParcel(Parcel parcel) {
            return new VKApiPhotoSize(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPhotoSize[] newArray(int i) {
            return new VKApiPhotoSize[i];
        }
    }

    public VKApiPhotoSize() {
    }

    public static void a(VKApiPhotoSize vKApiPhotoSize, float f, int i) {
        b(vKApiPhotoSize, Math.min(1.5f, f), i);
    }

    public static void b(VKApiPhotoSize vKApiPhotoSize, float f, int i) {
        vKApiPhotoSize.width = i;
        vKApiPhotoSize.height = (int) Math.ceil((double) (((float) i) / f));
    }

    public static void c(VKApiPhotoSize vKApiPhotoSize, float f, int i, int i2) {
        if (f > 1.0f) {
            vKApiPhotoSize.width = i;
            vKApiPhotoSize.height = (int) (((float) i) / f);
            return;
        }
        vKApiPhotoSize.height = i2;
        vKApiPhotoSize.width = (int) (((float) i2) * f);
    }

    public static VKApiPhotoSize create(String str, int i, int i2) {
        VKApiPhotoSize vKApiPhotoSize = new VKApiPhotoSize();
        vKApiPhotoSize.src = str;
        vKApiPhotoSize.width = i;
        vKApiPhotoSize.height = i2;
        float f = ((float) i) / ((float) i2);
        if (i <= 75) {
            vKApiPhotoSize.type = S;
        } else if (i <= 130) {
            vKApiPhotoSize.type = f <= 1.5f ? O : M;
        } else if (i <= 200 && f <= 1.5f) {
            vKApiPhotoSize.type = P;
        } else if (i <= 320 && f <= 1.5f) {
            vKApiPhotoSize.type = Q;
        } else if (i <= 604) {
            vKApiPhotoSize.type = X;
        } else if (i <= 807) {
            vKApiPhotoSize.type = Y;
        } else if (i <= 1280 && i2 <= 1024) {
            vKApiPhotoSize.type = Z;
        } else if (i <= 2560 && i2 <= 2048) {
            vKApiPhotoSize.type = W;
        }
        return vKApiPhotoSize;
    }

    public static void d(VKApiPhotoSize vKApiPhotoSize, int i, int i2) {
        float f = ((float) i) / ((float) i2);
        switch (vKApiPhotoSize.type) {
            case 'm':
                b(vKApiPhotoSize, f, Math.min(i, 130));
                return;
            case 'n':
            case 'r':
            case 't':
            case 'u':
            case 'v':
            default:
                return;
            case 'o':
                a(vKApiPhotoSize, f, Math.min(i, 130));
                return;
            case 'p':
                a(vKApiPhotoSize, f, Math.min(i, 200));
                return;
            case 'q':
                a(vKApiPhotoSize, f, Math.min(i, 320));
                return;
            case 's':
                b(vKApiPhotoSize, f, Math.min(i, 75));
                return;
            case 'w':
                c(vKApiPhotoSize, f, Math.min(i, 2560), Math.min(i2, 2048));
                return;
            case 'x':
                b(vKApiPhotoSize, f, Math.min(i, 604));
                return;
            case 'y':
                b(vKApiPhotoSize, f, Math.min(i, 807));
                return;
            case 'z':
                c(vKApiPhotoSize, f, Math.min(i, 1280), Math.min(i2, 1024));
                return;
        }
    }

    public static VKApiPhotoSize parse(JSONObject jSONObject, int i, int i2) {
        VKApiPhotoSize vKApiPhotoSize = new VKApiPhotoSize();
        vKApiPhotoSize.src = jSONObject.optString("src");
        vKApiPhotoSize.width = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        vKApiPhotoSize.height = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        String optString = jSONObject.optString("type");
        if (!TextUtils.isEmpty(optString)) {
            vKApiPhotoSize.type = optString.charAt(0);
        }
        if (vKApiPhotoSize.width == 0 || vKApiPhotoSize.height == 0) {
            d(vKApiPhotoSize, i, i2);
        }
        return vKApiPhotoSize;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.src);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.type);
    }

    public VKApiPhotoSize(Parcel parcel, a aVar) {
        this.src = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.type = (char) parcel.readInt();
    }

    public int compareTo(VKApiPhotoSize vKApiPhotoSize) {
        int i = this.width;
        int i2 = vKApiPhotoSize.width;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public VKApiPhotoSize(JSONObject jSONObject) throws JSONException {
        parse(jSONObject, 0, 0);
    }

    public static VKApiPhotoSize create(String str, char c, int i, int i2) {
        VKApiPhotoSize vKApiPhotoSize = new VKApiPhotoSize();
        vKApiPhotoSize.src = str;
        vKApiPhotoSize.type = c;
        d(vKApiPhotoSize, i, i2);
        return vKApiPhotoSize;
    }

    public static VKApiPhotoSize create(String str, int i) {
        return create(str, i, i);
    }
}
