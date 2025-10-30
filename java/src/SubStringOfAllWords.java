public static List<Integer> findSubstring(String s, String[] words) {

    int nWords = words.length;
    int wordLength = words[0].length();
    char[] arr = s.toCharArray();

    StringBuilder runword = new StringBuilder();
    List<String> saveWords = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    HashSet<String> wordSet = new HashSet<>(Arrays.asList(words).subList(0, nWords));

    IO.println(wordSet);
    //Main loop
    for (int i = 0; i < arr.length; i++) {

        //build the runword string
        runword.append(arr[i]);
        if (runword.length() == wordLength) {

            // iteration to check runword
            if (!saveWords.contains(runword.toString())) {
                if (wordSet.contains(runword.toString())) {
                    saveWords.add(runword.toString());
                    if (saveWords.size() == nWords) {
                        result.add(i - (nWords * wordLength) + 1);
                        i = (i - (saveWords.size() * wordLength) + wordLength);
                        saveWords.clear();
                    }
                } else {
                    saveWords.clear();
                }
            } else {
                //repeated word , reset it
                i = i - (saveWords.size() * wordLength) + wordLength;
                saveWords.clear();
            }
            runword = new StringBuilder();
        }
    }

    return result;
}


void main() {
    IO.print("Enter a string: ");
    IO.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    IO.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    IO.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));


}
