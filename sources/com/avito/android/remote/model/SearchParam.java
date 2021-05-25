package com.avito.android.remote.model;

import android.os.Parcelable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/SearchParam;", "T", "Landroid/os/Parcelable;", "", "describeContents", "()I", "getValue", "()Ljava/lang/Object;", "value", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class SearchParam<T> implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract T getValue();
}
