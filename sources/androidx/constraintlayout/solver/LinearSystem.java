package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.Objects;
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static int n = 1000;
    public static Metrics sMetrics;
    public int a;
    public a b;
    public int c;
    public int d;
    public ArrayRow[] e;
    public boolean[] f;
    public int g;
    public boolean graphOptimizer;
    public int h;
    public boolean hasSimpleDefinition;
    public int i;
    public final Cache j;
    public SolverVariable[] k;
    public int l;
    public a m;
    public boolean newgraphOptimizer;

    public interface a {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(a aVar);

        boolean isEmpty();
    }

    public class b extends ArrayRow {
        public b(LinearSystem linearSystem, Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.a = 0;
        this.c = 32;
        this.d = 32;
        this.e = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.f = new boolean[32];
        this.g = 1;
        this.h = 0;
        this.i = 32;
        this.k = new SolverVariable[n];
        this.l = 0;
        this.e = new ArrayRow[32];
        i();
        Cache cache = new Cache();
        this.j = cache;
        this.b = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.m = new b(this, cache);
        } else {
            this.m = new ArrayRow(cache);
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.variables.put(solverVariable, -1.0f);
        createRow.variables.put(solverVariable2, f2);
        return createRow;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable a3 = this.j.c.a();
        if (a3 == null) {
            a3 = new SolverVariable(type, str);
            a3.setType(type, str);
        } else {
            a3.reset();
            a3.setType(type, str);
        }
        int i2 = this.l;
        int i3 = n;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            n = i4;
            this.k = (SolverVariable[]) Arrays.copyOf(this.k, i4);
        }
        SolverVariable[] solverVariableArr = this.k;
        int i5 = this.l;
        this.l = i5 + 1;
        solverVariableArr[i5] = a3;
        return a3;
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d2 = (double) f2;
        double d3 = (double) i2;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d2) * d3));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d2) * d3));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        ArrayRow createRow = createRow();
        if (solverVariable2 == solverVariable3) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            createRow.variables.put(solverVariable2, -2.0f);
        } else if (f2 == 0.5f) {
            createRow.variables.put(solverVariable, 1.0f);
            createRow.variables.put(solverVariable2, -1.0f);
            createRow.variables.put(solverVariable3, -1.0f);
            createRow.variables.put(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                createRow.b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            createRow.variables.put(solverVariable, -1.0f);
            createRow.variables.put(solverVariable2, 1.0f);
            createRow.b = (float) i2;
        } else if (f2 >= 1.0f) {
            createRow.variables.put(solverVariable4, -1.0f);
            createRow.variables.put(solverVariable3, 1.0f);
            createRow.b = (float) (-i3);
        } else {
            float f3 = 1.0f - f2;
            createRow.variables.put(solverVariable, f3 * 1.0f);
            createRow.variables.put(solverVariable2, f3 * -1.0f);
            createRow.variables.put(solverVariable3, -1.0f * f2);
            createRow.variables.put(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                createRow.b = (((float) i3) * f2) + (((float) (-i2)) * f3);
            }
        }
        if (i4 != 8) {
            createRow.addError(this, i4);
        }
        addConstraint(createRow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x013f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addConstraint(androidx.constraintlayout.solver.ArrayRow r17) {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.LinearSystem.addConstraint(androidx.constraintlayout.solver.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (!USE_BASIC_SYNONYMS || i3 != 8 || !solverVariable2.isFinalValue || solverVariable.b != -1) {
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i2);
            if (i3 != 8) {
                createRow.addError(this, i3);
            }
            addConstraint(createRow);
            return createRow;
        }
        solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i2));
        return null;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 8) {
            createRow.variables.put(createErrorVariable(i3, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 8) {
            createRow.variables.put(createErrorVariable(i3, null), (float) ((int) (createRow.variables.get(createSlackVariable) * -1.0f)));
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        if (solverVariable.b == -1 && i2 == 0) {
            if (solverVariable2.h) {
                solverVariable2 = this.j.d[solverVariable2.i];
            }
            if (solverVariable.h) {
                SolverVariable solverVariable3 = this.j.d[solverVariable.i];
            } else {
                solverVariable.setSynonym(this, solverVariable2, 0.0f);
            }
        } else {
            addEquality(solverVariable, solverVariable2, i2, 8);
        }
    }

    public final void b(ArrayRow arrayRow) {
        int i2;
        if (!SIMPLIFY_SYNONYMS || !arrayRow.d) {
            ArrayRow[] arrayRowArr = this.e;
            int i3 = this.h;
            arrayRowArr[i3] = arrayRow;
            SolverVariable solverVariable = arrayRow.a;
            solverVariable.b = i3;
            this.h = i3 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        } else {
            arrayRow.a.setFinalValue(this, arrayRow.b);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i4 = 0;
            while (i4 < this.h) {
                if (this.e[i4] == null) {
                    System.out.println("WTF");
                }
                ArrayRow[] arrayRowArr2 = this.e;
                if (arrayRowArr2[i4] != null && arrayRowArr2[i4].d) {
                    ArrayRow arrayRow2 = arrayRowArr2[i4];
                    arrayRow2.a.setFinalValue(this, arrayRow2.b);
                    if (OPTIMIZED_ENGINE) {
                        this.j.a.b(arrayRow2);
                    } else {
                        this.j.b.b(arrayRow2);
                    }
                    this.e[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.h;
                        if (i5 >= i2) {
                            break;
                        }
                        ArrayRow[] arrayRowArr3 = this.e;
                        int i7 = i5 - 1;
                        arrayRowArr3[i7] = arrayRowArr3[i5];
                        if (arrayRowArr3[i7].a.b == i5) {
                            arrayRowArr3[i7].a.b = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.e[i6] = null;
                    }
                    this.h = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    public final void c() {
        for (int i2 = 0; i2 < this.h; i2++) {
            ArrayRow arrayRow = this.e[i2];
            arrayRow.a.computedValue = arrayRow.b;
        }
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.g + 1 >= this.d) {
            f();
        }
        SolverVariable a3 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.a + 1;
        this.a = i3;
        this.g++;
        a3.id = i3;
        a3.strength = i2;
        this.j.d[i3] = a3;
        this.b.addError(a3);
        return a3;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.g + 1 >= this.d) {
            f();
        }
        SolverVariable a3 = a(SolverVariable.Type.SLACK, null);
        int i2 = this.a + 1;
        this.a = i2;
        this.g++;
        a3.id = i2;
        this.j.d[i2] = a3;
        return a3;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.g + 1 >= this.d) {
            f();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.j);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i2 = solverVariable.id;
            if (i2 == -1 || i2 > this.a || this.j.d[i2] == null) {
                if (i2 != -1) {
                    solverVariable.reset();
                }
                int i3 = this.a + 1;
                this.a = i3;
                this.g++;
                solverVariable.id = i3;
                solverVariable.e = SolverVariable.Type.UNRESTRICTED;
                this.j.d[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = this.j.a.a();
            if (arrayRow == null) {
                arrayRow = new b(this, this.j);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = this.j.b.a();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.j);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.k++;
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.g + 1 >= this.d) {
            f();
        }
        SolverVariable a3 = a(SolverVariable.Type.SLACK, null);
        int i2 = this.a + 1;
        this.a = i2;
        this.g++;
        a3.id = i2;
        this.j.d[i2] = a3;
        return a3;
    }

    public final void d() {
        StringBuilder L = a2.b.a.a.a.L("Display Rows (");
        L.append(this.h);
        L.append("x");
        System.out.println(a2.b.a.a.a.j(L, this.g, ")\n"));
    }

    public void displayReadableRows() {
        d();
        StringBuilder sb = new StringBuilder();
        sb.append(" num vars ");
        String j2 = a2.b.a.a.a.j(sb, this.a, "\n");
        for (int i2 = 0; i2 < this.a + 1; i2++) {
            SolverVariable solverVariable = this.j.d[i2];
            if (solverVariable != null && solverVariable.isFinalValue) {
                j2 = j2 + " $[" + i2 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String c3 = a2.b.a.a.a.c3(j2, "\n");
        for (int i3 = 0; i3 < this.a + 1; i3++) {
            SolverVariable[] solverVariableArr = this.j.d;
            SolverVariable solverVariable2 = solverVariableArr[i3];
            if (solverVariable2 != null && solverVariable2.h) {
                c3 = c3 + " ~[" + i3 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.i] + " + " + solverVariable2.j + "\n";
            }
        }
        String c32 = a2.b.a.a.a.c3(c3, "\n\n #  ");
        for (int i4 = 0; i4 < this.h; i4++) {
            StringBuilder L = a2.b.a.a.a.L(c32);
            L.append(this.e[i4].d());
            c32 = a2.b.a.a.a.c3(L.toString(), "\n #  ");
        }
        if (this.b != null) {
            StringBuilder Q = a2.b.a.a.a.Q(c32, "Goal: ");
            Q.append(this.b);
            Q.append("\n");
            c32 = Q.toString();
        }
        System.out.println(c32);
    }

    public void displayVariablesReadableRows() {
        d();
        String str = "";
        for (int i2 = 0; i2 < this.h; i2++) {
            if (this.e[i2].a.e == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder L = a2.b.a.a.a.L(str);
                L.append(this.e[i2].d());
                str = a2.b.a.a.a.c3(L.toString(), "\n");
            }
        }
        StringBuilder L2 = a2.b.a.a.a.L(str);
        L2.append(this.b);
        L2.append("\n");
        System.out.println(L2.toString());
    }

    public final int e() throws Exception {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.h) {
                z = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.e;
            if (arrayRowArr[i2].a.e != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i2].b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i3++;
            float f2 = Float.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < this.h; i7++) {
                ArrayRow arrayRow = this.e[i7];
                if (arrayRow.a.e != SolverVariable.Type.UNRESTRICTED && !arrayRow.d && arrayRow.b < 0.0f) {
                    int i8 = 9;
                    if (SKIP_COLUMNS) {
                        int currentSize = arrayRow.variables.getCurrentSize();
                        int i9 = 0;
                        while (i9 < currentSize) {
                            SolverVariable variable = arrayRow.variables.getVariable(i9);
                            float f3 = arrayRow.variables.get(variable);
                            if (f3 > 0.0f) {
                                int i10 = 0;
                                while (i10 < i8) {
                                    float f4 = variable.c[i10] / f3;
                                    if ((f4 < f2 && i10 == i6) || i10 > i6) {
                                        i5 = variable.id;
                                        i6 = i10;
                                        i4 = i7;
                                        f2 = f4;
                                    }
                                    i10++;
                                    i8 = 9;
                                }
                            }
                            i9++;
                            i8 = 9;
                        }
                    } else {
                        for (int i11 = 1; i11 < this.g; i11++) {
                            SolverVariable solverVariable = this.j.d[i11];
                            float f5 = arrayRow.variables.get(solverVariable);
                            if (f5 > 0.0f) {
                                for (int i12 = 0; i12 < 9; i12++) {
                                    float f6 = solverVariable.c[i12] / f5;
                                    if ((f6 < f2 && i12 == i6) || i12 > i6) {
                                        i5 = i11;
                                        i6 = i12;
                                        i4 = i7;
                                        f2 = f6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i4 != -1) {
                ArrayRow arrayRow2 = this.e[i4];
                arrayRow2.a.b = -1;
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow2.c(this.j.d[i5]);
                SolverVariable solverVariable2 = arrayRow2.a;
                solverVariable2.b = i4;
                solverVariable2.updateReferencesWithNewDefinition(this, arrayRow2);
            } else {
                z2 = true;
            }
            if (i3 > this.g / 2) {
                z2 = true;
            }
        }
        return i3;
    }

    public final void f() {
        int i2 = this.c * 2;
        this.c = i2;
        this.e = (ArrayRow[]) Arrays.copyOf(this.e, i2);
        Cache cache = this.j;
        cache.d = (SolverVariable[]) Arrays.copyOf(cache.d, this.c);
        int i3 = this.c;
        this.f = new boolean[i3];
        this.d = i3;
        this.i = i3;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, (long) i3);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public void g(a aVar) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long) this.g);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, (long) this.h);
        }
        e();
        h(aVar);
        c();
    }

    public Cache getCache() {
        return this.j;
    }

    public int getMemoryUsed() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.h; i3++) {
            ArrayRow[] arrayRowArr = this.e;
            if (arrayRowArr[i3] != null) {
                ArrayRow arrayRow = arrayRowArr[i3];
                i2 += arrayRow.variables.sizeInBytes() + (arrayRow.a != null ? 4 : 0) + 4 + 4;
            }
        }
        return i2;
    }

    public int getNumEquations() {
        return this.h;
    }

    public int getNumVariables() {
        return this.a;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public final int h(a aVar) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            this.f[i2] = false;
        }
        boolean z = false;
        int i3 = 0;
        while (!z) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i3++;
            if (i3 >= this.g * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f[aVar.getKey().id] = true;
            }
            SolverVariable pivotCandidate = aVar.getPivotCandidate(this, this.f);
            if (pivotCandidate != null) {
                boolean[] zArr = this.f;
                int i4 = pivotCandidate.id;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (pivotCandidate != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.h; i6++) {
                    ArrayRow arrayRow = this.e[i6];
                    if (arrayRow.a.e != SolverVariable.Type.UNRESTRICTED && !arrayRow.d && arrayRow.variables.contains(pivotCandidate)) {
                        float f3 = arrayRow.variables.get(pivotCandidate);
                        if (f3 < 0.0f) {
                            float f4 = (-arrayRow.b) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.e[i5];
                    arrayRow2.a.b = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.c(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.a;
                    solverVariable.b = i5;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z = true;
            }
        }
        return i3;
    }

    public final void i() {
        int i2 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i2 < this.h) {
                ArrayRow arrayRow = this.e[i2];
                if (arrayRow != null) {
                    this.j.a.b(arrayRow);
                }
                this.e[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.h) {
            ArrayRow arrayRow2 = this.e[i2];
            if (arrayRow2 != null) {
                this.j.b.b(arrayRow2);
            }
            this.e[i2] = null;
            i2++;
        }
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.b.isEmpty()) {
            c();
        } else if (this.graphOptimizer || this.newgraphOptimizer) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.graphOptimizer++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.h) {
                    z = true;
                    break;
                } else if (!this.e[i2].d) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                g(this.b);
                return;
            }
            Metrics metrics3 = sMetrics;
            if (metrics3 != null) {
                metrics3.fullySolved++;
            }
            c();
        } else {
            g(this.b);
        }
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i2;
        if (arrayRow.d && (solverVariable = arrayRow.a) != null) {
            int i3 = solverVariable.b;
            if (i3 != -1) {
                while (true) {
                    i2 = this.h;
                    if (i3 >= i2 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.e;
                    int i4 = i3 + 1;
                    SolverVariable solverVariable2 = arrayRowArr[i4].a;
                    if (solverVariable2.b == i4) {
                        solverVariable2.b = i3;
                    }
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.h = i2 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.a;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.b);
            }
            if (OPTIMIZED_ENGINE) {
                this.j.a.b(arrayRow);
            } else {
                this.j.b.b(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.j;
            SolverVariable[] solverVariableArr = cache.d;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i2++;
        }
        l6.g.b.a<SolverVariable> aVar = cache.c;
        SolverVariable[] solverVariableArr2 = this.k;
        int i3 = this.l;
        Objects.requireNonNull(aVar);
        if (i3 > solverVariableArr2.length) {
            i3 = solverVariableArr2.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            SolverVariable solverVariable2 = solverVariableArr2[i4];
            int i5 = aVar.b;
            Object[] objArr = aVar.a;
            if (i5 < objArr.length) {
                objArr[i5] = solverVariable2;
                aVar.b = i5 + 1;
            }
        }
        this.l = 0;
        Arrays.fill(this.j.d, (Object) null);
        this.a = 0;
        this.b.clear();
        this.g = 1;
        for (int i6 = 0; i6 < this.h; i6++) {
            ArrayRow[] arrayRowArr = this.e;
            if (arrayRowArr[i6] != null) {
                Objects.requireNonNull(arrayRowArr[i6]);
            }
        }
        i();
        this.h = 0;
        if (OPTIMIZED_ENGINE) {
            this.m = new b(this, this.j);
        } else {
            this.m = new ArrayRow(this.j);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        if (!USE_BASIC_SYNONYMS || solverVariable.b != -1) {
            int i3 = solverVariable.b;
            if (i3 != -1) {
                ArrayRow arrayRow = this.e[i3];
                if (arrayRow.d) {
                    arrayRow.b = (float) i2;
                } else if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.d = true;
                    arrayRow.b = (float) i2;
                } else {
                    ArrayRow createRow = createRow();
                    createRow.createRowEquals(solverVariable, i2);
                    addConstraint(createRow);
                }
            } else {
                ArrayRow createRow2 = createRow();
                createRow2.a = solverVariable;
                float f2 = (float) i2;
                solverVariable.computedValue = f2;
                createRow2.b = f2;
                createRow2.d = true;
                addConstraint(createRow2);
            }
        } else {
            float f3 = (float) i2;
            solverVariable.setFinalValue(this, f3);
            for (int i4 = 0; i4 < this.a + 1; i4++) {
                SolverVariable solverVariable2 = this.j.d[i4];
                if (solverVariable2 != null && solverVariable2.h && solverVariable2.i == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.j + f3);
                }
            }
        }
    }
}
