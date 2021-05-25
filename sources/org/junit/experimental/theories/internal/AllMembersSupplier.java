package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;
public class AllMembersSupplier extends ParameterSupplier {
    public final TestClass a;

    public static class b extends PotentialAssignment {
        public final FrameworkMethod a;

        public b(FrameworkMethod frameworkMethod, a aVar) {
            this.a = frameworkMethod;
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public String getDescription() throws PotentialAssignment.CouldNotGenerateValueException {
            return this.a.getName();
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public Object getValue() throws PotentialAssignment.CouldNotGenerateValueException {
            boolean z = false;
            try {
                return this.a.invokeExplosively(null, new Object[0]);
            } catch (IllegalArgumentException unused) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (Throwable th) {
                DataPoint dataPoint = (DataPoint) this.a.getAnnotation(DataPoint.class);
                if (dataPoint == null || !AllMembersSupplier.c(dataPoint.ignoredExceptions(), th)) {
                    z = true;
                }
                Assume.assumeTrue(z);
                throw new PotentialAssignment.CouldNotGenerateValueException(th);
            }
        }
    }

    public AllMembersSupplier(TestClass testClass) {
        this.a = testClass;
    }

    public static boolean c(Class<?>[] clsArr, Object obj) {
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    public final void a(Class<?> cls, ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        int i = 0;
        if (cls.isArray()) {
            while (i < Array.getLength(obj)) {
                Object obj2 = Array.get(obj, i);
                if (parameterSignature.canAcceptValue(obj2)) {
                    list.add(PotentialAssignment.forValue(str + "[" + i + "]", obj2));
                }
                i++;
            }
        } else if (Iterable.class.isAssignableFrom(cls)) {
            for (Object obj3 : (Iterable) obj) {
                if (parameterSignature.canAcceptValue(obj3)) {
                    list.add(PotentialAssignment.forValue(str + "[" + i + "]", obj3));
                }
                i++;
            }
        }
    }

    public final Object b(Field field) {
        try {
            return field.get(null);
        } catch (IllegalArgumentException unused) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        }
    }

    public Collection<Field> getDataPointsFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.a.getAnnotatedFields(DataPoints.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField frameworkField : annotatedFields) {
            arrayList.add(frameworkField.getField());
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature parameterSignature) {
        return this.a.getAnnotatedMethods(DataPoints.class);
    }

    public Collection<Field> getSingleDataPointFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.a.getAnnotatedFields(DataPoint.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField frameworkField : annotatedFields) {
            arrayList.add(frameworkField.getField());
        }
        return arrayList;
    }

    public Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature parameterSignature) {
        return this.a.getAnnotatedMethods(DataPoint.class);
    }

    @Override // org.junit.experimental.theories.ParameterSupplier
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) throws Throwable {
        ArrayList arrayList = new ArrayList();
        for (Field field : getSingleDataPointFields(parameterSignature)) {
            Object b2 = b(field);
            if (parameterSignature.canAcceptValue(b2)) {
                arrayList.add(PotentialAssignment.forValue(field.getName(), b2));
            }
        }
        for (Field field2 : getDataPointsFields(parameterSignature)) {
            a(field2.getType(), parameterSignature, field2.getName(), arrayList, b(field2));
        }
        for (FrameworkMethod frameworkMethod : getSingleDataPointMethods(parameterSignature)) {
            if (parameterSignature.canAcceptType(frameworkMethod.getType())) {
                arrayList.add(new b(frameworkMethod, null));
            }
        }
        for (FrameworkMethod frameworkMethod2 : getDataPointsMethods(parameterSignature)) {
            Class<?> returnType = frameworkMethod2.getReturnType();
            if ((returnType.isArray() && parameterSignature.canPotentiallyAcceptType(returnType.getComponentType())) || Iterable.class.isAssignableFrom(returnType)) {
                try {
                    a(returnType, parameterSignature, frameworkMethod2.getName(), arrayList, frameworkMethod2.invokeExplosively(null, new Object[0]));
                } catch (Throwable th) {
                    DataPoints dataPoints = (DataPoints) frameworkMethod2.getAnnotation(DataPoints.class);
                    if (dataPoints == null || !c(dataPoints.ignoredExceptions(), th)) {
                        throw th;
                    }
                }
            }
        }
        return arrayList;
    }
}
