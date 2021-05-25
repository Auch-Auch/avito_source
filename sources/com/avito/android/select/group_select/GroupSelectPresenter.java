package com.avito.android.select.group_select;

import a2.a.a.m2.l.c;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.group_select.models.SelectableGroup;
import com.avito.android.select.group_select.models.SelectableOption;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001f\u0010\u0010J_\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017RD\u0010\u001e\u001a0\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00070\u0007 \u001a*\u0017\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u0019¢\u0006\u0002\b\u001b0\u0019¢\u0006\u0002\b\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectPresenter;", "", "Lcom/avito/android/select/group_select/GroupSelectView;", "view", "", "Lcom/avito/android/select/group_select/models/SelectableGroup;", "groups", "", "areGroupsCollapsible", "Lkotlin/Function1;", "", "applyListener", "hasSelectionListener", "bindView", "(Lcom/avito/android/select/group_select/GroupSelectView;Ljava/util/List;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "unbind", "()V", "", "c", "I", "selectedCounter", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "<init>", "select_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectPresenter {
    public Disposable a;
    public final PublishRelay<Boolean> b = PublishRelay.create();
    public int c;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Function1 function1 = this.a;
            if (function1 != null) {
                Intrinsics.checkNotNullExpressionValue(bool2, "hasSelected");
                Unit unit = (Unit) function1.invoke(bool2);
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1, List list) {
            super(0);
            this.a = function1;
            this.b = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final void access$updateSelectionState(GroupSelectPresenter groupSelectPresenter) {
        groupSelectPresenter.b.accept(Boolean.valueOf(groupSelectPresenter.c > 0));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.select.group_select.GroupSelectPresenter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bindView$default(GroupSelectPresenter groupSelectPresenter, GroupSelectView groupSelectView, List list, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 16) != 0) {
            function12 = null;
        }
        groupSelectPresenter.bindView(groupSelectView, list, z2, function1, function12);
    }

    public final void bindView(@NotNull GroupSelectView groupSelectView, @NotNull List<SelectableGroup> list, boolean z, @NotNull Function1<? super List<SelectableGroup>, Unit> function1, @Nullable Function1<? super Boolean, Unit> function12) {
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(groupSelectView, "view");
        Intrinsics.checkNotNullParameter(list, "groups");
        Intrinsics.checkNotNullParameter(function1, "applyListener");
        this.a = this.b.distinctUntilChanged().subscribe(new a(function12));
        Iterator<T> it = list.iterator();
        while (true) {
            z2 = true;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            List<SelectableOption> items = next.getItems();
            int i2 = this.c;
            if (!(items instanceof Collection) || !items.isEmpty()) {
                Iterator<T> it2 = items.iterator();
                i = 0;
                while (it2.hasNext()) {
                    if (it2.next().isSelected() && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
            this.c = i2 + i;
            if (next.getItems().size() > 1) {
                groupSelectView.addSelectGroup(new GroupSelectItemViewPresenter(next, new a2.a.a.m2.l.b(this), z));
            } else if (next.getItems().size() == 1) {
                SelectableOption selectableOption = next.getItems().get(0);
                groupSelectView.addSelectOption(selectableOption.getTitle(), selectableOption.isSelected(), new c(this, selectableOption));
            }
        }
        PublishRelay<Boolean> publishRelay = this.b;
        if (this.c <= 0) {
            z2 = false;
        }
        publishRelay.accept(Boolean.valueOf(z2));
        groupSelectView.setApplyListener(new b(function1, list));
    }

    public final void unbind() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = 0;
    }
}
