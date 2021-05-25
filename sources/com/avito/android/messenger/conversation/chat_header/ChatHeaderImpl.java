package com.avito.android.messenger.conversation.chat_header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.chat_header.ChatHeader;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
public final class ChatHeaderImpl implements ChatHeader {
    public final Context a;
    public final View b;
    public final ViewGroup c;
    public final TextView d;
    public final ItemTitleAndPriceView e;
    public final TextView f;
    public final TextView g;
    public final View h;
    public final SimpleDraweeView i;
    public final View j;
    public final View k;
    public final AccelerateDecelerateInterpolator l = new AccelerateDecelerateInterpolator();
    public final Drawable m;
    public ChatHeader.State n;
    public boolean o;
    public boolean p;
    public final PublishRelay<Unit> q;
    public final PublishRelay<Unit> r;
    @NotNull
    public final PublishRelay<View> s;
    @NotNull
    public final PublishRelay<View> t;
    public final ConstraintLayout u;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<TransitionDsl<Fade>, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(1);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(TransitionDsl<Fade> transitionDsl) {
            int i = this.a;
            if (i == 0) {
                TransitionDsl<Fade> transitionDsl2 = transitionDsl;
                Intrinsics.checkNotNullParameter(transitionDsl2, "$receiver");
                ItemTitleAndPriceView itemTitleAndPriceView = ((ChatHeaderImpl) this.b).e;
                Intrinsics.checkNotNullExpressionValue(itemTitleAndPriceView, "itemTitle");
                transitionDsl2.addTarget(itemTitleAndPriceView);
                TextView textView = ((ChatHeaderImpl) this.b).f;
                Intrinsics.checkNotNullExpressionValue(textView, "dealActionTitle");
                transitionDsl2.addTarget(textView);
                TextView textView2 = ((ChatHeaderImpl) this.b).d;
                Intrinsics.checkNotNullExpressionValue(textView2, "chatTitle");
                transitionDsl2.addTarget(textView2);
                TextView textView3 = ((ChatHeaderImpl) this.b).g;
                Intrinsics.checkNotNullExpressionValue(textView3, "chatSubtitle");
                transitionDsl2.addTarget(textView3);
                View view = ((ChatHeaderImpl) this.b).h;
                Intrinsics.checkNotNullExpressionValue(view, "itemImageContainer");
                transitionDsl2.addTarget(view);
                return Unit.INSTANCE;
            } else if (i == 1) {
                TransitionDsl<Fade> transitionDsl3 = transitionDsl;
                Intrinsics.checkNotNullParameter(transitionDsl3, "$receiver");
                View view2 = ((ChatHeaderImpl) this.b).b;
                Intrinsics.checkNotNullExpressionValue(view2, "titleContainer");
                transitionDsl3.addTarget(view2);
                View view3 = ((ChatHeaderImpl) this.b).k;
                Intrinsics.checkNotNullExpressionValue(view3, "connectionIndicator");
                transitionDsl3.addTarget(view3);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ GestureDetector a;

        public b(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public static final class c extends Lambda implements Function1<Transition, Unit> {
        public final /* synthetic */ ChatHeaderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ChatHeaderImpl chatHeaderImpl) {
            super(1);
            this.a = chatHeaderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "it");
            Views.conceal(this.a.c);
            ChatHeaderImpl chatHeaderImpl = this.a;
            chatHeaderImpl.s.accept(chatHeaderImpl.u);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Transition, Unit> {
        public final /* synthetic */ ChatHeaderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChatHeaderImpl chatHeaderImpl) {
            super(1);
            this.a = chatHeaderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Transition transition) {
            Intrinsics.checkNotNullParameter(transition, "it");
            ChatHeaderImpl chatHeaderImpl = this.a;
            chatHeaderImpl.t.accept(chatHeaderImpl.u);
            return Unit.INSTANCE;
        }
    }

    public ChatHeaderImpl(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "layout");
        this.u = constraintLayout;
        Context context = constraintLayout.getContext();
        this.a = context;
        View findViewById = constraintLayout.findViewById(R.id.title_container);
        this.b = findViewById;
        this.c = (ViewGroup) constraintLayout.findViewById(R.id.item_title_container);
        this.d = (TextView) constraintLayout.findViewById(R.id.name);
        this.e = (ItemTitleAndPriceView) constraintLayout.findViewById(R.id.item_title);
        this.f = (TextView) constraintLayout.findViewById(R.id.deal_action_title);
        this.g = (TextView) constraintLayout.findViewById(R.id.online_status);
        this.h = constraintLayout.findViewById(R.id.item_image_container);
        this.i = (SimpleDraweeView) constraintLayout.findViewById(R.id.item_image);
        this.j = constraintLayout.findViewById(R.id.back_button);
        this.k = constraintLayout.findViewById(R.id.connection_indicator);
        this.m = context.getDrawable(R.drawable.ic_messenger_item_no_image);
        this.q = PublishRelay.create();
        this.r = PublishRelay.create();
        PublishRelay<View> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.s = create;
        PublishRelay<View> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.t = create2;
        findViewById.setOnTouchListener(new b(new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this) { // from class: com.avito.android.messenger.conversation.chat_header.ChatHeaderImpl$titleGestureDetector$1
            public final /* synthetic */ ChatHeaderImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(@NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "e");
                this.a.q.accept(Unit.INSTANCE);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "e");
                this.a.r.accept(Unit.INSTANCE);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(@NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "e");
                this.a.q.accept(Unit.INSTANCE);
                return true;
            }
        })));
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    public void collapse(boolean z) {
        if (!this.p && !this.o) {
            this.o = true;
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.u);
            int i2 = R.id.item_title_container;
            constraintSet.clear(i2, 3);
            constraintSet.connect(i2, 4, R.id.title_container, 4);
            int i3 = R.id.item_image_container;
            constraintSet.clear(i3, 3);
            constraintSet.connect(i3, 3, 0, 3);
            constraintSet.applyTo(this.u);
            Views.show(this.c);
            ViewParent parent = this.u.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (!z || viewGroup == null) {
                Views.conceal(this.c);
                this.s.accept(this.u);
                return;
            }
            TransitionDsl transitionDsl = new TransitionDsl(new ChangeBounds());
            transitionDsl.setInterpolator(this.l);
            View view = this.h;
            Intrinsics.checkNotNullExpressionValue(view, "itemImageContainer");
            transitionDsl.addTarget(view);
            ViewGroup viewGroup2 = this.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "itemTitleContainer");
            transitionDsl.addTarget(viewGroup2);
            transitionDsl.addTarget(this.u);
            transitionDsl.addTarget(R.id.bottom_divider);
            transitionDsl.onTransitionEnd(new c(this));
            TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        }
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    public void expand(boolean z) {
        if (!this.p) {
            this.o = false;
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.u);
            int i2 = R.id.item_title_container;
            constraintSet.clear(i2, 4);
            constraintSet.connect(i2, 3, R.id.title_container, 4);
            int i3 = R.id.item_image_container;
            constraintSet.clear(i3, 3);
            constraintSet.connect(i3, 3, i2, 3);
            constraintSet.applyTo(this.u);
            Views.show(this.c);
            ViewParent parent = this.u.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (!z || viewGroup == null) {
                this.t.accept(this.u);
                return;
            }
            TransitionDsl transitionDsl = new TransitionDsl(new ChangeBounds());
            transitionDsl.setInterpolator(this.l);
            View view = this.h;
            Intrinsics.checkNotNullExpressionValue(view, "itemImageContainer");
            transitionDsl.addTarget(view);
            ViewGroup viewGroup2 = this.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "itemTitleContainer");
            transitionDsl.addTarget(viewGroup2);
            transitionDsl.addTarget(this.u);
            transitionDsl.addTarget(R.id.bottom_divider);
            transitionDsl.onTransitionEnd(new d(this));
            TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
        }
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    @NotNull
    public Observable<Unit> getBackNavigationClicks() {
        View view = this.j;
        Intrinsics.checkNotNullExpressionValue(view, "backButton");
        return RxView.clicks(view);
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    public Observable getCollapses() {
        return this.s;
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    public Observable getExpansions() {
        return this.t;
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    @NotNull
    public Observable<Unit> getItemImageClicks() {
        View view = this.h;
        Intrinsics.checkNotNullExpressionValue(view, "itemImageContainer");
        return RxView.clicks(view);
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    @NotNull
    public Observable<Unit> getItemTitleClicks() {
        ViewGroup viewGroup = this.c;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "itemTitleContainer");
        return RxView.clicks(viewGroup);
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    @NotNull
    public Observable<Unit> getTitleClicks() {
        PublishRelay<Unit> publishRelay = this.q;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "titleClicksAndDoubleClicksRelay");
        return publishRelay;
    }

    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    @NotNull
    public Observable<Unit> getTitleLongClicks() {
        PublishRelay<Unit> publishRelay = this.r;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "titleLongClicksRelay");
        return publishRelay;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bf, code lost:
        if ((r0.length() > 0) != false) goto L_0x00c3;
     */
    @Override // com.avito.android.messenger.conversation.chat_header.ChatHeader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.chat_header.ChatHeader.State r13) {
        /*
        // Method dump skipped, instructions count: 381
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.chat_header.ChatHeaderImpl.render(com.avito.android.messenger.conversation.chat_header.ChatHeader$State):void");
    }
}
