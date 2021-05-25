package com.avito.android.messenger.conversation.mvi.messages;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", "", "", "Lcom/avito/android/remote/model/Image;", "component1", "()Ljava/util/List;", "", "component2", "()I", "images", VKApiConst.POSITION, "copy", "(Ljava/util/List;I)Lcom/avito/android/messenger/conversation/mvi/messages/OpenGalleryData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getImages", AuthSource.BOOKING_ORDER, "I", "getPosition", "<init>", "(Ljava/util/List;I)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OpenGalleryData {
    @NotNull
    public final List<Image> a;
    public final int b;

    public OpenGalleryData(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        this.a = list;
        this.b = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.messages.OpenGalleryData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenGalleryData copy$default(OpenGalleryData openGalleryData, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = openGalleryData.a;
        }
        if ((i2 & 2) != 0) {
            i = openGalleryData.b;
        }
        return openGalleryData.copy(list, i);
    }

    @NotNull
    public final List<Image> component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final OpenGalleryData copy(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        return new OpenGalleryData(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenGalleryData)) {
            return false;
        }
        OpenGalleryData openGalleryData = (OpenGalleryData) obj;
        return Intrinsics.areEqual(this.a, openGalleryData.a) && this.b == openGalleryData.b;
    }

    @NotNull
    public final List<Image> getImages() {
        return this.a;
    }

    public final int getPosition() {
        return this.b;
    }

    public int hashCode() {
        List<Image> list = this.a;
        return ((list != null ? list.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OpenGalleryData(images=");
        L.append(this.a);
        L.append(", position=");
        return a.j(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OpenGalleryData(List list, int i, int i2, j jVar) {
        this(list, (i2 & 2) != 0 ? 0 : i);
    }
}
