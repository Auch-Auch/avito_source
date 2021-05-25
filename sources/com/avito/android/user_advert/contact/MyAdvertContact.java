package com.avito.android.user_advert.contact;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.advert_details.UserIconType;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_advert/contact/MyAdvertContact;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "subTitle", AuthSource.SEND_ABUSE, "getTitle", "title", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "c", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "getIcon", "()Lcom/avito/android/remote/model/advert_details/UserIconType;", "icon", "Lcom/avito/android/remote/model/Image;", "d", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertContact {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final UserIconType c;
    @Nullable
    public final Image d;

    public MyAdvertContact(@Nullable String str, @Nullable String str2, @Nullable UserIconType userIconType, @Nullable Image image) {
        this.a = str;
        this.b = str2;
        this.c = userIconType;
        this.d = image;
    }

    @Nullable
    public final Image getAvatar() {
        return this.d;
    }

    @Nullable
    public final UserIconType getIcon() {
        return this.c;
    }

    @Nullable
    public final String getSubTitle() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyAdvertContact(String str, String str2, UserIconType userIconType, Image image, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : userIconType, (i & 8) != 0 ? null : image);
    }
}
