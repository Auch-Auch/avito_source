package ru.avito.component.serp.cyclic_gallery.image_carousel;

import android.net.Uri;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItem;", "Lcom/avito/conveyor_item/Item;", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getVideoLink", "()Landroid/net/Uri;", "videoLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/image_loader/Picture;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/image_loader/Picture;", "getPicture", "()Lcom/avito/android/image_loader/Picture;", "picture", "<init>", "(Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Landroid/net/Uri;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageCarouselItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final Picture b;
    @Nullable
    public final Uri c;

    public ImageCarouselItem(@NotNull String str, @Nullable Picture picture, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = picture;
        this.c = uri;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Picture getPicture() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final Uri getVideoLink() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageCarouselItem(String str, Picture picture, Uri uri, int i, j jVar) {
        this(str, picture, (i & 4) != 0 ? null : uri);
    }
}
