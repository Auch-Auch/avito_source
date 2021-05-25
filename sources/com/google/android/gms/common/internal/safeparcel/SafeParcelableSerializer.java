package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
@VisibleForTesting
@KeepForSdk
public final class SafeParcelableSerializer {
    @RecentlyNonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromBytes(@RecentlyNonNull byte[] bArr, @RecentlyNonNull Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @RecentlyNullable
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromIntentExtra(@RecentlyNonNull Intent intent, @RecentlyNonNull String str, @RecentlyNonNull Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) deserializeFromBytes(byteArrayExtra, creator);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromString(@RecentlyNonNull String str, @RecentlyNonNull Parcelable.Creator<T> creator) {
        return (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    @RecentlyNullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(@RecentlyNonNull Bundle bundle, @RecentlyNonNull String str, @RecentlyNonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    @RecentlyNullable
    @KeepForSdk
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(@RecentlyNonNull Intent intent, @RecentlyNonNull String str, @RecentlyNonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        return arrayList2;
    }

    public static <T extends SafeParcelable> void serializeIterableToBundle(@RecentlyNonNull Iterable<T> iterable, @RecentlyNonNull Bundle bundle, @RecentlyNonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(serializeToBytes(t));
        }
        bundle.putSerializable(str, arrayList);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(@RecentlyNonNull Iterable<T> iterable, @RecentlyNonNull Intent intent, @RecentlyNonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(serializeToBytes(t));
        }
        intent.putExtra(str, arrayList);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] serializeToBytes(@RecentlyNonNull T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeToIntentExtra(@RecentlyNonNull T t, @RecentlyNonNull Intent intent, @RecentlyNonNull String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T extends SafeParcelable> String serializeToString(@RecentlyNonNull T t) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }
}
