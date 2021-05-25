package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModel {
    public final Bundle a;

    public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModelBuilder<P, E> {
        public Bundle a = new Bundle();

        public E putBoolean(String str, boolean z) {
            this.a.putBoolean(str, z);
            return this;
        }

        public E putBooleanArray(String str, @Nullable boolean[] zArr) {
            this.a.putBooleanArray(str, zArr);
            return this;
        }

        public E putDouble(String str, double d) {
            this.a.putDouble(str, d);
            return this;
        }

        public E putDoubleArray(String str, @Nullable double[] dArr) {
            this.a.putDoubleArray(str, dArr);
            return this;
        }

        public E putInt(String str, int i) {
            this.a.putInt(str, i);
            return this;
        }

        public E putIntArray(String str, @Nullable int[] iArr) {
            this.a.putIntArray(str, iArr);
            return this;
        }

        public E putLong(String str, long j) {
            this.a.putLong(str, j);
            return this;
        }

        public E putLongArray(String str, @Nullable long[] jArr) {
            this.a.putLongArray(str, jArr);
            return this;
        }

        public E putObject(String str, @Nullable ShareOpenGraphObject shareOpenGraphObject) {
            this.a.putParcelable(str, shareOpenGraphObject);
            return this;
        }

        public E putObjectArrayList(String str, @Nullable ArrayList<ShareOpenGraphObject> arrayList) {
            this.a.putParcelableArrayList(str, arrayList);
            return this;
        }

        public E putPhoto(String str, @Nullable SharePhoto sharePhoto) {
            this.a.putParcelable(str, sharePhoto);
            return this;
        }

        public E putPhotoArrayList(String str, @Nullable ArrayList<SharePhoto> arrayList) {
            this.a.putParcelableArrayList(str, arrayList);
            return this;
        }

        public E putString(String str, @Nullable String str2) {
            this.a.putString(str, str2);
            return this;
        }

        public E putStringArrayList(String str, @Nullable ArrayList<String> arrayList) {
            this.a.putStringArrayList(str, arrayList);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.share.model.ShareOpenGraphValueContainer$Builder<P extends com.facebook.share.model.ShareOpenGraphValueContainer, E extends com.facebook.share.model.ShareOpenGraphValueContainer$Builder> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            return readFrom((Builder<P, E>) ((ShareOpenGraphValueContainer) shareModel));
        }

        public E readFrom(P p) {
            if (p != null) {
                this.a.putAll(p.getBundle());
            }
            return this;
        }
    }

    public ShareOpenGraphValueContainer(Builder<P, E> builder) {
        this.a = (Bundle) builder.a.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Object get(String str) {
        return this.a.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    @Nullable
    public boolean[] getBooleanArray(String str) {
        return this.a.getBooleanArray(str);
    }

    public Bundle getBundle() {
        return (Bundle) this.a.clone();
    }

    public double getDouble(String str, double d) {
        return this.a.getDouble(str, d);
    }

    @Nullable
    public double[] getDoubleArray(String str) {
        return this.a.getDoubleArray(str);
    }

    public int getInt(String str, int i) {
        return this.a.getInt(str, i);
    }

    @Nullable
    public int[] getIntArray(String str) {
        return this.a.getIntArray(str);
    }

    public long getLong(String str, long j) {
        return this.a.getLong(str, j);
    }

    @Nullable
    public long[] getLongArray(String str) {
        return this.a.getLongArray(str);
    }

    public ShareOpenGraphObject getObject(String str) {
        Object obj = this.a.get(str);
        if (obj instanceof ShareOpenGraphObject) {
            return (ShareOpenGraphObject) obj;
        }
        return null;
    }

    @Nullable
    public ArrayList<ShareOpenGraphObject> getObjectArrayList(String str) {
        ArrayList parcelableArrayList = this.a.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<ShareOpenGraphObject> arrayList = new ArrayList<>();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable instanceof ShareOpenGraphObject) {
                arrayList.add((ShareOpenGraphObject) parcelable);
            }
        }
        return arrayList;
    }

    @Nullable
    public SharePhoto getPhoto(String str) {
        Parcelable parcelable = this.a.getParcelable(str);
        if (parcelable instanceof SharePhoto) {
            return (SharePhoto) parcelable;
        }
        return null;
    }

    @Nullable
    public ArrayList<SharePhoto> getPhotoArrayList(String str) {
        ArrayList parcelableArrayList = this.a.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<SharePhoto> arrayList = new ArrayList<>();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable instanceof SharePhoto) {
                arrayList.add((SharePhoto) parcelable);
            }
        }
        return arrayList;
    }

    @Nullable
    public String getString(String str) {
        return this.a.getString(str);
    }

    @Nullable
    public ArrayList<String> getStringArrayList(String str) {
        return this.a.getStringArrayList(str);
    }

    public Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    public ShareOpenGraphValueContainer(Parcel parcel) {
        this.a = parcel.readBundle(Builder.class.getClassLoader());
    }
}
