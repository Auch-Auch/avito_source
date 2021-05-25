package com.avito.android.photo_gallery;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.util.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/photo_gallery/LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", VKApiConst.POSITION, "", "onPageSelected", "(I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {
    public final /* synthetic */ LegacyPhotoGalleryActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        this.a = legacyPhotoGalleryActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        GalleryFragment galleryFragment;
        Fragment fragment;
        boolean z;
        if ((this.a.C) && i > CollectionsKt__CollectionsKt.getLastIndex(this.a.x) - 2) {
            LegacyPhotoGalleryActivity legacyPhotoGalleryActivity = this.a;
            boolean z2 = true;
            LegacyPhotoGalleryActivity.access$showTeaserAction(legacyPhotoGalleryActivity, CollectionsKt__CollectionsKt.getLastIndex(legacyPhotoGalleryActivity.x) == i);
            FragmentManager supportFragmentManager = this.a.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            List<Fragment> fragments = supportFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            ListIterator<Fragment> listIterator = fragments.listIterator(fragments.size());
            while (true) {
                galleryFragment = null;
                if (!listIterator.hasPrevious()) {
                    fragment = null;
                    break;
                }
                fragment = listIterator.previous();
                Fragment fragment2 = fragment;
                if (!(fragment2 instanceof GalleryFragment) || ((GalleryFragment) fragment2).getGalleryFragmentType() != GalleryFragmentType.AUTOTEKA_TEASER) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (fragment instanceof GalleryFragment) {
                galleryFragment = fragment;
            }
            GalleryFragment galleryFragment2 = galleryFragment;
            if (galleryFragment2 != null) {
                if (CollectionsKt__CollectionsKt.getLastIndex(this.a.x) != i) {
                    z2 = false;
                }
                galleryFragment2.showOpenTeaserButton(z2);
            }
        }
        this.a.getIntent().putExtra(Constants.IMAGE_POSITION, i);
        LegacyPhotoGalleryActivity.access$resetZoomForZoomableFragments(this.a);
        LegacyPhotoGalleryActivity.access$sendSwipeAnalytics(this.a);
    }
}
