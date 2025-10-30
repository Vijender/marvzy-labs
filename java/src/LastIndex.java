public static int lastIndex(String s) {
    int lastIndex = -1;

    char[] chars = s.toCharArray();

    for (int i = chars.length - 1; i >= 0; i--) {
        if (chars[i] == '1') {
            lastIndex = i;
            break;
        }
    }
    return lastIndex;
}


void main() {

    IO.println(lastIndex("0101000101000000"));

}
