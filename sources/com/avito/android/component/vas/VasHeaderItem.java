package com.avito.android.component.vas;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/component/vas/VasHeaderItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/image_loader/Picture;", "d", "Lcom/avito/android/image_loader/Picture;", "getPicture", "()Lcom/avito/android/image_loader/Picture;", "picture", "", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "title", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/avito/android/image_loader/Picture;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VasHeaderItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    @Nullable
    public final CharSequence c;
    @NotNull
    public final Picture d;

    public VasHeaderItem(@NotNull String str, @NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(charSequence, "title");
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = picture;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final Picture getPicture() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final CharSequence getSubtitle() {
        return this.c;
    }

    @NotNull
    public final CharSequence getTitle() {
        return this.b;
    }
}
