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

public class LGM {
    private Window window =
            new Window(800, 800, "LGM Main");
    ArrayList<LGM_Object> LGMO = new ArrayList<>();
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

        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(-0.12f, 0.34f, 6.54f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
        //Matahari
        LGMO.add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                1.0f,
                0.45f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LGMO.get(0).scaleObject(1.0f, 1.0f, 1.0f);


        // Badan Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.1f,
                0.1f,
                0.4f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.9f);
        LGMO.get(0).getChildObject().get(0).rotateObject(4.75f, 1f, 0f, 0f);

        // Fondasi Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.04f,
                0.04f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        LGMO.get(0).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(1).translateObject(0.0f, 0.7f, 0.0f);

        // Top of Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.15f,
                0.15f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LGMO.get(0).getChildObject().get(2).translateObject(0.00f, 1.4f, 0.05f);


        //Purple Neck
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(116/255f, 71/255f, 158/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.7f,
                0.25f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                4));
        LGMO.get(0).getChildObject().get(3).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(3).translateObject(0.00f, -0.6f, 0.0f);

        //White Eye Middle
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.05f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LGMO.get(0).getChildObject().get(4).translateObject(0.00f, 0.25f, 0.7f);

        //White Eye Left
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.05f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LGMO.get(0).getChildObject().get(5).rotateObject(0.4f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(5).translateObject(-0.495f, 0.19f, 0.7f);

        //White Eye Right
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.05f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LGMO.get(0).getChildObject().get(6).rotateObject(-0.4f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(6).translateObject(0.495f, 0.19f, 0.7f);

        //Black Eye Middle
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LGMO.get(0).getChildObject().get(7).translateObject(0.00f, 0.25f, 0.9f);

        //Black Eye Left
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        //LGMO.get(0).getChildObject().get(8).rotateObject(0.4f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(8).translateObject(-0.495f, 0.19f, 0.7f);

        //Black Eye Right
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        //LGMO.get(0).getChildObject().get(9).rotateObject(-0.4f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(9).translateObject(0.495f, 0.19f, 0.7f);









        /*TTSRY.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                2));*/

    }
    public void input() {

//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            LGMO.get(0).rotateObject(0.01f, 0f, 0f, 1f);
//            for (Object child : LGMO.get(0).getChildObject()) {
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//                child.translateObject(tempCenterPoint.x * -1,
//                        tempCenterPoint.y * -1,
//                        tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.1f), 0f, 0f, 1f);
//                child.translateObject(tempCenterPoint.x * 1,
//                        tempCenterPoint.y * 1,
//                        tempCenterPoint.z * 1);
//            }
       /*
            if (window.isKeyPressed(GLFW_KEY_W)) {
                LGMO.get(0).getChildObject().get(0).rotateObject(0.5f, 1f, 0f, 0f);
            }
        }*/
//        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }



        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.12f);
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
            glClearColor(255/255f, 255/255f, 0/255f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (LGM_Object obj3D : LGMO) {

                obj3D.draw(camera,projection);
            }
            System.out.println("X"+camera.getPosition().get(0));
            System.out.println("Y"+camera.getPosition().get(1));
            System.out.println("Z"+camera.getPosition().get(2));

            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new LGM().run();
    }
}

