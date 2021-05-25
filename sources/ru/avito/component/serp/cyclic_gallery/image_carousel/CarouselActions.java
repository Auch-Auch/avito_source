package ru.avito.component.serp.cyclic_gallery.image_carousel;

import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "", "<init>", "()V", "CallClick", "DeeplinkClick", "ImageClick", "VideoClick", "WriteClick", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$ImageClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$VideoClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$CallClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$WriteClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$DeeplinkClick;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class CarouselActions {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$CallClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallClick extends CarouselActions {
        @NotNull
        public static final CallClick INSTANCE = new CallClick();

        public CallClick() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$DeeplinkClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeeplinkClick extends CarouselActions {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeeplinkClick(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$ImageClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "", AuthSource.SEND_ABUSE, "I", "getImagePosition", "()I", "imagePosition", "<init>", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageClick extends CarouselActions {
        public final int a;

        public ImageClick(int i) {
            super(null);
            this.a = i;
        }

        public final int getImagePosition() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$VideoClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getVideoLink", "()Landroid/net/Uri;", "videoLink", "", AuthSource.BOOKING_ORDER, "I", "getVideoPosition", "()I", "videoPosition", "<init>", "(Landroid/net/Uri;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class VideoClick extends CarouselActions {
        @NotNull
        public final Uri a;
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoClick(@NotNull Uri uri, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "videoLink");
            this.a = uri;
            this.b = i;
        }

        @NotNull
        public final Uri getVideoLink() {
            return this.a;
        }

        public final int getVideoPosition() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions$WriteClick;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class WriteClick extends CarouselActions {
        @NotNull
        public static final WriteClick INSTANCE = new WriteClick();

        public WriteClick() {
            super(null);
        }
    }

    public CarouselActions() {
    }

    public CarouselActions(j jVar) {
    }
}
