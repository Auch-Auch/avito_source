package org.junit.experimental.theories.internal;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
public class EnumSupplier extends ParameterSupplier {
    public Class<?> a;

    public EnumSupplier(Class<?> cls) {
        this.a = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.experimental.theories.ParameterSupplier
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        Object[] enumConstants = this.a.getEnumConstants();
        ArrayList arrayList = new ArrayList();
        for (Object[] objArr : enumConstants) {
            arrayList.add(PotentialAssignment.forValue(objArr.toString(), objArr));
        }
        return arrayList;
    }
}
