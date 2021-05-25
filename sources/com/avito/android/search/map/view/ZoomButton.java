package com.avito.android.search.map.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.R;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010!B#\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b\u001d\u0010$R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\t8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006%"}, d2 = {"Lcom/avito/android/search/map/view/ZoomButton;", "Landroidx/cardview/widget/CardView;", "Lio/reactivex/rxjava3/core/Observable;", "", "l", "Lio/reactivex/rxjava3/core/Observable;", "getZoomInClicks", "()Lio/reactivex/rxjava3/core/Observable;", "zoomInClicks", "Landroid/widget/FrameLayout;", "o", "Lkotlin/Lazy;", "getZoomOutButton", "()Landroid/widget/FrameLayout;", "zoomOutButton", "Lcom/jakewharton/rxrelay3/PublishRelay;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "zoomInRelay", "n", "getZoomInButton", "zoomInButton", AuthSource.OPEN_CHANNEL_LIST, "getZoomOutClicks", "zoomOutClicks", "k", "zoomOutRelay", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class ZoomButton extends CardView {
    public final PublishRelay<Unit> j;
    public final PublishRelay<Unit> k;
    @NotNull
    public final Observable<Unit> l;
    @NotNull
    public final Observable<Unit> m;
    public final Lazy n = c.lazy(new b(0, this));
    public final Lazy o = c.lazy(new b(1, this));

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
                ((ZoomButton) this.b).j.accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((ZoomButton) this.b).k.accept(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<FrameLayout> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final FrameLayout invoke() {
            int i = this.a;
            if (i == 0) {
                View findViewById = ((ZoomButton) this.b).findViewById(R.id.zoomIn);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
                return (FrameLayout) findViewById;
            } else if (i == 1) {
                View findViewById2 = ((ZoomButton) this.b).findViewById(R.id.zoomOut);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
                return (FrameLayout) findViewById2;
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.k = create2;
        this.l = create;
        this.m = create2;
        View.inflate(getContext(), R.layout.search_map_zoom_button, this);
        getZoomInButton().setOnClickListener(new a(0, this));
        getZoomOutButton().setOnClickListener(new a(1, this));
    }

    private final FrameLayout getZoomInButton() {
        return (FrameLayout) this.n.getValue();
    }

    private final FrameLayout getZoomOutButton() {
        return (FrameLayout) this.o.getValue();
    }

    @NotNull
    public final Observable<Unit> getZoomInClicks() {
        return this.l;
    }

    @NotNull
    public final Observable<Unit> getZoomOutClicks() {
        return this.m;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.k = create2;
        this.l = create;
        this.m = create2;
        View.inflate(getContext(), R.layout.search_map_zoom_button, this);
        getZoomInButton().setOnClickListener(new a(0, this));
        getZoomOutButton().setOnClickListener(new a(1, this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZoomButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.k = create2;
        this.l = create;
        this.m = create2;
        View.inflate(getContext(), R.layout.search_map_zoom_button, this);
        getZoomInButton().setOnClickListener(new a(0, this));
        getZoomOutButton().setOnClickListener(new a(1, this));
    }
}
