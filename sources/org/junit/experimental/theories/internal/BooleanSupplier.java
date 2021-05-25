package org.junit.experimental.theories.internal;

import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
public class BooleanSupplier extends ParameterSupplier {
    @Override // org.junit.experimental.theories.ParameterSupplier
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        return Arrays.asList(PotentialAssignment.forValue(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, Boolean.TRUE), PotentialAssignment.forValue("false", Boolean.FALSE));
    }
}
