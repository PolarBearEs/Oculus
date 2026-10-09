package net.coderbot.iris.gl.shader;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** Expands multi-digit version components into the shader font's digit glyphs. */
final class EuphoriaVersionGlyphs {
    private static final Pattern MULTI_DIGIT_GLYPH = Pattern.compile("_(\\d{2,})(?![\\w])");

    static String normalize(String value) {
        return MULTI_DIGIT_GLYPH.matcher(value).replaceAll(match ->
            match.group(1).chars().mapToObj(digit -> "_" + (char) digit)
                .collect(Collectors.joining(", ")));
    }
}
