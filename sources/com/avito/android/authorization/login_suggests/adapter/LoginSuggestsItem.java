package com.avito.android.authorization.login_suggests.adapter;

import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/LoginSuggestsItem;", "Lcom/avito/konveyor/blueprint/Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public abstract class LoginSuggestsItem implements Item, Parcelable {
    public final long a;

    public LoginSuggestsItem(long j) {
        this.a = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }
}
