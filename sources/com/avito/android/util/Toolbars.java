package com.avito.android.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\r\u001a\u00020\u0005*\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000b\u001a\u001b\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u001b\u0010\u0014\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u001b\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0010\u001a\u0011\u0010\u0016\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0005*\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0005*\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d*\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/appcompat/widget/Toolbar;", "", "itemId", "Lcom/avito/android/util/ActionMenu;", "actionMenu", "", "addActionMenu", "(Landroidx/appcompat/widget/Toolbar;ILcom/avito/android/util/ActionMenu;)V", "", "title", "setSpannedTitle", "(Landroidx/appcompat/widget/Toolbar;Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSpannedSubtitle", "resId", "tintMenu", "(Landroidx/appcompat/widget/Toolbar;I)V", "colorAttr", "tintMenuByAttr", "colorResId", "setBackIcon", "setBackIconByAttr", "setCloseIcon", "(Landroidx/appcompat/widget/Toolbar;)V", "setBurgerIcon", "Lnet/opacapp/multilinecollapsingtoolbar/CollapsingToolbarLayout;", "applyTypefaceForExpandedTitle", "(Lnet/opacapp/multilinecollapsingtoolbar/CollapsingToolbarLayout;)V", "applyTypefaceForCollapsedTitle", "Lio/reactivex/rxjava3/core/Observable;", "upClicks", "(Landroidx/appcompat/widget/Toolbar;)Lio/reactivex/rxjava3/core/Observable;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Toolbars")
public final class Toolbars {

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ Toolbar a;

        /* renamed from: com.avito.android.util.Toolbars$a$a */
        public static final class C0169a implements Cancellable {
            public final /* synthetic */ a a;

            public C0169a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.setNavigationOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(Toolbar toolbar) {
            this.a = toolbar;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new C0169a(this));
            this.a.setNavigationOnClickListener(new b(observableEmitter));
        }
    }

    public static final void addActionMenu(@NotNull Toolbar toolbar, int i, @NotNull ActionMenu actionMenu) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$addActionMenu");
        Intrinsics.checkNotNullParameter(actionMenu, "actionMenu");
        MenuItem add = toolbar.getMenu().add(0, i, 0, actionMenu.getTitle());
        add.setShowAsAction(actionMenu.getMode());
        Integer drawableId = actionMenu.getDrawableId();
        if (drawableId != null) {
            add.setIcon(drawableId.intValue());
            Integer tintColorAttr = actionMenu.getTintColorAttr();
            if (tintColorAttr != null) {
                int intValue = tintColorAttr.intValue();
                Intrinsics.checkNotNullExpressionValue(add, "menuItem");
                Context context = toolbar.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                MenuItemsKt.tintIconByAttr(add, context, intValue);
                if (actionMenu.getContentDescriptionId() != null) {
                    MenuItemCompat.setContentDescription(add, toolbar.getContext().getString(actionMenu.getContentDescriptionId().intValue()));
                }
            }
        }
    }

    public static final void applyTypefaceForCollapsedTitle(@NotNull CollapsingToolbarLayout collapsingToolbarLayout) {
        Intrinsics.checkNotNullParameter(collapsingToolbarLayout, "$this$applyTypefaceForCollapsedTitle");
        Context context = collapsingToolbarLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        collapsingToolbarLayout.setCollapsedTitleTypeface(Typefaces.getTypeface(context, TypefaceType.Medium));
    }

    public static final void applyTypefaceForExpandedTitle(@NotNull CollapsingToolbarLayout collapsingToolbarLayout) {
        Intrinsics.checkNotNullParameter(collapsingToolbarLayout, "$this$applyTypefaceForExpandedTitle");
        Context context = collapsingToolbarLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        collapsingToolbarLayout.setExpandedTitleTypeface(Typefaces.getTypeface(context, TypefaceType.Medium));
    }

    public static final void setBackIcon(@NotNull Toolbar toolbar, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setBackIcon");
        Context context = toolbar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.navigationIcon});
        int resourceId = obtainStyledAttributes.getResourceId(0, com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            Drawable drawable = toolbar.getContext().getDrawable(resourceId);
            if (drawable != null) {
                drawable.setTint(ContextCompat.getColor(toolbar.getContext(), i));
                toolbar.setNavigationIcon(drawable);
                return;
            }
            return;
        }
        toolbar.setNavigationIcon(resourceId);
    }

    public static /* synthetic */ void setBackIcon$default(Toolbar toolbar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        setBackIcon(toolbar, i);
    }

    public static final void setBackIconByAttr(@NotNull Toolbar toolbar, @AttrRes int i) {
        Drawable mutate;
        Intrinsics.checkNotNullParameter(toolbar, "$this$setBackIconByAttr");
        Context context = toolbar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.navigationIcon});
        int resourceId = obtainStyledAttributes.getResourceId(0, com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            Drawable drawable = toolbar.getContext().getDrawable(resourceId);
            if (drawable != null && (mutate = drawable.mutate()) != null) {
                Context context2 = toolbar.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                mutate.setTint(Contexts.getColorByAttr(context2, i));
                toolbar.setNavigationIcon(mutate);
                return;
            }
            return;
        }
        toolbar.setNavigationIcon(resourceId);
    }

    public static /* synthetic */ void setBackIconByAttr$default(Toolbar toolbar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        setBackIconByAttr(toolbar, i);
    }

    public static final void setBurgerIcon(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setBurgerIcon");
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_burger_24);
    }

    public static final void setCloseIcon(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setCloseIcon");
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
    }

    public static final void setSpannedSubtitle(@NotNull Toolbar toolbar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setSpannedSubtitle");
        if (str != null) {
            Context context = toolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            toolbar.setTitle(Typefaces.getTypefaceSpannable(context, str, TypefaceType.Regular));
            return;
        }
        toolbar.setSubtitle((CharSequence) null);
    }

    public static final void setSpannedTitle(@NotNull Toolbar toolbar, @NotNull String str) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$setSpannedTitle");
        Intrinsics.checkNotNullParameter(str, "title");
        Context context = toolbar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        toolbar.setTitle(Typefaces.getTypefaceSpannable(context, str, TypefaceType.Medium));
    }

    public static final void tintMenu(@NotNull Toolbar toolbar, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$tintMenu");
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            Context context = toolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            MenusKt.tint(menu, context, i);
        }
    }

    public static final void tintMenuByAttr(@NotNull Toolbar toolbar, @AttrRes int i) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$tintMenuByAttr");
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            Context context = toolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            MenusKt.tintByAttr(menu, context, i);
        }
    }

    @NotNull
    public static final Observable<Unit> upClicks(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "$this$upClicks");
        Observable<Unit> create = Observable.create(new a(toolbar));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …ext(Unit)\n        }\n    }");
        return create;
    }
}
