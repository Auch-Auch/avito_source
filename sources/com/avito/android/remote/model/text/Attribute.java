package com.avito.android.remote.model.text;

import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/text/Attribute;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "getTitle", "()Ljava/lang/String;", "title", "getName", "name", "<init>", "()V", "Lcom/avito/android/remote/model/text/DeepLinkAttribute;", "Lcom/avito/android/remote/model/text/LinkAttribute;", "Lcom/avito/android/remote/model/text/FontAttribute;", "Lcom/avito/android/remote/model/text/DateAttribute;", "Lcom/avito/android/remote/model/text/UnknownAttribute;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class Attribute implements Parcelable {
    private Attribute() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract String getTitle();

    public /* synthetic */ Attribute(j jVar) {
        this();
    }
}
