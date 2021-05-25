package com.avito.android.publish.details.adapter.objects.old;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemPresenter;", "Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemView;Lcom/avito/android/category_parameters/ParameterElement$Objects;I)V", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemResourceProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsItemPresenterImpl implements ObjectsItemPresenter {
    public final ItemDetailsParameterClickListener a;
    public final ObjectsItemResourceProvider b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ObjectsItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Objects b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ObjectsItemPresenterImpl objectsItemPresenterImpl, ParameterElement.Objects objects) {
            super(0);
            this.a = objectsItemPresenterImpl;
            this.b = objects;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onAddMoreObjectsClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ ObjectsItemView b;
        public final /* synthetic */ ObjectsItemPresenterImpl c;
        public final /* synthetic */ ParameterElement.Objects d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, ObjectsItemView objectsItemView, ObjectsItemPresenterImpl objectsItemPresenterImpl, ParameterElement.Objects objects) {
            super(0);
            this.a = i;
            this.b = objectsItemView;
            this.c = objectsItemPresenterImpl;
            this.d = objects;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.c.a.onElementObjectClicked(this.d, this.a);
            return Unit.INSTANCE;
        }
    }

    public ObjectsItemPresenterImpl(@NotNull ItemDetailsParameterClickListener itemDetailsParameterClickListener, @NotNull ObjectsItemResourceProvider objectsItemResourceProvider) {
        Intrinsics.checkNotNullParameter(itemDetailsParameterClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(objectsItemResourceProvider, "resourceProvider");
        this.a = itemDetailsParameterClickListener;
        this.b = objectsItemResourceProvider;
    }

    public void bindView(@NotNull ObjectsItemView objectsItemView, @NotNull ParameterElement.Objects objects, int i) {
        Intrinsics.checkNotNullParameter(objectsItemView, "view");
        Intrinsics.checkNotNullParameter(objects, "item");
        objectsItemView.setTitle(objects.getTitle());
        objectsItemView.setOnAddMoreClickListener(new a(this, objects));
        objectsItemView.setAddMoreButtonVisible(objects.getAddMoreVisible());
        objectsItemView.setAddMoreButtonTitle(objects.getItems().isEmpty() ^ true ? this.b.addMoreTitle() : this.b.addTitle());
        objectsItemView.clearItems();
        int i2 = 0;
        for (T t : objects.getItems()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            objectsItemView.addItem(t2.getTitle(), t2.getFirstSubtitle(), t2.getSecondSubtitle(), new b(i2, objectsItemView, this, objects));
            i2 = i3;
        }
    }
}
