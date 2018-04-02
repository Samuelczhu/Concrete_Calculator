import javafx.collections.ObservableList;

public class Algorithm {
    private static int Fcuk;
    private static int N;
    private static double Lamba1, Lambda2;
    private static double Mfcu;
    private static double Fcumin;
    private static double Sfcu;

    public static void setFcuk(int fcuk) {
        Algorithm.Fcuk = fcuk;
    }

    public static void setN(int n) {
        Algorithm.N = n;
    }

    public static void findLambdas() {
        if (Algorithm.N>=10 && Algorithm.N<=14) {
            Algorithm.Lamba1 = 1.15;
            Algorithm.Lambda2 = 0.90;
        } else if (Algorithm.N>=15 && Algorithm.N<=19) {
            Algorithm.Lamba1 = 1.05;
            Algorithm.Lambda2 = 0.85;
        } else if (Algorithm.N>=20) {
            Algorithm.Lamba1 = 0.95;
            Algorithm.Lambda2 = 0.85;
        }
    }

    public static void findMfcu(ObservableList<TestData> list) {
        double sum =0.0;
        for (int i=0;i<list.size();i++) {
            sum += list.get(i).getRepresentData();
        }
        Algorithm.Mfcu = (double)Math.round((sum/list.size()) * 10d) / 10d;
    }

    public static void findFcumin(ObservableList<TestData> list) {
        double min = list.get(0).getRepresentData();
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getRepresentData() < min) {
                min = list.get(i).getRepresentData();
            }
        }
        Algorithm.Fcumin = (double)Math.round((min) * 10d) / 10d;
    }

    public static void findSfcu(ObservableList<TestData> list) {
        // this method should be call after called findMfcu
        double squareSum = 0.0;
        for (int i=0;i<list.size();i++) {
            squareSum += Math.pow(list.get(i).getRepresentData(),2);
        }
        double ans = Math.sqrt((squareSum - Algorithm.N * Math.pow(Algorithm.Mfcu,2)) / (Algorithm.N - 1));
        Algorithm.Sfcu = (double)Math.round((ans) * 100d) / 100d;
    }

    public static int getFcuk() {
        return Fcuk;
    }

    public static int getN() {
        return N;
    }

    public static double getLamba1() {
        return Lamba1;
    }

    public static double getLambda2() {
        return Lambda2;
    }

    public static double getMfcu() {
        return Mfcu;
    }

    public static double getFcumin() {
        return Fcumin;
    }

    public static double getSfcu() {
        return Sfcu;
    }
}
