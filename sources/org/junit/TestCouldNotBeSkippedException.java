package org.junit;

import org.junit.internal.AssumptionViolatedException;
public class TestCouldNotBeSkippedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public TestCouldNotBeSkippedException(AssumptionViolatedException assumptionViolatedException) {
        super("Test could not be skipped due to other failures", assumptionViolatedException);
    }
}
