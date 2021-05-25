package com.avito.android.beduin.core.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.beduin.core.form.ComponentsFormTransform;
import com.avito.android.beduin.core.form.ComponentsFormUpdate;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t*\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\f\u0010\rR<\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0016@RX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0004\u0018\u0001`\u00168\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0016\u0010\"\u001a\u00020!8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormImpl;", "Lcom/avito/android/beduin/core/form/ComponentsForm;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "formTransform", "", "apply", "(Lcom/avito/android/beduin/core/form/ComponentsFormTransform;)V", "", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/Map;", "<set-?>", "c", "Ljava/util/Map;", "getParameters", "()Ljava/util/Map;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lkotlin/Function1;", "Lcom/avito/android/beduin/core/form/ComponentsFormUpdate;", "Lcom/avito/android/beduin/core/form/FormUpdateHandler;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getOnFormUpdate", "()Lkotlin/jvm/functions/Function1;", "setOnFormUpdate", "(Lkotlin/jvm/functions/Function1;)V", "onFormUpdate", "", "Ljava/util/List;", "models", "", "isValid", "()Z", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class ComponentsFormImpl implements ComponentsForm {
    public final List<BeduinModel> a = new ArrayList();
    @Nullable
    public Function1<? super ComponentsFormUpdate, Unit> b;
    @NotNull
    public Map<String, ? extends Object> c = r.emptyMap();

    public final Map<String, Object> a(List<? extends BeduinModel> list) {
        Map<String, Object> emptyMap = r.emptyMap();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            emptyMap = r.plus(emptyMap, it.next().getParameters());
        }
        return emptyMap;
    }

    @Override // com.avito.android.beduin.core.form.ComponentsForm
    public void apply(@NotNull ComponentsFormTransform componentsFormTransform) {
        Intrinsics.checkNotNullParameter(componentsFormTransform, "formTransform");
        if (componentsFormTransform instanceof ComponentsFormTransform.Set) {
            List<BeduinModel> models = ((ComponentsFormTransform.Set) componentsFormTransform).getModels();
            this.a.clear();
            this.a.addAll(models);
            this.c = a(models);
            Function1<ComponentsFormUpdate, Unit> onFormUpdate = getOnFormUpdate();
            if (onFormUpdate != null) {
                onFormUpdate.invoke(new ComponentsFormUpdate.Form(models));
            }
        } else if (componentsFormTransform instanceof ComponentsFormTransform.Replace) {
            ComponentsFormTransform.Replace replace = (ComponentsFormTransform.Replace) componentsFormTransform;
            BeduinModel oldModel = replace.getOldModel();
            BeduinModel newModel = replace.getNewModel();
            if (!Intrinsics.areEqual(oldModel, newModel)) {
                int i = 0;
                Iterator<BeduinModel> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (Intrinsics.areEqual(it.next(), oldModel)) {
                        break;
                    } else {
                        i++;
                    }
                }
                this.a.set(i, newModel);
                this.c = r.plus(r.minus((Map) getParameters(), (Iterable) oldModel.getParameters().keySet()), newModel.getParameters());
                Function1<ComponentsFormUpdate, Unit> onFormUpdate2 = getOnFormUpdate();
                if (onFormUpdate2 != null) {
                    onFormUpdate2.invoke(new ComponentsFormUpdate.Component(i, newModel));
                }
            }
        } else if (componentsFormTransform instanceof ComponentsFormTransform.Apply) {
            Map<String, List<BeduinModelTransform>> modelsTransforms = ((ComponentsFormTransform.Apply) componentsFormTransform).getModelsTransforms();
            this.a.clear();
            List<BeduinModel> list = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                List<BeduinModelTransform> list2 = modelsTransforms.get(t.getId());
                if (list2 != null) {
                    Iterator<T> it2 = list2.iterator();
                    T t2 = t;
                    while (it2.hasNext()) {
                        t2 = t2.apply(it2.next());
                    }
                    if (t2 != null) {
                        t = t2;
                    }
                }
                arrayList.add(t);
            }
            this.a.addAll(arrayList);
            this.c = a(this.a);
            Function1<ComponentsFormUpdate, Unit> onFormUpdate3 = getOnFormUpdate();
            if (onFormUpdate3 != null) {
                onFormUpdate3.invoke(new ComponentsFormUpdate.Form(this.a));
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.avito.android.beduin.core.form.ComponentsFormUpdate, kotlin.Unit>, kotlin.jvm.functions.Function1<com.avito.android.beduin.core.form.ComponentsFormUpdate, kotlin.Unit> */
    @Override // com.avito.android.beduin.core.form.ComponentsForm
    @Nullable
    public Function1<ComponentsFormUpdate, Unit> getOnFormUpdate() {
        return this.b;
    }

    @Override // com.avito.android.beduin.core.form.ComponentsForm
    @NotNull
    public Map<String, Object> getParameters() {
        return this.c;
    }

    @Override // com.avito.android.beduin.core.form.ComponentsForm
    public boolean isValid() {
        List<BeduinModel> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.avito.android.beduin.core.form.ComponentsForm
    public void setOnFormUpdate(@Nullable Function1<? super ComponentsFormUpdate, Unit> function1) {
        this.b = function1;
    }
}
