// ImGui integration with Raylib bindings for Java.
package jlImGui;

import com.raylib.Raylib;

import imgui.ImGui;

import imgui.ImGuiIO;

import imgui.flag.ImGuiKey;

import imgui.flag.ImGuiMouseCursor;

import imgui.flag.ImGuiConfigFlags;

import imgui.flag.ImGuiBackendFlags;

import imgui.gl3.ImGuiImplGl3;

import static org.lwjgl.opengl.GL.createCapabilities;

/**
 * ImGui integration with Raylib bindings for Java.
 */
public class JaylibImGui {
    private static ImGuiIO io;

    private static ImGuiImplGl3 gl3Impl;

    private static final int[] keysMap = {
        0, 4, 24, 25, 39, 44, 45, 46, 47, 48, 49,
        50, 51, 52, 53, 54, 55, 56, 57, 59, 61,
        65, 66, 82, 67, 68, 69, 70, 71, 72, 73,
        74, 75, 76, 77, 78, 79, 80, 81, 82, 83,
        84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 96, 32,
        256, 257, 258, 259, 260, 261, 262, 263, 264,
        265, 266, 267, 268, 269, 280, 281, 282,
        283, 284, 290, 291, 292, 293, 294, 295,
        296, 297, 298, 299, 300, 301, 340, 341,
        342, 343, 344, 345, 346, 347, 348, 320,
        321, 322, 323, 324, 325, 326, 327, 328,
        329, 330, 331, 332, 333, 334, 335, 336
    };

    /**
     * Jaylib ImGui Version.
     */
    public static final String jlImGuiVersion = "1.2.1";

    /**
     * Setup ImGui.
     *
     * @param glslV GLSL Version.
     * @param font ImGui window font.
     * @param fontSize ImGui window font size.
     * @param useIni Use INI save file?
     */
    public static void setupImGui(int glslV, String font, int fontSize, boolean useIni) {
        ImGui.createContext();

        io = ImGui.getIO();

        io.setDisplaySize(Raylib.GetScreenWidth(), Raylib.GetScreenHeight());

        io.setDisplayFramebufferScale(Raylib.GetWindowScaleDPI().x(), Raylib.GetWindowScaleDPI().y());

        if(!useIni) {
            io.setWantSaveIniSettings(false);

            io.setIniFilename(null);
        }

        if(font != null && fontSize > 0) {
            ImGui.getIO().getFonts().addFontFromFileTTF(font, fontSize);

            ImGui.getIO().getFonts().build();
        }

        createCapabilities();

        gl3Impl = new ImGuiImplGl3();

        gl3Impl.init(String.format("#version %d", glslV));

        io.setBackendPlatformName("jlImGui");
        io.setBackendRendererName("raylib");

        io.setBackendFlags(io.getBackendFlags()
                | ImGuiBackendFlags.HasMouseCursors
                | ImGuiBackendFlags.HasSetMousePos
                | ImGuiBackendFlags.PlatformHasViewports
                | ImGuiBackendFlags.HasMouseHoveredViewport);

        io.setKeyMap(ImGuiKey.Tab, Raylib.KEY_TAB);

        io.setKeyMap(ImGuiKey.UpArrow, Raylib.KEY_UP);
        io.setKeyMap(ImGuiKey.DownArrow, Raylib.KEY_DOWN);

        io.setKeyMap(ImGuiKey.RightArrow, Raylib.KEY_RIGHT);
        io.setKeyMap(ImGuiKey.LeftArrow, Raylib.KEY_LEFT);

        io.setKeyMap(ImGuiKey.Home, Raylib.KEY_HOME);
        io.setKeyMap(ImGuiKey.End, Raylib.KEY_END);

        io.setKeyMap(ImGuiKey.PageUp, Raylib.KEY_PAGE_UP);
        io.setKeyMap(ImGuiKey.PageDown, Raylib.KEY_PAGE_DOWN);

        io.setKeyMap(ImGuiKey.Insert, Raylib.KEY_INSERT);
        io.setKeyMap(ImGuiKey.Delete, Raylib.KEY_DELETE);

        io.setKeyMap(ImGuiKey.Backspace, Raylib.KEY_BACKSPACE);

        io.setKeyMap(ImGuiKey.Space, Raylib.KEY_SPACE);

        io.setKeyMap(ImGuiKey.Enter, Raylib.KEY_ENTER);

        io.setKeyMap(ImGuiKey.KeyPadEnter, Raylib.KEY_KP_ENTER);

        io.setKeyMap(ImGuiKey.Escape, Raylib.KEY_ESCAPE);

        io.setKeyMap(ImGuiKey.A, Raylib.KEY_A);
        io.setKeyMap(ImGuiKey.C, Raylib.KEY_C);
        io.setKeyMap(ImGuiKey.V, Raylib.KEY_V);
        io.setKeyMap(ImGuiKey.X, Raylib.KEY_X);
        io.setKeyMap(ImGuiKey.Y, Raylib.KEY_Y);
        io.setKeyMap(ImGuiKey.Z, Raylib.KEY_Z);

        io.setConfigFlags(ImGuiConfigFlags.NavEnableKeyboard);
    }

    /**
     * Setup ImGui.
     *
     * @param glslV GLSL Version.
     * @param font ImGui window font.
     * @param fontSize ImGui window font size.
     */
    public static void setupImGui(int glslV, String font, int fontSize) {
        setupImGui(glslV, font, fontSize, false);
    }

    /**
     * Setup ImGui.
     *
     * @param glslV GLSL Version.
     */
    public static void setupImGui(int glslV) {
        setupImGui(glslV, null, 0, false);
    }

    /**
     * Setup ImGui.
     */
    public static void setupImGui() {
        setupImGui(330, null, 0, false);
    }

    /**
     * Process ImGui things..
     */
    public static void process() {
        if(Raylib.GetScreenHeight() > Raylib.GetMonitorHeight(Raylib.GetCurrentMonitor())) {
            System.err.println("JlImGui WARNING: GetScreenHeight() > GetMonitorHeight(GetCurrentMonitor()) == true; Restore window height to normal (<MonitorHeight)!");
        }

        io.setDisplaySize(Raylib.GetScreenWidth(), Raylib.GetScreenHeight());

        io.setDisplayFramebufferScale(Raylib.GetWindowScaleDPI().x(), Raylib.GetWindowScaleDPI().y());

        io.setMousePos(Raylib.GetMousePosition().x(), Raylib.GetMousePosition().y());

        io.setMouseDown(0, Raylib.IsMouseButtonDown(0));
        io.setMouseDown(1, Raylib.IsMouseButtonDown(1));
        io.setMouseDown(2, Raylib.IsMouseButtonDown(2));

        io.setMouseWheel(Raylib.GetMouseWheelMove());

        io.setMouseDelta(Raylib.GetMouseDelta().x(), Raylib.GetMouseDelta().y());

        for(int key: keysMap) {
            io.setKeysDown(key, Raylib.IsKeyDown(key));
        }

        int charPressed = Raylib.GetCharPressed();

        while(charPressed != 0) {
            io.addInputCharacter(charPressed);

            charPressed = Raylib.GetCharPressed();
        }

        io.setKeyCtrl(Raylib.IsKeyDown(Raylib.KEY_RIGHT_CONTROL) || Raylib.IsKeyDown(Raylib.KEY_LEFT_CONTROL));
        io.setKeyShift(Raylib.IsKeyDown(Raylib.KEY_RIGHT_SHIFT) || Raylib.IsKeyDown(Raylib.KEY_LEFT_SHIFT));
        io.setKeyAlt(Raylib.IsKeyDown(Raylib.KEY_RIGHT_ALT) || Raylib.IsKeyDown(Raylib.KEY_LEFT_ALT));
        io.setKeySuper(Raylib.IsKeyDown(Raylib.KEY_RIGHT_SUPER) || Raylib.IsKeyDown(Raylib.KEY_LEFT_SUPER));

        io.setDeltaTime(Raylib.GetFrameTime());

        io.setFramerate(Raylib.GetFPS());

        if(io.hasConfigFlags(ImGuiConfigFlags.NoMouse)) {
            Raylib.HideCursor();
        } else {
            Raylib.ShowCursor();
        }

        if(!io.hasConfigFlags(ImGuiConfigFlags.NoMouseCursorChange) && !io.hasConfigFlags(ImGuiConfigFlags.NoMouse)) {
            switch (ImGui.getMouseCursor()) {
                case ImGuiMouseCursor.None -> Raylib.HideCursor();
                case ImGuiMouseCursor.Arrow -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_ARROW); }
                case ImGuiMouseCursor.TextInput -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_IBEAM); }
                case ImGuiMouseCursor.Hand -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_POINTING_HAND); }
                case ImGuiMouseCursor.ResizeEW -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_RESIZE_EW); }
                case ImGuiMouseCursor.ResizeNS -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_RESIZE_NS); }
                case ImGuiMouseCursor.ResizeNWSE -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_RESIZE_NWSE); }
                case ImGuiMouseCursor.ResizeNESW -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_RESIZE_NESW); }
                case ImGuiMouseCursor.ResizeAll -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_RESIZE_ALL); }
                case ImGuiMouseCursor.NotAllowed -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_NOT_ALLOWED); }
                default -> { Raylib.ShowCursor(); Raylib.SetMouseCursor(Raylib.MOUSE_CURSOR_DEFAULT); }
            }
        }
    }

    /**
     * Render ImGui window.
     */
    public static void render() {
        ImGui.render();

        gl3Impl.renderDrawData(ImGui.getDrawData());
    }

    /**
     * Draw ImGui image.
     *
     * @param image Image.
     * @param width Width.
     * @param height Height.
     */
    public static void image(Raylib.Image image, float width, float height) {
        ImGui.image(Raylib.LoadTextureFromImage(image).id(), width, height, 0, 0, 1, 1);
    }

    /**
     * Draw ImGui image.
     *
     * @param image Image.
     * @param width Width.
     * @param height Height.
     * @param tint Image tint (use <code>JaylibImGui::color</code>).
     * @param border Border (use <code>JaylibImGui::color</code>).
     */
    public static void image(Raylib.Image image, float width, float height, float[] tint, float[] border) {
        ImGui.image(Raylib.LoadTextureFromImage(image).id(), width, height, 0, 0, 1, 1,
                tint[0], tint[1], tint[2], tint[3], border[0], border[1], border[2], border[3]);
    }

    /**
     * Draw ImGui image (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     */
    public static void image(Raylib.Texture texture, float width, float height) {
        ImGui.image(texture.id(), width, height, 0, 0, 1, 1);
    }

    /**
     * Draw ImGui image (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     * @param tint Image tint (use <code>JaylibImGui::color</code>).
     * @param border Border (use <code>JaylibImGui::color</code>).
     */
    public static void image(Raylib.Texture texture, float width, float height, float[] tint, float[] border) {
        ImGui.image(texture.id(), width, height, 0, 0, 1, 1,
                tint[0], tint[1], tint[2], tint[3], border[0], border[1], border[2], border[3]);
    }

    /**
     * Draw ImGui image button.
     *
     * @param image Image.
     * @param width Width.
     * @param height Height.
     */
    public static boolean imageButton(Raylib.Image image, float width, float height) {
        return ImGui.imageButton(Raylib.LoadTextureFromImage(image).id(), width, height, 0, 0, 1, 1);
    }

    /**
     * Draw ImGui image button.
     *
     * @param image Image.
     * @param width Width.
     * @param height Height.
     * @param borderSize Border size.
     * @param tint Image tint (use <code>JaylibImGui::color</code>).
     * @param background Background color (use <code>JaylibImGui::color</code>).
     */
    public static boolean imageButton(Raylib.Image image, float width, float height, int borderSize, float[] tint, float[] background) {
        return ImGui.imageButton(Raylib.LoadTextureFromImage(image).id(), width, height, 0, 0, 1, 1,
                borderSize, background[0], background[1], background[2], background[3], tint[0], tint[1], tint[2], tint[3]);
    }

    /**
     * Draw ImGui image button (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     */
    public static boolean imageButton(Raylib.Texture texture, float width, float height) {
        return ImGui.imageButton(texture.id(), width, height, 0, 0, 1, 1);
    }

    /**
     * Draw ImGui image button (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     * @param borderSize Border size.
     * @param tint Texture tint (use <code>JaylibImGui::color</code>).
     * @param background Background color (use <code>JaylibImGui::color</code>).
     */
    public static boolean imageButton(Raylib.Texture texture, float width, float height, int borderSize, float[] tint, float[] background) {
        return ImGui.imageButton(texture.id(), width, height, 0, 0, 1, 1,
                borderSize, background[0], background[1], background[2], background[3], tint[0], tint[1], tint[2], tint[3]);
    }

    /**
     * Create RGBA (0-255) color array translated into GL color space (0.0-1.0).
     *
     * @param r Red.
     * @param g Green.
     * @param b Blue.
     * @param a Alpha.
     */
    public static float[] color(int r, int g, int b, int a) {
        return new float[] {r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f};
    }

    /**
     * Dispose and destroy context.
     */
    public static void disposeNDestroy(){
        gl3Impl.dispose();

        ImGui.destroyContext();
    }

    /**
     * Get ImGui IO.
     */
    public static ImGuiIO getIO() {
        return io;
    }

    /**
     * Get GL3 implementation.
     */
    public static ImGuiImplGl3 getGl3Impl() {
        return gl3Impl;
    }

    /**
     * Get keys map.
     */
    public static int[] getKeysMap() {
        return keysMap;
    }

    /**
     * Get JlImGui version.
     */
    public static String getVersion() {
        return jlImGuiVersion;
    }
}
