package ru.avito.component.stories.single;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lru/avito/component/stories/single/StoryCarouselItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/Color;", "c", "Lcom/avito/android/remote/model/Color;", "getBackground", "()Lcom/avito/android/remote/model/Color;", "background", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "e", "Z", "isViewed", "()Z", "Lcom/avito/android/image_loader/Picture;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/image_loader/Picture;", "getPicture", "()Lcom/avito/android/image_loader/Picture;", "picture", "d", "getTitle", "title", "<init>", "(Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StoryCarouselItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final Picture b;
    @NotNull
    public final Color c;
    @NotNull
    public final String d;
    public final boolean e;

    public StoryCarouselItem(@NotNull String str, @Nullable Picture picture, @NotNull Color color, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(color, "background");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = picture;
        this.c = color;
        this.d = str2;
        this.e = z;
    }

    @NotNull
    public final Color getBackground() {
        return this.c;
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

    @NotNull
    public final String getTitle() {
        return this.d;
    }

    public final boolean isViewed() {
        return this.e;
    }
}
