package org.junit.experimental.theories.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.TestClass;
public class Assignments {
    public final List<PotentialAssignment> a;
    public final List<ParameterSignature> b;
    public final TestClass c;

    public Assignments(List<PotentialAssignment> list, List<ParameterSignature> list2, TestClass testClass) {
        this.b = list2;
        this.a = list;
        this.c = testClass;
    }

    public static Assignments allUnassigned(Method method, TestClass testClass) {
        List<ParameterSignature> signatures = ParameterSignature.signatures(testClass.getOnlyConstructor());
        signatures.addAll(ParameterSignature.signatures(method));
        return new Assignments(new ArrayList(), signatures, testClass);
    }

    public Assignments assignNext(PotentialAssignment potentialAssignment) {
        ArrayList arrayList = new ArrayList(this.a);
        arrayList.add(potentialAssignment);
        List<ParameterSignature> list = this.b;
        return new Assignments(arrayList, list.subList(1, list.size()), this.c);
    }

    public Object[] getActualValues(int i, int i2) throws PotentialAssignment.CouldNotGenerateValueException {
        Object[] objArr = new Object[(i2 - i)];
        for (int i3 = i; i3 < i2; i3++) {
            objArr[i3 - i] = this.a.get(i3).getValue();
        }
        return objArr;
    }

    public Object[] getAllArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, this.a.size());
    }

    public Object[] getArgumentStrings(boolean z) throws PotentialAssignment.CouldNotGenerateValueException {
        int size = this.a.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = this.a.get(i).getDescription();
        }
        return objArr;
    }

    public Object[] getConstructorArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(0, ParameterSignature.signatures(this.c.getOnlyConstructor()).size());
    }

    public Object[] getMethodArguments() throws PotentialAssignment.CouldNotGenerateValueException {
        return getActualValues(ParameterSignature.signatures(this.c.getOnlyConstructor()).size(), this.a.size());
    }

    public boolean isComplete() {
        return this.b.isEmpty();
    }

    public ParameterSignature nextUnassigned() {
        return this.b.get(0);
    }

    public List<PotentialAssignment> potentialsForNextUnassigned() throws Throwable {
        ParameterSupplier parameterSupplier;
        List<PotentialAssignment> valueSources;
        ParameterSignature nextUnassigned = nextUnassigned();
        ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) nextUnassigned.findDeepAnnotation(ParametersSuppliedBy.class);
        if (parametersSuppliedBy != null) {
            Class<? extends ParameterSupplier> value = parametersSuppliedBy.value();
            Constructor<?>[] constructors = value.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    parameterSupplier = (ParameterSupplier) value.newInstance();
                    break;
                }
                Constructor<?> constructor = constructors[i];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(TestClass.class)) {
                    parameterSupplier = (ParameterSupplier) constructor.newInstance(this.c);
                    break;
                }
                i++;
            }
        } else {
            parameterSupplier = new AllMembersSupplier(this.c);
        }
        List<PotentialAssignment> valueSources2 = parameterSupplier.getValueSources(nextUnassigned);
        if (!valueSources2.isEmpty()) {
            return valueSources2;
        }
        Class<?> type = nextUnassigned.getType();
        if (type.isEnum()) {
            valueSources = new EnumSupplier(type).getValueSources(nextUnassigned);
        } else if (type.equals(Boolean.class) || type.equals(Boolean.TYPE)) {
            valueSources = new BooleanSupplier().getValueSources(nextUnassigned);
        } else {
            valueSources = Collections.emptyList();
        }
        return valueSources;
    }
}
