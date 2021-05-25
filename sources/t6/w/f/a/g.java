package t6.w.f.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KPropertyImplKt;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
public final class g extends Lambda implements Function1<Field, CallerImpl<? extends Field>> {
    public final /* synthetic */ KPropertyImpl.Accessor a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ f c;
    public final /* synthetic */ e d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(KPropertyImpl.Accessor accessor, boolean z, f fVar, e eVar) {
        super(1);
        this.a = accessor;
        this.b = z;
        this.c = fVar;
        this.d = eVar;
    }

    @NotNull
    /* renamed from: a */
    public final CallerImpl<Field> invoke(@NotNull Field field) {
        Intrinsics.checkNotNullParameter(field, AnalyticFieldsName.field);
        if (KPropertyImplKt.access$isJvmFieldPropertyInCompanionObject(this.a.getProperty().getDescriptor()) || !Modifier.isStatic(field.getModifiers())) {
            if (this.b) {
                if (this.a.isBound()) {
                    return new CallerImpl.FieldGetter.BoundInstance(field, KPropertyImplKt.getBoundReceiver(this.a));
                }
                return new CallerImpl.FieldGetter.Instance(field);
            } else if (this.a.isBound()) {
                return new CallerImpl.FieldSetter.BoundInstance(field, this.c.invoke(), KPropertyImplKt.getBoundReceiver(this.a));
            } else {
                return new CallerImpl.FieldSetter.Instance(field, this.c.invoke());
            }
        } else if (this.d.invoke()) {
            if (this.b) {
                if (this.a.isBound()) {
                    return new CallerImpl.FieldGetter.BoundJvmStaticInObject(field);
                }
                return new CallerImpl.FieldGetter.JvmStaticInObject(field);
            } else if (this.a.isBound()) {
                return new CallerImpl.FieldSetter.BoundJvmStaticInObject(field, this.c.invoke());
            } else {
                return new CallerImpl.FieldSetter.JvmStaticInObject(field, this.c.invoke());
            }
        } else if (this.b) {
            return new CallerImpl.FieldGetter.Static(field);
        } else {
            return new CallerImpl.FieldSetter.Static(field, this.c.invoke());
        }
    }
}
