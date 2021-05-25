package com.avito.android.suggest_locations;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b'\u0010.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006/"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsToolbarImpl;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/suggest_locations/SuggestLocationsToolbar;", "", "query", "", "updateText", "(Ljava/lang/String;)V", "hint", "setHint", "showKeyboard", "()V", "Lio/reactivex/rxjava3/core/Observable;", "backPressed", "()Lio/reactivex/rxjava3/core/Observable;", "donePressed", "queryEmits", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/jakewharton/rxrelay3/PublishRelay;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "backPressedRelay", "f", "donePressedRelay", "Landroid/widget/ImageView;", AuthSource.BOOKING_ORDER, "Landroid/widget/ImageView;", "clearQueryButton", "Landroidx/appcompat/widget/AppCompatEditText;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/AppCompatEditText;", "queryInput", "c", "backButton", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsToolbarImpl extends FrameLayout implements SuggestLocationsToolbar {
    public final AppCompatEditText a;
    public final ImageView b;
    public final ImageView c;
    public final Toolbar d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<String> f;

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
                Editable text = ((SuggestLocationsToolbarImpl) this.b).a.getText();
                if (text != null) {
                    text.clear();
                }
            } else if (i == 1) {
                ((SuggestLocationsToolbarImpl) this.b).e.accept(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ SuggestLocationsToolbarImpl a;

        public b(SuggestLocationsToolbarImpl suggestLocationsToolbarImpl) {
            this.a = suggestLocationsToolbarImpl;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.a.f.accept(String.valueOf(this.a.a.getText()));
            return true;
        }
    }

    public static final class c<T> implements Consumer<CharSequence> {
        public final /* synthetic */ SuggestLocationsToolbarImpl a;

        public c(SuggestLocationsToolbarImpl suggestLocationsToolbarImpl) {
            this.a = suggestLocationsToolbarImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            ImageView imageView = this.a.b;
            Intrinsics.checkNotNullExpressionValue(charSequence2, "it");
            Views.setVisible(imageView, !m.isBlank(charSequence2));
        }
    }

    public static final class d<T, R> implements Function<CharSequence, String> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SuggestLocationsToolbarImpl(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    @NotNull
    public Observable<Unit> backPressed() {
        return this.e;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    @NotNull
    public Observable<String> donePressed() {
        return this.f;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    @NotNull
    public Observable<String> queryEmits() {
        Observable<R> map = RxTextView.textChanges(this.a).doOnNext(new c(this)).map(d.a);
        Intrinsics.checkNotNullExpressionValue(map, "queryInput.textChanges()…   .map { it.toString() }");
        return map;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.a.setHint(str);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    public void showKeyboard() {
        Keyboards.showKeyboardWithAttempt$default(this.a, 0, 10, 1, null);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsToolbar
    public void updateText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.a.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SuggestLocationsToolbarImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestLocationsToolbarImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.e = create;
        PublishRelay<String> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.f = create2;
        LayoutInflater.from(getContext()).inflate(R.layout.suggest_locations_search_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.query);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.query)");
        AppCompatEditText appCompatEditText = (AppCompatEditText) findViewById;
        this.a = appCompatEditText;
        View findViewById2 = findViewById(R.id.clear);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.clear)");
        ImageView imageView = (ImageView) findViewById2;
        this.b = imageView;
        View findViewById3 = findViewById(R.id.back);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.back)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.c = imageView2;
        View findViewById4 = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById4;
        this.d = toolbar;
        imageView.setOnClickListener(new a(0, this));
        imageView2.setOnClickListener(new a(1, this));
        toolbar.setNavigationIcon((Drawable) null);
        appCompatEditText.setOnEditorActionListener(new b(this));
    }
}
