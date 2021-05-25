package com.avito.android.photo_gallery.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "", "<init>", "()V", "GalleryForegroundImage", "GalleryImage", "GalleryTeaserAutoteka", "GalleryVideo", "Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryImage;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryForegroundImage;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryVideo;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryTeaserAutoteka;", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public abstract class GalleryItem {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryForegroundImage;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "Lcom/avito/android/remote/model/ForegroundImage;", "component1", "()Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "copy", "(Lcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryForegroundImage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "<init>", "(Lcom/avito/android/remote/model/ForegroundImage;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public static final class GalleryForegroundImage extends GalleryItem {
        @NotNull
        public final ForegroundImage a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GalleryForegroundImage(@NotNull ForegroundImage foregroundImage) {
            super(null);
            Intrinsics.checkNotNullParameter(foregroundImage, "foregroundImage");
            this.a = foregroundImage;
        }

        public static /* synthetic */ GalleryForegroundImage copy$default(GalleryForegroundImage galleryForegroundImage, ForegroundImage foregroundImage, int i, Object obj) {
            if ((i & 1) != 0) {
                foregroundImage = galleryForegroundImage.a;
            }
            return galleryForegroundImage.copy(foregroundImage);
        }

        @NotNull
        public final ForegroundImage component1() {
            return this.a;
        }

        @NotNull
        public final GalleryForegroundImage copy(@NotNull ForegroundImage foregroundImage) {
            Intrinsics.checkNotNullParameter(foregroundImage, "foregroundImage");
            return new GalleryForegroundImage(foregroundImage);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GalleryForegroundImage) && Intrinsics.areEqual(this.a, ((GalleryForegroundImage) obj).a);
            }
            return true;
        }

        @NotNull
        public final ForegroundImage getForegroundImage() {
            return this.a;
        }

        public int hashCode() {
            ForegroundImage foregroundImage = this.a;
            if (foregroundImage != null) {
                return foregroundImage.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GalleryForegroundImage(foregroundImage=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryImage;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "image", "copy", "(Lcom/avito/android/remote/model/Image;)Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryImage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public static final class GalleryImage extends GalleryItem {
        @NotNull
        public final Image a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GalleryImage(@NotNull Image image) {
            super(null);
            Intrinsics.checkNotNullParameter(image, "image");
            this.a = image;
        }

        public static /* synthetic */ GalleryImage copy$default(GalleryImage galleryImage, Image image, int i, Object obj) {
            if ((i & 1) != 0) {
                image = galleryImage.a;
            }
            return galleryImage.copy(image);
        }

        @NotNull
        public final Image component1() {
            return this.a;
        }

        @NotNull
        public final GalleryImage copy(@NotNull Image image) {
            Intrinsics.checkNotNullParameter(image, "image");
            return new GalleryImage(image);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GalleryImage) && Intrinsics.areEqual(this.a, ((GalleryImage) obj).a);
            }
            return true;
        }

        @NotNull
        public final Image getImage() {
            return this.a;
        }

        public int hashCode() {
            Image image = this.a;
            if (image != null) {
                return image.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GalleryImage(image=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryTeaserAutoteka;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "component1", "()Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "copy", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryTeaserAutoteka;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "getAutotekaTeaser", "<init>", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public static final class GalleryTeaserAutoteka extends GalleryItem {
        @NotNull
        public final AutotekaTeaserGalleryModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GalleryTeaserAutoteka(@NotNull AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
            super(null);
            Intrinsics.checkNotNullParameter(autotekaTeaserGalleryModel, "autotekaTeaser");
            this.a = autotekaTeaserGalleryModel;
        }

        public static /* synthetic */ GalleryTeaserAutoteka copy$default(GalleryTeaserAutoteka galleryTeaserAutoteka, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i, Object obj) {
            if ((i & 1) != 0) {
                autotekaTeaserGalleryModel = galleryTeaserAutoteka.a;
            }
            return galleryTeaserAutoteka.copy(autotekaTeaserGalleryModel);
        }

        @NotNull
        public final AutotekaTeaserGalleryModel component1() {
            return this.a;
        }

        @NotNull
        public final GalleryTeaserAutoteka copy(@NotNull AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
            Intrinsics.checkNotNullParameter(autotekaTeaserGalleryModel, "autotekaTeaser");
            return new GalleryTeaserAutoteka(autotekaTeaserGalleryModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GalleryTeaserAutoteka) && Intrinsics.areEqual(this.a, ((GalleryTeaserAutoteka) obj).a);
            }
            return true;
        }

        @NotNull
        public final AutotekaTeaserGalleryModel getAutotekaTeaser() {
            return this.a;
        }

        public int hashCode() {
            AutotekaTeaserGalleryModel autotekaTeaserGalleryModel = this.a;
            if (autotekaTeaserGalleryModel != null) {
                return autotekaTeaserGalleryModel.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GalleryTeaserAutoteka(autotekaTeaser=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryVideo;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "Lcom/avito/android/remote/model/Video;", "component1", "()Lcom/avito/android/remote/model/Video;", "video", "copy", "(Lcom/avito/android/remote/model/Video;)Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryVideo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Video;", "getVideo", "<init>", "(Lcom/avito/android/remote/model/Video;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public static final class GalleryVideo extends GalleryItem {
        @NotNull
        public final Video a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GalleryVideo(@NotNull Video video) {
            super(null);
            Intrinsics.checkNotNullParameter(video, "video");
            this.a = video;
        }

        public static /* synthetic */ GalleryVideo copy$default(GalleryVideo galleryVideo, Video video, int i, Object obj) {
            if ((i & 1) != 0) {
                video = galleryVideo.a;
            }
            return galleryVideo.copy(video);
        }

        @NotNull
        public final Video component1() {
            return this.a;
        }

        @NotNull
        public final GalleryVideo copy(@NotNull Video video) {
            Intrinsics.checkNotNullParameter(video, "video");
            return new GalleryVideo(video);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GalleryVideo) && Intrinsics.areEqual(this.a, ((GalleryVideo) obj).a);
            }
            return true;
        }

        @NotNull
        public final Video getVideo() {
            return this.a;
        }

        public int hashCode() {
            Video video = this.a;
            if (video != null) {
                return video.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GalleryVideo(video=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public GalleryItem() {
    }

    public GalleryItem(j jVar) {
    }
}
