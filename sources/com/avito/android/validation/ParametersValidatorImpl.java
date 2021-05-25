package com.avito.android.validation;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.avito.android.remote.model.category_parameters.ConstraintKt;
import com.avito.android.remote.model.category_parameters.DependentConstraint;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.RangeParameter;
import com.avito.android.remote.model.category_parameters.TextParameterDisplayingType;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasConstraints;
import com.avito.android.remote.model.category_parameters.base.HasHtmlValueSupport;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.Collections;
import com.avito.android.validation.ValidationResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u0001:\u0001DB'\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u00108\u001a\u000206\u0012\u0006\u0010;\u001a\u000209\u0012\u0006\u0010A\u001a\u00020?¢\u0006\u0004\bB\u0010CJ\u001f\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0012\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u0010*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0 \"\u0004\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\"J3\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\f*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010#\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0$H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b(\u0010)J=\u0010.\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\r2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0 H\u0002¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J#\u00103\u001a\u00020\u00052\n\u00102\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b3\u0010\u0007J)\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\n\u00102\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b4\u00105R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u00107R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010@¨\u0006E"}, d2 = {"Lcom/avito/android/validation/ParametersValidatorImpl;", "Lcom/avito/android/validation/ParametersValidator;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/validation/ValidationResult;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/validation/ValidationResult;", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "", "i", "(Lcom/avito/android/remote/model/category_parameters/CharParameter;)Ljava/lang/String;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "constraints", "Lkotlin/Function1;", "", "predicate", "k", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/ParametersTree;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/validation/ValidationResult;", "", "", AuthSource.SEND_ABUSE, "(Ljava/lang/Double;)Ljava/lang/Long;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "value", "f", "(Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;Ljava/lang/Long;)Z", "T", g.a, "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Z", "errorText", "", "j", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/lang/String;)Ljava/util/Map;", "params", "", "visitedIds", "d", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/ParametersTree;Ljava/util/Set;)Ljava/util/List;", "h", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Ljava/util/List;", "id", "title", "constraint", "fieldMessages", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/Constraint;Ljava/util/Map;)Lcom/avito/android/validation/ValidationResult;", "e", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "validate", "validateWithDependentParameters", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/List;", "Lcom/avito/android/Features;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlRenderer;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "<init>", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)V", "Companion", "validation_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersValidatorImpl implements ParametersValidator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final HtmlRenderOptions e = new HtmlRenderOptions(0, 0, 0, "—", false, 16, null);
    public final ParametersValidatorResourceProvider a;
    public final Features b;
    public final HtmlRenderer c;
    public final HtmlCleaner d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/validation/ParametersValidatorImpl$Companion;", "", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "HTML_RENDER_OPTIONS_FOR_VALIDATION", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "getHTML_RENDER_OPTIONS_FOR_VALIDATION", "()Lcom/avito/android/html_formatter/HtmlRenderOptions;", "<init>", "()V", "validation_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final HtmlRenderOptions getHTML_RENDER_OPTIONS_FOR_VALIDATION() {
            return ParametersValidatorImpl.e;
        }

        public Companion(j jVar) {
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Constraint, Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Constraint constraint) {
            int i = this.a;
            boolean z = true;
            if (i == 0) {
                Constraint constraint2 = constraint;
                Intrinsics.checkNotNullParameter(constraint2, "it");
                if (!Intrinsics.areEqual(constraint2.getSeverity(), "error") && constraint2.getSeverity() != null) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else if (i == 1) {
                Constraint constraint3 = constraint;
                Intrinsics.checkNotNullParameter(constraint3, "it");
                return Boolean.valueOf(Intrinsics.areEqual(constraint3.getSeverity(), ConstraintKt.WARNING_ON_FLOW_FINISH));
            } else if (i == 2) {
                Constraint constraint4 = constraint;
                Intrinsics.checkNotNullParameter(constraint4, "it");
                return Boolean.valueOf(Intrinsics.areEqual(constraint4.getSeverity(), "warning"));
            } else {
                throw null;
            }
        }
    }

    public ParametersValidatorImpl(@NotNull ParametersValidatorResourceProvider parametersValidatorResourceProvider, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner) {
        Intrinsics.checkNotNullParameter(parametersValidatorResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        this.a = parametersValidatorResourceProvider;
        this.b = features;
        this.c = htmlRenderer;
        this.d = htmlCleaner;
    }

    public final Long a(Double d2) {
        if (d2 == null) {
            return null;
        }
        d2.doubleValue();
        return Long.valueOf((long) (Math.ceil(Math.abs(d2.doubleValue())) * Math.signum(d2.doubleValue())));
    }

    public final ValidationResult b(EditableParameter<?> editableParameter, ParametersTree parametersTree) {
        boolean z;
        boolean z2;
        if (editableParameter instanceof HasHtmlValueSupport) {
            HasHtmlValueSupport hasHtmlValueSupport = (HasHtmlValueSupport) editableParameter;
            DisplayingOptions displayingOptions = hasHtmlValueSupport.getDisplayingOptions();
            String str = null;
            if (Intrinsics.areEqual(displayingOptions != null ? displayingOptions.getType() : null, TextParameterDisplayingType.TYPE_HTML_EDITOR)) {
                Object value = editableParameter.getValue();
                if (!(value instanceof String)) {
                    value = null;
                }
                String str2 = (String) value;
                if (str2 != null) {
                    str = String.valueOf(this.c.fromHtml(this.d.cleanHtml(str2), e));
                }
                hasHtmlValueSupport.setRenderedHtmlValue(str);
            }
        }
        boolean z3 = false;
        if (editableParameter.getRequired() && !editableParameter.hasValue()) {
            if (editableParameter instanceof PhotoParameter) {
                List<Constraint> h = h(editableParameter);
                if (h != null) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : h) {
                        if (t instanceof Constraint.Limit) {
                            arrayList.add(t);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Constraint.Limit limit = (Constraint.Limit) it.next();
                            if (limit.getSeverity() == null || Intrinsics.areEqual(limit.getSeverity(), "error")) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                    z3 = true;
                }
            }
            if (!z3) {
                String emptyRequiredParameterErrorMessage = this.a.emptyRequiredParameterErrorMessage(editableParameter);
                return new ValidationResult.Failure.Error(editableParameter.getId(), editableParameter.getTitle(), emptyRequiredParameterErrorMessage, null, j(editableParameter, emptyRequiredParameterErrorMessage), 8, null);
            }
        }
        List<Constraint> h2 = h(editableParameter);
        if (h2 == null) {
            return new ValidationResult.Success(editableParameter.getId());
        }
        ValidationResult k = k(editableParameter, h2, parametersTree, a.b);
        if (k == null) {
            k = k(editableParameter, h2, parametersTree, a.c);
        }
        if (k == null) {
            k = k(editableParameter, h2, parametersTree, a.d);
        }
        return k != null ? k : new ValidationResult.Success(editableParameter.getId());
    }

    public final ValidationResult c(String str, String str2, Constraint constraint, Map<String, String> map) {
        String str3;
        String str4;
        String str5;
        if (constraint.getSeverity() == null || Intrinsics.areEqual(constraint.getSeverity(), "error")) {
            String message = constraint.getMessage();
            if (message != null) {
                str5 = message;
            } else {
                str5 = "";
            }
            return new ValidationResult.Failure.Error(str, str2, str5, constraint.getTag(), map);
        } else if (Intrinsics.areEqual(constraint.getSeverity(), ConstraintKt.WARNING_ON_FLOW_FINISH)) {
            String message2 = constraint.getMessage();
            if (message2 != null) {
                str4 = message2;
            } else {
                str4 = "";
            }
            return new ValidationResult.Failure.WarningOnFlowFinish(str, str2, str4, constraint.getTag(), map);
        } else if (!Intrinsics.areEqual(constraint.getSeverity(), "warning")) {
            return new ValidationResult.Success(str);
        } else {
            String message3 = constraint.getMessage();
            if (message3 != null) {
                str3 = message3;
            } else {
                str3 = "";
            }
            return new ValidationResult.Failure.Warning(str, str2, str3, constraint.getTag(), map);
        }
    }

    public final List<ValidationResult> d(EditableParameter<?> editableParameter, ParametersTree parametersTree, Set<String> set) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        List<Constraint> h = h(editableParameter);
        if (h != null) {
            arrayList = new ArrayList();
            for (T t : h) {
                if (t instanceof DependentConstraint) {
                    arrayList.add(t);
                }
            }
        } else {
            arrayList = null;
        }
        if (Collections.isNullOrEmpty(arrayList)) {
            return d.listOf(b(editableParameter, parametersTree));
        }
        Intrinsics.checkNotNull(arrayList);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(arrayList);
        ValidationResult b2 = b(editableParameter, parametersTree);
        set.add(editableParameter.getId());
        arrayList2.add(b2);
        while (!linkedList.isEmpty()) {
            DependentConstraint dependentConstraint = (DependentConstraint) linkedList.remove();
            if (!set.contains(dependentConstraint.getDependentId())) {
                arrayList2.addAll(d(e(dependentConstraint.getDependentId(), parametersTree), parametersTree, set));
            }
        }
        return arrayList2;
    }

    public final EditableParameter<?> e(String str, ParametersTree parametersTree) {
        ParameterSlot findParameter = parametersTree.findParameter(str);
        if (!(findParameter instanceof EditableParameter)) {
            findParameter = null;
        }
        EditableParameter<?> editableParameter = (EditableParameter) findParameter;
        if (editableParameter != null) {
            return editableParameter;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.e3("Parameter with ", str, " is not present in the list"));
    }

    public final boolean f(Constraint.Limit limit, Long l) {
        if (l == null) {
            return false;
        }
        Long min = limit.getMin();
        Long max = limit.getMax();
        if (min != null && l.longValue() < min.longValue()) {
            return false;
        }
        if (max == null || l.longValue() <= max.longValue()) {
            return true;
        }
        return false;
    }

    public final <T> boolean g(EditableParameter<T> editableParameter) {
        if (editableParameter instanceof RangeParameter) {
            RangeParameter rangeParameter = (RangeParameter) editableParameter;
            RangeParameter.RangeValue rangeValue = (RangeParameter.RangeValue) rangeParameter.getValue();
            Double d2 = null;
            if ((rangeValue != null ? rangeValue.getFrom() : null) != null) {
                RangeParameter.RangeValue rangeValue2 = (RangeParameter.RangeValue) rangeParameter.getValue();
                if (rangeValue2 != null) {
                    d2 = rangeValue2.getTo();
                }
                if (d2 != null) {
                    Object value = rangeParameter.getValue();
                    Intrinsics.checkNotNull(value);
                    Double from = ((RangeParameter.RangeValue) value).getFrom();
                    Intrinsics.checkNotNull(from);
                    double doubleValue = from.doubleValue();
                    Object value2 = rangeParameter.getValue();
                    Intrinsics.checkNotNull(value2);
                    Double to = ((RangeParameter.RangeValue) value2).getTo();
                    Intrinsics.checkNotNull(to);
                    if (doubleValue > to.doubleValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final List<Constraint> h(EditableParameter<?> editableParameter) {
        if (!(editableParameter instanceof HasConstraints)) {
            editableParameter = null;
        }
        HasConstraints hasConstraints = (HasConstraints) editableParameter;
        if (hasConstraints != null) {
            return hasConstraints.getConstraints();
        }
        return null;
    }

    public final String i(CharParameter charParameter) {
        DisplayingOptions displayingOptions = charParameter.getDisplayingOptions();
        if (Intrinsics.areEqual(displayingOptions != null ? displayingOptions.getType() : null, TextParameterDisplayingType.TYPE_HTML_EDITOR)) {
            return charParameter.getRenderedHtmlValue();
        }
        return (String) charParameter.getValue();
    }

    public final <T> Map<String, String> j(EditableParameter<T> editableParameter, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if ((editableParameter instanceof RangeParameter) && editableParameter.getRequired()) {
            RangeParameter rangeParameter = (RangeParameter) editableParameter;
            RangeParameter.RangeValue rangeValue = (RangeParameter.RangeValue) rangeParameter.getValue();
            Double d2 = null;
            if ((rangeValue != null ? rangeValue.getFrom() : null) == null) {
                linkedHashMap.put("from", str);
            }
            RangeParameter.RangeValue rangeValue2 = (RangeParameter.RangeValue) rangeParameter.getValue();
            if (rangeValue2 != null) {
                d2 = rangeValue2.getTo();
            }
            if (d2 == null) {
                linkedHashMap.put("to", str);
            }
        }
        return r.toMap(linkedHashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020c, code lost:
        if (((long) r5) < r6.longValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0217, code lost:
        if (((long) r5) > r3.longValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x029b, code lost:
        if (r3.matcher(r5).find() == false) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02cc, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(r12.getValue(), r3.getValue())) == false) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02fb, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r12.getValue(), r3.getValue()) == false) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0157, code lost:
        if (r6 < r5.doubleValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0161, code lost:
        if (r6 > r3.doubleValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x019a, code lost:
        if (f(r3, a(r5.getTo())) != false) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b5, code lost:
        if (r5.longValue() < r6.longValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c3, code lost:
        if (r5.longValue() > r3.longValue()) goto L_0x02fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0082 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x002f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x030d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.validation.ValidationResult k(com.avito.android.remote.model.category_parameters.base.EditableParameter<?> r12, java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> r13, com.avito.android.remote.model.category_parameters.ParametersTree r14, kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.category_parameters.Constraint, java.lang.Boolean> r15) {
        /*
        // Method dump skipped, instructions count: 1040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.validation.ParametersValidatorImpl.k(com.avito.android.remote.model.category_parameters.base.EditableParameter, java.util.List, com.avito.android.remote.model.category_parameters.ParametersTree, kotlin.jvm.functions.Function1):com.avito.android.validation.ValidationResult");
    }

    @Override // com.avito.android.validation.ParametersValidator
    @NotNull
    public ValidationResult validate(@NotNull EditableParameter<?> editableParameter, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(editableParameter, "parameter");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return b(editableParameter, parametersTree);
    }

    @Override // com.avito.android.validation.ParametersValidator
    @NotNull
    public List<ValidationResult> validateWithDependentParameters(@NotNull EditableParameter<?> editableParameter, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(editableParameter, "parameter");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return d(editableParameter, parametersTree, new LinkedHashSet());
    }
}
