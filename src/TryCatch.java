public class TryCatch {
    public static void main(String[] args) {
            int[] nums = new int[10];
            int i = 100;
            try {
                nums[i] = 10;
            } catch (Exception e) {
                System.out.println("Well that didn't go well");
                System.out.println(e);
            }

    }
}
