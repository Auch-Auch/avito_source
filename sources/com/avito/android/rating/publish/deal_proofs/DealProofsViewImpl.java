package com.avito.android.rating.publish.deal_proofs;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_view.ImageData;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListView;
import com.avito.android.photo_view.LegacyImageListViewImpl;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010@\u001a\u000205\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\bA\u0010BJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\nJ\u001e\u0010\u001f\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00107¨\u0006C"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsViewImpl;", "Lcom/avito/android/rating/publish/deal_proofs/DealProofsView;", "Lcom/avito/android/photo_view/ImageListView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "isEmptyList", "setContentMode", "(Z)V", "addPhotoClicks", "buttonClicks", "infoClicks", "isEnabled", "setButtonEnabled", "showContinueButton", "()V", "showContinueNoPhotosButton", "showSendButton", "showSendNoPhotosButton", "setUploadImagesTexts", "setDealProofsTexts", "setAutoDealProofsTexts", "isLoading", "showLoadingState", "isVisible", "showInfoLinkVisible", "", "Lcom/avito/android/photo_view/ImageData;", "images", "show", "(Ljava/util/List;)V", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", "sendButton", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.SEND_ABUSE, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "emptyListView", "Lcom/avito/android/photo_view/ImageListPresenter;", "i", "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "text", "Landroid/view/View;", "d", "Landroid/view/View;", "infoLinkView", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "imageListRoot", "f", "title", "h", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_view/ImageListPresenter;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealProofsViewImpl implements DealProofsView, ImageListView {
    public final AppBarImpl a;
    public final RecyclerView b;
    public final ViewGroup c;
    public final View d;
    public final Button e;
    public final TextView f;
    public final TextView g;
    public final View h;
    public final ImageListPresenter i;
    public final /* synthetic */ LegacyImageListViewImpl j;

    public DealProofsViewImpl(@NotNull View view, @NotNull ImageListPresenter imageListPresenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(imageListPresenter, "imageListPresenter");
        int i2 = R.id.image_list_container;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.j = new LegacyImageListViewImpl((RecyclerView) findViewById, imageListPresenter);
        this.h = view;
        this.i = imageListPresenter;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle("");
        Unit unit = Unit.INSTANCE;
        this.a = appBarImpl;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.b = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.empty_view_content);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById3;
        View findViewById4 = view.findViewById(R.id.info_link);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.send_button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.e = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    @NotNull
    public Observable<Unit> addPhotoClicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    @NotNull
    public Observable<Unit> buttonClicks() {
        return RxView.clicks(this.e);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    @NotNull
    public Observable<Unit> infoClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return this.a.navigationCallbacks();
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void setAutoDealProofsTexts() {
        this.g.setText(R.string.auto_deal_proofs_text);
        this.f.setText(R.string.auto_deal_proofs_title);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void setButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void setContentMode(boolean z) {
        Views.setVisible(this.c, z);
        Views.setVisible(this.b, !z);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void setDealProofsTexts() {
        this.g.setText(R.string.deal_proofs_text);
        this.f.setText(R.string.deal_proofs_title);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void setUploadImagesTexts() {
        this.g.setText(R.string.upload_images_text);
        this.f.setText(R.string.uploadImages);
    }

    @Override // com.avito.android.photo_view.ImageListView
    public void show(@NotNull List<? extends ImageData> list) {
        Intrinsics.checkNotNullParameter(list, "images");
        this.j.show(list);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showContinueButton() {
        this.e.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showContinueNoPhotosButton() {
        this.e.setText(R.string.continue_no_photos_button_title);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showInfoLinkVisible(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showLoadingState(boolean z) {
        this.e.setLoading(z);
        this.e.setClickable(!z);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showSendButton() {
        this.e.setText(R.string.send_button_title);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.DealProofsView
    public void showSendNoPhotosButton() {
        this.e.setText(R.string.send_no_photos_button_title);
    }
}
