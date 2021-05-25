package com.avito.android.user_favorites.adapter;

import android.os.Parcelable;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b&\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "Lcom/avito/android/design/widget/tab/Tab;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "label", AuthSource.SEND_ABUSE, "getTitle", "title", "c", "Ljava/lang/Integer;", "getListBottomPaddingPx", "()Ljava/lang/Integer;", "listBottomPaddingPx", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public abstract class FavoritesTab implements Tab, Parcelable {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Integer c;

    public FavoritesTab(@NotNull String str, @Nullable String str2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = str2;
        this.c = num;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        return this.b;
    }

    @Nullable
    public Integer getListBottomPaddingPx() {
        return this.c;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.a;
    }
}
