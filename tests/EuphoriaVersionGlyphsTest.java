package net.coderbot.iris.gl.shader;

public final class EuphoriaVersionGlyphsTest {
    public static void main(String[] args) {
        check("_1, _dot, _10, _dot, _0", "_1, _dot, _1, _0, _dot, _0");
        check("_1, _dot, _9, _dot, _3", "_1, _dot, _9, _dot, _3");
        check("_10, _dot, _123", "_1, _0, _dot, _1, _2, _3");
        check("_10_named_symbol", "_10_named_symbol");
        System.out.println("Euphoria version glyph regression checks passed.");
    }

    private static void check(String input, String expected) {
        String actual = EuphoriaVersionGlyphs.normalize(input);
        if (!expected.equals(actual)) throw new AssertionError(input + " => " + actual);
    }
}
