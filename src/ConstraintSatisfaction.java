public class ConstraintSatisfaction {
    private static boolean isInputValid(String[] args) {
        if (args.length != 6) return false;
        if (!args[0].equals("nQueens") && !args[0].equals("latinSquare")) return false;
        try {
            int n = Integer.parseInt(args[1]);
            if (n < 1) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        if (!args[2].equals("backtracking") && !args[2].equals("forwardChecking")) return false;
        if (!args[3].equals("none") && !args[3].equals("variable") && !args[3].equals("value")) return false;
        if (!args[4].equals("yes") && !args[4].equals("no")) return false;
        return args[5].equals("yes") || args[5].equals("no");
    }

    public static void main(String[] args) {
        if (isInputValid(args)) {
            if (args[0].equals("nQueens")) {
                NQueensProblem nQueensProblem = new NQueensProblem(Integer.parseInt(args[1]));
                if (args[2].equals("backtracking")) {
                    nQueensProblem.backtracking(args[4].equals("yes"), args[5].equals("yes"), args[3], true);
                } else {
                    nQueensProblem.forwardChecking(args[4].equals("yes"), args[5].equals("yes"), args[3], true);
                }
            } else {
                LatinSquareProblem latinSquareProblem = new LatinSquareProblem(Integer.parseInt(args[1]));
                if (args[2].equals("backtracking")) {
                    latinSquareProblem.backtracking(args[4].equals("yes"), args[5].equals("yes"), args[3], true);
                } else {
                    latinSquareProblem.forwardChecking(args[4].equals("yes"), args[5].equals("yes"), args[3], true);
                }
            }
        } else {
            System.out.println("____________________________________________________________________________________________________\n");
            System.out.println("java -jar ConstraintSatisfaction.jar [problem (nQueens, latinSquare)] [problemSize (1, 2, ..., N)] [algorithm (backtracking, forwardChecking)] [heuristic (none, variable, value)] [allSolutions (yes, no)] [printSolutions (yes, no)]");
            System.out.println("____________________________________________________________________________________________________\n");
        }
    }
}
