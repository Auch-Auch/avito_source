package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsState;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.TextViews;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.n.x;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bj\u0010kJE\u0010\u000b\u001a\u00020\n*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJM\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0004j\u0002`\u00050\u00130\u0012*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00032\u001a\u0010\u0011\u001a\u0016\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\n*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bRK\u0010!\u001a \u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\r0\u001c*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00038V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(Rk\u00101\u001a\u001a\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050**\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00032\u001e\u0010+\u001a\u001a\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050*8V@VX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00106\u001a\u00060\u000ej\u0002`28\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR \u0010G\u001a\f\u0012\u0006\b\u0001\u0012\u00020D\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR7\u0010V\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u001c*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00038V@\u0016X\u0002¢\u0006\f\n\u0004\bT\u0010\u001e\u001a\u0004\bU\u0010 R\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR=\u0010i\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u00120\u001c*\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00038V@\u0016X\u0002¢\u0006\f\n\u0004\bg\u0010\u001e\u001a\u0004\bh\u0010 ¨\u0006l"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASConsumer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PAState;", "prevState", "curState", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diff", "", "doConsume", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsState;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "producers", "", "Ljava/lang/Class;", "doBind", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Ljava/util/Map;)Ljava/util/Set;", "doUnbind", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Visible;", "state", AuthSource.SEND_ABUSE, "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState$Visible;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "c", "Lkotlin/properties/ReadWriteProperty;", "getBoundRelay", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Lcom/jakewharton/rxrelay2/PublishRelay;", "boundRelay", "Lru/avito/component/bottom_sheet/BottomSheet;", g.a, "Lru/avito/component/bottom_sheet/BottomSheet;", "bottomSheet", "Landroidx/recyclerview/widget/RecyclerView;", "l", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", "<set-?>", AuthSource.BOOKING_ORDER, "getLastConsumedStatesByKey", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Ljava/util/Map;", "setLastConsumedStatesByKey", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;Ljava/util/Map;)V", "lastConsumedStatesByKey", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumerKey;", "Ljava/lang/Object;", "getConsumerKey", "()Ljava/lang/Object;", "consumerKey", "", "f", "F", "density", "Lcom/avito/konveyor/ItemBinder;", "r", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "titleView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "n", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroid/view/LayoutInflater;", "i", "Landroid/view/LayoutInflater;", "inflater", "Landroidx/constraintlayout/widget/ConstraintLayout;", "j", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "Landroidx/recyclerview/widget/LinearLayoutManager;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "e", "getConsumedRelay", "consumedRelay", "Landroid/view/View;", "p", "Landroid/view/View;", "rootView", "Lio/reactivex/disposables/CompositeDisposable;", "o", "Lio/reactivex/disposables/CompositeDisposable;", "subscription", "Lcom/avito/konveyor/adapter/AdapterPresenter;", VKApiConst.Q, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "bottomSheetContentView", "d", "getUnboundRelay", "unboundRelay", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SamplePlatformActionsViewImpl implements SamplePlatformActionsView {
    public static final /* synthetic */ KProperty[] s = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(SamplePlatformActionsViewImpl.class, "lastConsumedStatesByKey", "getLastConsumedStatesByKey(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Ljava/util/Map;", 0)), Reflection.property2(new PropertyReference2Impl(SamplePlatformActionsViewImpl.class, "boundRelay", "getBoundRelay(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Lcom/jakewharton/rxrelay2/PublishRelay;", 0)), Reflection.property2(new PropertyReference2Impl(SamplePlatformActionsViewImpl.class, "unboundRelay", "getUnboundRelay(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Lcom/jakewharton/rxrelay2/PublishRelay;", 0)), Reflection.property2(new PropertyReference2Impl(SamplePlatformActionsViewImpl.class, "consumedRelay", "getConsumedRelay(Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateConsumer;)Lcom/jakewharton/rxrelay2/PublishRelay;", 0))};
    @NotNull
    public final Object a = "SamplePlatformActionsView";
    @NotNull
    public final ReadWriteProperty b = new BackingField(new LinkedHashMap());
    @NotNull
    public final ReadWriteProperty c = new BackingField(PublishRelay.create());
    @NotNull
    public final ReadWriteProperty d = new BackingField(PublishRelay.create());
    @NotNull
    public final ReadWriteProperty e = new BackingField(PublishRelay.create());
    public final float f;
    public BottomSheet g;
    public ViewGroup h;
    public LayoutInflater i;
    public ConstraintLayout j;
    public TextView k;
    public RecyclerView l;
    public LinearLayoutManager m;
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> n;
    public final CompositeDisposable o;
    public final View p;
    public final AdapterPresenter q;
    public final ItemBinder r;

    public static final class a<T> implements Consumer<SamplePlatformActionsState> {
        public final /* synthetic */ PlatformActionsStateConsumer a;

        public a(PlatformActionsStateConsumer platformActionsStateConsumer) {
            this.a = platformActionsStateConsumer;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SamplePlatformActionsState samplePlatformActionsState) {
            SamplePlatformActionsState samplePlatformActionsState2 = samplePlatformActionsState;
            PlatformActionsStateConsumer platformActionsStateConsumer = this.a;
            Intrinsics.checkNotNullExpressionValue(samplePlatformActionsState2, "state");
            PlatformActionsStateConsumer.DefaultImpls.consume$default(platformActionsStateConsumer, samplePlatformActionsState2, null, 2, null);
        }
    }

    public SamplePlatformActionsViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.p = view;
        this.q = adapterPresenter;
        this.r = itemBinder;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        float f2 = resources.getDisplayMetrics().density;
        this.f = f2;
        c.roundToInt(((float) 16) * f2);
        c.roundToInt(((float) 160) * f2);
        this.o = new CompositeDisposable();
    }

    public final void a(SamplePlatformActionsState.Visible visible) {
        TextView textView = this.k;
        if (textView != null) {
            TextViews.bindText$default(textView, visible.getTitle(), false, 2, null);
        }
        this.q.onDataSourceChanged(visible.getItemsDataSource());
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter = this.n;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void bind(@NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map) {
        Intrinsics.checkNotNullParameter(map, "producers");
        SamplePlatformActionsView.DefaultImpls.bind(this, map);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void consume(@NotNull PlatformActionsState platformActionsState, @Nullable DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(platformActionsState, "state");
        SamplePlatformActionsView.DefaultImpls.consume(this, platformActionsState, diffResult);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Set<Class<? extends PlatformActionsState>> doBind(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer, @NotNull Map<Object, ? extends PlatformActionsStateProducer<?>> map) {
        Observable stateObservable;
        Observable observeOn;
        Disposable subscribe;
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$doBind");
        Intrinsics.checkNotNullParameter(map, "producers");
        if (this.o.size() == 0) {
            PlatformActionsStateProducer platformActionsStateProducer = (PlatformActionsStateProducer) map.get(SamplePlatformActionsState.KEY);
            SamplePlatformActionsStateProducer samplePlatformActionsStateProducer = null;
            if (platformActionsStateProducer != null) {
                if (!(platformActionsStateProducer instanceof SamplePlatformActionsStateProducer)) {
                    platformActionsStateProducer = null;
                }
                samplePlatformActionsStateProducer = (SamplePlatformActionsStateProducer) platformActionsStateProducer;
            }
            if (!(samplePlatformActionsStateProducer == null || (stateObservable = samplePlatformActionsStateProducer.getStateObservable()) == null || (observeOn = stateObservable.observeOn(AndroidSchedulers.mainThread())) == null || (subscribe = observeOn.subscribe(new a(platformActionsStateConsumer))) == null)) {
                DisposableKt.addTo(subscribe, this.o);
            }
        }
        return x.setOf(SamplePlatformActionsState.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r6 != null) goto L_0x0019;
     */
    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doConsume(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer<?> r5, @org.jetbrains.annotations.Nullable com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState r6, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState r7, @org.jetbrains.annotations.Nullable androidx.recyclerview.widget.DiffUtil.DiffResult r8) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsViewImpl.doConsume(com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer, com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState, com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsState, androidx.recyclerview.widget.DiffUtil$DiffResult):void");
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void doUnbind(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$doUnbind");
        this.o.clear();
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public PublishRelay<Map<Object, PlatformActionsState>> getBoundRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$boundRelay");
        return (PublishRelay) this.c.getValue(platformActionsStateConsumer, s[1]);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Observable<Map<Object, PlatformActionsState>> getBoundStream() {
        return SamplePlatformActionsView.DefaultImpls.getBoundStream(this);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public PublishRelay<PlatformActionsState> getConsumedRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$consumedRelay");
        return (PublishRelay) this.e.getValue(platformActionsStateConsumer, s[3]);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Observable<PlatformActionsState> getConsumedStream() {
        return SamplePlatformActionsView.DefaultImpls.getConsumedStream(this);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Object getConsumerKey() {
        return this.a;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Map<Object, PlatformActionsState> getLastConsumedStatesByKey(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$lastConsumedStatesByKey");
        return (Map) this.b.getValue(platformActionsStateConsumer, s[0]);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public PublishRelay<Set<Object>> getUnboundRelay(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$unboundRelay");
        return (PublishRelay) this.d.getValue(platformActionsStateConsumer, s[2]);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    @NotNull
    public Observable<Set<Object>> getUnboundStream() {
        return SamplePlatformActionsView.DefaultImpls.getUnboundStream(this);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void setLastConsumedStatesByKey(@NotNull PlatformActionsStateConsumer<?> platformActionsStateConsumer, @NotNull Map<Object, PlatformActionsState> map) {
        Intrinsics.checkNotNullParameter(platformActionsStateConsumer, "$this$lastConsumedStatesByKey");
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.b.setValue(platformActionsStateConsumer, s[0], map);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void stateConsumed(@NotNull PlatformActionsState platformActionsState) {
        Intrinsics.checkNotNullParameter(platformActionsState, "state");
        SamplePlatformActionsView.DefaultImpls.stateConsumed(this, platformActionsState);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateConsumer
    public void unbind() {
        SamplePlatformActionsView.DefaultImpls.unbind(this);
    }
}
