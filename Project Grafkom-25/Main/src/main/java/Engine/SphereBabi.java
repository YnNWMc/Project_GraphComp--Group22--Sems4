package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class SphereBabi extends Circle3D {
    Float rZ;
    int stackCount;
    int sectorCount;

    public SphereBabi(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float rX, Float rY, Float rZ, int stackCount, int sectorCount, int option) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;

        if (option == 0) {
            createPrismaSegitiga();

        } else if (option == 1) {
            createSphereElipsoid();

        } else if (option == 2) {
            createTabung();

        } else if (option == 3) {
            createSphere();

        } else if (option == 31) {
            createSphereflat();
        } else if (option == 4) {
            createHyperboloid1();

        } else if (option == 5) {
            createHyperboloid2();

        } else if (option == 6) {
            createCone();

        } else if (option == 7) {
            createEllipticParaboloid();

        } else if (option == 8) {
            createHyperboloidParaboloid();
        }

        setupVAOVBO();
    }

    public void createPrismaSegitiga() {
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        // x jika plus di kanan, x jika minus di kiri
        // y di minus di bawah, y jika plus di atas
        // z di minus belakang, z di plus atas

        //titik 1 kiri atas belakang
        temp.x = (float) centerPoint.get(0) - rX / 2;
        temp.y = (float) centerPoint.get(1) + rY / 2;
        temp.z = (float) centerPoint.get(2) - rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 2 kiri bawah belakang
        temp.x = (float) centerPoint.get(0) - rX / 2;
        temp.y = (float) centerPoint.get(1) - rY / 2;
        temp.z = (float) centerPoint.get(2) - rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 3 kanan bawah belakang
        temp.x = (float) centerPoint.get(0) + rX / 2;
        temp.y = (float) centerPoint.get(1) - rY / 2;
        temp.z = (float) centerPoint.get(2) - rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 4 kanan atas belakang
        temp.x = (float) centerPoint.get(0) + rX / 2;
        temp.y = (float) centerPoint.get(1) + rY / 2;
        temp.z = (float) centerPoint.get(2) - rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 5 kiri atas depan
        temp.x = (float) centerPoint.get(0) - rX / 2;
        temp.y = (float) centerPoint.get(1) + rY / 2;
        temp.z = (float) centerPoint.get(2) + rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 6 kiri bawah depan
        temp.x = (float) centerPoint.get(0) - rX / 2;
        temp.y = (float) centerPoint.get(1) - rY / 2;
        temp.z = (float) centerPoint.get(2) + rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 7 kanan bawah depan
        temp.x = (float) centerPoint.get(0) + rX / 2;
        temp.y = (float) centerPoint.get(1) - rY / 2;
        temp.z = (float) centerPoint.get(2) + rZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //titik 8 kanan atas depan
        temp.x = (float) centerPoint.get(0) + rX / 2;
        temp.y = (float) centerPoint.get(1) + rY / 2;
        temp.z = (float) centerPoint.get(2) + rZ / 2;
        tempVertices.add(temp);

        vertices.clear();
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

//        vertices.add(tempVertices.get(3));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(6));
    }

    public void createSphereElipsoid() {
        vertices.clear();
        //Dari Ellipsoid
        vertices.clear();
        float radiusX = rX;
        float radiusY = rY;
        float radiusZ = rZ;
        List<Float> centerPoint = Arrays.asList(0.0f, 0.0f, 0.0f);

        float pi = (float) Math.PI;
        float sectorStep = 2 * (float) Math.PI / sectorCount;
        float stackStep = (float) Math.PI / stackCount;
        float sectorAngle, StackAngle, stackAngle, xy, x, y, z;
        for (int i = 0; i <= stackCount; ++i) {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float) Math.cos(StackAngle);
            y = radiusY * (float) Math.cos(StackAngle);
            z = radiusZ * (float) Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j) {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float) Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float) Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z + 0.2f;
                vertices.add(temp_vector);
            }
        }
    }

    public void createTabung() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double i = 0; i <= 360; i += 0.02f) {
            float x = centerPoint.get(0) + rX * (float) Math.cos(Math.toRadians(i));
            float y = centerPoint.get(1) + rY * (float) Math.sin(Math.toRadians(i));

            temp.add(new Vector3f(x, y, 0.0f));
            temp.add(new Vector3f(x, y, -rZ));
        }
        vertices = temp;
    }



    public void createSphere(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/180){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/180){
                float x = this.rX * (float)(Math.cos(v) * Math.cos(u));
                float y = this.rY * (float)(Math.cos(v) * Math.sin(u));
                float z = this.rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void createSphereflat(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/6; v<= Math.PI/6; v+=Math.PI/180){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/180){
                float x = this.rX * (float)(Math.cos(v) * Math.cos(u));
                float y = this.rY * (float)(Math.cos(v) * Math.sin(u));
                float z = this.rZ * (float)(Math.sin(v)/2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid1() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = rX * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = rY * (float)((1/Math.cos(v)) * Math.sin(u));
                float z = rZ * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }

    public void createHyperboloid2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float z = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;

    }
    public void createCone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

//        for(double v = -Math.PI*2; v<= Math.PI*2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = 0.2f * (float)(v * Math.cos(u));
//                float y = 0.2f * (float)((v * Math.sin(u)));
//                float z = 0.2f * (float)(v);
//                temp.add(new Vector3f(x,z,y));
//            }
//        }
//
        for (double v = 0; v<= Math.PI*2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI /60) {
                float x = (float) (rX * v * Math.cos(u));
                float y = (float) (rY * v * Math.sin(u));
                float z = (float) (rZ * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }
    public void createEllipticConev2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (float u = -180; u <= 180; u += 180 / 36) {
            for (float v = (-90); v <= 90; v += 180 / 36) {
                Vector3f temp_vector = new Vector3f();
                float uRad = (float) Math.toRadians(u);
                float vRad = (float) Math.toRadians(v);
                temp_vector.x = (float) (1 * vRad * Math.cos(uRad));
                temp_vector.z = (float) (1 * vRad * Math.sin(uRad));
                temp_vector.y = (float) (1 * vRad);
                vertices.add(temp_vector);
            }
        }
    }

    public void createEllipticConev3() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=0.01){
                float x = 0.5f * (float)v * (float)(Math.tan(u));
                float y = 0.5f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void createEllipticParaboloid() {

        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 10; v+=0.1){
            for(double u = -Math.PI; u<= Math.PI; u+=0.1){
                float x = rX * (float)v * (float)(Math.cos(u));
                float y = rY * (float)v * (float)((Math.sin(u)));
                float z = rZ * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
    }
    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.01){
            for(double u = -Math.PI; u<= Math.PI; u+=0.666){
                float x = 0.125f * (float)v * (float)(Math.tan(u));
                float y = 0.25f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    /*
    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.01){
            for(double u = -Math.PI; u<= Math.PI; u+=0.666){
                float x = 0.125f * (float)v * (float)(Math.tan(u));
                float y = 0.25f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }*/
//    public void draw(Camera camera, Projection projection){
//        drawSetup(camera,projection);
//        // Draw vertices
//        glLineWidth(1);
//        glPointSize(1);
//        glDrawArrays(GL_POLYGON, 0, vertices.size());
//        for(Object child : getChildObject()){
//            child.draw(camera,projection);
//        }
//    }

    public float getrZ() {
        return rZ;
    }

    public void setrZ(float rZ) {
        this.rZ = rZ;
    }
}

