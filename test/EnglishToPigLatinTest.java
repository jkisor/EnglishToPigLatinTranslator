import org.junit.Test;
import piglatin.EnglishToPigLatin;

import static org.junit.Assert.assertEquals;

public class EnglishToPigLatinTest
{

    private EnglishToPigLatin englishToPigLatin = new EnglishToPigLatin();

    @Test
    public void appendWAYToWordsStartingWithVowel()
    {
        assertEquals("appleway", englishToPigLatin.translate("apple"));
        assertEquals("eggway", englishToPigLatin.translate("egg"));
        assertEquals("indieway", englishToPigLatin.translate("indie"));
        assertEquals("offway", englishToPigLatin.translate("off"));
        assertEquals("urinalway", englishToPigLatin.translate("urinal"));
        assertEquals("yikesway", englishToPigLatin.translate("yikes"));
    }

    @Test
    public void moveAllLettersUpToFirstVowelToEndAndAppendAY()
    {
        assertEquals("uckday", englishToPigLatin.translate("duck"));
        assertEquals("oveglay", englishToPigLatin.translate("glove"));
        assertEquals("atcay", englishToPigLatin.translate("cat"));
    }

    @Test
    public void keepQUTogether()
    {
        assertEquals("eenquay", englishToPigLatin.translate("queen"));
        assertEquals("ietquay", englishToPigLatin.translate("quiet"));
    }
}
