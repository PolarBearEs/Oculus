package net.coderbot.iris.pipeline.transform.parameter;
import net.coderbot.iris.pipeline.transform.Patch;
import net.coderbot.iris.gl.blending.AlphaTest;
import net.coderbot.iris.shaderpack.texture.TextureStage;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
public final class DHParameters extends Parameters {
    public DHParameters() { super(Patch.DH, new Object2ObjectOpenHashMap<>()); }
    public TextureStage getTextureStage() { return TextureStage.GBUFFERS_AND_SHADOW; }
    @Override
    public AlphaTest getAlphaTest() { return AlphaTest.ALWAYS; }
}
