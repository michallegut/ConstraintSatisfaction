import java.util.ArrayList;
import java.util.List;

class LatinSquareProblem {
    private int problemSize;
    private int problemSizeMinusOne;
    private int halfProblemSizePlusOne;
    private int[][] square;
    private int[][][] domains;
    private List<int[][]> solutions;
    private long startTime;
    private long runtime;
    private long recursiveCalls;

    private LatinSquareProblem() {
        throw new AssertionError();
    }

    LatinSquareProblem(int problemSize) {
        this.problemSize = problemSize;
        problemSizeMinusOne = problemSize - 1;
        halfProblemSizePlusOne = problemSize / 2 + 1;
    }

    void backtracking(boolean findAllSolutions, boolean printSolutions, String heuristic, boolean printResults) {
        reset();
        recursiveCalls++;
        if (findAllSolutions) {
            switch (heuristic) {
                case "none":
                    backtrackingRecursionAllSolutions(0, 0, 1);
                    break;
                case "variable":
                    backtrackingRecursionAllSolutionsVariableHeuristic(0, 0, 1, true, 0);
                    break;
                case "value":
                    backtrackingRecursionAllSolutionsValueHeuristic(0, 0, 1, true, 0);
                    break;
                default:
                    return;
            }
        } else {
            switch (heuristic) {
                case "none":
                    backtrackingRecursionFirstSolution(0, 0, 1);
                    break;
                case "variable":
                    backtrackingRecursionFirstSolutionVariableHeuristic(0, 0, 1, true, 0);
                    break;
                case "value":
                    backtrackingRecursionFirstSolutionValueHeuristic(0, 0, 1, true, 0);
                    break;
                default:
                    return;
            }
        }
        runtime = (System.nanoTime() - startTime);
        if (printResults) {
            printResults(problemSize + "x" + problemSize + " LatinSquareProblem - backtracking, heuristic: " + heuristic + (findAllSolutions ? ", all solutions" : ", first solution"), printSolutions);
        }
    }

    private void reset() {
        square = new int[problemSize][problemSize];
        domains = new int[problemSize][problemSize][problemSize + 1];
        solutions = new ArrayList<>();
        startTime = System.nanoTime();
        runtime = 0;
        recursiveCalls = 0;
    }

    private void backtrackingRecursionAllSolutions(int column, int row, int value) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutions(column + 1, row, 1);
            } else if (row < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutions(0, row + 1, 1);
            } else {
                addSolution();
            }
            square[column][row] = 0;
        }
        if (value < problemSize) {
            recursiveCalls++;
            backtrackingRecursionAllSolutions(column, row, value + 1);
        }
    }

    private void backtrackingRecursionAllSolutionsVariableHeuristic(int column, int row, int value, boolean proceedHorizontally, int shift) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (proceedHorizontally) {
                if (column < problemSizeMinusOne) {
                    recursiveCalls++;
                    backtrackingRecursionAllSolutionsVariableHeuristic(column + 1, row, 1, true, shift);
                } else {
                    if (row < problemSizeMinusOne) {
                        recursiveCalls++;
                        backtrackingRecursionAllSolutionsVariableHeuristic(shift, row + 1, 1, false, shift);
                    } else {
                        solutions.add(square);
                    }
                }
            } else {
                recursiveCalls++;
                if (row < problemSizeMinusOne) {
                    backtrackingRecursionAllSolutionsVariableHeuristic(column, row + 1, 1, false, shift);
                } else {
                    shift++;
                    backtrackingRecursionAllSolutionsVariableHeuristic(shift, shift, 1, true, shift);
                }
            }
        }
        if (value < problemSize) {
            recursiveCalls++;
            backtrackingRecursionAllSolutionsVariableHeuristic(column, row, value + 1, proceedHorizontally, shift);
        }
    }

    private void backtrackingRecursionAllSolutionsValueHeuristic(int column, int row, int value, boolean firstHalf, int shift) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutionsValueHeuristic(column + 1, row, 1, true, 0);
            } else if (row < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutionsValueHeuristic(0, row + 1, 1, true, 0);
            } else {
                addSolution();
            }
            square[column][row] = 0;
        }
        if (value != halfProblemSizePlusOne) {
            recursiveCalls++;
            if (firstHalf) {
                backtrackingRecursionAllSolutionsValueHeuristic(column, row, problemSize - shift, false, shift + 1);
            } else {
                backtrackingRecursionAllSolutionsValueHeuristic(column, row, 1 + shift, true, shift);
            }
        }
    }

    private void backtrackingRecursionFirstSolution(int column, int row, int value) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolution(column + 1, row, 1);
            } else if (row < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolution(0, row + 1, 1);
            } else {
                addSolution();
            }
            square[column][row] = 0;
        }
        if (value < problemSize && solutions.isEmpty()) {
            recursiveCalls++;
            backtrackingRecursionFirstSolution(column, row, value + 1);
        }
    }

    private void backtrackingRecursionFirstSolutionVariableHeuristic(int column, int row, int value, boolean proceedHorizontally, int shift) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (proceedHorizontally) {
                if (column < problemSizeMinusOne) {
                    recursiveCalls++;
                    backtrackingRecursionFirstSolutionVariableHeuristic(column + 1, row, 1, true, shift);
                } else {
                    if (row < problemSizeMinusOne) {
                        recursiveCalls++;
                        backtrackingRecursionFirstSolutionVariableHeuristic(shift, row + 1, 1, false, shift);
                    } else {
                        solutions.add(square);
                    }
                }
            } else {
                recursiveCalls++;
                if (row < problemSizeMinusOne) {
                    backtrackingRecursionFirstSolutionVariableHeuristic(column, row + 1, 1, false, shift);
                } else {
                    shift++;
                    backtrackingRecursionFirstSolutionVariableHeuristic(shift, shift, 1, true, shift);
                }
            }
        }
        if (value < problemSize && solutions.isEmpty()) {
            recursiveCalls++;
            backtrackingRecursionFirstSolutionVariableHeuristic(column, row, value + 1, proceedHorizontally, shift);
        }
    }

    private void backtrackingRecursionFirstSolutionValueHeuristic(int column, int row, int value, boolean firstHalf, int shift) {
        if (isConsistentBackwards(column, row, value)) {
            square[column][row] = value;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolutionValueHeuristic(column + 1, row, 1, true, 0);
            } else if (row < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolutionValueHeuristic(0, row + 1, 1, true, 0);
            } else {
                addSolution();
            }
            square[column][row] = 0;
        }
        if (value != halfProblemSizePlusOne && solutions.isEmpty()) {
            recursiveCalls++;
            if (firstHalf) {
                backtrackingRecursionFirstSolutionValueHeuristic(column, row, problemSize - shift, false, shift + 1);
            } else {
                backtrackingRecursionFirstSolutionValueHeuristic(column, row, 1 + shift, true, shift);
            }
        }
    }

    private boolean isConsistentBackwards(int column, int row, int value) {
        for (int i = 0; i < column; i++) {
            if (square[i][row] == value) {
                return false;
            }
        }
        for (int i = 0; i < row; i++) {
            if (square[column][i] == value) {
                return false;
            }
        }
        return true;
    }

    private void addSolution() {
        int[][] solution = new int[problemSize][problemSize];
        for (int i = 0; i < problemSize; i++) {
            for (int j = 0; j < problemSize; j++) {
                solution[i][j] = square[i][j];
            }
        }
        solutions.add(solution);
    }

    private void printResults(String algorithm, boolean printSolutions) {
        System.out.println("____________________________________________________________________________________________________\n");
        System.out.println("Algorithm: " + algorithm);
        System.out.println("Run time: " + runtime + " ns, Recursive calls: " + recursiveCalls + ", Number of solutions: " + solutions.size());
        System.out.println("____________________________________________________________________________________________________\n");
        if (printSolutions) {
            int i = 1;
            for (int[][] solution : solutions) {
                System.out.println("Solution " + i + ":");
                for (int j = 0; j < problemSize; j++) {
                    for (int k = 0; k < problemSize; k++) {
                        if (problemSize >= 10 && solution[j][k] < 10) {
                            System.out.print("0");
                        }
                        System.out.print(solution[j][k] + " ");
                    }
                    System.out.println();
                }
                i++;
                if (i <= solutions.size()) {
                    System.out.println();
                }
            }
            System.out.println("____________________________________________________________________________________________________\n");
        }
    }

    void forwardChecking(boolean findAllSolutions, boolean printSolutions, String heuristic, boolean printResults) {
        reset();
        recursiveCalls++;
        if (findAllSolutions) {
            switch (heuristic) {
                case "none":
                    forwardCheckingRecursionAllSolutions(0, 0, 1);
                    break;
                case "variable":
                    forwardCheckingRecursionAllSolutionsVariableHeuristic(0, 0, 1, true, 0);
                    break;
                case "value":
                    forwardCheckingRecursionAllSolutionsValueHeuristic(0, 0, 1, true, 0);
                    break;
                default:
                    return;
            }
        } else {
            switch (heuristic) {
                case "none":
                    forwardCheckingRecursionFirstSolution(0, 0, 1);
                    break;
                case "variable":
                    forwardCheckingRecursionFirstSolutionVariableHeuristic(0, 0, 1, true, 0);
                    break;
                case "value":
                    forwardCheckingRecursionFirstSolutionValueHeuristic(0, 0, 1, true, 0);
                    break;
                default:
                    return;
            }
        }
        runtime = (System.nanoTime() - startTime);
        if (printResults) {
            printResults(problemSize + "x" + problemSize + " LatinSquareProblem - forward checking, heuristic: " + heuristic + (findAllSolutions ? ", all solutions" : ", first solution"), printSolutions);
        }
    }

    private void forwardCheckingRecursionAllSolutions(int column, int row, int value) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            int firstConsistentValue = findNextConsistentValue(nextColumn, row, 0);
            if (firstConsistentValue != 0) {
                recursiveCalls++;
                forwardCheckingRecursionAllSolutions(nextColumn, row, firstConsistentValue);
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                int firstConsistentValue = findNextConsistentValue(0, nextRow, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutions(0, nextRow, firstConsistentValue);
                }
            } else {
                addSolution();
            }
        }
        extendDomainsForwards(column, row, value);
        int nextConsistentValue = findNextConsistentValue(column, row, value);
        if (nextConsistentValue != 0) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutions(column, row, nextConsistentValue);
        }
    }

    private void forwardCheckingRecursionAllSolutionsVariableHeuristic(int column, int row, int value, boolean proceedHorizontally, int shift) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (proceedHorizontally) {
            if (column < problemSizeMinusOne) {
                int nextColumn = column + 1;
                int firstConsistentValue = findNextConsistentValue(nextColumn, row, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsVariableHeuristic(nextColumn, row, firstConsistentValue, true, shift);
                }
            } else {
                if (row < problemSizeMinusOne) {
                    int nextRow = row + 1;
                    int firstConsistentValue = findNextConsistentValue(shift, nextRow, 0);
                    if (firstConsistentValue != 0) {
                        recursiveCalls++;
                        forwardCheckingRecursionAllSolutionsVariableHeuristic(shift, nextRow, firstConsistentValue, false, shift);
                    }
                } else {
                    solutions.add(square);
                }
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                int firstConsistentValue = findNextConsistentValue(column, nextRow, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsVariableHeuristic(column, nextRow, firstConsistentValue, false, shift);
                }
            } else {
                shift++;
                int firstConsistentValue = findNextConsistentValue(shift, shift, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsVariableHeuristic(shift, shift, firstConsistentValue, true, shift);
                }
            }
        }
        extendDomainsForwards(column, row, value);
        int nextConsistentValue = findNextConsistentValue(column, row, value);
        if (nextConsistentValue != 0) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutionsVariableHeuristic(column, row, nextConsistentValue, proceedHorizontally, shift);
        }
    }

    private void forwardCheckingRecursionAllSolutionsValueHeuristic(int column, int row, int value, boolean firstHalf, int shift) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            if (domains[nextColumn][row][1] == 0) {
                recursiveCalls++;
                forwardCheckingRecursionAllSolutionsValueHeuristic(nextColumn, row, 1, true, 0);
            } else {
                Object[] firstCall = findNextConsistentValueHeuristic(nextColumn, row, 1, true, 0);
                int firstValue = (int) firstCall[0];
                if (firstValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsValueHeuristic(nextColumn, row, firstValue, (boolean) firstCall[1], (int) firstCall[2]);
                }
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                if (domains[0][nextRow][1] == 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsValueHeuristic(0, nextRow, 1, true, 0);
                } else {
                    Object[] firstCall = findNextConsistentValueHeuristic(0, nextRow, 1, true, 0);
                    int firstValue = (int) firstCall[0];
                    if (firstValue != 0) {
                        recursiveCalls++;
                        forwardCheckingRecursionAllSolutionsValueHeuristic(0, nextRow, firstValue, (boolean) firstCall[1], (int) firstCall[2]);
                    }
                }
            } else {
                addSolution();
            }
        }
        extendDomainsForwards(column, row, value);
        Object[] nextCall = findNextConsistentValueHeuristic(column, row, value, firstHalf, shift);
        int nextValue = (int) nextCall[0];
        if (nextValue != 0) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutionsValueHeuristic(column, row, nextValue, (boolean) nextCall[1], (int) nextCall[2]);
        }
    }

    private void forwardCheckingRecursionFirstSolution(int column, int row, int value) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            int firstConsistentValue = findNextConsistentValue(nextColumn, row, 0);
            if (firstConsistentValue != 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolution(nextColumn, row, firstConsistentValue);
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                int firstConsistentValue = findNextConsistentValue(0, nextRow, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolution(0, nextRow, firstConsistentValue);
                }
            } else {
                addSolution();
            }
        }
        if (solutions.isEmpty()) {
            extendDomainsForwards(column, row, value);
            int nextConsistentValue = findNextConsistentValue(column, row, value);
            if (nextConsistentValue != 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolution(column, row, nextConsistentValue);
            }
        }
    }

    private void forwardCheckingRecursionFirstSolutionVariableHeuristic(int column, int row, int value, boolean proceedHorizontally, int shift) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (proceedHorizontally) {
            if (column < problemSizeMinusOne) {
                int nextColumn = column + 1;
                int firstConsistentValue = findNextConsistentValue(nextColumn, row, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionVariableHeuristic(nextColumn, row, firstConsistentValue, true, shift);
                }
            } else {
                if (row < problemSizeMinusOne) {
                    int nextRow = row + 1;
                    int firstConsistentValue = findNextConsistentValue(shift, nextRow, 0);
                    if (firstConsistentValue != 0) {
                        recursiveCalls++;
                        forwardCheckingRecursionFirstSolutionVariableHeuristic(shift, nextRow, firstConsistentValue, false, shift);
                    }
                } else {
                    solutions.add(square);
                }
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                int firstConsistentValue = findNextConsistentValue(column, nextRow, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionVariableHeuristic(column, nextRow, firstConsistentValue, false, shift);
                }
            } else {
                shift++;
                int firstConsistentValue = findNextConsistentValue(shift, shift, 0);
                if (firstConsistentValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionVariableHeuristic(shift, shift, firstConsistentValue, true, shift);
                }
            }
        }
        if (solutions.isEmpty()) {
            extendDomainsForwards(column, row, value);
            int nextConsistentValue = findNextConsistentValue(column, row, value);
            if (nextConsistentValue != 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionVariableHeuristic(column, row, nextConsistentValue, proceedHorizontally, shift);
            }
        }
    }

    private void forwardCheckingRecursionFirstSolutionValueHeuristic(int column, int row, int value, boolean firstHalf, int shift) {
        square[column][row] = value;
        restrictDomainsForwards(column, row, value);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            if (domains[nextColumn][row][1] == 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionValueHeuristic(nextColumn, row, 1, true, 0);
            } else {
                Object[] firstCall = findNextConsistentValueHeuristic(nextColumn, row, 1, true, 0);
                int firstValue = (int) firstCall[0];
                if (firstValue != 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionValueHeuristic(nextColumn, row, firstValue, (boolean) firstCall[1], (int) firstCall[2]);
                }
            }
        } else {
            if (row < problemSizeMinusOne) {
                int nextRow = row + 1;
                if (domains[0][nextRow][1] == 0) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionValueHeuristic(0, nextRow, 1, true, 0);
                } else {
                    Object[] firstCall = findNextConsistentValueHeuristic(0, nextRow, 1, true, 0);
                    int firstValue = (int) firstCall[0];
                    if (firstValue != 0) {
                        recursiveCalls++;
                        forwardCheckingRecursionFirstSolutionValueHeuristic(0, nextRow, firstValue, (boolean) firstCall[1], (int) firstCall[2]);
                    }
                }
            } else {
                addSolution();
            }
        }
        if (solutions.isEmpty()) {
            extendDomainsForwards(column, row, value);
            Object[] nextCall = findNextConsistentValueHeuristic(column, row, value, firstHalf, shift);
            int nextValue = (int) nextCall[0];
            if (nextValue != 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionValueHeuristic(column, row, nextValue, (boolean) nextCall[1], (int) nextCall[2]);
            }
        }
    }

    private void restrictDomainsForwards(int column, int row, int value) {
        for (int i = column + 1; i < problemSize; i++) {
            domains[i][row][value]++;
        }
        for (int i = row + 1; i < problemSize; i++) {
            domains[column][i][value]++;
        }
    }

    private int findNextConsistentValue(int column, int row, int value) {
        int nextConsistentValue = 0;
        for (int i = value + 1; i <= problemSize && nextConsistentValue == 0; i++) {
            if (domains[column][row][i] == 0) {
                nextConsistentValue = i;
            }
        }
        return nextConsistentValue;
    }

    private Object[] findNextConsistentValueHeuristic(int column, int row, int value, boolean firstHalf, int shift) {
        Object[] result = new Object[3];
        int nextConsistentValue = 0;
        int i = value;
        while (nextConsistentValue == 0 && i != halfProblemSizePlusOne) {
            if (firstHalf) {
                i = problemSize - shift;
                firstHalf = false;
                shift++;
            } else {
                i = 1 + shift;
                firstHalf = true;
            }
            if (domains[column][row][i] == 0) {
                nextConsistentValue = i;
            }
        }
        result[0] = nextConsistentValue;
        result[1] = firstHalf;
        result[2] = shift;
        return result;
    }

    private void extendDomainsForwards(int column, int row, int value) {
        for (int i = column + 1; i < problemSize; i++) {
            domains[i][row][value]--;
        }
        for (int i = row + 1; i < problemSize; i++) {
            domains[column][i][value]--;
        }
    }

    long getRuntime() {
        return runtime;
    }

    long getRecursiveCalls() {
        return recursiveCalls;
    }
}
