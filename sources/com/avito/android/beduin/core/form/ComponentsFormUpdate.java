package com.avito.android.beduin.core.form;

import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "", "<init>", "()V", "Component", "Form", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate$Form;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate$Component;", "beduin_release"}, k = 1, mv = {1, 4, 2})
public abstract class ComponentsFormUpdate {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormUpdate$Component;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "", AuthSource.SEND_ABUSE, "I", "getIndex", "()I", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "getModel", "()Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "(ILcom/avito/android/beduin/core/model/container/component/BeduinModel;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Component extends ComponentsFormUpdate {
        public final int a;
        @NotNull
        public final BeduinModel b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Component(int i, @NotNull BeduinModel beduinModel) {
            super(null);
            Intrinsics.checkNotNullParameter(beduinModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
            this.a = i;
            this.b = beduinModel;
        }

        public final int getIndex() {
            return this.a;
        }

        @NotNull
        public final BeduinModel getModel() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormUpdate$Form;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getModels", "()Ljava/util/List;", "models", "<init>", "(Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Form extends ComponentsFormUpdate {
        @NotNull
        public final List<BeduinModel> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Form(@NotNull List<? extends BeduinModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "models");
            this.a = list;
        }

        @NotNull
        public final List<BeduinModel> getModels() {
            return this.a;
        }
    }

    public ComponentsFormUpdate() {
    }

    public ComponentsFormUpdate(j jVar) {
    }
}
