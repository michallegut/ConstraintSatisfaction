import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueensProblem {
    private int problemSize;
    private int problemSizeMinusOne;
    private int negativeProblemSize;
    private int halfProblemSize;
    private boolean isProblemSizeOdd;
    private int[] chessboard;
    private int[][] fieldsThreats;
    private List<int[]> solutions;
    private long startTime;
    private long runtime;
    private long recursiveCalls;

    private NQueensProblem() {
        throw new AssertionError();
    }

    NQueensProblem(int problemSize) {
        this.problemSize = problemSize;
        problemSizeMinusOne = problemSize - 1;
        halfProblemSize = problemSize / 2;
        negativeProblemSize = -problemSize;
        isProblemSizeOdd = problemSize % 2 == 1;
    }

    void backtracking(boolean findAllSolutions, boolean printSolutions, String heuristic, boolean printResults) {
        reset();
        recursiveCalls++;
        if (findAllSolutions) {
            switch (heuristic) {
                case "none":
                    backtrackingRecursionAllSolutions(0, 0);
                    break;
                case "variable":
                    backtrackingRecursionAllSolutionsVariableHeuristic(0, 0, true);
                    break;
                case "value":
                    backtrackingRecursionAllSolutionsValueHeuristic(0, halfProblemSize, isProblemSizeOdd);
                    break;
                default:
                    return;
            }
        } else {
            switch (heuristic) {
                case "none":
                    backtrackingRecursionFirstSolution(0, 0);
                    break;
                case "variable":
                    backtrackingRecursionFirstSolutionVariableHeuristic(0, 0, true);
                    break;
                case "value":
                    backtrackingRecursionFirstSolutionValueHeuristic(0, halfProblemSize, isProblemSizeOdd);
                    break;
                default:
                    return;
            }
        }
        runtime = (System.nanoTime() - startTime);
        if (printResults) {
            printResults(problemSize + "QueensProblem - backtracking, heuristic: " + heuristic + (findAllSolutions ? ", all solutions" : ", first solution"), printSolutions);
        }
    }

    private void reset() {
        chessboard = new int[problemSize];
        Arrays.fill(chessboard, negativeProblemSize);
        fieldsThreats = new int[problemSize][problemSize];
        solutions = new ArrayList<>();
        startTime = System.nanoTime();
        runtime = 0;
        recursiveCalls = 0;
    }

    private void backtrackingRecursionAllSolutions(int column, int row) {
        if (isConsistentBackwards(column, row)) {
            chessboard[column] = row;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutions(column + 1, 0);
            } else {
                addSolution();
            }
        }
        if (row < problemSizeMinusOne) {
            recursiveCalls++;
            backtrackingRecursionAllSolutions(column, row + 1);
        }
    }

    private void backtrackingRecursionAllSolutionsVariableHeuristic(int column, int row, boolean leftSide) {
        if (isConsistentBackwards(column, row) && isConsistentForwards(column, row)) {
            chessboard[column] = row;
            if (column != halfProblemSize) {
                recursiveCalls++;
                if (leftSide) {
                    backtrackingRecursionAllSolutionsVariableHeuristic(problemSizeMinusOne - column, 0, false);
                } else {
                    backtrackingRecursionAllSolutionsVariableHeuristic(problemSize - column, 0, true);
                }
            } else {
                addSolution();
            }
            chessboard[column] = negativeProblemSize;
        }
        if (row < problemSizeMinusOne) {
            recursiveCalls++;
            backtrackingRecursionAllSolutionsVariableHeuristic(column, row + 1, leftSide);
        }
    }

    private void backtrackingRecursionAllSolutionsValueHeuristic(int column, int row, boolean upperSide) {
        if (isConsistentBackwards(column, row)) {
            chessboard[column] = row;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionAllSolutionsValueHeuristic(column + 1, halfProblemSize, isProblemSizeOdd);
            } else {
                addSolution();
            }
        }
        if (row > 0) {
            recursiveCalls++;
            if (upperSide) {
                backtrackingRecursionAllSolutionsValueHeuristic(column, problemSize - row, false);
            } else {
                backtrackingRecursionAllSolutionsValueHeuristic(column, problemSizeMinusOne - row, true);
            }
        }
    }

    private void backtrackingRecursionFirstSolution(int column, int row) {
        if (isConsistentBackwards(column, row)) {
            chessboard[column] = row;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolution(column + 1, 0);
            } else {
                addSolution();
            }
        }
        if (row < problemSizeMinusOne && solutions.isEmpty()) {
            recursiveCalls++;
            backtrackingRecursionFirstSolution(column, row + 1);
        }
    }

    private void backtrackingRecursionFirstSolutionVariableHeuristic(int column, int row, boolean leftSide) {
        if (isConsistentBackwards(column, row) && isConsistentForwards(column, row)) {
            chessboard[column] = row;
            if (column != halfProblemSize) {
                recursiveCalls++;
                if (leftSide) {
                    backtrackingRecursionFirstSolutionVariableHeuristic(problemSizeMinusOne - column, 0, false);
                } else {
                    backtrackingRecursionFirstSolutionVariableHeuristic(problemSize - column, 0, true);
                }
            } else {
                addSolution();
            }
            chessboard[column] = negativeProblemSize;
        }
        if (row < problemSizeMinusOne && solutions.isEmpty()) {
            recursiveCalls++;
            backtrackingRecursionFirstSolutionVariableHeuristic(column, row + 1, leftSide);
        }
    }

    private void backtrackingRecursionFirstSolutionValueHeuristic(int column, int row, boolean upperSide) {
        if (isConsistentBackwards(column, row)) {
            chessboard[column] = row;
            if (column < problemSizeMinusOne) {
                recursiveCalls++;
                backtrackingRecursionFirstSolutionValueHeuristic(column + 1, halfProblemSize, isProblemSizeOdd);
            } else {
                addSolution();
            }
        }
        if (row > 0 && solutions.isEmpty()) {
            recursiveCalls++;
            if (upperSide) {
                backtrackingRecursionFirstSolutionValueHeuristic(column, problemSize - row, false);
            } else {
                backtrackingRecursionFirstSolutionValueHeuristic(column, problemSizeMinusOne - row, true);
            }
        }
    }

    private boolean isConsistentBackwards(int column, int row) {
        for (int i = 0; i < column; i++) {
            if (chessboard[i] == row || chessboard[i] == row - column + i || chessboard[i] == row + column - i) {
                return false;
            }
        }
        return true;
    }

    private boolean isConsistentForwards(int column, int row) {
        for (int i = column + 1; i < problemSize; i++) {
            if (chessboard[i] == row || chessboard[i] == row - column + i || chessboard[i] == row + column - i) {
                return false;
            }
        }
        return true;
    }

    private void addSolution() {
        int[] solution = new int[problemSize];
        for (int i = 0; i < problemSize; i++) {
            solution[i] = chessboard[i];
        }
        solutions.add(solution);
    }

    private void printResults(String algorithm, boolean printSolutions) {
        System.out.println("____________________________________________________________________________________________________\n");
        System.out.println("Algorithm: " + algorithm);
        System.out.println("Runtime: " + runtime + " ns, Recursive calls: " + recursiveCalls + ", Number of solutions: " + solutions.size());
        System.out.println("____________________________________________________________________________________________________\n");
        if (printSolutions) {
            int i = 1;
            for (int[] solution : solutions) {
                System.out.println("Solution " + i + ":");
                for (int j = 0; j < problemSize; j++) {
                    for (int k = 0; k < problemSize; k++) {
                        System.out.print((solution[j] == k ? "X" : "O") + " ");
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
                    forwardCheckingRecursionAllSolutions(0, 0);
                    break;
                case "variable":
                    forwardCheckingRecursionAllSolutionsVariableHeuristic(0, 0, true);
                    break;
                case "value":
                    forwardCheckingRecursionAllSolutionsValueHeuristic(0, halfProblemSize, isProblemSizeOdd);
                    break;
                default:
                    return;
            }
        } else {
            switch (heuristic) {
                case "none":
                    forwardCheckingRecursionFirstSolution(0, 0);
                    break;
                case "variable":
                    forwardCheckingRecursionFirstSolutionVariableHeuristic(0, 0, true);
                    break;
                case "value":
                    forwardCheckingRecursionFirstSolutionValueHeuristic(0, halfProblemSize, isProblemSizeOdd);
                    break;
                default:
                    return;
            }
        }
        runtime = (System.nanoTime() - startTime);
        if (printResults) {
            printResults(problemSize + "QueensProblem - forward checking, heuristic: " + heuristic + (findAllSolutions ? ", all solutions" : ", first solution"), printSolutions);
        }
    }

    private void forwardCheckingRecursionAllSolutions(int column, int row) {
        chessboard[column] = row;
        addThreatsForwards(column);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            int firstSafeRow = findNextSafeRow(nextColumn, -1);
            if (firstSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionAllSolutions(nextColumn, firstSafeRow);
            }
        } else {
            addSolution();
        }
        removeThreatsForwards(column);
        int nextSafeRow = findNextSafeRow(column, row);
        if (nextSafeRow != -1) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutions(column, nextSafeRow);
        }
    }

    private void forwardCheckingRecursionAllSolutionsVariableHeuristic(int column, int row, boolean leftSide) {
        chessboard[column] = row;
        addThreatsBackawards(column);
        addThreatsForwards(column);
        if (column != halfProblemSize) {
            int nextColumn;
            boolean nextSide;
            if (leftSide) {
                nextColumn = problemSizeMinusOne - column;
                nextSide = false;
            } else {
                nextColumn = problemSize - column;
                nextSide = true;
            }
            int firstSafeRow = findNextSafeRow(nextColumn, -1);
            if (firstSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionAllSolutionsVariableHeuristic(nextColumn, firstSafeRow, nextSide);
            }
        } else {
            addSolution();
        }
        removeThreatsBackwards(column);
        removeThreatsForwards(column);
        int nextSafeRow = findNextSafeRow(column, row);
        if (nextSafeRow != -1) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutionsVariableHeuristic(column, nextSafeRow, leftSide);
        }
    }

    private void forwardCheckingRecursionAllSolutionsValueHeuristic(int column, int row, boolean upperSide) {
        chessboard[column] = row;
        addThreatsForwards(column);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            if (fieldsThreats[nextColumn][halfProblemSize] == 0) {
                recursiveCalls++;
                forwardCheckingRecursionAllSolutionsValueHeuristic(nextColumn, halfProblemSize, isProblemSizeOdd);
            } else {
                Object[] firstCall = findNextSafeRowValueHeuristic(nextColumn, halfProblemSize, isProblemSizeOdd);
                int firstRow = (int) firstCall[0];
                if (firstRow != -1) {
                    recursiveCalls++;
                    forwardCheckingRecursionAllSolutionsValueHeuristic(nextColumn, firstRow, (boolean) firstCall[1]);
                }
            }
        } else {
            addSolution();
        }
        removeThreatsForwards(column);
        Object[] nextCall = findNextSafeRowValueHeuristic(column, row, upperSide);
        int nextRow = (int) nextCall[0];
        if (nextRow != -1) {
            recursiveCalls++;
            forwardCheckingRecursionAllSolutionsValueHeuristic(column, nextRow, (boolean) nextCall[1]);
        }
    }

    private void forwardCheckingRecursionFirstSolution(int column, int row) {
        chessboard[column] = row;
        addThreatsForwards(column);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            int firstSafeRow = findNextSafeRow(nextColumn, -1);
            if (firstSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolution(nextColumn, firstSafeRow);
            }
        } else {
            addSolution();
        }
        if (solutions.isEmpty()) {
            removeThreatsForwards(column);
            int nextSafeRow = findNextSafeRow(column, row);
            if (nextSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolution(column, nextSafeRow);
            }
        }
    }

    private void forwardCheckingRecursionFirstSolutionVariableHeuristic(int column, int row, boolean leftSide) {
        chessboard[column] = row;
        addThreatsBackawards(column);
        addThreatsForwards(column);
        if (column != halfProblemSize) {
            int nextColumn;
            boolean nextSide;
            if (leftSide) {
                nextColumn = problemSizeMinusOne - column;
                nextSide = false;
            } else {
                nextColumn = problemSize - column;
                nextSide = true;
            }
            int firstSafeRow = findNextSafeRow(nextColumn, -1);
            if (firstSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionVariableHeuristic(nextColumn, firstSafeRow, nextSide);
            }
        } else {
            addSolution();
        }
        if (solutions.isEmpty()) {
            removeThreatsBackwards(column);
            removeThreatsForwards(column);
            int nextSafeRow = findNextSafeRow(column, row);
            if (nextSafeRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionVariableHeuristic(column, nextSafeRow, leftSide);
            }
        }
    }

    private void forwardCheckingRecursionFirstSolutionValueHeuristic(int column, int row, boolean upperSide) {
        chessboard[column] = row;
        addThreatsForwards(column);
        if (column < problemSizeMinusOne) {
            int nextColumn = column + 1;
            if (fieldsThreats[nextColumn][halfProblemSize] == 0) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionValueHeuristic(nextColumn, halfProblemSize, isProblemSizeOdd);
            } else {
                Object[] firstCall = findNextSafeRowValueHeuristic(nextColumn, halfProblemSize, isProblemSizeOdd);
                int firstRow = (int) firstCall[0];
                if (firstRow != -1) {
                    recursiveCalls++;
                    forwardCheckingRecursionFirstSolutionValueHeuristic(nextColumn, firstRow, (boolean) firstCall[1]);
                }
            }
        } else {
            addSolution();
        }
        if (solutions.isEmpty()) {
            removeThreatsForwards(column);
            Object[] nextCall = findNextSafeRowValueHeuristic(column, row, upperSide);
            int nextRow = (int) nextCall[0];
            if (nextRow != -1) {
                recursiveCalls++;
                forwardCheckingRecursionFirstSolutionValueHeuristic(column, nextRow, (boolean) nextCall[1]);
            }
        }
    }

    private void addThreatsForwards(int column) {
        for (int i = column + 1; i < problemSize; i++) {
            fieldsThreats[i][chessboard[column]]++;
            int row = chessboard[column] + column - i;
            if (row >= 0) {
                fieldsThreats[i][row]++;
            }
            row = chessboard[column] - column + i;
            if (row < problemSize) {
                fieldsThreats[i][row]++;
            }
        }
    }

    private void addThreatsBackawards(int column) {
        for (int i = 0; i < column; i++) {
            fieldsThreats[i][chessboard[column]]++;
            int row = chessboard[column] + column - i;
            if (row < problemSize) {
                fieldsThreats[i][row]++;
            }
            row = chessboard[column] - column + i;
            if (row >= 0) {
                fieldsThreats[i][row]++;
            }
        }
    }

    private int findNextSafeRow(int column, int row) {
        int nextSafeRow = -1;
        for (int i = row + 1; i < problemSize && nextSafeRow == -1; i++) {
            if (fieldsThreats[column][i] == 0) {
                nextSafeRow = i;
            }
        }
        return nextSafeRow;
    }

    private Object[] findNextSafeRowValueHeuristic(int column, int row, boolean upperSide) {
        Object[] result = new Object[2];
        int nextSafeRow = -1;
        int i = row;
        while (nextSafeRow == -1 && i > 0) {
            if (upperSide) {
                i = problemSize - i;
                upperSide = false;
            } else {
                i = problemSizeMinusOne - i;
                upperSide = true;
            }
            if (fieldsThreats[column][i] == 0) {
                nextSafeRow = i;
            }
        }
        result[0] = nextSafeRow;
        result[1] = upperSide;
        return result;
    }

    private void removeThreatsForwards(int column) {
        for (int i = column + 1; i < problemSize; i++) {
            fieldsThreats[i][chessboard[column]]--;
            int row = chessboard[column] + column - i;
            if (row >= 0) {
                fieldsThreats[i][row]--;
            }
            row = chessboard[column] - column + i;
            if (row < problemSize) {
                fieldsThreats[i][row]--;
            }
        }
    }

    private void removeThreatsBackwards(int column) {
        for (int i = 0; i < column; i++) {
            fieldsThreats[i][chessboard[column]]--;
            int row = chessboard[column] + column - i;
            if (row < problemSize) {
                fieldsThreats[i][row]--;
            }
            row = chessboard[column] - column + i;
            if (row >= 0) {
                fieldsThreats[i][row]--;
            }
        }
    }

    long getRuntime() {
        return runtime;
    }

    long getRecursiveCalls() {
        return recursiveCalls;
    }
}
