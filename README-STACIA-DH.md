# Local Stacia 2 Expert shader compatibility port

Based on Asek3/Oculus 1.19.2 (1.6.9a) and the Distant Horizons renderer integration from fangyu-mc/oculus-dh3-compat. The original LGPL licensing applies. The sources and build changes are kept here for review and rebuilding.

Target: Minecraft 1.19.2, Forge 43.x, Embeddium 0.3.18.1, Distant Horizons 3.3.3, Complementary Unbound 5.8.1 with Euphoria Patches 1.9.3.

This adds DH terrain/water programs, framebuffer overrides, depth samplers, projection uniforms, and shader-aware DH render passes to the existing 1.19.2 rendering implementation. Custom uniforms use the original Oculus uniform management. Vanilla Fade and DH shadow passes are skipped while this integration is active.

Runtime verification completed on 2026-10-10: Forge 43.5.1, the original Complementary Unbound 5.8.1 + Euphoria Patches 1.9.3 pack and settings, Euphoria Patcher mod, Embeddium, Create and Oculus Flywheel compatibility. The isolated creative/spectator world displayed terrain, water, shader lighting, and distant terrain with Minecraft's render distance set to 6 chunks. Switching shaders off and back on worked. A second isolated installation with all 394 mod jars also loaded the world and rendered the same shader pack with DH 3.3.3 active. These native-window tests used Mesa llvmpipe under Xvfb; they do not measure the user's GPU performance or exercise every mod/dimension.

The port also splits multi-digit Euphoria update-version font symbols into individual digits, fixing the `_10` compilation error without disabling Euphoria update messages. Standalone regression checks cover single- and multi-digit versions.

This is a custom Oculus port, not an official Oculus 1.19.2 release. Older DH versions are untested and may fail because the integration uses DH 3 APIs. The integration is guarded when DH is absent, but that case has not been runtime-tested. Original installation files and a source archive were preserved in the local installation backup.

Source revisions:
- Oculus 1.19.2: 52684db6d5aad990d91ac7bdcf96d4fb3b2c1001
- DH 3 compatibility fork: 7512883a5ae004d12cd01ee45428638c5a58da13 (integration classes; earlier tag used for wrappers/mixins)
- Oculus 1.20.1-new: b3b278134f719afe32ba8b6b5d3a93f052175afc (DH GLSL transformer adapted to the old AST API)

Build with Java 17:

```sh
bash ./gradlew remapJar
```

The build resolves the exact DH 3.3.3 / Minecraft 1.19.2 compile dependency from Modrinth Maven; no manually downloaded jar outside the repository is required. The runnable output is `build/libs/oculus-mc1.19.2-1.8.0-stacia-dh3.jar`. Install it in place of the original Oculus jar alongside the official DH 3.3.3 jar. Keep only one Oculus jar enabled.

Upstream sources:
- https://github.com/Asek3/Oculus/tree/1.19.2
- https://github.com/fangyu-mc/oculus-dh3-compat
- https://github.com/Asek3/Oculus/tree/1.20.1-new
