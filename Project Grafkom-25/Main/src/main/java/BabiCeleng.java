import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class BabiCeleng {
    private Window window =
            new Window(800, 800, "Latest Main");
    ArrayList<Sphere> TTSRY = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        camera.setPosition(-0.5f, 0.0f, 0.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));
        // code dst jangan ditaruh diatas code diatas

        // Badan Babi
        TTSRY.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.3f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).scaleObject(1.3f, 1.3f, 1.3f);
        TTSRY.get(0).rotateObject((float)Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        //Kepala Babi
        TTSRY.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).scaleObject(1.0f, 1.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(0).translateObject(0.0f, 0.075f, 0.43f);

        // Hidung babi
        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.5f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.1f, 0.73f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        // lubang hidung
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.4f, 0.69f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.075f, 0.1f, 0.03f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.05f, 0.12f, 0.74f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.4f, 0.69f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.075f, 0.1f, 0.03f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.05f, 0.12f, 0.74f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        //Mata
        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.09f, 0.15f, 0.60f);

        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.1f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.09f, 0.15f, 0.60f);

    }
    public void input() {


        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Sphere i : TTSRY) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (Sphere i : TTSRY) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (Sphere i : TTSRY) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Sphere i : TTSRY) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Sphere i : TTSRY) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Sphere i : TTSRY) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Sphere i : TTSRY) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.05f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(0.02f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.moveLeft(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.moveRight(0.02f);
        }
    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(1.00f, 1.0f, 1.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (Sphere obj3D : TTSRY) {

                obj3D.draw(camera,projection);
            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new BabiCeleng().run();
    }
}


