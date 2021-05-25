package com.avito.android.component.clickable_info_block;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.component.clickable_info_block.ClickableInfoBlock;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.component.info_block.InfoBlockImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020%¢\u0006\u0004\b+\u0010,J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u0019\u0010\u001dJ\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\"\u0010\u0014J\u001a\u0010\"\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\"\u0010\u001dJ\u0010\u0010$\u001a\u00020\u0004H\u0001¢\u0006\u0004\b$\u0010\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/component/clickable_info_block/ClickableInfoBlockImpl;", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "Lcom/avito/android/component/info_block/InfoBlock;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock$Action;", "actions", "Lio/reactivex/rxjava3/core/Maybe;", "showActions", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Maybe;", "", "enabled", "setEnabled", "(Z)V", "", "text", "bindText", "(Ljava/lang/CharSequence;)V", "hide", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "drawableRes", "(I)V", "Landroid/content/res/ColorStateList;", "colorList", "setIconTintColor", "(Landroid/content/res/ColorStateList;)V", "setText", "textId", "show", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "moreButton", AuthSource.BOOKING_ORDER, "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ClickableInfoBlockImpl implements ClickableInfoBlock, InfoBlock {
    public final View a;
    public final View b;
    public final /* synthetic */ InfoBlockImpl c;

    public static final class a<T> implements MaybeOnSubscribe<ClickableInfoBlock.Action> {
        public final /* synthetic */ PopupMenu a;
        public final /* synthetic */ Map b;

        /* renamed from: com.avito.android.component.clickable_info_block.ClickableInfoBlockImpl$a$a  reason: collision with other inner class name */
        public static final class C0135a implements PopupMenu.OnMenuItemClickListener {
            public final /* synthetic */ a a;
            public final /* synthetic */ MaybeEmitter b;

            public C0135a(a aVar, MaybeEmitter maybeEmitter) {
                this.a = aVar;
                this.b = maybeEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.b.onSuccess(r.getValue(this.a.b, menuItem));
                return true;
            }
        }

        public static final class b implements Cancellable {
            public final /* synthetic */ a a;

            public b(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.dismiss();
            }
        }

        public static final class c implements PopupMenu.OnDismissListener {
            public final /* synthetic */ MaybeEmitter a;

            public c(MaybeEmitter maybeEmitter) {
                this.a = maybeEmitter;
            }

            @Override // android.widget.PopupMenu.OnDismissListener
            public final void onDismiss(PopupMenu popupMenu) {
                this.a.onComplete();
            }
        }

        public a(PopupMenu popupMenu, Map map) {
            this.a = popupMenu;
            this.b = map;
        }

        @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
        public final void subscribe(MaybeEmitter<ClickableInfoBlock.Action> maybeEmitter) {
            this.a.setOnMenuItemClickListener(new C0135a(this, maybeEmitter));
            this.a.show();
            maybeEmitter.setCancellable(new b(this));
            this.a.setOnDismissListener(new c(maybeEmitter));
        }
    }

    public ClickableInfoBlockImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = new InfoBlockImpl(view);
        this.b = view;
        View findViewById = view.findViewById(R.id.more);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void bindText(@Nullable CharSequence charSequence) {
        this.c.bindText(charSequence);
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.b);
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.c.hide();
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    public void setEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@DrawableRes int i) {
        this.c.setIcon(i);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.c.setIcon(drawable);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIconTintColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorList");
        this.c.setIconTintColor(colorStateList);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.c.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.c.show();
    }

    @Override // com.avito.android.component.clickable_info_block.ClickableInfoBlock
    @NotNull
    public Maybe<ClickableInfoBlock.Action> showActions(@NotNull List<ClickableInfoBlock.Action> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        PopupMenu popupMenu = new PopupMenu(this.b.getContext(), this.a);
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(TuplesKt.to(popupMenu.getMenu().add(t.getText()), t));
        }
        Maybe<ClickableInfoBlock.Action> create = Maybe.create(new a(popupMenu, r.toMap(arrayList)));
        Intrinsics.checkNotNullExpressionValue(create, "Maybe.create { emitter -….onComplete() }\n        }");
        return create;
    }
}
