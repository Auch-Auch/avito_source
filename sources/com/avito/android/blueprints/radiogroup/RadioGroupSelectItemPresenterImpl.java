package com.avito.android.blueprints.radiogroup;

import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RadioSelectItemChangePayload;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eR:\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenterImpl;", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", "", "", "payloads", "(Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;ILjava/util/List;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/blueprints/SelectedInfo;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "itemSelectedRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getItemSelectedObservable", "()Lio/reactivex/Observable;", "itemSelectedObservable", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupSelectItemPresenterImpl implements RadioGroupSelectItemPresenter {
    public final PublishRelay<SelectedInfo> a;
    @NotNull
    public final Observable<SelectedInfo> b;

    public static final class a extends Lambda implements Function2<String, Boolean, Unit> {
        public final /* synthetic */ RadioGroupSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RadioGroupSelectItemPresenterImpl radioGroupSelectItemPresenterImpl, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = radioGroupSelectItemPresenterImpl;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Boolean bool) {
            T t;
            String str2 = str;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(str2, "selectableItemId");
            if (booleanValue) {
                Iterator<T> it = this.b.getValues().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getStringId(), str2)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    this.a.a.accept(new SelectedInfo(this.b.getStringId(), t2));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<String, Boolean, Unit> {
        public final /* synthetic */ RadioGroupSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(RadioGroupSelectItemPresenterImpl radioGroupSelectItemPresenterImpl, RadioSelectItemChangePayload radioSelectItemChangePayload, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = radioGroupSelectItemPresenterImpl;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Boolean bool) {
            T t;
            String str2 = str;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(str2, "selectableItemId");
            if (booleanValue) {
                Iterator<T> it = this.b.getValues().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getStringId(), str2)) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    this.a.a.accept(new SelectedInfo(this.b.getStringId(), t2));
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public RadioGroupSelectItemPresenterImpl() {
        PublishRelay<SelectedInfo> create = PublishRelay.create();
        this.a = create;
        Observable<SelectedInfo> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "itemSelectedRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter
    @NotNull
    public Observable<SelectedInfo> getItemSelectedObservable() {
        return this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(RadioGroupSelectItemView radioGroupSelectItemView, ParameterElement.Select.Flat flat, int i, List list) {
        bindView(radioGroupSelectItemView, flat, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull RadioGroupSelectItemView radioGroupSelectItemView, @NotNull ParameterElement.Select.Flat flat, int i) {
        Intrinsics.checkNotNullParameter(radioGroupSelectItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        radioGroupSelectItemView.setTitle(flat.getHideTitle() ? "" : flat.getTitle());
        radioGroupSelectItemView.setTag(flat.getTitle());
        ItemWithState.State state = flat.getState();
        if (state instanceof ItemWithState.State.Error) {
            radioGroupSelectItemView.setError(((ItemWithState.State.Error) state).getMessage().toString());
        } else {
            radioGroupSelectItemView.setError(null);
        }
        radioGroupSelectItemView.setValues(flat.getValues(), flat.getSelectedValue(), new a(this, flat));
    }

    public void bindView(@NotNull RadioGroupSelectItemView radioGroupSelectItemView, @NotNull ParameterElement.Select.Flat flat, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(radioGroupSelectItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof RadioSelectItemChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(radioGroupSelectItemView, flat, i);
            return;
        }
        ItemWithState.State state = t3.getState();
        if (state != null) {
            if (state instanceof ItemWithState.State.Error) {
                radioGroupSelectItemView.setError(((ItemWithState.State.Error) state).getMessage().toString());
            } else {
                radioGroupSelectItemView.setError(null);
            }
        }
        SelectableItem selectedItem = t3.getSelectedItem();
        if (selectedItem != null) {
            radioGroupSelectItemView.setSelectedIndex(flat.getValues().indexOf(selectedItem));
        }
        radioGroupSelectItemView.setCheckChangeListener(new b(this, t3, flat));
    }
}
