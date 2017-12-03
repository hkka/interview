package hkka.interview.xspeedit;

public class Basic {

    public static void main(String[] args) {
        int[] chaine = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        System.out.printf(emballer(chaine));
    }

    static String emballer(final int[] chaine) {
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int c : chaine) {
                sum = sum + c;
                if (sum == 10) {
                    sb.append(c);
                    sb.append("/");
                    sum = 0;
                } else if (sum > 10) {
                    sb.append("/");
                    sb.append(c);
                    sum = c;
                } else {
                    sb.append(c);
                }
            }
        return sb.toString();
    }
}