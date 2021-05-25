package com.avito.android.photo_picker.legacy.details_list;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import com.avito.android.photo_picker.legacy.thumbnail_list.ResourcePhotoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/ExtraSmallCameraBluePrint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "getPresenter", "()Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ExtraSmallCameraBluePrint implements ItemBlueprint<CameraItemView, BasePhotoItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CameraItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.camera_preview_item_extra_small, new a(this));
    @NotNull
    public final CameraItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CameraItemViewImpl> {
        public final /* synthetic */ ExtraSmallCameraBluePrint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ExtraSmallCameraBluePrint extraSmallCameraBluePrint) {
            super(2);
            this.a = extraSmallCameraBluePrint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.avito.android.photo_picker.legacy.details_list.CameraItemView$Presenter, com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl invoke(android.view.ViewGroup r2, android.view.View r3) {
            /*
                r1 = this;
                android.view.ViewGroup r2 = (android.view.ViewGroup) r2
                android.view.View r3 = (android.view.View) r3
                java.lang.String r0 = "parent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r2 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl r2 = new com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl
                com.avito.android.photo_picker.legacy.details_list.ExtraSmallCameraBluePrint r0 = r1.a
                com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter r0 = r0.getPresenter()
                r2.<init>(r3, r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_picker.legacy.details_list.ExtraSmallCameraBluePrint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    public ExtraSmallCameraBluePrint(@NotNull CameraItemPresenter cameraItemPresenter) {
        Intrinsics.checkNotNullParameter(cameraItemPresenter, "presenter");
        this.b = cameraItemPresenter;
    }

    /* Return type fixed from 'com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CameraItemView, BasePhotoItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CameraItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ResourcePhotoItem;
    }
}
