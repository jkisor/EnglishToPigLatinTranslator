package piglatin;

public class EnglishToPigLatin
{
    public String translate(String word)
    {
        int vowelIndex = firstVowelIndex(word);
        if (!isFirstLetter(vowelIndex))
            word = rearrange(word, vowelIndex);
        word = appendSuffix(word, vowelIndex);

        return word;
    }

    private boolean isFirstLetter(int vowelIndex)
    {
        return vowelIndex == 0;
    }

    private String appendSuffix(String word, int vowelIndex)
    {
        if (isFirstLetter(vowelIndex))
            word += "way";
        else
            word += "ay";
        return word;
    }

    private String rearrange(String word, int vowelIndex)
    {
        if (word.charAt(vowelIndex) == 'u' && word.charAt(vowelIndex - 1) == 'q')
            ++vowelIndex;

        word = pieceFirstVowelToEnd(word, vowelIndex)
                + pieceBeforeVowel(word, vowelIndex);
        return word;
    }

    private String pieceFirstVowelToEnd(String word, int vowelIndex)
    {
        return word.substring(vowelIndex, word.length());
    }

    private String pieceBeforeVowel(String word, int vowelIndex)
    {
        return word.substring(0, vowelIndex);
    }

    private int firstVowelIndex(String word)
    {
        for (char letter : word.toCharArray())
        {
            if (isVowel(letter))
                return word.indexOf(letter);
        }
        return 0;
    }

    private boolean isVowel(char letter)
    {
        String vowels = "aeiouy";
        for (char vowel : vowels.toCharArray())
        {
            if (letter == vowel)
                return true;
        }
        return false;
    }
}