package com.avito.android.photo_gallery;

import android.os.Bundle;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.util.FragmentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001am\u0010\u0013\u001a\u00020\u00122\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/Image;", "image", "", "cropImage", "Lcom/avito/android/photo_gallery/GalleryFragmentType;", "galleryFragmentType", "isFastOpen", "isSubComponent", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "", "ratio", "Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryTeaserAutoteka;", "teaser", "Lcom/avito/android/photo_gallery/GalleryFragment;", "newGalleryFragmentInstance", "(Lcom/avito/android/remote/model/Image;ZLcom/avito/android/photo_gallery/GalleryFragmentType;ZZLcom/avito/android/analytics/screens/Screen;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Ljava/lang/Float;Lcom/avito/android/photo_gallery/adapter/GalleryItem$GalleryTeaserAutoteka;)Lcom/avito/android/photo_gallery/GalleryFragment;", "photo-gallery_release"}, k = 2, mv = {1, 4, 2})
public final class GalleryFragmentKt {

    public static final class a extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ Image a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ GalleryFragmentType c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Screen e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ GalleryItem.GalleryTeaserAutoteka h;
        public final /* synthetic */ ForegroundImage i;
        public final /* synthetic */ Float j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Image image, boolean z, GalleryFragmentType galleryFragmentType, boolean z2, Screen screen, boolean z3, String str, GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka, ForegroundImage foregroundImage, Float f2) {
            super(1);
            this.a = image;
            this.b = z;
            this.c = galleryFragmentType;
            this.d = z2;
            this.e = screen;
            this.f = z3;
            this.g = str;
            this.h = galleryTeaserAutoteka;
            this.i = foregroundImage;
            this.j = f2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bundle bundle) {
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "$receiver");
            bundle2.putParcelable("image", this.a);
            bundle2.putBoolean("crop", this.b);
            bundle2.putSerializable("type", this.c);
            bundle2.putBoolean("fastOpen", this.d);
            bundle2.putParcelable(InternalConstsKt.SCREEN, this.e);
            bundle2.putBoolean("sub_component", this.f);
            bundle2.putString(BookingInfoActivity.EXTRA_ITEM_ID, this.g);
            GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka = this.h;
            bundle2.putParcelable("teaser", galleryTeaserAutoteka != null ? galleryTeaserAutoteka.getAutotekaTeaser() : null);
            bundle2.putParcelable("foreground_info", this.i);
            Float f2 = this.j;
            if (f2 != null) {
                bundle2.putFloat("ratio", f2.floatValue());
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final GalleryFragment newGalleryFragmentInstance(@Nullable Image image, boolean z, @NotNull GalleryFragmentType galleryFragmentType, boolean z2, boolean z3, @NotNull Screen screen, @NotNull String str, @Nullable ForegroundImage foregroundImage, @Nullable Float f, @Nullable GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka) {
        Intrinsics.checkNotNullParameter(galleryFragmentType, "galleryFragmentType");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return (GalleryFragment) FragmentsKt.arguments$default(new GalleryFragment(), 0, new a(image, z, galleryFragmentType, z2, screen, z3, str, galleryTeaserAutoteka, foregroundImage, f), 1, null);
    }

    public static /* synthetic */ GalleryFragment newGalleryFragmentInstance$default(Image image, boolean z, GalleryFragmentType galleryFragmentType, boolean z2, boolean z3, Screen screen, String str, ForegroundImage foregroundImage, Float f, GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka, int i, Object obj) {
        return newGalleryFragmentInstance(image, z, galleryFragmentType, (i & 8) != 0 ? false : z2, z3, screen, str, (i & 128) != 0 ? null : foregroundImage, (i & 256) != 0 ? null : f, (i & 512) != 0 ? null : galleryTeaserAutoteka);
    }
}
