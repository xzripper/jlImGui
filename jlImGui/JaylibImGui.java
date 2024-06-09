// ImGui binding for Raylib bindings for Java.

package jlImGui;

import static com.raylib.Raylib.GetScreenWidth;

import static com.raylib.Raylib.GetScreenHeight;

import static com.raylib.Raylib.GetCurrentMonitor;

import static com.raylib.Raylib.GetMonitorHeight;

import static com.raylib.Raylib.GetMousePosition;

import static com.raylib.Raylib.IsMouseButtonDown;

import static com.raylib.Raylib.GetMouseWheelMove;

import static com.raylib.Raylib.GetMouseDelta;

import static com.raylib.Raylib.IsKeyDown;

import static com.raylib.Raylib.GetCharPressed;

import static com.raylib.Raylib.GetFrameTime;

import static com.raylib.Raylib.GetFPS;

import static com.raylib.Raylib.GetWindowScaleDPI;

import static com.raylib.Raylib.SetMouseCursor;

import static com.raylib.Raylib.ShowCursor;

import static com.raylib.Raylib.HideCursor;

import static com.raylib.Raylib.LoadTextureFromImage;

import static com.raylib.Raylib.UnloadTexture;

import static com.raylib.Raylib.Image;

import static com.raylib.Raylib.Texture;

import static com.raylib.Raylib.MOUSE_CURSOR_DEFAULT;

import static com.raylib.Raylib.MOUSE_CURSOR_ARROW;

import static com.raylib.Raylib.MOUSE_CURSOR_IBEAM;

import static com.raylib.Raylib.MOUSE_CURSOR_POINTING_HAND;

import static com.raylib.Raylib.MOUSE_CURSOR_RESIZE_EW;
import static com.raylib.Raylib.MOUSE_CURSOR_RESIZE_NS;
import static com.raylib.Raylib.MOUSE_CURSOR_RESIZE_NWSE;
import static com.raylib.Raylib.MOUSE_CURSOR_RESIZE_NESW;
import static com.raylib.Raylib.MOUSE_CURSOR_RESIZE_ALL;

import static com.raylib.Raylib.MOUSE_CURSOR_NOT_ALLOWED;

import static com.raylib.Raylib.KEY_TAB;

import static com.raylib.Raylib.KEY_UP;
import static com.raylib.Raylib.KEY_DOWN;
import static com.raylib.Raylib.KEY_RIGHT;
import static com.raylib.Raylib.KEY_LEFT;

import static com.raylib.Raylib.KEY_HOME;
import static com.raylib.Raylib.KEY_END;

import static com.raylib.Raylib.KEY_PAGE_UP;
import static com.raylib.Raylib.KEY_PAGE_DOWN;

import static com.raylib.Raylib.KEY_INSERT;
import static com.raylib.Raylib.KEY_DELETE;

import static com.raylib.Raylib.KEY_BACKSPACE;

import static com.raylib.Raylib.KEY_SPACE;

import static com.raylib.Raylib.KEY_ENTER;

import static com.raylib.Raylib.KEY_KP_ENTER;

import static com.raylib.Raylib.KEY_ESCAPE;

import static com.raylib.Raylib.KEY_A;
import static com.raylib.Raylib.KEY_C;
import static com.raylib.Raylib.KEY_V;
import static com.raylib.Raylib.KEY_X;
import static com.raylib.Raylib.KEY_Y;
import static com.raylib.Raylib.KEY_Z;

import static com.raylib.Raylib.KEY_LEFT_CONTROL;
import static com.raylib.Raylib.KEY_RIGHT_CONTROL;

import static com.raylib.Raylib.KEY_LEFT_SHIFT;
import static com.raylib.Raylib.KEY_RIGHT_SHIFT;

import static com.raylib.Raylib.KEY_LEFT_ALT;
import static com.raylib.Raylib.KEY_RIGHT_ALT;

import static com.raylib.Raylib.KEY_LEFT_SUPER;
import static com.raylib.Raylib.KEY_RIGHT_SUPER;

import imgui.ImGui;

import imgui.ImGuiIO;

import imgui.flag.ImGuiKey;

import imgui.flag.ImGuiMouseCursor;

import imgui.flag.ImGuiConfigFlags;

import imgui.gl3.ImGuiImplGl3;

import static org.lwjgl.opengl.GL.createCapabilities;

/**
 * ImGui binding for Raylib bindings for Java.
 */
public class JaylibImGui {
    private static ImGuiIO io;

    private static ImGuiImplGl3 gl3Impl;

    private static final int[] keysMap = {
            0, 39, 44, 45, 46, 47, 48, 49, 50, 51,
            52, 53, 54, 55, 56, 57, 59, 61, 65, 66,
            67, 68, 69, 70, 71, 72, 73, 74, 75, 76,
            77, 78, 79, 80, 81, 82, 83, 84, 85, 86,
            87, 88, 89, 90, 91, 92, 93, 96, 32, 256,
            257, 258, 259, 260, 261, 262, 263, 264,
            265, 266, 267, 268, 269, 280, 281, 282,
            283, 284, 290, 291, 292, 293, 294, 295,
            296, 297, 298, 299, 300, 301, 340, 341,
            342, 343, 344, 345, 346, 347, 348, 320,
            321, 322, 323, 324, 325, 326, 327, 328,
            329, 330, 331, 332, 333, 334, 335, 336,
            4, 82, 24, 25
    };

    /**
     * Jaylib ImGui Version.
     */
    public static final String jlImGuiVersion = "1.1.1";

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

        io.setDisplaySize(GetScreenWidth(), GetScreenHeight());

        io.setDisplayFramebufferScale(GetWindowScaleDPI().x(), GetWindowScaleDPI().y());

        if(!useIni) {
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

        io.setKeyMap(ImGuiKey.Tab, KEY_TAB);

        io.setKeyMap(ImGuiKey.UpArrow, KEY_UP);
        io.setKeyMap(ImGuiKey.DownArrow, KEY_DOWN);

        io.setKeyMap(ImGuiKey.RightArrow, KEY_RIGHT);
        io.setKeyMap(ImGuiKey.LeftArrow, KEY_LEFT);

        io.setKeyMap(ImGuiKey.Home, KEY_HOME);
        io.setKeyMap(ImGuiKey.End, KEY_END);

        io.setKeyMap(ImGuiKey.PageUp, KEY_PAGE_UP);
        io.setKeyMap(ImGuiKey.PageDown, KEY_PAGE_DOWN);

        io.setKeyMap(ImGuiKey.Insert, KEY_INSERT);
        io.setKeyMap(ImGuiKey.Delete, KEY_DELETE);

        io.setKeyMap(ImGuiKey.Backspace, KEY_BACKSPACE);

        io.setKeyMap(ImGuiKey.Space, KEY_SPACE);

        io.setKeyMap(ImGuiKey.Enter, KEY_ENTER);

        io.setKeyMap(ImGuiKey.KeyPadEnter, KEY_KP_ENTER);

        io.setKeyMap(ImGuiKey.Escape, KEY_ESCAPE);

        io.setKeyMap(ImGuiKey.A, KEY_A);
        io.setKeyMap(ImGuiKey.C, KEY_C);
        io.setKeyMap(ImGuiKey.V, KEY_V);
        io.setKeyMap(ImGuiKey.X, KEY_X);
        io.setKeyMap(ImGuiKey.Y, KEY_Y);
        io.setKeyMap(ImGuiKey.Z, KEY_Z);

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
     * Process ImGui things..
     */
    public static void process() {
        if(GetScreenHeight() > GetMonitorHeight(GetCurrentMonitor())) {
            System.err.println("JlImGui WARNING: GetScreenHeight() > GetMonitorHeight(GetCurrentMonitor()) == true; Restore window height to normal (<MonitorHeight)!");
        }

        io.setDisplaySize(GetScreenWidth(), GetScreenHeight());

        io.setDisplayFramebufferScale(GetWindowScaleDPI().x(), GetWindowScaleDPI().y());

        io.setMousePos(GetMousePosition().x(), GetMousePosition().y());

        io.setMouseDown(0, IsMouseButtonDown(0));
        io.setMouseDown(1, IsMouseButtonDown(1));
        io.setMouseDown(2, IsMouseButtonDown(2));

        io.setMouseWheel(GetMouseWheelMove());

        io.setMouseDelta(GetMouseDelta().x(), GetMouseDelta().y());

        for(int key: keysMap) {
            io.setKeysDown(key, IsKeyDown(key));
        }

        int charPressed = GetCharPressed();

        while(charPressed != 0) {
            io.addInputCharacter(charPressed);

            charPressed = GetCharPressed();
        }

        io.setKeyCtrl(IsKeyDown(KEY_RIGHT_CONTROL) || IsKeyDown(KEY_LEFT_CONTROL));
        io.setKeyShift(IsKeyDown(KEY_RIGHT_SHIFT) || IsKeyDown(KEY_LEFT_SHIFT));
        io.setKeyAlt(IsKeyDown(KEY_RIGHT_ALT) || IsKeyDown(KEY_LEFT_ALT));
        io.setKeySuper(IsKeyDown(KEY_RIGHT_SUPER) || IsKeyDown(KEY_LEFT_SUPER));

        io.setDeltaTime(GetFrameTime());

        io.setFramerate(GetFPS());

        if(io.hasConfigFlags(ImGuiConfigFlags.NoMouse)) {
            HideCursor();
        } else {
            ShowCursor();
        }

        if(!io.hasConfigFlags(ImGuiConfigFlags.NoMouseCursorChange)) {
            switch(ImGui.getMouseCursor()) {
                case ImGuiMouseCursor.None:
                    HideCursor(); break;

                case ImGuiMouseCursor.Arrow:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_ARROW); break;

                case ImGuiMouseCursor.TextInput:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_IBEAM); break;

                case ImGuiMouseCursor.Hand:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_POINTING_HAND); break;

                case ImGuiMouseCursor.ResizeEW:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_RESIZE_EW); break;

                case ImGuiMouseCursor.ResizeNS:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_RESIZE_NS); break;

                case ImGuiMouseCursor.ResizeNWSE:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_RESIZE_NWSE); break;

                case ImGuiMouseCursor.ResizeNESW:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_RESIZE_NESW); break;

                case ImGuiMouseCursor.ResizeAll:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_RESIZE_ALL); break;

                case ImGuiMouseCursor.NotAllowed:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_NOT_ALLOWED); break;

                default:
                    ShowCursor(); SetMouseCursor(MOUSE_CURSOR_DEFAULT); break;
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
    public static void image(Image image, float width, float height) {
        Texture texture = LoadTextureFromImage(image);

        ImGui.image(texture.id(), width, height, 0, 0, 1, 1);

        UnloadTexture(texture);
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
    public static void image(Image image, float width, float height, float[] tint, float[] border) {
        Texture texture = LoadTextureFromImage(image);

        ImGui.image(texture.id(), width, height, 0, 0, 1, 1, tint[0], tint[1], tint[2], tint[3], border[0], border[1], border[2], border[3]);

        UnloadTexture(texture);
    }

    /**
     * Draw ImGui image (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     */
    public static void image(Texture texture, float width, float height) {
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
    public static void image(Texture texture, float width, float height, float[] tint, float[] border) {
        ImGui.image(texture.id(), width, height, 0, 0, 1, 1, tint[0], tint[1], tint[2], tint[3], border[0], border[1], border[2], border[3]);
    }

    /**
     * Draw ImGui image button.
     *
     * @param image Image.
     * @param width Width.
     * @param height Height.
     */
    public static boolean imageButton(Image image, float width, float height) {
        Texture texture = LoadTextureFromImage(image);

        boolean clicked = ImGui.imageButton(texture.id(), width, height, 0, 0, 1, 1);

        UnloadTexture(texture);

        return clicked;
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
    public static boolean imageButton(Image image, float width, float height, int borderSize, float[] tint, float[] background) {
        Texture texture = LoadTextureFromImage(image);

        boolean clicked = ImGui.imageButton(texture.id(), width, height, 0, 0, 1, 1, borderSize, background[0], background[1], background[2], background[3], tint[0], tint[1], tint[2], tint[3]);

        UnloadTexture(texture);

        return clicked;
    }

    /**
     * Draw ImGui image button (texture).
     *
     * @param texture Texture.
     * @param width Width.
     * @param height Height.
     */
    public static boolean imageButton(Texture texture, float width, float height) {
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
    public static boolean imageButton(Texture texture, float width, float height, int borderSize, float[] tint, float[] background) {
        return ImGui.imageButton(texture.id(), width, height, 0, 0, 1, 1, borderSize, background[0], background[1], background[2], background[3], tint[0], tint[1], tint[2], tint[3]);
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
}
