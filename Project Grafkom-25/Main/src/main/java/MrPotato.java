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

public class MrPotato {
    private Window window =
            new Window(800, 800, "MrPotato");
    ArrayList<Sphere> bodyPart = new ArrayList<>();
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
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(-0.5f, 0.0f, 0.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));


        // Objek

        //buat badan Mr Potato
        bodyPart.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.2f,// titik y
                0.2f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                8));// option
        bodyPart.get(0).scaleObject(0.8f, 0.8f, 0.8f);


    }
    public void input() {

        if (window.isKeyPressed(GLFW_KEY_W)) {
            bodyPart.get(0).rotateObject(0.01f, 0f, 0f, 1f);
            for (Object child : bodyPart.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);
                child.rotateObject((float) Math.toRadians(0.1f), 0f, 0f, 1f);
                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Sphere i : bodyPart) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (Sphere i : bodyPart) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (Sphere i : bodyPart) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Sphere i : bodyPart) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Sphere i : bodyPart) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Sphere i : bodyPart) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Sphere i : bodyPart) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.1f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.02f);
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
            glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (Sphere obj3D : bodyPart) {
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
        new MrPotato().run();
    }
}


