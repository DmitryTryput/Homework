public class PalindromeString {

    public static void main(String[] args) {
        String word = "dAbcdcbad";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        String test = word.trim().toLowerCase();
        for (int i = 0; i < test.length() / 2; i++) {
            if (test.charAt(i) != test.charAt(test.length() - (i + 1))){
                return false;
            }
        }
        return true;
    }
}
