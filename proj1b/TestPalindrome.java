import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("ava"));
        assertTrue(palindrome.isPalindrome("cddc"));
        assertTrue(palindrome.isPalindrome("hannah"));
        assertTrue(palindrome.isPalindrome("l"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("Acca"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("java"));
    }

    @Test
    public void testIsPalindromeInoffByOne() {
        assertTrue(palindrome.isPalindrome("flake", new OffByOne()));
        assertTrue(palindrome.isPalindrome("flke", new OffByOne()));
        assertTrue(palindrome.isPalindrome("FlakE", new OffByOne()));
        assertTrue(palindrome.isPalindrome("fl&a%ke", new OffByOne()));
        assertFalse(palindrome.isPalindrome("acca", new OffByOne()));
        assertFalse(palindrome.isPalindrome("AccA", new OffByOne()));
    }

    @Test
    public void testIsPalindromeInoffByN() {
        assertTrue(palindrome.isPalindrome("flake", new OffByN(1)));
        assertTrue(palindrome.isPalindrome("flke", new OffByN(1)));
        assertTrue(palindrome.isPalindrome("fl&a%ke", new OffByN(1)));
        assertFalse(palindrome.isPalindrome("aaaa", new OffByN(1)));
        assertTrue(palindrome.isPalindrome("fFaHh", new OffByN(2)));
        assertTrue(palindrome.isPalindrome("fh", new OffByN(2)));
    }
}
