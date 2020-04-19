package solved;

public class P125 {

    class Solution {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < s.length() && !isAlphanumeric(s.charAt(i))) {
                    i++;
                }
                while (j >= 0 && !isAlphanumeric(s.charAt(j))) {
                    j--;
                }
                if (i == s.length() && j == -1) return true;
                char x = Character.toUpperCase(s.charAt(i));
                char y = Character.toUpperCase(s.charAt(j));
                if (x != y) return false;
                i++;
                j--;
            }
            return true;
        }

        private boolean isAlphanumeric(char ch) {
            if (ch >= '0' && ch <= '9') return true;
            if (ch >= 'a' && ch <= 'z') return true;
            if (ch >= 'A' && ch <= 'Z') return true;
            return false;
        }
    }

//    class Solution {
//        public boolean isPalindrome(String s) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                char temp = s.charAt(i);
//                if (isAlphanumeric(temp)) {
//                    sb.append(Character.toUpperCase(temp));
//                }
//            }
//            String str = sb.toString();
//            for (int i = 0; i < str.length(); i++) {
//                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        private boolean isAlphanumeric(char ch) {
//            if (ch >= '0' && ch <= '9') return true;
//            if (ch >= 'a' && ch <= 'z') return true;
//            if (ch >= 'A' && ch <= 'Z') return true;
//            return false;
//        }
//    }

}