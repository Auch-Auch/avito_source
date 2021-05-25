package com.avito.android.profile.edit;

import a2.g.r.g;
import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.profile.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002I3B\u001f\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0011J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b \u0010\u0005J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0005J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b#\u0010\u0005R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010*R\u0016\u00109\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010*R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006R"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileViewImpl;", "Lcom/avito/android/profile/edit/EditProfileView;", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", "", "deleteButtonVisible", "animate", "showAvatarPicker", "(ZZ)V", "hideAvatarPicker", "()V", "showContent", "showProgress", "showSavingProgress", "showAvatarError", "", "error", "showSavingError", "(Ljava/lang/String;)V", "showError", "enabled", "setSaveEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "takePhotoClicks", "deleteAvatarClicks", "pickerEmptySpaceClicks", "saveClicks", "refreshClicks", "Landroidx/appcompat/widget/Toolbar;", "f", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", "d", "Landroid/view/View;", "saveProgress", "j", "takePhotoButton", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "h", "avatarPickerRoot", "k", "deleteAvatarButton", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/MenuItem;", g.a, "Landroid/view/MenuItem;", "saveMenuItem", "Landroid/view/ViewGroup;", "l", "Landroid/view/ViewGroup;", "rootView", "i", "pickerEmptySpace", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/analytics/Analytics;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditProfileViewImpl implements EditProfileView {
    public final Context a;
    public final RecyclerView b;
    public ProgressOverlay c;
    public final View d;
    public RecyclerView.ItemDecoration e;
    public final Toolbar f;
    public final MenuItem g;
    public final View h;
    public final View i;
    public final View j;
    public final View k;
    public final ViewGroup l;

    public static final class a extends AnimationUtils.SimpleAnimatorListener {
        public final View a;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
        }

        @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            Views.hide(this.a);
        }
    }

    public static final class b extends AnimationUtils.SimpleAnimatorListener {
        public final View a;

        public b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = view;
        }

        @Override // com.avito.android.util.AnimationUtils.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            this.a.setAlpha(1.0f);
            Views.show(this.a);
        }
    }

    public static final class c<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ EditProfileViewImpl a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(Unit.INSTANCE);
                }
            }
        }

        public c(EditProfileViewImpl editProfileViewImpl) {
            this.a = editProfileViewImpl;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a.f.setNavigationOnClickListener(new a(observableEmitter));
        }
    }

    public static final class d<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ EditProfileViewImpl a;

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ObservableEmitter observableEmitter) {
                super(0);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        }

        public d(EditProfileViewImpl editProfileViewImpl) {
            this.a = editProfileViewImpl;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a.c.setOnRefreshListener(new a(observableEmitter));
        }
    }

    public static final class e<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ EditProfileViewImpl a;

        public static final class a implements Toolbar.OnMenuItemClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
                if (observableEmitter.isDisposed()) {
                    return true;
                }
                this.a.onNext(Unit.INSTANCE);
                return true;
            }
        }

        public e(EditProfileViewImpl editProfileViewImpl) {
            this.a = editProfileViewImpl;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a.f.setOnMenuItemClickListener(new a(observableEmitter));
        }
    }

    public EditProfileViewImpl(@NotNull ViewGroup viewGroup, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.l = viewGroup;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        int i2 = R.id.recycler;
        View findViewById = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = viewGroup.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) findViewById2, i2, analytics, false, 0, 24, null);
        View findViewById3 = viewGroup.findViewById(R.id.save_progress);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = viewGroup.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById4;
        this.f = toolbar;
        View findViewById5 = viewGroup.findViewById(R.id.picker_root_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.empty_space);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.i = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.take_photo_button);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.delete_avatar_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById8;
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        View findViewById9 = viewGroup.findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        Views.show(findViewById9);
        toolbar.setTitle(context.getString(R.string.edit_profile_title));
        Toolbars.setCloseIcon(toolbar);
        MenuItem add = toolbar.getMenu().add(com.avito.android.deprecated_design.R.string.save);
        Intrinsics.checkNotNullExpressionValue(add, "toolbar.menu.add(deprecated_R.string.save)");
        this.g = add;
        add.setShowAsAction(2);
        setSaveEnabled(false);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> deleteAvatarClicks() {
        return RxView.clicks(this.k);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void hideAvatarPicker() {
        this.h.animate().setDuration(200).alpha(0.0f).setListener(new a(this.h));
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.l, false, 1, null);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> navigationClicks() {
        Observable<Unit> create = Observable.create(new c(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> pickerEmptySpaceClicks() {
        return RxView.clicks(this.i);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> refreshClicks() {
        Observable<Unit> create = Observable.create(new d(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…        }\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> saveClicks() {
        Observable<Unit> create = Observable.create(new e(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…     true\n        }\n    }");
        return create;
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void setDividers(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "indexes");
        RecyclerView.ItemDecoration itemDecoration = this.e;
        if (itemDecoration != null) {
            this.b.removeItemDecoration(itemDecoration);
        }
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.standard_padding);
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.black_12_divider);
        VerticalListItemDecoration.Builder padding = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize);
        for (Integer num : iterable) {
            int intValue = num.intValue();
            Intrinsics.checkNotNull(drawable);
            padding.setDividerForItemAt(intValue, drawable);
        }
        VerticalListItemDecoration build = padding.build();
        this.b.addItemDecoration(build);
        Unit unit = Unit.INSTANCE;
        this.e = build;
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void setSaveEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showAvatarError() {
        AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.b, R.string.invalid_image_format, 0, null, 0, null, null, 0, 0, 504, null).show();
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showAvatarPicker(boolean z, boolean z2) {
        Views.setVisible(this.k, z);
        View view = this.h;
        if (z2) {
            view.setAlpha(0.0f);
            Views.show(view);
            view.animate().setDuration(200).alpha(1.0f).setListener(new b(this.h));
            return;
        }
        view.setAlpha(1.0f);
        Views.show(view);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showContent() {
        this.c.showContent();
        Views.hide(this.d);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showSavingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.hide(this.d);
        AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.b, str, 0, null, 0, null, null, 0, 0, 0, 1016, null).show();
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    public void showSavingProgress() {
        Views.show(this.d);
    }

    @Override // com.avito.android.profile.edit.EditProfileView
    @NotNull
    public Observable<Unit> takePhotoClicks() {
        return RxView.clicks(this.j);
    }
}
