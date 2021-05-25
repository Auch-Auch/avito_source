package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import a2.a.a.o1.d.a0.k.a.e.f;
import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.button.Button;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.confirmation_dialog.ConfirmationDialogView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\bj\u0010kJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010 \u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\u00192\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\"\"\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R:\u00100\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00109\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020%058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R:\u0010;\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u00070\u0007 -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u00070\u0007\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010/R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R:\u0010A\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u00070\u0007 -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u00070\u0007\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010/R\u0016\u0010D\u001a\u00020B8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b \u0010CR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00100E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010N\u001a\u00020I8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001e\u0010Q\u001a\n -*\u0004\u0018\u00010O0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001e\u0010_\u001a\n -*\u0004\u0018\u00010]0]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010^R:\u0010a\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010/R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001e\u0010i\u001a\n -*\u0004\u0018\u00010f0f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "presenter", "", "bindPresenter", "(Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter;)V", "unbindPresenter", "()V", "Landroid/view/ViewGroup;", "container", "Landroid/view/ViewGroup$LayoutParams;", "params", "Landroid/view/View;", "closeButton", "addToParent", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V", "removeFromParent", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "content", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "uiData", "", "render", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;)Z", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;", "actions", "isBottomSheet", "c", "(Ljava/util/List;Z)V", "", AuthSource.SEND_ABUSE, "([Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State$Action;)Z", "", "spacing", AuthSource.BOOKING_ORDER, "(I)V", "h", "Z", "closeButtonIsVisible", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "j", "Lcom/jakewharton/rxrelay2/PublishRelay;", "actionConfirmedStream", "Lcom/avito/android/util/ImplicitIntentFactory;", "r", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "", "", "n", "Ljava/util/Map;", "buttonIdCache", "f", "closeClicks", "Landroid/content/Context;", VKApiConst.Q, "Landroid/content/Context;", "context", "k", "confirmationDialogDismissedStream", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "actionButtons", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View$OnClickListener;", g.a, "Landroid/view/View$OnClickListener;", "closeClickListener", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "o", "Lcom/avito/android/messenger/conversation/confirmation_dialog/ConfirmationDialogView;", "confirmationDialog", "p", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "lastRenderedState", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "i", "actionButtonsClicksStream", "Lio/reactivex/disposables/CompositeDisposable;", "l", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "progress", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/ImplicitIntentFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ContextActionsView implements LegacyPlatformActionsView.ContentView<ContextActionsPresenter.State, ContextActionsPresenter> {
    public final Resources a;
    public final LayoutInflater b;
    @SuppressLint({"InflateParams"})
    public final ConstraintLayout c;
    public final ProgressBar d;
    @NotNull
    public final TextView e;
    public final PublishRelay<Unit> f = PublishRelay.create();
    public final View.OnClickListener g = new d(this);
    public boolean h;
    public final PublishRelay<ContextActionsPresenter.State.Action> i = PublishRelay.create();
    public final PublishRelay<ContextActionsPresenter.State.Action> j = PublishRelay.create();
    public final PublishRelay<Unit> k = PublishRelay.create();
    public final CompositeDisposable l = new CompositeDisposable();
    public final List<View> m = new ArrayList();
    public final Map<String, Integer> n = new LinkedHashMap();
    public final ConfirmationDialogView o;
    public ContextActionsPresenter.State p;
    public final Context q;
    public final ImplicitIntentFactory r;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((ContextActionsPresenter) this.b).handleCloseAction();
            } else if (i == 1) {
                ((ContextActionsPresenter) this.b).onConfirmationDialogDismissed();
            } else {
                throw null;
            }
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ContextActionsView a;

        public d(ContextActionsView contextActionsView) {
            this.a = contextActionsView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.f.accept(Unit.INSTANCE);
        }
    }

    public ContextActionsView(@NotNull Context context, @NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        this.q = context;
        this.r = implicitIntentFactory;
        this.a = context.getResources();
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        View inflate = from.inflate(R.layout.messenger_context_actions, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.c = constraintLayout;
        this.d = (ProgressBar) constraintLayout.findViewById(R.id.messenger_platform_actions_progress);
        View findViewById = constraintLayout.findViewById(R.id.messenger_platform_actions_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id…r_platform_actions_title)");
        this.e = (TextView) findViewById;
        this.o = new ConfirmationDialogView(context);
    }

    public final boolean a(ContextActionsPresenter.State.Action... actionArr) {
        int length = actionArr.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                return true;
            }
            if (actionArr[i2].getTitle().length() > 10) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i2++;
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void addToParent(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        if (!Intrinsics.areEqual(this.c.getParent(), viewGroup)) {
            Views.removeFromParent(this.c);
            viewGroup.addView(this.c, layoutParams);
        }
        if (view != null) {
            view.setOnClickListener(this.g);
        }
        if (view != null) {
            Views.setVisible(view, this.h);
        }
    }

    public final void b(int i2) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.c);
        int i3 = 0;
        for (T t : this.m) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            constraintSet.connect(t2.getId(), 6, 0, 6);
            constraintSet.connect(t2.getId(), 7, 0, 7);
            if (i3 != 0) {
                constraintSet.connect(t2.getId(), 3, this.m.get(i3 - 1).getId(), 4);
            } else {
                constraintSet.connect(t2.getId(), 3, R.id.messenger_platform_actions_title_container, 4);
            }
            i3 = i4;
        }
        int size = this.m.size();
        for (int i5 = 1; i5 < size; i5++) {
            constraintSet.setMargin(this.m.get(i5).getId(), 3, i2);
        }
        constraintSet.applyTo(this.c);
    }

    public final void c(List<ContextActionsPresenter.State.Action> list, boolean z) {
        int i2;
        List<ContextActionsPresenter.State.Action> list2;
        List<View> list3 = this.m;
        ConstraintLayout constraintLayout = this.c;
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            constraintLayout.removeView(it.next());
        }
        this.m.clear();
        if (z) {
            i2 = this.a.getDimensionPixelSize(R.dimen.messenger_platform_actions_buttons_internal_margin_sheet);
        } else {
            i2 = this.a.getDimensionPixelSize(R.dimen.messenger_platform_actions_buttons_internal_margin_sticky);
        }
        if (list.size() <= 3 || z) {
            list2 = list;
        } else {
            Logs.warning$default("ContextActionsView", "More than 3 buttons is currently not supported in sticky view", null, 4, null);
            list2 = CollectionsKt___CollectionsKt.take(list, 3);
        }
        int i3 = 0;
        int i4 = 0;
        for (T t : list2) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            View inflate = this.b.inflate(R.layout.messenger_platform_action_button, (ViewGroup) this.c, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
            Button button = (Button) inflate;
            if (t2.isPrimary()) {
                button.setAppearance(com.avito.android.lib.design.R.style.Deprecated_Button_Appearance_Primary);
            } else {
                button.setAppearance(com.avito.android.lib.design.R.style.Deprecated_Button_Appearance_Secondary);
            }
            Map<String, Integer> map = this.n;
            String str = i4 + ": " + t2.getTitle();
            Integer num = map.get(str);
            if (num == null) {
                num = Integer.valueOf(View.generateViewId());
                map.put(str, num);
            }
            button.setId(num.intValue());
            button.setClickable(true);
            button.setFocusable(true);
            button.setText(t2.getTitle());
            button.setOnClickListener(new a2.a.a.o1.d.a0.k.a.e.c(this, t2));
            this.c.addView(button, new ConstraintLayout.LayoutParams(0, -2));
            this.m.add(button);
            i4 = i5;
        }
        if (z) {
            b(i2);
        } else if (list2.size() == 2 && a(list2.get(0), list2.get(1))) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.c);
            int id = this.m.get(0).getId();
            int i6 = R.id.messenger_platform_actions_title_container;
            constraintSet.connect(id, 3, i6, 4);
            constraintSet.connect(this.m.get(1).getId(), 3, i6, 4);
            List<View> list4 = this.m;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(it2.next().getId()));
            }
            int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            List<View> list5 = this.m;
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list5, 10));
            for (T t3 : list5) {
                arrayList2.add(Float.valueOf(1.0f));
            }
            constraintSet.createHorizontalChain(0, 1, 0, 2, intArray, CollectionsKt___CollectionsKt.toFloatArray(arrayList2), 0);
            int size = this.m.size() - 1;
            while (i3 < size) {
                int i7 = i2 / 2;
                constraintSet.setMargin(this.m.get(i3).getId(), 7, i7);
                i3++;
                constraintSet.setMargin(this.m.get(i3).getId(), 6, i7);
            }
            constraintSet.applyTo(this.c);
        } else if (list2.size() <= 2) {
            b(i2);
        } else if (list2.size() != 3 || a(list2.get(1), list2.get(2))) {
            if (this.m.size() == 3) {
                ConstraintSet constraintSet2 = new ConstraintSet();
                constraintSet2.clone(this.c);
                constraintSet2.connect(this.m.get(0).getId(), 6, 0, 6);
                constraintSet2.connect(this.m.get(0).getId(), 7, 0, 7);
                constraintSet2.connect(this.m.get(0).getId(), 3, R.id.messenger_platform_actions_title_container, 4);
                constraintSet2.setGoneMargin(this.m.get(0).getId(), 3, i2);
                constraintSet2.connect(this.m.get(1).getId(), 3, this.m.get(0).getId(), 4);
                constraintSet2.connect(this.m.get(2).getId(), 3, this.m.get(0).getId(), 4);
                constraintSet2.setMargin(this.m.get(1).getId(), 3, i2);
                constraintSet2.setMargin(this.m.get(2).getId(), 3, i2);
                constraintSet2.createHorizontalChain(0, 1, 0, 2, new int[]{this.m.get(1).getId(), this.m.get(2).getId()}, new float[]{1.0f, 1.0f}, 0);
                int i8 = i2 / 2;
                constraintSet2.setMargin(this.m.get(1).getId(), 7, i8);
                constraintSet2.setMargin(this.m.get(1).getId(), 3, i8);
                constraintSet2.setMargin(this.m.get(2).getId(), 6, i8);
                constraintSet2.setMargin(this.m.get(2).getId(), 3, i8);
                constraintSet2.applyTo(this.c);
                return;
            }
            throw new IllegalArgumentException("Mixed layout only supported for 3 buttons".toString());
        } else {
            b(i2);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void removeFromParent(@Nullable ViewGroup viewGroup, @Nullable View view) {
        this.o.dismiss();
        this.n.clear();
        this.p = null;
        if (viewGroup == null || Intrinsics.areEqual(this.c.getParent(), viewGroup)) {
            if (view != null) {
                Views.setVisible(view, this.h);
            }
            if (view != null) {
                view.setOnClickListener(null);
            }
            Views.removeFromParent(this.c);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void unbindPresenter() {
        this.l.clear();
    }

    public void bindPresenter(@NotNull LifecycleOwner lifecycleOwner, @NotNull ContextActionsPresenter contextActionsPresenter) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contextActionsPresenter, "presenter");
        PublishRelay<ContextActionsPresenter.State.Action> publishRelay = this.i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe = publishRelay.throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(new Function1<ContextActionsPresenter.State.Action, Unit>(contextActionsPresenter) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ContextActionsPresenter.State.Action action) {
                ContextActionsPresenter.State.Action action2 = action;
                Intrinsics.checkNotNullParameter(action2, "p1");
                ((ContextActionsPresenter) this.receiver).handleAction(action2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "actionButtonsClicksStrea…(presenter::handleAction)");
        DisposableKt.addTo(subscribe, this.l);
        Disposable subscribe2 = this.j.throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(new Function1<ContextActionsPresenter.State.Action, Unit>(contextActionsPresenter) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ContextActionsPresenter.State.Action action) {
                ContextActionsPresenter.State.Action action2 = action;
                Intrinsics.checkNotNullParameter(action2, "p1");
                ((ContextActionsPresenter) this.receiver).handleActionConfirmation(action2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "actionConfirmedStream\n  …handleActionConfirmation)");
        DisposableKt.addTo(subscribe2, this.l);
        Disposable subscribe3 = this.f.throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(0, contextActionsPresenter));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "closeClicks\n            …ter.handleCloseAction() }");
        DisposableKt.addTo(subscribe3, this.l);
        Disposable subscribe4 = this.k.subscribe(new a(1, contextActionsPresenter));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "confirmationDialogDismis…mationDialogDismissed() }");
        DisposableKt.addTo(subscribe4, this.l);
        contextActionsPresenter.getErrorMessageStream().observe(lifecycleOwner, new Observer<T>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView$bindPresenter$$inlined$observeNotNull$1
            public final /* synthetic */ ContextActionsView a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    ToastsKt.showToast$default(this.a.q, t, 0, 2, (Object) null);
                }
            }
        });
        contextActionsPresenter.getUrlNavigationStream().observe(lifecycleOwner, new Observer<T>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView$bindPresenter$$inlined$observeNotNull$2
            public final /* synthetic */ ContextActionsView a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    try {
                        this.a.q.startActivity(IntentsKt.makeSafeForExternalApps(ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this.a.r, t, false, 2, null)));
                    } catch (Exception e2) {
                        Logs.debug("ContextActionsView", "Unable to start activity", e2);
                        ToastsKt.showToast$default(this.a.q, com.avito.android.ui_components.R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
                    }
                }
            }
        });
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    @NotNull
    public TextView getTitleView() {
        return this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x024d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean render(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter.State r12, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.UiData r13) {
        /*
        // Method dump skipped, instructions count: 617
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView.render(com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter$State, com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter$UiData):boolean");
    }
}
