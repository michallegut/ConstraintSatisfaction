public class ChartsGenerator {
    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();
        XYChart nQueensAllSolutionsRuntime = null;
        XYChart nQueensAllSolutionsRecursiveCalls = null;
        XYChart nQueensFirstSolutionRuntime = null;
        XYChart nQueensFirstSolutionRecursiveCalls = null;
        XYChart latinSquareAllSolutionsRuntime = null;
        XYChart latinSquareAllSolutionsRecursiveCalls = null;
        XYChart latinSquareFirstSolutionRuntime = null;
        XYChart latinSquareFirstSolutionRecursiveCalls = null;
        XYChart nQueensBacktrackingHeuristicsAllSolutionsRuntime = null;
        XYChart nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls = null;
        XYChart nQueensForwardCheckingHeuristicsAllSolutionsRuntime = null;
        XYChart nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls = null;
        XYChart nQueensBacktrackingHeuristicsFirstSolutionRuntime = null;
        XYChart nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls = null;
        XYChart nQueensForwardCheckingHeuristicsFirstSolutionRuntime = null;
        XYChart nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls = null;
        XYChart latinSquareBacktrackingHeuristicsAllSolutionsRuntime = null;
        XYChart latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls = null;
        XYChart latinSquareForwardCheckingHeuristicsAllSolutionsRuntime = null;
        XYChart latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls = null;
        XYChart latinSquareBacktrackingHeuristicsFirstSolutionRuntime = null;
        XYChart latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls = null;
        XYChart latinSquareForwardCheckingHeuristicsFirstSolutionRuntime = null;
        XYChart latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls = null;
        for (int iteration = 0; iteration < 2; iteration++) {
            nQueensAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Problem N-hetmanów: wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", false);
            nQueensAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Problem N-hetmanów: wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", false);
            nQueensFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Problem N-hetmanów: pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", false);
            nQueensFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Problem N-hetmanów: pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", false);
            latinSquareAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Kwadrat łaciński: wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", false);
            latinSquareAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Kwadrat łaciński: wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", false);
            latinSquareFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Kwadrat łaciński: pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", false);
            latinSquareFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Backtracking", "Forward Checking", "", "Kwadrat łaciński: pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", false);
            nQueensBacktrackingHeuristicsAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: backtracking z heurystykami, wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", true);
            nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: backtracking z heurystykami, wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            nQueensForwardCheckingHeuristicsAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: forward checking z heurystykami, wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", true);
            nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: forward checking z heurystykami, wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            nQueensBacktrackingHeuristicsFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: backtracking z heurystykami, pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", true);
            nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: backtracking z heurystykami, pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            nQueensForwardCheckingHeuristicsFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: forward checking z heurystykami, pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", true);
            nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Problem N-hetmanów: forward checking z heurystykami, pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            latinSquareBacktrackingHeuristicsAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: backtracking z heurystykami, wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", true);
            latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: backtracking z heurystykami, wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            latinSquareForwardCheckingHeuristicsAllSolutionsRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: forward checking z heurystykami, wszystkie rozwiązania, czas wykonania", "Czas wykonania [ns]", true);
            latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: forward checking z heurystykami, wszystkie rozwiązania, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            latinSquareBacktrackingHeuristicsFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: backtracking z heurystykami, pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", true);
            latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: backtracking z heurystykami, pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            latinSquareForwardCheckingHeuristicsFirstSolutionRuntime = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: forward checking z heurystykami, pierwsze rozwiązanie, czas wykonania", "Czas wykonania [ns]", true);
            latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls = new XYChart("Problem spełniania ograniczeń", "Brak", "Wyboru zmiennej", "Wyboru wartości", "Kwadrat łaciński: forward checking z heurystykami, pierwsze rozwiązanie, liczba wywołań rekurencyjnych", "Liczba wywołań rekurencyjnych", true);
            for (int i = 1 /*1*/; i <= 16 /*16*/; i++) {
                NQueensProblem nQueensProblem = new NQueensProblem(i);
                nQueensProblem.backtracking(true, false, "none", false);
                nQueensAllSolutionsRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                nQueensAllSolutionsRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 14) {
                    nQueensBacktrackingHeuristicsAllSolutionsRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
                nQueensProblem.forwardChecking(true, false, "none", false);
                nQueensAllSolutionsRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                nQueensAllSolutionsRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 14) {
                    nQueensForwardCheckingHeuristicsAllSolutionsRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
                nQueensProblem.backtracking(false, false, "none", false);
                nQueensFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                nQueensFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                nQueensBacktrackingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                nQueensProblem.forwardChecking(false, false, "none", false);
                nQueensFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                nQueensFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 14) {
                    nQueensProblem.backtracking(true, false, "variable", false);
                    nQueensBacktrackingHeuristicsAllSolutionsRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.forwardChecking(true, false, "variable", false);
                    nQueensForwardCheckingHeuristicsAllSolutionsRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
                nQueensProblem.backtracking(false, false, "variable", false);
                nQueensBacktrackingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                nQueensProblem.forwardChecking(false, false, "variable", false);
                nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 14) {
                    nQueensProblem.backtracking(true, false, "value", false);
                    nQueensBacktrackingHeuristicsAllSolutionsRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.forwardChecking(true, false, "value", false);
                    nQueensForwardCheckingHeuristicsAllSolutionsRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
                nQueensProblem.backtracking(false, false, "value", false);
                nQueensBacktrackingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
                nQueensProblem.forwardChecking(false, false, "value", false);
                nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
            }
            for (int i = 17 /*17*/; i <= 33 /*33*/; i++) {
                NQueensProblem nQueensProblem = new NQueensProblem(i);
                nQueensProblem.backtracking(false, false, "none", false);
                nQueensFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                nQueensFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 29) {
                    nQueensBacktrackingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
                nQueensProblem.forwardChecking(false, false, "none", false);
                nQueensFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                nQueensFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                if (i <= 29) {
                    nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.backtracking(false, false, "variable", false);
                    nQueensBacktrackingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.forwardChecking(false, false, "variable", false);
                    nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.backtracking(false, false, "value", false);
                    nQueensBacktrackingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                    nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
                    nQueensProblem.forwardChecking(false, false, "value", false);
                    nQueensForwardCheckingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, nQueensProblem.getRuntime());
                    nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, nQueensProblem.getRecursiveCalls());
                }
            }
            for (int i = 1 /*1*/; i <= 5 /*5*/; i++) {
                LatinSquareProblem latinSquareProblem = new LatinSquareProblem(i);
                latinSquareProblem.backtracking(true, false, "none", false);
                latinSquareAllSolutionsRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareAllSolutionsRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareBacktrackingHeuristicsAllSolutionsRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(true, false, "none", false);
                latinSquareAllSolutionsRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareAllSolutionsRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareForwardCheckingHeuristicsAllSolutionsRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.backtracking(false, false, "none", false);
                latinSquareFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(false, false, "none", false);
                latinSquareFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.backtracking(true, false, "variable", false);
                latinSquareBacktrackingHeuristicsAllSolutionsRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(true, false, "variable", false);
                latinSquareForwardCheckingHeuristicsAllSolutionsRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.backtracking(false, false, "variable", false);
                latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(false, false, "variable", false);
                latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.backtracking(true, false, "value", false);
                latinSquareBacktrackingHeuristicsAllSolutionsRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(true, false, "value", false);
                latinSquareForwardCheckingHeuristicsAllSolutionsRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.backtracking(false, false, "value", false);
                latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
                latinSquareProblem.forwardChecking(false, false, "value", false);
                latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
            }
            for (int i = 6 /*6*/; i <= 20 /*20*/; i++) {
                LatinSquareProblem latinSquareProblem = new LatinSquareProblem(i);
                latinSquareProblem.backtracking(false, false, "none", false);
                latinSquareFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                if (i <= 12) {
                    latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                }
                latinSquareProblem.forwardChecking(false, false, "none", false);
                latinSquareFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                latinSquareFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                if (i <= 12) {
                    latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getFirstSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getFirstSeries().add(i, latinSquareProblem.getRecursiveCalls());
                    latinSquareProblem.backtracking(false, false, "variable", false);
                    latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                    latinSquareProblem.forwardChecking(false, false, "variable", false);
                    latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getSecondSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getSecondSeries().add(i, latinSquareProblem.getRecursiveCalls());
                    latinSquareProblem.backtracking(false, false, "value", false);
                    latinSquareBacktrackingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
                    latinSquareProblem.forwardChecking(false, false, "value", false);
                    latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.getThirdSeries().add(i, latinSquareProblem.getRuntime());
                    latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.getThirdSeries().add(i, latinSquareProblem.getRecursiveCalls());
                }
            }
        }
        nQueensAllSolutionsRuntime.generateChart();
        nQueensAllSolutionsRecursiveCalls.generateChart();
        nQueensFirstSolutionRuntime.generateChart();
        nQueensFirstSolutionRecursiveCalls.generateChart();
        latinSquareAllSolutionsRuntime.generateChart();
        latinSquareAllSolutionsRecursiveCalls.generateChart();
        latinSquareFirstSolutionRuntime.generateChart();
        latinSquareFirstSolutionRecursiveCalls.generateChart();
        nQueensBacktrackingHeuristicsAllSolutionsRuntime.generateChart();
        nQueensBacktrackingHeuristicsAllSolutionsRecursiveCalls.generateChart();
        nQueensForwardCheckingHeuristicsAllSolutionsRuntime.generateChart();
        nQueensForwardCheckingHeuristicsAllSolutionsRecursiveCalls.generateChart();
        nQueensBacktrackingHeuristicsFirstSolutionRuntime.generateChart();
        nQueensBacktrackingHeuristicsFirstSolutionRecursiveCalls.generateChart();
        nQueensForwardCheckingHeuristicsFirstSolutionRuntime.generateChart();
        nQueensForwardCheckingHeuristicsFirstSolutionRecursiveCalls.generateChart();
        latinSquareBacktrackingHeuristicsAllSolutionsRuntime.generateChart();
        latinSquareBacktrackingHeuristicsAllSolutionsRecursiveCalls.generateChart();
        latinSquareForwardCheckingHeuristicsAllSolutionsRuntime.generateChart();
        latinSquareForwardCheckingHeuristicsAllSolutionsRecursiveCalls.generateChart();
        latinSquareBacktrackingHeuristicsFirstSolutionRuntime.generateChart();
        latinSquareBacktrackingHeuristicsFirstSolutionRecursiveCalls.generateChart();
        latinSquareForwardCheckingHeuristicsFirstSolutionRuntime.generateChart();
        latinSquareForwardCheckingHeuristicsFirstSolutionRecursiveCalls.generateChart();
        double runtime = System.currentTimeMillis() - startTime;
        System.out.println("Runtime: " + runtime / 1000 / 60 + " minutes");
    }
}
