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

public class Wheezy {
    private Window window =
            new Window(800, 800, "Wheezy");
    ArrayList<Wheezy_Object> bodyPart = new ArrayList<>();
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
        camera.setPosition(-0.7f, 0.0f, 0.7f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));

        // Objek

        // badan utama
        bodyPart.add(new Wheezy_Object(
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
                new Vector4f(0.27f, 0.25f, 0.21f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.32f,// titik x
                0.48f,// titik y
                0.40f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                1));// option
        bodyPart.get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).translateObject(-0.3f, 0f, 0f); // POSISI

        //bagian perut yg putih
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.22f,// titik y
                0.05f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                2));// option
        bodyPart.get(0).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).translateObject(-0.41f, -0.18f, 0.33f); // POSISI

        //tangan kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.27f, 0.25f, 0.21f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.26f,// titik y
                0.2f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                3));// option
        bodyPart.get(0).getChildObject().get(1).rotateObject(2.2f, 1.3f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(1).rotateObject(1.2f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(1).translateObject(-0.138f, 0.16f, 0.28f); // POSISI

        //tangan Kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.27f, 0.25f, 0.21f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.26f,// titik y
                0.2f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                3));// option

        bodyPart.get(0).getChildObject().get(2).rotateObject(2.2f, 1.3f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(2).rotateObject(4.4f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(2).translateObject(-0.57f, 0.16f, 0.08f); // POSISI


        //kelopak mata kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.95f, 1f, 1f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.05f,// titik x
                0.038f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(3).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(3).translateObject(-0.28f, 0.46f, 0.2f); // POSISI

        //kelopak mata kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.95f, 1f, 1f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.05f,// titik x
                0.038f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(4).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(4).translateObject(-0.42f, 0.465f, 0.12f); // POSISI

        //mata kanan
        bodyPart.get(0).getChildObject().get(3).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.01f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.29f, 0.45f, 0.21f); // POSISI

        //mata kiri
        bodyPart.get(0).getChildObject().get(4).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.01f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.43f, 0.455f, 0.13f);// POSISI

        // paruh atas
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.95f, 0.75f, 0.09f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.01f,// titik x
                0.017f,// titik y
                0.023f,// titik z
                15, // Stack -->
                30, // Sector --> TitikW
                5));// option

        bodyPart.get(0).getChildObject().get(5).rotateObject(3.13f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(5).translateObject(-0.44f, 0.3f, 0.51f); // POSISI

        // paruh bwh
        bodyPart.get(0).getChildObject().get(5).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.95f, 0.75f, 0.09f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.008f,// titik x
                0.007f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                5));// option

        bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject(3.13f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-0.44f, 0.26f, 0.5f); // POSISI

        //buletan dasi
        bodyPart.get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                8));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.44f, -0.009f, 0.4f);// POSISI


        //dasi kanan
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.07f,// titik x
                0.068f,// titik y
                0.07f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                6));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(29.81f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-30.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.4f, -0.009f, 0.40f);// POSISI

        //dasi kiri
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.07f,// titik x
                0.068f,// titik y
                0.07f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                6));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(29.81f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(29.3f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.465f, -0.007f, 0.40f);// POSISI

        //kaki kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.3f,// titik y
                0.11f,// titik z
                150, // Stack -->
                150, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(6).rotateObject(1.57f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(6).rotateObject(90f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(6).translateObject(-0.5f, -0.41f, 0.1f);

        //kaki kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
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
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.3f,// titik y
                0.11f,// titik z
                150, // Stack -->
                150, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(7).rotateObject(1.57f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(7).rotateObject(-60f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(7).translateObject(-0.2f, -0.41f, 0.3f);


    }

    float counterParuh = 0f;
    boolean cekParuh = true;

    float counterJalan = 0f;
    boolean cekJalan = true;

    float counterJalanDepan = 0f;
    boolean cekJalanDepan = true;

    public void input() {
        // gerakkin Paruh
        if (window.isKeyPressed(GLFW_KEY_1)) {
            if (cekParuh == true) {
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * -1,tempCenterPoint.y * -1,tempCenterPoint.z *-1);
                counterParuh ++;
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(-0.1f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * 1,tempCenterPoint.y * 1,tempCenterPoint.z * 1);
            }
            else {
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * -1,tempCenterPoint2.y * -1,tempCenterPoint2.z * -1);
                counterParuh --;
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(0.1f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y* 1,tempCenterPoint2.z* 1);
            }
            if (counterParuh == 40.0f){
                cekParuh = false;
            }
            if(counterParuh == 0.0f){
                cekParuh = true;
            }
        }

        //gerakkin mata
//        if (window.isKeyPressed(GLFW_KEY_2)) {
//            if (cekParuh == true) {
//                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(5).updateCenterPoint();
//
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * -1,tempCenterPoint.y * -1,tempCenterPoint.z *-1);
//                counterParuh ++;
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(-0.06f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * 1,tempCenterPoint.y * 1,tempCenterPoint.z * 1);
//            }
//            else {
//                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(5).updateCenterPoint();
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * -1,tempCenterPoint2.y * -1,tempCenterPoint2.z * -1);
//                counterParuh --;
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(0.06f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
//                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y* 1,tempCenterPoint2.z* 1);
//            }
//            if (counterParuh == 15.0f){
//                cekParuh = false;
//            }
//            if(counterParuh == 0){
//                cekParuh = true;
//            }
//        }

        // jalan samping
        if (window.isKeyPressed(GLFW_KEY_3)) {
            if(cekJalan == true) {
                bodyPart.get(0).translateObject(0.002f,0.0f,0.0f);
                counterJalan++;
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

            } else{
                bodyPart.get(0).translateObject(-0.002f,0.0f,0.0f);
                counterJalan--;
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }

            if (counterJalan == 800.0f){
                cekJalan = false;
            }
            if(counterJalan == 0.0f){
                cekJalan = true;
            }

        }

        // jalan depan
        if (window.isKeyPressed(GLFW_KEY_4)) {
            if(cekJalanDepan == true) {
                counterJalanDepan++;
                //bodyPart.get(0).translateObject(0.002f,0.0f,0.0f);
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(0.1f),-1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(0.1f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

            } else{
                //bodyPart.get(0).translateObject(-0.002f,0.0f,0.0f);
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-0.1f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-0.1f),-1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                counterJalanDepan--;
            }


            if (counterJalanDepan == 10.0f){
                cekJalanDepan = false;
            }
            if(counterJalanDepan == 0.0f){
                cekJalanDepan = true;
            }

        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            bodyPart.get(0).rotateObject(0.01f, 0f, 0f, 1f);
        }

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Wheezy_Object i : bodyPart) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Wheezy_Object i : bodyPart) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.01f);
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
            for (Wheezy_Object obj3D : bodyPart) {
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
        new Wheezy().run();
    }
}


