package com.avito.android.messenger.map;

import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001'B+\u0012\u0006\u0010@\u001a\u00020.\u0012\b\b\u0001\u0010B\u001a\u00020A\u0012\b\b\u0001\u0010C\u001a\u00020A\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00106\u001a\n 3*\u0004\u0018\u000102028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010:\u001a\n 3*\u0004\u0018\u000107078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020.0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00100¨\u0006H"}, d2 = {"Lcom/avito/android/messenger/map/MapBottomSheetImpl;", "Lcom/avito/android/messenger/map/MapBottomSheet;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "prevState", "curState", "", "render", "(Lcom/avito/android/messenger/map/MapBottomSheet$State;Lcom/avito/android/messenger/map/MapBottomSheet$State;)V", "Lio/reactivex/rxjava3/core/Observable;", "l", "Lio/reactivex/rxjava3/core/Observable;", "getActionButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "actionButtonClicks", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "content", "Lcom/avito/android/lib/design/button/Button;", "j", "Lcom/avito/android/lib/design/button/Button;", "actionButton", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "k", "getVisibilityStream", "visibilityStream", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "collapsedTitleTextView", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay3/PublishRelay;", "getEditDescriptionClicks", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "editDescriptionClicks", "e", "titleTextView", "Lru/avito/component/bottom_sheet/BottomSheet;", "c", "Lru/avito/component/bottom_sheet/BottomSheet;", "bottomSheet", "Landroidx/core/widget/NestedScrollView;", "h", "Landroidx/core/widget/NestedScrollView;", "descriptionScrollView", "Landroid/view/View;", "f", "Landroid/view/View;", "collapsedTitleContainer", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "Landroid/view/LayoutInflater;", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "layoutInflater", "", "i", "Ljava/util/List;", "descriptionViews", "n", "rootView", "", "actionButtonAppearance", "actionButtonText", "", "lockExpanded", "<init>", "(Landroid/view/View;IIZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MapBottomSheetImpl implements MapBottomSheet {
    public final Resources a;
    public final LayoutInflater b;
    public final BottomSheet c;
    public final LinearLayout d;
    public final TextView e;
    public final View f;
    public final TextView g;
    public final NestedScrollView h;
    public final List<View> i = new ArrayList();
    public final Button j;
    @NotNull
    public final Observable<BottomSheet.Visibility> k;
    @NotNull
    public final Observable<Unit> l;
    @NotNull
    public final PublishRelay<Unit> m;
    public final View n;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ MapBottomSheetImpl a;
        public final /* synthetic */ View b;

        /* renamed from: com.avito.android.messenger.map.MapBottomSheetImpl$a$a  reason: collision with other inner class name */
        public static final class RunnableC0146a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ int b;

            public RunnableC0146a(a aVar, int i) {
                this.a = aVar;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.h.smoothScrollTo(0, this.b);
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ a a;

            public b(a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.h.smoothScrollTo(0, 0);
            }
        }

        public a(MapBottomSheetImpl mapBottomSheetImpl, View view) {
            this.a = mapBottomSheetImpl;
            this.b = view;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int height;
            Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 3 && actionMasked != 1) || (height = this.a.e.getHeight() - this.a.g.getHeight()) <= 0) {
                return false;
            }
            int scrollY = this.a.h.getScrollY();
            int i = height / 2;
            if (i <= scrollY && height > scrollY) {
                this.b.post(new RunnableC0146a(this, height));
                return false;
            } else if (scrollY < 0 || i <= scrollY) {
                return false;
            } else {
                this.b.post(new b(this));
                return false;
            }
        }
    }

    public static final class b<T> implements Consumer<BottomSheet.Visibility> {
        public final /* synthetic */ MapBottomSheetImpl a;
        public final /* synthetic */ View b;

        public b(MapBottomSheetImpl mapBottomSheetImpl, View view) {
            this.a = mapBottomSheetImpl;
            this.b = view;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(BottomSheet.Visibility visibility) {
            if (!Intrinsics.areEqual(visibility, BottomSheet.Visibility.Expanded.INSTANCE)) {
                this.b.post(new a2.a.a.o1.e.a(this));
            }
        }
    }

    public static final class c extends ImageSpan {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(@NotNull Drawable drawable) {
            super(drawable, 0);
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @Nullable CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Drawable drawable = getDrawable();
            canvas.save();
            Intrinsics.checkNotNullExpressionValue(drawable, "d");
            canvas.translate(f, (float) ((i5 - drawable.getBounds().bottom) - (paint.getFontMetricsInt().descent / 2)));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public MapBottomSheetImpl(@NotNull View view, @StyleRes int i2, @StringRes int i3, boolean z) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.n = view;
        Resources resources = view.getResources();
        this.a = resources;
        this.b = LayoutInflater.from(view.getContext());
        BottomSheet.Companion companion = BottomSheet.Companion;
        View findViewById = view.findViewById(R.id.messenger_map_bottom_sheet_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…_map_bottom_sheet_layout)");
        BottomSheet create = companion.create(findViewById);
        this.c = create;
        this.k = create.getVisibilityObservable();
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.m = create2;
        Views.conceal(create.getView());
        create.setLockExpanded(z);
        create.setDimBackgroundOnExpand(true);
        View contentView = create.setContentView(R.layout.messenger_platform_map_bottom_sheet_content);
        View findViewById2 = contentView.findViewById(R.id.messenger_map_bottom_sheet_content);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.d = (LinearLayout) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.messenger_map_bottom_sheet_title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.messenger_map_bottom_sheet_collapsed_title_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById4;
        View findViewById5 = contentView.findViewById(R.id.messenger_map_bottom_sheet_collapsed_title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById5;
        View findViewById6 = contentView.findViewById(R.id.messenger_map_bottom_sheet_description_scroll);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById6;
        this.h = nestedScrollView;
        View findViewById7 = contentView.findViewById(R.id.messenger_map_bottom_sheet_action_button);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById7;
        this.j = button;
        this.l = RxView.clicks(button);
        button.setAppearance(i2);
        String string = resources.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(actionButtonText)");
        button.setText(string);
        nestedScrollView.setOnTouchListener(new a(this, contentView));
        getVisibilityStream().distinctUntilChanged().subscribe(new b(this, contentView));
    }

    public static final void access$addEditIcon(MapBottomSheetImpl mapBottomSheetImpl, TextView textView) {
        Objects.requireNonNull(mapBottomSheetImpl);
        View rootView = textView.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        Drawable drawable = ContextCompat.getDrawable(rootView.getContext(), com.avito.android.ui_components.R.drawable.ic_edit_16_gray);
        if (drawable != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "editDrawable");
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            String str = textView.getText() + "  ";
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new c(drawable), str.length() - 1, str.length(), 17);
            textView.setText(spannableString);
        }
    }

    public static final void access$applyTopMargin(MapBottomSheetImpl mapBottomSheetImpl, View view, int i2) {
        Objects.requireNonNull(mapBottomSheetImpl);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(i2);
        view.setLayoutParams(marginLayoutParams);
    }

    public static final TextView access$createDescriptionTextView(MapBottomSheetImpl mapBottomSheetImpl, CharSequence charSequence) {
        Objects.requireNonNull(mapBottomSheetImpl);
        View inflate = mapBottomSheetImpl.b.inflate(R.layout.messenger_platform_map_bottom_sheet_description_text, (ViewGroup) mapBottomSheetImpl.d, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setId(View.generateViewId());
        textView.setTag("messenger_map_bottom_sheet_description_text");
        return textView;
    }

    public static final void access$setBottomSheetDescription(MapBottomSheetImpl mapBottomSheetImpl, List list, boolean z) {
        Objects.requireNonNull(mapBottomSheetImpl);
        if (!mapBottomSheetImpl.i.isEmpty() || !list.isEmpty()) {
            for (View view : mapBottomSheetImpl.i) {
                mapBottomSheetImpl.d.removeView(view);
            }
            mapBottomSheetImpl.i.clear();
            if (!list.isEmpty()) {
                int dimensionPixelSize = mapBottomSheetImpl.n.getResources().getDimensionPixelSize(R.dimen.messenger_platform_map_bottom_sheet_descr_text_vertical_margin);
                int i2 = 0;
                for (Object obj : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    View inflate = mapBottomSheetImpl.b.inflate(R.layout.messenger_platform_map_bottom_sheet_description_text, (ViewGroup) mapBottomSheetImpl.d, false);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView = (TextView) inflate;
                    textView.setText((CharSequence) obj);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setId(View.generateViewId());
                    textView.setTag("messenger_map_bottom_sheet_description_text");
                    if (i2 == 0 && z) {
                        View rootView = textView.getRootView();
                        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                        Drawable drawable = ContextCompat.getDrawable(rootView.getContext(), com.avito.android.ui_components.R.drawable.ic_edit_16_gray);
                        if (drawable != null) {
                            Intrinsics.checkNotNullExpressionValue(drawable, "editDrawable");
                            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            String str = textView.getText() + "  ";
                            SpannableString spannableString = new SpannableString(str);
                            spannableString.setSpan(new c(drawable), str.length() - 1, str.length(), 17);
                            textView.setText(spannableString);
                        }
                        textView.setOnClickListener(new View.OnClickListener(z, dimensionPixelSize) { // from class: com.avito.android.messenger.map.MapBottomSheetImpl$setBottomSheetDescription$$inlined$forEachIndexed$lambda$3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                MapBottomSheetImpl.this.getEditDescriptionClicks().accept(Unit.INSTANCE);
                            }
                        });
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.bottomMargin = dimensionPixelSize;
                    mapBottomSheetImpl.d.addView(textView, i3, layoutParams);
                    mapBottomSheetImpl.i.add(textView);
                    i2 = i3;
                }
            }
        }
    }

    @Override // com.avito.android.messenger.map.MapBottomSheet
    @NotNull
    public Observable<Unit> getActionButtonClicks() {
        return this.l;
    }

    @Override // com.avito.android.messenger.map.MapBottomSheet
    @NotNull
    public Observable<BottomSheet.Visibility> getVisibilityStream() {
        return this.k;
    }

    @Override // com.avito.android.messenger.map.MapBottomSheet
    @NotNull
    public PublishRelay<Unit> getEditDescriptionClicks() {
        return this.m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: android.view.LayoutInflater */
    /* JADX DEBUG: Multi-variable search result rejected for r8v9, resolved type: android.graphics.drawable.Drawable */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(@org.jetbrains.annotations.Nullable com.avito.android.messenger.map.MapBottomSheet.State r17, @org.jetbrains.annotations.NotNull com.avito.android.messenger.map.MapBottomSheet.State r18) {
        /*
        // Method dump skipped, instructions count: 743
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.map.MapBottomSheetImpl.render(com.avito.android.messenger.map.MapBottomSheet$State, com.avito.android.messenger.map.MapBottomSheet$State):void");
    }
}
