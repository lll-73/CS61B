public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> chardeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            chardeque.addLast(word.charAt(i));
        }
        return chardeque;
    }

    public boolean isPalindrome(String word) {
        ArrayDeque<Character> chardeque = (ArrayDeque<Character>) wordToDeque(word);
        int len = chardeque.size();
        int i = 0;
        int j = len - 1;
        for (; i < len / 2; i++, j--) {
            if (chardeque.get(i) != chardeque.get(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        ArrayDeque<Character> chardeque = (ArrayDeque<Character>) wordToDeque(word);
        int len = chardeque.size();
        int i = 0;
        int j = len - 1;
        for (; i < len / 2; i++, j--){
            if (!cc.equalChars(chardeque.get(i), chardeque.get(j))) {
                return false;
            }
        }
        return true;
    }
}
