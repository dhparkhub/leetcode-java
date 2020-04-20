package solved.p1410;

class Solution {
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int tempSize = text.length() - i;
            if (tempSize >= 4) {
                if (text.substring(i, i + 4).equals("&gt;")) {
                    sb.append(">");
                    i += 3;
                    continue;
                } else if (text.substring(i, i + 4).equals("&lt;")) {
                    sb.append("<");
                    i += 3;
                    continue;
                }
            }
            if (tempSize >= 5) {
                if (text.substring(i, i + 5).equals("&amp;")) {
                    sb.append("&");
                    i += 4;
                    continue;
                }
            }
            if (tempSize >= 6) {
                if (text.substring(i, i + 6).equals("&quot;")) {
                    sb.append("\"");
                    i += 5;
                    continue;
                } else if (text.substring(i, i + 6).equals("&apos;")) {
                    sb.append("'");
                    i += 5;
                    continue;
                }
            }
            if (tempSize >= 7) {
                if (text.substring(i, i + 7).equals("&frasl;")) {
                    sb.append("/");
                    i += 6;
                    continue;
                }
            }
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
}