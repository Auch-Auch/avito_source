package com.avito.android.photo_picker.legacy;

import a2.a.a.x1.q.d;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.legacy.PhotoPickerView;
import com.avito.android.photo_picker.legacy.thumbnail_list.PhotoItemDecoration;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.view.PagerLayoutManager;
import com.avito.android.util.Contexts;
import com.avito.android.util.Rotation;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BI\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010c\u001a\u00020a\u0012\b\b\u0002\u0010J\u001a\u00020G¢\u0006\u0004\bd\u0010eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\tJ\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\tR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010+R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010MR\u0016\u0010Z\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010+¨\u0006f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoPickerViewImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView;", "", VKApiConst.POSITION, "", "onDetailsListItemChanged", "(I)V", "scrollDetailsListToPosition", "onThumbnailsListChanged", "()V", "onDetailsListChanged", "count", "onDetailsListRangeChanged", "(II)V", "itemPos", "ensureThumbnailIsVisible", "Lcom/avito/android/util/Rotation;", "rotation", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "", "isVisible", "setThumbnailsListVisibility", "(Z)V", "visible", "setContinueButtonVisibility", "enabled", "setContinueButtonEnabled", "progress", "setContinueButtonProgress", "", "error", "showWarning", "(Ljava/lang/String;)V", "showError", "Lio/reactivex/Observable;", "continueClicks", "()Lio/reactivex/Observable;", "showProgress", "hideProgress", "onDetach", "Landroid/view/View;", "d", "Landroid/view/View;", "removeBtn", "Landroid/widget/ImageButton;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageButton;", "cancelButton", "Lcom/avito/android/ui/view/PagerLayoutManager;", "h", "Lcom/avito/android/ui/view/PagerLayoutManager;", "detailsListLayoutManager", "Landroid/view/ViewGroup;", "l", "Landroid/view/ViewGroup;", "rootView", "Landroid/widget/FrameLayout;", g.a, "Landroid/widget/FrameLayout;", "containerView", "c", "thumbnailsListContainer", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "rotationCallback", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$Presenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$Presenter;", "presenter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "n", "Landroidx/recyclerview/widget/LinearLayoutManager;", "thumbnailsListLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "thumbnailsList", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "k", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "La2/a/a/x1/q/c;", "j", "La2/a/a/x1/q/c;", "continueButton", "f", "detailsList", "e", "editBtn", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;", "photoPickerLayoutConfig", "Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "photoDragAndDrop", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "detailsAdapter", "thumbnailsAdapter", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/photo_picker/legacy/PhotoPickerView$Presenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/photo_picker/legacy/PhotoPickerView$PhotoPickerLayoutConfig;Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Landroidx/recyclerview/widget/LinearLayoutManager;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerViewImpl implements PhotoPickerView {
    public final ImageButton a;
    public final RecyclerView b;
    public final View c;
    public final View d;
    public final View e;
    public final RecyclerView f;
    public final FrameLayout g;
    public final PagerLayoutManager h;
    public Runnable i;
    public final a2.a.a.x1.q.c j;
    public final ProgressOverlay k;
    public final ViewGroup l;
    public final PhotoPickerView.Presenter m;
    public final LinearLayoutManager n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhotoPickerView.PhotoPickerLayoutConfig.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_APPBAR;
            iArr[0] = 1;
            PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig2 = PhotoPickerView.PhotoPickerLayoutConfig.CONTINUE_BTN_FOOTER;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((PhotoPickerViewImpl) this.b).m.editSelectedPhoto();
            } else if (i == 1) {
                ((PhotoPickerViewImpl) this.b).m.onCancelClicked();
            } else if (i == 2) {
                ((PhotoPickerViewImpl) this.b).m.removeSelectedPhoto();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PhotoPickerViewImpl a;
        public final /* synthetic */ int b;

        public b(PhotoPickerViewImpl photoPickerViewImpl, int i) {
            this.a = photoPickerViewImpl;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.Adapter adapter = this.a.b.getAdapter();
            int itemCount = adapter != null ? adapter.getItemCount() : 0;
            int i = this.b;
            if (i > 0 && i < itemCount - 1) {
                int findFirstCompletelyVisibleItemPosition = this.a.n.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = this.a.n.findLastCompletelyVisibleItemPosition() - findFirstCompletelyVisibleItemPosition;
                if (findLastCompletelyVisibleItemPosition != 0) {
                    int i2 = this.b;
                    i = ((double) (i2 - findFirstCompletelyVisibleItemPosition)) / ((double) findLastCompletelyVisibleItemPosition) < 0.5d ? i2 - 1 : i2 + 1;
                } else {
                    return;
                }
            }
            this.a.b.smoothScrollToPosition(i);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PhotoPickerViewImpl a;
        public final /* synthetic */ Rotation b;

        public c(PhotoPickerViewImpl photoPickerViewImpl, Rotation rotation) {
            this.a = photoPickerViewImpl;
            this.b = rotation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PhotoPickerViewImpl.access$rotateContinueButton(this.a, this.b);
        }
    }

    public PhotoPickerViewImpl(@NotNull ViewGroup viewGroup, @NotNull PhotoPickerView.Presenter presenter, @NotNull Analytics analytics, @NotNull PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig, @NotNull PhotoDragAndDrop photoDragAndDrop, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter2, @NotNull LinearLayoutManager linearLayoutManager) {
        a2.a.a.x1.q.c cVar;
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(photoPickerLayoutConfig, "photoPickerLayoutConfig");
        Intrinsics.checkNotNullParameter(photoDragAndDrop, "photoDragAndDrop");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "detailsAdapter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter2, "thumbnailsAdapter");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "thumbnailsListLayoutManager");
        this.l = viewGroup;
        this.m = presenter;
        this.n = linearLayoutManager;
        View findViewById = viewGroup.findViewById(R.id.cancel_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById;
        this.a = imageButton;
        View findViewById2 = viewGroup.findViewById(R.id.photo_list);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        View findViewById3 = viewGroup.findViewById(R.id.photo_list_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.remove_btn);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.edit_btn);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById5;
        int i2 = R.id.camera_list;
        View findViewById6 = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView2 = (RecyclerView) findViewById6;
        this.f = recyclerView2;
        View findViewById7 = viewGroup.findViewById(R.id.container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById7;
        this.g = frameLayout;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        PagerLayoutManager pagerLayoutManager = new PagerLayoutManager(context, 0, 2, null);
        this.h = pagerLayoutManager;
        int ordinal = photoPickerLayoutConfig.ordinal();
        if (ordinal == 0) {
            cVar = new a2.a.a.x1.q.a(viewGroup);
        } else if (ordinal == 1) {
            cVar = new d(viewGroup, presenter.getMode());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.j = cVar;
        this.k = new ProgressOverlay(frameLayout, i2, analytics, false, 0, 24, null);
        findViewById5.setOnClickListener(new a(0, this));
        imageButton.setOnClickListener(new a(1, this));
        if (presenter.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_ADD) {
            imageButton.setImageResource(com.avito.android.ui_components.R.drawable.ic_back_24);
        }
        if (presenter.getMode() == PublishIntentFactory.PhotoPickerMode.MODE_LEGACY) {
            Views.hide(findViewById4);
            Views.hide(findViewById5);
        }
        findViewById4.setOnClickListener(new a(2, this));
        recyclerView2.setLayoutManager(pagerLayoutManager);
        recyclerView2.setAdapter(simpleRecyclerAdapter);
        pagerLayoutManager.setPageListener(new PagerLayoutManager.OnPageScrollListener(this) { // from class: com.avito.android.photo_picker.legacy.PhotoPickerViewImpl.4
            public final /* synthetic */ PhotoPickerViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.ui.view.PagerLayoutManager.OnPageScrollListener
            public void onPageChanged(int i3) {
                this.a.m.onDetailsListScrolled(i3);
            }

            @Override // com.avito.android.ui.view.PagerLayoutManager.OnPageScrollListener
            public void onPageScrollFinished(int i3) {
                this.a.m.onDetailsListScrollFinished(i3);
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        Context context2 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        Resources resources = context2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.context.resources");
        recyclerView.addItemDecoration(new PhotoItemDecoration(resources));
        simpleRecyclerAdapter2.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter2);
        photoDragAndDrop.attachTo(recyclerView, presenter);
    }

    public static final void access$rotateContinueButton(PhotoPickerViewImpl photoPickerViewImpl, Rotation rotation) {
        photoPickerViewImpl.j.a(rotation);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    @NotNull
    public Observable<Unit> continueClicks() {
        return this.j.getClickObservable();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void ensureThumbnailIsVisible(int i2) {
        this.b.post(new b(this, i2));
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void hideProgress() {
        this.k.showContent();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void onDetach() {
        Runnable runnable = this.i;
        if (runnable != null) {
            this.l.removeCallbacks(runnable);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void onDetailsListChanged() {
        RecyclerView.Adapter adapter = this.f.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void onDetailsListItemChanged(int i2) {
        RecyclerView.Adapter adapter = this.f.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void onDetailsListRangeChanged(int i2, int i3) {
        RecyclerView.Adapter adapter = this.f.getAdapter();
        if (adapter != null) {
            adapter.notifyItemRangeInserted(i2, i3);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void onThumbnailsListChanged() {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void rotateUi(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Views.rotateByShortestPath(this.a, rotation.getDegree());
        Runnable runnable = this.i;
        if (runnable != null) {
            this.l.removeCallbacks(runnable);
        }
        c cVar = new c(this, rotation);
        this.i = cVar;
        this.l.postDelayed(cVar, 200);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void scrollDetailsListToPosition(int i2) {
        this.h.scrollToPosition(i2);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void setContinueButtonEnabled(boolean z) {
        this.j.setEnabled(z);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void setContinueButtonProgress(boolean z) {
        this.j.b(z);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void setContinueButtonVisibility(boolean z) {
        this.j.setVisibility(z);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void setThumbnailsListVisibility(boolean z) {
        Views.setVisible(this.c, z);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ViewGroup viewGroup = this.l;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        Views.showSnackBar$default(viewGroup, str, 0, (String) null, 0, (Function0) null, (Function0) null, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red), 62, (Object) null);
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void showProgress() {
        this.k.showLoading();
    }

    @Override // com.avito.android.photo_picker.legacy.PhotoPickerView
    public void showWarning(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.l, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoPickerViewImpl(ViewGroup viewGroup, PhotoPickerView.Presenter presenter, Analytics analytics, PhotoPickerView.PhotoPickerLayoutConfig photoPickerLayoutConfig, PhotoDragAndDrop photoDragAndDrop, SimpleRecyclerAdapter simpleRecyclerAdapter, SimpleRecyclerAdapter simpleRecyclerAdapter2, LinearLayoutManager linearLayoutManager, int i2, j jVar) {
        this(viewGroup, presenter, analytics, photoPickerLayoutConfig, photoDragAndDrop, simpleRecyclerAdapter, simpleRecyclerAdapter2, (i2 & 128) != 0 ? new LinearLayoutManager(viewGroup.getContext(), 0, false) : linearLayoutManager);
    }
}
